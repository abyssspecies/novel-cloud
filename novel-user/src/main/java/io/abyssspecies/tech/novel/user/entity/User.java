package io.abyssspecies.tech.novel.user.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description...
 *
 * @author abyss species 2021-05
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nickName;
    @Column(name = "user_photo")
    private String avatar;
    @Column(name = "user_sex")
    private Byte gender;
    private Byte status;
    private BigDecimal accountBalance;
}
