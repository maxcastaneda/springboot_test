package mx.com.gm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;


@Controller
@Slf4j
public class ControladorInicio {
	
	@Autowired
	private PersonaDao personaDao;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ControladorInicio.class);

	@Value("${titulo}")
	private String titulo;

	@GetMapping("/")	
	public String Inicio(Model model) {		
		
		log.info("Accediendo a la pagina de inicio...");		

		
		var personas = personaDao.findAll();
		
		model.addAttribute("titulo", titulo);		
		model.addAttribute("personas", personas);
		
		return "index";
	}
	
}
