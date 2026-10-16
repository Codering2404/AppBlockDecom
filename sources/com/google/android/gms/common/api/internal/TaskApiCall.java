package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Feature[] f71615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f71617c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<A extends Api.AnyClient, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RemoteCall f71618a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Feature[] f71620c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f71619b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f71621d = 0;

        /* synthetic */ Builder(zacw zacwVar) {
        }

        public TaskApiCall a() {
            Preconditions.b(this.f71618a != null, "execute parameter required");
            return new zacv(this, this.f71620c, this.f71619b, this.f71621d);
        }

        public Builder b(RemoteCall remoteCall) {
            this.f71618a = remoteCall;
            return this;
        }

        public Builder c(boolean z2) {
            this.f71619b = z2;
            return this;
        }

        public Builder d(Feature... featureArr) {
            this.f71620c = featureArr;
            return this;
        }

        public Builder e(int i3) {
            this.f71621d = i3;
            return this;
        }
    }

    protected TaskApiCall(Feature[] featureArr, boolean z2, int i3) {
        this.f71615a = featureArr;
        boolean z3 = false;
        if (featureArr != null && z2) {
            z3 = true;
        }
        this.f71616b = z3;
        this.f71617c = i3;
    }

    public static Builder a() {
        return new Builder(null);
    }

    protected abstract void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource);

    public boolean c() {
        return this.f71616b;
    }

    public final int d() {
        return this.f71617c;
    }

    public final Feature[] e() {
        return this.f71615a;
    }
}
