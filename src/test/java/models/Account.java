package models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    String name;
    String sname;
    String lname;
    String phone;
    String dolzn;
    String inn;

}
