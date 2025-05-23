package ed.lab;

import java.util.HashMap;

public class E02Logger {

    private HashMap<String, Integer> messageMap;

    public E02Logger() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message)) {
            messageMap.put(message, timestamp);
            return true;
        } else {
            int lastTimestamp = messageMap.get(message);
            if (timestamp >= lastTimestamp + 10) {
                messageMap.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}