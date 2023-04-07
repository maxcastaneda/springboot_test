package mx.com.gm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;


@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired 
	private PersonaService personaService;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ControladorInicio.class);

	@Value("${titulo}")
	private String titulo;

	@GetMapping("/")	
	public String Inicio(Model model) {		
		
		log.info("Accediendo a la pagina de inicio...");				
		var personas = personaService.listarPersonas();
		
		model.addAttribute("titulo", titulo);		
		model.addAttribute("personas", personas);		
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Persona persona) {		
		return "details";
	}
	
	@GetMapping("/editar/{id_persona}")
	public String editar(Persona persona, Model model) {		
		// si la variable recibida, en este caso id_persona, existe como atributo de la clase especificada
		// spring automaticamente busca el setter correspondiente, y asigna el valor recibido al atributo
		// creando un objeto nuevo con este valor.
		
		log.info("id recibido:" + persona.getId_persona());
		persona = personaService.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "details";
	}	
	
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		persona = personaService.encontrarPersona(persona);
		personaService.eliminar(persona);
		return "redirect:/"; // enviar a la pagina de inicio
	}	
	
	@PostMapping("/guardar")
	public String guardar(Persona persona) {
		personaService.guardar(persona);
		return "redirect:/"; // enviar a la pagina de inicio
	} 
	
}
