package com.datagrokr.multitenant.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "books")
public class PrimaryBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String bookname;
    private String genre;
    private String author;
}
