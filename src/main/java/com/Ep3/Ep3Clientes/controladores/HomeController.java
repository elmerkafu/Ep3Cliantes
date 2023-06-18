package com.Ep3.Ep3Clientes.controladores;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import com.Ep3.Ep3Clientes.servicios.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/home")
public class HomeController {

    private final ClienteService clienteService;
    @GetMapping("")
    public String index(Model model){

        List<Clientes> clientesList = clienteService.obtenerClientes();
        model.addAttribute("clientes", clientesList);
        model.addAttribute("fechaCreacion", LocalDate.now().toString());

        return "index";
    }

    @GetMapping("/actualizar")
    public String actualizar(@RequestParam Long id, Model model) throws Exception{
        model.addAttribute("cliente", clienteService.obtenerPorId(id));
        model.addAttribute("fechaCreacion", LocalDate.now().toString());
        return "actualizar";
    }

    @PostMapping("")
    public String add(@ModelAttribute("cliente") Clientes cliente){
        clienteService.addCliente(cliente);
        return "redirect:/home";
    }

    @PutMapping("")
    public String actualizar(@ModelAttribute("cliente") Clientes cliente){
        clienteService.addCliente(cliente);
        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") Long id){
       clienteService.eliminar(id);
       return "redirect:/home";
    }
}
