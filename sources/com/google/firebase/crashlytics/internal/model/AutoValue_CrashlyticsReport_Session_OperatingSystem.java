package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f88962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f88965d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f88966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f88969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte f88970e;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem a() {
            String str;
            String str2;
            if (this.f88970e == 3 && (str = this.f88967b) != null && (str2 = this.f88968c) != null) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.f88966a, str, str2, this.f88969d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88970e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f88967b == null) {
                sb.append(" version");
            }
            if (this.f88968c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f88970e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f88968c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder c(boolean z2) {
            this.f88969d = z2;
            this.f88970e = (byte) (this.f88970e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder d(int i3) {
            this.f88966a = i3;
            this.f88970e = (byte) (this.f88970e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f88967b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public String b() {
        return this.f88964c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int c() {
        return this.f88962a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public String d() {
        return this.f88963b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean e() {
        return this.f88965d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.OperatingSystem) {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            if (this.f88962a == operatingSystem.c() && this.f88963b.equals(operatingSystem.d()) && this.f88964c.equals(operatingSystem.b()) && this.f88965d == operatingSystem.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f88962a ^ 1000003) * 1000003) ^ this.f88963b.hashCode()) * 1000003) ^ this.f88964c.hashCode()) * 1000003) ^ (this.f88965d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f88962a + ", version=" + this.f88963b + ", buildVersion=" + this.f88964c + ", jailbroken=" + this.f88965d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i3, String str, String str2, boolean z2) {
        this.f88962a = i3;
        this.f88963b = str;
        this.f88964c = str2;
        this.f88965d = z2;
    }
}
