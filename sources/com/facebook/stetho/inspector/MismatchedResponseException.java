package com.facebook.stetho.inspector;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j3) {
        super("Response for request id " + j3 + ", but no such request is pending");
        this.mRequestId = j3;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
