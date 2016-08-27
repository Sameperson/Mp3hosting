package com.sameperson.mp3hosting.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Mp3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Shouldn't be empty")
    @Size(min = 3, max = 16, message = "Name should be from 3 to 16 characters in length")
    private String name;
    @Lob
    private byte[] data;
    private boolean availableForEveryone;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String hash;
    private LocalDateTime dateUploaded = LocalDateTime.now();

    public Mp3() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDateTime dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isAvailableForEveryone() {
        return availableForEveryone;
    }

    public void setAvailableForEveryone(boolean availableForEveryone) {
        this.availableForEveryone = availableForEveryone;
    }
}

