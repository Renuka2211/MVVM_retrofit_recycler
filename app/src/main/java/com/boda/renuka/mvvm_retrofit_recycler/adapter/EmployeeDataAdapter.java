package com.boda.renuka.mvvm_retrofit_recycler.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.boda.renuka.mvvm_retrofit_recycler.R;
import com.boda.renuka.mvvm_retrofit_recycler.databinding.RowLayoutBinding;
import com.boda.renuka.mvvm_retrofit_recycler.model.Employee;

import java.util.ArrayList;

public class EmployeeDataAdapter  extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {
    private ArrayList<Employee> employees;
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RowLayoutBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.row_layout, viewGroup, false);
        return new EmployeeViewHolder(employeeListItemBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        Employee currentStudent = employees.get(i);
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent);
    }
    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }
    public void setEmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }
    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private RowLayoutBinding employeeListItemBinding;
        public EmployeeViewHolder(@NonNull RowLayoutBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());
            this.employeeListItemBinding = employeetListItemBinding;
        }
    }
}