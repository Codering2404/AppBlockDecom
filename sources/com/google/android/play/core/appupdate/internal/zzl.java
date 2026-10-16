package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final zzm f82863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntentFilter f82864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f82865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Set f82866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzk f82867e;

    private final void e() {
        zzk zzkVar;
        if (!this.f82866d.isEmpty() && this.f82867e == null) {
            zzk zzkVar2 = new zzk(this, null);
            this.f82867e = zzkVar2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f82865c.registerReceiver(zzkVar2, this.f82864b, 2);
            } else {
                this.f82865c.registerReceiver(zzkVar2, this.f82864b);
            }
        }
        if (!this.f82866d.isEmpty() || (zzkVar = this.f82867e) == null) {
            return;
        }
        this.f82865c.unregisterReceiver(zzkVar);
        this.f82867e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Context context, Intent intent);

    public final synchronized void b(StateUpdatedListener stateUpdatedListener) {
        this.f82863a.d("registerListener", new Object[0]);
        zzac.a(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.f82866d.add(stateUpdatedListener);
        e();
    }

    public final synchronized void c(StateUpdatedListener stateUpdatedListener) {
        this.f82863a.d("unregisterListener", new Object[0]);
        zzac.a(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.f82866d.remove(stateUpdatedListener);
        e();
    }

    public final synchronized void d(Object obj) {
        Iterator it = new HashSet(this.f82866d).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).a(obj);
        }
    }
}
