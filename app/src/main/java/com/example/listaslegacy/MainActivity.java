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

public class MainActivity extends AppCompatActivity {

    String animais[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        animais = new String[] {"Cachorro", "Gato", "Coelho", "Peixe", "Canguru"};
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, animais);
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_da_lista, R.id.txtAnimais, animais);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_da_lista, R.id.txtAnimais, animais);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, animais[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}