package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_RolloutsState extends CrashlyticsReport.Session.Event.RolloutsState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f88960a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.RolloutsState.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f88961a;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutsState.Builder
        public CrashlyticsReport.Session.Event.RolloutsState a() {
            List list = this.f88961a;
            if (list != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutsState(list);
            }
            throw new IllegalStateException("Missing required properties: rolloutAssignments");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutsState.Builder
        public CrashlyticsReport.Session.Event.RolloutsState.Builder b(List list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.f88961a = list;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.RolloutsState
    public List b() {
        return this.f88960a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.RolloutsState) {
            return this.f88960a.equals(((CrashlyticsReport.Session.Event.RolloutsState) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f88960a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f88960a + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutsState(List list) {
        this.f88960a = list;
    }
}
