package brussels.spfb.kensho.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import brussels.spfb.kensho.model.FollowUp;
import brussels.spfb.kensho.repository.FollowUpRepository;
import lombok.NonNull;

@RestController
@RequestMapping("api/followups")
public class FollowUpController {

    protected FollowUpRepository followUpRepository;

    public FollowUpController(FollowUpRepository followUpRepository) {
        this.followUpRepository = followUpRepository;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FollowUp> getFollowUpById(@NonNull @PathVariable Long id) {
        return followUpRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
