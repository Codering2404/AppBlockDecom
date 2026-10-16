package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f71431a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue f71432b = new LinkedBlockingQueue();

    public IBinder a(long j3, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.l("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f71431a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f71431a = true;
        IBinder iBinder = (IBinder) this.f71432b.poll(j3, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f71432b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
