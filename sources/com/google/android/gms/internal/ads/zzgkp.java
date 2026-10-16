package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgkp extends zzfxg {
    private final zzgfh zzb;

    zzgkp(Context context, Executor executor, zzgfh zzgfhVar) {
        super(context, executor, new TaskCompletionSource().getTask(), false);
        this.zzb = zzgfhVar;
    }

    private static Task zzh() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(Boolean.TRUE);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final Task zzb(int i3, long j3) {
        this.zzb.zzb(i3, j3, null, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final Task zzc(int i3, long j3, Exception exc) {
        this.zzb.zzb(i3, j3, exc, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfxg
    public final Task zze(int i3, String str) {
        this.zzb.zzb(i3, -1L, null, str);
        return zzh();
    }
}
