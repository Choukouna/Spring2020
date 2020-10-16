package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.model.Card;

import java.util.Date;
import java.util.List;

@Transactional
public interface CardDao extends JpaRepository<Card, Long> {

    public Card findByLibelle(String nameCard);

    public List<Card> findByDateButoire(Date deadline);
}