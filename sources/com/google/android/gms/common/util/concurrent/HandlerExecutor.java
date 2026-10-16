package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzg;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HandlerExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f72296a;

    public HandlerExecutor(Looper looper) {
        this.f72296a = new zzg(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f72296a.post(runnable);
    }
}
