package com.starlingbank;
import java.security.*;
import java.util.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.ZonedDateTime;

public class Main2 {

    public static void main(String[] args) throws Exception {
        // 1. Set the file paths in the constants of SigningExample class then run this first to create a key pair
        //new SigningExample().generateKeyForPortal();

        //String privateKeyString = "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";
        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
//        String privateKeyString = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDbtchUCfZcRWfOuzzYWhsmyBBsv93H1pB6L6AaDcmBKOllVj9C0rpdUNd4IC4Ty5eGeRpZ5+Tu2WR3S4o5S0Jmzy02MeVp1XVmgQV9j4Wc5SeLh94Mf/VBl4y14hIrYs2BUy7iSBVdN3LAIYHktsVQ90f+x4qVECAmZj4tPIIf55ln4D89mgWV7m8tVVGGfq1TP7iuIK9ETuKCFQZEK36tihEOurCiCIoufFZSHIbMvgIkiPZV9kLL8p3qlgmX3WjN2ELEo7Kgq9leRhJXYXH6v14mtIvb3PJtml45FEbppj6rWlZesLqK3o//xL2JKiQ0tY+xUxQxCl7pBwDQIod9AgMBAAECggEBAK98BRKilmRihyRGxrVjWtZh60SBBuoLhYAiM/U7V9vSyoBHH+YGnBXWcRMgWM00ysT8S0DOCDuB5U2nRzK12sZ06X6k4cDjXo7NtI3yKV0EZs56aa+AMGsAWcIYXDzNAKkvwH2551554Cx3VuFP3k/qAlYMGLMwmw0wkq7c6m4BuaNfTKQpggN/B0a/WldZ2lFm06Snie3xD8yWd9A/SLtRw117xfHcsBkeludxnl5sboK1a2SKxFHmFaitpTGSF2CgPpN4x5p9+XkmeaP7TCtM5qPjomyDuxtxg2XafcU8KdRsAa2Ol8EZTZw0bB3xNYN7wwJhZF4MKTfGy+RM/l0CgYEA5VA9bg6kwu/hyeO8wk6aASRdTPfGTawLaNpo5ozXyryLjutkXn9W1FBb67sPH1Q9E4LWzBZX+EO3hZQRoEOR5Y75eMNEUiu+RhooDD52beG1wOhdsYaGb8YrfyhlkojoKCGdB4VfHojy/LLBwkmzq+LPJb+YeNM8uQ9Ic4wx1G8CgYEA9Udv9FrFwH1JKdWckH8JSlSG5HRoK4HICXh0+GWYIzhFzjSne89z29vppqbWNZ7NmlYHSnQYEEgQVWTL37r464PjgK55gw5+8IogfB2jRk3hZhzLCHsIvc4rMhJwT9FwCITFetFbAzdJVwf3MEUz6UP/4b/Sr0inVVdhMPqOkNMCgYAhljoZJ53sS3RXvLqF/ztBVZEw1828zKkzJ2Jb+l8U+765JTMjQCV4nXiJM3HIle8IL47Ef7VM0KZNs11NivgQlntlu7wDCRMqc2RQPsnb2EZlxeMLQHfqYS03x7Pw3Yqbbijw1BEViNuGNax5h5AAag0LK1/quo3XUSy8d9lIkwKBgQCGGuDjQR4N+HIgJWLMviheM4jtL5gk8XhldS6/AQ0FdKb172QDFZHLC5ncPCuydXkEgTTLSF4/yKbliY7ObHPckOe6W6qkNTDCY0MPmUTEE6DBK8z2fg5xeF+1qM8vVNtkTPOMCxsvzvKSWxCTm8KeL0egLjkLDTYwOu4w0U1RcQKBgQDcnr5bkzuHitrSIKGEqn1cG0ChTgxvDoNem+P7a0CiQHd6+enK6AbuY4JOgxoixVLh3EKP/hFBt8zZnw45DadNzP1MaHtxTjVzJRKGqz6MN2WzxZVlBqwmySJBeTHZ+4zFsk0p3/jkK0Ht2TuxGqdXvnPY5eDQIzAhgbYbWEgLXg==";
//        String publicKeyString = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAhptMkrNkyT0pVSCUzrcgzQ3gLABwjGa5nlZqQlp34svD2C9cOG5TNpDdHvTmzJW4B00neF68NAf5GkHJ2ugGGKQOeI9bl4s0lBkWkOLALfxTZdm3wRTjdOAV3sQpo0ahI2Gg6yrN4nWoEt9ZyPLlr2/9GFFQAt9KUboYRSlwpY1vnFI5xm6PY6TQ6SdYTAO0Y01G89VVXpGx2M8rm8SFjTqXe2wBsmC3SBPqDwyXXyqlgXni87JL3gYRnJwNnnCpS4l5OPgp5PuzQpdKlaUlBYD5tgVfV9hwOtBpntzn/WzokJN65cbFeK2ZmRPefsOt19kO7PETVGd3tWLQg3EMMTZLEq2n9p05fcv0fHRZ3k9VtMhdPx96aDuV4Pn6yYBrpJvO/jkjb58ZBkrlSxNiTJblHq/P8NbCPq+m5AkLBXSm1deklihVmwJyAJSip0jMBhw2wRdaz7g/Eh0gYd7gCJFPsShb6bwGNQzv1MmMjCSFwvUjE9D0d9fwr5yN04sc0fH3twLItjJbvn+7uwSw5/UubdIULTqhsZuj4lvmTK6i0QFF9nGc+vGGKV6iMj0lp9VY2sakMQCU53nvtcemBFJRmFY0USY+phxU0JA/bwTUgcpCCaNVDzCEFWS8iEN77b0DSZW55O3IQRLWdmYAG36xxAnqyI49B089EVJfyS8CAwEAAQ";
//        KeyFactory kf = KeyFactory.getInstance("RSA");;
//        final byte[] decode = Base64.getDecoder().decode(privateKeyString);
//        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(decode);
//        PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString)));
//        PrivateKey privKey = kf.generatePrivate(keySpecPKCS8);

        //generate key
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096, new SecureRandom(Long.toString(new Random().nextLong()).getBytes()));
        KeyPair signingKey = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = signingKey.getPrivate();
        PublicKey publicKey = signingKey.getPublic();

