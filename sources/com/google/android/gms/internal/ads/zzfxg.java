package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzfxg {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfxg(Context context, Executor executor, Task task, boolean z2) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z2;
    }

    public static zzfxg zza(final Context context, Executor executor, boolean z2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z2) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfxc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i3 = zzfxg.zza;
                    taskCompletionSource.setResult(zzfzc.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfxe
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i3 = zzfxg.zza;
                    taskCompletionSource.setResult(zzfzc.zzc());
                }
            });
        }
        return new zzfxg(context, executor, taskCompletionSource.getTask(), z2);
    }

    static void zzg(int i3) {
        zzf = i3;
    }

    private final Task zzh(final int i3, long j3, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfxf.zza);
        }
        Context context = this.zzb;
        final zzaws zzawsVarZza = zzaww.zza();
        zzawsVarZza.zza(context.getPackageName());
        zzawsVarZza.zzb(j3);
        zzawsVarZza.zzg(zzf);
        if (exc != null) {
            int i4 = zzgug.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzawsVarZza.zzc(stringWriter.toString());
            zzawsVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzawsVarZza.zze(str2);
        }
        if (str != null) {
            zzawsVarZza.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfxd
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i5 = zzfxg.zza;
                if (!task.isSuccessful()) {
                    return Boolean.FALSE;
                }
                int i6 = i3;
                zzfzb zzfzbVarZza = ((zzfzc) task.getResult()).zza(((zzaww) zzawsVarZza.zzbu()).zzaN());
                zzfzbVarZza.zzc(i6);
                zzfzbVarZza.zza();
                return Boolean.TRUE;
            }
        });
    }

    public Task zzb(int i3, long j3) {
        return zzh(i3, j3, null, null, null, null);
    }

    public Task zzc(int i3, long j3, Exception exc) {
        return zzh(i3, j3, exc, null, null, null);
    }

    public final Task zzd(int i3, long j3, String str, Map map) {
        return zzh(i3, j3, null, str, null, null);
    }

    public Task zze(int i3, String str) {
        return zzh(i3, 0L, null, null, null, str);
    }

    public final Task zzf(int i3, long j3, String str) {
        return zzh(i3, j3, null, null, null, str);
    }
}
