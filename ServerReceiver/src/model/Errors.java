package model;

/**
 * The list of available error
 * @author riza
 */
public enum Errors {
    UNKNOWN,
    CONNECTION_ERROR,
    WORKER_RUN,
    SOCKET_LISTENING,
    TAKING_REQUEST,
    WRITING_RESPONSE,
    ERROR_CLOSING_SOCKET,
    GET_CAPACITY_FAILED,
    GET_FAIRNESS_FAILED,
    GET_THREADNUMBER_FAILED,
    CREATE_THREAD_FAILED,
    READ_SOCKET,
    INITIALIZE_QUEUE,
    GET_MESSAGE_FROM_SOCKET,
    GET_MAINTAINCONNECTION_FAILED,
    MAINTAINED_SOCKET_ERROR,
    CONNECT_TO_DB,
    CREATE_STATEMENT_FAIL,
    GET_MYSQL_USER_FAIL,
    GET_MYSQL_PASS_FAIL,
    GET_MYSQL_HOST_FAIL,
    GET_MYSQL_PORT_FAIL,
    GET_MYSQL_NAME_FAIL;
}
