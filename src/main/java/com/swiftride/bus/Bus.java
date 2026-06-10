package com.swiftride.bus;

import com.swiftride.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    private String busName;

    private String source;

    private String destination;

    private Integer availableSeats;

    private Double fare;

    private String busType;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private User vendor;
}