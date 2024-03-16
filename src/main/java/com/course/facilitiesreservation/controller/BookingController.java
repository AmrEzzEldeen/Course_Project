package com.course.facilitiesreservation.controller;

import com.course.facilitiesreservation.dto.BookingRequestDto;
import com.course.facilitiesreservation.entity.Booking;
import com.course.facilitiesreservation.service.BookingService;
import com.course.facilitiesreservation.service.FacilitiyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingRequestDto bookingRequestDto;
//    private final FacilitiyService facilitiyService;

    public BookingController(BookingService bookingService, BookingRequestDto bookingRequestDto) {
        this.bookingService = bookingService;
        this.bookingRequestDto = bookingRequestDto;
    }

    @GetMapping("/{facilityId}")
    public ResponseEntity<List<Booking>> getAllBookingsByFacilityId (@PathVariable Long facilityId) {
        return new ResponseEntity<>(bookingService.getAllBookingsByFacilityId(facilityId), HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        Booking booking = bookingService.addNewBooking(bookingRequestDto);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBookingById(@PathVariable Long bookingId) {
        bookingService.removeBooking(bookingId);
        return new ResponseEntity<>("Booking Deleted", HttpStatus.NO_CONTENT);
    }
}
