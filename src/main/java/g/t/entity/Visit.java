package g.t.entity;

import java.time.ZonedDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class Visit extends AbstractSoftEntity {

	private static final long	serialVersionUID	= 5383939146649631852L;

	private String				country;
	private String				city;

	@Field( "visit_date" )
	private ZonedDateTime		visitDate;

}
