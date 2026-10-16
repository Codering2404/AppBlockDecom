package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzp implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    zzq f71409c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzv f71412g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f71407a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Messenger f71408b = new Messenger(new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzm
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i3 = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Received response to request: " + i3);
            }
            zzp zzpVar = this.f71404a;
            synchronized (zzpVar) {
                try {
                    zzs zzsVar = (zzs) zzpVar.f71411f.get(i3);
                    if (zzsVar == null) {
                        Log.w("MessengerIpcClient", "Received response for unknown request: " + i3);
                        return true;
                    }
                    zzpVar.f71411f.remove(i3);
                    zzpVar.f();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        zzsVar.c(new zzt(4, "Not supported by GmsCore", null));
                        return true;
                    }
                    zzsVar.a(data);
                    return true;
                } finally {
                }
            }
        }
    }));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Queue f71410d = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final SparseArray f71411f = new SparseArray();

    /* synthetic */ zzp(zzv zzvVar, zzo zzoVar) {
        this.f71412g = zzvVar;
    }

    final synchronized void a(int i3, String str) {
        b(i3, str, null);
    }

    final synchronized void b(int i3, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i4 = this.f71407a;
            if (i4 == 0) {
                throw new IllegalStateException();
            }
            if (i4 != 1 && i4 != 2) {
                if (i4 != 3) {
                    return;
                }
                this.f71407a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f71407a = 4;
            ConnectionTracker.b().c(this.f71412g.f71420a, this);
            zzt zztVar = new zzt(i3, str, th);
            Iterator it = this.f71410d.iterator();
            while (it.hasNext()) {
                ((zzs) it.next()).c(zztVar);
            }
            this.f71410d.clear();
            for (int i5 = 0; i5 < this.f71411f.size(); i5++) {
                ((zzs) this.f71411f.valueAt(i5)).c(zztVar);
            }
            this.f71411f.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    final void c() {
        this.f71412g.f71421b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzj
            @Override // java.lang.Runnable
            public final void run() {
                final zzs zzsVar;
                while (true) {
                    final zzp zzpVar = this.f71401a;
                    synchronized (zzpVar) {
                        try {
                            if (zzpVar.f71407a != 2) {
                                return;
                            }
                            if (zzpVar.f71410d.isEmpty()) {
                                zzpVar.f();
                                return;
                            } else {
                                zzsVar = (zzs) zzpVar.f71410d.poll();
                                zzpVar.f71411f.put(zzsVar.f71415a, zzsVar);
                                zzpVar.f71412g.f71421b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzn
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzpVar.e(zzsVar.f71415a);
                                    }
                                }, 30L, TimeUnit.SECONDS);
                            }
                        } finally {
                        }
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(zzsVar)));
                    }
                    zzv zzvVar = zzpVar.f71412g;
                    Messenger messenger = zzpVar.f71408b;
                    int i3 = zzsVar.f71417c;
                    Context context = zzvVar.f71420a;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i3;
                    messageObtain.arg1 = zzsVar.f71415a;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", zzsVar.b());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", zzsVar.f71418d);
                    messageObtain.setData(bundle);
                    try {
                        zzpVar.f71409c.a(messageObtain);
                    } catch (RemoteException e3) {
                        zzpVar.a(2, e3.getMessage());
                    }
                }
            }
        });
    }

    final synchronized void d() {
        if (this.f71407a == 1) {
            a(1, "Timed out while binding");
        }
    }

    final synchronized void e(int i3) {
        zzs zzsVar = (zzs) this.f71411f.get(i3);
        if (zzsVar != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i3);
            this.f71411f.remove(i3);
            zzsVar.c(new zzt(3, "Timed out waiting for response", null));
            f();
        }
    }

    final synchronized void f() {
        try {
            if (this.f71407a == 2 && this.f71410d.isEmpty() && this.f71411f.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f71407a = 3;
                ConnectionTracker.b().c(this.f71412g.f71420a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized boolean g(zzs zzsVar) {
        int i3 = this.f71407a;
        if (i3 != 0) {
            if (i3 == 1) {
                this.f71410d.add(zzsVar);
                return true;
            }
            if (i3 != 2) {
                return false;
            }
            this.f71410d.add(zzsVar);
            c();
            return true;
        }
        this.f71410d.add(zzsVar);
        Preconditions.q(this.f71407a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f71407a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(vfptEEmYY.eJxjHmdDbAJA);
        try {
            if (ConnectionTracker.b().a(this.f71412g.f71420a, intent, this, 1)) {
                this.f71412g.f71421b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f71402a.d();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e3) {
            b(0, "Unable to bind to service", e3);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f71412g.f71421b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
            @Override // java.lang.Runnable
            public final void run() {
                zzp zzpVar = this.f71399a;
                IBinder iBinder2 = iBinder;
                synchronized (zzpVar) {
                    if (iBinder2 == null) {
                        zzpVar.a(0, "Null service connection");
                        return;
                    }
                    try {
                        zzpVar.f71409c = new zzq(iBinder2);
                        zzpVar.f71407a = 2;
                        zzpVar.c();
                    } catch (RemoteException e3) {
                        zzpVar.a(0, e3.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f71412g.f71421b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzl
            @Override // java.lang.Runnable
            public final void run() {
                this.f71403a.a(2, "Service disconnected");
            }
        });
    }
}
