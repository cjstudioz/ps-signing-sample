package com.starlingbank;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.UUID;

public class SignFromFile {
    public static void main(String[] args) throws Exception {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        byte[] privateKeyBytes = FileUtils.readFileToByteArray(new File("C:\\IdeaProjects\\ps-signing-sample-master\\PATH_TO_PRIVATE_KEY_ROTATION"));
        //String privateKeyString = "hidden";
        //final byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
        EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey2 = kf.generatePrivate(keySpecPKCS8);
        String privateKey2Str = new String(Base64.getEncoder().encode(privateKey2.getEncoded()));
        System.out.println(privateKey2Str);

        byte[] publicKeyBytes = FileUtils.readFileToByteArray(new File("C:\\IdeaProjects\\ps-signing-sample-master\\PATH_TO_PUBLIC_KEY"));
        //String publicKeyString = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAsXzRmGbFqB/QdTyAoMwOtJqBfGNW/yJKe6y1QC83bZ16BbGk9cJ3TVcF8/meL2oTti+aa1Y+8BIWJ8cvtvwJvtkChwi9tY7wj4Vx09d1EUMS94Nxk1hdWPFukh6M084s0RzVAAyw5hgXYqdiawSQs+h+QphQ6RmcKU8CsuRCZOABul3XC81GI4Rw97IbzWC7zbY+53ezVqC67rfFUwBlqTfLPiXPGZjFCYGeDMvqZ0MyGVrZiBoACZHOm0qVCCRqc8zfyyIsI0oWVs0oF0YFUuPBInN2wrwBtXPxeiNd1n/2qbruMYZu3C2n1xX296Q8drkOxOy/v/voqYX8hd95MsmEW9sn9ijtaRYs310/xNN6t1DcEOQQ6Y4YoEpRmQlFPegz3gJ0g7dfYd6ZEbGuWmvBHSN5edDoFirzEH3RBKVyY+c7Jf6KM/FThrFnPs3DyTiqzO1LGwDRlA60Y7TIrsLjwXVXFnGGq7AHKjKDRxhn2+cg2ibeX9+52cOeyb/h431xAL5a5XPMcUy/LqcZ6ScWQ1E6gXaCcKEoEXD+m174eSKpH85fV6eatUXQLjsokGDYZa+f7IS92B/7jcF267QoTFKDMQ8VMfouqU4kQmjFNuH958VqA0HLboHpAEL34qWAWAqPJXvI/s2O6Suwb6Ta/D3RjLHJ8vbh1FW1wvcCAwEAAQ==";
        //final byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey2 = kf.generatePublic(publicKeySpec);

        KeySigningExample kse = new KeySigningExample();
        KeySigningExample.KeyAndSignature kns = kse.signPaymentsPublicKeyWithUploadPrivateKey(
                UUID.fromString("4fbe78ef-5958-4f16-a234-cfc6eb61852f"),
                privateKey2,
                publicKey2,
                ZonedDateTime.now()//ZonedDateTime.parse("2019-06-27T12:30:40+01:00[+01:00]")//ZonedDateTime.now()
        );
        System.out.println(kns.getSignature());
    }
}
//Date: 2019-06-27T12:30:40+01:00
//        Digest: yVGzLhVb8BIYxHYftVpCJe/FYXDhVEZhGtg4TDr9md5dSh34ZeZg4u3Tj1+NC3iCzwyhqpzEEZJ6FslhsDbITg==
//        Signature keyid="b0a0f2d9-e42e-4378-9a6b-65963e6d4381",algorithm="rsa-sha512",headers="Date Digest",signature="myBTpapyN61RbtQr16WeDWWKHF9Nnan+ytpJLtFY3+aJ3uBgYG+FZm8Xz9G63s3HHVMTOVm2aHpbO/6tgIKAsY9E9ERcaf81S5WX2tCjNVQMxrewFl477crgwtPTgAOFPgg5Z5OOePQlJM09V5A4boak6IILaHqJK7dZQOHFYDxaS8kd1SAX6vijlDOjwk7CXHjY9Y1YftHvYt2jSd/aR5CZe+4FxfHGbCP4haaaoc92uf85NJzg7/GCxQBQFNT1y5JcEWLsU2+PxreG0Xks7gC3xGKrNwJN4N97c9h8ofscY3+Vhj6potPZwWegZq/okVeLgH+NY/boyojafMfix2smMgevb95JvLNuzqcm4mybX4enZKfObOUG9CJBhsYrKw86/8N7VQI/iFbn4wtfkTimc3fOF4O1lzeGkhwEa/BH7dtUjkAH+KMwQb2w8L/U3GnLv+TkC8w/zXki2Jge71WQmm3XSLDJhYKe0qeCm0RYV1ge9zPVnfeul0GURd2REzlMuG571cASTkaImqgrBwRDfKy57ndUppxqnWctYENV6kb/aJmaE22vB4lA30bwjEnTMY8Z2eeCMfJYNK8YjM8L2QawbYcm3gMLsfXhr98cSaUKGRsSDBBG9P1tldx1FZBQWU45q4k+15x5mvT7mhCv78LOgvLl0UB6ky5cBmE="
