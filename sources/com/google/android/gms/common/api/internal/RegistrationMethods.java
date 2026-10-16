package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RegisterListenerMethod f71604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UnregisterListenerMethod f71605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f71606c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<A extends Api.AnyClient, L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RemoteCall f71607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RemoteCall f71608b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ListenerHolder f71610d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Feature[] f71611e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f71613g;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f71609c = new Runnable() { // from class: com.google.android.gms.common.api.internal.zacj
            @Override // java.lang.Runnable
            public final void run() {
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f71612f = true;

        /* synthetic */ Builder(zacm zacmVar) {
        }

        public RegistrationMethods a() {
            Preconditions.b(this.f71607a != null, "Must set register function");
            Preconditions.b(this.f71608b != null, "Must set unregister function");
            Preconditions.b(this.f71610d != null, "Must set holder");
            return new RegistrationMethods(new zack(this, this.f71610d, this.f71611e, this.f71612f, this.f71613g), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.n(this.f71610d.b(), "Key must not be null")), this.f71609c, null);
        }

        public Builder b(RemoteCall remoteCall) {
            this.f71607a = remoteCall;
            return this;
        }

        public Builder c(int i3) {
            this.f71613g = i3;
            return this;
        }

        public Builder d(RemoteCall remoteCall) {
            this.f71608b = remoteCall;
            return this;
        }

        public Builder e(ListenerHolder listenerHolder) {
            this.f71610d = listenerHolder;
            return this;
        }
    }

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacnVar) {
        this.f71604a = registerListenerMethod;
        this.f71605b = unregisterListenerMethod;
        this.f71606c = runnable;
    }

    public static Builder a() {
        return new Builder(null);
    }
}
