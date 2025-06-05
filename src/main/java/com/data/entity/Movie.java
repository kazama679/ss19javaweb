package com.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    private String director;

    @NotNull(message = "Năm phát hành không được để trống")
    @Min(value = 1900, message = "Năm phát hành không hợp lệ")
    @Max(value = 2100, message = "Năm phát hành không hợp lệ")
    private Integer releaseYear;

    private String genre;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 1, message = "Thời lượng phải lớn hơn 0")
    private Integer duration;

    private String language;

    @NotBlank(message = "Poster không được để trống")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "URL không hợp lệ")
    private String poster;

    private boolean status = true;
}
