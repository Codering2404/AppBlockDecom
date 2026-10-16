package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88945a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88946a;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log a() {
            String str = this.f88946a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Log(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f88946a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    public String b() {
        return this.f88945a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.f88945a.equals(((CrashlyticsReport.Session.Event.Log) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f88945a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f88945a + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.f88945a = str;
    }
}
