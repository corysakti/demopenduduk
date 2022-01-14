package com.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "penduduk")
public class Penduduk implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //masih error untuk menentukan nip sebagai primary key
    @Id
    @NotEmpty(message = "NIP is Required")
    @Column(length = 63, nullable = false, unique = true)
    private String nip;

    @NotEmpty(message = "Name is Required")
    @Column(length = 50, nullable = false)
    private String nama_lengkap;

    @Column(nullable = false)
    private Date tanggal_lahir;

    @NotEmpty(message = "tempat lahir is Required")
    @Column(length = 63)
    private String tempat_lahir;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }


    public Penduduk() {
    }

    public Penduduk(@NotEmpty(message = "NIP is Required") String nip,
            @NotEmpty(message = "Name is Required") String nama_lengkap, Date tanggal_lahir,
            @NotEmpty(message = "tempat lahir is Required") String tempat_lahir) {
        this.nip = nip;
        this.nama_lengkap = nama_lengkap;
        this.tanggal_lahir = tanggal_lahir;
        this.tempat_lahir = tempat_lahir;
    }


    

    
}
