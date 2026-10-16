package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Application_Organization extends CrashlyticsReport.Session.Application.Organization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88820a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Application.Organization.Builder {
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization
    public String a() {
        return this.f88820a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.f88820a.equals(((CrashlyticsReport.Session.Application.Organization) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f88820a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f88820a + "}";
    }
}
