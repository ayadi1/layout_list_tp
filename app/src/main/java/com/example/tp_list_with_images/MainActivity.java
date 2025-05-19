package com.example.tp_list_with_images;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Tableau des noms des villes
    City[] citys = new City[]{
            new City("agadir", "agadir description", R.drawable.agadir),
            new City("casa", "casa description", R.drawable.casa),
            new City("eljadida", "eljadida description", R.drawable.eljadida),
            new City("essaouira", "essaouira description", R.drawable.essaouira),
            new City("fes", "fes description", R.drawable.fes),
            new City("meknes", "meknes description", R.drawable.meknes),
            new City("merrakech", "merrakech description", R.drawable.merrakech),
            new City("oujda", "oujda description", R.drawable.oujda),
            new City("tanger", "tanger description", R.drawable.tanger)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> data = new ArrayList<>();

        for (City city : citys) {
            Map<String, Object> map = new HashMap<>();

            map.put("name", city.name);
            map.put("description", city.description);
            map.put("imageSrc", city.imageSrc);
            data.add(map);
        }

        String[] from = {"name", "description", "imageSrc"};
        int[] to = {R.id.txt, R.id.description, R.id.flag};


        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.layout_list, from, to);

        ListView listView = findViewById(R.id.l1);

        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}