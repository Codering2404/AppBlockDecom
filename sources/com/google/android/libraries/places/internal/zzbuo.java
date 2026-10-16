package com.google.android.libraries.places.internal;

import java.lang.Thread;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuo implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvr f76915a;

    zzbuo(zzbvr zzbvrVar) {
        Objects.requireNonNull(zzbvrVar);
        this.f76915a = zzbvrVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzbvr zzbvrVar = this.f76915a;
        Logger logger = zzbvr.f76976e0;
        Level level = Level.SEVERE;
        String strValueOf = String.valueOf(zzbvrVar.zzc());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 59);
        sb.append("[");
        sb.append(strValueOf);
        sb.append("] Uncaught exception in the SynchronizationContext. Panic!");
        logger.logp(level, "io.grpc.internal.ManagedChannelImpl$3", "uncaughtException", sb.toString(), th);
        try {
            zzbvrVar.a0(th);
        } catch (Throwable th2) {
            zzbvr zzbvrVar2 = this.f76915a;
            Logger logger2 = zzbvr.f76976e0;
            Level level2 = Level.SEVERE;
            String strValueOf2 = String.valueOf(zzbvrVar2.zzc());
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 37);
            sb2.append("[");
            sb2.append(strValueOf2);
            sb2.append("] Uncaught exception while panicking");
            logger2.logp(level2, "io.grpc.internal.ManagedChannelImpl$3", "uncaughtException", sb2.toString(), th2);
        }
    }
}
