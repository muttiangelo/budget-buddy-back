package com.br.budgetbuddy.transfer.service;

import com.br.budgetbuddy.transfer.entity.Transfer;
import com.br.budgetbuddy.user.entity.User;

import java.util.List;
import java.util.UUID;

public interface TransferService {

    List<Transfer> findAllByUserId(User userId);

    UUID saveTransfer(Transfer transfer);

    void deleteTransfer(UUID transferId);

    Transfer updateTransfer(UUID transferId, Transfer transfer);

    Transfer findTransferById(UUID transferId);
}