        String encodedPublicKey = new String(Base64.getEncoder().encode(signingKey.getPublic().getEncoded()));
        System.out.println(encodedPublicKey);

        String encodedPrivateKey = new String(Base64.getEncoder().encode(signingKey.getPrivate().getEncoded()));
        System.out.println(encodedPrivateKey);

        //sign key
        calculateAuthorisationHeader(privateKey, "my string");

        //alternative sign key
        KeyFactory kf = KeyFactory.getInstance("RSA");;
        final byte[] decode = Base64.getDecoder().decode(encodedPrivateKey);
        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(decode);
        PrivateKey privateKey2 = kf.generatePrivate(keySpecPKCS8);
        calculateAuthorisationHeader(privateKey2, "my string");

        //sign keys
        PublicKey publicKey2= kf.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(encodedPublicKey)));

        KeySigningExample kse = new KeySigningExample();
        KeySigningExample.KeyAndSignature kns = kse.signPaymentsPublicKeyWithUploadPrivateKey(
                UUID.fromString("b0a0f2d9-e42e-4378-9a6b-65963e6d4381"),
                privateKey2,
                publicKey2,
                ZonedDateTime.parse("2019-06-27T12:30:40+01:00[+01:00]")//ZonedDateTime.now()
        );
        System.out.println(kns.getSignature());
    }

    public static String calculateAuthorisationHeader(PrivateKey privateKey, String textToSign) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance("SHA512withRSA"); // Could also use "SHA512withECDSA"
        instance.initSign(privateKey);
        instance.update(textToSign.getBytes());
        byte[] encodedSignedString = Base64.getEncoder().encode(instance.sign());
        String signature = new String(encodedSignedString);
        System.out.println(signature);

        return signature;
    }

}
