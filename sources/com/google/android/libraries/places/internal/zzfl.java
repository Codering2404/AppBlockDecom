package com.google.android.libraries.places.internal;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f77817d = TimeUnit.SECONDS.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FusedLocationProviderClient f77818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzmb f77819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f77820c;

    zzfl(Context context, FusedLocationProviderClient fusedLocationProviderClient, zzmb zzmbVar) {
        this.f77820c = context;
        this.f77818a = fusedLocationProviderClient;
        this.f77819b = zzmbVar;
    }

    public final Task a(CancellationToken cancellationToken) {
        CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
        long j3 = f77817d;
        CurrentLocationRequest.Builder builderB = builder.b(j3);
        if (ContextCompat.checkSelfPermission(this.f77820c, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            builderB.c(100);
        } else {
            builderB.c(102);
        }
        return this.f77819b.a(this.f77818a.getCurrentLocation(builderB.a(), cancellationToken), cancellationToken, j3, "Location timeout.").continueWithTask(new zzfk(this));
    }
}
