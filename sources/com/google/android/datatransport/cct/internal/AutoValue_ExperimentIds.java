package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ExperimentIds;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ExperimentIds extends ExperimentIds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f69166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f69167b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends ExperimentIds.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f69168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f69169b;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds a() {
            return new AutoValue_ExperimentIds(this.f69168a, this.f69169b);
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds.Builder b(byte[] bArr) {
            this.f69168a = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ExperimentIds.Builder
        public ExperimentIds.Builder c(byte[] bArr) {
            this.f69169b = bArr;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public byte[] b() {
        return this.f69166a;
    }

    @Override // com.google.android.datatransport.cct.internal.ExperimentIds
    public byte[] c() {
        return this.f69167b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExperimentIds) {
            ExperimentIds experimentIds = (ExperimentIds) obj;
            boolean z2 = experimentIds instanceof AutoValue_ExperimentIds;
            if (Arrays.equals(this.f69166a, z2 ? ((AutoValue_ExperimentIds) experimentIds).f69166a : experimentIds.b())) {
                if (Arrays.equals(this.f69167b, z2 ? ((AutoValue_ExperimentIds) experimentIds).f69167b : experimentIds.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f69166a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f69167b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f69166a) + ", encryptedBlob=" + Arrays.toString(this.f69167b) + "}";
    }

    private AutoValue_ExperimentIds(byte[] bArr, byte[] bArr2) {
        this.f69166a = bArr;
        this.f69167b = bArr2;
    }
}
