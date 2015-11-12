package logic;

import entity.persons.Customer;

public class InvoiceLogic {
	
	public InvoiceLogic() {}
	
	public String getInvoice(Customer customer) {
		String invoiceFinal = "";
		for (int i=0; customer.invoices.get(customer.currentInvoice).payments.size()>i; i++) {
			invoiceFinal += i+": "+customer.invoices.get(customer.currentInvoice).payments.get(i).toString() + "\n";
		}
		return "Customer: "+customer.getName()+"\t Phonenumber: "+customer.getPhonenumber()+
				"\n"+invoiceFinal;
				
	}

}
