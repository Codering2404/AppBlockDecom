package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzx {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Map f82881n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f82882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzm f82883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f82884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f82885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f82886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f82887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f82888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Intent f82889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakReference f82890i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IBinder.DeathRecipient f82891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f82892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ServiceConnection f82893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IInterface f82894m;

    public static /* synthetic */ void j(zzx zzxVar) {
        zzxVar.f82883b.d("reportBinderDeath", new Object[0]);
        zzs zzsVar = (zzs) zzxVar.f82890i.get();
        if (zzsVar != null) {
            zzxVar.f82883b.d("calling onBinderDied", new Object[0]);
            zzsVar.zza();
        } else {
            zzxVar.f82883b.d("%s : Binder has died.", zzxVar.f82884c);
            Iterator it = zzxVar.f82885d.iterator();
            while (it.hasNext()) {
                ((zzn) it.next()).c(zzxVar.v());
            }
            zzxVar.f82885d.clear();
        }
        synchronized (zzxVar.f82887f) {
            zzxVar.w();
        }
    }

    static /* bridge */ /* synthetic */ void n(final zzx zzxVar, final TaskCompletionSource taskCompletionSource) {
        zzxVar.f82886e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.appupdate.internal.zzo
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f82870a.t(taskCompletionSource, task);
            }
        });
    }

    static /* bridge */ /* synthetic */ void p(zzx zzxVar, zzn zznVar) {
        if (zzxVar.f82894m != null || zzxVar.f82888g) {
            if (!zzxVar.f82888g) {
                zznVar.run();
                return;
            } else {
                zzxVar.f82883b.d("Waiting to bind to the service.", new Object[0]);
                zzxVar.f82885d.add(zznVar);
                return;
            }
        }
        zzxVar.f82883b.d("Initiate binding to the service.", new Object[0]);
        zzxVar.f82885d.add(zznVar);
        zzw zzwVar = new zzw(zzxVar, null);
        zzxVar.f82893l = zzwVar;
        zzxVar.f82888g = true;
        if (zzxVar.f82882a.bindService(zzxVar.f82889h, zzwVar, 1)) {
            return;
        }
        zzxVar.f82883b.d("Failed to bind to the service.", new Object[0]);
        zzxVar.f82888g = false;
        Iterator it = zzxVar.f82885d.iterator();
        while (it.hasNext()) {
            ((zzn) it.next()).c(new zzy());
        }
        zzxVar.f82885d.clear();
    }

    static /* bridge */ /* synthetic */ void q(zzx zzxVar) {
        zzxVar.f82883b.d("linkToDeath", new Object[0]);
        try {
            zzxVar.f82894m.asBinder().linkToDeath(zzxVar.f82891j, 0);
        } catch (RemoteException e3) {
            zzxVar.f82883b.c(e3, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void r(zzx zzxVar) {
        zzxVar.f82883b.d("unlinkToDeath", new Object[0]);
        zzxVar.f82894m.asBinder().unlinkToDeath(zzxVar.f82891j, 0);
    }

    private final RemoteException v() {
        return new RemoteException(String.valueOf(this.f82884c).concat(" : Binder has died."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Iterator it = this.f82886e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(v());
        }
        this.f82886e.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = f82881n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f82884c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f82884c, 10);
                    handlerThread.start();
                    map.put(this.f82884c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f82884c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f82894m;
    }

    public final void s(zzn zznVar, TaskCompletionSource taskCompletionSource) {
        c().post(new zzq(this, zznVar.b(), taskCompletionSource, zznVar));
    }

    final /* synthetic */ void t(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f82887f) {
            this.f82886e.remove(taskCompletionSource);
        }
    }

    public final void u(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f82887f) {
            this.f82886e.remove(taskCompletionSource);
        }
        c().post(new zzr(this));
    }
}
