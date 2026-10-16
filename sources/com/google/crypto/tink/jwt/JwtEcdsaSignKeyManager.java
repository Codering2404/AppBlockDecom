package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.internal.PrivateKeyTypeManager;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaKeyFormat;
import com.google.crypto.tink.proto.JwtEcdsaPrivateKey;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtEcdsaSignKeyManager extends PrivateKeyTypeManager<JwtEcdsaPrivateKey, JwtEcdsaPublicKey> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JwtPublicKeySignFactory extends PrimitiveFactory<JwtPublicKeySignInternal, JwtEcdsaPrivateKey> {

        /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager$JwtPublicKeySignFactory$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements JwtPublicKeySignInternal {
        }

        public JwtPublicKeySignFactory() {
            super(JwtPublicKeySignInternal.class);
        }
    }

    JwtEcdsaSignKeyManager() {
        super(JwtEcdsaPrivateKey.class, JwtEcdsaPublicKey.class, new JwtPublicKeySignFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(JwtEcdsaAlgorithm jwtEcdsaAlgorithm, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((JwtEcdsaKeyFormat) JwtEcdsaKeyFormat.S().J(jwtEcdsaAlgorithm).build(), outputPrefixType);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<JwtEcdsaKeyFormat, JwtEcdsaPrivateKey>(JwtEcdsaKeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager.1
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_ES256_RAW", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_ES256", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm, outputPrefixType2));
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm2 = JwtEcdsaAlgorithm.ES384;
                map.put("JWT_ES384_RAW", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm2, outputPrefixType));
                map.put("JWT_ES384", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm2, outputPrefixType2));
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm3 = JwtEcdsaAlgorithm.ES512;
                map.put("JWT_ES512_RAW", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm3, outputPrefixType));
                map.put("JWT_ES512", JwtEcdsaSignKeyManager.g(jwtEcdsaAlgorithm3, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
