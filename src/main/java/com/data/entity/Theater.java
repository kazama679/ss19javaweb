package com.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên rạp không được để trống")
    private String theaterName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Min(value = 1, message = "Số phòng chiếu phải > 0")
    private int numberScreenRoom;

    private boolean status = true;
}
