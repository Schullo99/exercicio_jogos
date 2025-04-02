package br.com.unicuritiba.CadastroJogo.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.RequestEntity.HeadersBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.CadastroJogo.models.Jogo;
import br.com.unicuritiba.CadastroJogo.repositories.JogoRepository;

@RestController
@RequestMapping("/jogo")  // O caminho de base para os endpoints
public class CadastroJogosController {

    @Autowired
    JogoRepository repository;

    // Método GET para buscar todos os jogos
    @GetMapping
    public ResponseEntity<List<Jogo>> getJogos() {
        List<Jogo> jogos = repository.findAll();
        if (jogos.isEmpty()) {
            return ResponseEntity.noContent().build();  // Retorna 204 caso a lista esteja vazia
        }
        return ResponseEntity.ok(jogos);  // Retorna a lista de jogos com status 200
    }

    // Método POST para salvar um novo jogo
    @PostMapping
    public ResponseEntity<Jogo> saveJogo(@RequestBody Jogo jogo) {
        Jogo jogoSalvo = repository.save(jogo);
        return ResponseEntity.status(201).body(jogoSalvo);  // Retorna o jogo salvo com status 201 (Created)
    }

    // Método DELETE para remover um jogo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeJogo(@PathVariable long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o jogo não existir
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();  // Retorna 204 (No Content) após a exclusão
    }

    // Endpoint de Teste para verificar se o controlador está funcionando corretamente
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test successful");
    }
}
