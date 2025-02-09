package org.prgrms.kdt.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VoucherCommand {
    FIXED_AMOUNT("fixedAmount"), PERCENT_DISCOUNT("percentDiscount"), WRONG("wrong");
    private final String voucherCommand;
    private static final Map<String, VoucherCommand> VOUCHER_COMMAND_MAP = Stream.of(values()).collect(Collectors.toMap(v -> v.voucherCommand, v -> v));
    private static final Logger logger = LoggerFactory.getLogger(VoucherCommand.class);

    VoucherCommand(String voucherCommand) {
        this.voucherCommand = voucherCommand;
    }

    private static boolean validateVoucherCommand(String voucherCommand) {
        return VOUCHER_COMMAND_MAP.containsKey(voucherCommand);
    }

    public static VoucherCommand findByUserInputVoucherCommand(String voucherCommand) {
        if (validateVoucherCommand(voucherCommand)) {
            return VOUCHER_COMMAND_MAP.get(voucherCommand);
        }
        logger.warn("Your inputValue:'{}' is wrong.",voucherCommand);
        return WRONG;
    }
}
