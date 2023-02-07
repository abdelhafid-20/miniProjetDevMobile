package ma.fsdm.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import ma.fsdm.myapplication.entities.Coure;
import ma.fsdm.myapplication.entities.Etudiant;

public class DataBaseManager extends SQLiteOpenHelper {
    private final static  String DATA_BASE_NAME = "course";
    private final static  int DATA_BASE_VERSION = 4;
    public DataBaseManager(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlReq = "create table etudiant (idEtudiant integer primary key autoincrement, " +
                "nom text not null," +
                "prenom text not null," +
                "cne text not null," +
                "email text not null," +
                "password text not null)";
        sqLiteDatabase.execSQL( sqlReq );
        Log.i("DataBase", "on create invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "drop table if exists coure " );
        String sqlReq;

        sqlReq = "create table coure (idcoure integer primary key autoincrement, " +
                "filiere text not null," +
                "matiere text not null," +
                "titre text not null," +
                "uri text not null)";
        sqLiteDatabase.execSQL( sqlReq );
        Log.i("DataBase", "on update invoked");

    }

    public void insertEtudiant(Etudiant e) {
        String sqlReq = "insert into etudiant (nom, prenom, cne, email, password) values ( '" +
                e.getNom()+"', '"+e.getPrenom()+"', '"+e.getCne()+"', '" +
                e.getEmail()+"', '"+e.getMotDePasse()+"')";
        this.getWritableDatabase().execSQL(sqlReq);
        Log.i("DataBase", "insertEtudiant invoked");
    }

    public boolean isExiste(String cne, String email, String password){
        String sqlReq = "select * from etudiant where cne = '" +
                cne+"' and email = '" +
                email+"' and password='"+password+"'";
        Cursor cursor = this.getReadableDatabase().rawQuery( sqlReq, null );
        cursor.moveToFirst();
        Log.i("database", "isExiste invoked");
        return !cursor.isAfterLast();
    }

    public ArrayList<String> listFilliere(){
        System.out.println("listFilirer");
        ArrayList<String> filieres = new ArrayList<>();
        String sqlReq = "select filiere from coure group By filiere";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            System.out.printf(cursor.getString(0));
            filieres.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return filieres;
    }

    public ArrayList<String> listMatiereParFiliere(String filiere){
        ArrayList<String> matieres = new ArrayList<>();
        String sqlReq = "select matiere from coure where filiere = '"+filiere+"' group by matiere";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            matieres.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return matieres;
    }

    public ArrayList<String> listCoursParMatiere(String matiere){
        ArrayList<String> cours = new ArrayList<>();
        String sqlReq = "select titre from coure where matiere = '"+matiere+"' group by titre";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            cours.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return cours;
    }

    public String getUriByTitle(String titre){
        String sqlReq = "select uri from coure where titre = '"+titre+"' ";
        Cursor cursor = this.getReadableDatabase().rawQuery(sqlReq, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
            return cursor.getString(0);
        return null;
    }

    public void deleteEtudiant(String cne, String email){
        String sqlReq = "delete from etudiant where cne = '"+cne+"' and email = '"+email+"'";
        this.getWritableDatabase().execSQL(sqlReq);
    }
}
