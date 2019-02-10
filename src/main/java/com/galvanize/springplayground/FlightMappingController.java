package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightMappingController {

  @GetMapping("flight")
  public Flight getFlight() {
    Flight flight = new Flight();
    return flight;
  }

  // nested classes
  static class Flight {
    // field variables
    private Date departure;
    private List<Ticket> tickets;
    // constructor
    public Flight() {
      this.departure = new Date();
      Person annie = new Person("Annie", "Herald");
      Person greg = new Person("Greg", "Marley");
      Ticket ticket1 = new Ticket(annie, 200);
      Ticket ticket2 = new Ticket(greg, 210);
      this.tickets = Arrays.asList(ticket1, ticket2);
    }
    // getters and setters
    public Date getDeparture() { return this.departure; }
    public List<Ticket> getTickets() { return this.tickets; }
  }

  static class Ticket {
    private Person passenger;
    private int price;

    public Ticket(Person passenger, int price) {
      this.passenger = passenger;
      this.price = price;
    }

    public Person getPassenger() { return passenger; }
    public int getPrice() { return price; }
  }

}
