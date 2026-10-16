package com.android.billingclient.api;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AlternativeBillingOnlyReportingDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57152a;

    AlternativeBillingOnlyReportingDetails(String str) {
        this.f57152a = new JSONObject(str).optString("externalTransactionToken");
    }
}
