package com.example.sum;

import org.springframework.stereotype.Service;

@Service
public class StepService {

    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    void printCount() {
        long startDay = DateUtils.parseDate("20200625", "yyyyMMdd");
        for (int i = 0; i < 15; i++)
        {
//            System.out.println(DateUtils.formatString(startDay, "yyyyMMdd"));
            long nextDay = startDay + 86400000;
//            long donateUser = stepRepository.countDomateUser(startDay, nextDay);
//            long donateTimes = stepRepository.countDomateTimes(startDay, nextDay);
//            long donateSteps = stepRepository.countDomateSteps(startDay, nextDay);
//            System.out.println(donateUser + ", " + donateTimes + ", " + donateSteps);

            long users = stepRepository.countUsers(startDay, nextDay);

            System.out.println(users);

            startDay = nextDay;
        }

    }
}
