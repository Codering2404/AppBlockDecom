package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AFb1cSDK {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AFa1ySDK {
        public final float AFInAppEventType;
        public final String valueOf;

        public AFa1ySDK(float f3, String str) {
            this.AFInAppEventType = f3;
            this.valueOf = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1ySDK)) {
                return false;
            }
            AFa1ySDK aFa1ySDK = (AFa1ySDK) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.AFInAppEventType), (Object) Float.valueOf(aFa1ySDK.AFInAppEventType)) && Intrinsics.areEqual(this.valueOf, aFa1ySDK.valueOf);
        }

        public final int hashCode() {
            int iHashCode = Float.hashCode(this.AFInAppEventType) * 31;
            String str = this.valueOf;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("BatteryData(level=");
            sb.append(this.AFInAppEventType);
            sb.append(", charging=");
            sb.append(this.valueOf);
            sb.append(')');
            return sb.toString();
        }
    }

    AFa1ySDK valueOf(Context context);
}
