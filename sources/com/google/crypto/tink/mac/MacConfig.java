package com.google.crypto.tink.mac;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MacConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f86368a = new HmacKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RegistryConfig f86369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegistryConfig f86370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RegistryConfig f86371d;

    static {
        RegistryConfig registryConfigR = RegistryConfig.R();
        f86369b = registryConfigR;
        f86370c = registryConfigR;
        f86371d = registryConfigR;
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
        MacWrapper.b();
        ChunkedMacWrapper.b();
        HmacKeyManager.h(true);
        if (TinkFips.a()) {
            return;
        }
        AesCmacKeyManager.f(true);
    }
}
