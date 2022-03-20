package dev.jefferson.estoquepreco.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigoProduto;
	private Double preco;

}