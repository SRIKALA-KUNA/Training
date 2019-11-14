package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    /**
     *
     * @param principal principal amount
     * @param term term of mortgage in years
     * @param rate rate of interest
     * @return monthly payment amount
     */
    public static double calculateMonthlyPayment(
            int principal, int term, double rateOfInterest) {

       
        if (principal < 0 || term <= 0 || rateOfInterest < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        
        rateOfInterest /= 100.0;

       
        double timeInMonths = term * 12;

        
        if(rateOfInterest==0)
            return  principal/timeInMonths;

        
        double monthlyRate = rateOfInterest / 12.0;

       
        double monthlyPayment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -timeInMonths));

        return monthlyPayment;
    }
}
