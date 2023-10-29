package com.example.studentsmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSubject, btnAuthor, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubject= findViewById(R.id.buttonSubject);
        btnAuthor= findViewById(R.id.buttonAuthor);
        btnExit= findViewById(R.id.buttonExit);

        //Click tác giả
        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAuthor();
            }
        });

        //Click subject
        btnSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ActivitySubject.class);
                startActivity(intent);
            }
        });

        //Click Exit
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });
    }

    //Hiển thị thông tin tác giả
    private void DialogAuthor(){
        //Tạo đối tượng cửa sổ dialog
        Dialog dialog= new Dialog(this);
        // Nạp Layout vào dialog
        dialog.setContentView(R.layout.dialogformation);
        dialog.show();
    }
        // Hàm hiển thị cửa sổ dialog exit
    private void DialogExit(){
        Dialog dialog= new Dialog(this);

        dialog.setContentView(R.layout.dialogexit);
            // Tắt click ngoài là tắt
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes= dialog.findViewById(R.id.buttonYes);
        Button btnNo= dialog.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

                // Thoát
                Intent intent1= new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });
        // Nếu click No thì trở lại main đóng cửa sổ
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        // show dialog
        dialog.show();
    }
    //run...
}