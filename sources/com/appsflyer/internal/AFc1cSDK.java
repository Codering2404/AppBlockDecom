package com.appsflyer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1cSDK {
    final String AFInAppEventParameterName;
    final String valueOf;

    public AFc1cSDK(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.AFInAppEventParameterName = str;
        this.valueOf = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1cSDK)) {
            return false;
        }
        AFc1cSDK aFc1cSDK = (AFc1cSDK) obj;
        return Intrinsics.areEqual(this.AFInAppEventParameterName, aFc1cSDK.AFInAppEventParameterName) && Intrinsics.areEqual(this.valueOf, aFc1cSDK.valueOf);
    }

    public final int hashCode() {
        return (this.AFInAppEventParameterName.hashCode() * 31) + this.valueOf.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HostConfig(prefix=");
        sb.append(this.AFInAppEventParameterName);
        sb.append(", host=");
        sb.append(this.valueOf);
        sb.append(')');
        return sb.toString();
    }
}
