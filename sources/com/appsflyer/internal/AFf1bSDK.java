package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1tSDK;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1bSDK {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum AFa1vSDK {
        NONE,
        FIRST,
        ALL
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum AFa1wSDK {
        UNKNOWN(0),
        ACCELEROMETER(1),
        MAGNETOMETER(2),
        RESERVED(3),
        GYROSCOPE(4);

        private int afRDLog;

        AFa1wSDK(int i3) {
            this.afRDLog = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum AFa1xSDK {
        UNKNOWN("uk"),
        ACCELEROMETER("am"),
        MAGNETOMETER("mm"),
        RESERVED("rs"),
        GYROSCOPE("gs");

        String AFKeystoreWrapper;

        AFa1xSDK(String str) {
            this.AFKeystoreWrapper = str;
        }
    }

    static List<BigDecimal> values(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        Float f3 = (Float) arrayList.get(0);
        Float f4 = (Float) arrayList.get(1);
        Float f5 = (Float) arrayList.get(2);
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(BigDecimal.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(f3.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(f4.toString())));
            arrayList2.add(BigDecimal.valueOf(AFc1tSDK.AFa1wSDK.AFInAppEventType(f5.toString())));
            return arrayList2;
        } catch (ParseException e3) {
            AFLogger.afErrorLogForExcManagerOnly("failed to parse string to number", e3);
            return arrayList2;
        }
    }
}
