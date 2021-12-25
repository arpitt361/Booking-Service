package com.paypal.bfs.test.bookingserv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String>{

}
