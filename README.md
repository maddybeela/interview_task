# interview_task - Calculate rewards for the customer .

Data set : 
ID   CUSTOMER_NAME TRANSACTION_AMOUNT  TRANSACTION_DATE TRANSACTION_ID  
1	user1	120	11/29/2022	transaction1
2	user1	90	10/29/2022	transaction1
3	user1	130	9/29/2022	transaction1
4	user2	140	11/29/2022	transaction1
5	user2	20	10/29/2022	transaction2
6	user2	80	9/12/2022	transaction1
7	user3	105	10/29/2022	transaction1
8	user3	60	9/11/2022	transaction2
9	user3	70	8/12/2022	transaction3

**1) get All customers data :**

Endpoint : localhost:8080/rewards
Response body: 
[
    {
        "customerName": "user1",
        "previousOneMonthRewardPoints": 40,
        "previousTwoMonthRewardPoints": 110,
        "previousThreeMonthRewardPoints": 0,
        "totalRewardPoints": 150
    },
    {
        "customerName": "user2",
        "previousOneMonthRewardPoints": 0,
        "previousTwoMonthRewardPoints": 30,
        "previousThreeMonthRewardPoints": 0,
        "totalRewardPoints": 30
    },
    {
        "customerName": "user3",
        "previousOneMonthRewardPoints": 60,
        "previousTwoMonthRewardPoints": 10,
        "previousThreeMonthRewardPoints": 20,
        "totalRewardPoints": 90
    }
]
**
2) get for single customer :**

Endpoint : localhost:8080/rewards/user1

Response body :

{
    "customerName": "user1",
    "previousOneMonthRewardPoints": 40,
    "previousTwoMonthRewardPoints": 110,
    "previousThreeMonthRewardPoints": 0,
    "totalRewardPoints": 150
}
