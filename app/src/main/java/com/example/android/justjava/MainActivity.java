package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


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

        EditText nameText = (EditText) findViewById(R.id.name_input);
        Editable names = nameText.getText();

        int pricePerCup = calculatePrice(hasWhippedCream, hasChocolateDrizzle);
        String totalMessage = createOrderSummary(pricePerCup, hasWhippedCream, hasChocolateDrizzle, names);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+ names);
        intent.putExtra(Intent.EXTRA_TEXT, totalMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolateDrizzle){
       int pricePerCup = 5;
        if (hasWhippedCream == true) {
            pricePerCup += 1;
        }
        if (hasChocolateDrizzle == true){
            pricePerCup +=2;
        }
        return numCoffee*pricePerCup;
    }

   private String createOrderSummary(int pricePerCup, boolean hasWhippedCream, boolean hasChocolateDrizzle, Editable names){
        String totalMessage = "Name: " + names;
       totalMessage= totalMessage + "\nQuantity: " +numCoffee;
       totalMessage= totalMessage + "\nHas Whipped Cream? " + hasWhippedCream;
       totalMessage= totalMessage + "\nHas Chocolate Drizzle? " + hasChocolateDrizzle;
       totalMessage = totalMessage + "\nTotal: $"+ pricePerCup;
       return totalMessage;
   }

    public void increaseOrder(View view) {
        if (numCoffee==100){
            Toast.makeText(this, "You cannot order more than 100 coffees.", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(numCoffee = numCoffee+1);
    }
    public void decreaseOrder(View view) {
        if (numCoffee ==1){
            Toast.makeText(this, "You cannot order less than one coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        displayQuantity(numCoffee = numCoffee-1);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int amount) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + amount);
    }
}