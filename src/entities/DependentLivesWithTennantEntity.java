package entities;

import javax.persistence.*;

@Entity
@Table(name = "Dependent_lives_with_Tennant", schema = "RealEstate", catalog = "")
public class DependentLivesWithTennantEntity {
    private int tennantSsn;
    private DependentEntity dependentByDependentDepId;

    @Id
    @Column(name = "Tennant_ssn")
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

        return true;
    }

    @Override
    public int hashCode() {
        return tennantSsn;
    }

    @ManyToOne
    @JoinColumn(name = "Dependent_depId", referencedColumnName = "depId")
    public DependentEntity getDependentByDependentDepId() {
        return dependentByDependentDepId;
    }

    public void setDependentByDependentDepId(DependentEntity dependentByDependentDepId) {
        this.dependentByDependentDepId = dependentByDependentDepId;
    }
}
