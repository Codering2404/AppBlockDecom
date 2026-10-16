package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f74055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f74056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f74057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f74058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f74059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f74060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ zzlj f74061j;

    zzkc(zzlj zzljVar, String str, String str2, long j3, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        this.f74053a = str;
        this.f74054b = str2;
        this.f74055c = j3;
        this.f74056d = bundle;
        this.f74057f = z2;
        this.f74058g = z3;
        this.f74059h = z4;
        this.f74060i = str3;
        Objects.requireNonNull(zzljVar);
        this.f74061j = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74061j.v(this.f74053a, this.f74054b, this.f74055c, this.f74056d, this.f74057f, this.f74058g, this.f74059h, this.f74060i);
    }
}
