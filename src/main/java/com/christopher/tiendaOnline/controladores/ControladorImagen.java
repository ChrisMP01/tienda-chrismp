package com.christopher.tiendaOnline.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.christopher.tiendaOnline.entidades.Imagen;
import com.christopher.tiendaOnline.entidades.Producto;
import com.christopher.tiendaOnline.servicios.ImagenService;
import com.christopher.tiendaOnline.servicios.ProductoService;

@Controller
@RequestMapping(value="/imagenes")
public class ControladorImagen {
	
	@Autowired
	private ImagenService imagenService;
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/cargar/{id_producto}")
	public ModelAndView actualizarFoto(HttpServletRequest request,@PathVariable("id_producto")Long id_producto) {
		
		ModelAndView mav=new ModelAndView();
		Producto producto=productoService.buscarId(id_producto);
		Imagen img=null;
		
		if(!producto.getImagen().isEmpty()) {
			for(Imagen i:producto.getImagen()) {
				img=i;
				break;
			}
		}
		
		mav.addObject("imagen",img);
		mav.addObject("producto",producto);
		mav.setViewName("/imagen/imagen_subir");
		return mav;
	}
	
	@PostMapping("/cargar/{id_producto}")
	public String fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request,
			@PathVariable("id_producto") Long id_producto) {
		try {
			byte[] image = file.getBytes();
			Imagen img = new Imagen("foto", image);
			Boolean saveImage = imagenService.actualizarImagen(id_producto, file);
			if (saveImage) {
				return "redirect:/producto/" + id_producto;
			} else {
				return "redirect:/imagenes/cargar/" + id_producto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/imagenes/cargar/" + id_producto;
		}
	}
		
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity imagenResponseEntity(@PathVariable String id) {
		try {
			Imagen imagesObj=imagenService.obtenerImagen(Long.parseLong(id));
			byte[] media=imagesObj.getImagen();
			HttpHeaders headers=new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			
			ResponseEntity<byte[]> responseEntity=new ResponseEntity<>(media,headers,HttpStatus.OK);
			return responseEntity;
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
