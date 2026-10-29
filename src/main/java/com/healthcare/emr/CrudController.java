package com.healthcare.emr;

import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import java.util.List;

/** Generic REST CRUD shared by all resources. */
public abstract class CrudController<T> {
    private final JpaRepository<T, Long> repo;
    protected CrudController(JpaRepository<T, Long> repo) { this.repo = repo; }

    @org.springframework.web.bind.annotation.GetMapping
    public List<T> all() { return repo.findAll(); }

    @org.springframework.web.bind.annotation.GetMapping("/{id}")
    public ResponseEntity<T> one(@org.springframework.web.bind.annotation.PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @org.springframework.web.bind.annotation.PostMapping
    public T create(@Valid @org.springframework.web.bind.annotation.RequestBody T body) { return repo.save(body); }

    @org.springframework.web.bind.annotation.PutMapping("/{id}")
    public ResponseEntity<T> update(@org.springframework.web.bind.annotation.PathVariable Long id,
                                    @Valid @org.springframework.web.bind.annotation.RequestBody T body) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        try {
            body.getClass().getField("id").set(body, id);
        } catch (ReflectiveOperationException e) { throw new IllegalStateException(e); }
        return ResponseEntity.ok(repo.save(body));
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@org.springframework.web.bind.annotation.PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
