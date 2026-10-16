package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzasl {
    private zzasl(Object obj) {
        Preconditions.u(obj, "Request message cannot be null");
    }

    public static zzasl a(Object obj) {
        return new zzasl(obj);
    }
}
