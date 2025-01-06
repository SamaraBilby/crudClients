package com.crudclient.client.services;

import com.crudclient.client.dto.ClientDTO;
import com.crudclient.client.entities.Client;
import com.crudclient.client.repositories.ClientRepository;
import com.crudclient.client.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository _clientRepository;
    @Autowired
    private ModelMapper _modelMapper;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = _clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado para o ID: " + id));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = _clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO create(ClientDTO dto){
        Client entity = _modelMapper.map(dto, Client.class);
        entity = _clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto) {
        try {
            Client entity = _clientRepository.getReferenceById(id);
            _modelMapper.map(dto, Client.class);
            entity = _clientRepository.save(entity);
            return  new ClientDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Cliente não encontrado para o ID: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){

        if(!_clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Cliente não encontrado para o ID: " + id);
        }

        _clientRepository.deleteById(id);
    }

}
