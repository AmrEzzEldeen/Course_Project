package com.course.facilitiesreservation.service;

import com.course.facilitiesreservation.dto.BookingRequestDto;
import com.course.facilitiesreservation.entity.Booking;
import com.course.facilitiesreservation.entity.Tenant;
import com.course.facilitiesreservation.entity.TimeSlot;
import com.course.facilitiesreservation.repository.BookingRespository;
import com.course.facilitiesreservation.repository.TenantRepository;
import com.course.facilitiesreservation.repository.TimeSlotRespository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRespository bookingRespository;
    private final TenantRepository tenantRepository;
    private final TimeSlotRespository timeSlotRepository;
    private final TimeSlotService timeSlotService;

    public BookingService(BookingRespository bookingRespository, TenantRepository tenantRepository, TimeSlotRespository timeSlotRespository, TimeSlotService timeSlotService) {
        this.bookingRespository = bookingRespository;
        this.tenantRepository = tenantRepository;
        this.timeSlotRepository = timeSlotRespository;
        this.timeSlotService = timeSlotService;
    }

    public List<Booking> getAllBookingsByFacilityId(Long facilityId) {
        return bookingRespository.findAllByFacilityId(facilityId);
    }

    public Booking addNewBooking(BookingRequestDto bookingRequestDto) {
        Long tenantId = bookingRequestDto.getTenantId();
        Long facilityTimeSlotId = bookingRequestDto.getFacilityTimeSlotId();
        // Check if the tenant exists
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found with id " + tenantId));

        // Check if the time slot exists
        TimeSlot timeSlot = timeSlotRepository.findById(facilityTimeSlotId)
                .orElseThrow(() -> new RuntimeException("Time slot not found with id " + facilityTimeSlotId));
        // Check If time slot is Booked
        if (!timeSlot.getIsAvailable())
        {
            throw new RuntimeException("Time slot already Booked");
        }
        // Create a new booking
        Booking booking = new Booking();
        booking.setTenantId(tenant.getId());
        booking.setFacilityTimeSlotId(facilityTimeSlotId);
        booking.setBookingDate(timeSlot.getStartDate());
        booking.setTenant(tenant);
        booking.setTimeSlot(timeSlot);
        timeSlotService.setTimeSlotIsAvailable(false, timeSlot.getId());
        // Save the booking in the database
        return bookingRespository.save(booking);
    }

    public void removeBooking (Long bookingId) {
        Booking booking = bookingRespository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not Found"));
        TimeSlot timeSlot = booking.getTimeSlot();
        timeSlot.setIsAvailable(true);
        timeSlotRepository.save(timeSlot);
        bookingRespository.deleteById(bookingId);
    }
}
