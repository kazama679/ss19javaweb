package com.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatName;

    private boolean status = true;

    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;
}
