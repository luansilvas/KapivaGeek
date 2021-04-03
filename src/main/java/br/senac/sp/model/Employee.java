/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.model;

import lombok.Getter;
import lombok.Setter;
import at.favre.lib.crypto.bcrypt.BCrypt;

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

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeRole, String employeeEmail, String employeePassword, String employeeStatus) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.employeeEmail = employeeEmail;
        this.employeePassword = employeePassword;
        this.employeeStatus = employeeStatus;
    }
    public boolean verifyStatus(String status){
        if(status.equals("Ativo"))
            return true;
        else
            return false;
    }
    
    
        public String codificarSenha(String senha){
    return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
    public boolean validarSenha(String senha){
    BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(),this.employeePassword);
    return response.verified;
    }
}
