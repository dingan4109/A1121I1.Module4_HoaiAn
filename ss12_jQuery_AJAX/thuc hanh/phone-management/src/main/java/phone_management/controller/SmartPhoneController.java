package phone_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import phone_management.entity.SmartPhone;
import phone_management.service.SmartPhoneService;

import java.util.Optional;

@RestController
@RequestMapping("smartphones")
public class SmartPhoneController {
    @Autowired
    SmartPhoneService smartPhoneService;

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        SmartPhone phone = smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ModelAndView getAllSmartPhone() {
        return new ModelAndView("list","phoneList",smartPhoneService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable("id") Long id) {
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            smartPhoneService.remove(id);
            return new ResponseEntity<>(smartPhone.get(),HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<SmartPhone> selectSmartPhone(@PathVariable("id") Long id) {
        Optional<SmartPhone> smartPhone = smartPhoneService.findById(id);
        if(!smartPhone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(smartPhone.get(),HttpStatus.OK);
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<SmartPhone> updateSmartPhone(@PathVariable("id") Long id,@RequestBody SmartPhone smartPhone) {
        Optional<SmartPhone> phone = smartPhoneService.findById(id);
        if(!phone.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            smartPhone.setId(phone.get().getId());
            return new ResponseEntity<>(smartPhoneService.save(smartPhone),HttpStatus.OK);
        }

    }

}
