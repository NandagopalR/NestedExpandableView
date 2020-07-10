package com.nanda.nestedexpandablerecyclerview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.nanda.nestedexpandablerecyclerview.R;
import com.nanda.nestedexpandablerecyclerview.adapter.ExpandableListViewAdapter;
import com.nanda.nestedexpandablerecyclerview.data.mapper.CompanyMapper;
import com.nanda.nestedexpandablerecyclerview.data.model.CompanyModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnGroupExpandListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this);
        List<CompanyModel> companyModelList = CompanyMapper.getCompanyModelList();

        expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setAdapter(adapter);
        adapter.setCompanyModelList(companyModelList);
        expandableListView.setOnGroupExpandListener(this);
        expandableListView.setOnGroupClickListener(this);
        expandableListView.setOnChildClickListener(this);
    }

    @Override
    public void onGroupExpand(int groupPosition) {

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return true;
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return expandableListView.isGroupExpanded(groupPosition) ? expandableListView.collapseGroup(groupPosition) : expandableListView.expandGroup(groupPosition);
    }
}