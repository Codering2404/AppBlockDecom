package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BillingResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f57225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f57226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f57227c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f57228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f57229b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f57230c = "";

        /* synthetic */ Builder(zzdb zzdbVar) {
        }

        public BillingResult a() {
            BillingResult billingResult = new BillingResult();
            billingResult.f57225a = this.f57228a;
            billingResult.f57226b = this.f57229b;
            billingResult.f57227c = this.f57230c;
            return billingResult;
        }

        public Builder b(String str) {
            this.f57230c = str;
            return this;
        }

        public Builder c(int i3) {
            this.f57229b = i3;
            return this;
        }

        public Builder d(int i3) {
            this.f57228a = i3;
            return this;
        }
    }

    public static Builder d() {
        return new Builder(null);
    }

    public String a() {
        return this.f57227c;
    }

    public int b() {
        return this.f57226b;
    }

    public int c() {
        return this.f57225a;
    }

    public String toString() {
        return "Response Code: " + com.google.android.gms.internal.play_billing.zzc.zzl(this.f57225a) + ", Debug Message: " + this.f57227c;
    }
}
