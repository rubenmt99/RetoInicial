package com.example.retoinicial.service;

import com.example.retoinicial.entity.Language;

import java.util.List;

public interface ILanguageService {

    public List<Language> listLanguages();

    public Language findByCode(String code);

    public Language getLanguage(Integer id);

    public Language crearLanguage(Language language);

    public Language updateLanguage(Language language);

    public void deleteLanguage(Integer id);

}
