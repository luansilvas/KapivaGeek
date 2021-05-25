/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.model;

/**
 *
 * @author luans
 */
public class Payment {
    private int payment_id;
    private String payment_way;
    private int payment_instalments;
    private String payment_status;
    private int card_id;

    public Payment(int payment_id, String payment_way, int payment_instalments, String payment_status, int card_id) {
        this.payment_id = payment_id;
        this.payment_way = payment_way;
        this.payment_instalments = payment_instalments;
        this.payment_status = payment_status;
        this.card_id = card_id;
    }

    public Payment(String payment_way, int payment_instalments, String payment_status, int card_id) {
        this.payment_way = payment_way;
        this.payment_instalments = payment_instalments;
        this.payment_status = payment_status;
        this.card_id = card_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public Payment(String payment_way, int payment_instalments, String payment_status) {
        this.payment_way = payment_way;
        this.payment_instalments = payment_instalments;
        this.payment_status = payment_status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_way() {
        return payment_way;
    }

    public void setPayment_way(String payment_way) {
        this.payment_way = payment_way;
    }

    public int getPayment_instalments() {
        return payment_instalments;
    }

    public void setPayment_instalments(int payment_instalments) {
        this.payment_instalments = payment_instalments;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

}
