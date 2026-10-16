package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaaw implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zabi f71669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f71670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f71671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f71672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConnectionResult f71673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f71674f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f71676h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.google.android.gms.signin.zae f71679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f71680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f71681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f71682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private IAccountAccessor f71683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f71684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f71685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ClientSettings f71686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Map f71687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Api.AbstractClientBuilder f71688t;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f71675g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Bundle f71677i = new Bundle();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set f71678j = new HashSet();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList f71689u = new ArrayList();

    public zaaw(zabi zabiVar, ClientSettings clientSettings, Map map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder abstractClientBuilder, Lock lock, Context context) {
        this.f71669a = zabiVar;
        this.f71686r = clientSettings;
        this.f71687s = map;
        this.f71672d = googleApiAvailabilityLight;
        this.f71688t = abstractClientBuilder;
        this.f71670b = lock;
        this.f71671c = context;
    }

    static /* bridge */ /* synthetic */ void B(zaaw zaawVar, com.google.android.gms.signin.internal.zak zakVar) {
        if (zaawVar.o(0)) {
            ConnectionResult connectionResultM = zakVar.M();
            if (!connectionResultM.w0()) {
                if (!zaawVar.q(connectionResultM)) {
                    zaawVar.l(connectionResultM);
                    return;
                } else {
                    zaawVar.i();
                    zaawVar.n();
                    return;
                }
            }
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.m(zakVar.N());
            ConnectionResult connectionResultM2 = zavVar.M();
            if (!connectionResultM2.w0()) {
                String strValueOf = String.valueOf(connectionResultM2);
                Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zaawVar.l(connectionResultM2);
                return;
            }
            zaawVar.f71682n = true;
            zaawVar.f71683o = (IAccountAccessor) Preconditions.m(zavVar.N());
            zaawVar.f71684p = zavVar.O();
            zaawVar.f71685q = zavVar.g0();
            zaawVar.n();
        }
    }

    private final void J() {
        ArrayList arrayList = this.f71689u;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Future) arrayList.get(i3)).cancel(true);
        }
        this.f71689u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        this.f71681m = false;
        this.f71669a.f71741o.f71716p = Collections.EMPTY_SET;
        for (Api.AnyClientKey anyClientKey : this.f71678j) {
            if (!this.f71669a.f71734h.containsKey(anyClientKey)) {
                zabi zabiVar = this.f71669a;
                zabiVar.f71734h.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    private final void j(boolean z2) {
        com.google.android.gms.signin.zae zaeVar = this.f71679k;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z2) {
                zaeVar.a();
            }
            zaeVar.disconnect();
            this.f71683o = null;
        }
    }

    private final void k() {
        this.f71669a.l();
        zabj.a().execute(new zaak(this));
        com.google.android.gms.signin.zae zaeVar = this.f71679k;
        if (zaeVar != null) {
            if (this.f71684p) {
                zaeVar.d((IAccountAccessor) Preconditions.m(this.f71683o), this.f71685q);
            }
            j(false);
        }
        Iterator it = this.f71669a.f71734h.keySet().iterator();
        while (it.hasNext()) {
            ((Api.Client) Preconditions.m((Api.Client) this.f71669a.f71733g.get((Api.AnyClientKey) it.next()))).disconnect();
        }
        this.f71669a.f71742p.a(this.f71677i.isEmpty() ? null : this.f71677i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ConnectionResult connectionResult) {
        J();
        j(!connectionResult.j0());
        this.f71669a.n(connectionResult);
        this.f71669a.f71742p.c(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(ConnectionResult connectionResult, Api api, boolean z2) {
        int priority = api.c().getPriority();
        if ((!z2 || connectionResult.j0() || this.f71672d.c(connectionResult.N()) != null) && (this.f71673e == null || priority < this.f71674f)) {
            this.f71673e = connectionResult;
            this.f71674f = priority;
        }
        zabi zabiVar = this.f71669a;
        zabiVar.f71734h.put(api.b(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (this.f71676h != 0) {
            return;
        }
        if (!this.f71681m || this.f71682n) {
            ArrayList arrayList = new ArrayList();
            this.f71675g = 1;
            this.f71676h = this.f71669a.f71733g.size();
            for (Api.AnyClientKey anyClientKey : this.f71669a.f71733g.keySet()) {
                if (!this.f71669a.f71734h.containsKey(anyClientKey)) {
                    arrayList.add((Api.Client) this.f71669a.f71733g.get(anyClientKey));
                } else if (p()) {
                    k();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f71689u.add(zabj.a().submit(new zaap(this, arrayList)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(int i3) {
        if (this.f71675g == i3) {
            return true;
        }
        Log.w("GACConnecting", this.f71669a.f71741o.v());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        Log.w("GACConnecting", "mRemainingConnections=" + this.f71676h);
        Log.e("GACConnecting", "GoogleApiClient connecting is in step " + r(this.f71675g) + " but received callback for step " + r(i3), new Exception());
        l(new ConnectionResult(8, null));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p() {
        int i3 = this.f71676h - 1;
        this.f71676h = i3;
        if (i3 > 0) {
            return false;
        }
        if (i3 < 0) {
            Log.w("GACConnecting", this.f71669a.f71741o.v());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            l(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f71673e;
        if (connectionResult == null) {
            return true;
        }
        this.f71669a.f71740n = this.f71674f;
        l(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(ConnectionResult connectionResult) {
        return this.f71680l && !connectionResult.j0();
    }

    private static final String r(int i3) {
        return i3 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set y(zaaw zaawVar) {
        ClientSettings clientSettings = zaawVar.f71686r;
        if (clientSettings == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(clientSettings.g());
        Map mapK = zaawVar.f71686r.k();
        for (Api api : mapK.keySet()) {
            zabi zabiVar = zaawVar.f71669a;
            if (!zabiVar.f71734h.containsKey(api.b())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zab) mapK.get(api)).f72040a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void a(Bundle bundle) {
        if (o(1)) {
            if (bundle != null) {
                this.f71677i.putAll(bundle);
            }
            if (p()) {
                k();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @Override // com.google.android.gms.common.api.internal.zabf
    public final void b() {
        this.f71669a.f71734h.clear();
        this.f71681m = false;
        zaas zaasVar = null;
        this.f71673e = null;
        this.f71675g = 0;
        this.f71680l = true;
        this.f71682n = false;
        this.f71684p = false;
        HashMap map = new HashMap();
        boolean z2 = false;
        for (Api api : this.f71687s.keySet()) {
            Api.Client client = (Api.Client) Preconditions.m((Api.Client) this.f71669a.f71733g.get(api.b()));
            z2 |= api.c().getPriority() == 1;
            boolean zBooleanValue = ((Boolean) this.f71687s.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.f71681m = true;
                if (zBooleanValue) {
                    this.f71678j.add(api.b());
                } else {
                    this.f71680l = false;
                }
            }
            map.put(client, new zaal(this, api, zBooleanValue));
        }
        if (z2) {
            this.f71681m = false;
        }
        if (this.f71681m) {
            Preconditions.m(this.f71686r);
            Preconditions.m(this.f71688t);
            this.f71686r.l(Integer.valueOf(System.identityHashCode(this.f71669a.f71741o)));
            zaat zaatVar = new zaat(this, zaasVar);
            Api.AbstractClientBuilder abstractClientBuilder = this.f71688t;
            Context context = this.f71671c;
            zabi zabiVar = this.f71669a;
            ClientSettings clientSettings = this.f71686r;
            this.f71679k = abstractClientBuilder.buildClient(context, zabiVar.f71741o.k(), clientSettings, clientSettings.h(), (GoogleApiClient.ConnectionCallbacks) zaatVar, (GoogleApiClient.OnConnectionFailedListener) zaatVar);
        }
        this.f71676h = this.f71669a.f71733g.size();
        this.f71689u.add(zabj.a().submit(new zaao(this, map)));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void d(ConnectionResult connectionResult, Api api, boolean z2) {
        if (o(1)) {
            m(connectionResult, api, z2);
            if (p()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void e(int i3) {
        l(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl f(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f71669a.f71741o.f71708h.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean g() {
        J();
        j(true);
        this.f71669a.n(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void c() {
    }
}
