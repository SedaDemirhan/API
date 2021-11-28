package com.techproed.pojos;

public class TodosPojo {
 //{
        // "userId": 21,
        // "id": 201,
        // "title": "Tidy your room",
        //"completed": false
        //}

    /*GENEL MANTIK*/
    //Notlar:Burada bir encapsulation yaptık(OOP Consept).Data hiding(dataları saklama)işlemi yaptık.
    //Bu datalara getter setter methodları üzerinden ulaşabiliriz diye bu methodları oluşturduk
    //Bir değer ataması yapabilmek icin parametreli constructor olusturduk
    //ToString methodu ile de atadığımız methodları toString formatında okuyabilmeyi sagladik

    //1.ADIM:Değişkenleri private yapıyoruz

    private int userId;
    private int id;
    private String title;
    private boolean completed;

//2.ADIM:Bu degerlere ulasabilmek icin public getter ve setter methodları olusturalim


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //3.ADIM:Parametreli ve parametresiz constructor olusturuyoruz

    public TodosPojo() {

    }

    public TodosPojo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //4.ADIM:toString methodu ı-olustururuz


    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
