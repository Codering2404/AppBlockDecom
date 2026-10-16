package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final Status mStatus;

    public ApiException(Status status) {
        int iO = status.O();
        String strG0 = status.g0() != null ? status.g0() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(iO).length() + 2 + String.valueOf(strG0).length());
        sb.append(iO);
        sb.append(": ");
        sb.append(strG0);
        super(sb.toString());
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.O();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.g0();
    }
}
