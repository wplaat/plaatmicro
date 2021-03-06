package nl.plaatsoft.micro.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Inventory.
 * 
 * @author wplaat
 */
@Entity
@Table(name = "inventory")
public class Inventory {

	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		super();
	}

	/**
	 * Instantiates a new inventory.
	 *
	 * @param name the name
	 * @param description the description
	 */
	public Inventory(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
