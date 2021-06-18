package NexosForm.NexosForm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.Value;

@Controller
@RequestMapping("productos")
public class ProductoController {
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@Autowired
	private ProductoService productoService;
	
	@GetMapping(value = "/lista")
	public String listar(Model model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("productos", productoService.obtenerTodosProductos());

		return "lista";
	}
	
	@GetMapping("/crear")
	public String crear(Map<String, Object> model) {
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", nombreAplicacion);
		
		return "formulario";
	}
	
	@PostMapping(value="/guardar")
	public String guardar(Producto producto, Model model) {
		productoService.guardar(producto);
		
		return "redirect:lista";
	}
	
	
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Integer idProducto) {
		productoService.eliminar(idProducto);

		return "redirect:../lista";
	}

}