package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment extends CrashlyticsReport.Session.Event.RolloutAssignment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f88947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f88950d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f88951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f88954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte f88955e;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment a() {
            CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant;
            String str;
            String str2;
            if (this.f88955e == 1 && (rolloutVariant = this.f88951a) != null && (str = this.f88952b) != null && (str2 = this.f88953c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(rolloutVariant, str, str2, this.f88954d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88951a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f88952b == null) {
                sb.append(" parameterKey");
            }
            if (this.f88953c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f88955e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f88952b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f88953c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder d(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant) {
            if (rolloutVariant == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f88951a = rolloutVariant;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder e(long j3) {
            this.f88954d = j3;
            this.f88955e = (byte) (this.f88955e | 1);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public String b() {
        return this.f88948b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public String c() {
        return this.f88949c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant d() {
        return this.f88947a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment
    public long e() {
        return this.f88950d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment) {
            CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment = (CrashlyticsReport.Session.Event.RolloutAssignment) obj;
            if (this.f88947a.equals(rolloutAssignment.d()) && this.f88948b.equals(rolloutAssignment.b()) && this.f88949c.equals(rolloutAssignment.c()) && this.f88950d == rolloutAssignment.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.f88947a.hashCode() ^ 1000003) * 1000003) ^ this.f88948b.hashCode()) * 1000003) ^ this.f88949c.hashCode()) * 1000003;
        long j3 = this.f88950d;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f88947a + ", parameterKey=" + this.f88948b + ", parameterValue=" + this.f88949c + ", templateVersion=" + this.f88950d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant, String str, String str2, long j3) {
        this.f88947a = rolloutVariant;
        this.f88948b = str;
        this.f88949c = str2;
        this.f88950d = j3;
    }
}
