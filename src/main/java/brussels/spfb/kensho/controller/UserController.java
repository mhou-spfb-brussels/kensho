package brussels.spfb.kensho.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import brussels.spfb.kensho.client.TrombiClient;
import brussels.spfb.kensho.dto.UserDTO;
import lombok.NonNull;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    protected TrombiClient trombiClient;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Long, Optional<UserDTO>>> getUsersByIds(
            @NonNull @RequestParam List<Long> id) {
        return ResponseEntity.ok(trombiClient.getUsersByIds(id));
    }

}
