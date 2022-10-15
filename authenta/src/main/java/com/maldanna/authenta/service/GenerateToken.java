package com.maldanna.authenta.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.maldanna.authenta.model.CustomerData;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class GenerateToken {

    public String generateToken(CustomerData custData){
        try{
            KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
            keyGenerator.initialize(1024);
            KeyPair kp = keyGenerator.genKeyPair();
            PublicKey publicKey = (PublicKey) kp.getPublic();
            PrivateKey privateKey = (PrivateKey) kp.getPrivate();
            String token = Jwts.builder().setSubject("authena-maldanna")
                .setExpiration(new Date(2022,10,10))
				.setIssuer("maldanna")
				.claim("commands", custData.getCommands())
				.signWith(SignatureAlgorithm.RS256, privateKey).compact();
            printStructure(token, publicKey);
		    return token;
        }
        catch(Exception e){
            System.out.println("Exception is: "+e.toString());
        }
        return null;
    }

    public void printStructure(String token, PublicKey publicKey) {
        Jws  parseClaimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
		System.out.println("Header     : " + parseClaimsJws.getHeader());
		System.out.println("Body       : " + parseClaimsJws.getBody());
		System.out.println("Signature  : " + parseClaimsJws.getSignature());
	}

}

