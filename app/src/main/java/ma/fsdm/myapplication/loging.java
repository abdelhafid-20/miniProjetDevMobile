package ma.fsdm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ma.fsdm.myapplication.dao.DataBaseManager;

public class loging extends AppCompatActivity {
    private EditText editCne;
    private EditText editPassword;
    private EditText editEmail;
    private Button btnLogin;

    private TextView inscrire;

    private DataBaseManager dataBaseManager;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        dataBaseManager = new DataBaseManager(this);
        Toast.makeText(loging.this, getIntent().getStringExtra("key"), Toast.LENGTH_LONG).show();
                                 editCne = findViewById(R.id.editCne);
                                 editEmail = findViewById(R.id.editEmail);
                                 editPassword = findViewById(R.id.editPasswordLogin);
                                 btnLogin = findViewById(R.id.loginbtn);
                                 btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataBaseManager.isExiste(editCne.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString())) {
                    Toast.makeText(loging.this, "exist", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loging.this, Filieres.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(loging.this, "n'exist pas", Toast.LENGTH_LONG).show();
            }
        });


        //inscription d'un nouveau etudiant
        inscrire = findViewById(R.id.inscrire);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loging.this, SingUp.class);
                startActivity(intent);
            }
        });
    }
}