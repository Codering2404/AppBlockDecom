package com.google.android.gms.common.signatureverification;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SignatureVerificationConfiguration f72244a;

    public static synchronized void a(SignatureVerificationConfiguration signatureVerificationConfiguration) {
        if (f72244a != null) {
            throw new IllegalStateException("Redundantly setting SignatureVerificationConfiguration");
        }
        f72244a = signatureVerificationConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized SignatureVerificationConfiguration c() {
        try {
            if (f72244a == null) {
                a(new zzb());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f72244a;
    }
}
