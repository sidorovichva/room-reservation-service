package com.vs.roomreservationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("room-reservations")
@RequiredArgsConstructor
public class RoomReservationWebService {
    private final RestTemplate restTemplate;

    @GetMapping
    public List<RoomReservation> getRoomReservations() {
        List<Room> rooms = this.getAllRooms();
        List<RoomReservation> roomReservations = new ArrayList<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomId(room.getId());
            roomReservations.add(roomReservation);
        });
        return roomReservations;
    }

    public List<Room> getAllRooms() {
        ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange(
                "http://ROOMSERVICES/room",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Room>>() {}
        );
        return roomResponse.getBody();
    }
}
