package com.example.android.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolateDrizzle = chocolateCheckbox.isChecked();

        int price = numCoffee*5;
        String totalMessage = createOrderSummary(price, hasWhippedCream, hasChocolateDrizzle);
        displayMessage(totalMessage);

        calculatePrice(numCoffee, price);
    }

    private void calculatePrice(int numCoffee, int pricePerCup){
        int price= numCoffee*5;
    }

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolateDrizzle){
        String totalMessage = "Name: Jenna Koslowski" ;
        totalMessage= totalMessage + "\nQuantity: " +numCoffee;
        totalMessage= totalMessage + "\nHas Whipped Cream? " + hasWhippedCream;
        totalMessage= totalMessage + "\nHas Chocolate Drizzle? " + hasChocolateDrizzle;
        totalMessage = totalMessage + "\nTotal: $"+ price;
        return totalMessage;
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
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
}