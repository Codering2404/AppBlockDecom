package com.applovin.impl;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bs {
    private static long a(Map map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = (String) map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair a(y6 y6Var) {
        Map mapD = y6Var.d();
        if (mapD == null) {
            return null;
        }
        return new Pair(Long.valueOf(a(mapD, "LicenseDurationRemaining")), Long.valueOf(a(mapD, "PlaybackDurationRemaining")));
    }
}
