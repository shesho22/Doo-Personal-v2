package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.RegistrarEstadoTipoRelacionInstitucionValidaton;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public class IdentificadorValidation implements Validation<UUID>{
	
	private IdentificadorValidation() {
		super();
	}
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);
	}

	@Override
	public final Result execute(UUID data) {
		var result=Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el idenficiador del estado del tipo relacion institucion vacio...");
		}
		else if(UtilUUID.isDefault(data)) {
			result.addMessage("No es posible tener el identificador por defecto del estado del tipo relacion institucion...");
		}
		return result;
	}
	
}
