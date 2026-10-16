package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
enum zzdf {
    GET_BILLING_CONFIG("getBillingConfig", 29),
    IS_BILLING_PROGRAM_AVAILABLE_ASYNC("isIndirectBillingProgramAvailable", 33),
    CREATE_BILLING_PROGRAM_REPORTING_DETAILS_ASYNC("createIndirectBillingReportingDetails", 35);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f57582b;

    zzdf(String str, int i3) {
        this.f57581a = str;
        this.f57582b = i3;
    }

    final String a() {
        return this.f57581a;
    }

    final int b() {
        return this.f57582b;
    }
}
