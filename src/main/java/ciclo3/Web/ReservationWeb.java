/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ciclo3.Web;

import ciclo3.Modelo.Reservation;
import ciclo3.Servicios.ServiciosReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kryz
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservationWeb {
    @Autowired
    private ServiciosReservation servicios;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return servicios.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation) {
        return servicios.getReservation(idReservation);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return servicios.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return servicios.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idReservation) {
        return servicios.deleteReservation(idReservation);
    }
    
}
