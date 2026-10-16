package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapc {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*+)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    public static zzaow zza(zzet zzetVar, List list) {
        Charset charset = StandardCharsets.UTF_8;
        String strZzN = zzetVar.zzN(charset);
        if (strZzN != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzN);
            if (matcher.matches()) {
                return zzd(null, matcher, zzetVar, list);
            }
            String strZzN2 = zzetVar.zzN(charset);
            if (strZzN2 != null) {
                Matcher matcher2 = pattern.matcher(strZzN2);
                if (matcher2.matches()) {
                    return zzd(strZzN.trim(), matcher2, zzetVar, list);
                }
            }
        }
        return null;
    }

    static zzcw zzb(String str) {
        zzapb zzapbVar = new zzapb();
        zze(str, zzapbVar);
        return zzapbVar.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.text.SpannedString zzc(java.lang.String r13, java.lang.String r14, java.util.List r15) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapc.zzc(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    private static zzaow zzd(String str, Matcher matcher, zzet zzetVar, List list) {
        zzapb zzapbVar = new zzapb();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            zzapbVar.zza = zzape.zza(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            zzapbVar.zzb = zzape.zza(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zze(strGroup3, zzapbVar);
            StringBuilder sb = new StringBuilder();
            String strZzN = zzetVar.zzN(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strZzN)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strZzN.trim());
                strZzN = zzetVar.zzN(StandardCharsets.UTF_8);
            }
            zzapbVar.zzc = zzc(str, sb.toString(), list);
            return new zzaow(zzapbVar.zza().zzr(), zzapbVar.zza, zzapbVar.zzb);
        } catch (IllegalArgumentException unused) {
            zzeg.zzc("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cf A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0146 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0190 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zze(java.lang.String r16, com.google.android.gms.internal.ads.zzapb r17) {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapc.zze(java.lang.String, com.google.android.gms.internal.ads.zzapb):void");
    }

    private static void zzf(String str, zzaoz zzaozVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i3 = zzaozVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzaozVar.zza;
        int iHashCode = str2.hashCode();
        int i4 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode == 3511770) {
                        if (!str2.equals("ruby")) {
                            return;
                        }
                        int iZzg = zzg(list2, str, zzaozVar);
                        ArrayList arrayList = new ArrayList(list.size());
                        arrayList.addAll(list);
                        Collections.sort(arrayList, zzaoy.zza);
                        int i5 = i3;
                        int i6 = 0;
                        int length2 = 0;
                        while (i6 < arrayList.size()) {
                            if ("rt".equals(((zzaoy) arrayList.get(i6)).zzc().zza)) {
                                zzaoy zzaoyVar = (zzaoy) arrayList.get(i6);
                                int iZzg2 = zzg(list2, str, zzaoyVar.zzc());
                                if (iZzg2 == i4) {
                                    iZzg2 = iZzg != i4 ? iZzg : 1;
                                }
                                int i7 = zzaoyVar.zzc().zzb - length2;
                                int iZzd = zzaoyVar.zzd() - length2;
                                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i7, iZzd);
                                spannableStringBuilder.delete(i7, iZzd);
                                spannableStringBuilder.setSpan(new zzdc(charSequenceSubSequence.toString(), iZzg2), i5, i7, 33);
                                length2 += charSequenceSubSequence.length();
                                i5 = i7;
                            }
                            i6++;
                            i4 = -1;
                        }
                    } else if (iHashCode != 98) {
                        if (iHashCode == 99) {
                            if (!str2.equals("c")) {
                                return;
                            }
                            for (String str3 : zzaozVar.zzd) {
                                Map map = zzc;
                                if (map.containsKey(str3)) {
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i3, length, 33);
                                } else {
                                    Map map2 = zzd;
                                    if (map2.containsKey(str3)) {
                                        spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i3, length, 33);
                                    }
                                }
                            }
                        } else if (iHashCode != 117) {
                            if (iHashCode != 118 || !str2.equals("v")) {
                                return;
                            } else {
                                spannableStringBuilder.setSpan(new zzdf(zzaozVar.zzc), i3, length, 33);
                            }
                        } else if (!str2.equals("u")) {
                            return;
                        } else {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, length, 33);
                        }
                    } else if (!str2.equals("b")) {
                        return;
                    } else {
                        spannableStringBuilder.setSpan(new StyleSpan(1), i3, length, 33);
                    }
                } else if (!str2.equals("lang")) {
                    return;
                }
            } else if (!str2.equals("i")) {
                return;
            } else {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
        } else if (!str2.equals("")) {
            return;
        }
        List listZzh = zzh(list2, str, zzaozVar);
        for (int i8 = 0; i8 < listZzh.size(); i8++) {
            zzaov zzaovVar = ((zzapa) listZzh.get(i8)).zzb;
            if (zzaovVar != null) {
                if (zzaovVar.zzf() != -1) {
                    zzdd.zza(spannableStringBuilder, new StyleSpan(zzaovVar.zzf()), i3, length, 33);
                }
                if (zzaovVar.zzg()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i3, length, 33);
                }
                if (zzaovVar.zzo()) {
                    zzdd.zza(spannableStringBuilder, new ForegroundColorSpan(zzaovVar.zzm()), i3, length, 33);
                }
                if (zzaovVar.zzr()) {
                    zzdd.zza(spannableStringBuilder, new BackgroundColorSpan(zzaovVar.zzp()), i3, length, 33);
                }
                if (zzaovVar.zzk() != null) {
                    zzdd.zza(spannableStringBuilder, new TypefaceSpan(zzaovVar.zzk()), i3, length, 33);
                }
                int iZzu = zzaovVar.zzu();
                if (iZzu == 1) {
                    zzdd.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzaovVar.zzv(), true), i3, length, 33);
                } else if (iZzu == 2) {
                    zzdd.zza(spannableStringBuilder, new RelativeSizeSpan(zzaovVar.zzv()), i3, length, 33);
                } else if (iZzu == 3) {
                    zzdd.zza(spannableStringBuilder, new RelativeSizeSpan(zzaovVar.zzv() / 100.0f), i3, length, 33);
                }
                if (zzaovVar.zzz()) {
                    spannableStringBuilder.setSpan(new zzdb(), i3, length, 33);
                }
            }
        }
    }

    private static int zzg(List list, String str, zzaoz zzaozVar) {
        List listZzh = zzh(list, str, zzaozVar);
        for (int i3 = 0; i3 < listZzh.size(); i3++) {
            zzaov zzaovVar = ((zzapa) listZzh.get(i3)).zzb;
            if (zzaovVar.zzx() != -1) {
                return zzaovVar.zzx();
            }
        }
        return -1;
    }

    private static List zzh(List list, String str, zzaoz zzaozVar) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzaov zzaovVar = (zzaov) list.get(i3);
            int iZze = zzaovVar.zze(str, zzaozVar.zza, zzaozVar.zzd, zzaozVar.zzc);
            if (iZze > 0) {
                arrayList.add(new zzapa(iZze, zzaovVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
