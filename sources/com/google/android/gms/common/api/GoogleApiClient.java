package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class GoogleApiClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f71512a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Account f71513a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f71516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f71517e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f71518f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f71519g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Context f71521i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private LifecycleActivity f71523k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private OnConnectionFailedListener f71525m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Looper f71526n;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set f71514b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set f71515c = new HashSet();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map f71520h = new ArrayMap();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Map f71522j = new ArrayMap();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f71524l = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private GoogleApiAvailability f71527o = GoogleApiAvailability.q();

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private Api.AbstractClientBuilder f71528p = com.google.android.gms.signin.zad.f74579c;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final ArrayList f71529q = new ArrayList();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final ArrayList f71530r = new ArrayList();

        public Builder(Context context) {
            this.f71521i = context;
            this.f71526n = context.getMainLooper();
            this.f71518f = context.getPackageName();
            this.f71519g = context.getClass().getName();
        }

        public Builder a(Api api) {
            Preconditions.n(api, "Api must not be null");
            this.f71522j.put(api, null);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.n(api.c(), "Base client builder must not be null")).getImpliedScopes(null);
            this.f71515c.addAll(impliedScopes);
            this.f71514b.addAll(impliedScopes);
            return this;
        }

        public Builder b(ConnectionCallbacks connectionCallbacks) {
            Preconditions.n(connectionCallbacks, "Listener must not be null");
            this.f71529q.add(connectionCallbacks);
            return this;
        }

        public Builder c(OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.n(onConnectionFailedListener, "Listener must not be null");
            this.f71530r.add(onConnectionFailedListener);
            return this;
        }

        public GoogleApiClient d() {
            Preconditions.b(!this.f71522j.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings clientSettingsE = e();
            Map mapK = clientSettingsE.k();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z2 = false;
            for (Api api2 : this.f71522j.keySet()) {
                Object obj = this.f71522j.get(api2);
                boolean z3 = mapK.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z3));
                zat zatVar = new zat(api2, z3);
                arrayList.add(zatVar);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) Preconditions.m(api2.a());
                Api.Client clientBuildClient = abstractClientBuilder.buildClient(this.f71521i, this.f71526n, clientSettingsE, obj, (ConnectionCallbacks) zatVar, (OnConnectionFailedListener) zatVar);
                arrayMap2.put(api2.b(), clientBuildClient);
                if (abstractClientBuilder.getPriority() == 1) {
                    z2 = obj != null;
                }
                if (clientBuildClient.providesSignIn()) {
                    if (api != null) {
                        throw new IllegalStateException(api2.d() + " cannot be used with " + api.d());
                    }
                    api = api2;
                }
            }
            if (api != null) {
                if (z2) {
                    throw new IllegalStateException("With using " + api.d() + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                }
                Preconditions.s(this.f71513a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.d());
                Preconditions.s(this.f71514b.equals(this.f71515c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.d());
            }
            zabe zabeVar = new zabe(this.f71521i, new ReentrantLock(), this.f71526n, clientSettingsE, this.f71527o, this.f71528p, arrayMap, this.f71529q, this.f71530r, arrayMap2, this.f71524l, zabe.t(arrayMap2.values(), true), arrayList);
            synchronized (GoogleApiClient.f71512a) {
                GoogleApiClient.f71512a.add(zabeVar);
            }
            if (this.f71524l >= 0) {
                zak.i(this.f71523k).j(this.f71524l, zabeVar, this.f71525m);
            }
            return zabeVar;
        }

        public final ClientSettings e() {
            SignInOptions signInOptions = SignInOptions.f74552k;
            Map map = this.f71522j;
            Api api = com.google.android.gms.signin.zad.f74583g;
            if (map.containsKey(api)) {
                signInOptions = (SignInOptions) this.f71522j.get(api);
            }
            return new ClientSettings(this.f71513a, this.f71514b, this.f71520h, this.f71516d, this.f71517e, this.f71518f, this.f71519g, signInOptions, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static Set i() {
        Set set = f71512a;
        synchronized (set) {
        }
        return set;
    }

    public abstract void d();

    public abstract void e();

    public abstract void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public BaseImplementation.ApiMethodImpl g(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new UnsupportedOperationException();
    }

    public BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new UnsupportedOperationException();
    }

    public Api.Client j(Api.AnyClientKey anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public Looper k() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean l();

    public boolean m(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    public void n() {
        throw new UnsupportedOperationException();
    }

    public abstract void o(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void p(OnConnectionFailedListener onConnectionFailedListener);

    public void q(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    public void r(zada zadaVar) {
        throw new UnsupportedOperationException();
    }
}
