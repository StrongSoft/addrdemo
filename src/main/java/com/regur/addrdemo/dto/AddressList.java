package com.regur.addrdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddressList {
    @JsonProperty("juso")
    private List<Juso> juso;
    @JsonProperty("common")
    private Common common;

    @Data
    public static class Common{
        private String errorMessage;
        private String countPerPage;
        private String totalCount;
        private String errorCode;
        private String currentPage;
    }

    @Data
    public static class Juso{
        private String roadAddr;
        private String roadAddrPart1;
        private String roadAddrPart2;
        private String jibunAddr;
        private String engAddr;
        private String zipNo;
        private String admCd;
        private String rnMgtSn;
        private String bdMgtSn;
        private String detBdNmList;
        private String bdNm;
        private String bdKdcd;
        private String siNm;
        private String sggNm;
        private String emdNm;
        private String liNm;
        private String rn;
        private String udrtYn;
        private String buldMnnm;
        private String buldSlno;
        private String mtYn;
        private String lnbrMnnm;
        private String lnbrSlno;
        private String emdNo;
    }
}
