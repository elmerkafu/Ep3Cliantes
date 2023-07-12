package com.Ep3.Ep3Clientes.controladores;

import com.Ep3.Ep3Clientes.entidades.Visitas;
import com.Ep3.Ep3Clientes.servicios.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/home")
public class HomeController {

    private final ClienteService clienteService;
    @GetMapping("")
    public String index(Model model){

        List<Visitas> visitasList = clienteService.obtenerVisitas();
        model.addAttribute("visita", visitasList);
        model.addAttribute("fechaCreacion", LocalDate.now().toString());

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaConFormato =now.format(formatter);

        model.addAttribute("horaActual", horaConFormato);

        return "index";
    }

    @GetMapping("/actualizar")
    public String actualizar(@RequestParam Long id, Model model) throws Exception{
        model.addAttribute("visita", clienteService.obtenerPorIdVisitas(id));
        model.addAttribute("fechaCreacion", LocalDate.now().toString());
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaConFormato =now.format(formatter);

        model.addAttribute("horaActual", horaConFormato);
        return "actualizar";
    }

    @PostMapping("")
    public String add(@ModelAttribute("visita") Visitas visita){
        clienteService.addVisita(visita);
        return "redirect:/home";
    }

    @PutMapping("")
    public String actualizar(@ModelAttribute("visita") Visitas visita){
        clienteService.addVisita(visita);
        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") Long id){
       clienteService.eliminarVisita(id);
       return "redirect:/home";
    }
}
