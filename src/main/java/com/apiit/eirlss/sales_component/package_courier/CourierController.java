package com.apiit.eirlss.sales_component.package_courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "courier/")
public class CourierController {

    @Autowired
    CourierRepository courierRepository;

    @GetMapping(path = "all")
    public Iterable<Courier> GetCouriers() {
        return courierRepository.findAll();
    }

    @GetMapping(path = "{couId}")
    public Courier getCourier(@PathVariable String couId){
        return courierRepository.findById(couId).get();
    }

    @PostMapping(path = "new")
    public Courier AddNewCourier (@RequestBody Courier courier) {
        return courierRepository.save(courier);
    }

    @PutMapping(path = "/update")
    public Courier UpdateCourier(@RequestBody Courier courier){

        Courier cour = courierRepository.save(courier);
        System.out.println(cour.getCourierId() + " is updated");

        return cour;
    }


    @DeleteMapping("/{couid}")
    public Boolean DeleteCourier(@PathVariable String couid){

        Optional<Courier> c = courierRepository.findById(couid);
        if(c.isPresent())
            courierRepository.deleteById(couid);

        System.out.println(c.get().getCourierId() + " is deleted");

        return c.isPresent();
    }
}
