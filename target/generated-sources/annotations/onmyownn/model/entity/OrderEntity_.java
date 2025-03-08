package onmyownn.model.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderEntity.class)
public abstract class OrderEntity_ {

	public static volatile SingularAttribute<OrderEntity, String> note;
	public static volatile SingularAttribute<OrderEntity, String> address;
	public static volatile SingularAttribute<OrderEntity, String> code;
	public static volatile SingularAttribute<OrderEntity, Double> totalPrice;
	public static volatile SingularAttribute<OrderEntity, VoucherEntity> voucher;
	public static volatile SingularAttribute<OrderEntity, AccountEntity> employee;
	public static volatile SingularAttribute<OrderEntity, Integer> paymentType;
	public static volatile ListAttribute<OrderEntity, OrderDetailEntity> orderDetails;
	public static volatile SingularAttribute<OrderEntity, Integer> totalPayment;
	public static volatile SingularAttribute<OrderEntity, String> phone;
	public static volatile SingularAttribute<OrderEntity, String> paymentTransactionNo;
	public static volatile SingularAttribute<OrderEntity, String> name;
	public static volatile SingularAttribute<OrderEntity, Double> totalDiscount;
	public static volatile SingularAttribute<OrderEntity, Long> id;
	public static volatile SingularAttribute<OrderEntity, LocalDateTime> confirmedAt;
	public static volatile SingularAttribute<OrderEntity, String> email;
	public static volatile SingularAttribute<OrderEntity, Boolean> paymentStatus;
	public static volatile SingularAttribute<OrderEntity, Integer> status;
	public static volatile SingularAttribute<OrderEntity, AccountEntity> customer;

	public static final String NOTE = "note";
	public static final String ADDRESS = "address";
	public static final String CODE = "code";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String VOUCHER = "voucher";
	public static final String EMPLOYEE = "employee";
	public static final String PAYMENT_TYPE = "paymentType";
	public static final String ORDER_DETAILS = "orderDetails";
	public static final String TOTAL_PAYMENT = "totalPayment";
	public static final String PHONE = "phone";
	public static final String PAYMENT_TRANSACTION_NO = "paymentTransactionNo";
	public static final String NAME = "name";
	public static final String TOTAL_DISCOUNT = "totalDiscount";
	public static final String ID = "id";
	public static final String CONFIRMED_AT = "confirmedAt";
	public static final String EMAIL = "email";
	public static final String PAYMENT_STATUS = "paymentStatus";
	public static final String STATUS = "status";
	public static final String CUSTOMER = "customer";

}

