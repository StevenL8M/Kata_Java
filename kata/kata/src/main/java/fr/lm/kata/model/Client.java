package fr.lm.kata.model;

public class Client {
	private Long id;
	
	public Client() {
		
	}
	
	public Client(Long id) {
		super();
		this.id = id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
}
