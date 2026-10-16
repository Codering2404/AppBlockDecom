package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList f60191a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f60192b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60194b;

        public a(int i3, int i4) {
            this.f60193a = i3;
            this.f60194b = i4;
        }

        public int a() {
            int i3 = this.f60194b;
            if (i3 == 2) {
                return 10;
            }
            if (i3 == 5) {
                return 11;
            }
            if (i3 == 29) {
                return 12;
            }
            if (i3 == 42) {
                return 16;
            }
            if (i3 != 22) {
                return i3 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    public static boolean a(String str, String str2) {
        a aVarC;
        int iA;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (aVarC = c(str2)) != null && (iA = aVarC.a()) != 0 && iA != 16) {
                }
                break;
        }
        return false;
    }

    public static int b(String str, String str2) {
        a aVarC;
        str.getClass();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (aVarC = c(str2)) == null) {
                    return 0;
                }
                return aVarC.a();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    static a c(String str) {
        Matcher matcher = f60192b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) b1.a((Object) matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new a(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String d(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (g(str)) {
            return 1;
        }
        if (i(str)) {
            return 2;
        }
        if (h(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        return f(str);
    }

    private static int f(String str) {
        ArrayList arrayList = f60191a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        c8.a(arrayList.get(0));
        throw null;
    }

    public static boolean g(String str) {
        return "audio".equals(d(str));
    }

    public static boolean h(String str) {
        return "text".equals(d(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean i(String str) {
        return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO.equals(d(str));
    }

    public static String j(String str) {
        str.getClass();
        switch (str) {
            case "audio/x-flac":
                return "audio/flac";
            case "audio/x-wav":
                return "audio/wav";
            case "audio/mp3":
                return "audio/mpeg";
            default:
                return str;
        }
    }

    public static String a(int i3) {
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
        if (i3 == 165) {
            return "audio/ac3";
        }
        if (i3 != 166) {
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
        return "audio/eac3";
    }

    public static String b(String str) {
        a aVarC;
        String strA = null;
        if (str == null) {
            return null;
        }
        String lowerCase = Ascii.toLowerCase(str.trim());
        if (!lowerCase.startsWith("avc1") && !lowerCase.startsWith("avc3")) {
            if (!lowerCase.startsWith("hev1") && !lowerCase.startsWith("hvc1")) {
                if (!lowerCase.startsWith("dvav") && !lowerCase.startsWith("dva1") && !lowerCase.startsWith("dvhe") && !lowerCase.startsWith("dvh1")) {
                    if (lowerCase.startsWith("av01")) {
                        return "video/av01";
                    }
                    if (!lowerCase.startsWith("vp9") && !lowerCase.startsWith("vp09")) {
                        if (!lowerCase.startsWith("vp8") && !lowerCase.startsWith("vp08")) {
                            if (lowerCase.startsWith("mp4a")) {
                                if (lowerCase.startsWith("mp4a.") && (aVarC = c(lowerCase)) != null) {
                                    strA = a(aVarC.f60193a);
                                }
                                return strA == null ? "audio/mp4a-latm" : strA;
                            }
                            if (lowerCase.startsWith("mha1")) {
                                return "audio/mha1";
                            }
                            if (lowerCase.startsWith("mhm1")) {
                                return "audio/mhm1";
                            }
                            if (!lowerCase.startsWith("ac-3") && !lowerCase.startsWith("dac3")) {
                                if (!lowerCase.startsWith("ec-3") && !lowerCase.startsWith("dec3")) {
                                    if (lowerCase.startsWith("ec+3")) {
                                        return "audio/eac3-joc";
                                    }
                                    if (!lowerCase.startsWith("ac-4") && !lowerCase.startsWith("dac4")) {
                                        if (lowerCase.startsWith("dtsc")) {
                                            return "audio/vnd.dts";
                                        }
                                        if (lowerCase.startsWith("dtse")) {
                                            return "audio/vnd.dts.hd;profile=lbr";
                                        }
                                        if (!lowerCase.startsWith("dtsh") && !lowerCase.startsWith("dtsl")) {
                                            if (lowerCase.startsWith("dtsx")) {
                                                return "audio/vnd.dts.uhd;profile=p2";
                                            }
                                            if (lowerCase.startsWith("opus")) {
                                                return "audio/opus";
                                            }
                                            if (lowerCase.startsWith("vorbis")) {
                                                return "audio/vorbis";
                                            }
                                            if (lowerCase.startsWith("flac")) {
                                                return "audio/flac";
                                            }
                                            if (lowerCase.startsWith("stpp")) {
                                                return "application/ttml+xml";
                                            }
                                            if (lowerCase.startsWith("wvtt")) {
                                                return "text/vtt";
                                            }
                                            if (lowerCase.contains("cea708")) {
                                                return "application/cea-708";
                                            }
                                            if (!lowerCase.contains("eia608") && !lowerCase.contains("cea608")) {
                                                return a(lowerCase);
                                            }
                                            return "application/cea-608";
                                        }
                                        return "audio/vnd.dts.hd";
                                    }
                                    return "audio/ac4";
                                }
                                return "audio/eac3";
                            }
                            return "audio/ac3";
                        }
                        return "video/x-vnd.on2.vp8";
                    }
                    return "video/x-vnd.on2.vp9";
                }
                return "video/dolby-vision";
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    private static String a(String str) {
        ArrayList arrayList = f60191a;
        if (arrayList.size() <= 0) {
            return null;
        }
        c8.a(arrayList.get(0));
        throw null;
    }
}
