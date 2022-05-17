package com.example.demo.entity;

import lombok.Data;

@Data
public class Memo {

		private int id;

		private String title;

		private String category;

		private String description;

		private String date;
		
		private int mark_div;
}
