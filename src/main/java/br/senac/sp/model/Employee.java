/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luans
 */
@Getter
@Setter
public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeeRole;
    private String employeeEmail;
    private String employeePassword;
    private String employeeStatus;

   
        
       
    public boolean verifyStatus(String status){
        if(status.equals("Ativo"))
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeRole=" + employeeRole + ", employeeEmail=" + employeeEmail + ", employeePassword=" + employeePassword + ", employeeStatus=" + employeeStatus + '}';
    }
    
    
}
