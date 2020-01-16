package com.regur.addrdemo.dto;

import lombok.Data;

@Data
public class AddressSearch {
    private String confmKey;
    private String currentPage;
    private String countPerPage;
    private String keyword;
    private String resultType;
}
