package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabe extends GoogleApiClient implements zabz {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f71702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.common.internal.zak f71703c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f71705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f71706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Looper f71707g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f71709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f71710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f71711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zabc f71712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final GoogleApiAvailability f71713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    zabx f71714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final Map f71715o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Set f71716p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final ClientSettings f71717q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final Map f71718r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final Api.AbstractClientBuilder f71719s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ListenerHolders f71720t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList f71721u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Integer f71722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Set f71723w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final zadc f71724x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final com.google.android.gms.common.internal.zaj f71725y;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zaca f71704d = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Queue f71708h = new LinkedList();

    public zabe(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder abstractClientBuilder, Map map, List list, List list2, Map map2, int i3, int i4, ArrayList arrayList) {
        this.f71710j = true != ClientLibraryUtils.a() ? 120000L : 10000L;
        this.f71711k = 5000L;
        this.f71716p = new HashSet();
        this.f71720t = new ListenerHolders();
        this.f71722v = null;
        this.f71723w = null;
        zaay zaayVar = new zaay(this);
        this.f71725y = zaayVar;
        this.f71706f = context;
        this.f71702b = lock;
        this.f71703c = new com.google.android.gms.common.internal.zak(looper, zaayVar);
        this.f71707g = looper;
        this.f71712l = new zabc(this, looper);
        this.f71713m = googleApiAvailability;
        this.f71705e = i3;
        if (i3 >= 0) {
            this.f71722v = Integer.valueOf(i4);
        }
        this.f71718r = map;
        this.f71715o = map2;
        this.f71721u = arrayList;
        this.f71724x = new zadc();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f71703c.f((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f71703c.g((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.f71717q = clientSettings;
        this.f71719s = abstractClientBuilder;
    }

    private final void B(int i3) {
        zabe zabeVar;
        Integer num = this.f71722v;
        if (num == null) {
            this.f71722v = Integer.valueOf(i3);
        } else if (num.intValue() != i3) {
            throw new IllegalStateException("Cannot use sign-in mode: " + w(i3) + ". Mode was already set to " + w(this.f71722v.intValue()));
        }
        if (this.f71704d != null) {
            return;
        }
        boolean zRequiresSignIn = false;
        boolean zProvidesSignIn = false;
        for (Api.Client client : this.f71715o.values()) {
            zRequiresSignIn |= client.requiresSignIn();
            zProvidesSignIn |= client.providesSignIn();
        }
        int iIntValue = this.f71722v.intValue();
        if (iIntValue == 1) {
            zabeVar = this;
            if (!zRequiresSignIn) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (zProvidesSignIn) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else {
            if (iIntValue == 2 && zRequiresSignIn) {
                this.f71704d = zaaa.p(this.f71706f, this, this.f71702b, this.f71707g, this.f71713m, this.f71715o, this.f71717q, this.f71718r, this.f71719s, this.f71721u);
                return;
            }
            zabeVar = this;
        }
        zabeVar.f71704d = new zabi(zabeVar.f71706f, zabeVar, zabeVar.f71702b, zabeVar.f71707g, zabeVar.f71713m, zabeVar.f71715o, zabeVar.f71717q, zabeVar.f71718r, zabeVar.f71719s, zabeVar.f71721u, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z2) {
        Common.f72032d.a(googleApiClient).setResultCallback(new zabb(this, statusPendingResult, z2, googleApiClient));
    }

    private final void D() {
        this.f71703c.b();
        ((zaca) Preconditions.m(this.f71704d)).a();
    }

    public static int t(Iterable iterable, boolean z2) {
        Iterator it = iterable.iterator();
        boolean zRequiresSignIn = false;
        boolean zProvidesSignIn = false;
        while (it.hasNext()) {
            Api.Client client = (Api.Client) it.next();
            zRequiresSignIn |= client.requiresSignIn();
            zProvidesSignIn |= client.providesSignIn();
        }
        if (zRequiresSignIn) {
            return (zProvidesSignIn && z2) ? 2 : 1;
        }
        return 3;
    }

    static String w(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE" : "SIGN_IN_MODE_OPTIONAL" : "SIGN_IN_MODE_REQUIRED";
    }

    static /* bridge */ /* synthetic */ void y(zabe zabeVar) {
        zabeVar.f71702b.lock();
        try {
            if (zabeVar.f71709i) {
                zabeVar.D();
            }
        } finally {
            zabeVar.f71702b.unlock();
        }
    }

    static /* bridge */ /* synthetic */ void z(zabe zabeVar) {
        zabeVar.f71702b.lock();
        try {
            if (zabeVar.A()) {
                zabeVar.D();
            }
        } finally {
            zabeVar.f71702b.unlock();
        }
    }

    final boolean A() {
        if (!this.f71709i) {
            return false;
        }
        this.f71709i = false;
        this.f71712l.removeMessages(2);
        this.f71712l.removeMessages(1);
        zabx zabxVar = this.f71714n;
        if (zabxVar != null) {
            zabxVar.b();
            this.f71714n = null;
        }
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void a(Bundle bundle) {
        while (!this.f71708h.isEmpty()) {
            h((BaseImplementation.ApiMethodImpl) this.f71708h.remove());
        }
        this.f71703c.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void b(int i3, boolean z2) {
        if (i3 == 1) {
            if (!z2 && !this.f71709i) {
                this.f71709i = true;
                if (this.f71714n == null && !ClientLibraryUtils.a()) {
                    try {
                        this.f71714n = this.f71713m.v(this.f71706f.getApplicationContext(), new zabd(this));
                    } catch (SecurityException unused) {
                    }
                }
                zabc zabcVar = this.f71712l;
                zabcVar.sendMessageDelayed(zabcVar.obtainMessage(1), this.f71710j);
                zabc zabcVar2 = this.f71712l;
                zabcVar2.sendMessageDelayed(zabcVar2.obtainMessage(2), this.f71711k);
            }
            i3 = 1;
        }
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f71724x.f71831a.toArray(new BasePendingResult[0])) {
            basePendingResult.forceFailureUnlessReady(zadc.f71830c);
        }
        this.f71703c.e(i3);
        this.f71703c.a();
        if (i3 == 2) {
            D();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void c(ConnectionResult connectionResult) {
        if (!this.f71713m.k(this.f71706f, connectionResult.N())) {
            A();
        }
        if (this.f71709i) {
            return;
        }
        this.f71703c.c(connectionResult);
        this.f71703c.a();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void d() {
        this.f71702b.lock();
        try {
            int i3 = 2;
            boolean z2 = false;
            if (this.f71705e >= 0) {
                Preconditions.r(this.f71722v != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.f71722v;
                if (num == null) {
                    this.f71722v = Integer.valueOf(t(this.f71715o.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            int iIntValue = ((Integer) Preconditions.m(this.f71722v)).intValue();
            this.f71702b.lock();
            try {
                if (iIntValue != 3 && iIntValue != 1) {
                    if (iIntValue != 2) {
                        i3 = iIntValue;
                    }
                    Preconditions.b(z2, "Illegal sign-in mode: " + i3);
                    B(i3);
                    D();
                    this.f71702b.unlock();
                    return;
                }
                i3 = iIntValue;
                Preconditions.b(z2, "Illegal sign-in mode: " + i3);
                B(i3);
                D();
                this.f71702b.unlock();
                return;
            } finally {
                this.f71702b.unlock();
            }
            z2 = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void e() {
        this.f71702b.lock();
        try {
            this.f71724x.b();
            zaca zacaVar = this.f71704d;
            if (zacaVar != null) {
                zacaVar.d();
            }
            this.f71720t.d();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.f71708h) {
                apiMethodImpl.zan(null);
                apiMethodImpl.cancel();
            }
            this.f71708h.clear();
            if (this.f71704d != null) {
                A();
                this.f71703c.a();
            }
            this.f71702b.unlock();
        } catch (Throwable th) {
            this.f71702b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f71706f);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f71709i);
        printWriter.append(" mWorkQueue.size()=").print(this.f71708h.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f71724x.f71831a.size());
        zaca zacaVar = this.f71704d;
        if (zacaVar != null) {
            zacaVar.f(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final BaseImplementation.ApiMethodImpl g(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        Api<?> api = apiMethodImpl.getApi();
        Preconditions.b(this.f71715o.containsKey(apiMethodImpl.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.d() : "the API") + " required for this call.");
        this.f71702b.lock();
        try {
            zaca zacaVar = this.f71704d;
            if (zacaVar == null) {
                this.f71708h.add(apiMethodImpl);
            } else {
                apiMethodImpl = zacaVar.g(apiMethodImpl);
            }
            this.f71702b.unlock();
            return apiMethodImpl;
        } catch (Throwable th) {
            this.f71702b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        Map map = this.f71715o;
        Api<?> api = apiMethodImpl.getApi();
        Preconditions.b(map.containsKey(apiMethodImpl.getClientKey()), "GoogleApiClient is not configured to use " + (api != null ? api.d() : "the API") + " required for this call.");
        this.f71702b.lock();
        try {
            zaca zacaVar = this.f71704d;
            if (zacaVar == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f71709i) {
                this.f71708h.add(apiMethodImpl);
                while (!this.f71708h.isEmpty()) {
                    BaseImplementation.ApiMethodImpl apiMethodImpl2 = (BaseImplementation.ApiMethodImpl) this.f71708h.remove();
                    this.f71724x.a(apiMethodImpl2);
                    apiMethodImpl2.setFailedResult(Status.f71539i);
                }
            } else {
                apiMethodImpl = zacaVar.i(apiMethodImpl);
            }
            this.f71702b.unlock();
            return apiMethodImpl;
        } catch (Throwable th) {
            this.f71702b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Api.Client j(Api.AnyClientKey anyClientKey) {
        Api.Client client = (Api.Client) this.f71715o.get(anyClientKey);
        Preconditions.n(client, "Appropriate Api was not requested.");
        return client;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper k() {
        return this.f71707g;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean l() {
        zaca zacaVar = this.f71704d;
        return zacaVar != null && zacaVar.h();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean m(SignInConnectionListener signInConnectionListener) {
        zaca zacaVar = this.f71704d;
        return zacaVar != null && zacaVar.e(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void n() {
        zaca zacaVar = this.f71704d;
        if (zacaVar != null) {
            zacaVar.c();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void o(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f71703c.g(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void p(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f71703c.h(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void q(zada zadaVar) {
        this.f71702b.lock();
        try {
            if (this.f71723w == null) {
                this.f71723w = new HashSet();
            }
            this.f71723w.add(zadaVar);
            this.f71702b.unlock();
        } catch (Throwable th) {
            this.f71702b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void r(zada zadaVar) {
        this.f71702b.lock();
        try {
            Set set = this.f71723w;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (set.remove(zadaVar)) {
                this.f71702b.lock();
                try {
                    Set set2 = this.f71723w;
                    if (set2 == null) {
                        this.f71702b.unlock();
                    } else {
                        boolean zIsEmpty = set2.isEmpty();
                        this.f71702b.unlock();
                        if (zIsEmpty) {
                        }
                    }
                    zaca zacaVar = this.f71704d;
                    if (zacaVar != null) {
                        zacaVar.b();
                    }
                } finally {
                    this.f71702b.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final String v() {
        StringWriter stringWriter = new StringWriter();
        f("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
