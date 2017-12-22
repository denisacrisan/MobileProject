package com.example.denisa.bookapp;

/**
 * Created by Denisa on 25.11.2017.
 */

public class BookItem {

        String title;
        String author;
        String publisher;

        public BookItem(String title, String author, String publisher) {
            this.title = title;
            this.author = author;
            this.publisher = publisher;
        }

        public String getTitle() {
            return title;
        }

        public void setTtile(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }
}
