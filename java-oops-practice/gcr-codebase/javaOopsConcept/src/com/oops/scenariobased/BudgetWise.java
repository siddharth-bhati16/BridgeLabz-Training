package com.oops.scenariobased;


import java.time.LocalDate;
import java.util.*;

interface IAnalyzable {
    void generateReport();
    void detectOverspend();
}

class Transactions {
    private double amount;
    private String type;     
    private LocalDate date;
    private String category;

    public Transactions(double amount, String type, LocalDate date, String category) {
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }
}

class Budget {
    protected double income;
    protected double limit;
    protected Map<String, Double> categoryLimits;
    protected List<Transactions> transactions;

    public Budget(double income, double limit, Map<String, Double> categoryLimits) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = categoryLimits;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    protected double getTotalExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("EXPENSE")) {
                total += t.getAmount();
            }
        }
        return total;
    }

    public double calculateNetSavings() {
        return income - getTotalExpenses();
    }
}

class MonthlyBudget extends Budget implements IAnalyzable {

    public MonthlyBudget(double income, double limit, Map<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Monthly Budget Report ---");
        System.out.println("Income: " + income);
        System.out.println("Total Expenses: " + getTotalExpenses());
        System.out.println("Net Savings: " + calculateNetSavings());
    }

    @Override
    public void detectOverspend() {
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("EXPENSE")) {
                double catLimit = categoryLimits.getOrDefault(t.getCategory(), Double.MAX_VALUE);
                if (t.getAmount() > catLimit) {
                    System.out.println("Overspend in category: " + t.getCategory());
                }
            }
        }
    }
}

class AnnualBudget extends Budget implements IAnalyzable {

    public AnnualBudget(double income, double limit, Map<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("\n=== Annual Budget Report ===");
        System.out.println("Annual Income: " + income);
        System.out.println("Annual Expenses: " + getTotalExpenses());
        System.out.println("Annual Savings: " + calculateNetSavings());
    }

    @Override
    public void detectOverspend() {
        if (getTotalExpenses() > limit) {
            System.out.println("WARNING: Annual budget limit exceeded!");
        }
    }
}

public class BudgetWise {
    public static void main(String[] args) {

        Map<String, Double> categoryLimits = new HashMap<>();
        categoryLimits.put("Food", 500.0);
        categoryLimits.put("Rent", 1200.0);
        categoryLimits.put("Entertainment", 300.0);

        IAnalyzable budget = new MonthlyBudget(3000, 2500, categoryLimits);

        MonthlyBudget mb = (MonthlyBudget) budget;
        mb.addTransactions(new Transactions(600, "EXPENSE", LocalDate.now(), "Food"));
        mb.addTransactions(new Transactions(1200, "EXPENSE", LocalDate.now(), "Rent"));

        budget.generateReport();
        budget.detectOverspend();

        IAnalyzable annual = new AnnualBudget(36000, 30000, categoryLimits);
        AnnualBudget ab = (AnnualBudget) annual;
        ab.addTransactions(new Transactions(32000, "EXPENSE", LocalDate.now(), "All"));

        annual.generateReport();
        annual.detectOverspend();
    }
}
