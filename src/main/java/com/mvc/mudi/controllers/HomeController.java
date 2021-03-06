package com.mvc.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.mudi.models.Pedido;
import com.mvc.mudi.repositorys.PedidoRepository;

@Controller
public class HomeController {
	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
}
