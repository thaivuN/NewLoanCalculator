package com.example.a1412998.loancalculatorthaiversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private EditText loan;
    private EditText year;
    private EditText interest;

    private TextView monthlyResult;
    private TextView totalResult;
    private TextView interResult;
    private TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        loan = (EditText) findViewById(R.id.loanAmInput);
        year = (EditText) findViewById(R.id.termsInput);
        interest = (EditText) findViewById(R.id.interestInput);

        monthlyResult = (TextView) findViewById(R.id.monthlyOutput);
        totalResult = (TextView) findViewById(R.id.totalOutput);
        interResult = (TextView) findViewById(R.id.interestOutput);
        error = (TextView) findViewById(R.id.errorTag);
    }

    private void createLayout(){
        LinearLayout llayout = new LinearLayout(this);
        llayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        llayout.setLayoutParams(params);
        llayout.setPadding(16,16,16,16);

        TextView tv = new TextView(this);

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(params);
        tv.setGravity(Gravity.CENTER);
        tv.setText(getString(R.string.topCenterName));

        llayout.addView(tv);

        LinearLayout loanLL = new LinearLayout(this);
        llayout.setOrientation(LinearLayout.HORIZONTAL);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        loanLL.setLayoutParams(params);

        TextView loanTV = new TextView(this);
        params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        loanTV.setText(getString(R.string.loanAmLbl));

        EditText loanET = new EditText(this);
        loanET.setLayoutParams(params);
        loanET.setHint(R.string.loanAmHint);
        loanET.setId(R.id.loanAmInput);

        loanLL.addView(loanTV);
        loanLL.addView(loanET);







    }


    public void onCalculate(View view)
    {
        Log.d (loan.getText().toString(), "getText");


        try
        {


            double loanNum = Double.parseDouble(loan.getText().toString());
            int yearNum = Integer.parseInt(year.getText().toString());
            double interNum = Double.parseDouble(interest.getText().toString());

            LoanCalculator lc = new LoanCalculator(loanNum, yearNum, interNum);


            monthlyResult.setText(lc.getMonthlyPayment() + "");
            totalResult.setText(lc.getTotalCostOfLoan() + "");
            interResult.setText(lc.getTotalInterest() + "");

            error.setVisibility(TextView.GONE);

            monthlyResult.setVisibility(TextView.VISIBLE);
            totalResult.setVisibility(TextView.VISIBLE);
            interResult.setVisibility(TextView.VISIBLE);
        }
        catch(Exception e) {
            error.setVisibility(TextView.VISIBLE);
        }




    }

    public void onClear (View view)
    {
        loan.setText("");
        year.setText("");
        interResult.setText("");
        monthlyResult.setText("");
        totalResult.setText("");
        interest.setText("");

        interResult.setVisibility(TextView.INVISIBLE);
        monthlyResult.setVisibility(TextView.INVISIBLE);
        totalResult.setVisibility(TextView.INVISIBLE);
        error.setVisibility(TextView.GONE);
    }




}
