package pe.edu.upc.schedule.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "books")
public class AndresDoig {
    
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT o SEQUENCE
  private Integer id;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  @Column(name = "author_name", length = 50, nullable = false)  // Validation: tabla
  private String authorName;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 100)  // Validation: Objeto
  @Column(name = "book_title", length = 100, nullable = false)
  private String bookTitle;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 100)
  @Column(name = "book_description", length = 100, nullable = false)  // u201812236
  private String bookDescription;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 12)
  @Column(name = "book_category", length = 12, nullable = false)
  private String bookCategory;

  @NotNull
  @NotBlank
  @Size(min = 13, max = 13)
  @Column(name = "isbn_number", length = 13, nullable = false)
  private String isbnNumber;

  @Past
  @Column(name = "publish_date")
  @Temporal(TemporalType.DATE)
  private Date publishDate; // lower Camel Case

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "career_id")
  private Career career;

}
