package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.estadotiporelacioninstitucion.RegistrarEstadoTipoRelacionInstitucionValidaton;
import co.edu.uco.publiuco.business.facade.impl.EstadoTipoRelacionInstitucionFacadeImpl;
import co.edu.uco.publiuco.business.facade.EstadoTipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoApiException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	private EstadoTipoRelacionInstitucionFacade facade;

	private EstadoTipoRelacionInstitucionController(){
		facade = new EstadoTipoRelacionInstitucionFacadeImpl();
	}

	@GetMapping("/dummy")
	public EstadoTipoRelacionInstitucionDTO dummy() {
		return EstadoTipoRelacionInstitucionDTO.crete();
	}

	@GetMapping
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> list(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		List<EstadoTipoRelacionInstitucionDTO> list = new ArrayList<>();
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		list.add(EstadoTipoRelacionInstitucionDTO.crete());
		
		List<String> messages = new ArrayList<>();
		Messages.add("Estados de tipos de relacion institucion consuiltados exitosamente");
		
		Response<EstadoTipoRelacionInstitucionDTO> response = new Response<>(list,messages);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id) {
		
	
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}
	
	@PostMapping
	public ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>> create(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		
		var statusCode=HttpStatus.OK;
		var response= new Response<EstadoTipoRelacionInstitucionDTO>();
		try {
			var result= RegistrarEstadoTipoRelacionInstitucionValidaton.validate(dto);
			
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("El nuevo estado tipo relacion institucion se ha registrado de forma satisfactoria");
			}else {
				statusCode=HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch(final PubliUcoException exception) {
			statusCode=HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
		}catch(final Exception exception) {
			statusCode=HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor intentar de nuevo y si el problema persiste, contacte al administrador de la aplicacion...");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		return new ResponseEntity<>(response,statusCode);
	}
	
	@PutMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id,@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		return dto.setIdenficador(id);
	}
	
	@DeleteMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO update(@PathVariable UUID id) {
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}
	
	

}
