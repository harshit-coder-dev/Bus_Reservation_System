package com.masai.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAdminSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	private String adminUID;

	private LocalDateTime dateTime;
}
