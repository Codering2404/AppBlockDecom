package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f88773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88774b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.FilesPayload.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f88775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88776b;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload a() {
            List list = this.f88775a;
            if (list != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload(list, this.f88776b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f88775a = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder
        public CrashlyticsReport.FilesPayload.Builder c(String str) {
            this.f88776b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public List b() {
        return this.f88773a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public String c() {
        return this.f88774b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.FilesPayload) {
            CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
            if (this.f88773a.equals(filesPayload.b()) && ((str = this.f88774b) != null ? str.equals(filesPayload.c()) : filesPayload.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f88773a.hashCode() ^ 1000003) * 1000003;
        String str = this.f88774b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f88773a + ", orgId=" + this.f88774b + "}";
    }

    private AutoValue_CrashlyticsReport_FilesPayload(List list, String str) {
        this.f88773a = list;
        this.f88774b = str;
    }
}
