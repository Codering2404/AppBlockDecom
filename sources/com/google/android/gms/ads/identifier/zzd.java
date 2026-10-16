package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.tasks.OnFailureListener;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    private static volatile zzd zza;
    private static final Object zzb = new Object();
    private static final Duration zzc = Duration.ofMinutes(30);
    private final TelemetryLoggingClient zzd;
    private final AtomicLong zze = new AtomicLong(-1);

    private zzd(Context context, String str) {
        this.zzd = TelemetryLogging.b(context, TelemetryLoggingOptions.a().b("ads_identifier:api").a());
    }

    public static zzd zza(Context context) {
        if (zza == null) {
            synchronized (zzb) {
                try {
                    if (zza == null) {
                        zza = new zzd(context, "ads_identifier:api");
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    public static /* synthetic */ void zzb(zzd zzdVar, long j3, Exception exc) {
        ConnectionResult connectionResultM;
        Log.i("AdvertisingIdClient", "getting error as ".concat(String.valueOf(exc.getMessage())));
        if ((exc instanceof ApiException) && (connectionResultM = ((ApiException) exc).getStatus().M()) != null && connectionResultM.N() == 24) {
            zzdVar.zze.set(j3);
        }
    }

    public final synchronized void zzc(int i3, int i4, long j3, long j4, int i5) {
        AtomicLong atomicLong = this.zze;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        Log.i("AdvertisingIdClient", "shouldSendLog " + atomicLong.get());
        if (this.zze.get() == -1 || jElapsedRealtime - this.zze.get() > zzc.toMillis()) {
            TelemetryLoggingClient telemetryLoggingClient = this.zzd;
            if (telemetryLoggingClient != null) {
                telemetryLoggingClient.b(new TelemetryData(0, Arrays.asList(new MethodInvocation(35401, i4, 0, j3, j4, null, null, 0, i5)))).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.ads.identifier.zzc
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        zzd.zzb(this.zza, jElapsedRealtime, exc);
                    }
                });
            }
        }
    }
}
