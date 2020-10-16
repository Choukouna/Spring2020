package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.model.Section;

@Transactional
public interface SectionDao extends JpaRepository<Section, Integer> {
    public Section findByLibelle(String libelle);
}
