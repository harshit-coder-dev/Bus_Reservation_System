package com.masai.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAdminSession {

	@Id
	@Column(unique = true)
	private Integer adminId;

	private String adminUID;

	private LocalDateTime dateTime;
}
