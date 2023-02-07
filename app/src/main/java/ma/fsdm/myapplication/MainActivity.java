package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import ma.fsdm.myapplication.dao.DataBaseManager;

public class MainActivity extends AppCompatActivity {
    DataBaseManager dataBaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseManager = new DataBaseManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, loging.class);

                intent.putExtra("key", "abdelhafi");
                startActivity(intent);
                finish();
            }
        },3000);
    }
}