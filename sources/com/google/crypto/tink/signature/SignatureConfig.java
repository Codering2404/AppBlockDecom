package com.google.crypto.tink.signature;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SignatureConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f87271a = new EcdsaVerifyKeyManager().c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f87272b = new EcdsaSignKeyManager().c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f87273c = new Ed25519PublicKeyManager().c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f87274d = new Ed25519PrivateKeyManager().c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f87275e = new RsaSsaPkcs1SignKeyManager().c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f87276f = new RsaSsaPkcs1VerifyKeyManager().c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f87277g = new RsaSsaPssSignKeyManager().c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f87278h = new RsaSsaPssVerifyKeyManager().c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final RegistryConfig f87279i = RegistryConfig.R();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final RegistryConfig f87280j = RegistryConfig.R();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final RegistryConfig f87281k = RegistryConfig.R();

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
        PublicKeySignWrapper.b();
        PublicKeyVerifyWrapper.b();
        EcdsaSignKeyManager.h(true);
        RsaSsaPkcs1SignKeyManager.h(true);
        if (TinkFips.a()) {
            return;
        }
        RsaSsaPssSignKeyManager.h(true);
        Ed25519PrivateKeyManager.f(true);
    }
}
