package com.example.retoinicial.service;

import com.example.retoinicial.entity.Language;
import com.example.retoinicial.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService{

    @Autowired
    ILanguageRepository languageRepository;

    @Override
    public List<Language> listLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language findByCode(String code) {
        return languageRepository.findByCode(code);
    }

    @Override
    public Language getLanguage(Integer id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public Language crearLanguage(Language language) {
        language.setCode(language.getCode().toUpperCase());
        return languageRepository.save(language);
    }

    @Override
    public Language updateLanguage(Language language) {
        Language language1 = getLanguage(language.getId());
        if(language1 == null){
            return null;
        }
        language1.setCode(language.getCode());
        language1.setMessage(language.getMessage());
        return languageRepository.save(language1);
    }

    @Override
    public void deleteLanguage(Integer id) {
        Language language1 = getLanguage(id);
        if(language1 == null){
            return;
        }
        languageRepository.delete(language1);
    }
}
