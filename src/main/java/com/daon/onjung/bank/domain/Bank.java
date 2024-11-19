package com.daon.onjung.bank.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank {

    /* -------------------------------------------- */
    /* Default Column ----------------------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* -------------------------------------------- */
    /* Information Column ------------------------- */
    /* -------------------------------------------- */
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "bank_number", length = 20, nullable = false)
    private String bankNumber;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Builder
    public Bank(Long eventId, String bankNumber) {
        this.eventId = eventId;
        this.bankNumber = bankNumber;
        this.balance = 0;
    }

    public void updateBalance(Integer balance) {
        this.balance = balance;
    }
}
