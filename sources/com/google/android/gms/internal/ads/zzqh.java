package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqh {
    public static final zzqh zza;
    static final zzgwp zzb;
    private static final zzgwm zzc;
    private static final zzgwm zzd;
    private static final zzgwm zze;
    private final SparseArray zzf = new SparseArray();
    private final int zzg;
    private final zzgwm zzh;
    private final zzgwm zzi;

    static {
        zzgwm zzgwmVarZzj = zzgwm.zzj(12);
        zzc = zzgwmVarZzj;
        zzgwm zzgwmVarZzi = zzgwm.zzi();
        zzd = zzgwmVarZzi;
        zza = new zzqh(zzgwm.zzj(zzqg.zza), zzgwmVarZzj, zzgwmVarZzi);
        zze = zzgwm.zzl(2, 5, 6);
        zzgwo zzgwoVar = new zzgwo();
        zzgwoVar.zza(5, 6);
        zzgwoVar.zza(17, 6);
        zzgwoVar.zza(7, 6);
        zzgwoVar.zza(30, 10);
        zzgwoVar.zza(18, 6);
        zzgwoVar.zza(6, 8);
        zzgwoVar.zza(8, 8);
        zzgwoVar.zza(14, 8);
        zzb = zzgwoVar.zzc();
    }

    private zzqh(List list, List list2, List list3) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzqg zzqgVar = (zzqg) list.get(i3);
            this.zzf.put(zzqgVar.zzb, zzqgVar);
        }
        int iMax = 0;
        for (int i4 = 0; i4 < this.zzf.size(); i4++) {
            iMax = Math.max(iMax, ((zzqg) this.zzf.valueAt(i4)).zzc);
        }
        this.zzg = iMax;
        this.zzh = zzgwm.zzq(list2);
        this.zzi = zzgwm.zzq(list3);
    }

    static zzqh zza(Context context, zzd zzdVar, AudioDeviceInfo audioDeviceInfo, List list) {
        return zzb(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.ads.zzqh zzb(android.content.Context r9, android.content.Intent r10, com.google.android.gms.internal.ads.zzd r11, android.media.AudioDeviceInfo r12, java.util.List r13) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqh.zzb(android.content.Context, android.content.Intent, com.google.android.gms.internal.ads.zzd, android.media.AudioDeviceInfo, java.util.List):com.google.android.gms.internal.ads.zzqh");
    }

    static Uri zzc() {
        if (zzg()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    private static boolean zzg() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    private static zzgwm zzh(int[] iArr, int i3) {
        int i4 = zzgwm.zzd;
        zzgwj zzgwjVar = new zzgwj();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i5 : iArr) {
            zzgwjVar.zzf(new zzqg(i5, i3));
        }
        return zzgwjVar.zzi();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqh)) {
            return false;
        }
        zzqh zzqhVar = (zzqh) obj;
        SparseArray sparseArray = this.zzf;
        SparseArray sparseArray2 = zzqhVar.zzf;
        String str = zzfl.zza;
        if (Build.VERSION.SDK_INT < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i3 = 0; i3 < size; i3++) {
                    if (!Objects.equals(sparseArray.valueAt(i3), sparseArray2.get(sparseArray.keyAt(i3)))) {
                        break;
                    }
                }
                if (this.zzg != zzqhVar.zzg) {
                }
            }
        } else if (sparseArray.contentEquals(sparseArray2)) {
            if (this.zzg != zzqhVar.zzg && Objects.equals(this.zzh, zzqhVar.zzh) && Objects.equals(this.zzi, zzqhVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzfl.zza;
        int i3 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzf;
        if (i3 >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iKeyAt = 17;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i4)) * 31) + Objects.hashCode(sparseArray.valueAt(i4));
            }
            iContentHashCode = iKeyAt;
        }
        return (((((this.zzg * 31) + iContentHashCode) * 31) + Objects.hashCode(this.zzh)) * 31) + Objects.hashCode(this.zzi);
    }

    public final String toString() {
        zzgwm zzgwmVar = this.zzi;
        zzgwm zzgwmVar2 = this.zzh;
        String string = this.zzf.toString();
        String strValueOf = String.valueOf(zzgwmVar2);
        String strValueOf2 = String.valueOf(zzgwmVar);
        int i3 = this.zzg;
        int length = String.valueOf(i3).length();
        int length2 = string.length();
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 28 + strValueOf.length() + 26 + strValueOf2.length() + 1);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i3);
        sb.append(", audioProfiles=");
        sb.append(string);
        sb.append(", speakerLayoutChannelMasks=");
        sb.append(strValueOf);
        sb.append(", spatializerChannelMasks=");
        sb.append(strValueOf2);
        sb.append("]");
        return sb.toString();
    }

    public final zzgwm zzd() {
        return this.zzh;
    }

    public final zzgwm zze() {
        return this.zzi;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[PHI: r1
      0x003a: PHI (r1v3 int) = (r1v2 int), (r1v7 int) binds: [B:11:0x002c, B:14:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair zzf(com.google.android.gms.internal.ads.zzv r10, com.google.android.gms.internal.ads.zzd r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.zzp
            r0.getClass()
            java.lang.String r1 = r10.zzk
            int r1 = com.google.android.gms.internal.ads.zzas.zzg(r0, r1)
            com.google.android.gms.internal.ads.zzgwp r2 = com.google.android.gms.internal.ads.zzqh.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L19
            goto Lad
        L19:
            r2 = 7
            r3 = 8
            r4 = 6
            r5 = 18
            if (r1 != r5) goto L2c
            android.util.SparseArray r1 = r9.zzf
            boolean r1 = com.google.android.gms.internal.ads.zzfl.zza(r1, r5)
            if (r1 != 0) goto L2b
            r1 = r4
            goto L47
        L2b:
            r1 = r5
        L2c:
            if (r1 != r3) goto L3a
            android.util.SparseArray r1 = r9.zzf
            boolean r1 = com.google.android.gms.internal.ads.zzfl.zza(r1, r3)
            if (r1 == 0) goto L38
            r1 = r3
            goto L3a
        L38:
            r1 = r2
            goto L47
        L3a:
            r6 = 30
            if (r1 != r6) goto L47
            android.util.SparseArray r7 = r9.zzf
            boolean r6 = com.google.android.gms.internal.ads.zzfl.zza(r7, r6)
            if (r6 != 0) goto L47
            goto L38
        L47:
            android.util.SparseArray r6 = r9.zzf
            boolean r7 = com.google.android.gms.internal.ads.zzfl.zza(r6, r1)
            if (r7 == 0) goto Lad
            java.lang.Object r6 = r6.get(r1)
            com.google.android.gms.internal.ads.zzqg r6 = (com.google.android.gms.internal.ads.zzqg) r6
            r6.getClass()
            int r7 = r10.zzH
            r8 = -1
            if (r7 == r8) goto L7a
            if (r1 != r5) goto L60
            goto L7a
        L60:
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L73
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 33
            if (r10 >= r11) goto L73
            r10 = 10
            if (r7 <= r10) goto L85
            goto Lad
        L73:
            boolean r10 = r6.zza(r7)
            if (r10 != 0) goto L85
            goto Lad
        L7a:
            int r10 = r10.zzI
            if (r10 != r8) goto L81
            r10 = 48000(0xbb80, float:6.7262E-41)
        L81:
            int r7 = r6.zzb(r10, r11)
        L85:
            int r10 = android.os.Build.VERSION.SDK_INT
            r11 = 28
            if (r10 > r11) goto L99
            if (r7 != r2) goto L8e
            goto L9a
        L8e:
            r10 = 3
            if (r7 == r10) goto L97
            r10 = 4
            if (r7 == r10) goto L97
            r10 = 5
            if (r7 != r10) goto L99
        L97:
            r3 = r4
            goto L9a
        L99:
            r3 = r7
        L9a:
            int r10 = com.google.android.gms.internal.ads.zzfl.zzE(r3)
            if (r10 == 0) goto Lad
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r11, r10)
            return r10
        Lad:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqh.zzf(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzd):android.util.Pair");
    }
}
