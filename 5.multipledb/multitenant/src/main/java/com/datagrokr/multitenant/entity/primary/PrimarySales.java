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
@Entity
@Getter
@Setter
@Table(name = "sales")
public class PrimarySales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sales_id;
    private Integer user_id;
    private Integer book_id;
}
