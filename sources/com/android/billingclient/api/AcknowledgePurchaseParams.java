package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AcknowledgePurchaseParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f57150a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f57151a;

        /* synthetic */ Builder(zza zzaVar) {
        }

        public AcknowledgePurchaseParams a() {
            String str = this.f57151a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams.f57150a = str;
            return acknowledgePurchaseParams;
        }

        public Builder b(String str) {
            this.f57151a = str;
            return this;
        }
    }

    /* synthetic */ AcknowledgePurchaseParams(zza zzaVar) {
    }

    public static Builder b() {
        return new Builder(null);
    }

    public String a() {
        return this.f57150a;
    }
}
