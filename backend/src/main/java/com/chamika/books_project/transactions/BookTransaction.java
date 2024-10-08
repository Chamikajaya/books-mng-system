package com.chamika.books_project.transactions;

import com.chamika.books_project.book.Book;
import com.chamika.books_project.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_book_transaction")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_transaction_id_sequence")
    @SequenceGenerator(name = "book_transaction_id_sequence", sequenceName = "book_transaction_id_sequence", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private Boolean isReturned = false;

    @Column(nullable = false)
    private Boolean isReturnApproved = false;


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)  // * for the relationship between transaction and book, BookTransaction entity is the owning side
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)  // * for the relationship between transaction and user, BookTransaction entity is the owning side
    private User user;

    // audit fields -->
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;


}
