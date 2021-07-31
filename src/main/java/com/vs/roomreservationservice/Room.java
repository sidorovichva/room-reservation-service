package com.vs.roomreservationservice;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Room {
    private long id;
    private String roomName;
    private String roomNumber;
    private String bedInfo;
}
