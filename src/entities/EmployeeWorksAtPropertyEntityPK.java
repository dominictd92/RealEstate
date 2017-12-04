package RealEstate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployeeWorksAtPropertyEntityPK implements Serializable {
    private int propertyPropertyId;
    private int employeeSsn;

    @Column(name = "Property_propertyID", nullable = false)
    @Id
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Column(name = "Employee_ssn", nullable = false)
    @Id
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

        EmployeeWorksAtPropertyEntityPK that = (EmployeeWorksAtPropertyEntityPK) o;

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
}
