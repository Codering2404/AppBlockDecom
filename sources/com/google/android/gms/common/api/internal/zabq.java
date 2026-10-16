package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Api.Client f71752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ApiKey f71753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zaad f71754d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f71757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zact f71758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f71759j;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f71763n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f71751a = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f71755f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f71756g = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f71760k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ConnectionResult f71761l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f71762m = 0;

    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.f71763n = googleApiManager;
        Api.Client clientZab = googleApi.zab(googleApiManager.f71578o.getLooper(), this);
        this.f71752b = clientZab;
        this.f71753c = googleApi.getApiKey();
        this.f71754d = new zaad();
        this.f71757h = googleApi.zaa();
        if (clientZab.requiresSignIn()) {
            this.f71758i = googleApi.zac(googleApiManager.f71569f, googleApiManager.f71578o);
        } else {
            this.f71758i = null;
        }
    }

    static /* bridge */ /* synthetic */ void A(zabq zabqVar, zabs zabsVar) {
        Feature[] featureArrG;
        if (zabqVar.f71760k.remove(zabsVar)) {
            zabqVar.f71763n.f71578o.removeMessages(15, zabsVar);
            zabqVar.f71763n.f71578o.removeMessages(16, zabsVar);
            Feature feature = zabsVar.f71765b;
            ArrayList arrayList = new ArrayList(zabqVar.f71751a.size());
            for (zai zaiVar : zabqVar.f71751a) {
                if ((zaiVar instanceof zac) && (featureArrG = ((zac) zaiVar).g(zabqVar)) != null && ArrayUtils.b(featureArrG, feature)) {
                    arrayList.add(zaiVar);
                }
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                zai zaiVar2 = (zai) arrayList.get(i3);
                zabqVar.f71751a.remove(zaiVar2);
                zaiVar2.b(new UnsupportedApiCallException(feature));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Feature c(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] availableFeatures = this.f71752b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                arrayMap.put(feature.getName(), Long.valueOf(feature.N()));
            }
            for (Feature feature2 : featureArr) {
                Long l3 = (Long) arrayMap.get(feature2.getName());
                if (l3 == null || l3.longValue() < feature2.N()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    private final void d(ConnectionResult connectionResult) {
        Iterator it = this.f71755f.iterator();
        while (it.hasNext()) {
            ((zal) it.next()).b(this.f71753c, connectionResult, Objects.b(connectionResult, ConnectionResult.f71433g) ? this.f71752b.getEndpointPackageName() : null);
        }
        this.f71755f.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Status status) {
        Preconditions.d(this.f71763n.f71578o);
        f(status, null, false);
    }

    private final void f(Status status, Exception exc, boolean z2) {
        Preconditions.d(this.f71763n.f71578o);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f71751a.iterator();
        while (it.hasNext()) {
            zai zaiVar = (zai) it.next();
            if (!z2 || zaiVar.f71839a == 2) {
                if (status != null) {
                    zaiVar.a(status);
                } else {
                    zaiVar.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void g() {
        ArrayList arrayList = new ArrayList(this.f71751a);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zai zaiVar = (zai) arrayList.get(i3);
            if (!this.f71752b.isConnected()) {
                return;
            }
            if (m(zaiVar)) {
                this.f71751a.remove(zaiVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        B();
        d(ConnectionResult.f71433g);
        l();
        Iterator it = this.f71756g.values().iterator();
        while (it.hasNext()) {
            zaci zaciVar = (zaci) it.next();
            if (c(zaciVar.f71795a.c()) != null) {
                it.remove();
            } else {
                try {
                    zaciVar.f71795a.d(this.f71752b, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.f71752b.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        g();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(int i3) {
        B();
        this.f71759j = true;
        this.f71754d.e(i3, this.f71752b.getLastDisconnectMessage());
        ApiKey apiKey = this.f71753c;
        GoogleApiManager googleApiManager = this.f71763n;
        googleApiManager.f71578o.sendMessageDelayed(Message.obtain(googleApiManager.f71578o, 9, apiKey), 5000L);
        ApiKey apiKey2 = this.f71753c;
        GoogleApiManager googleApiManager2 = this.f71763n;
        googleApiManager2.f71578o.sendMessageDelayed(Message.obtain(googleApiManager2.f71578o, 11, apiKey2), 120000L);
        this.f71763n.f71571h.c();
        Iterator it = this.f71756g.values().iterator();
        while (it.hasNext()) {
            ((zaci) it.next()).f71797c.run();
        }
    }

    private final void j() {
        this.f71763n.f71578o.removeMessages(12, this.f71753c);
        ApiKey apiKey = this.f71753c;
        GoogleApiManager googleApiManager = this.f71763n;
        googleApiManager.f71578o.sendMessageDelayed(googleApiManager.f71578o.obtainMessage(12, apiKey), this.f71763n.f71565a);
    }

    private final void k(zai zaiVar) {
        zaiVar.d(this.f71754d, a());
        try {
            zaiVar.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f71752b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void l() {
        if (this.f71759j) {
            GoogleApiManager googleApiManager = this.f71763n;
            googleApiManager.f71578o.removeMessages(11, this.f71753c);
            GoogleApiManager googleApiManager2 = this.f71763n;
            googleApiManager2.f71578o.removeMessages(9, this.f71753c);
            this.f71759j = false;
        }
    }

    private final boolean m(zai zaiVar) {
        if (!(zaiVar instanceof zac)) {
            k(zaiVar);
            return true;
        }
        zac zacVar = (zac) zaiVar;
        Feature featureC = c(zacVar.g(this));
        if (featureC == null) {
            k(zaiVar);
            return true;
        }
        Log.w("GoogleApiManager", this.f71752b.getClass().getName() + " could not execute call because it requires feature (" + featureC.getName() + ", " + featureC.N() + ").");
        if (!this.f71763n.f71579p || !zacVar.f(this)) {
            zacVar.b(new UnsupportedApiCallException(featureC));
            return true;
        }
        zabs zabsVar = new zabs(this.f71753c, featureC, null);
        int iIndexOf = this.f71760k.indexOf(zabsVar);
        if (iIndexOf >= 0) {
            zabs zabsVar2 = (zabs) this.f71760k.get(iIndexOf);
            this.f71763n.f71578o.removeMessages(15, zabsVar2);
            GoogleApiManager googleApiManager = this.f71763n;
            googleApiManager.f71578o.sendMessageDelayed(Message.obtain(googleApiManager.f71578o, 15, zabsVar2), 5000L);
            return false;
        }
        this.f71760k.add(zabsVar);
        GoogleApiManager googleApiManager2 = this.f71763n;
        googleApiManager2.f71578o.sendMessageDelayed(Message.obtain(googleApiManager2.f71578o, 15, zabsVar), 5000L);
        GoogleApiManager googleApiManager3 = this.f71763n;
        googleApiManager3.f71578o.sendMessageDelayed(Message.obtain(googleApiManager3.f71578o, 16, zabsVar), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (n(connectionResult)) {
            return false;
        }
        this.f71763n.f(connectionResult, this.f71757h);
        return false;
    }

    private final boolean n(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.f71563s) {
            try {
                GoogleApiManager googleApiManager = this.f71763n;
                if (googleApiManager.f71575l == null || !googleApiManager.f71576m.contains(this.f71753c)) {
                    return false;
                }
                this.f71763n.f71575l.h(connectionResult, this.f71757h);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(boolean z2) {
        Preconditions.d(this.f71763n.f71578o);
        if (!this.f71752b.isConnected() || !this.f71756g.isEmpty()) {
            return false;
        }
        if (!this.f71754d.g()) {
            this.f71752b.disconnect("Timing out service connection.");
            return true;
        }
        if (!z2) {
            return false;
        }
        j();
        return false;
    }

    static /* bridge */ /* synthetic */ void z(zabq zabqVar, zabs zabsVar) {
        if (zabqVar.f71760k.contains(zabsVar) && !zabqVar.f71759j) {
            if (zabqVar.f71752b.isConnected()) {
                zabqVar.g();
            } else {
                zabqVar.C();
            }
        }
    }

    public final void B() {
        Preconditions.d(this.f71763n.f71578o);
        this.f71761l = null;
    }

    public final void C() {
        Preconditions.d(this.f71763n.f71578o);
        if (this.f71752b.isConnected() || this.f71752b.isConnecting()) {
            return;
        }
        try {
            GoogleApiManager googleApiManager = this.f71763n;
            int iB = googleApiManager.f71571h.b(googleApiManager.f71569f, this.f71752b);
            if (iB == 0) {
                GoogleApiManager googleApiManager2 = this.f71763n;
                Api.Client client = this.f71752b;
                zabu zabuVar = new zabu(googleApiManager2, client, this.f71753c);
                if (client.requiresSignIn()) {
                    ((zact) Preconditions.m(this.f71758i)).j5(zabuVar);
                }
                try {
                    this.f71752b.connect(zabuVar);
                    return;
                } catch (SecurityException e3) {
                    F(new ConnectionResult(10), e3);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f71752b.getClass().getName() + " is not available: " + connectionResult.toString());
            F(connectionResult, null);
        } catch (IllegalStateException e4) {
            F(new ConnectionResult(10), e4);
        }
    }

    public final void D(zai zaiVar) {
        Preconditions.d(this.f71763n.f71578o);
        if (this.f71752b.isConnected()) {
            if (m(zaiVar)) {
                j();
                return;
            } else {
                this.f71751a.add(zaiVar);
                return;
            }
        }
        this.f71751a.add(zaiVar);
        ConnectionResult connectionResult = this.f71761l;
        if (connectionResult == null || !connectionResult.j0()) {
            C();
        } else {
            F(this.f71761l, null);
        }
    }

    final void E() {
        this.f71762m++;
    }

    public final void F(ConnectionResult connectionResult, Exception exc) {
        Preconditions.d(this.f71763n.f71578o);
        zact zactVar = this.f71758i;
        if (zactVar != null) {
            zactVar.k5();
        }
        B();
        this.f71763n.f71571h.c();
        d(connectionResult);
        if ((this.f71752b instanceof com.google.android.gms.common.internal.service.zap) && connectionResult.N() != 24) {
            this.f71763n.f71566b = true;
            GoogleApiManager googleApiManager = this.f71763n;
            googleApiManager.f71578o.sendMessageDelayed(googleApiManager.f71578o.obtainMessage(19), 300000L);
        }
        if (connectionResult.N() == 4) {
            e(GoogleApiManager.f71562r);
            return;
        }
        if (this.f71751a.isEmpty()) {
            this.f71761l = connectionResult;
            return;
        }
        if (exc != null) {
            Preconditions.d(this.f71763n.f71578o);
            f(null, exc, false);
            return;
        }
        if (!this.f71763n.f71579p) {
            e(GoogleApiManager.g(this.f71753c, connectionResult));
            return;
        }
        f(GoogleApiManager.g(this.f71753c, connectionResult), null, true);
        if (this.f71751a.isEmpty() || n(connectionResult) || this.f71763n.f(connectionResult, this.f71757h)) {
            return;
        }
        if (connectionResult.N() == 18) {
            this.f71759j = true;
        }
        if (!this.f71759j) {
            e(GoogleApiManager.g(this.f71753c, connectionResult));
            return;
        }
        GoogleApiManager googleApiManager2 = this.f71763n;
        googleApiManager2.f71578o.sendMessageDelayed(Message.obtain(googleApiManager2.f71578o, 9, this.f71753c), 5000L);
    }

    public final void G(ConnectionResult connectionResult) {
        Preconditions.d(this.f71763n.f71578o);
        Api.Client client = this.f71752b;
        client.disconnect("onSignInFailed for " + client.getClass().getName() + " with " + String.valueOf(connectionResult));
        F(connectionResult, null);
    }

    public final void H(zal zalVar) {
        Preconditions.d(this.f71763n.f71578o);
        this.f71755f.add(zalVar);
    }

    public final void I() {
        Preconditions.d(this.f71763n.f71578o);
        if (this.f71759j) {
            C();
        }
    }

    public final void J() {
        Preconditions.d(this.f71763n.f71578o);
        e(GoogleApiManager.f71561q);
        this.f71754d.f();
        for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.f71756g.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            D(new zah(listenerKey, new TaskCompletionSource()));
        }
        d(new ConnectionResult(4));
        if (this.f71752b.isConnected()) {
            this.f71752b.onUserSignOut(new zabp(this));
        }
    }

    public final void K() {
        Preconditions.d(this.f71763n.f71578o);
        if (this.f71759j) {
            l();
            GoogleApiManager googleApiManager = this.f71763n;
            e(googleApiManager.f71570g.i(googleApiManager.f71569f) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f71752b.disconnect("Timing out connection while resuming.");
        }
    }

    final boolean N() {
        return this.f71752b.isConnected();
    }

    public final boolean a() {
        return this.f71752b.requiresSignIn();
    }

    public final boolean b() {
        return o(true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.f71763n.f71578o.getLooper()) {
            h();
        } else {
            this.f71763n.f71578o.post(new zabm(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        F(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        if (Looper.myLooper() == this.f71763n.f71578o.getLooper()) {
            i(i3);
        } else {
            this.f71763n.f71578o.post(new zabn(this, i3));
        }
    }

    public final int p() {
        return this.f71757h;
    }

    final int q() {
        return this.f71762m;
    }

    public final ConnectionResult r() {
        Preconditions.d(this.f71763n.f71578o);
        return this.f71761l;
    }

    public final Api.Client t() {
        return this.f71752b;
    }

    public final Map v() {
        return this.f71756g;
    }

    @Override // com.google.android.gms.common.api.internal.zau
    public final void x3(ConnectionResult connectionResult, Api api, boolean z2) {
        throw null;
    }
}
