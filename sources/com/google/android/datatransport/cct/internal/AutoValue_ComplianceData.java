package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ComplianceData;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ComplianceData extends ComplianceData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExternalPrivacyContext f69162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComplianceData.ProductIdOrigin f69163b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends ComplianceData.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ExternalPrivacyContext f69164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ComplianceData.ProductIdOrigin f69165b;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData a() {
            return new AutoValue_ComplianceData(this.f69164a, this.f69165b);
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData.Builder b(ExternalPrivacyContext externalPrivacyContext) {
            this.f69164a = externalPrivacyContext;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ComplianceData.Builder
        public ComplianceData.Builder c(ComplianceData.ProductIdOrigin productIdOrigin) {
            this.f69165b = productIdOrigin;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public ExternalPrivacyContext b() {
        return this.f69162a;
    }

    @Override // com.google.android.datatransport.cct.internal.ComplianceData
    public ComplianceData.ProductIdOrigin c() {
        return this.f69163b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComplianceData) {
            ComplianceData complianceData = (ComplianceData) obj;
            ExternalPrivacyContext externalPrivacyContext = this.f69162a;
            if (externalPrivacyContext != null ? externalPrivacyContext.equals(complianceData.b()) : complianceData.b() == null) {
                ComplianceData.ProductIdOrigin productIdOrigin = this.f69163b;
                if (productIdOrigin != null ? productIdOrigin.equals(complianceData.c()) : complianceData.c() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ExternalPrivacyContext externalPrivacyContext = this.f69162a;
        int iHashCode = ((externalPrivacyContext == null ? 0 : externalPrivacyContext.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.f69163b;
        return iHashCode ^ (productIdOrigin != null ? productIdOrigin.hashCode() : 0);
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f69162a + ", productIdOrigin=" + this.f69163b + "}";
    }

    private AutoValue_ComplianceData(ExternalPrivacyContext externalPrivacyContext, ComplianceData.ProductIdOrigin productIdOrigin) {
        this.f69162a = externalPrivacyContext;
        this.f69163b = productIdOrigin;
    }
}
