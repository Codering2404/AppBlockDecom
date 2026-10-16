package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport f88306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f88308c;

    AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport == null) {
            throw new NullPointerException("Null report");
        }
        this.f88306a = crashlyticsReport;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f88307b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f88308c = file;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public CrashlyticsReport b() {
        return this.f88306a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public File c() {
        return this.f88308c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public String d() {
        return this.f88307b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReportWithSessionId) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
            if (this.f88306a.equals(crashlyticsReportWithSessionId.b()) && this.f88307b.equals(crashlyticsReportWithSessionId.d()) && this.f88308c.equals(crashlyticsReportWithSessionId.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f88306a.hashCode() ^ 1000003) * 1000003) ^ this.f88307b.hashCode()) * 1000003) ^ this.f88308c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f88306a + ", sessionId=" + this.f88307b + ", reportFile=" + this.f88308c + "}";
    }
}
