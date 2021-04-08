/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import br.senac.sp.model.EmployeeRole;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luans
 */
public class EmployeeDataValidation {

    public List<String> validParamethers(String name, String role, String email, String status, String pass, String passConf) {

        List<String> errorList = new ArrayList();
        String erro = "";

        if (name.equals("")
                || name.equals("")
                || role.equals("")
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

        if (!role.equals(EmployeeRole.Administrador.name())
                && !role.equals(EmployeeRole.Estoquista.name())) {
            erro = "Não foi selecionada um cargo válido.";
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
            System.out.println(erro);
            errorList.add(erro);
        }
        if (pass.length() < 3
                || passConf.length() < 3) {
            erro = "A senha precisa ter no mínimo 3 caracteres";
            System.out.println(erro);
            errorList.add(erro);
        }

        return errorList;
    }

    public List<String> validateChanges(String name, String role, String status) {

        List<String> errorList = new ArrayList();
        String erro = "";
        if (name.equals("")
                || name.equals("")
                || role.equals("")
                || status.equals("")) {
            erro = "Existem campos que não foram preenchidos.";
            errorList.add(erro);
            return errorList;
        }
        if (!verificaPalavra(name)) {
            erro = "O campo Nome permite apenas letras";
            System.out.println(erro);
            errorList.add(erro);
        } else if (name.length() < 5) {
            erro = "O campo Nome precisa ter pelo menos 5 caracteres";
            System.out.println(erro);
            errorList.add(erro);
        }

        if (!role.equals(EmployeeRole.Administrador.name())
                && !role.equals(EmployeeRole.Estoquista.name())) {
            erro = "Não foi selecionada um cargo válido.";
            System.out.println(erro);
            errorList.add(erro);
        }

        return errorList;
    }

    public List<String> validatePassword(String pass, String passConf) {

        List<String> errorList = new ArrayList();
        String erro = "";

        if (!pass.equals(passConf)) {
            erro = "Foram inseridas senhas divergentes.";
            System.out.println(erro);
            errorList.add(erro);
        }
        if (pass.length() < 3
                || passConf.length() < 3) {
            erro = "A senha precisa ter no mínimo 3 caracteres";
            System.out.println(erro);
            errorList.add(erro);
        }

        return errorList;
    }

    public static boolean verificaPalavra(String palavra) {
        boolean retorno = true;
        for (int i = 0; i < palavra.length(); i++) {
            if (verificaLetra(palavra.charAt(i)) == false) {
                return false;
            }

        }
        return retorno;
    }

    public static boolean verificaLetra(char caract) {
        boolean letra = false;
        String temp = Character.toString(caract);

        Pattern pattern = Pattern.compile("[qwertyuiopasdfghjklzxcvbnmQWERTYÇUIOPASDFGHJKLZXCVBN M]");
        Matcher matcher = pattern.matcher(temp);
        while (matcher.find()) {
            letra = true;
        }

        return letra;
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

}
