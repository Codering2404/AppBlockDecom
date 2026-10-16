package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwf {
    public static final /* synthetic */ int zza = 0;
    private static final HashMap zzb = new HashMap();

    public static zzvm zza() throws zzvx {
        List listZzb = zzb("audio/raw", false, false);
        if (listZzb.isEmpty()) {
            return null;
        }
        return (zzvm) listZzb.get(0);
    }

    public static synchronized List zzb(String str, boolean z2, boolean z3) throws zzvx {
        try {
            zzvw zzvwVar = new zzvw(str, z2, z3);
            HashMap map = zzb;
            List list = (List) map.get(zzvwVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListZzh = zzh(zzvwVar, new zzwa(z2, z3, str.equals("video/mv-hevc")));
            if (z2) {
                arrayListZzh.isEmpty();
            }
            if ("audio/raw".equals(str)) {
                zzj(arrayListZzh, zzwb.zza);
            }
            if (Build.VERSION.SDK_INT < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzvm) arrayListZzh.get(0)).zza)) {
                arrayListZzh.add((zzvm) arrayListZzh.remove(0));
            }
            zzgwm zzgwmVarZzq = zzgwm.zzq(arrayListZzh);
            map.put(zzvwVar, zzgwmVarZzq);
            return zzgwmVarZzq;
        } catch (Throwable th) {
            throw th;
        }
    }

    @RequiresNonNull
    public static List zzc(zzvv zzvvVar, zzv zzvVar, boolean z2, boolean z3) throws zzvx {
        List listZza = zzvvVar.zza(zzvVar.zzp, z2, z3);
        List listZzd = zzd(zzvvVar, zzvVar, z2, z3);
        int i3 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        zzgwjVar.zzh(listZza);
        zzgwjVar.zzh(listZzd);
        return zzgwjVar.zzi();
    }

    public static List zzd(zzvv zzvvVar, zzv zzvVar, boolean z2, boolean z3) throws zzvx {
        String strZzg = zzg(zzvVar);
        return strZzg == null ? zzgwm.zzi() : zzvvVar.zza(strZzg, z2, z3);
    }

    public static List zze(final Context context, List list, final zzv zzvVar) {
        ArrayList arrayList = new ArrayList(list);
        zzj(arrayList, new zzwe() { // from class: com.google.android.gms.internal.ads.zzwd
            @Override // com.google.android.gms.internal.ads.zzwe
            public final /* synthetic */ int zza(Object obj) {
                int i3 = zzwf.zza;
                return ((zzvm) obj).zzd(context, zzvVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    public static MediaCodecInfo.CodecProfileLevel zzf(int i3, int i4) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i3;
        codecProfileLevel.level = i4;
        return codecProfileLevel;
    }

    public static String zzg(zzv zzvVar) {
        zzdp zzdpVarZzf;
        String str = zzvVar.zzp;
        if ("audio/eac3-joc".equals(str)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(str) && (zzdpVarZzf = zzdq.zzf(zzvVar)) != null && zzdpVarZzf.zzc()) {
            int iZza = zzdpVarZzf.zza();
            if (iZza == 16 || iZza == 256) {
                return "video/hevc";
            }
            if (iZza == 512) {
                return "video/avc";
            }
            if (iZza == 1024) {
                zzi zziVar = zzvVar.zzF;
                if (zziVar != null && zziVar.zzd == 6 && zziVar.zzc == 1) {
                    return null;
                }
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(str)) {
            return "video/hevc";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0200 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013c A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0158 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:64:0x00f8, B:71:0x0114, B:77:0x0128, B:79:0x0130, B:87:0x0149, B:89:0x0153, B:90:0x0158, B:92:0x0168, B:94:0x0170, B:83:0x013c), top: B:127:0x00f8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzvw r24, com.google.android.gms.internal.ads.zzvy r25) throws com.google.android.gms.internal.ads.zzvx {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzh(com.google.android.gms.internal.ads.zzvw, com.google.android.gms.internal.ads.zzvy):java.util.ArrayList");
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzas.zza(str)) {
            return true;
        }
        String strZza = zzgss.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.") || ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google."))) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }

    private static void zzj(List list, final zzwe zzweVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwc
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i3 = zzwf.zza;
                zzwe zzweVar2 = zzweVar;
                return zzweVar2.zza(obj2) - zzweVar2.zza(obj);
            }
        });
    }
}
