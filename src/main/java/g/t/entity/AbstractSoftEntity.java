package g.t.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class AbstractSoftEntity extends AbstractEntity {

	private static final long	serialVersionUID	= 8993946052188516907L;

	@Field( "deleted" )
	@JsonIgnore
	private boolean				deleted				= false;

}
