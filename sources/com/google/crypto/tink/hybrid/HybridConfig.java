package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HybridConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f86171a = new EciesAeadHkdfPublicKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f86172b = new EciesAeadHkdfPrivateKeyManager().c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegistryConfig f86173c = RegistryConfig.R();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RegistryConfig f86174d = RegistryConfig.R();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final RegistryConfig f86175e = RegistryConfig.R();

    static {
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
        HybridDecryptWrapper.b();
        HybridEncryptWrapper.b();
        AeadConfig.b();
        if (TinkFips.a()) {
            return;
        }
        EciesAeadHkdfPrivateKeyManager.j(true);
        HpkePrivateKeyManager.h(true);
    }
}
