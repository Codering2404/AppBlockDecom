package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1KeyFormat;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtRsaSsaPkcs1SignKeyManager extends PrivateKeyTypeManager<JwtRsaSsaPkcs1PrivateKey, JwtRsaSsaPkcs1PublicKey> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JwtPublicKeySignFactory extends PrimitiveFactory<JwtPublicKeySignInternal, JwtRsaSsaPkcs1PrivateKey> {

        /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager$JwtPublicKeySignFactory$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements JwtPublicKeySignInternal {
        }

        public JwtPublicKeySignFactory() {
            super(JwtPublicKeySignInternal.class);
        }
    }

    JwtRsaSsaPkcs1SignKeyManager() {
        super(JwtRsaSsaPkcs1PrivateKey.class, JwtRsaSsaPkcs1PublicKey.class, new JwtPublicKeySignFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm, int i3, BigInteger bigInteger, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((JwtRsaSsaPkcs1KeyFormat) JwtRsaSsaPkcs1KeyFormat.U().J(jwtRsaSsaPkcs1Algorithm).K(i3).L(ByteString.p(bigInteger.toByteArray())).build(), outputPrefixType);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<JwtRsaSsaPkcs1KeyFormat, JwtRsaSsaPkcs1PrivateKey>(JwtRsaSsaPkcs1KeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager.1
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_RS256_2048_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm, 2048, bigInteger, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_RS256_2048_F4", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm, 2048, bigInteger, outputPrefixType2));
                map.put("JWT_RS256_3072_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm, 3072, bigInteger, outputPrefixType));
                map.put("JWT_RS256_3072_F4", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm2 = JwtRsaSsaPkcs1Algorithm.RS384;
                map.put("JWT_RS384_3072_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm2, 3072, bigInteger, outputPrefixType));
                map.put("JWT_RS384_3072_F4", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm2, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm3 = JwtRsaSsaPkcs1Algorithm.RS512;
                map.put("JWT_RS512_4096_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm3, 4096, bigInteger, outputPrefixType));
                map.put("JWT_RS512_4096_F4", JwtRsaSsaPkcs1SignKeyManager.g(jwtRsaSsaPkcs1Algorithm3, 4096, bigInteger, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
