package com.saigontech.interviewsample.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class MoneyExam{

//    public static void main(final String[] args) {
//        Money a = new Money(1.23, "USD");
//        Money b = new Money(1.12, "USD");
//        Money c = a.minus(b);
//        System.out.println("c amount: " + c.amount);
//    }

    static class Money {
        private final Double amount;
        private final String currency;


        public Money(Double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }

        public Money minus(Money _that) {
            BigDecimal a = new BigDecimal(_that.amount, MathContext.DECIMAL64);
            BigDecimal b = new BigDecimal(this.amount, MathContext.DECIMAL64);
            BigDecimal val = a.subtract(b);
            return new Money(Double.valueOf(String.valueOf(val)), currency);
        }

        public Double getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Money money = (Money) o;
            return Objects.equals(amount, money.amount) && Objects.equals(currency, money.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, currency);
        }
    }
}
