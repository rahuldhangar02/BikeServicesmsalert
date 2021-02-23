package com.smsalert.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mecanic")
public class Mecanic {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="id")
	    private int id;
	    @Column(name = "name",nullable =false)
	    private String name;
	    
		public Mecanic() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Mecanic(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Mecanic [id=" + id + ", name=" + name + "]";
		}
	    
	    
}
