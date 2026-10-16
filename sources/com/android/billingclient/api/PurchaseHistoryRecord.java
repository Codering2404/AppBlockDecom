package com.android.billingclient.api;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PurchaseHistoryRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57340b;

    public String a() {
        return this.f57339a;
    }

    public String b() {
        return this.f57340b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.f57339a, purchaseHistoryRecord.a()) && TextUtils.equals(this.f57340b, purchaseHistoryRecord.b());
    }

    public int hashCode() {
        return this.f57339a.hashCode();
    }

    public String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.f57339a));
    }
}
