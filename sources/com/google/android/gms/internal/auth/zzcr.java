package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.ArrayMap;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcr {
    private static final ArrayMap zza = new ArrayMap();

    public static synchronized Uri zza(String str) {
        ArrayMap arrayMap = zza;
        String str2 = MrGIhy.RuSXYBKxrmRhKnx;
        Uri uri = (Uri) arrayMap.get(str2);
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode(str2))));
        arrayMap.put(str2, uri2);
        return uri2;
    }
}
