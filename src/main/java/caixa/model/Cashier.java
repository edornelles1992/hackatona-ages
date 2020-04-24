package caixa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CAIXA")
public class Cashier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_caixa")
	private Long id;
	
	@Column(name = "data_abertura")
	private LocalDateTime dataAbertura; 
	
	@Column(name = "data_fechamento")
	private LocalDateTime dataFechamento; 
	
}
