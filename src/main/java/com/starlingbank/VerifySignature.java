package com.starlingbank;

import java.security.MessageDigest;
import java.util.Base64;

public class verifySignature {
    public static void main(String[] args) throws Exception {
        //Json payload taken from webhook triggered at 2019-06-28 07:28:21 UTC
        String jsonPayload =  "86e144f369ed4e8482901a913b131d6f62c8176b520b4193a1b7a4edac310e0a{\"fpid\": \"JHGU7DORVVRHVYGE7G1020190628826572590 \", \"paymentBusinessUid\": \"b9352afd-13ae-4c03-99f0-42f46bd98b20\", \"paymentAccountUid\": \"dc747e10-9970-11e9-b24f-10d07ac91ea0\", \"addressUid\": \"2e93115e-9976-11e9-ae61-10d07ac91ea0\", \"paymentUid\": \"29a0311d-7c95-4f83-a9c2-fcc658153517\", \"sourceAccount\": {\"sortCode\": \"204514\", \"accountNumber\": \"58236355\", \"accountName\": \"MR CUSTOMER\"}, \"destinationAccount\": {\"sortCode\": \"040059\", \"accountNumber\": \"15457678\", \"accountName\": \"\"}, \"settlementAmount\": {\"currency\": \"GBP\", \"minorUnits\": 12310}, \"instructedAmount\": {\"currency\": \"GBP\", \"minorUnits\": 12310}, \"reference\": \"AAATest\", \"receivedAt\": \"2019-06-28T07:28:18.000Z\", \"returnDetails\": {}, \"deadlineForReturn\": \"2019-07-01T16:00:00.000Z\", \"type\": \"SIP\", \"settlementCycleUid\": \"bc1f2fd4-7fa3-4b3e-af5e-2fe890e6b83a\", \"fpsSettlementCycleId\": \"CYCLE_001\", \"fpsSettlementDate\": \"2019-06-28\"}";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        String digest = Base64.getEncoder().encodeToString(messageDigest.digest(jsonPayload.getBytes()));
        System.out.println(digest);
        System.out.println("expected mPYVuoYLH8u2Ax4HL6ZvyXOkIhdh9jKpY/noyNy22jJTyIH20jQrrhDhshqAN3S/xzh7cYAprYD2aOFOYG1wcg==");
    }
}
