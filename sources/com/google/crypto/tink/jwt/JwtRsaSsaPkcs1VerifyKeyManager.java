package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.internal.PrimitiveFactory;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class JwtRsaSsaPkcs1VerifyKeyManager extends KeyTypeManager<JwtRsaSsaPkcs1PublicKey> {

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86303a;

        static {
            int[] iArr = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            f86303a = iArr;
            try {
                iArr[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86303a[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86303a[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public JwtRsaSsaPkcs1VerifyKeyManager() {
        super(JwtRsaSsaPkcs1PublicKey.class, new PrimitiveFactory<JwtPublicKeyVerifyInternal, JwtRsaSsaPkcs1PublicKey>(JwtPublicKeyVerifyInternal.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager.1

            /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1VerifyKeyManager$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            class C01641 implements JwtPublicKeyVerifyInternal {
            }
        });
    }

    @Override // com.google.crypto.tink.internal.KeyTypeManager
    public String c() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    }
}
