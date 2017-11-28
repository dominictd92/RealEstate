package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PropertyHasExpenseEntityPK implements Serializable {
    private int expenseExpenseId;
    private int propertyPropertyId;
    private int propertyTennantSsn;

    @Column(name = "Expense_expenseId")
    @Id
    public int getExpenseExpenseId() {
        return expenseExpenseId;
    }

    public void setExpenseExpenseId(int expenseExpenseId) {
        this.expenseExpenseId = expenseExpenseId;
    }

    @Column(name = "Property_propertyID")
    @Id
    public int getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(int propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Column(name = "Property_Tennant_ssn")
    @Id
    public int getPropertyTennantSsn() {
        return propertyTennantSsn;
    }

    public void setPropertyTennantSsn(int propertyTennantSsn) {
        this.propertyTennantSsn = propertyTennantSsn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyHasExpenseEntityPK that = (PropertyHasExpenseEntityPK) o;

        if (expenseExpenseId != that.expenseExpenseId) return false;
        if (propertyPropertyId != that.propertyPropertyId) return false;
        if (propertyTennantSsn != that.propertyTennantSsn) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseExpenseId;
        result = 31 * result + propertyPropertyId;
        result = 31 * result + propertyTennantSsn;
        return result;
    }
}
