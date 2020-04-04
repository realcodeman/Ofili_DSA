# Ofili_DSA

Q.  Given calendar schedules for two individuals, write an algorithm that returns a list of available times for both individuals to have a meeting, each meeting duration must be at least K mins, this would be passed into the function. You would also be given the daily bound for both individuals as well, think of it as the start and end times of an individual active hours, i: e the duration he has to work and have meetings and so on.
Sample Input:
Person1: [[‘9:00’, ’10:30’], [’12:00’,’13:00’], [’16:00’,’18:00’]]
Person1 Daily bound: [‘9:00’, ’20:00’]

Person2: [[’10:00’,’11:30’], [’12:30’,’14:30’], [’14:30’,’15:00’], [’16:00’,’17:00’]]
Person2 Daily bound: [’10:00’, ’18:30’]

K = 30 mis

Sample output:
[[’11:30’, ’12:00’], [’15:00’,’16:00’], [’18:00’,’18:30’]]
