package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zad extends zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f72316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GoogleApiAvailability f72317b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zad(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f72317b = googleApiAvailability;
        this.f72316a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i3);
            return;
        }
        GoogleApiAvailability googleApiAvailability = this.f72317b;
        int i4 = googleApiAvailability.i(this.f72316a);
        if (googleApiAvailability.m(i4)) {
            this.f72317b.s(this.f72316a, i4);
        }
    }
}
