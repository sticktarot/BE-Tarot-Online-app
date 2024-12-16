package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntityLazy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
