package com.inf5153.notification;

/**
 * Interface for objects that can send notifications.
 */
public interface INotifier {

    /**
     * Method called to send a notification.
     * Implementations define how notifications are sent.
     */
    void sendNotification();
    
}
