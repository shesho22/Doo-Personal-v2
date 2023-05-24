package co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class RegistrarEstadoTipoRelacionInstitucionValidaton implements Validation<EstadoTipoRelacionInstitucionDTO>{
	
	private RegistrarEstadoTipoRelacionInstitucionValidaton() {
		super();
	}
	
	public static final Result validate(final EstadoTipoRelacionInstitucionDTO data) {
		return new RegistrarEstadoTipoRelacionInstitucionValidaton().execute(data);
	}

	@Override
	public final Result execute(final EstadoTipoRelacionInstitucionDTO data) {
		var result=Result.create();

		if(UtilObject.isNull(data)){
			result.addMessage("No es posible registrar un nuevo estado tipo relacion institucion con los datos vacios...")
		}else{
		result.addMessage(NombreValidation.validate(data.getNombre()).getMessages());
		result.addMessage(DescripcionValidation.validate(data.getDescripcion()).getMessages())
		}
		return result;
	}

} 
