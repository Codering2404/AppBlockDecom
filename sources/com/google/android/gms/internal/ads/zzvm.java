package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvm {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    private final boolean zzi;
    private int zzj;
    private int zzk;
    private float zzl;

    zzvm(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z2;
        this.zze = z5;
        this.zzf = z7;
        this.zzh = z8;
        this.zzi = zzas.zzb(str2);
        this.zzl = -3.4028235E38f;
        this.zzj = -1;
        this.zzk = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzvm zza(java.lang.String r12, java.lang.String r13, java.lang.String r14, android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            com.google.android.gms.internal.ads.zzvm r0 = new com.google.android.gms.internal.ads.zzvm
            r1 = 1
            r2 = 0
            if (r15 == 0) goto L10
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L10
            r8 = r1
            goto L11
        L10:
            r8 = r2
        L11:
            if (r15 == 0) goto L1d
            java.lang.String r3 = "tunneled-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L1d
            r9 = r1
            goto L1e
        L1d:
            r9 = r2
        L1e:
            if (r20 != 0) goto L2a
            if (r15 == 0) goto L2c
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L2c
        L2a:
            r10 = r1
            goto L2d
        L2c:
            r10 = r2
        L2d:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 35
            if (r3 < r4) goto L67
            if (r15 == 0) goto L67
            java.lang.String r3 = "detached-surface"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L67
            java.lang.String r3 = android.os.Build.MANUFACTURER
            java.lang.String r4 = "Xiaomi"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L67
            java.lang.String r4 = "OPPO"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L67
            java.lang.String r4 = "realme"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L67
            java.lang.String r4 = "motorola"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L67
            java.lang.String r4 = "LENOVO"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L73
        L67:
            r1 = r12
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r11 = r2
            r2 = r13
            goto L7e
        L73:
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r11 = r1
            r1 = r12
        L7e:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvm.zza(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzvm");
    }

    private final boolean zzj(zzv zzvVar) {
        String str = this.zzb;
        return str.equals(zzvVar.zzp) || str.equals(zzwf.zzg(zzvVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzk(android.content.Context r12, com.google.android.gms.internal.ads.zzv r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvm.zzk(android.content.Context, com.google.android.gms.internal.ads.zzv, boolean):boolean");
    }

    private final boolean zzl(zzv zzvVar) {
        return (Objects.equals(zzvVar.zzp, "audio/flac") && zzvVar.zzJ == 22 && Build.VERSION.SDK_INT < 34 && this.zza.equals("c2.android.flac.decoder")) ? false : true;
    }

    private final void zzm(String str) {
        String str2 = zzfl.zza;
        String str3 = this.zzb;
        int length = String.valueOf(str3).length();
        int length2 = String.valueOf(str2).length();
        int length3 = str.length();
        String str4 = this.zza;
        StringBuilder sb = new StringBuilder(length3 + 14 + str4.length() + 2 + length + 3 + length2 + 1);
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str4);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str2);
        sb.append("]");
        zzeg.zza("MediaCodecInfo", sb.toString());
    }

    private static boolean zzn(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4, double d3) {
        Point pointZzo = zzo(videoCapabilities, i3, i4);
        int i5 = pointZzo.x;
        int i6 = pointZzo.y;
        if (d3 == -1.0d || d3 < 1.0d) {
            return videoCapabilities.isSizeSupported(i5, i6);
        }
        double dFloor = Math.floor(d3);
        if (!videoCapabilities.areSizeAndRateSupported(i5, i6, dFloor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i5, i6);
        return achievableFrameRatesFor == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
    }

    private static Point zzo(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        String str = zzfl.zza;
        return new Point((((i3 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i4 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    public final String toString() {
        return this.zza;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzb() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public final boolean zzc(Context context, zzv zzvVar) {
        int i3;
        if (!zzj(zzvVar) || !zzk(context, zzvVar, true) || !zzl(zzvVar)) {
            return false;
        }
        if (this.zzi) {
            int i4 = zzvVar.zzw;
            if (i4 <= 0 || (i3 = zzvVar.zzx) <= 0) {
                return true;
            }
            return zzg(i4, i3, zzvVar.zzA);
        }
        int i5 = zzvVar.zzI;
        if (i5 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzm("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzm("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i5)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 20);
                sb.append("sampleRate.support, ");
                sb.append(i5);
                zzm(sb.toString());
                return false;
            }
        }
        int i6 = zzvVar.zzH;
        if (i6 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzm("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
            if (audioCapabilities2 == null) {
                zzm("channelCount.aCaps");
                return false;
            }
            String str = this.zza;
            String str2 = this.zzb;
            int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
            if (maxInputChannelCount <= 1 && maxInputChannelCount <= 0 && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2)) {
                int i7 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
                StringBuilder sb2 = new StringBuilder(str.length() + 32 + String.valueOf(maxInputChannelCount).length() + 4 + String.valueOf(i7).length() + 1);
                sb2.append("AssumedMaxChannelAdjustment: ");
                sb2.append(str);
                sb2.append(", [");
                sb2.append(maxInputChannelCount);
                sb2.append(" to ");
                sb2.append(i7);
                sb2.append("]");
                zzeg.zzc("MediaCodecInfo", sb2.toString());
                maxInputChannelCount = i7;
            }
            if (maxInputChannelCount < i6) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 22);
                sb3.append("channelCount.support, ");
                sb3.append(i6);
                zzm(sb3.toString());
                return false;
            }
        }
        return true;
    }

    public final boolean zzd(Context context, zzv zzvVar) {
        return zzj(zzvVar) && zzk(context, zzvVar, false) && zzl(zzvVar);
    }

    public final boolean zze(zzv zzvVar) {
        if (this.zzi) {
            return this.zze;
        }
        zzdp zzdpVarZzf = zzdq.zzf(zzvVar);
        return zzdpVarZzf != null && zzdpVarZzf.zzc() && zzdpVarZzf.zza() == 42;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzg(int r10, int r11, double r12) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvm.zzg(int, int, double):boolean");
    }

    public final float zzh(int i3, int i4) {
        if (!this.zzi) {
            return -3.4028235E38f;
        }
        float f3 = this.zzl;
        if (f3 != -3.4028235E38f && this.zzj == i3 && this.zzk == i4) {
            return f3;
        }
        float f4 = 1024.0f;
        if (!zzg(i3, i4, 1024.0d)) {
            float f5 = 0.0f;
            while (true) {
                float f6 = f4 - f5;
                if (Math.abs(f6) <= 5.0f) {
                    break;
                }
                float f7 = (f6 / 2.0f) + f5;
                boolean zZzg = zzg(i3, i4, f7);
                if (true == zZzg) {
                    f5 = f7;
                }
                if (true != zZzg) {
                    f4 = f7;
                }
            }
            f4 = f5;
        }
        this.zzl = f4;
        this.zzj = i3;
        this.zzk = i4;
        return f4;
    }

    public final Point zzi(int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzo(videoCapabilities, i3, i4);
    }

    public final zzjc zzf(zzv zzvVar, zzv zzvVar2) {
        zzv zzvVar3;
        zzv zzvVar4;
        int i3;
        String str = zzvVar.zzp;
        String str2 = zzvVar2.zzp;
        int i4 = true != Objects.equals(str, str2) ? 8 : 0;
        if (this.zzi) {
            if (zzvVar.zzB != zzvVar2.zzB) {
                i4 |= 1024;
            }
            boolean z2 = (zzvVar.zzw == zzvVar2.zzw && zzvVar.zzx == zzvVar2.zzx) ? false : true;
            if (!this.zze && z2) {
                i4 |= 512;
            }
            zzi zziVar = zzvVar.zzF;
            if ((!zzi.zza(zziVar) || !zzi.zza(zzvVar2.zzF)) && !Objects.equals(zziVar, zzvVar2.zzF)) {
                i4 |= 2048;
            }
            String str3 = this.zza;
            if (Build.MODEL.startsWith("SM-T230") && KrzujOtzIk.dmWP.equals(str3) && !zzvVar.zzd(zzvVar2)) {
                i4 |= 2;
            }
            int i5 = zzvVar.zzy;
            if (i5 != -1 && (i3 = zzvVar.zzz) != -1 && i5 == zzvVar2.zzy && i3 == zzvVar2.zzz && z2) {
                i4 |= 2;
            }
            if (i4 == 0 && Objects.equals(str2, "video/dolby-vision")) {
                Pair pairZze = zzdq.zze(zzvVar);
                Pair pairZze2 = zzdq.zze(zzvVar2);
                if (pairZze == null || pairZze2 == null || !((Integer) pairZze.first).equals(pairZze2.first)) {
                    i4 = 2;
                }
            }
            if (i4 == 0) {
                return new zzjc(str3, zzvVar, zzvVar2, true == zzvVar.zzd(zzvVar2) ? 3 : 2, 0);
            }
            zzvVar3 = zzvVar;
            zzvVar4 = zzvVar2;
        } else {
            zzvVar3 = zzvVar;
            zzvVar4 = zzvVar2;
            if (zzvVar3.zzH != zzvVar4.zzH) {
                i4 |= 4096;
            }
            if (zzvVar3.zzI != zzvVar4.zzI) {
                i4 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            if (zzvVar3.zzJ != zzvVar4.zzJ) {
                i4 |= 16384;
            }
            if (i4 == 0) {
                String str4 = this.zzb;
                if (str4.equals("audio/mp4a-latm") || str4.equals("audio/ac4")) {
                    Pair pairZze3 = zzdq.zze(zzvVar3);
                    Pair pairZze4 = zzdq.zze(zzvVar4);
                    if (pairZze3 != null && pairZze4 != null) {
                        int iIntValue = ((Integer) pairZze3.first).intValue();
                        int iIntValue2 = ((Integer) pairZze4.first).intValue();
                        if (iIntValue == 42 && iIntValue2 == 42) {
                            return new zzjc(this.zza, zzvVar3, zzvVar4, 3, 0);
                        }
                        if (str4.equals("audio/ac4") && pairZze3.equals(pairZze4)) {
                            return new zzjc(this.zza, zzvVar3, zzvVar4, 3, 0);
                        }
                    }
                }
            }
            if (i4 == 0) {
                String str5 = this.zzb;
                if (str5.equals("audio/eac3-joc") || str5.equals("audio/eac3")) {
                    return new zzjc(this.zza, zzvVar3, zzvVar4, 3, 0);
                }
            }
            if (!zzvVar3.zzd(zzvVar4)) {
                i4 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i4 |= 2;
            }
            if (i4 == 0) {
                return new zzjc(this.zza, zzvVar3, zzvVar4, 1, 0);
            }
        }
        return new zzjc(this.zza, zzvVar3, zzvVar4, 0, i4);
    }
}
