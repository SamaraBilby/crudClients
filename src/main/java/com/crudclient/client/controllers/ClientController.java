package com.crudclient.client.controllers;

import com.crudclient.client.dto.ClientDTO;
import com.crudclient.client.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService _clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO dto = _clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
        Page<ClientDTO> dto = _clientService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO dto){
        dto = _clientService.create(dto);
        URI uri = ServletUriComponentsBuilder
                  .fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(dto.getId())
                  .toUri();
        return ResponseEntity.created(uri).body(dto);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id,@Valid @RequestBody ClientDTO dto){
        dto = _clientService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        _clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
