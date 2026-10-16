package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzas {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean zza(String str) {
        return "audio".equals(zzj(str));
    }

    public static boolean zzb(String str) {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO.equals(zzj(str));
    }

    public static boolean zzc(String str) {
        return "image".equals(zzj(str)) || "application/x-image-uri".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean zzd(String str, String str2) {
        zzar zzarVarZzi;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                }
                break;
            case -1354451219:
                if (str.equals("application/vnd.dvb.ait")) {
                }
                break;
            case -1348231605:
                if (str.equals("application/x-icy")) {
                }
                break;
            case -1265048566:
                if (str.equals("application/x-camera-motion")) {
                }
                break;
            case -1248341703:
                if (str.equals("application/id3")) {
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                }
                break;
            case -53558318:
                if (!str.equals("audio/mp4a-latm") || str2 == null || (zzarVarZzi = zzi(str2)) == null || (iZza = zzarVarZzi.zza()) == 0 || iZza == 16) {
                }
                break;
            case -43764892:
                if (str.equals("application/meta")) {
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                }
                break;
            case 469933706:
                if (str.equals("application/x-media3-cues")) {
                }
                break;
            case 1054472807:
                if (str.equals("application/x-itut-t35")) {
                }
                break;
            case 1154383568:
                if (str.equals("application/x-emsg")) {
                }
                break;
            case 1331836563:
                if (str.equals(KLAQHFCRAUejH.cFUfYhnXEZE)) {
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                }
                break;
            case 1652648887:
                if (str.equals("application/x-scte35")) {
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                }
                break;
        }
        return false;
    }

    public static String zze(int i3) {
        if (i3 == 32) {
            return "video/mp4v-es";
        }
        if (i3 == 33) {
            return "video/avc";
        }
        if (i3 == 35) {
            return "video/hevc";
        }
        if (i3 == 64) {
            return "audio/mp4a-latm";
        }
        if (i3 == 163) {
            return "video/wvc1";
        }
        if (i3 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i3 == 221) {
            return "audio/vorbis";
        }
        if (i3 == 165) {
            return "audio/ac3";
        }
        if (i3 == 166) {
            return "audio/eac3";
        }
        switch (i3) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i3) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static int zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zza(str)) {
            return 1;
        }
        if (zzb(str)) {
            return 2;
        }
        if ("text".equals(zzj(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if (zzc(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str) || "application/meta".equals(str) || "application/x-itut-t35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str2 = ((zzaq) arrayList.get(i3)).zza;
            if (str.equals(null)) {
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzg(java.lang.String r3, java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzas.zzg(java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String zzh(String str) {
        if (str == null) {
            return null;
        }
        String strZza = zzgss.zza(str);
        switch (strZza.hashCode()) {
            case -1833600100:
                return strZza.equals("video/x-mvhevc") ? "video/mv-hevc" : strZza;
            case -1007807498:
                return strZza.equals("audio/x-flac") ? "audio/flac" : strZza;
            case -979095690:
                return strZza.equals("application/x-mpegurl") ? "application/x-mpegURL" : strZza;
            case -586683234:
                return strZza.equals("audio/x-wav") ? "audio/wav" : strZza;
            case -432836268:
                return strZza.equals("audio/mpeg-l1") ? "audio/mpeg-L1" : strZza;
            case -432836267:
                return strZza.equals("audio/mpeg-l2") ? "audio/mpeg-L2" : strZza;
            case 187090231:
                return strZza.equals("audio/mp3") ? "audio/mpeg" : strZza;
            default:
                return strZza;
        }
    }

    static zzar zzi(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzar(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String zzj(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
