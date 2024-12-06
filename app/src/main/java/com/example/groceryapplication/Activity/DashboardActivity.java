package com.example.groceryapplication.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryapplication.Adapter.BestDealAdapter;
import com.example.groceryapplication.Adapter.CategoryAdapter;
import com.example.groceryapplication.Domain.CategoryDomain;
import com.example.groceryapplication.Domain.ItemsDomain;
import com.example.groceryapplication.R;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView.Adapter catAdapter, bestDealAdapter;
    private RecyclerView recyclerViewCat, recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
        initRecyclerviewCat();
        initlocation();
        initRecyclerBestDeal();
        //initSimilarList();
    }



    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items = new ArrayList<>();
        items.add(new CategoryDomain("cat1", "vegetable"));
        items.add(new CategoryDomain("cat2", "Fruits"));
        items.add(new CategoryDomain("cat3", "Dairy"));
        items.add(new CategoryDomain("cat4", "Drinks"));
        items.add(new CategoryDomain("cat5", "Grain"));

        recyclerViewCat = findViewById(R.id.catview);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);
    }

    private void initlocation() {
        String[] items = new String[]{"LosAngles,USA", "NewYork,USA"};
        final Spinner locationSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter);
    }

    public ArrayList<ItemsDomain> getData() {
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain("orange", "Quality Orange", 6.2, "Juicy and vibrant, our orange bursts with refreshing citrus flavor.", 4.2));
        items.add(new ItemsDomain("apple", "Quality apple", 6.5, "Impeccably designed and seamlessly integrated, the Apple product delivers unparalleled performance and user experience.", 4.2));
        items.add(new ItemsDomain("watermelon", "Quality watermelon", 5.1, "Juicy and refreshing watermelon, bursting with sweet summertime flavor.", 4.1));
        items.add(new ItemsDomain("berry", "Quality berry", 5.2, "A succulent mix of tart and sweet, bursting with antioxidants and vibrant flavors.", 4.4));
        items.add(new ItemsDomain("pineaplle", "Quality pineapple", 5.3, "Tropical paradise in every bite, offering a perfect balance of sweetness and tanginess.", 4.3));
        items.add(new ItemsDomain("strawberry", "Quality strawberry", 4.5, "Juicy, ruby-red delights that embody the essence of summer with their luscious sweetness.", 4.5));
        return items;
    }
    private void initRecyclerBestDeal(){
        recyclerViewBestDeal=findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }
}
