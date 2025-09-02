package co.com.pragma.model.user;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
  private Long userId;
  private String firstName;
  private String lastName;
  private String email;
  private String identityDocument;
  private String phone;
  private String address;
  private LocalDate birthDate;
  private BigDecimal baseSalary;
  private Long roleId;
}
