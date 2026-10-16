package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfln {
    public static Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = bundle.getBundle(str);
        return bundle2 == null ? new Bundle() : bundle2;
    }

    public static void zzb(Bundle bundle, String str, String str2, boolean z2) {
        if (!z2 || str2 == null) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static void zzc(Bundle bundle, String str, int i3, boolean z2) {
        if (z2) {
            bundle.putInt(str, i3);
        }
    }

    public static void zzd(Bundle bundle, String str, boolean z2, boolean z3) {
        if (z3) {
            bundle.putBoolean(str, z2);
        }
    }

    public static void zze(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    public static void zzf(Bundle bundle, String str, Bundle bundle2) {
        if (bundle2 != null) {
            bundle.putBundle(str, bundle2);
        }
    }

    public static void zzg(Bundle bundle, String str, List list) {
        if (list != null) {
            bundle.putStringArrayList(str, new ArrayList<>(list));
        }
    }

    public static void zzh(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }
}
