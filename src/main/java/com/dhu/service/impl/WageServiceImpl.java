package com.dhu.service.impl;

import com.dhu.dto.EmpAndWage;
import com.dhu.mapper.WageMapper;
import com.dhu.service.WageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WageServiceImpl implements WageService {
    @Autowired
    WageMapper wageMapper;

    @Override
    public void updateEmpAndWage(EmpAndWage empAndWage) {
        wageMapper.updateEmpAndWage(empAndWage);
    }

    @Override
    public Collection<EmpAndWage> selectEmpAndWage() {
        return wageMapper.selectEmpAndWage();
    }

    @Override
    public EmpAndWage selectEmpAndWageById(int id) {
        return wageMapper.selectEmpAndWageById(id);
    }

    @Override
    public void addNewWageById(Integer id) {
        wageMapper.addNewWageById(id);
    }
}
