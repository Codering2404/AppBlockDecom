package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExternalPRequestContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ExternalPRequestContext extends ExternalPRequestContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f69170a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends ExternalPRequestContext.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f69171a;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public ExternalPRequestContext a() {
            return new AutoValue_ExternalPRequestContext(this.f69171a);
        }

        @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext.Builder
        public ExternalPRequestContext.Builder b(Integer num) {
            this.f69171a = num;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ExternalPRequestContext
    public Integer b() {
        return this.f69170a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPRequestContext)) {
            return false;
        }
        Integer num = this.f69170a;
        Integer numB = ((ExternalPRequestContext) obj).b();
        return num == null ? numB == null : num.equals(numB);
    }

    public int hashCode() {
        Integer num = this.f69170a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f69170a + "}";
    }

    private AutoValue_ExternalPRequestContext(Integer num) {
        this.f69170a = num;
    }
}
