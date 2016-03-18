package g.t.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class AbstractEntity implements Serializable {

	private static final long	serialVersionUID	= 1L;

	@CreatedBy
	@Field( "created_by" )
	@JsonIgnore
	private String				createdBy;

	@CreatedDate
	@Field( "created_date" )
	@JsonIgnore
	private Date				createdDate			= new Date( );

	@LastModifiedBy
	@Field( "last_modified_by" )
	@JsonIgnore
	private String				lastModifiedBy;

	@LastModifiedDate
	@Field( "last_modified_date  " )
	@JsonIgnore
	private Date				lastModifiedDate	= new Date( );

}
