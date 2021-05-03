package com.gm.gmreader.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.codec.Codecs;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {
    // Token请求头
    public static final String TOKEN_HEADER = "token";
    // Token前缀
    public static final String TOKEN_PREFIX = "Bearer ";

    // 签名主题
    public static final String SUBJECT = "piconjo";
    // 过期时间
    public static final long EXPIRITION = 1000 *60 * 60;
    // 应用密钥
    public static final String APPSECRET_KEY = "piconjo_secret";
    // 角色权限声明
    private static final String ROLE_CLAIMS = "role";


    private static Object obj=new Object();

    /**
     * jzq.sso的私钥
     */
    private static String ssoAppPrivateKey="-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIICXAIBAAKBgQC0VDBhucMpBp2bAmFqgrtAoOyOLQ7VjqYCsCp29D8yBRefMlFS\n" +
            "xfY5SvMhlMopObJyLzRjWIXFYKgbubX261+ctPhExJdqH7VryZiYkxbLB7HUVfeK\n" +
            "eWgqAwYE7hep2nNRSpR4E3uN2zEAA6Opm/Iv7dzB8gALMeM7HdZaMuBkVQIDAQAB\n" +
            "AoGACWNosW3Ob1Bc3DkfgUAVJ6Q5LJ3D6/JlSjaJv2+v6pbBSBSCj2CnFQyF4/Wv\n" +
            "IL5UQAWdIJ73N/N0TR06EATpEVUd3kxvR/MjWuAaBNsdx8upQVz299fl9J+BbyvK\n" +
            "Ht9ZIlXEOB2/xPNZNsGKnGkGWqiDod0f60JLEWNB87VNsPECQQDmGuwJTo4vIGab\n" +
            "kKffuVG4s/FYUBJKz9XGVr83WNDj9/FZSpWl9opqPXpZ0Kj2Pa/jrEi1ipz18nr+\n" +
            "HnQ85Fx3AkEAyJ9EJpupo4EPuYS3l9tN+8fJ6h8n1ezsSW9yVulDscEtAU2lDmQZ\n" +
            "HagI6HI35WwyGB99FLWgfOQrZDHSzyoUkwJAESwzL2Kgc93sKnH6RVUURz+OpHOd\n" +
            "Wd32601wCdZkCI9pgKtzTaZ/n/wklG1hHrdt2AT0jC/jFOvax/pH3H+CcwJAS25e\n" +
            "kGmcucYv5F/7K5SgWJeA2o9GSg/fs6i8g+MGudHZGxFXival3tmsJ8GyNIeeuiU0\n" +
            "wVGc+vhLPEvjaFL5EwJBAIPjDp86VqlwViBRz2SICYj/z/cnVOMOrhWQQI058Sg3\n" +
            "XTx7P/rhJ8dlUhmCHcOJQpufyC+EyPbpdd+8gWDuCw0="+
            "-----END RSA PRIVATE KEY-----\n";

    /**
     * jzq.sso的公钥
     */
    private static String ssoAppPublicKey="-----BEGIN PUBLIC KEY-----\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0VDBhucMpBp2bAmFqgrtAoOyO\n" +
            "LQ7VjqYCsCp29D8yBRefMlFSxfY5SvMhlMopObJyLzRjWIXFYKgbubX261+ctPhE\n" +
            "xJdqH7VryZiYkxbLB7HUVfeKeWgqAwYE7hep2nNRSpR4E3uN2zEAA6Opm/Iv7dzB\n" +
            "8gALMeM7HdZaMuBkVQIDAQAB"+
            "-----END PUBLIC KEY-----\n";

    private static RsaSigner signer;

    private static RsaVerifier verifier;

    static {
        signer=new RsaSigner(ssoAppPrivateKey);
        verifier=new RsaVerifier(ssoAppPublicKey);
    }

    public byte[] enSign(String data){
        byte[] content = Codecs.utf8Encode(data);
        byte[] signed = signer.sign(content);
        return signed;
    }

    /**
     * 生成Token
     */
    public static String createToken(String username,String role) {
        JSONObject json=new JSONObject();
        json.put("username",username);
        json.put("date",new Date());
        json.put("outdate",new Date(System.currentTimeMillis() + EXPIRITION));
        json.put("role",role);
        Jwt jwt = JwtHelper.encode(json.toJSONString(), signer);
        return jwt.getEncoded();
//        Map<String,Object> map = new HashMap<>();
//        map.put(ROLE_CLAIMS, role);
//        String token = Jwts
//                .builder()
//                .setSubject(username)
//                .setClaims(map)
//                .claim("username",username)
//                .setIssuedAt(new Date())
//                .setExpiration()
//                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
//        return token;
    }

    /**
     * 校验Token
     */
    public static JSONObject checkJWT(String token) {
        try{
            Jwt jwt = JwtHelper.decodeAndVerify(token,verifier);
            return JSONObject.parseObject(jwt.getClaims());
        }catch (RuntimeException e){
//            System.out.println("token ");
            return null;
        }
    }

    /**
     * 从Token中获取username
     */
    public static String getUsername(String token){
        JSONObject json=checkJWT(token);
        if(json!=null)
        return json.get("username").toString();
        else return null;
    }

    /**
     * 从Token中获取用户角色
     */
    public static String getUserRole(String token){
        JSONObject json=checkJWT(token);
        if(json!=null)
            return json.get("role").toString();
        else return null;
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token){
        JSONObject json=checkJWT(token);
        if(json!=null)
            return json.getDate("outdate").before(new Date());
        else
            return false;
    }
}