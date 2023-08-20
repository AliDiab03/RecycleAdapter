package com.example.recycleadapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomRecycleAdapter adapter  ;
    EditText etname ;
    EditText etrate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rvStudents = findViewById(R.id.rvStudent);
        Button btn  = findViewById(R.id.btn);
        EditText etname = findViewById(R.id.etName);
        EditText etrate = findViewById(R.id.etrate);

        ArrayList<Student> data = new ArrayList<>();
        data.add(new Student("ahmed",80.4,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24));
        data.add(new Student("ahmed1",50.2,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24));
        data.add(new Student("ahmed2",80.4,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24));
        data.add(new Student("ahmed3",70.1,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24));
        data.add(new Student("ahmed4",84.3,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24));

         adapter = new CustomRecycleAdapter(this, data, new CustomRecycleAdapter.onIteamClickLisnear() {
            @Override
            public void onClicked(Student student,int position) {
               Student std1 = new Student( student.getName()+"1 0",student.getRate()+10f,student.getImg(),student.getImgDelete());
               data.set(position,std1);
               adapter.notifyItemChanged(position);
            }

            @Override
            public void onDeleteClick(int position) {


                data.remove(position);

                adapter.notifyItemRemoved(position);

            }
        });
        rvStudents.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                double rate = Double.parseDouble(etrate.getText().toString());
                Student student = new Student(name,rate,R.drawable.ic_launcher_background,R.drawable.ic_baseline_delete_24);
                data.add(student);
                adapter.notifyItemInserted(data.size()-1);

            }
        });

//          LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        GridLayoutManager manager = new GridLayoutManager(this,2,RecyclerView.HORIZONTAL,false);
        rvStudents.setLayoutManager(manager);




    }
}

