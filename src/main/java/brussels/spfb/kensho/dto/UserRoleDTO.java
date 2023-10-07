package brussels.spfb.kensho.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleDTO {

    protected Long id;
    protected UserDTO user;
    protected Long role;

}
