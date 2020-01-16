package com.regur.addrdemo.web;

import com.regur.addrdemo.dto.AddressList;
import com.regur.addrdemo.dto.AddressSearch;
import com.regur.addrdemo.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public String getAddressList(AddressSearch search, Model model){
        log.info("search {}",search.toString());
        AddressList address = null;
        try {
            address = addressService.getAddress(search);
            model.addAttribute("addrList", address.getJuso());
            model.addAttribute("common",address.getCommon());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address.toString();
    }
}
