package com.example.opilane.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText unitprice,nrofunits,itm,item,vat;
    RadioButton excl,incl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitprice = findViewById(R.id.UnitPrice);
        nrofunits = findViewById(R.id.NumberOfunits);
        itm = findViewById(R.id.itm);
        item = findViewById(R.id.item);
        vat = findViewById(R.id.vat);
        excl = findViewById(R.id.ExclVAT);
        incl = findViewById(R.id.InclVAT);

    }

    public double VAT(double up, double nrf)
    {
        return (up * nrf) * 0.2;
    }

    public double exclVAT(double up, double nrf)
    {
        return up * nrf;
    }

    public  double inclVAT(double up, double nrf)
    {
        return ((up * nrf) * 0.2) + up * nrf ;
    }

    public void onClick(View view)
    {
        if (view.getId() == R.id.clear)
        {
            unitprice.setText("");
            nrofunits.setText("");
        } if (view.getId() == R.id.OK)
        {
            if (unitprice.getText().length() == 0 || nrofunits.getText().length() == 0)
            {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }
            double up = Double.parseDouble(unitprice.getText().toString());
            double nrf = Double.parseDouble(nrofunits.getText().toString());
            if (excl.isChecked()) itm.setText(String.valueOf(exclVAT(up,nrf)));
            if (incl.isChecked()) item.setText(String.valueOf(inclVAT(up,nrf)));

            vat.setText(String.valueOf(VAT(up,nrf)));

        }
    }
}
