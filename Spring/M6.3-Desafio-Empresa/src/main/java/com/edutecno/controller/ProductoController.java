package com.edutecno.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edutecno.model.Producto;
import com.edutecno.service.ProductoService;
import com.edutecno.util.Util;
import com.edutecno.vo.ProductoVO;

@Controller
public class ProductoController {	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService svc;
	private int cantPro = 5;

	@GetMapping({ "/home" })
	public String home(Model model, @RequestParam(defaultValue = "1") Integer p) {
		Integer totalPaginas = (int) svc.getPageCount(cantPro).getValor();
		model.addAttribute("paginas", Util.getArregloPaginas(p, totalPaginas));
		model.addAttribute("cantres", cantPro);
		model.addAttribute("paginaActual", p);
		model.addAttribute("VO", svc.getPage(p-1, cantPro));
		return "home";
	}
	
	@PostMapping("/cantidad")
	public ModelAndView cantidad(Model model, @RequestParam(defaultValue = "1") Integer cantprod) {
		if (cantprod < 1) {
			cantprod = 5;
		} else {
			cantPro = cantprod;
		}		
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam String idProducto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		try {
			Integer id = (Integer.parseInt(idProducto));
			respuestaServicio = svc.findById(id);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			model.addAttribute("VO", respuestaServicio.getProductos().get(0));
			return new ModelAndView("editar");
		} catch (Exception e) {
			log.error("Error en UsuarioController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.getAllProductos();
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}
	
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {		
		return "agregar";
	}
	
	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.update(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String idProducto, RedirectAttributes ra) {		
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo eliminar al usuario, intente nuevamente.");
		try {
			Producto eliminado = new Producto();
			eliminado.setIdProducto(Integer.parseInt(idProducto));
			respuestaServicio = svc.delete(eliminado);
			ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en UsuarioController eliminar", e);
		}
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.getAllProductos();
		ra.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/buscar")
	public String agregarSubmit(Model model, @RequestParam String textoBuscado) {
		ProductoVO respuestaServicio = svc.findByNombreContainingIgnoreCase(textoBuscado);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", respuestaServicio);
		return "home";
	}
}
