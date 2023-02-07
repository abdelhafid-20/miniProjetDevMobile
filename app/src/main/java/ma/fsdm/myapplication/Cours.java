package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ma.fsdm.myapplication.dao.DataBaseManager;

public class Cours extends AppCompatActivity {
    private DataBaseManager dataBaseManager;
    private ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        dataBaseManager = new DataBaseManager(this);
        listView = findViewById(R.id.listCours);

        ArrayList<String> cours = dataBaseManager.listCoursParMatiere(this.getIntent().getExtras().getString("matiereSelected"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cours);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri =Uri.parse(dataBaseManager.getUriByTitle(((TextView)view).getText().toString()));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}