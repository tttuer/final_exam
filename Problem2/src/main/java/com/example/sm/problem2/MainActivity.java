package com.example.sm.problem2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here
        emp_list = new ArrayList<>();

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee;

        switch (v.getId()){
            case R.id.btn_inc:
                // need something here
                Log.v("getid값 : ",""+v.getId());
                employee = (Employee)adapter.getItem(adapter.selected_position);
                employee.increase();
                break;

            case R.id.btn_dec:
                // need something here
                employee = (Employee)adapter.getItem(adapter.selected_position);
                employee.decrease();
                break;

            case R.id.btn_store:
                // need something here
                employee = new Employee(edit_name.getText().toString(),Integer.parseInt(edit_age.getText().toString()),Integer.parseInt(edit_salary.getText().toString()));
                Log.v("입력","" + employee.getName() + "" + employee.getAge() + "" + employee.getSalary());
                adapter.add(employee);
                break;

            case R.id.btn_modify:
                // need something here
                adapter.notifyDataSetInvalidated();
                break;

            case R.id.btn_delete:
                // need something here
                adapter.delete(adapter.selected_position);
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
