package guru.springframework.domain;

import java.util.Set;


import javax.persistence.*;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	
	@ManyToMany(mappedBy = "categories" ,fetch = FetchType.EAGER)
	private Set<Recipe> recipes;
	
	
}
