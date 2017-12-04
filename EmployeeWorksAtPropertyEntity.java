package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Employee_Works_At_Property", schema = "RealEstate", catalog = "")
@IdClass(EmployeeWorksAtPropertyEntityPK.class)
public class EmployeeWorksAtPropertyEntity {
    private int propertyPropertyId;
    private int employeeSsn;
    private Collection<PropertyEntity> propertyByPropertyId;
    private EmployeeEntity employeeByEmployeeSsn;

    public EmployeeWorksAtPropertyEntity(int propertyPropertyId, int employeeSsn) {
        this.propertyPropertyId = propertyPropertyId;
        this.employeeSsn = employeeSsn;
    }

    public EmployeeWorksAtPropertyEntity() {

    }

    @Id
    @Column(name = "Property_propertyID", nullable = false)
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Employee_ssn", nullable = false)
    public int getEmployeeSsn() {
        return employeeSsn;
    }

    public void setEmployeeSsn(int employeeSsn) {
        this.employeeSsn = employeeSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeWorksAtPropertyEntity that = (EmployeeWorksAtPropertyEntity) o;

        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (employeeSsn != that.employeeSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyPropertyId;
        result = 31 * result + employeeSsn;
        return result;
    }

    @OneToMany(mappedBy = "employeeWorksAtPropertyByPropertyId")
    public Collection<PropertyEntity> getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(Collection<PropertyEntity> propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "Employee_ssn", referencedColumnName = "ssn", nullable = false)
    public EmployeeEntity getEmployeeByEmployeeSsn() {
        return employeeByEmployeeSsn;
    }

    public void setEmployeeByEmployeeSsn(EmployeeEntity employeeByEmployeeSsn) {
        this.employeeByEmployeeSsn = employeeByEmployeeSsn;
    }
}
