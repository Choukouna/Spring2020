package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.model.Tablo;

@Transactional
public interface TabloDao extends JpaRepository<Tablo, Long> {

    public Tablo findByTitreProjet(String title);
}
