package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.Session.Event.Application.Execution.Signal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f88900c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f88903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte f88904d;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal a() {
            String str;
            String str2;
            if (this.f88904d == 1 && (str = this.f88901a) != null && (str2 = this.f88902b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str, str2, this.f88903c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88901a == null) {
                sb.append(" name");
            }
            if (this.f88902b == null) {
                sb.append(" code");
            }
            if ((1 & this.f88904d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder b(long j3) {
            this.f88903c = j3;
            this.f88904d = (byte) (this.f88904d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f88902b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f88901a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public long b() {
        return this.f88900c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public String c() {
        return this.f88899b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal
    public String d() {
        return this.f88898a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal) {
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
            if (this.f88898a.equals(signal.d()) && this.f88899b.equals(signal.c()) && this.f88900c == signal.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f88898a.hashCode() ^ 1000003) * 1000003) ^ this.f88899b.hashCode()) * 1000003;
        long j3 = this.f88900c;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f88898a + ", code=" + this.f88899b + ", address=" + this.f88900c + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j3) {
        this.f88898a = str;
        this.f88899b = str2;
        this.f88900c = j3;
    }
}
