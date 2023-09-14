package com.br.budgetbuddy.transfer.controller;

import com.br.budgetbuddy.transfer.entity.Transfer;
import com.br.budgetbuddy.transfer.service.TransferServiceImpl;
import com.br.budgetbuddy.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("transfer")
@AllArgsConstructor
public class TransferController {

    private final TransferServiceImpl transferService;


    @GetMapping("/{userId}")
    public List<Transfer> findAllByUserId(@PathVariable User userId) {
        return transferService.findAllByUserId(userId);
    }

    @PostMapping("/save")
    public void saveTransfer(@RequestBody Transfer transfer) {
        transferService.saveTransfer(transfer);
    }

    @PostMapping("/delete/{transferId}")
    public void deleteTransfer(@PathVariable UUID transferId) {
        transferService.deleteTransfer(transferId);
    }

    @PutMapping("/update/{transferId}")
    public void updateTransfer(@PathVariable UUID transferId, Transfer transfer) {
        transferService.updateTransfer(transferId, transfer);
    }
}
