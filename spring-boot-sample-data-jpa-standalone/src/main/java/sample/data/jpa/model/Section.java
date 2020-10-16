package sample.data.jpa.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {

    private int idSection;
    private String libelle;
    private Tablo appartenance;
    private List<Card> mesFiches = new ArrayList<Card>();

    @Id
    @GeneratedValue
    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public Tablo getAppartenance() {
        return appartenance;
    }

    public void setAppartenance(Tablo appartenance) {
        this.appartenance = appartenance;
    }

    @OneToMany(mappedBy = "etat", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @XmlTransient
    public List<Card> getMesFiches() {
        return mesFiches;
    }

    public void setMesFiches(List<Card> fiches) {
        this.mesFiches.addAll(fiches);
    }

    public void addMesFiches(Card card) {
        card.setEtat(this);
        this.setMesFiches(new ArrayList<Card>(){{
            add(card);
        }});
    }
}
