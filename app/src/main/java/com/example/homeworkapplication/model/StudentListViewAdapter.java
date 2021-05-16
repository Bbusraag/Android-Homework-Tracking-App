package com.example.homeworkapplication.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homeworkapplication.R;

import java.util.List;

public class StudentListViewAdapter extends ArrayAdapter<student> {
    List<student> studentList;
    Context context;
    int resource;
    public StudentListViewAdapter(@NonNull Context context, int resource, @NonNull List<student>list) {
        super(context, resource, list);
        this.studentList = list;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(resource,parent, false);

        ImageView ivImage=(ImageView)view.findViewById(R.id.ivImage);
        TextView tvAd=(TextView)view.findViewById(R.id.tvAd);
        TextView tvsoyad=(TextView)view.findViewById(R.id.tvSoyad);
        TextView tvDepartment=(TextView)view.findViewById(R.id.tvDepartment);
        Button btnAdd=(Button)view.findViewById(R.id.btnAdd);
        student Student=studentList.get(position);

        tvAd.setText(Student.getName());
        tvsoyad.setText(Student.getSurname());
        tvDepartment.setText(Student.getDepartment());
        ivImage.setImageDrawable(context.getResources().getDrawable(Student.getImage()));
        return view;
    }

}
