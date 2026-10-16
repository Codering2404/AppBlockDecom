package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88971a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.User.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88972a;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User a() {
            String str = this.f88972a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_User(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f88972a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    public String b() {
        return this.f88971a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.f88971a.equals(((CrashlyticsReport.Session.User) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f88971a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f88971a + "}";
    }

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.f88971a = str;
    }
}
