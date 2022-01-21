package com.company;

public class Movie {
   private int ticketPrice;
   private String genre;
   private String movieTitle;

    public Movie(String movieTitle, String genre, int ticketPrice) {
        this.ticketPrice = ticketPrice;
        this.genre = genre;
        this.movieTitle = movieTitle;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public String getGenre() {
        return genre;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ticketPrice=" + ticketPrice +
                ", genre='" + genre + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
