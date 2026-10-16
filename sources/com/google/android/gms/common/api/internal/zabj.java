package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zabj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f71743a = com.google.android.gms.internal.base.zat.zaa().zac(2, new NumberedThreadFactory("GAC_Executor"), 2);

    public static ExecutorService a() {
        return f71743a;
    }
}
