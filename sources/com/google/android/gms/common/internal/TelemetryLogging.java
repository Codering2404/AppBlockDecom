package com.google.android.gms.common.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TelemetryLogging {
    public static TelemetryLoggingClient a(Context context) {
        return b(context, TelemetryLoggingOptions.f72026b);
    }

    public static TelemetryLoggingClient b(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }
}
