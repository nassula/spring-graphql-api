package com.nassula.graphqlapi.controller;

import com.nassula.graphqlapi.domain.Company;
import com.nassula.graphqlapi.repository.CompanyRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @QueryMapping
    public Flux<Company> companyList(@Argument Long page) {
        return companyRepository.findAll().skip(page * 10).take(10);
    }

    @QueryMapping
    public Mono<Long> companyCount() {
        return companyRepository.count();
    }
}
