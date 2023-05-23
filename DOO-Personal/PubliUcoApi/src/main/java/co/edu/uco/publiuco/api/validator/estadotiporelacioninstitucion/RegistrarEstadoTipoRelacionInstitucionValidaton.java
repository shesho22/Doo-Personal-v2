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
		// TODO Auto-generated method stub
		return null;
	}

} 
