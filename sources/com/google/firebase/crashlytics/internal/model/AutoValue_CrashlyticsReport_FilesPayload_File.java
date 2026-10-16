package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;
import kotlin.comparisons.xn.YvFRmou;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.FilesPayload.File {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f88778b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.FilesPayload.File.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f88780b;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f88780b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f88779a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder
        public CrashlyticsReport.FilesPayload.File a() {
            byte[] bArr;
            String str = this.f88779a;
            if (str != null && (bArr = this.f88780b) != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88779a == null) {
                sb.append(YvFRmou.kNsHgjeShTAR);
            }
            if (this.f88780b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    public byte[] b() {
        return this.f88778b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
    public String c() {
        return this.f88777a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.FilesPayload.File) {
            CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
            if (this.f88777a.equals(file.c())) {
                if (Arrays.equals(this.f88778b, file instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) file).f88778b : file.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f88777a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f88778b);
    }

    public String toString() {
        return "File{filename=" + this.f88777a + ", contents=" + Arrays.toString(this.f88778b) + "}";
    }

    private AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.f88777a = str;
        this.f88778b = bArr;
    }
}
