package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaof implements zzanl {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzet zze = new zzet();

    public static float zzb(int i3) {
        if (i3 == 0) {
            return 0.08f;
        }
        if (i3 == 1) {
            return 0.5f;
        }
        if (i3 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i3) {
        String strGroup = matcher.group(i3 + 1);
        long j3 = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i3 + 2);
        strGroup2.getClass();
        long j4 = j3 + (Long.parseLong(strGroup2) * 60000);
        String strGroup3 = matcher.group(i3 + 3);
        strGroup3.getClass();
        long j5 = j4 + (Long.parseLong(strGroup3) * 1000);
        String strGroup4 = matcher.group(i3 + 4);
        if (strGroup4 != null) {
            j5 += Long.parseLong(strGroup4);
        }
        return j5 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    @Override // com.google.android.gms.internal.ads.zzanl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(byte[] r18, int r19, int r20, com.google.android.gms.internal.ads.zzank r21, com.google.android.gms.internal.ads.zzdt r22) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaof.zza(byte[], int, int, com.google.android.gms.internal.ads.zzank, com.google.android.gms.internal.ads.zzdt):void");
    }
}
