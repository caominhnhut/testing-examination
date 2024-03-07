package com.saigontech.interviewsample.assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DOC_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Document {
    @Id
    @GeneratedValue
    @Column(name = "DOC_ID")
    protected Long id;

    @Column(name = "REFERENCE_ID")
    protected String referenceId;

    @Column(name = "AUTHOR_NAME")
    protected String authorName;

    public Document(String referenceId, String authorName) {
        this.referenceId = referenceId;
        this.authorName = authorName;
    }

    String getAuthorName() {
        return authorName;
    }

}
