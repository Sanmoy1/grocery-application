package com.example.groceryapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.groceryapplication.Adapter.SimilarAdapter;
import com.example.groceryapplication.Domain.ItemsDomain;
import com.example.groceryapplication.R;

public class DetailActivity extends AppCompatActivity {
    private ItemsDomain object;
    private ImageView backBtn, itemImg;
    private TextView priceKgTxt, titleTxt, descriptionTxt, ratingTxt;
    private RatingBar ratingBar;
    private TextView weightTxt, plusBtn, minusBtn, totalTxt;
    private int weight = 1;
    private RecyclerView. Adapter similarAdapter;
    private RecyclerView recyclerViewSimilar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getBundles();
        initView();
        settingVariables();
        initSimilarList();

        button.setOnClickListener(view -> {
            Intent i=new Intent(this,DeliveryActivity.class);
            i.putExtra("totalPrice", totalTxt.getText().toString());
            startActivity(i);
        });

    }

    private void initSimilarList() {
        recyclerViewSimilar=findViewById(R.id.similarView);
        recyclerViewSimilar.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        similarAdapter=new SimilarAdapter(new DashboardActivity().getData());
        recyclerViewSimilar.setAdapter(similarAdapter);
    }

    private void settingVariables() {
        backBtn.setOnClickListener(view -> finish());

        int drawResID=getResources().getIdentifier(object.getImgPath(),"drawable",DetailActivity.this.getPackageName());

        Glide.with(DetailActivity.this).load(drawResID).into(itemImg);

        priceKgTxt.setText(object.getPrice()+"$/kg");
        titleTxt.setText(object.getTitle());
        descriptionTxt.setText(object.getDescription());
        ratingTxt.setText("("+object.getRate()+")");
        ratingBar.setRating((float) object.getRate());
        totalTxt.setText((weight*object.getPrice())+"$");

        plusBtn.setOnClickListener(view -> {
            weight=weight+1;
            weightTxt.setText(weight+" kg");
            totalTxt.setText((weight+object.getPrice())+"$");
        });
        minusBtn.setOnClickListener(view -> {
            if (weight>1)
            {
                weight=weight-1;
                weightTxt.setText(weight+" kg");
                totalTxt.setText((weight*object.getPrice())+"$");
            }
        });


    }

    private void initView() {


        backBtn = findViewById(R.id.backBtn);
        itemImg=      findViewById(R.id.img);
        priceKgTxt = findViewById(R.id.priceKgTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        ratingBar =findViewById(R.id.ratingBar);
        ratingTxt =findViewById(R.id.ratingTxt);
        weightTxt=  findViewById(R.id.wrightTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        totalTxt = findViewById(R.id.totalTxt);
        button=findViewById(R.id.button);
    }

    private void getBundles() {
        object=(ItemsDomain) getIntent().getSerializableExtra("object");
    }
}