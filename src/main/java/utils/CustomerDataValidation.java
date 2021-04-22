/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import br.senac.sp.model.EmployeeRole;
import java.util.ArrayList;
import java.util.List;
import static utils.EmployeeDataValidation.verificaPalavra;

/**
 *
 * @author luans
 */
public class CustomerDataValidation {

    public List<String> validParamethers(String name, String cpf, String email, String status, String pass, String passConf) {

        List<String> errorList = new ArrayList();
        String erro = "";

        if (name.equals("")
                || name.equals("")
                || cpf.equals("")
                || email.equals("")
                || status.equals("")
                || pass.equals("")
                || passConf.equals("")) {
            erro = "Existem campos que não foram preenchidos.";
            errorList.add(erro);
            return errorList;
        }
        if (!verificaPalavra(name)) {
            erro = "O campo Nome pode conter apenas letras";
            System.out.println(erro);
            errorList.add(erro);
        } else if (name.length() < 5) {
            erro = "O campo Nome não tem carácteres o suficiente";
            System.out.println(erro);
            errorList.add(erro);
        }

        if (!email.contains("@")
                || !email.contains(".com")
                || email.contains(" ")
                || email.contains("@.com")
                || !hasDominio(email)) {
            erro = "Não foi inserido um e-mail válido.";
            System.out.println(erro);
            errorList.add(erro);
        }

        if (!pass.equals(passConf)) {
            erro = "Foram inseridas senhas divergentes.";
            System.out.println("senha 1"+pass);
                        System.out.println("senha 2"+passConf);

            System.out.println(erro);
            errorList.add(erro);
        }
        if (pass.length() < 3
                || passConf.length() < 3) {
            erro = "A senha precisa ter no mínimo 3 caracteres";
            System.out.println(erro);
            errorList.add(erro);
        }
        if (!validaQtdeNomes(name)) {
            erro = "É necessário um nome completo válido";
            System.out.println(erro);
            errorList.add(erro);
        }
        if (!validaTamanhoNomes(name)) {
            erro = "Cada nome deve ter pelo menos 3 letras";
            System.out.println(erro);
            errorList.add(erro);
        }

        return errorList;
    }

    private boolean validaTamanhoNomes(String nome) {
        int tamAtual = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                if (tamAtual < 3) {
                    return false;
                }
                tamAtual = 0;
            } else {
                tamAtual++;
            }
        }
        return true;
    }

    private boolean validaQtdeNomes(String nome) {
        boolean isValid = false;
        int espaces = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                espaces++;
            }
        }
        if (espaces > 0) {
            return true;
        }
        return isValid;
    }

    private boolean hasDominio(String email) {
        boolean dominio = true;
        if (email.contains("@") && email.contains(".")) {
            int indexArroba = email.indexOf("@");
            int indexPonto = email.indexOf(".");
            String resultado = email.substring(indexArroba + 1, indexPonto);

            if (resultado.length() < 2) {
                System.out.println("O e-mail dado não possui domínio");
                return false;
            }
        } else {
            return false;
        }

        return dominio;
    }

    public List<String> validaEndereco(String street, String code, String uf, String number, String neighborhood, String complement, String type, String isActive, List<String> currentErrorList) {
        String erro = "";
        if (street.equals("")
                || code.equals("")
                || uf.equals("")
                || number.equals("")
                || complement.equals("")
                || neighborhood.equals("")
                || uf.equals("")
                || isActive.equals("")
                || type.equals("")) {
            erro = "Existem campos de endereço que não foram preenchidos.";
            currentErrorList.add(erro);
        }
        return currentErrorList;
    }

}
