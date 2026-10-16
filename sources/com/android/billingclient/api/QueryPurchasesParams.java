package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class QueryPurchasesParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f57351b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f57352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f57353b = false;

        /* synthetic */ Builder(zzed zzedVar) {
        }

        public QueryPurchasesParams a() {
            String str = this.f57352a;
            if (str == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            if (!this.f57353b || str.equals("subs")) {
                return new QueryPurchasesParams(this, null);
            }
            throw new IllegalArgumentException("includeSuspendedSubscriptions is only supported for subscription purchases");
        }

        public Builder b(String str) {
            this.f57352a = str;
            return this;
        }
    }

    /* synthetic */ QueryPurchasesParams(Builder builder, zzed zzedVar) {
        this.f57350a = builder.f57352a;
        this.f57351b = builder.f57353b;
    }

    public static Builder b() {
        return new Builder(null);
    }

    public boolean a() {
        return this.f57351b;
    }

    public final String c() {
        return this.f57350a;
    }
}
