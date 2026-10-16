package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConsumeParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f57231a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f57232a;

        /* synthetic */ Builder(zzdd zzddVar) {
        }

        public ConsumeParams a() {
            String str = this.f57232a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            ConsumeParams consumeParams = new ConsumeParams(null);
            consumeParams.f57231a = str;
            return consumeParams;
        }

        public Builder b(String str) {
            this.f57232a = str;
            return this;
        }
    }

    /* synthetic */ ConsumeParams(zzdd zzddVar) {
    }

    public static Builder b() {
        return new Builder(null);
    }

    public String a() {
        return this.f57231a;
    }
}
