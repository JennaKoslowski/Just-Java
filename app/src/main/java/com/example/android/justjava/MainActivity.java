package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int numCoffee=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**public void calculatePrice(){
     *    return numCoffee*5;
    *}
     **/

    public void submitOrder(View view) {
        int price = numCoffee*5;
        String displayCost = "Total:$"+ price;
        displayCost= displayCost + "\nThank you!";
        displayMessage(displayCost);
    }

    public void increaseOrder(View view) {
        displayQuantity(numCoffee = numCoffee+1);
    }
    public void decreaseOrder(View view) {
        displayQuantity(numCoffee = numCoffee-1);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int amount) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + amount);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}