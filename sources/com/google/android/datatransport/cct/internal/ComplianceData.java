package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.AutoValue_ComplianceData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ComplianceData {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ComplianceData a();

        public abstract Builder b(ExternalPrivacyContext externalPrivacyContext);

        public abstract Builder c(ProductIdOrigin productIdOrigin);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ProductIdOrigin {
        NOT_SET(0),
        EVENT_OVERRIDE(5);


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final SparseArray f69217d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f69219a;

        static {
            ProductIdOrigin productIdOrigin = NOT_SET;
            ProductIdOrigin productIdOrigin2 = EVENT_OVERRIDE;
            SparseArray sparseArray = new SparseArray();
            f69217d = sparseArray;
            sparseArray.put(0, productIdOrigin);
            sparseArray.put(5, productIdOrigin2);
        }

        ProductIdOrigin(int i3) {
            this.f69219a = i3;
        }
    }

    public static Builder a() {
        return new AutoValue_ComplianceData.Builder();
    }

    public abstract ExternalPrivacyContext b();

    public abstract ProductIdOrigin c();
}
