package ecom.mobile.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
            name = "enable_finger_print",
            nullable = false
    )
    private int enableFingerPrint;

    @Column(
            name = "enable_notification",
            nullable = false
    )
    private int enableNotification;

    @Column(
            name = "enable_location_service",
            nullable = false
    )
    private int enableLocationService;

    @OneToOne(
            mappedBy = "setting"
    )
    @JsonBackReference
    private User user;

}
