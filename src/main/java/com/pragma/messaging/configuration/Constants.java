package com.pragma.messaging.configuration;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }


    public static final String EMAIL = "email";
    public static final String MESSAGE_BASE_PATH = "/message";
    public static final String MESSAGE_TAG = "Message Management";
    public static final String MESSAGE_DESCRIPTION = "API for sending messages and verifying security codes";

    public static final String MESSAGE_SEND_READY_PATH = "/send-message-ready";
    public static final String MESSAGE_SEND_READY_SUMMARY = "Send ready message";
    public static final String MESSAGE_SEND_READY_DESCRIPTION = "Sends a message when an order is ready";

    public static final String MESSAGE_SEND_CANCELED_PATH = "/send-message-canceled";
    public static final String MESSAGE_SEND_CANCELED_SUMMARY = "Send canceled message";
    public static final String MESSAGE_SEND_CANCELED_DESCRIPTION = "Sends a message when an order is canceled";

    public static final String MESSAGE_VERIFY_SECURITY_CODE_PATH = "/verify-security-code";
    public static final String MESSAGE_VERIFY_SECURITY_CODE_SUMMARY = "Verify security code";
    public static final String MESSAGE_VERIFY_SECURITY_CODE_DESCRIPTION = "Verifies the security code for an order";

    public static final String ORDER_ID_PARAM = "orderId";
    public static final String SECURITY_CODE_PARAM = "securityCode";



}
