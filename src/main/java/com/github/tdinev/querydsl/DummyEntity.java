package com.github.tdinev.querydsl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
class DummyEntity {
    @Id
    @Column
    private Long id;

    @Column
    private String content;
}
