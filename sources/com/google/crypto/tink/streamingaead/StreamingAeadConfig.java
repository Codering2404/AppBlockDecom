package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class StreamingAeadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f87320a = new AesCtrHmacStreamingKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f87321b = new AesGcmHkdfStreamingKeyManager().c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegistryConfig f87322c = RegistryConfig.R();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RegistryConfig f87323d = RegistryConfig.R();

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
        StreamingAeadWrapper.b();
        if (TinkFips.a()) {
            return;
        }
        AesCtrHmacStreamingKeyManager.h(true);
        AesGcmHkdfStreamingKeyManager.h(true);
    }
}
