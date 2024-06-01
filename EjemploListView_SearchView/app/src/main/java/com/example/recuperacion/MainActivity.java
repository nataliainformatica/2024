package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.recuperacion.model.DAO_figuras;
import com.example.recuperacion.model.Shape;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Shape> shapeList;
    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shapeList = DAO_figuras.getShapeList();
        initSearchWidgets();
        setUpList();
        setUpOnclickListener();
    }

    private void initSearchWidgets() {
        searchView = (SearchView) findViewById(R.id.shapeListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                currentSearchText = s;
                ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

                for (Shape shape : shapeList) {
                    if (shape.getName().toLowerCase().contains(s.toLowerCase())) {
                        if (selectedFilter.equals("all")) {
                            filteredShapes.add(shape);
                        } else {
                            if (shape.getName().toLowerCase().contains(selectedFilter)) {
                                filteredShapes.add(shape);
                            }
                        }
                    }
                }
                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }


    private void setUpList() {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id", selectShape.getId());
                startActivity(showDetail);
            }
        });

    }


    private void filterList(String status) {
        selectedFilter = status;

        ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

        for (Shape shape : shapeList) {
            if (shape.getName().toLowerCase().contains(status)) {
                if (currentSearchText == "") {
                    filteredShapes.add(shape);
                } else {
                    if (shape.getName().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        filteredShapes.add(shape);
                    }
                }
            }
        }

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
        listView.setAdapter(adapter);
    }


    public void allFilterTapped(View view) {
        selectedFilter = "all";

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    public void triangleFilterTapped(View view) {
        filterList("triangle");
    }

    public void squareFilterTapped(View view) {
        filterList("square");
    }

    public void octagonFilterTapped(View view) {
        filterList("octagon");
    }

    public void rectangleFilterTapped(View view) {
        filterList("rectangle");
    }

    public void circleFilterTapped(View view) {
        filterList("circle");
    }
}