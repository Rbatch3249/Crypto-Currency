package com.cryptoCurrency.CryptoCurrency;

import java.util.Date;

public class MarketStamp {
    private String created_on;
    private String unix_time;
   private Ticker ticker;
   private Market market;

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(String unix_time) {
        this.unix_time = unix_time;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return "MarketStamp{" +
                "created_on='" + created_on + '\'' +
                ", unix_time='" + unix_time + '\'' +
                ", ticker=" + ticker +
                ", market=" + market +
                '}';
    }
}
