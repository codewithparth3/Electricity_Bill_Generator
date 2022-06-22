package com.company.electricityBill.service;

public class BillCalculator {

    static double billAmount;

    /**
     * calculate method contains the logic of bill calculator
     *
     * @param units
     * @param state
     * @return bill amount
     */
    public static double calculate(int units, String state) {
        switch (state) {
            case "Madhya Pradesh":
                if (units <= 100) {
                    billAmount = units * 4;
                } else if (units <= 200) {
                    billAmount = 100 * 4 + (units - 100) * 5;
                } else if (units <= 300) {
                    billAmount = 100 * 4 + 100 * 5 + (units - 200) * 7;
                } else {
                    billAmount = 100 * 4 + 100 * 5 + 100 * 7 + units * 9;
                }
                break;
            case "Gujarat":
                if (units <= 100) {
                    billAmount = units * 3;
                } else if (units <= 200) {
                    billAmount = 100 * 3 + (units - 100) * 3.5;
                } else if (units <= 300) {
                    billAmount = 100 * 3 + 100 * 3.5 + (units - 200) * 5;
                } else {
                    billAmount = 100 * 3 + 100 * 3.5 + 100 * 5 + units * 7;
                }
                break;
            case "RAJASTHAN":
                if (units <= 100) {
                    billAmount = units * 2;
                } else if (units <= 200) {
                    billAmount = 100 * 2 + (units - 100) * 4;
                } else if (units <= 300) {
                    billAmount = 100 * 2 + 100 * 4 + (units - 200) * 6;
                } else {
                    billAmount = 100 * 2 + 100 * 4 + 100 * 6 + units * 8;
                }
                break;
            case "PUNJAB":
                if (units <= 100) {
                    billAmount = units * 4;

                } else if (units <= 200) {
                    billAmount = 100 * 4 + (units - 100) * 5;

                } else if (units <= 300) {
                    billAmount = 100 * 4 + 100 * 5 + (units - 200) * 6.5;

                } else {
                    billAmount = 100 * 4 + 100 * 5 + 100 * 6.5 + units * 8;
                }
                break;
            case "UTTAR_PRADESH":
                if (units <= 100) {
                    billAmount = units * 4.5;

                } else if (units <= 200) {
                    billAmount = 100 * 4.5 + (units - 100) * 5.5;

                } else if (units <= 300) {
                    billAmount = 100 * 4.5 + 100 * 5.5 + (units - 200) * 6.5;
                } else {
                    billAmount = 100 * 4.5 + 100 * 5.5 + 100 * 6.5 + units * 7.5;

                }
        }
        return billAmount;
    }
}
