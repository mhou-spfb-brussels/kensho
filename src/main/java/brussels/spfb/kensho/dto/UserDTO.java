package brussels.spfb.kensho.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    protected Long id;
    protected String userName;
    protected String password;

}
