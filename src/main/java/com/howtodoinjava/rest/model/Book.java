package com.howtodoinjava.rest.model;

public class Book {

    public Book(int pages) {

        this.pages = pages;
    }

    public Book(Integer id, String countryOfOrigin, String publisher, String contact, int pages) {
        super();
        this.id = id;
        this.countryOfOrigin = countryOfOrigin;
        this.publisher = publisher;
        this.contact = contact;
        this.pages = pages;
    }
 
    private Integer id;
    private String countryOfOrigin;
    private String publisher;
    private String contact;
    private int pages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getcountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setcountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", countryOfOrigin=" + countryOfOrigin + ", publisher=" + publisher + "]";
    }
}
