package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ConnectionTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f72246b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ConnectionTracker f72247c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f72248a = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    public static ConnectionTracker b() {
        if (f72247c == null) {
            synchronized (f72246b) {
                try {
                    if (f72247c == null) {
                        f72247c = new ConnectionTracker();
                    }
                } finally {
                }
            }
        }
        ConnectionTracker connectionTracker = f72247c;
        Preconditions.m(connectionTracker);
        return connectionTracker;
    }

    private final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i3, boolean z2, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!f(serviceConnection)) {
            return h(context, intent, serviceConnection, i3, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f72248a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zH = h(context, intent, serviceConnection, i3, executor);
            if (zH) {
                return zH;
            }
            return false;
        } finally {
            this.f72248a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean f(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzr);
    }

    private static void g(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private static final boolean h(Context context, Intent intent, ServiceConnection serviceConnection, int i3, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!PlatformVersion.g() || executor == null) ? context.bindService(intent, serviceConnection, i3) : context.bindService(intent, i3, executor, serviceConnection);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i3) {
        return e(context, context.getClass().getName(), intent, serviceConnection, i3, true, null);
    }

    public void c(Context context, ServiceConnection serviceConnection) {
        if (f(serviceConnection)) {
            ConcurrentHashMap concurrentHashMap = this.f72248a;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    g(context, (ServiceConnection) concurrentHashMap.get(serviceConnection));
                    return;
                } finally {
                    this.f72248a.remove(serviceConnection);
                }
            }
        }
        g(context, serviceConnection);
    }

    public final boolean d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i3, Executor executor) {
        return e(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
