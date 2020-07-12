package com.nanda.nestedexpandablerecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nanda.nestedexpandablerecyclerview.R;
import com.nanda.nestedexpandablerecyclerview.data.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<EmployeeModel> employeeModelList;

    public EmployeeAdapter() {
        employeeModelList = new ArrayList<>();
    }

    public void setEmployeeModelList(List<EmployeeModel> itemList) {
        if (itemList == null)
            return;
        employeeModelList.clear();
        employeeModelList.addAll(itemList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        EmployeeModel model = employeeModelList.get(position);
        holder.bindDataToView(model);
    }

    @Override
    public int getItemCount() {
        return employeeModelList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageButton btnToggle;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            btnToggle = itemView.findViewById(R.id.toggle_btn);
        }

        void bindDataToView(EmployeeModel model) {
            tvName.setText(model.getEmpName());
        }
    }

}
