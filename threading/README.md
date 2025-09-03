# Java Multithreading Interview Questions  
*(10+ Years Experience — Team Lead Level)*

This document covers core concepts, scenario-based, and high-level design questions for advanced Java multithreading interviews, plus practical coding practice questions.

---

## 🔹 Core Conceptual Questions

1. **What is the difference between Thread and Runnable? Which one should be preferred and why?**
2. **What are different ways to create a thread in Java?**
   - Thread class
   - Runnable interface
   - Callable + Future
   - ExecutorService
   - ForkJoinPool
3. **What is the difference between synchronized method and block? When would you use each?**
4. **What are daemon threads? Can you force JVM to wait for daemon threads?**
5. **What is the difference between wait(), notify(), and notifyAll()?**
6. **What is the role of volatile keyword? Can it replace synchronized?**
7. **What is the Java Memory Model (JMM)? How does it affect visibility and ordering in multithreading?**
8. **What is the difference between ReentrantLock and synchronized? Which one would you choose and why?**
9. **What are atomic operations in Java? How do you achieve atomicity?**
10. **What is a deadlock? How can it be prevented or detected in Java?**
11. **What are thread starvation and livelock? How do they differ from deadlock?**
12. **What are thread-safe collections in Java? When would you use ConcurrentHashMap over Collections.synchronizedMap()?**
13. **What is the ThreadLocal class? Use cases?**
14. **What is the difference between Callable and Runnable?**
15. **Explain the usage of Future and CompletableFuture.**
16. **What is the ExecutorService? How does it manage threads?**
17. **What are the different types of thread pools in Java? (newFixedThreadPool, cachedThreadPool, etc.)**
18. **How does ForkJoinPool work? When should it be used?**
19. **How does Java handle interrupting threads? How do you implement cooperative cancellation?**
20. **What is the difference between invokeAll() and invokeAny() in ExecutorService?**

---

## 🔹 Scenario-Based Multithreading Questions

21. **You have a shared cache accessed by multiple threads. How do you ensure safe access and good performance?**  
   *Discuss ConcurrentHashMap, ReadWriteLock, or AtomicReference.*

22. **You have 5 tasks that need to run in parallel. Once they are complete, execute a final task. How would you implement this?**  
   *Use CountDownLatch or CompletableFuture.allOf().*

23. **You have two threads: Thread A and Thread B. B must wait until A finishes a specific task. How do you coordinate them?**  
   *CountDownLatch, join(), or wait/notify.*

24. **How would you implement a producer-consumer model in Java?**  
   *Use BlockingQueue or low-level wait/notify with synchronized.*

25. **How do you prevent thread contention when multiple threads write to a log file?**  
   *Use BlockingQueue with a single writer thread, or Logger with async handlers.*

26. **You need to retry a failed API call asynchronously, up to 3 times. How do you implement it?**  
   *Use ExecutorService + custom retry logic or CompletableFuture + recursion.*

27. **You’re asked to design a rate limiter for an API. How do you implement one using multithreading concepts?**  
   *Use Semaphore, token-bucket algorithm, or ScheduledExecutorService.*

28. **You need to cancel a long-running background task. How do you design this with cooperative cancellation?**  
   *Use Future.cancel() + Thread.interrupted() + proper check flags.*

29. **Design a system where 10 threads print numbers from 1 to 100 in order without overlap.**  
   *Shared counter + synchronized block or ReentrantLock.*

30. **You have multiple threads reading from a large file and processing lines. How do you design it for high throughput?**  
   *Use ExecutorService, BlockingQueue, and worker pool.*

31. **A shared resource needs to be accessed only by one thread at a time. Which approach is better — synchronized, ReentrantLock, or Semaphore?**  
   *Compare pros/cons (fairness, interruptibility, performance).*

32. **You have a thread pool and one thread throws an exception. How do you catch and log that exception?**  
   *Use Future.get() or handle exception inside Callable.*

33. **You want to throttle database access to max 10 concurrent queries. How do you enforce this?**  
   *Use Semaphore or ThreadPoolExecutor with fixed size.*

34. **Implement a custom thread-safe LRU cache.**  
   *Use LinkedHashMap + synchronized or ConcurrentHashMap + Deque.*

35. **You have 3 threads that must execute in a sequence: Thread A → B → C repeatedly. How do you enforce this ordering?**  
   *Use CyclicBarrier, Semaphore, or volatile flags with coordination.*

---

## 🔹 Coding Practice & Advanced Scenarios

36. **Write code to demonstrate thread-safe increment of a shared counter using AtomicInteger.**

37. **Implement a simple thread pool from scratch (without using ExecutorService).**

38. **Write a program where multiple threads update a shared list. How do you ensure thread safety?**

39. **Show how to use ThreadLocal to store user session data per thread.**

40. **Demonstrate how to use CompletableFuture for asynchronous computation and combine results.**

41. **Write code to simulate a deadlock and then resolve it.**

42. **Implement a multi-threaded file downloader that splits a file into chunks and downloads in parallel.**

43. **Write a program to process a large CSV file using multiple threads and aggregate results.**

44. **Show how to use ScheduledExecutorService to run a periodic task.**

45. **Write a test case to verify that your custom thread-safe class works under concurrent access.**

---

## 🔹 High-Level Design / Leadership Focused Questions

46. **How would you debug a production deadlock?**  
   *Thread dumps, jstack, visual tools like VisualVM or JConsole.*

47. **How do you choose thread count in a thread pool?**  
   *Based on CPU cores (Runtime.getRuntime().availableProcessors()), blocking vs non-blocking.*

48. **How would you test and validate multi-threaded code?**  
   *Use JUnit + concurrency testing libraries like Awaitility, stress tests, race condition tests.*

49. **How do you make your multithreaded code extensible and clean?**  
   *Use Executor pattern, avoid thread inheritance, clean separation of tasks, use high-level concurrency APIs.*

50. **How do you ensure consistency between threads and a database (e.g., double booking, stale writes)?**  
   *Use transactions, optimistic/pessimistic locking, or thread-safe caching mechanisms.*

---

## 🔹 Want Practice Code for These?

Say:  
✅ “Give me code for Q22 and Q26”  
or  
✅ “Show producer-consumer model using BlockingQueue”