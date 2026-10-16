package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class JwtEcdsaVerifyKeyManager extends KeyTypeManager<JwtEcdsaPublicKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86295a;

        static {
            int[] iArr = new int[JwtEcdsaAlgorithm.values().length];
            f86295a = iArr;
            try {
                iArr[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86295a[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86295a[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class JwtPublicKeyVerifyFactory extends PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtEcdsaPublicKey> {

        /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$JwtPublicKeyVerifyFactory$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements JwtPublicKeyVerifyInternal {
        }

        public JwtPublicKeyVerifyFactory() {
            super(JwtPublicKeyVerifyInternal.class);
        }
    }

    public JwtEcdsaVerifyKeyManager() {
        super(JwtEcdsaPublicKey.class, new JwtPublicKeyVerifyFactory());
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    }
}
