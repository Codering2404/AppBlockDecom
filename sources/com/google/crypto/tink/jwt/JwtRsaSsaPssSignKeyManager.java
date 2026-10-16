package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.math.BigInteger;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtRsaSsaPssSignKeyManager extends PrivateKeyTypeManager<JwtRsaSsaPssPrivateKey, JwtRsaSsaPssPublicKey> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JwtPublicKeySignFactory extends PrimitiveFactory<JwtPublicKeySignInternal, JwtRsaSsaPssPrivateKey> {

        /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPssSignKeyManager$JwtPublicKeySignFactory$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements JwtPublicKeySignInternal {
        }

        public JwtPublicKeySignFactory() {
            super(JwtPublicKeySignInternal.class);
        }
    }

    JwtRsaSsaPssSignKeyManager() {
        super(JwtRsaSsaPssPrivateKey.class, JwtRsaSsaPssPublicKey.class, new JwtPublicKeySignFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm, int i3, BigInteger bigInteger, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((JwtRsaSsaPssKeyFormat) JwtRsaSsaPssKeyFormat.U().J(jwtRsaSsaPssAlgorithm).K(i3).L(ByteString.p(bigInteger.toByteArray())).build(), outputPrefixType);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<JwtRsaSsaPssKeyFormat, JwtRsaSsaPssPrivateKey>(JwtRsaSsaPssKeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPssSignKeyManager.1
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_PS256_2048_F4_RAW", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm, 2048, bigInteger, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_PS256_2048_F4", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm, 2048, bigInteger, outputPrefixType2));
                map.put("JWT_PS256_3072_F4_RAW", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm, 3072, bigInteger, outputPrefixType));
                map.put("JWT_PS256_3072_F4", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm2 = JwtRsaSsaPssAlgorithm.PS384;
                map.put("JWT_PS384_3072_F4_RAW", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm2, 3072, bigInteger, outputPrefixType));
                map.put("JWT_PS384_3072_F4", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm2, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm3 = JwtRsaSsaPssAlgorithm.PS512;
                map.put("JWT_PS512_4096_F4_RAW", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm3, 4096, bigInteger, outputPrefixType));
                map.put("JWT_PS512_4096_F4", JwtRsaSsaPssSignKeyManager.g(jwtRsaSsaPssAlgorithm3, 4096, bigInteger, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
