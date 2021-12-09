package com.hotel.dao.model;

import com.hotel.dao.model.enums.RoomStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity{
    private String number;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private int price;

    @OneToMany(mappedBy = "room")
    private List<Order> orders;
}
