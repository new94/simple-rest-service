package ru.nenahov.simplerest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nenahov.simplerest.data.DataDTO;

@Repository
public interface IRepositoryData extends CrudRepository<DataDTO, Long> {
}
