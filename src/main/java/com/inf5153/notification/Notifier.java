package com.inf5153.notification;

import java.util.ArrayList;

/**
 * Abstract base class for implementing notifiers.
 * Implements the {@link INotifier} interface.
 */
public abstract class Notifier implements INotifier {

    /**
     * List of listeners to notify.
     */
    protected ArrayList<String> listeners;

    /**
     * Retrieves the list of listeners.
     *
     * @return The list of listeners
     */
    public ArrayList<String> getListeners() {
        return listeners;
    }

    /**
     * Unimplemented method to send notifications.
     * Subclasses should override this method to define
     * their specific notification sending behavior.
     *
     * @throws UnsupportedOperationException if the method is called
     */
    @Override
    public void sendNotification() {
        throw new UnsupportedOperationException("Unimplemented method 'sendNotification'");
    }

    /**
     * Unimplemented method to send an SMS notification.
     *
     * @throws UnsupportedOperationException if the method is called
     */
    public void sendSMS() {
        throw new UnsupportedOperationException("Unimplemented method 'sendSMS'");
    }

    /**
     * Unimplemented method to send an email notification.
     *
     * @throws UnsupportedOperationException if the method is called
     */
    public void sendMail() {
        throw new UnsupportedOperationException("Unimplemented method 'sendMail'");
    }

    /**
     * Returns a string representation of the notifier, displaying its
     * attributes.
     *
     * @return A string representation of the notifier
     */
    @Override
    public String toString() {
        return "Notifier [listeners=" + listeners + "]";
    }
}
