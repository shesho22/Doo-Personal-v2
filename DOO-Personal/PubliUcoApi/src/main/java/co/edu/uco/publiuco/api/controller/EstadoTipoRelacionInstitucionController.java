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
import co.edu.uco.publiuco.crosscutting.utils.Messages;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/estadotiporelacioninstitucion")
public final class EstadoTipoRelacionInstitucionController {

	private Logger log=LoggerFactory.getLooger(EstadoTipoRelacionInstitucionController.class)

	private EstadoTipoRelacionInstitucionFacade facade;

	private EstadoTipoRelacionInstitucionController(){
		try{
			facade new EstadoTipoRelacionInstitucionFacadeImpl();
		}catch(final PubliUcoApiException exception){
			log.error(exception.getType().toString(.concat("-").concat(exception.getTechnicalMessage(""))))
		}
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
		
		List<String> messages = new ArrayList<>();
		Messages.add("Estados de tipos de relacion institucion consuiltados exitosamente");
		
		Response<EstadoTipoRelacionInstitucionDTO> response = new Response<>(list,messages);
		
		return new ResponseEntity<Response<EstadoTipoRelacionInstitucionDTO>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EstadoTipoRelacionInstitucionDTO listById(@PathVariable UUID id) {
		
	
		return EstadoTipoRelacionInstitucionDTO.crete().setIdenficador(id);
	}
	
	@PostMapping
	public EstadoTipoRelacionInstitucionDTO create(@RequestParam EstadoTipoRelacionInstitucionDTO dto) {
		var statusCode= HttpStatus.OK;
		try{
			var result=RegistrarEstadoTipoRelacionInstitucionValidaton.validate(dto)
		}catch(final PubliUcoException exception){
			statusCode=HttpStatus.
		}catch(final Exception exception){
			statusCode=HttpStatus.
		}
		return dto;
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
