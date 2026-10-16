package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class GmsClientSupervisor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f71990a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f71991b = 9;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static zzq f71992c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static HandlerThread f71993d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Executor f71994e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f71995f = false;

    public static int a() {
        return 4225;
    }

    public static GmsClientSupervisor b(Context context) {
        synchronized (f71990a) {
            try {
                if (f71992c == null) {
                    f71992c = new zzq(context.getApplicationContext(), f71995f ? c().getLooper() : context.getMainLooper(), f71994e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f71992c;
    }

    public static HandlerThread c() {
        synchronized (f71990a) {
            try {
                HandlerThread handlerThread = f71993d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", f71991b);
                f71993d = handlerThread2;
                handlerThread2.start();
                return f71993d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract ConnectionResult d(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor);

    public final void e(String str, String str2, int i3, ServiceConnection serviceConnection, String str3, boolean z2) {
        f(new zzn(str, str2, 4225, z2), serviceConnection, str3);
    }

    protected abstract void f(zzn zznVar, ServiceConnection serviceConnection, String str);
}
