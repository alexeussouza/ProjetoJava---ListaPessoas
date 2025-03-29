package br.com.pessoa.service;

import br.com.pessoa.model.PessoaModel;
import br.com.pessoa.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Page<PessoaModel> getPessoas(int pagina, int tamanho) {
        return pessoaRepository.findAll(PageRequest.of(pagina, tamanho));
    }
}
