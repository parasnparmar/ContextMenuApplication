package com.example.contextmenuapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //ImageView imageView;
    int itemId;
    ListView foodItemListView;
    String [] foodItems;
    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_item_list_view);
        initViews();
        registerForContextMenu(foodItemListView);

        Resources resources = getResources();
        foodItems = resources.getStringArray(R.array.foodItems);

        stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,foodItems);
        foodItemListView.setAdapter(stringArrayAdapter);
        registerForContextMenu(foodItemListView);


    }
    private void initViews(){
      // imageView = findViewById(R.id.imageView);
       //imageView.setImageResource(R.drawable.shopstock);
       foodItemListView = findViewById(R.id.foodItemListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu for Image");
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        itemId = item.getItemId();
        if (itemId == R.id.saveImage) {
            makeToast("Save Image");
        } else if (itemId == R.id.copyImage) {
            makeToast("Copy Image");
        } else if (itemId == R.id.copyImagePath) {
            makeToast("Copy Image Path");
        } else if (itemId == R.id.saveAs) {
            makeToast("Save As");
        } else if(itemId == R.id.download){
            makeToast("Download Image");
         }

        return super.onContextItemSelected(item);
    }
    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        super.onContextMenuClosed(menu);
    }
}