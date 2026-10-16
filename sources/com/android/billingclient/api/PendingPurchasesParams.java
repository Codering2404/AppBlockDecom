package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PendingPurchasesParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f57263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f57264b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f57265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f57266b;

        private Builder() {
        }

        public PendingPurchasesParams a() {
            if (!this.f57265a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new PendingPurchasesParams(true, this.f57266b);
        }

        public Builder b() {
            this.f57265a = true;
            return this;
        }

        public Builder c() {
            this.f57266b = true;
            return this;
        }
    }

    private PendingPurchasesParams(boolean z2, boolean z3) {
        this.f57263a = z2;
        this.f57264b = z3;
    }

    public static Builder c() {
        return new Builder();
    }

    boolean a() {
        return this.f57263a;
    }

    boolean b() {
        return this.f57264b;
    }
}
