package com.dhu.service;

import com.dhu.dto.EmpAndWage;

import java.util.Collection;

public interface WageService {

    void updateEmpAndWage(EmpAndWage empAndWage);

    Collection<EmpAndWage> selectEmpAndWage();

    EmpAndWage selectEmpAndWageById(int id);

    void addNewWageById(Integer id);
}
