
package os_practicals;
/*Task2: Create a TicketSystem class with:
An int ticketsAvailable field initialized to, say, 10.
Two methods:
public void bookTicket(int count) { 

    // Decrease ticketsAvailable by count  

}
public void cancelTicket(int count) { 

    // Increase ticketsAvailable by count  

}
In main, launch at least three threads—each representing a user session—that repeatedly:
Try to book a random number of tickets (1–3)
Sleep briefly (e.g. 50ms)
Then cancel a random number of tickets (1–2)
Log each attempt: thread name, action (book/cancel), tickets requested, and resulting ticketsAvailable
Repeat this loop several times.
After all threads complete (use join()), print the final number of tickets available.
 */

public class Task2 {

    private int ticketsAvailable = 10;

    public synchronized void bookTicket(int count) {
        if (count <= ticketsAvailable) {
            ticketsAvailable -= count;
            System.out.printf("%s booked %d tickets | Tickets available: %d\n", Thread.currentThread().getName(), count, ticketsAvailable);
        } else {
            System.out.printf("%s tried to book %d tickets | Not enough tickets available\n", Thread.currentThread().getName(), count);
        }
    }

    public synchronized void cancelTicket(int count) {
        ticketsAvailable += count;
        System.out.printf("%s cancelled %d tickets | Tickets available: %d\n", Thread.currentThread().getName(), count, ticketsAvailable);
    }

    public static void main(String[] args) {
        task2 ticketSystem = new task2();

        Runnable userSession = () -> {
            for (int i = 0; i < 5; i++) {
                int ticketsToBook = (int) (Math.random() * 3) + 1;
                ticketSystem.bookTicket(ticketsToBook);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int ticketsToCancel = (int) (Math.random() * 2) + 1;
                ticketSystem.cancelTicket(ticketsToCancel);
            }
        };

        Thread user1 = new Thread(userSession, "User 1");
        Thread user2 = new Thread(userSession, "User 2");
        Thread user3 = new Thread(userSession, "User 3");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Final tickets available: %d\n", ticketSystem.ticketsAvailable);
    }

}
