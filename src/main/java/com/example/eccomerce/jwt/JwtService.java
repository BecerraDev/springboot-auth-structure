package com.example.eccomerce.jwt;

import java.util.Map;
import java.util.function.Function;
import java.util.HashMap;
import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@Service
public class JwtService {
	
	private static final String SECRET_KEY = "uYbYxQkUDsJ+8ReHMQ5LOj7ECYv3g5l6kOouqJZ5ZjU=";

	 public String getToken(UserDetails user) {
	        return getToken(new HashMap<>(), user);
	    }

	 private String getToken(Map<String,Object> extraClaims, UserDetails user) 
	 {
	        return Jwts.builder()
	                .setClaims(extraClaims)  // Agrega claims personalizados
	                .setSubject(user.getUsername()) // Establece el usuario
	                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expira en 10 horas
	                .signWith(getKey(), SignatureAlgorithm.HS256) // Firma con clave secreta
	                .compact(); // Construye el token
	    }
	 
	 private Key getKey() {
		 byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		 return Keys.hmacShaKeyFor(keyBytes);
	 }

	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	private Claims getAllClaims(String token)
	{
		return Jwts
				.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
	{
		final Claims claims = getAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Date getExpiration(String token)
	{
		return getClaim(token, Claims::getExpiration);
	}
	private boolean isTokenExpired(String token)
	{
		return getExpiration(token).before(new Date());
	}
	
	
}

