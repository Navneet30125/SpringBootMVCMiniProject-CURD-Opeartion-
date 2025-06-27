package com.nav.vo;

import lombok.Data;

@Data
public class DoctorVO {
private Integer did;
private String dname;
private String specialization;
private Double fee;
private String qlfy="MBBS";
}
