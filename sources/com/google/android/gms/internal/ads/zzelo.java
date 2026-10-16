package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelo {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    zzelo(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        try {
            MeasurementManagerFutures measurementManagerFuturesA = MeasurementManagerFutures.a(this.zzb);
            this.zza = measurementManagerFuturesA;
            return measurementManagerFuturesA == null ? zzhbw.zzc(new IllegalStateException("MeasurementManagerFutures is null")) : measurementManagerFuturesA.b();
        } catch (Exception e3) {
            return zzhbw.zzc(e3);
        }
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        try {
            MeasurementManagerFutures measurementManagerFutures = this.zza;
            Objects.requireNonNull(measurementManagerFutures);
            return measurementManagerFutures.c(uri, inputEvent);
        } catch (Exception e3) {
            return zzhbw.zzc(e3);
        }
    }
}
