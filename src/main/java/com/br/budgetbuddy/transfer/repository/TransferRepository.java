package com.br.budgetbuddy.transfer.repository;

import com.br.budgetbuddy.transfer.entity.Transfer;
import com.br.budgetbuddy.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {

    List<Transfer> findAllByUserId(User userId);
}
