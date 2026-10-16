package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88765c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88768c;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch a() {
            String str;
            String str2;
            String str3 = this.f88766a;
            if (str3 != null && (str = this.f88767b) != null && (str2 = this.f88768c) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88766a == null) {
                sb.append(" arch");
            }
            if (this.f88767b == null) {
                sb.append(" libraryName");
            }
            if (this.f88768c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f88766a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f88768c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder
        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f88767b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public String b() {
        return this.f88763a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public String c() {
        return this.f88765c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch
    public String d() {
        return this.f88764b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) {
            CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
            if (this.f88763a.equals(buildIdMappingForArch.b()) && this.f88764b.equals(buildIdMappingForArch.d()) && this.f88765c.equals(buildIdMappingForArch.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f88763a.hashCode() ^ 1000003) * 1000003) ^ this.f88764b.hashCode()) * 1000003) ^ this.f88765c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f88763a + ", libraryName=" + this.f88764b + ", buildId=" + this.f88765c + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(String str, String str2, String str3) {
        this.f88763a = str;
        this.f88764b = str2;
        this.f88765c = str3;
    }
}
