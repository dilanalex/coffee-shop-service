package cofeeshop.main.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tray")
public class Tray {
	
	private long id;
	
	private Customer customer;
	private Date createdDate;
	private Date modifiedDate;
	private String status;
	private BigDecimal total;
	private BigDecimal tax;
	private boolean isCustomerInQueue;
	
	private List<Item> items;
	
	
	@JsonIgnore
	private CustomerQueue customerQueue;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "tray_id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "modified_date")
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "total")
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "tax")
	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@OneToMany(mappedBy = "tray")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@ManyToOne
	@JoinColumn(name = "cutomer_queue_id")
	public CustomerQueue getCustomerQueue() {
		return customerQueue;
	}

	public void setCustomerQueue(CustomerQueue customerQueue) {
		this.customerQueue = customerQueue;
	}

	@Column(name = "customer_in_queue")
	public boolean isCustomerInQueue() {
		return isCustomerInQueue;
	}

	public void setCustomerInQueue(boolean isCustomerInQueue) {
		this.isCustomerInQueue = isCustomerInQueue;
	}

	
	
}
