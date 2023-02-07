package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ma.fsdm.myapplication.dao.DataBaseManager;
import ma.fsdm.myapplication.entities.Etudiant;

public class SingUp extends AppCompatActivity {
    private Button signupbtn;
    private EditText nom;
    private EditText prenom;
    private EditText cne;
    private EditText email;
    private EditText password;

    private DataBaseManager dataBaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        cne = findViewById(R.id.editCne);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPasswordLogin);

        dataBaseManager = new DataBaseManager(this);

        signupbtn = findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Etudiant e = new Etudiant(nom.getText().toString(),
                                            prenom.getText().toString(),
                                            cne.getText().toString(),
                                            email.getText().toString(),
                                            password.getText().toString());
                dataBaseManager.insertEtudiant(e);
                Toast.makeText(SingUp.this, "inscription avec secces", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SingUp.this, loging.class);
                startActivity(intent);
                finish();
            }
        });
    }
}