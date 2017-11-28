package entities;

import javax.persistence.*;

@Entity
@Table(name = "Property_has_Expense", schema = "RealEstate", catalog = "")
@IdClass(PropertyHasExpenseEntityPK.class)
public class PropertyHasExpenseEntity {
    private int expenseExpenseId;
    private int propertyPropertyId;
    private int propertyTennantSsn;
    private ExpenseEntity expenseByExpenseExpenseId;
    private PropertyEntity property;

    @Id
    @Column(name = "Expense_expenseId")
    public int getExpenseExpenseId() {
        return expenseExpenseId;
    }

    public void setExpenseExpenseId(int expenseExpenseId) {
        this.expenseExpenseId = expenseExpenseId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyHasExpenseEntity that = (PropertyHasExpenseEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "Expense_expenseId", referencedColumnName = "expenseId", nullable = false)
    public ExpenseEntity getExpenseByExpenseExpenseId() {
        return expenseByExpenseExpenseId;
    }

    public void setExpenseByExpenseExpenseId(ExpenseEntity expenseByExpenseExpenseId) {
        this.expenseByExpenseExpenseId = expenseByExpenseExpenseId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "Property_propertyID", referencedColumnName = "propertyID", nullable = false), @JoinColumn(name = "Property_Tennant_ssn", referencedColumnName = "Tennant_ssn", nullable = false)})
    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }
}
