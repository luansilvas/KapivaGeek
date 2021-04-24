/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import br.senac.sp.dao.CustomerDAO;
import br.senac.sp.model.EmployeeRole;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if (!pass.equals(passConf)) {
            erro = "Foram inseridas senhas divergentes.";
            System.out.println("senha 1" + pass);
            System.out.println("senha 2" + passConf);

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

        if (!isCPF(cpf)) {
            erro = "CPF inválido - Insira apenas numeros e verifique o valor digitado";

            errorList.add(erro);
        } else {
            if (CustomerDAO.CPFExists(cpf)) {

                erro = "CPF já está cadastrado na base";
                errorList.add(erro);
            }
        }
        if (!email.contains("@")
                || !email.contains(".com")
                || email.contains(" ")
                || email.contains("@.com")) {
            erro = "Não foi inserido um e-mail válido.";
            System.out.println(erro);
            errorList.add(erro);
        } else {
            if (CustomerDAO.EmailExists(email)) {
                erro = "E-mail já existe na base";
                errorList.add(erro);
            }
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

   /* private boolean hasDominio(String email) {
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
    }*/

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

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

}
