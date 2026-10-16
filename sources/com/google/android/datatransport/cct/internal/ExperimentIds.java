package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExperimentIds;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ExperimentIds {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ExperimentIds a();

        public abstract Builder b(byte[] bArr);

        public abstract Builder c(byte[] bArr);
    }

    public static Builder a() {
        return new AutoValue_ExperimentIds.Builder();
    }

    public abstract byte[] b();

    public abstract byte[] c();
}
