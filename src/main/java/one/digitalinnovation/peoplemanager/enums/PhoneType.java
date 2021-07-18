package one.digitalinnovation.peoplemanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERIAL("Commercial");

    private final String description;
}
