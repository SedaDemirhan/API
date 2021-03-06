package com.techproed.pojos;

public class BookingDatesPojo {
   /*"bookingdates": {
   "checkin": "2020-09-09",
   "checkout": "2020-09-21"
        */

    //private değişkenler oluşturduk

    private String checkin;
    private String checkout;

    //getter ve setter metodları olustur


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //constructor olusturma parametreli ve parametresiz

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //tostring olusturuyoruz

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
