package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ma.fsdm.myapplication.dao.DataBaseManager;

public class Filieres extends AppCompatActivity {
    private ListView listView;
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filieres);

        listView = findViewById(R.id.listFilieres);
        dataBaseManager = new DataBaseManager(this);
        System.out.println("appel listFilire");
        ArrayList<String> l = (ArrayList<String>) dataBaseManager.listFilliere();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, l);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent  intent = new Intent(Filieres.this, Matieres.class);
                intent.putExtra("filiereSelected", ((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }
}