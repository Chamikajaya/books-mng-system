package com.chamika.books_project.book;

public record BookResponseBody(
        Integer id,
        String title,
        String authorName,
        String isbn,
        String synopsis,
        Boolean isShareable,
        Boolean isArchived,

        String ownerName,

        byte[] coverImage,

        Double averageRating


) {
}
