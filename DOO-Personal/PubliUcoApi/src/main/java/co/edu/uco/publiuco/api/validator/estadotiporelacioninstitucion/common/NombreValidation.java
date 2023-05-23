package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public class NombreValidation implements Validation<String>{

	private NombreValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);
	}
	
	@Override
	public Result execute(String data) {
		// TODO Auto-generated method stub
		return null;
	}
}
