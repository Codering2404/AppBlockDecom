package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.common.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaob implements zzanl {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzaoa zzc;
    private final zzet zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaob() {
        this(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zzb(zzet zzetVar, Charset charset) {
        while (true) {
            String strZzN = zzetVar.zzN(charset);
            if (strZzN == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzN)) {
                while (true) {
                    String strZzN2 = zzetVar.zzN(charset);
                    if (strZzN2 == null || (zzetVar.zzd() != 0 && zzetVar.zzp(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzN2.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                    if (strArrSplit.length == 2) {
                        String strZza = zzgss.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (strZza.equals("playresx")) {
                                    this.zzf = Float.parseFloat(strArrSplit[1].trim());
                                }
                                break;
                            case 1879649549:
                                if (strZza.equals("playresy")) {
                                    try {
                                        this.zzg = Float.parseFloat(strArrSplit[1].trim());
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                break;
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzN)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzaoc zzaocVarZza = null;
                while (true) {
                    String strZzN3 = zzetVar.zzN(charset);
                    if (strZzN3 != null && (zzetVar.zzd() == 0 || zzetVar.zzp(charset) != 91)) {
                        if (strZzN3.startsWith("Format:")) {
                            zzaocVarZza = zzaoc.zza(strZzN3);
                        } else if (strZzN3.startsWith("Style:")) {
                            if (zzaocVarZza == null) {
                                zzeg.zzc("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzN3));
                            } else {
                                zzaoe zzaoeVarZza = zzaoe.zza(strZzN3, zzaocVarZza);
                                if (zzaoeVarZza != null) {
                                    linkedHashMap.put(zzaoeVarZza.zza, zzaoeVarZza);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzN)) {
                zzeg.zzb("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzN)) {
                return;
            }
        }
    }

    private static long zzc(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzfl.zza;
        long j3 = Long.parseLong(strGroup) * 3600000000L;
        long j4 = Long.parseLong(matcher.group(2)) * 60000000;
        return j3 + j4 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    private static float zzd(int i3) {
        if (i3 == 0) {
            return 0.05f;
        }
        if (i3 != 1) {
            return i3 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zze(long j3, List list, List list2) {
        int i3;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i3 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j3) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j3) {
                i3 = size + 1;
                break;
            }
        }
        list.add(i3, Long.valueOf(j3));
        list2.add(i3, i3 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i3 - 1)));
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x030e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzanl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(byte[] r23, int r24, int r25, com.google.android.gms.internal.ads.zzank r26, com.google.android.gms.internal.ads.zzdt r27) {
        /*
            Method dump skipped, instruction units count: 868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaob.zza(byte[], int, int, com.google.android.gms.internal.ads.zzank, com.google.android.gms.internal.ads.zzdt):void");
    }

    public zzaob(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzet();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzj = zzfl.zzj((byte[]) list.get(0));
        zzgtj.zza(strZzj.startsWith("Format:"));
        zzaoa zzaoaVarZza = zzaoa.zza(strZzj);
        zzaoaVarZza.getClass();
        this.zzc = zzaoaVarZza;
        zzb(new zzet((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
