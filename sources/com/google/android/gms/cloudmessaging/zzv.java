package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static zzv f71419e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f71421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzp f71422c = new zzp(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f71423d = 1;

    zzv(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f71421b = scheduledExecutorService;
        this.f71420a = context.getApplicationContext();
    }

    public static synchronized zzv b(Context context) {
        try {
            if (f71419e == null) {
                com.google.android.gms.internal.cloudmessaging.zze.zza();
                f71419e = new zzv(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f71419e;
    }

    private final synchronized int f() {
        int i3;
        i3 = this.f71423d;
        this.f71423d = i3 + 1;
        return i3;
    }

    private final synchronized Task g(zzs zzsVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(zzsVar.toString()));
            }
            if (!this.f71422c.g(zzsVar)) {
                zzp zzpVar = new zzp(this, null);
                this.f71422c = zzpVar;
                zzpVar.g(zzsVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzsVar.f71416b.getTask();
    }

    public final Task c(int i3, Bundle bundle) {
        return g(new zzr(f(), i3, bundle));
    }

    public final Task d(int i3, Bundle bundle) {
        return g(new zzu(f(), i3, bundle));
    }
}
