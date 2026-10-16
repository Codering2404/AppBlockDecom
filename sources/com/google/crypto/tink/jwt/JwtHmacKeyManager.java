package com.google.crypto.tink.jwt;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.JwtHmacAlgorithm;
import com.google.crypto.tink.proto.JwtHmacKey;
import com.google.crypto.tink.proto.JwtHmacKeyFormat;
import com.google.errorprone.annotations.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtHmacKeyManager extends KeyTypeManager<JwtHmacKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtHmacKeyManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86297a;

        static {
            int[] iArr = new int[JwtHmacAlgorithm.values().length];
            f86297a = iArr;
            try {
                iArr[JwtHmacAlgorithm.HS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86297a[JwtHmacAlgorithm.HS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86297a[JwtHmacAlgorithm.HS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Immutable
    private static final class JwtHmac implements JwtMacInternal {
    }

    public JwtHmacKeyManager() {
        super(JwtHmacKey.class, new PrimitiveFactory<JwtMacInternal, JwtHmacKey>(JwtMacInternal.class) { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager.1
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat g(JwtHmacAlgorithm jwtHmacAlgorithm, int i3, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat((JwtHmacKeyFormat) JwtHmacKeyFormat.T().J(jwtHmacAlgorithm).K(i3).build(), outputPrefixType);
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtHmacKey";
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory d() {
        return new KeyTypeManager.KeyFactory<JwtHmacKeyFormat, JwtHmacKey>(JwtHmacKeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map a() {
                HashMap map = new HashMap();
                JwtHmacAlgorithm jwtHmacAlgorithm = JwtHmacAlgorithm.HS256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_HS256_RAW", JwtHmacKeyManager.g(jwtHmacAlgorithm, 32, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_HS256", JwtHmacKeyManager.g(jwtHmacAlgorithm, 32, outputPrefixType2));
                JwtHmacAlgorithm jwtHmacAlgorithm2 = JwtHmacAlgorithm.HS384;
                map.put("JWT_HS384_RAW", JwtHmacKeyManager.g(jwtHmacAlgorithm2, 48, outputPrefixType));
                map.put("JWT_HS384", JwtHmacKeyManager.g(jwtHmacAlgorithm2, 48, outputPrefixType2));
                JwtHmacAlgorithm jwtHmacAlgorithm3 = JwtHmacAlgorithm.HS512;
                map.put("JWT_HS512_RAW", JwtHmacKeyManager.g(jwtHmacAlgorithm3, 64, outputPrefixType));
                map.put("JWT_HS512", JwtHmacKeyManager.g(jwtHmacAlgorithm3, 64, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }
        };
    }
}
