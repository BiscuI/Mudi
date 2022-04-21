package com.mvc.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.mudi.models.Pedido;
import com.mvc.mudi.models.StatusPedido;
import com.mvc.mudi.repositorys.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError(){
		return "redirect:/home";
	}
}
