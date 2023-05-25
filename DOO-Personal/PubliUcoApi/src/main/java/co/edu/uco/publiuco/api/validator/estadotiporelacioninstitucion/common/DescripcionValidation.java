package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;

public class DescripcionValidation implements Validation<String>{

	private DescripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	
	@Override
	public Result execute(String data) {
		var result=Result.create();
		
		if(true) //validar longitud de la cadenano supere 250
		{
			result.addMessage("La descripcion del estado del tipo relacion institucion no debe ser mayor a las 250 caracteres...");
		}
		return result;
	}
}
