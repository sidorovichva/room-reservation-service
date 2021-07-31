package com.vs.roomreservationservice;

import lombok.Data;

@Data
public class Room {
    private long id;
    private String roomName;
    private String roomNumber;
    private String bedInfo;
}
