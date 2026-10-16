package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CrashlyticsReportWithSessionId {
    public static CrashlyticsReportWithSessionId a(CrashlyticsReport crashlyticsReport, String str, File file) {
        return new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, str, file);
    }

    public abstract CrashlyticsReport b();

    public abstract File c();

    public abstract String d();
}
