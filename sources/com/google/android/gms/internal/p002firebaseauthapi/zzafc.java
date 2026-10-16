package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafc {
    private final int zza;

    private zzafc(String str) {
        this.zza = zza(str);
    }

    private static int zza(String str) {
        try {
            List<String> listZza = zzt.zza("[.-]").zza((CharSequence) str);
            if (listZza.size() == 1) {
                return Integer.parseInt(str);
            }
            if (listZza.size() >= 3) {
                return (Integer.parseInt(listZza.get(0)) * 1000000) + (Integer.parseInt(listZza.get(1)) * 1000) + Integer.parseInt(listZza.get(2));
            }
            return -1;
        } catch (IllegalArgumentException e3) {
            if (!Log.isLoggable("LibraryVersionContainer", 3)) {
                return -1;
            }
            Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", str, e3));
            return -1;
        }
    }

    public final String zzb() {
        return String.format("X%s", Integer.toString(this.zza));
    }

    public static zzafc zza() throws Throwable {
        String strB = LibraryVersion.a().b("firebase-auth");
        if (TextUtils.isEmpty(strB) || strB.equals("UNKNOWN")) {
            strB = "-1";
        }
        return new zzafc(strB);
    }
}
