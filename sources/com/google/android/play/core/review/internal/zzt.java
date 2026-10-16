package com.google.android.play.core.review.internal;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzt {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Map f83123n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f83124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzi f83125b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f83130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Intent f83131h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ServiceConnection f83135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IInterface f83136m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f83127d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f83128e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f83129f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IBinder.DeathRecipient f83133j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.review.internal.zzk
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzt.j(this.f83112a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f83134k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f83126c = "com.google.android.finsky.inappreviewservice.InAppReviewService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakReference f83132i = new WeakReference(null);

    public zzt(Context context, zzi zziVar, String str, Intent intent, com.google.android.play.core.review.zze zzeVar, zzo zzoVar) {
        this.f83124a = context;
        this.f83125b = zziVar;
        this.f83131h = intent;
    }

    public static /* synthetic */ void j(zzt zztVar) {
        zztVar.f83125b.c("reportBinderDeath", new Object[0]);
        zzo zzoVar = (zzo) zztVar.f83132i.get();
        if (zzoVar != null) {
            zztVar.f83125b.c("calling onBinderDied", new Object[0]);
            zzoVar.zza();
        } else {
            zztVar.f83125b.c("%s : Binder has died.", zztVar.f83126c);
            Iterator it = zztVar.f83127d.iterator();
            while (it.hasNext()) {
                ((zzj) it.next()).c(zztVar.v());
            }
            zztVar.f83127d.clear();
        }
        synchronized (zztVar.f83129f) {
            zztVar.w();
        }
    }

    static /* bridge */ /* synthetic */ void n(final zzt zztVar, final TaskCompletionSource taskCompletionSource) {
        zztVar.f83128e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.review.internal.zzl
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f83113a.t(taskCompletionSource, task);
            }
        });
    }

    static /* bridge */ /* synthetic */ void p(zzt zztVar, zzj zzjVar) {
        if (zztVar.f83136m != null || zztVar.f83130g) {
            if (!zztVar.f83130g) {
                zzjVar.run();
                return;
            } else {
                zztVar.f83125b.c("Waiting to bind to the service.", new Object[0]);
                zztVar.f83127d.add(zzjVar);
                return;
            }
        }
        zztVar.f83125b.c("Initiate binding to the service.", new Object[0]);
        zztVar.f83127d.add(zzjVar);
        zzr zzrVar = new zzr(zztVar, null);
        zztVar.f83135l = zzrVar;
        zztVar.f83130g = true;
        if (zztVar.f83124a.bindService(zztVar.f83131h, zzrVar, 1)) {
            return;
        }
        zztVar.f83125b.c("Failed to bind to the service.", new Object[0]);
        zztVar.f83130g = false;
        Iterator it = zztVar.f83127d.iterator();
        while (it.hasNext()) {
            ((zzj) it.next()).c(new zzu());
        }
        zztVar.f83127d.clear();
    }

    static /* bridge */ /* synthetic */ void q(zzt zztVar) {
        zztVar.f83125b.c("linkToDeath", new Object[0]);
        try {
            zztVar.f83136m.asBinder().linkToDeath(zztVar.f83133j, 0);
        } catch (RemoteException e3) {
            zztVar.f83125b.b(e3, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void r(zzt zztVar) {
        zztVar.f83125b.c("unlinkToDeath", new Object[0]);
        zztVar.f83136m.asBinder().unlinkToDeath(zztVar.f83133j, 0);
    }

    private final RemoteException v() {
        return new RemoteException(String.valueOf(this.f83126c).concat(" : Binder has died."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Iterator it = this.f83128e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(v());
        }
        this.f83128e.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = f83123n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f83126c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f83126c, 10);
                    handlerThread.start();
                    map.put(this.f83126c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f83126c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f83136m;
    }

    public final void s(zzj zzjVar, TaskCompletionSource taskCompletionSource) {
        c().post(new zzm(this, zzjVar.b(), taskCompletionSource, zzjVar));
    }

    final /* synthetic */ void t(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f83129f) {
            this.f83128e.remove(taskCompletionSource);
        }
    }

    public final void u(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f83129f) {
            this.f83128e.remove(taskCompletionSource);
        }
        c().post(new zzn(this));
    }
}
