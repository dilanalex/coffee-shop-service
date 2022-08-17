package cofeeshop.main.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_queue")
public class CustomerQueue {

	
	//private Shop shop; lets keep this unimplemented for the moment
	private List<Tray> trays;
	private long queueId;
	//private boolean isCustomerIn; this one really no need, change the ERD
	private long id;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cutomer_queue_id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "customerQueue")
	public List<Tray> getTrays() {
		return trays;
	}
	
	public void setTrays(List<Tray> trays) {
		this.trays = trays;
	}
	
	public long getQueueId() {
		return queueId;
	}
	
	public void setQueueId(long queueId) {
		this.queueId = queueId;
	}
	
	
	
}
