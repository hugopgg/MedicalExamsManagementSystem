package com.inf5153.notification;

/**
 * Interface for objects that can receive notifications.
 */
public interface IListener {

    /**
     * Method called to receive a notification.
     * Implementations define the action to be taken when a notification is received.
     */
    void receiveNotification();
    
}
