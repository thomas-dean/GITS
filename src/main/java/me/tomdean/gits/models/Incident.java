package me.tomdean.gits.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "incident", schema = "gits")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_on_site")
    private Date dateOnSite;
    @Column(name = "date_created")
    private Date dateCreated;
    @Column(name = "date_cleaned_up")
    private Date dateCleanedUp;
    @ManyToOne
    private CleanupEffort effort;
    @JoinColumn(name = "amount_of_damage_id")
    @ManyToOne
    private Damage amountOfDamage;
    @JoinColumn(name = "investigation_status_id")
    @ManyToOne
    private InvestigationStatus investigationStatus;
    @ManyToOne
    private Structure structure;
    private String address;
    @Column(name = "nearest_cross_streets")
    private String nearestCrossStreets;
    private double latitude;
    private double longitude;
    private String moniker;
    @ManyToOne
    private User submitter;
    @JoinColumn(name = "law_enforcement_official_id")
    @ManyToOne
    private User lawEnforcementOfficial;
    @ManyToOne
    private Crew crew;
    @ManyToMany
    @JoinTable(name = "incident_suspects", schema = "gits")
    private Set<Suspect> suspects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOnSite() {
        return dateOnSite;
    }

    public void setDateOnSite(Date dateOnSite) {
        this.dateOnSite = dateOnSite;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateCleanedUp() {
        return dateCleanedUp;
    }

    public void setDateCleanedUp(Date dateCleanedUp) {
        this.dateCleanedUp = dateCleanedUp;
    }

    public CleanupEffort getEffort() {
        return effort;
    }

    public void setEffort(CleanupEffort effort) {
        this.effort = effort;
    }

    public Damage getAmountOfDamage() {
        return amountOfDamage;
    }

    public void setAmountOfDamage(Damage ammountOfDamage) {
        this.amountOfDamage = ammountOfDamage;
    }

    public InvestigationStatus getInvestigationStatus() {
        return investigationStatus;
    }

    public void setInvestigationStatus(InvestigationStatus investigationStatus) {
        this.investigationStatus = investigationStatus;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearestCrossStreets() {
        return nearestCrossStreets;
    }

    public void setNearestCrossStreets(String nearestCrossStreets) {
        this.nearestCrossStreets = nearestCrossStreets;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMoniker() {
        return moniker;
    }

    public void setMoniker(String moniker) {
        this.moniker = moniker;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    public User getLawEnforcementOfficial() {
        return lawEnforcementOfficial;
    }

    public void setLawEnforcementOfficial(User lawEnforcementOfficial) {
        this.lawEnforcementOfficial = lawEnforcementOfficial;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Set<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(Set<Suspect> suspects) {
        this.suspects = suspects;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", dateOnSite=" + dateOnSite +
                ", dateCreated=" + dateCreated +
                ", dateCleanedUp=" + dateCleanedUp +
                ", effort=" + effort +
                ", amountOfDamage=" + amountOfDamage +
                ", investigationStatus=" + investigationStatus +
                ", structure=" + structure +
                ", address='" + address + '\'' +
                ", nearestCrossStreets='" + nearestCrossStreets + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", moniker='" + moniker + '\'' +
                ", submitter=" + submitter +
                ", lawEnforcementOfficial=" + lawEnforcementOfficial +
                ", crew=" + crew +
                ", suspects=" + suspects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Incident incident = (Incident) o;

        if (Double.compare(incident.getLatitude(), getLatitude()) != 0) return false;
        if (Double.compare(incident.getLongitude(), getLongitude()) != 0) return false;
        if (getId() != null ? !getId().equals(incident.getId()) : incident.getId() != null) return false;
        if (getDateOnSite() != null ? !getDateOnSite().equals(incident.getDateOnSite()) : incident.getDateOnSite() != null)
            return false;
        if (getDateCreated() != null ? !getDateCreated().equals(incident.getDateCreated()) : incident.getDateCreated() != null)
            return false;
        if (getDateCleanedUp() != null ? !getDateCleanedUp().equals(incident.getDateCleanedUp()) : incident.getDateCleanedUp() != null)
            return false;
        if (getEffort() != null ? !getEffort().equals(incident.getEffort()) : incident.getEffort() != null)
            return false;
        if (getAmountOfDamage() != null ? !getAmountOfDamage().equals(incident.getAmountOfDamage()) : incident.getAmountOfDamage() != null)
            return false;
        if (getInvestigationStatus() != null ? !getInvestigationStatus().equals(incident.getInvestigationStatus()) : incident.getInvestigationStatus() != null)
            return false;
        if (getStructure() != null ? !getStructure().equals(incident.getStructure()) : incident.getStructure() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(incident.getAddress()) : incident.getAddress() != null)
            return false;
        if (getNearestCrossStreets() != null ? !getNearestCrossStreets().equals(incident.getNearestCrossStreets()) : incident.getNearestCrossStreets() != null)
            return false;
        if (getMoniker() != null ? !getMoniker().equals(incident.getMoniker()) : incident.getMoniker() != null)
            return false;
        if (getSubmitter() != null ? !getSubmitter().equals(incident.getSubmitter()) : incident.getSubmitter() != null)
            return false;
        if (getLawEnforcementOfficial() != null ? !getLawEnforcementOfficial().equals(incident.getLawEnforcementOfficial()) : incident.getLawEnforcementOfficial() != null)
            return false;
        if (getCrew() != null ? !getCrew().equals(incident.getCrew()) : incident.getCrew() != null) return false;
        return getSuspects() != null ? getSuspects().equals(incident.getSuspects()) : incident.getSuspects() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDateOnSite() != null ? getDateOnSite().hashCode() : 0);
        result = 31 * result + (getDateCreated() != null ? getDateCreated().hashCode() : 0);
        result = 31 * result + (getDateCleanedUp() != null ? getDateCleanedUp().hashCode() : 0);
        result = 31 * result + (getEffort() != null ? getEffort().hashCode() : 0);
        result = 31 * result + (getAmountOfDamage() != null ? getAmountOfDamage().hashCode() : 0);
        result = 31 * result + (getInvestigationStatus() != null ? getInvestigationStatus().hashCode() : 0);
        result = 31 * result + (getStructure() != null ? getStructure().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getNearestCrossStreets() != null ? getNearestCrossStreets().hashCode() : 0);
        temp = Double.doubleToLongBits(getLatitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getMoniker() != null ? getMoniker().hashCode() : 0);
        result = 31 * result + (getSubmitter() != null ? getSubmitter().hashCode() : 0);
        result = 31 * result + (getLawEnforcementOfficial() != null ? getLawEnforcementOfficial().hashCode() : 0);
        result = 31 * result + (getCrew() != null ? getCrew().hashCode() : 0);
        result = 31 * result + (getSuspects() != null ? getSuspects().hashCode() : 0);
        return result;
    }
}
