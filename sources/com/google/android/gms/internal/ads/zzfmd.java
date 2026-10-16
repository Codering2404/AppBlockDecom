package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmd {
    static Task zza;
    public static AppSetIdClient zzb;
    private static final Object zzc = new Object();

    public static void zza(Context context, boolean z2) {
        synchronized (zzc) {
            try {
                if (zzb == null) {
                    zzb = AppSet.getClient(context);
                }
                Task task = zza;
                if (task == null || ((task.isComplete() && !zza.isSuccessful()) || (z2 && zza.isComplete()))) {
                    try {
                        zza = ((AppSetIdClient) Preconditions.n(zzb, "the appSetIdClient shouldn't be null")).getAppSetIdInfo();
                    } catch (ArrayIndexOutOfBoundsException e3) {
                        String message = e3.getMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 31);
                        sb.append("Failed to get app set ID info: ");
                        sb.append(message);
                        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                        zza = Tasks.forException(e3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Task zzb(Context context) {
        Task task;
        zza(context, false);
        synchronized (zzc) {
            task = zza;
        }
        return task;
    }
}
