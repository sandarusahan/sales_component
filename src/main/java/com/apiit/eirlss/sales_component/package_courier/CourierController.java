package com.apiit.eirlss.sales_component.package_courier;

import java.util.Optional;

import com.apiit.eirlss.sales_component.package_order.SalesOrder;
import com.apiit.eirlss.sales_component.package_order.SalesOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "courier/")
public class CourierController {

    @Autowired
    CourierRepository courierRepository;

    @Autowired
    SalesOrderRepository salesRepo;

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
        if(c.isPresent()){
            int count = 0;
            Iterable<SalesOrder> sales = salesRepo.findAllByCourierId(c.get().getCourierId());
            for(SalesOrder sale: sales){
                if(sale != null)
                    count++;
            }

            if(count >= 1){
                return false;
            }else {
                courierRepository.deleteById(couid);
                return true;
            }
        }else {
            return false;
        }

    }
}
