package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88957b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88959b;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant a() {
            String str;
            String str2 = this.f88958a;
            if (str2 != null && (str = this.f88959b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88958a == null) {
                sb.append(" rolloutId");
            }
            if (this.f88959b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f88958a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder
        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f88959b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant
    public String b() {
        return this.f88956a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant
    public String c() {
        return this.f88957b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant) {
            CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant = (CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant) obj;
            if (this.f88956a.equals(rolloutVariant.b()) && this.f88957b.equals(rolloutVariant.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f88956a.hashCode() ^ 1000003) * 1000003) ^ this.f88957b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f88956a + ", variantId=" + this.f88957b + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(String str, String str2) {
        this.f88956a = str;
        this.f88957b = str2;
    }
}
