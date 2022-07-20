package mx.com.cdc.apihub.ve.dto;

import java.util.ArrayList;
import java.util.List;

import mx.com.cdc.apihub.ve.facade.dto.DomicilioFacade;

public class Domicilios {

	List<Domicilio> list;
	
	static Domicilios buildFromFacade(List<DomicilioFacade> facadeList) {
		List<Domicilio> listDomicilio = new ArrayList<>();
		
		for (DomicilioFacade facade : facadeList) {
			listDomicilio.add(Domicilio.buildFromFacade(facade));
		}
		
		Domicilios domicilios = new Domicilios();
		domicilios.list = listDomicilio;
		
		return domicilios;
	}
}
