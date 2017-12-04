package entities;

import javax.persistence.*;

@Entity
@Table(name = "Dependent_lives_with_Tennant", schema = "RealEstate", catalog = "")
public class DependentLivesWithTennantEntity {
    private Integer dependentDepId;
    private int tennantSsn;
    private DependentEntity dependentByDependentDepId;
    private TennantEntity tennantByTennantSsn;

    @Basic
    @Column(name = "Dependent_depId", nullable = true)
    public Integer getDependentDepId() {
        return dependentDepId;
    }

    public void setDependentDepId(Integer dependentDepId) {
        this.dependentDepId = dependentDepId;
    }

    @Id
    @Column(name = "Tennant_ssn", nullable = false)
    public int getTennantSsn() {
        return tennantSsn;
    }

    public void setTennantSsn(int tennantSsn) {
        this.tennantSsn = tennantSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependentLivesWithTennantEntity that = (DependentLivesWithTennantEntity) o;

        if (tennantSsn != that.tennantSsn) return false;
        if (dependentDepId != null ? !dependentDepId.equals(that.dependentDepId) : that.dependentDepId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dependentDepId != null ? dependentDepId.hashCode() : 0;
        result = 31 * result + tennantSsn;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Dependent_depId", referencedColumnName = "depId")
    public DependentEntity getDependentByDependentDepId() {
        return dependentByDependentDepId;
    }

    public void setDependentByDependentDepId(DependentEntity dependentByDependentDepId) {
        this.dependentByDependentDepId = dependentByDependentDepId;
    }

    @OneToOne
    @JoinColumn(name = "Tennant_ssn", referencedColumnName = "ssn", nullable = false)
    public TennantEntity getTennantByTennantSsn() {
        return tennantByTennantSsn;
    }

    public void setTennantByTennantSsn(TennantEntity tennantByTennantSsn) {
        this.tennantByTennantSsn = tennantByTennantSsn;
    }
}
