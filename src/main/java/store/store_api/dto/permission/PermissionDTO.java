package store.store_api.dto.permission;

import jakarta.validation.constraints.NotBlank;

public record PermissionDTO(
        @NotBlank
        String permissionName
) {
}
