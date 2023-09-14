package com.br.budgetbuddy.transfer.service;

import com.br.budgetbuddy.transfer.entity.Transfer;
import com.br.budgetbuddy.transfer.repository.TransferRepository;
import com.br.budgetbuddy.user.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    public List<Transfer> findAllByUserId(User userId) {
        return transferRepository.findAllByUserId(userId);
    }

    @Override
    public UUID saveTransfer(@Valid Transfer transfer) {
        return transferRepository.save(transfer).getId();
    }

    @Override
    public void deleteTransfer(@NotNull UUID transferId) {
        transferRepository.deleteById(transferId);
    }

    @Override
    public Transfer updateTransfer(UUID transferId, Transfer transfer) {
        return null;
    }

    @Override
    public Transfer findTransferById(UUID transferId) {
        return transferRepository.findById(transferId).orElse(null);
    }
}
