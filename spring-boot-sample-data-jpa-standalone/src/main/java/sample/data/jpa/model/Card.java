package sample.data.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//enum Section {ToDO, Doing, Done};
@Entity
@NamedQuery(
        name="findCardByLibelle",
        query = "select c from Card c where c.libelle = :lib"
)
public class Card {
    private Long idCard;
    private String libelle;
    private Date dateButoire;
    private int tempsRestant;
    private String lieu;
    private String url;
    private String description;

    private Section etat;
    private List<User> workers = new ArrayList<User>();

    @Id
    @GeneratedValue
    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long id) {
        this.idCard = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    public int getTempsRestant() {
        return tempsRestant;
    }

    public void setTempsRestant(int tempsRestant) {
        this.tempsRestant = tempsRestant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade= CascadeType.ALL)
    public Section getEtat() {
        return etat;
    }
    public void setEtat(Section etat) {
        this.etat = etat;
    }

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="mesJobs")
    @XmlTransient
    @JsonIgnoreProperties("mesJobs")
    public List<User> getWorkers() {
        return workers;
    }
    public void setWorkers(List<User> workers) {
        this.workers.addAll(workers);
    }

    public void addWorkers(User user) {
        user.addWork(this);
        this.setWorkers(new ArrayList<User>(){{
            add(user);
        }});
    }
}
