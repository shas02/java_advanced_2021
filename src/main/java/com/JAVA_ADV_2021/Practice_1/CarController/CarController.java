package com.JAVA_ADV_2021.Practice_1.CarController;

import com.JAVA_ADV_2021.Practice_1.Entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(1, "200", 3.0, 240));
        cars.add(new Car(2, "DeepSpace9", 1000, 9000));
        cars.add(new Car(3, "Voyajer", 500.5, 349));
        cars.add(new Car(4, "e600", 400, 500));
    }

    //    @RequestMapping(value = "/car", method = RequestMethod.GET)
    @GetMapping(value = "/car")
    public List<Car> getCars() {
        return cars;
    }

    @PostMapping(value = "/car")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        cars.add(car);
        return car;
    }

    @PutMapping(value = "/car/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Car updateCar(@PathVariable int id, @RequestBody Car car) {
        final Optional<Car> first = cars.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        final Car carInList = first
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car found"));
        final int index = cars.indexOf(carInList);
        car.setId(id);
        cars.set(index, car);
        return car;
    }

    @DeleteMapping(value = "/car/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable int id) {
        final boolean isRemoved = cars.removeIf(car -> car.getId() == id);
        if (isRemoved) {
            System.out.println("Movie removed");
        } else {
            System.out.println("No movie with such id");
        }
    }
}
