package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingRepo;

@RestController
public class BookingResourceImpl implements BookingResource {

	@Autowired
	BookingRepo bookingRepo;
	
    @Override
    public ResponseEntity<Booking> create(Booking booking) {
    	Booking booking2 = bookingRepo.save(booking);
        return new ResponseEntity<Booking>(booking2, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<List<Booking>> getAll() {
		List<Booking> bookings = bookingRepo.findAll();
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
}
