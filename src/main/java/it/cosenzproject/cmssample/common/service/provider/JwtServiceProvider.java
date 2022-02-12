package it.cosenzproject.cmssample.common.service.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import it.cosenzproject.cmssample.core.security.service.JwtService;

@Service(JwtServiceProvider.BEAN_NAME)
public class JwtServiceProvider implements JwtService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtService.class);

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.common.service.provider.JwtServiceProvider";

	@Value("${jwt.expiration}")
	private Long expiration;

	@Value("${jwt.privateKey}")
	private String privateJwtKey;
	@Value("${jwt.publicKey}")
	private String publicJwtKey;

	@Override
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	@Override
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", userDetails.getAuthorities());
		return createToken(claims, userDetails.getUsername());
	}

	@Override
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> resolver) {
		final Claims claims = extractAllClaims(token);
		return resolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(generatePublicKey()).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuer("cosenzproject")
		        .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + (expiration * 1000)))
		        .signWith(SignatureAlgorithm.RS256, generatePrivateKey()).compact();
	}

	private PrivateKey generatePrivateKey() {
//		KeyPairGenerator keyGenerator;
		PrivateKey privateKey = null;
		try {
			// read private key
			KeyFactory kf = KeyFactory.getInstance("RSA");
			privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(Files.readAllBytes(Paths.get(this.privateJwtKey))));

			// Generate private and public key
//			keyGenerator = KeyPairGenerator.getInstance("RSA");
//			keyGenerator.initialize(4096);
//
//			KeyPair kp = keyGenerator.genKeyPair();
//			PublicKey publicKey = kp.getPublic();
//			privateKey = kp.getPrivate();

			// print keys
//			String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//			String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//			System.out.println("Public Key:");
//			System.out.println(convertToKey("PUBLIC", encodedPublicKey));
//			System.out.println("Private Key:");
//			System.out.println(convertToKey("RSA PRIVATE", encodedPrivateKey));

			// per generare la chiave pubblica con solo la chiave privata
//			RSAPrivateCrtKey priv2 = (RSAPrivateCrtKey) privateKey;
//			PublicKey pubkey = kf.generatePublic(new RSAPublicKeySpec(priv2.getModulus(), priv2.getPublicExponent()));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
			LOGGER.error("Errore durante la lettura del certificato jwt: {0}", e);
		}

		return privateKey;
	}

	private PublicKey generatePublicKey() {
		PublicKey publicKey = null;
		try {
			// read public key
			KeyFactory kf = KeyFactory.getInstance("RSA");
			publicKey = kf.generatePublic(new X509EncodedKeySpec(Files.readAllBytes(Paths.get(this.publicJwtKey))));
		} catch (InvalidKeySpecException | IOException | NoSuchAlgorithmException e) {
			LOGGER.error("Errore durante la lettura della public key: {0}", e);
		}

		return publicKey;
	}

}
