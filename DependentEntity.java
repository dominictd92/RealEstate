package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Dependent", schema = "RealEstate", catalog = "")
public class DependentEntity {
    private int depId;
    private String fName;
    private String mName;
    private String lName;
    private Timestamp birthDate;
    private Collection<DependentLivesWithTennantEntity> dependentLivesWithTennantsByDepId;

    public DependentEntity() {

    }

    public DependentEntity(int depId, String fName, String mName, String lName, Timestamp birthDate, Collection<DependentLivesWithTennantEntity> dependentLivesWithTennantsByDepId) {

        this.depId = depId;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.dependentLivesWithTennantsByDepId = dependentLivesWithTennantsByDepId;
    }

    public DependentEntity(int depId, String fName, String mName, String lName) {

        this.depId = depId;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    @Id
    @Column(name = "depId", nullable = false)
    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "f_name", nullable = true, length = 45)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "m_name", nullable = true, length = 45)
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "l_name", nullable = true, length = 45)
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "birthDate", nullable = true)
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DependentEntity that = (DependentEntity) o;

        if (depId != that.depId) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (mName != null ? !mName.equals(that.mName) : that.mName != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depId;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dependentByDependentDepId")
    public Collection<DependentLivesWithTennantEntity> getDependentLivesWithTennantsByDepId() {
        return dependentLivesWithTennantsByDepId;
    }

    public void setDependentLivesWithTennantsByDepId(Collection<DependentLivesWithTennantEntity> dependentLivesWithTennantsByDepId) {
        this.dependentLivesWithTennantsByDepId = dependentLivesWithTennantsByDepId;
    }
}
