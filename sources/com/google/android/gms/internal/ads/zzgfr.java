package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzgfr {
    String zza();

    ListenableFuture zzb();

    ListenableFuture zzc(Context context);

    ListenableFuture zzd(Context context, String str, View view, Activity activity);

    ListenableFuture zze(Context context, String str, View view, Activity activity);

    void zzf(InputEvent inputEvent);

    int zzg();
}
