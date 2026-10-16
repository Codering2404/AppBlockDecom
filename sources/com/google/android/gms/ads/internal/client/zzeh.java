package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f69873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f69874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f69875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f69876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f69877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f69878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f69879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Bundle f69880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set f69881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f69882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f69883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f69884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f69885n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f69886o;

    public zzeh(zzeg zzegVar) {
        this.f69886o = 0L;
        this.f69872a = zzegVar.A();
        this.f69873b = zzegVar.B();
        this.f69874c = Collections.unmodifiableSet(zzegVar.u());
        this.f69875d = zzegVar.v();
        Collections.unmodifiableMap(zzegVar.w());
        this.f69876e = zzegVar.C();
        this.f69877f = zzegVar.a();
        this.f69878g = zzegVar.b();
        this.f69879h = Collections.unmodifiableSet(zzegVar.x());
        this.f69880i = zzegVar.y();
        this.f69881j = Collections.unmodifiableSet(zzegVar.z());
        this.f69882k = zzegVar.c();
        this.f69883l = zzegVar.d();
        this.f69884m = zzegVar.e();
        this.f69886o = zzegVar.f();
    }

    public final String a() {
        return this.f69872a;
    }

    public final List b() {
        return new ArrayList(this.f69873b);
    }

    public final Set c() {
        return this.f69874c;
    }

    public final Bundle d(Class cls) {
        return this.f69875d.getBundle(cls.getName());
    }

    public final String e() {
        return this.f69876e;
    }

    public final String f() {
        return this.f69877f;
    }

    public final boolean g(Context context) {
        RequestConfiguration requestConfigurationN = zzeu.f().n();
        zzay.a();
        Set set = this.f69879h;
        String strF = com.google.android.gms.ads.internal.util.client.zzf.f(context);
        return set.contains(strF) || requestConfigurationN.e().contains(strF);
    }

    public final Bundle h() {
        return this.f69875d;
    }

    public final int i() {
        return this.f69878g;
    }

    public final Bundle j() {
        return this.f69880i;
    }

    public final Set k() {
        return this.f69881j;
    }

    public final boolean l() {
        return this.f69882k;
    }

    public final String m() {
        return this.f69883l;
    }

    public final int n() {
        return this.f69884m;
    }

    public final void o(long j3) {
        this.f69885n = j3;
    }

    public final long p() {
        return this.f69885n;
    }

    public final long q() {
        return this.f69886o;
    }
}
