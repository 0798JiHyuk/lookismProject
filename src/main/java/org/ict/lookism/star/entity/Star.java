package org.ict.lookism.star.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Star {
	private String starId;
	private String starName;
	private String starGender;
	private String starJob;
}