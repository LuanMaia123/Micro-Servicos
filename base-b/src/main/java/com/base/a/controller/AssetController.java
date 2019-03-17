package com.base.a.controller;

import com.base.a.model.Asset;
import com.base.a.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/asset")
public class AssetController {

    @Autowired
    private AssetRepository assetRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Asset>> getAssets() {
        List<Asset> assets = assetRepository.findAll();
        return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Asset> read(@PathVariable long id) {
        Asset asset = assetRepository.findOne(id);
        return new ResponseEntity<Asset>(asset, HttpStatus.OK);
    }
}
