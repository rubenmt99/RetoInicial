package com.example.retoinicial.repository;

import com.example.retoinicial.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, Integer> {

    public Language findByCode(String code);

}
