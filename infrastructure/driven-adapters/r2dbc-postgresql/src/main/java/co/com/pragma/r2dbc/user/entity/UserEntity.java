package co.com.pragma.r2dbc.user.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UserEntity {
  @Id
  @Column("user_id")
  private Long userId;
  @Column("first_name")
  private String firstName;
  @Column("last_name")
  private String lastName;
  @Column("email")
  private String email;
  @Column("identity_document")
  private String identityDocument;
  @Column("phone")
  private String phone;
  @Column("address")
  private String address;
  @Column("birth_date")
  private LocalDate birthDate;
  @Column("base_salary")
  private BigDecimal baseSalary;
  @Column("role_id")
  private Long roleId;
}
