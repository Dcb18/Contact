package br.com.contact.model.enums;

public enum ContactType {
	PHONE(1L),
	EMAIL(2L),
	WHATSAPP(3L);
	
	private Long id;
	
	private ContactType(Long id){
		this.id = id;
		
	}

	public ContactType findValue(Long id) {
		for(ContactType op : ContactType.values()){
			if(op.equals(id)){
				return op;
			}
		}
		return null;
	}
	
	public Long getId() {
		return id;
	}


	
	
	
}
