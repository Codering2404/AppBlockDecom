package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzbb;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzcr;
import com.google.android.gms.internal.location.zzcz;
import com.google.android.gms.internal.location.zzda;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class LocationServices {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api f72965a = zzbi.zzb;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FusedLocationProviderApi f72966b = new zzbb();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GeofencingApi f72967c = new zzcr();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SettingsApi f72968d = new zzcz();

    public static FusedLocationProviderClient a(Context context) {
        return new zzbi(context);
    }

    public static SettingsClient b(Activity activity) {
        return new zzda(activity);
    }
}
