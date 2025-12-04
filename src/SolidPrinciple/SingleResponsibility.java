package SolidPrinciple;
// A class should be responsible for single operation.

// problem
class Invoice{
    public void calculation(){}
    void generateInvoice(){}
    void print(){}
}

// solution
class Calculation{
    void calculateBill(){}
}

 class InvoiceGenerator{
    void generatorInvoice(){}
}

 class Print{
    void print(){}
}

public class SingleResponsibility {
    public static void main(String args[]){
        Calculation cal = new Calculation();
        InvoiceGenerator generator = new InvoiceGenerator();
        Print print = new Print();
}
}
