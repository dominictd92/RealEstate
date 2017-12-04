package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Property_has_Expense", schema = "RealEstate", catalog = "")
public class PropertyHasExpenseEntity {
    private Integer expenseExpenseId;
    private Integer propertyPropertyId;
    private int propertyExpenseId;
    private ExpenseEntity expenseByExpenseExpenseId;
    private Collection<PropertyEntity> propertyByPropertyId;

    public PropertyHasExpenseEntity(Integer expenseExpenseId, Integer propertyPropertyId, int propertyExpenseId) {
        this.expenseExpenseId = expenseExpenseId;
        this.propertyPropertyId = propertyPropertyId;
        this.propertyExpenseId = propertyExpenseId;
    }

    public PropertyHasExpenseEntity() {

    }

    @Basic
    @Column(name = "Expense_expenseId", nullable = true)
    public Integer getExpenseExpenseId() {
        return expenseExpenseId;
    }

    public void setExpenseExpenseId(Integer expenseExpenseId) {
        this.expenseExpenseId = expenseExpenseId;
    }

    @Basic
    @Column(name = "Property_propertyID", nullable = true)
    public Integer getPropertyPropertyId() {
        return propertyPropertyId;
    }

    public void setPropertyPropertyId(Integer propertyPropertyId) {
        this.propertyPropertyId = propertyPropertyId;
    }

    @Id
    @Column(name = "Property_ExpenseID", nullable = false)
    public int getPropertyExpenseId() {
        return propertyExpenseId;
    }

    public void setPropertyExpenseId(int propertyExpenseId) {
        this.propertyExpenseId = propertyExpenseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyHasExpenseEntity that = (PropertyHasExpenseEntity) o;

        if (propertyExpenseId != that.propertyExpenseId) return false;
        if (expenseExpenseId != null ? !expenseExpenseId.equals(that.expenseExpenseId) : that.expenseExpenseId != null)
            return false;
        if (propertyPropertyId != null ? !propertyPropertyId.equals(that.propertyPropertyId) : that.propertyPropertyId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseExpenseId != null ? expenseExpenseId.hashCode() : 0;
        result = 31 * result + (propertyPropertyId != null ? propertyPropertyId.hashCode() : 0);
        result = 31 * result + propertyExpenseId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Expense_expenseId", referencedColumnName = "expenseId")
    public ExpenseEntity getExpenseByExpenseExpenseId() {
        return expenseByExpenseExpenseId;
    }

    public void setExpenseByExpenseExpenseId(ExpenseEntity expenseByExpenseExpenseId) {
        this.expenseByExpenseExpenseId = expenseByExpenseExpenseId;
    }

    @OneToMany(mappedBy = "propertyHasExpenseByPropertyId")
    public Collection<PropertyEntity> getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(Collection<PropertyEntity> propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }
}
