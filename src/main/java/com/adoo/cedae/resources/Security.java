/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adoo.cedae.resources;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author mario
 * 
 */
public class Security {

    public Security() {
    }
    
    public String encriptar(String s) throws UnsupportedEncodingException{
        String encodedUrl = Base64.getUrlEncoder().encodeToString(s.getBytes());
        return encodedUrl;
    }
    
    public String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decodedBytes = Base64.getUrlDecoder().decode(s);
        String decodedUrl = new String(decodedBytes);
        return decodedUrl;
    }
}
