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

## Features of Taxi Company

1. *Randomly Request Vehicles* at time intervals from 5 - 10 minutes.

```java

randomDelay = random.nextInt((10 - 5) + 1) + 5;

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

2. *Random Duration* for each request at time intervals from 10 - 20 minutes.

3. *Manage Current Trip List* - Customers who have taken vehicle.

4. *Maintain a Waitlist of Requests* - Customers who are waiting for the vehicle.

