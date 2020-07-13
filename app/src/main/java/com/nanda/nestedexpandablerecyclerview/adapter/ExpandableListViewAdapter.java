package com.nanda.nestedexpandablerecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nanda.nestedexpandablerecyclerview.R;
import com.nanda.nestedexpandablerecyclerview.data.model.CompanyModel;
import com.nanda.nestedexpandablerecyclerview.data.model.DesignationModel;
import com.nanda.nestedexpandablerecyclerview.helper.ExpandableLayout;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<CompanyModel> companyModelList;
    private GroupClickListener groupClickListener;
    private int selectedPosition = -1;

    public ExpandableListViewAdapter(Context context, GroupClickListener groupClickListener) {
        this.context = context;
        companyModelList = new ArrayList<>();
        this.groupClickListener = groupClickListener;
    }

    public void setCompanyModelList(List<CompanyModel> itemList) {
        if (itemList == null) {
            return;
        }
        companyModelList.clear();
        companyModelList.addAll(itemList);
        notifyDataSetChanged();
    }

    public interface GroupClickListener {
        void onGroupClicked(int selectedPosition, int groupPosition);
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_company, parent, false);
        }

        convertView.setTag(groupPosition);
        CompanyModel companyModel = (CompanyModel) getGroup(groupPosition);
        FrameLayout layoutGroupHeader = convertView.findViewById(R.id.layout_group);
        TextView tvName = convertView.findViewById(R.id.tv_name);
        ImageView imgArrow = convertView.findViewById(R.id.img_arrow);
        imgArrow.setTag(groupPosition);

        tvName.setText(companyModel.getCompanyName());
        imgArrow.setImageResource(isExpanded ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down);
        layoutGroupHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateList(groupPosition);
                if (groupClickListener != null) {
                    groupClickListener.onGroupClicked(selectedPosition, groupPosition);
                }
                selectedPosition = groupPosition;
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_desig, parent, false);
        }

        DesignationModel designationModel = (DesignationModel) getChild(groupPosition, childPosition);
        EmployeeAdapter employeeAdapter = new EmployeeAdapter();

        final ExpandableLayout expandableLayout = convertView.findViewById(R.id.expandable_layout);
        FrameLayout layoutHeader = convertView.findViewById(R.id.layout_first_child);
        TextView tvName = convertView.findViewById(R.id.tv_name);
        ImageView imgArrow = convertView.findViewById(R.id.img_arrow);
        RecyclerView recyclerView = convertView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        String tag = groupPosition + "" + childPosition;
        convertView.setTag(tag);
        expandableLayout.setTag(tag);
        layoutHeader.setTag(tag);
        imgArrow.setTag(tag);
        recyclerView.setTag(tag);
        recyclerView.setAdapter(employeeAdapter);
        tvName.setText(designationModel.getDesignation());

        final boolean isExpanded = designationModel.isExpanded();
        if (isExpanded) {
            employeeAdapter.setEmployeeModelList(designationModel.getEmployeeModelList());
        }
        imgArrow.setImageResource(isExpanded ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down);
        expandableLayout.setExpanded(isExpanded, false);

        layoutHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DesignationModel designationModel = (DesignationModel) getChild(groupPosition, childPosition);
                if (designationModel.isExpanded()) {
                    designationModel.setExpanded(false);
                } else {
                    List<DesignationModel> designationModelList = companyModelList.get(groupPosition).getDesignationModelList();
                    for (int i = 0, size = designationModelList.size(); i < size; i++) {
                        DesignationModel model = designationModelList.get(i);
                        if (i == childPosition) {
                            model.setExpanded(true);
                        } else {
                            model.setExpanded(false);
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    private void updateList(int groupPosition) {
        List<DesignationModel> designationModelList = companyModelList.get(groupPosition).getDesignationModelList();
        for (int i = 0, size = designationModelList.size(); i < size; i++) {
            DesignationModel model = designationModelList.get(i);
            model.setExpanded(false);
        }
    }

    @Override
    public int getGroupCount() {
        return companyModelList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return companyModelList.get(groupPosition).getDesignationModelList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return companyModelList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return companyModelList.get(groupPosition).getDesignationModelList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
