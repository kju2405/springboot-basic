package org.prgrms.kdt.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuCommand {
    EXIT("exit"), CREATE("create"), LIST("list"), WRONG("wrong");
    private final String command;
    private static final Map<String, MenuCommand> MENU_COMMAND_MAP = Stream.of(values())
            .collect(Collectors
                    .toMap(menuCommandField -> menuCommandField.command, menuCommandField -> menuCommandField));
    private static final Logger logger = LoggerFactory.getLogger(MenuCommand.class);

    MenuCommand(String command) {
        this.command = command;
    }

    private static boolean validateMenuCommand(String menuCommand) {
        return MENU_COMMAND_MAP.containsKey(menuCommand);
    }

    public static MenuCommand findByUserInputMenuCommand(String menuCommand) {
        if (validateMenuCommand(menuCommand)) {
            return MENU_COMMAND_MAP.get(menuCommand);
        }
        logger.warn("Your inputValue:'{}' is wrong.", menuCommand);
        return WRONG;
    }
}
