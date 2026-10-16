package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TaskCompletionSource f71416b = new TaskCompletionSource();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f71417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Bundle f71418d;

    zzs(int i3, int i4, Bundle bundle) {
        this.f71415a = i3;
        this.f71417c = i4;
        this.f71418d = bundle;
    }

    abstract void a(Bundle bundle);

    abstract boolean b();

    final void c(zzt zztVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + zztVar.toString());
        }
        this.f71416b.setException(zztVar);
    }

    final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.f71416b.setResult(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f71417c + " id=" + this.f71415a + " oneWay=" + b() + "}";
    }
}
