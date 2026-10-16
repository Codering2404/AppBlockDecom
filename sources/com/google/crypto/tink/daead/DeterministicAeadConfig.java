package com.google.crypto.tink.daead;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DeterministicAeadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f86162a = new AesSivKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RegistryConfig f86163b = RegistryConfig.R();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RegistryConfig f86164c = RegistryConfig.R();

    static {
        try {
            a();
        } catch (GeneralSecurityException e3) {
            throw new ExceptionInInitializerError(e3);
        }
    }

    public static void a() {
        DeterministicAeadWrapper.b();
        if (TinkFips.a()) {
            return;
        }
        AesSivKeyManager.f(true);
    }
}
