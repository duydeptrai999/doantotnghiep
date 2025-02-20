package onmyownn.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import onmyownn.support.enums.RoleEnum;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AccountEntity.class)
public abstract class AccountEntity_ {

	public static volatile SingularAttribute<AccountEntity, String> password;
	public static volatile ListAttribute<AccountEntity, OrderEntity> customerOrders;
	public static volatile SingularAttribute<AccountEntity, String> address;
	public static volatile SingularAttribute<AccountEntity, RoleEnum> role;
	public static volatile ListAttribute<AccountEntity, CartEntity> carts;
	public static volatile SingularAttribute<AccountEntity, String> phone;
	public static volatile SingularAttribute<AccountEntity, String> name;
	public static volatile SingularAttribute<AccountEntity, Long> id;
	public static volatile ListAttribute<AccountEntity, OrderEntity> employeeOrders;
	public static volatile SingularAttribute<AccountEntity, String> email;
	public static volatile SingularAttribute<AccountEntity, String> username;
	public static volatile SingularAttribute<AccountEntity, Integer> status;

	public static final String PASSWORD = "password";
	public static final String CUSTOMER_ORDERS = "customerOrders";
	public static final String ADDRESS = "address";
	public static final String ROLE = "role";
	public static final String CARTS = "carts";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMPLOYEE_ORDERS = "employeeOrders";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";
	public static final String STATUS = "status";

}

