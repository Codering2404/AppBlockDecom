package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ExternalPrivacyContext;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ExternalPrivacyContext {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ExternalPrivacyContext a();

        public abstract Builder b(ExternalPRequestContext externalPRequestContext);
    }

    public static Builder a() {
        return new AutoValue_ExternalPrivacyContext.Builder();
    }

    public abstract ExternalPRequestContext b();
}
