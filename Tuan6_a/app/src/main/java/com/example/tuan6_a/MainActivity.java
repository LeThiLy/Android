package com.example.tuan6_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    DataUser dataUser;
    Button addBtn, cancelBtn, removeBtn ;
    EditText nameEdt;
    ListView nameLv;
    ArrayList nameList;
    ArrayList idList;
    ArrayAdapter adapter;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameList=new ArrayList();

        dataUser= new DataUser(this,"userdb.sqlite",null,1);
        idList=new ArrayList();
        dataUser.addUser(new User("Đỗ Anh Bôn"));
        dataUser.addUser(new User("Hoàng Quốc Cường"));
        dataUser.addUser(new User("Phạm Minh Dũng"));
        dataUser.addUser(new User("Châu Hoàng Duy"));
        dataUser.addUser(new User("Trần Nhật Duy"));
        /*dataUser.addUser(new User("Nguyễn Đình Hảo"));
        dataUser.addUser(new User("Hà Khã Huê"));
        dataUser.addUser(new User("Nguyễn Hoàng Hữu"));
        dataUser.addUser(new User("Lê Nguyễn Quang Linh"));
        dataUser.addUser(new User("Nguyễn Công Minh"));
        dataUser.addUser(new User("Nguyễn Hoàng Nghĩa"));
        dataUser.addUser(new User("Trần Thanh Nhã"));
        dataUser.addUser(new User("Trương Hoàng Anh Vũ"));*/

       getNameList();

        nameEdt=findViewById(R.id.nameEdt);
        addBtn=findViewById(R.id.addBtn);
        removeBtn=findViewById(R.id.removeBtn);
        cancelBtn=findViewById(R.id.cancelBtn);
        nameLv=findViewById(R.id.nameLv);

        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);
        nameLv.setAdapter(adapter);

        //Thêm 1 User
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUser.addUser(new User(nameEdt.getText().toString()));
                getNameList();
                adapter.notifyDataSetChanged();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUser.removeUser((int)idList.get(index));
                getNameList();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,
                        "Xóa Thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        nameLv.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index=position;
            }
        });
    }

    private ArrayList getNameList(){
        nameList.clear();
        idList.clear();
        for(Iterator iterator=dataUser.getAll().iterator(); iterator.hasNext();){
            User user=(User) iterator.next();
            nameList.add(user.getName());
            idList.add(user.getId());
        }
        return nameList;
    }
}