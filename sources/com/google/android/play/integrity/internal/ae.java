package com.google.android.play.integrity.internal;

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
public final class ae {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Map f83163o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f83164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f83165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f83166c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f83170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Intent f83171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final z f83172i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ServiceConnection f83176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IInterface f83177n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f83167d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f83168e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f83169f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final IBinder.DeathRecipient f83174k = new IBinder.DeathRecipient() { // from class: com.google.android.play.integrity.internal.u
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ae.k(this.f83189a);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicInteger f83175l = new AtomicInteger(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final WeakReference f83173j = new WeakReference(null);

    public ae(Context context, s sVar, String str, Intent intent, z zVar, y yVar) {
        this.f83164a = context;
        this.f83165b = sVar;
        this.f83166c = str;
        this.f83171h = intent;
        this.f83172i = zVar;
    }

    public static /* synthetic */ void k(ae aeVar) {
        aeVar.f83165b.d("reportBinderDeath", new Object[0]);
        y yVar = (y) aeVar.f83173j.get();
        if (yVar != null) {
            aeVar.f83165b.d("calling onBinderDied", new Object[0]);
            yVar.a();
        } else {
            aeVar.f83165b.d("%s : Binder has died.", aeVar.f83166c);
            Iterator it = aeVar.f83167d.iterator();
            while (it.hasNext()) {
                ((t) it.next()).a(aeVar.w());
            }
            aeVar.f83167d.clear();
        }
        synchronized (aeVar.f83169f) {
            aeVar.x();
        }
    }

    static /* bridge */ /* synthetic */ void o(final ae aeVar, final TaskCompletionSource taskCompletionSource) {
        aeVar.f83168e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.integrity.internal.v
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f83190a.u(taskCompletionSource, task);
            }
        });
    }

    static /* bridge */ /* synthetic */ void q(ae aeVar, t tVar) {
        if (aeVar.f83177n != null || aeVar.f83170g) {
            if (!aeVar.f83170g) {
                tVar.run();
                return;
            } else {
                aeVar.f83165b.d("Waiting to bind to the service.", new Object[0]);
                aeVar.f83167d.add(tVar);
                return;
            }
        }
        aeVar.f83165b.d("Initiate binding to the service.", new Object[0]);
        aeVar.f83167d.add(tVar);
        ad adVar = new ad(aeVar, null);
        aeVar.f83176m = adVar;
        aeVar.f83170g = true;
        if (aeVar.f83164a.bindService(aeVar.f83171h, adVar, 1)) {
            return;
        }
        aeVar.f83165b.d("Failed to bind to the service.", new Object[0]);
        aeVar.f83170g = false;
        Iterator it = aeVar.f83167d.iterator();
        while (it.hasNext()) {
            ((t) it.next()).a(new af());
        }
        aeVar.f83167d.clear();
    }

    static /* bridge */ /* synthetic */ void r(ae aeVar) {
        aeVar.f83165b.d("linkToDeath", new Object[0]);
        try {
            aeVar.f83177n.asBinder().linkToDeath(aeVar.f83174k, 0);
        } catch (RemoteException e3) {
            aeVar.f83165b.c(e3, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void s(ae aeVar) {
        aeVar.f83165b.d("unlinkToDeath", new Object[0]);
        aeVar.f83177n.asBinder().unlinkToDeath(aeVar.f83174k, 0);
    }

    private final RemoteException w() {
        return new RemoteException(String.valueOf(this.f83166c).concat(" : Binder has died."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        Iterator it = this.f83168e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(w());
        }
        this.f83168e.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = f83163o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f83166c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f83166c, 10);
                    handlerThread.start();
                    map.put(this.f83166c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f83166c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final IInterface e() {
        return this.f83177n;
    }

    public final void t(t tVar, TaskCompletionSource taskCompletionSource) {
        c().post(new w(this, tVar.c(), taskCompletionSource, tVar));
    }

    final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f83169f) {
            this.f83168e.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f83169f) {
            this.f83168e.remove(taskCompletionSource);
        }
        c().post(new x(this));
    }
}
