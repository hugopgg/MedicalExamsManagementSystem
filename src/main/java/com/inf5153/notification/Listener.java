package com.inf5153.notification;

/**
 * Abstract base class for implementing listeners.
 * Implements the IListener interface.
 */
public abstract class Listener implements IListener {

    /**
     * Unimplemented method to receive notifications.
     * Subclasses should override this method to define
     * their specific notification handling behavior.
     *
     * @throws UnsupportedOperationException if the method is called
     */
    @Override
    public void receiveNotification() {
        throw new UnsupportedOperationException("Unimplemented method 'receiveNotification'");
    }

}
