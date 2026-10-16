package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCtrJceCipher implements IndCpaCipher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f87357a = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal f87358b = new ThreadLocal<Cipher>() { // from class: com.google.crypto.tink.subtle.AesCtrJceCipher.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return (Cipher) EngineFactory.f87432b.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException(e3);
            }
        }
    };
}
