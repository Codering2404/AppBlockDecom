package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ExternalPrivacyContext extends ExternalPrivacyContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExternalPRequestContext f69172a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends ExternalPrivacyContext.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ExternalPRequestContext f69173a;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public ExternalPrivacyContext a() {
            return new AutoValue_ExternalPrivacyContext(this.f69173a);
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext.Builder
        public ExternalPrivacyContext.Builder b(ExternalPRequestContext externalPRequestContext) {
            this.f69173a = externalPRequestContext;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPrivacyContext
    public ExternalPRequestContext b() {
        return this.f69172a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPrivacyContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = this.f69172a;
        ExternalPRequestContext externalPRequestContextB = ((ExternalPrivacyContext) obj).b();
        return externalPRequestContext == null ? externalPRequestContextB == null : externalPRequestContext.equals(externalPRequestContextB);
    }

    public int hashCode() {
        ExternalPRequestContext externalPRequestContext = this.f69172a;
        return (externalPRequestContext == null ? 0 : externalPRequestContext.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f69172a + "}";
    }

    private AutoValue_ExternalPrivacyContext(ExternalPRequestContext externalPRequestContext) {
        this.f69172a = externalPRequestContext;
    }
}
