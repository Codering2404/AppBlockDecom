package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f74029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Boolean f74030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f74031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.google.android.gms.internal.measurement.zzdd f74032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f74033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Long f74034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f74035g;

    public zzjs(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l3) {
        this.f74033e = true;
        Preconditions.m(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.m(applicationContext);
        this.f74029a = applicationContext;
        this.f74034f = l3;
        if (zzddVar != null) {
            this.f74032d = zzddVar;
            this.f74033e = zzddVar.zzc;
            this.f74031c = zzddVar.zzb;
            this.f74035g = zzddVar.zze;
            Bundle bundle = zzddVar.zzd;
            if (bundle != null) {
                this.f74030b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
