package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFc1kSDK {
    public final long values;

    public AFc1kSDK(long j3) {
        this.values = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.values == ((AFc1kSDK) obj).values;
    }

    public int hashCode() {
        long j3 = this.values;
        return (int) (j3 ^ (j3 >>> 32));
    }
}
