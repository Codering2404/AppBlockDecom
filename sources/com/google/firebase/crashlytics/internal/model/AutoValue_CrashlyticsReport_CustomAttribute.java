package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.CustomAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88770b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.CustomAttribute.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88772b;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute a() {
            String str;
            String str2 = this.f88771a;
            if (str2 != null && (str = this.f88772b) != null) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88771a == null) {
                sb.append(" key");
            }
            if (this.f88772b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f88771a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder
        public CrashlyticsReport.CustomAttribute.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f88772b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public String b() {
        return this.f88769a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute
    public String c() {
        return this.f88770b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.CustomAttribute) {
            CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
            if (this.f88769a.equals(customAttribute.b()) && this.f88770b.equals(customAttribute.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f88769a.hashCode() ^ 1000003) * 1000003) ^ this.f88770b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f88769a + ", value=" + this.f88770b + "}";
    }

    private AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.f88769a = str;
        this.f88770b = str2;
    }
}
