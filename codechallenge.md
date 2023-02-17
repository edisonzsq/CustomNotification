# Code Challenge

## Brief

Modify the code to achieve the following requirements:

- Create an interval where `ExecutorService` will poll `x` number of objects from the `Queue` to process.

- `x` number of objects equate to the number of non-active thread pool initialized in the `ExecutorService`

- Move `ExecutorService` to a separate class using `Singleton` pattern (same as `NotificationQueue`). With this, we are applying the *Single Responsibility Principle* of [SOLID](https://en.wikipedia.org/wiki/SOLID).