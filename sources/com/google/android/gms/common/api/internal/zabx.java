package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f71775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zabw f71776b;

    public zabx(zabw zabwVar) {
        this.f71776b = zabwVar;
    }

    public final void a(Context context) {
        this.f71775a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f71775a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f71775a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f71776b.a();
            b();
        }
    }
}
