package bookingservImplementation;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.bookingserv.BookingServApplication;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.BookingRepo;
import com.paypal.bfs.test.bookingserv.impl.BookingResourceImpl;

@SpringBootTest(classes = BookingServApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BookingTest {
	
	@Autowired
	BookingResourceImpl bookingResImpl;
	
	@Test
	public void createBookingTest() {
		bookingResImpl = Mockito.mock(BookingResourceImpl.class);
		Booking booking = new Booking();
		Address address = new Address(1, "55 A", "Tularambagh", "Allahabad", "UP");
		booking.setFirstName("Arpit");
		booking.setLastName("Tripathi");
		booking.setDob("22-08-1992");
		booking.setCheckInDate("10-8-2020");
		booking.setCheckOutDate("11-8-2020");
		booking.setTotalPrice(100);
		booking.setDeposit(60);
		booking.setAddress(address);
		
		Mockito.when(bookingResImpl.create(booking)).thenReturn(new ResponseEntity<Booking>(booking, HttpStatus.OK));
	}
	
	@Test
	public void getAllBookingsTest() {
		bookingResImpl = Mockito.mock(BookingResourceImpl.class);
		List<Booking> listBookings = new ArrayList<>();
		Booking booking = new Booking();
		Address address = new Address(1, "55 A", "Tularambagh", "Allahabad", "UP");
		booking.setFirstName("Arpit");
		booking.setLastName("Tripathi");
		booking.setDob("22-08-1992");
		booking.setCheckInDate("10-8-2020");
		booking.setCheckOutDate("11-8-2020");
		booking.setTotalPrice(100);
		booking.setDeposit(60);
		booking.setAddress(address);
		listBookings.add(booking);
		when(bookingResImpl.getAll()).thenReturn(new ResponseEntity<List<Booking>>(listBookings, HttpStatus.OK));
		
	}
}
