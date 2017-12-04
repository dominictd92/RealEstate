package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "Expense", schema = "RealEstate", catalog = "")
public class ExpenseEntity {
    private int expenseId;
    private BigDecimal cost;
    private String expense;
    private Collection<PropertyHasExpenseEntity> propertyHasExpensesByExpenseId;

    @Id
    @Column(name = "expenseId", nullable = false)
    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    @Basic
    @Column(name = "cost", nullable = true, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "expense", nullable = true, length = 45)
    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseEntity that = (ExpenseEntity) o;

        if (expenseId != that.expenseId) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (expense != null ? !expense.equals(that.expense) : that.expense != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expenseId;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (expense != null ? expense.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "expenseByExpenseExpenseId")
    public Collection<PropertyHasExpenseEntity> getPropertyHasExpensesByExpenseId() {
        return propertyHasExpensesByExpenseId;
    }

    public void setPropertyHasExpensesByExpenseId(Collection<PropertyHasExpenseEntity> propertyHasExpensesByExpenseId) {
        this.propertyHasExpensesByExpenseId = propertyHasExpensesByExpenseId;
    }
}
