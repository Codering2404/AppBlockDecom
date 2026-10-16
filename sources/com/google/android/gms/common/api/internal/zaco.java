package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaco {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f71801a = com.google.android.gms.internal.base.zat.zaa().zaa(new NumberedThreadFactory("GAC_Transform"), 1);

    public static ExecutorService a() {
        return f71801a;
    }
}
