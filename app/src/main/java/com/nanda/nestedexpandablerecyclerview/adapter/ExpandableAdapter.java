package com.nanda.nestedexpandablerecyclerview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanda.nestedexpandablerecyclerview.R;
import com.nanda.nestedexpandablerecyclerview.data.model.CompanyModel;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CompanyModel> companyModelList;

    public ExpandableAdapter() {
        companyModelList = new ArrayList<>();
    }

    public void setCompanyModelList(List<CompanyModel> itemList) {
        if (itemList == null)
            return;
        companyModelList.clear();
        companyModelList.addAll(itemList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return companyModelList.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageButton btnToggle;

        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnToggle = itemView.findViewById(R.id.toggle_btn);
        }
    }

    class DesigViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageButton btnToggle;

        public DesigViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnToggle = itemView.findViewById(R.id.toggle_btn);
        }
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageButton btnToggle;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnToggle = itemView.findViewById(R.id.toggle_btn);
        }
    }

}
