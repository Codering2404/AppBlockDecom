package com.android.billingclient.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class QueryProductDetailsParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.internal.play_billing.zzbw f57341a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.gms.internal.play_billing.zzbw f57342a;

        /* synthetic */ Builder(zzeb zzebVar) {
        }

        public QueryProductDetailsParams a() {
            if (this.f57342a != null) {
                return new QueryProductDetailsParams(this, null);
            }
            throw new IllegalArgumentException("Product list must be set to a non empty list.");
        }

        public Builder b(List list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Product product = (Product) it.next();
                if (!"play_pass_subs".equals(product.c())) {
                    hashSet.add(product.c());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.f57342a = com.google.android.gms.internal.play_billing.zzbw.zzj(list);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Product {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f57344b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f57345a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f57346b;

            /* synthetic */ Builder(zzeb zzebVar) {
            }

            public Product a() {
                String str = this.f57346b;
                if ("first_party".equals(str)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if (this.f57345a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (str != null) {
                    return new Product(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }

            public Builder b(String str) {
                this.f57345a = str;
                return this;
            }

            public Builder c(String str) {
                this.f57346b = str;
                return this;
            }
        }

        /* synthetic */ Product(Builder builder, zzeb zzebVar) {
            this.f57343a = builder.f57345a;
            this.f57344b = builder.f57346b;
        }

        public static Builder a() {
            return new Builder(null);
        }

        public final String b() {
            return this.f57343a;
        }

        public final String c() {
            return this.f57344b;
        }
    }

    /* synthetic */ QueryProductDetailsParams(Builder builder, zzeb zzebVar) {
        this.f57341a = builder.f57342a;
    }

    public static Builder a() {
        return new Builder(null);
    }

    public final com.google.android.gms.internal.play_billing.zzbw b() {
        return this.f57341a;
    }

    public final String c() {
        return ((Product) this.f57341a.get(0)).c();
    }
}
