# TaxiCompany_Java

## Problem Statement

I am designing an object model for the Taxi Company which owns 3 kinds of vehicles:

1. Van (7 Seater)
2. Car (4 Seater)
3. Motorcycle (2 Seater)

Customers always visit this taxi company in groups of 2, 4 or 7.

All the customers request vehicles at random times between 5 - 10 minutes in whole minutes increment.

All customers take a ride for random times between 10 - 20 minutes in whole minute increments.

**Assumptions**

1. All rides start and end at same location

2. Customers are riding in circular track which takes 1 minute for each loop

3. Customers of group size 2 always take Motorcycle, group size 4 always take Car and group size 7 always take the Van.

## Prerequisites

To run the code, you need to have following installed in your system:

* Recent version of Java (1.8)
* An IDE (Eclipse, IntelliJ or Netbeans)

## Object Diagram
![Object_Diagram](/resources/ObjectDiagram.png "Object Diagram")

## Design Patterns

For the purpose of this code, I have used following design patterns:

* **Strategy Pattern** - To be able to select vehicle at runtime
* **Singleton Pattern** - Only one instance of request lists and waitlists

## Features of Taxi Company

1. *Randomly Request Vehicles* at time intervals from 5 - 10 minutes.

```java

int randomDelay = random.nextInt((10 - 5) + 1) + 5;

Timer timerTask = new Timer();

timerTask.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
            ....
            randomDelay = random.nextInt((10 - 5) + 1) + 5;
            ....
      }
}, randomDelay * 1000, randomDelay * 1000);

```

2. *Random Group Size* for each request

```java
private static int[] capacities = {2, 4, 7};

int groupSize = capacities[random.nextInt(capacities.length)];
```

2. *Random Duration* for each request at time intervals from 10 - 20 minutes.

```java
int duration = random.nextInt((20 - 10) + 1) + 10;
Request request = new Request(duration, vehicle, customer);
```

3. *Manage Current Trip List* - Customers who have taken vehicle.

```java
public static ArrayList<Request> vanRequests = new ArrayList<>();
public static ArrayList<Request> carRequests = new ArrayList<>();
public static ArrayList<Request> motorcycleRequests = new ArrayList<>();
```

4. *Maintain a Waitlist of Requests* - Customers who are waiting for the vehicle.

```java
public static ArrayList<Request> vanWaitlist = new ArrayList<>();
public static ArrayList<Request> carWaitlist = new ArrayList<>();
public static ArrayList<Request> motorcycleWaitlist = new ArrayList<>();
```

## Authors

* **Mansi Jain** - [Online Portfolio](https://jainmansi.com)
