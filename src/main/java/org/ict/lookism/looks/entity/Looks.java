package org.ict.lookism.looks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Looks {
	private String userId;
	private String starName;
	private double percent;
	private Date looksDate;
}