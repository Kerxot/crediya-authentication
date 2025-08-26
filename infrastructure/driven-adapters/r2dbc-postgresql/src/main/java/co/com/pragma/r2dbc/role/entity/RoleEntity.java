package co.com.pragma.r2dbc.role.entity;

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
@Table("roles")
public class RoleEntity {
  @Id
  @Column("role_id")
  private Long userId;
  @Column("name")
  private String name;
  @Column("description")
  private String description;
}
