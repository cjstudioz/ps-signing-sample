package com.starlingbank;

import java.security.MessageDigest;
import java.util.Base64;

public class verifySignature {
    public static void main(String[] args) throws Exception {
        String jsonPayload = "86e144f369ed4e8482901a913b131d6f62c8176b520b4193a1b7a4edac310e0a" + "{\"fpid\":\"39TB7RZZJZ51GSY62Y1020190702826336381 \",\"paymentBusinessUid\":\"b9352afd-13ae-4c03-99f0-42f46bd98b20\",\"paymentAccountUid\":\"dc747e10-9970-11e9-b24f-10d07ac91ea0\",\"addressUid\":\"ace2eb1e-99f5-11e9-b8c5-10d07ac91ea0\",\"paymentUid\":\"3fd5eb37-6f12-4641-a10c-fe8169e6b929\",\"sourceAccount\":{\"sortCode\":\"203002\",\"accountNumber\":\"11044524\",\"accountName\":\"MR CUSTOMER\"},\"destinationAccount\":{\"sortCode\":\"040059\",\"accountNumber\":\"88517431\",\"accountName\":\"\"},\"settlementAmount\":{\"currency\":\"GBP\",\"minorUnits\":12310},\"instructedAmount\":{\"currency\":\"GBP\",\"minorUnits\":12310},\"reference\":\"AAATest\",\"receivedAt\":\"2019-07-02T06:13:57.000Z\",\"returnDetails\":{},\"deadlineForReturn\":\"2019-07-03T16:00:00.000Z\",\"type\":\"SIP\",\"settlementCycleUid\":\"061f8021-facc-4d56-b52a-8f1367aad843\",\"fpsSettlementCycleId\":\"CYCLE_001\",\"fpsSettlementDate\":\"2019-07-02\"}";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        String digest = Base64.getEncoder().encodeToString(messageDigest.digest(jsonPayload.getBytes()));
        System.out.println(digest);
        System.out.println("expected vsybnXxaxLBBA7HXSHviwlgSOP9bKRZ0j3ohu70DJ8wxsLak9vKimG57FsmGU+aPQEVSKs+ldcXUzKh/xMBjiw==");
    }
}
