package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ma.fsdm.myapplication.dao.DataBaseManager;

public class Matieres extends AppCompatActivity {
    private DataBaseManager dataBaseManager;
    private ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matieres);
        dataBaseManager = new DataBaseManager(this);
        listView = findViewById(R.id.listCours);
        String fili = this.getIntent().getExtras().getString("filiereSelected");
        ArrayList<String> matieres = dataBaseManager.listMatiereParFiliere(fili);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matieres);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Matieres.this, Cours.class);
                intent.putExtra("matiereSelected", ((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }
}