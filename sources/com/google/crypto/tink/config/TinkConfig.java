package com.google.crypto.tink.config;

import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.hybrid.HybridConfig;
import com.google.crypto.tink.prf.PrfConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import com.google.crypto.tink.signature.SignatureConfig;
import com.google.crypto.tink.streamingaead.StreamingAeadConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TinkConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RegistryConfig f86153a = RegistryConfig.R();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RegistryConfig f86154b = RegistryConfig.R();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegistryConfig f86155c = RegistryConfig.R();

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
        DeterministicAeadConfig.a();
        HybridConfig.b();
        PrfConfig.a();
        SignatureConfig.b();
        StreamingAeadConfig.b();
    }
}
