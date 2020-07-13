package com.nanda.nestedexpandablerecyclerview.activity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nanda.nestedexpandablerecyclerview.R;
import com.nanda.nestedexpandablerecyclerview.adapter.ExpandableListViewAdapter;
import com.nanda.nestedexpandablerecyclerview.data.mapper.CompanyMapper;
import com.nanda.nestedexpandablerecyclerview.data.model.CompanyModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ExpandableListViewAdapter.GroupClickListener {

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this, this);
        List<CompanyModel> companyModelList = CompanyMapper.getCompanyModelList();

        expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setAdapter(adapter);
        adapter.setCompanyModelList(companyModelList);
    }

    @Override
    public void onGroupClicked(int selectedPosition, int groupPosition) {
        if (selectedPosition == groupPosition) {
            expandableListView.collapseGroup(selectedPosition);
        } else if (selectedPosition != -1 && expandableListView.isGroupExpanded(selectedPosition)) {
            expandableListView.collapseGroup(selectedPosition);
            expandableListView.expandGroup(groupPosition);
        } else {
            expandableListView.expandGroup(groupPosition);
        }
    }
}