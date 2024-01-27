package com.nassula.graphqlapi.repository;

import com.nassula.graphqlapi.domain.Company;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface CompanyRepository extends ReactiveNeo4jRepository<Company, Long> {

}
