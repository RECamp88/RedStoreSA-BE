package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String firstname = "";
   private String lastname = "";
   private String address_line_1 = "";
   private String address_line_2 = "";
   private String city = "";
   private String state = "";
   private String zipcode = "";
   private String phone = "";
   private String balance = "";

   @OneToOne(fetch = FetchType.EAGER)
   @JsonBackReference
   @JoinColumn(name="login_id")
   private Login login;

}
