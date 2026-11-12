package com.cineman1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblScreeningRoom1")
public class ScreeningRoom1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "roomName", length = 50)
    private String roomName;

    @Column(name = "seatCount")
    private int seatCount;

    @Column(name = "roomType", length = 20)
    private String roomType;

    @Column(name = "status", length = 20)
    private String status;

    public ScreeningRoom1() {
    }

    public ScreeningRoom1(String roomName, int seatCount, String roomType, String status) {
        this.roomName = roomName;
        this.seatCount = seatCount;
        this.roomType = roomType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
