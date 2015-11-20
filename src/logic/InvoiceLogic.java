package logic;

import entity.persons.Customer;

public class InvoiceLogic {
	
	public InvoiceLogic() {}
	public String getInvoice(Customer customer) {
		String invoiceFinal = "";
		for (int i=0; customer.getInvoice().getPayments().size()>i; i++) {
			invoiceFinal += (i+1)+": "+customer.getInvoice().getPayments().get(i).toString()+"kr." + "\n";
		}
		return "Customer: "+customer.getName()+"\t Phonenumber: "+customer.getPhonenumber()+
				"\n"+invoiceFinal+"\n \n"+
				"Total price: "+getTotal(customer);
	}
	public double getTotal(Customer customer) {
		double price=0;
		for (int i=0; customer.getInvoice().getPayments().size()>i; i++) {
			price += customer.getInvoice().getPrice(i);
		}
		return price;
	}
}
