package com.example.a1412998.loancalculatorthaiversion;

/**
 * Created by 1412998 on 9/7/2016.
 */

/**
 * @author 1412998
 *
 */
public class LoanCalculator {

    private double loanAmount;
    private int numberOfYears;
    private double yearlyInterestRate;

    public LoanCalculator(){}

    public LoanCalculator (double loanAmount, int numberOfYears, double yearlyInterestRate)
    {
        this.loanAmount = loanAmount;
        this.numberOfYears = numberOfYears;
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public double getLoanAmount ()
    {
        return loanAmount;
    }

    public double getMonthlyPayment ()
    {
        double monthlyPayment;
        monthlyPayment = (loanAmount * yearlyInterestRate/12)/(1 - (1/Math.pow((1+ (yearlyInterestRate/12)), (numberOfYears * 12))));
        monthlyPayment = Math.round (monthlyPayment*100)/100.0;
        return monthlyPayment;
    }


    public int getNumberOfYears ()
    {
        return numberOfYears;
    }

    public double getTotalCostOfLoan ()
    {
        double totalCostOfLoan;
        totalCostOfLoan = this.getMonthlyPayment() * numberOfYears * 12;
        return totalCostOfLoan;
    }

    public double getTotalInterest ()
    {
        double totalInterest;
        totalInterest = this.getTotalCostOfLoan() - this.getLoanAmount();
        return totalInterest;

    }

    public double getYearlyInterestRate ()
    {
        return yearlyInterestRate;
    }

    public void setLoanAmount (double loanAmount)
    {
        this.loanAmount = loanAmount;
    }

    public void setNumberOfYears (int numberOfYears)
    {
        this.numberOfYears = numberOfYears;
    }

    public void setYearlyInterestRate (double yearlyInterestRate)
    {
        this.yearlyInterestRate = yearlyInterestRate;
    }



}



