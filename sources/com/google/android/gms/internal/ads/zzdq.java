package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdq {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", "A", "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    public static zzgwm zza(byte b3, byte b4, byte b5, byte b6) {
        return zzgwm.zzj(new byte[]{1, 1, b3, 2, 1, b4, 3, 1, b5, 4, 1, b6});
    }

    public static String zzb(int i3, int i4, int i5) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String zzc(int i3, boolean z2, int i4, int i5, int[] iArr, int i6) {
        int i7;
        Object[] objArr = {zzc[i3], Integer.valueOf(i4), Integer.valueOf(i5), Character.valueOf(true != z2 ? 'L' : 'H'), Integer.valueOf(i6)};
        String str = zzfl.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i8 = 6;
        while (true) {
            if (i8 <= 0) {
                break;
            }
            int i9 = i8 - 1;
            if (iArr[i9] != 0) {
                break;
            }
            i8 = i9;
        }
        for (i7 = 0; i7 < i8; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }

    public static String zzd(byte[] bArr) {
        int length = bArr.length;
        zzgtj.zzd(length >= 17, "Invalid APV CSD length: %s", length);
        byte b3 = bArr[0];
        zzgtj.zzd(b3 == 1, "Invalid APV CSD version: %s", b3);
        Object[] objArr = {Integer.valueOf(bArr[5]), Integer.valueOf(bArr[6]), Integer.valueOf(bArr[7])};
        String str = zzfl.zza;
        return String.format(Locale.US, "apv1.apvf%d.apvl%d.apvb%d", objArr);
    }

    public static Pair zze(zzv zzvVar) {
        zzdp zzdpVarZzf = zzf(zzvVar);
        if (zzdpVarZzf == null || !zzdpVarZzf.zzc()) {
            return null;
        }
        return new Pair(Integer.valueOf(zzdpVarZzf.zza()), Integer.valueOf(zzdpVarZzf.zzb()));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzdp zzg(String str, String[] strArr, zzi zziVar) {
        int i3;
        Integer numValueOf = null;
        if (strArr.length < 4) {
            zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String strGroup = matcher.group(1);
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strGroup)) {
            i3 = 1;
        } else {
            if (!"2".equals(strGroup)) {
                zzeg.zzc("CodecSpecificDataUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                return zzdp.zza;
            }
            i3 = (zziVar == null || zziVar.zzd != 6) ? 2 : 4096;
        }
        String str2 = strArr[3];
        switch (str2.hashCode()) {
            case 70821:
                if (str2.equals("H30")) {
                    numValueOf = 2;
                }
                break;
            case 70914:
                if (str2.equals("H60")) {
                    numValueOf = 8;
                }
                break;
            case 70917:
                if (str2.equals("H63")) {
                    numValueOf = 32;
                }
                break;
            case 71007:
                if (str2.equals("H90")) {
                    numValueOf = Integer.valueOf(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                }
                break;
            case 71010:
                if (str2.equals("H93")) {
                    numValueOf = 512;
                }
                break;
            case 74665:
                if (str2.equals("L30")) {
                    numValueOf = 1;
                }
                break;
            case 74758:
                if (str2.equals("L60")) {
                    numValueOf = 4;
                }
                break;
            case 74761:
                if (str2.equals("L63")) {
                    numValueOf = 16;
                }
                break;
            case 74851:
                if (str2.equals("L90")) {
                    numValueOf = 64;
                }
                break;
            case 74854:
                if (str2.equals("L93")) {
                    numValueOf = Integer.valueOf(Function.MAX_NARGS);
                }
                break;
            case 2193639:
                if (str2.equals("H120")) {
                    numValueOf = 2048;
                }
                break;
            case 2193642:
                if (str2.equals("H123")) {
                    numValueOf = Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
                break;
            case 2193732:
                if (str2.equals("H150")) {
                    numValueOf = 32768;
                }
                break;
            case 2193735:
                if (str2.equals("H153")) {
                    numValueOf = 131072;
                }
                break;
            case 2193738:
                if (str2.equals("H156")) {
                    numValueOf = 524288;
                }
                break;
            case 2193825:
                if (str2.equals("H180")) {
                    numValueOf = 2097152;
                }
                break;
            case 2193828:
                if (str2.equals("H183")) {
                    numValueOf = 8388608;
                }
                break;
            case 2193831:
                if (str2.equals("H186")) {
                    numValueOf = 33554432;
                }
                break;
            case 2312803:
                if (str2.equals("L120")) {
                    numValueOf = 1024;
                }
                break;
            case 2312806:
                if (str2.equals("L123")) {
                    numValueOf = 4096;
                }
                break;
            case 2312896:
                if (str2.equals("L150")) {
                    numValueOf = 16384;
                }
                break;
            case 2312899:
                if (str2.equals("L153")) {
                    numValueOf = Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                }
                break;
            case 2312902:
                if (str2.equals("L156")) {
                    numValueOf = 262144;
                }
                break;
            case 2312989:
                if (str2.equals("L180")) {
                    numValueOf = 1048576;
                }
                break;
            case 2312992:
                if (str2.equals("L183")) {
                    numValueOf = 4194304;
                }
                break;
            case 2312995:
                if (str2.equals("L186")) {
                    numValueOf = 16777216;
                }
                break;
        }
        if (numValueOf != null) {
            return new zzdp(i3, numValueOf.intValue());
        }
        zzeg.zzc("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(str2));
        return zzdp.zza;
    }

    public static byte[] zzh(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = new byte[i4 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i3, bArr2, 4, i4);
        return bArr2;
    }

    private static int zzi(int i3, int i4) {
        switch (i3) {
            case 30:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb.append("Unrecognized APV band: ");
                                sb.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb.toString());
                            }
                        }
                    }
                }
                break;
            case 33:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb2.append("Unrecognized APV band: ");
                                sb2.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb2.toString());
                            }
                        }
                    }
                }
                break;
            case 60:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb3.append("Unrecognized APV band: ");
                                sb3.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb3.toString());
                            }
                        }
                    }
                }
                break;
            case 63:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb4 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb4.append("Unrecognized APV band: ");
                                sb4.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb4.toString());
                            }
                        }
                    }
                }
                break;
            case 90:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb5 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb5.append("Unrecognized APV band: ");
                                sb5.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb5.toString());
                            }
                        }
                    }
                }
                break;
            case 93:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb6 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb6.append("Unrecognized APV band: ");
                                sb6.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb6.toString());
                            }
                        }
                    }
                }
                break;
            case 120:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb7 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb7.append("Unrecognized APV band: ");
                                sb7.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb7.toString());
                            }
                        }
                    }
                }
                break;
            case 123:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb8 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb8.append("Unrecognized APV band: ");
                                sb8.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb8.toString());
                            }
                        }
                    }
                }
                break;
            case 150:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb9 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb9.append("Unrecognized APV band: ");
                                sb9.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb9.toString());
                            }
                        }
                    }
                }
                break;
            case 153:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb10 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb10.append("Unrecognized APV band: ");
                                sb10.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb10.toString());
                            }
                        }
                    }
                }
                break;
            case SensibleDefaults.X_OFFSET /* 180 */:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb11 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb11.append("Unrecognized APV band: ");
                                sb11.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb11.toString());
                            }
                        }
                    }
                }
                break;
            case 183:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb12 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb12.append("Unrecognized APV band: ");
                                sb12.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb12.toString());
                            }
                        }
                    }
                }
                break;
            case 210:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb13 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb13.append("Unrecognized APV band: ");
                                sb13.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb13.toString());
                            }
                        }
                    }
                }
                break;
            case 213:
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                StringBuilder sb14 = new StringBuilder(String.valueOf(i4).length() + 23);
                                sb14.append("Unrecognized APV band: ");
                                sb14.append(i4);
                                zzeg.zzc("CodecSpecificDataUtil", sb14.toString());
                            }
                        }
                    }
                }
                break;
            default:
                StringBuilder sb15 = new StringBuilder(String.valueOf(i3).length() + 30);
                sb15.append("Unrecognized APV level index: ");
                sb15.append(i3);
                zzeg.zzc("CodecSpecificDataUtil", sb15.toString());
                break;
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x0743, code lost:
    
        if (r5.equals("hvc1") != false) goto L426;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x074c, code lost:
    
        if (r5.equals("hev1") != false) goto L426;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0a68  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzdp zzf(com.google.android.gms.internal.ads.zzv r30) {
        /*
            Method dump skipped, instruction units count: 3198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdq.zzf(com.google.android.gms.internal.ads.zzv):com.google.android.gms.internal.ads.zzdp");
    }
}
