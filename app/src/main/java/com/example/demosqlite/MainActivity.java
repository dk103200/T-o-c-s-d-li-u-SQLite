package com.example.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase = new MyDatabase(this);
        initView();
        initListener();
    }

    private void initListener(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl = myDatabase.insertData(name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Thêm thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSua.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String toan = etToan.getText().toString();
                String li = etLi.getText().toString();
                String hoa = etHoa.getText().toString();
                boolean bl = myDatabase.updateData(id,name,toan,li,hoa);
                if(bl){
                    Toast.makeText(MainActivity.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Sửa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        }));

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                boolean bl = myDatabase.deleteData(id);
                if(bl){
                    Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Xóa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView(){
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
        etId = (EditText) findViewById(R.id.et_id);
        etName = (EditText) findViewById(R.id.et_name);
        etToan = (EditText) findViewById(R.id.et_toan);
        etLi = (EditText) findViewById(R.id.et_li);
        etHoa = (EditText) findViewById(R.id.et_hoa);

    }
}