package entities;

import javax.persistence.*;

@Entity
@Table(name = "Employee_Works_At_Property", schema = "RealEstate", catalog = "")
@IdClass(EmployeeWorksAtPropertyEntityPK.class)
public class EmployeeWorksAtPropertyEntity {
    private int propertyPropertyId;
    private int propertyTennantSsn;
    private int employeeSsn;
    private EmployeeEntity employeeByEmployeeSsn;

    @Id
    @Column(name = "Property_propertyID")
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Property_Tennant_ssn")
    public int getPropertyTennantSsn() {
        return propertyTennantSsn;
    }

    public void setPropertyTennantSsn(int propertyTennantSsn) {
        this.propertyTennantSsn = propertyTennantSsn;
    }

    @Id
    @Column(name = "Employee_ssn")
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
        if (propertyTennantSsn != that.propertyTennantSsn) return false;
        if (employeeSsn != that.employeeSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyPropertyId;
        result = 31 * result + propertyTennantSsn;
        result = 31 * result + employeeSsn;
        return result;
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
