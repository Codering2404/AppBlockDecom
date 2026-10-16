package com.google.crypto.tink.aead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AeadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f86055a = new AesCtrHmacAeadKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f86056b = new AesGcmKeyManager().c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f86057c = new AesGcmSivKeyManager().c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f86058d = new AesEaxKeyManager().c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f86059e = new KmsAeadKeyManager().c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f86060f = new KmsEnvelopeAeadKeyManager().c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f86061g = new ChaCha20Poly1305KeyManager().c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f86062h = new XChaCha20Poly1305KeyManager().c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final RegistryConfig f86063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final RegistryConfig f86064j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final RegistryConfig f86065k;

    static {
        RegistryConfig registryConfigR = RegistryConfig.R();
        f86063i = registryConfigR;
        f86064j = registryConfigR;
        f86065k = registryConfigR;
        try {
            a();
        } catch (GeneralSecurityException e3) {
            throw new ExceptionInInitializerError(e3);
        }
    }

    public static void a() {
        b();
    }

    public static void b() {
        AeadWrapper.b();
        MacConfig.b();
        AesCtrHmacAeadKeyManager.i(true);
        AesGcmKeyManager.h(true);
        if (TinkFips.a()) {
            return;
        }
        AesEaxKeyManager.h(true);
        AesGcmSivKeyManager.i(true);
        ChaCha20Poly1305KeyManager.f(true);
        KmsAeadKeyManager.f(true);
        KmsEnvelopeAeadKeyManager.f(true);
        XChaCha20Poly1305KeyManager.f(true);
    }
}
