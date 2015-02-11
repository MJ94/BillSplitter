package edu.css.cis3334.billsplitter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView txtNumParty;
    EditText txtBill;
    EditText total1, total2, total3, total4 ;
    SeekBar sbNumparty;
    Integer NumParty = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total1 = (EditText) findViewById(R.id.editText);
        txtNumParty = (TextView) findViewById(R.id.tvNumParty);
        sbNumparty = (SeekBar) findViewById(R.id.seekBar);
        sbNumparty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                NumParty = sbNumparty.getProgress()+1;
                txtNumParty.setText("Number in Party: " + NumParty.toString());
            }
        });

        txtBill = (EditText) findViewById(R.id.txtBillAmount);
        txtBill.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                UpdateTotals();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
            }
            public void onTextChanged(CharSequence s, int start, int before, int count){
            }
        });


    }

    // update all the fields on the form
    public void UpdateTotals() {
        Double bill = Double.parseDouble(txtBill.getText().toString());
        Double split = bill/NumParty;
        total1.setText(split.toString());
    }




}
