package com.example.demo.service;

import com.example.demo.dao.BroadbandRepository;
import com.example.demo.entity.Broadband;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BroadbandImpl implements BroadbandService {
    private BroadbandRepository broadbandRepository;

    @Autowired
    public BroadbandImpl(BroadbandRepository broadbandRepository) {
        this.broadbandRepository = broadbandRepository;
    }

    @Override
    public List<Broadband> getAllBroadbandConnections() {
        return broadbandRepository.findAll();
    }

    @Override
    public Broadband saveBroadbandConnection(Broadband broadband) {
        return broadbandRepository.save(broadband);
    }

    @Override
    public Broadband getBroadbandConnectionById(Integer id) {
        return broadbandRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteBroadbandConnection(Integer id) {
        broadbandRepository.deleteById(id);
    }
}
