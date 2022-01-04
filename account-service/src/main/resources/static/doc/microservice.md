Four Reasons to use Microservices
---

1- Scalability
* Vertical - Hardware
    * CPU
    * RAM
    * Disk Capacity
* Horizontal - Software
    * Load balancing

2- Flexibility
* Abstraction
  * An error in the service does not affect the entire running application.

3- CI / CD Process
* Easier to deploy application

4- Technology
* Ability to code services in other programming languages.

Notice
* Each service should depend on each other as little as possible or be independent.
* Each service must run in its own container and must be separated at the database level.
* A service should not need other services while deployed.

Disadvantages
* Hard to handle authentication and authorization.