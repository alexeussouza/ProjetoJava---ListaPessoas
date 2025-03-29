package br.com.pessoa.controller;


import br.com.pessoa.model.PessoaModel;
import br.com.pessoa.repository.PessoaRepository;
import br.com.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public ModelAndView listarPessoas(@RequestParam(defaultValue = "0") int pagina) {
        Page<PessoaModel> pessoas = pessoaService.getPessoas(pagina, 5); // 10 registros por página

        System.out.println("numeroPaginas: " + pagina);

        ModelAndView modelAndView = new ModelAndView("relatorioPessoa"); // Define a view

        // Adiciona os atributos ao modelo
        modelAndView.addObject("pessoas", pessoas);
        modelAndView.addObject("paginaAtual", pagina);
        modelAndView.addObject("totalPaginas", pessoas.getTotalPages());

        return modelAndView; // Retorna o ModelAndView
    }

    @PostMapping
    public PessoaModel salvarPessoa(@RequestBody PessoaModel pessoaModel){
        return  pessoaRepository.save(pessoaModel);
    }




}
