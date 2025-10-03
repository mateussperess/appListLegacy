package com.example.listaslegacy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        gerarContatos();

        ListView listView = findViewById(R.id.listView);
        MeuAdaptador adaptador = new MeuAdaptador(this, R.layout.item_contato, contatos);
        listView.setAdapter(adaptador);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void gerarContatos() {
        contatos = new ArrayList<Contato>();
        criarContato("Juca", "555", R.drawable.golden1);
        criarContato("Jereias", "777", R.drawable.golden2);
        criarContato("Zezao", "888", R.drawable.golden3);
        criarContato("Matias", "111", R.drawable.golden4);
        criarContato("Denta", "222", R.drawable.golden5);
    }

    private void criarContato(String nome, String telefone, int foto) {
        Contato contato = new Contato(nome, telefone, foto);
        contatos.add(contato);
    }
}