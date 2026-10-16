package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zak implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zaj f72053a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f72060i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f72054b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList f72055c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f72056d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f72057f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f72058g = new AtomicInteger(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f72059h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f72061j = new Object();

    public zak(Looper looper, zaj zajVar) {
        this.f72053a = zajVar;
        this.f72060i = new com.google.android.gms.internal.base.zau(looper, this);
    }

    public final void a() {
        this.f72057f = false;
        this.f72058g.incrementAndGet();
    }

    public final void b() {
        this.f72057f = true;
    }

    public final void c(ConnectionResult connectionResult) {
        Preconditions.e(this.f72060i, "onConnectionFailure must only be called on the Handler thread");
        this.f72060i.removeMessages(1);
        synchronized (this.f72061j) {
            try {
                ArrayList arrayList = new ArrayList(this.f72056d);
                int i3 = this.f72058g.get();
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) obj;
                    if (this.f72057f && this.f72058g.get() == i3) {
                        if (this.f72056d.contains(onConnectionFailedListener)) {
                            onConnectionFailedListener.onConnectionFailed(connectionResult);
                        }
                    }
                    return;
                }
            } finally {
            }
        }
    }

    public final void d(Bundle bundle) {
        Preconditions.e(this.f72060i, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f72061j) {
            try {
                Preconditions.q(!this.f72059h);
                this.f72060i.removeMessages(1);
                this.f72059h = true;
                Preconditions.q(this.f72055c.isEmpty());
                ArrayList arrayList = new ArrayList(this.f72054b);
                int i3 = this.f72058g.get();
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.f72057f || !this.f72053a.isConnected() || this.f72058g.get() != i3) {
                        break;
                    } else if (!this.f72055c.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
                this.f72055c.clear();
                this.f72059h = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(int i3) {
        Preconditions.e(this.f72060i, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f72060i.removeMessages(1);
        synchronized (this.f72061j) {
            try {
                this.f72059h = true;
                ArrayList arrayList = new ArrayList(this.f72054b);
                int i4 = this.f72058g.get();
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                    if (!this.f72057f || this.f72058g.get() != i4) {
                        break;
                    } else if (this.f72054b.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i3);
                    }
                }
                this.f72055c.clear();
                this.f72059h = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.m(connectionCallbacks);
        synchronized (this.f72061j) {
            try {
                if (this.f72054b.contains(connectionCallbacks)) {
                    Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + String.valueOf(connectionCallbacks) + " is already registered");
                } else {
                    this.f72054b.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f72053a.isConnected()) {
            Handler handler = this.f72060i;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void g(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.m(onConnectionFailedListener);
        synchronized (this.f72061j) {
            try {
                if (this.f72056d.contains(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " is already registered");
                } else {
                    this.f72056d.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.m(onConnectionFailedListener);
        synchronized (this.f72061j) {
            try {
                if (!this.f72056d.remove(onConnectionFailedListener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + String.valueOf(onConnectionFailedListener) + " not found");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i3, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.f72061j) {
            try {
                if (this.f72057f && this.f72053a.isConnected() && this.f72054b.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }
}
