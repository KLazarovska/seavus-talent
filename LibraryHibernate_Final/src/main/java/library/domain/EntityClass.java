package library.domain;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class EntityClass {

	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
}
