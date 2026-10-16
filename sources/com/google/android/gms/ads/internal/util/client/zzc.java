package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzc extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f70158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f70159b;

    zzc(zzf zzfVar, Context context, String str) {
        this.f70158a = context;
        this.f70159b = str;
        Objects.requireNonNull(zzfVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzu(this.f70158a, null).b(this.f70159b, null);
    }
}
