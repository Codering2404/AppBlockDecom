package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabi implements zaca, zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f71728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Condition f71729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f71730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f71731d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zabh f71732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Map f71733g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final ClientSettings f71735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Map f71736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Api.AbstractClientBuilder f71737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile zabf f71738l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f71740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final zabe f71741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final zabz f71742p;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map f71734h = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ConnectionResult f71739m = null;

    public zabi(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList, zabz zabzVar) {
        this.f71730c = context;
        this.f71728a = lock;
        this.f71731d = googleApiAvailabilityLight;
        this.f71733g = map;
        this.f71735i = clientSettings;
        this.f71736j = map2;
        this.f71737k = abstractClientBuilder;
        this.f71741o = zabeVar;
        this.f71742p = zabzVar;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((zat) arrayList.get(i3)).a(this);
        }
        this.f71732f = new zabh(this, looper);
        this.f71729b = lock.newCondition();
        this.f71738l = new zaax(this);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void a() {
        this.f71738l.c();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void b() {
        if (this.f71738l instanceof zaaj) {
            ((zaaj) this.f71738l).j();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void d() {
        if (this.f71738l.g()) {
            this.f71734h.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean e(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").println(this.f71738l);
        for (Api api : this.f71736j.keySet()) {
            String strValueOf = String.valueOf(str);
            printWriter.append((CharSequence) str).append((CharSequence) api.d()).println(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            ((Api.Client) Preconditions.m((Api.Client) this.f71733g.get(api.b()))).dump(strValueOf.concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl g(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.f71738l.f(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean h() {
        return this.f71738l instanceof zaaj;
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl i(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        return this.f71738l.h(apiMethodImpl);
    }

    final void l() {
        this.f71728a.lock();
        try {
            this.f71741o.A();
            this.f71738l = new zaaj(this);
            this.f71738l.b();
            this.f71729b.signalAll();
        } finally {
            this.f71728a.unlock();
        }
    }

    final void m() throws Throwable {
        zabi zabiVar;
        this.f71728a.lock();
        try {
            zabiVar = this;
            try {
                zabiVar.f71738l = new zaaw(zabiVar, this.f71735i, this.f71736j, this.f71731d, this.f71737k, this.f71728a, this.f71730c);
                zabiVar.f71738l.b();
                zabiVar.f71729b.signalAll();
                zabiVar.f71728a.unlock();
            } catch (Throwable th) {
                th = th;
                zabiVar.f71728a.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zabiVar = this;
        }
    }

    final void n(ConnectionResult connectionResult) {
        this.f71728a.lock();
        try {
            this.f71739m = connectionResult;
            this.f71738l = new zaax(this);
            this.f71738l.b();
            this.f71729b.signalAll();
        } finally {
            this.f71728a.unlock();
        }
    }

    final void o(zabg zabgVar) {
        zabh zabhVar = this.f71732f;
        zabhVar.sendMessage(zabhVar.obtainMessage(1, zabgVar));
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f71728a.lock();
        try {
            this.f71738l.a(bundle);
        } finally {
            this.f71728a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        this.f71728a.lock();
        try {
            this.f71738l.e(i3);
        } finally {
            this.f71728a.unlock();
        }
    }

    final void p(RuntimeException runtimeException) {
        zabh zabhVar = this.f71732f;
        zabhVar.sendMessage(zabhVar.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void x3(ConnectionResult connectionResult, Api api, boolean z2) {
        this.f71728a.lock();
        try {
            this.f71738l.d(connectionResult, api, z2);
        } finally {
            this.f71728a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void c() {
    }
}
