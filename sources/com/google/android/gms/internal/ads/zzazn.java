package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzazn implements Runnable {
    private zzazn() {
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzazo.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzazo.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzazo.zzb;
        } catch (Throwable th) {
            zzazo.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    /* synthetic */ zzazn(byte[] bArr) {
    }
}
