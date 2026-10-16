package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaaa implements zaca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zabe f71625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Looper f71626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zabi f71627d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zabi f71628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f71629g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Api.Client f71631i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bundle f71632j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lock f71636n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f71630h = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConnectionResult f71633k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ConnectionResult f71634l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f71635m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f71637o = 0;

    /* JADX WARN: Multi-variable type inference failed */
    private zaaa(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, Map map2, ClientSettings clientSettings, Api.AbstractClientBuilder abstractClientBuilder, Api.Client client, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f71624a = context;
        this.f71625b = zabeVar;
        this.f71636n = lock;
        this.f71626c = looper;
        this.f71631i = client;
        this.f71627d = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zax(this, null));
        this.f71628f = new zabi(context, zabeVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this, 0 == true ? 1 : 0));
        ArrayMap arrayMap = new ArrayMap();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((Api.AnyClientKey) it.next(), this.f71627d);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put((Api.AnyClientKey) it2.next(), this.f71628f);
        }
        this.f71629g = Collections.unmodifiableMap(arrayMap);
    }

    private final PendingIntent B() {
        Api.Client client = this.f71631i;
        if (client == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f71624a, System.identityHashCode(this.f71625b), client.getSignInIntent(), com.google.android.gms.internal.base.zap.zaa | 134217728);
    }

    private final void j(ConnectionResult connectionResult) {
        int i3 = this.f71637o;
        if (i3 == 1) {
            k();
        } else if (i3 != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.f71625b.c(connectionResult);
            k();
        }
        this.f71637o = 0;
    }

    private final void k() {
        Iterator it = this.f71630h.iterator();
        while (it.hasNext()) {
            ((SignInConnectionListener) it.next()).onComplete();
        }
        this.f71630h.clear();
    }

    private final boolean l() {
        ConnectionResult connectionResult = this.f71634l;
        return connectionResult != null && connectionResult.N() == 4;
    }

    private final boolean m(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zabi zabiVar = (zabi) this.f71629g.get(apiMethodImpl.getClientKey());
        Preconditions.n(zabiVar, "GoogleApiClient is not configured to use the API required for this call.");
        return zabiVar.equals(this.f71628f);
    }

    private static boolean n(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.w0();
    }

    public static zaaa p(Context context, zabe zabeVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map map, ClientSettings clientSettings, Map map2, Api.AbstractClientBuilder abstractClientBuilder, ArrayList arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry entry : map.entrySet()) {
            Api.Client client2 = (Api.Client) entry.getValue();
            if (true == client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                arrayMap.put((Api.AnyClientKey) entry.getKey(), client2);
            } else {
                arrayMap2.put((Api.AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.r(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            Api.AnyClientKey anyClientKeyB = api.b();
            if (arrayMap.containsKey(anyClientKeyB)) {
                arrayMap3.put(api, (Boolean) map2.get(api));
            } else {
                if (!arrayMap2.containsKey(anyClientKeyB)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, (Boolean) map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zat zatVar = (zat) arrayList.get(i3);
            if (arrayMap3.containsKey(zatVar.f71861a)) {
                arrayList2.add(zatVar);
            } else {
                if (!arrayMap4.containsKey(zatVar.f71861a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zatVar);
            }
        }
        return new zaaa(context, zabeVar, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    static /* bridge */ /* synthetic */ void w(zaaa zaaaVar, int i3, boolean z2) {
        zaaaVar.f71625b.b(i3, z2);
        zaaaVar.f71634l = null;
        zaaaVar.f71633k = null;
    }

    static /* bridge */ /* synthetic */ void x(zaaa zaaaVar, Bundle bundle) {
        Bundle bundle2 = zaaaVar.f71632j;
        if (bundle2 == null) {
            zaaaVar.f71632j = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void y(zaaa zaaaVar) {
        ConnectionResult connectionResult;
        if (!n(zaaaVar.f71633k)) {
            if (zaaaVar.f71633k != null && n(zaaaVar.f71634l)) {
                zaaaVar.f71628f.d();
                zaaaVar.j((ConnectionResult) Preconditions.m(zaaaVar.f71633k));
                return;
            }
            ConnectionResult connectionResult2 = zaaaVar.f71633k;
            if (connectionResult2 == null || (connectionResult = zaaaVar.f71634l) == null) {
                return;
            }
            if (zaaaVar.f71628f.f71740n < zaaaVar.f71627d.f71740n) {
                connectionResult2 = connectionResult;
            }
            zaaaVar.j(connectionResult2);
            return;
        }
        if (n(zaaaVar.f71634l) || zaaaVar.l()) {
            int i3 = zaaaVar.f71637o;
            if (i3 == 1) {
                zaaaVar.k();
            } else if (i3 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((zabe) Preconditions.m(zaaaVar.f71625b)).a(zaaaVar.f71632j);
                zaaaVar.k();
            }
            zaaaVar.f71637o = 0;
            return;
        }
        ConnectionResult connectionResult3 = zaaaVar.f71634l;
        if (connectionResult3 != null) {
            if (zaaaVar.f71637o == 1) {
                zaaaVar.k();
            } else {
                zaaaVar.j(connectionResult3);
                zaaaVar.f71627d.d();
            }
        }
    }

    public final boolean A() {
        this.f71636n.lock();
        try {
            return this.f71637o == 2;
        } finally {
            this.f71636n.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void a() {
        this.f71637o = 2;
        this.f71635m = false;
        this.f71634l = null;
        this.f71633k = null;
        this.f71627d.a();
        this.f71628f.a();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void b() {
        this.f71627d.b();
        this.f71628f.b();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void c() {
        this.f71636n.lock();
        try {
            boolean zA = A();
            this.f71628f.d();
            this.f71634l = new ConnectionResult(4);
            if (zA) {
                new com.google.android.gms.internal.base.zau(this.f71626c).post(new zav(this));
            } else {
                k();
            }
            this.f71636n.unlock();
        } catch (Throwable th) {
            this.f71636n.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void d() {
        this.f71634l = null;
        this.f71633k = null;
        this.f71637o = 0;
        this.f71627d.d();
        this.f71628f.d();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final boolean e(SignInConnectionListener signInConnectionListener) {
        this.f71636n.lock();
        try {
            boolean z2 = false;
            if (A() || h()) {
                if (!this.f71628f.h()) {
                    this.f71630h.add(signInConnectionListener);
                    z2 = true;
                    if (this.f71637o == 0) {
                        this.f71637o = 1;
                    }
                    this.f71634l = null;
                    this.f71628f.a();
                }
            }
            this.f71636n.unlock();
            return z2;
        } catch (Throwable th) {
            this.f71636n.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        this.f71628f.f(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        this.f71627d.f(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl g(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!m(apiMethodImpl)) {
            this.f71627d.g(apiMethodImpl);
            return apiMethodImpl;
        }
        if (l()) {
            apiMethodImpl.setFailedResult(new Status(4, (String) null, B()));
            return apiMethodImpl;
        }
        this.f71628f.g(apiMethodImpl);
        return apiMethodImpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    @Override // com.google.android.gms.common.api.internal.zaca
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.f71636n
            r0.lock()
            com.google.android.gms.common.api.internal.zabi r0 = r3.f71627d     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.h()     // Catch: java.lang.Throwable -> L23
            r1 = 0
            if (r0 == 0) goto L25
            com.google.android.gms.common.api.internal.zabi r0 = r3.f71628f     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.h()     // Catch: java.lang.Throwable -> L23
            r2 = 1
            if (r0 != 0) goto L21
            boolean r0 = r3.l()     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L21
            int r0 = r3.f71637o     // Catch: java.lang.Throwable -> L23
            if (r0 != r2) goto L25
        L21:
            r1 = r2
            goto L25
        L23:
            r0 = move-exception
            goto L2b
        L25:
            java.util.concurrent.locks.Lock r0 = r3.f71636n
            r0.unlock()
            return r1
        L2b:
            java.util.concurrent.locks.Lock r1 = r3.f71636n
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaaa.h():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zaca
    public final BaseImplementation.ApiMethodImpl i(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        if (!m(apiMethodImpl)) {
            return this.f71627d.i(apiMethodImpl);
        }
        if (!l()) {
            return this.f71628f.i(apiMethodImpl);
        }
        apiMethodImpl.setFailedResult(new Status(4, (String) null, B()));
        return apiMethodImpl;
    }
}
