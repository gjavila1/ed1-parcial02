package ed.lab;

import java.util.*;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) {
            return 0;
        }
        //Primero se ordena
        meetingIntervals.sort(Comparator.comparingInt(a -> a.startTime()));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(meetingIntervals.get(0).endTime());

        //para cuando i sea mayor que meeting interval.size
        int maxRooms = 1;
        for (int i = 1; i < meetingIntervals.size(); i++) {
            MeetingInterval current = meetingIntervals.get(i);
            if (current.startTime() >= heap.peek()) {
                heap.poll();
            }
            heap.offer(current.endTime());
            maxRooms = Math.max(maxRooms, heap.size());
        }
        return maxRooms;
    }
}
