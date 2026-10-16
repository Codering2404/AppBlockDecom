package com.applovin.impl;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f61407a = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap f61408b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f61409c = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f61410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f61411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f61412c;

        public b(String str, boolean z2, boolean z3) {
            this.f61410a = str;
            this.f61411b = z2;
            this.f61412c = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == b.class) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.f61410a, bVar.f61410a) && this.f61411b == bVar.f61411b && this.f61412c == bVar.f61412c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f61410a.hashCode() + 31) * 31) + (this.f61411b ? 1231 : 1237)) * 31) + (this.f61412c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c extends Exception {
        private c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface d {
        int a();

        MediaCodecInfo a(int i3);

        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e implements d {
        private e() {
        }

        @Override // com.applovin.impl.md.d
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.applovin.impl.md.d
        public boolean b() {
            return false;
        }

        @Override // com.applovin.impl.md.d
        public MediaCodecInfo a(int i3) {
            return MediaCodecList.getCodecInfoAt(i3);
        }

        @Override // com.applovin.impl.md.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.applovin.impl.md.d
        public int a() {
            return MediaCodecList.getCodecCount();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f61413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MediaCodecInfo[] f61414b;

        public f(boolean z2, boolean z3) {
            this.f61413a = (z2 || z3) ? 1 : 0;
        }

        private void c() {
            if (this.f61414b == null) {
                this.f61414b = new MediaCodecList(this.f61413a).getCodecInfos();
            }
        }

        @Override // com.applovin.impl.md.d
        public int a() {
            c();
            return this.f61414b.length;
        }

        @Override // com.applovin.impl.md.d
        public boolean b() {
            return true;
        }

        @Override // com.applovin.impl.md.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.applovin.impl.md.d
        public MediaCodecInfo a(int i3) {
            c();
            return this.f61414b[i3];
        }

        @Override // com.applovin.impl.md.d
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface g {
        int a(Object obj);
    }

    private static int a(int i3) {
        switch (i3) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            case 8:
                return Function.MAX_NARGS;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int b(int i3) {
        switch (i3) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i3) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    default:
                        switch (i3) {
                            case 30:
                                return Function.MAX_NARGS;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i3) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
                                    default:
                                        switch (i3) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int g(int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return i3 != 3 ? -1 : 8;
        }
        return 4;
    }

    private static boolean h(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Integer a(String str) {
        if (str == null) {
            return null;
        }
        byte b3 = -1;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    b3 = 0;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    b3 = 1;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    b3 = 2;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    b3 = 3;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    b3 = 4;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    b3 = 5;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    b3 = 6;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    b3 = 7;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    b3 = 8;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b3 = 9;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b3 = 10;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b3 = Ascii.FF;
                }
                break;
        }
        switch (b3) {
        }
        return null;
    }

    private static Integer b(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    private static int c(int i3) {
        if (i3 == 1 || i3 == 2) {
            return 25344;
        }
        switch (i3) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD /* 128 */:
            case Function.MAX_NARGS /* 256 */:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /* 65536 */:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int d(int i3) {
        if (i3 == 66) {
            return 1;
        }
        if (i3 == 77) {
            return 2;
        }
        if (i3 == 88) {
            return 4;
        }
        if (i3 == 100) {
            return 8;
        }
        if (i3 == 110) {
            return 16;
        }
        if (i3 != 122) {
            return i3 != 244 ? -1 : 64;
        }
        return 32;
    }

    private static int e(int i3) {
        int i4 = 17;
        if (i3 != 17) {
            i4 = 20;
            if (i3 != 20) {
                i4 = 23;
                if (i3 != 23) {
                    i4 = 29;
                    if (i3 != 29) {
                        i4 = 39;
                        if (i3 != 39) {
                            i4 = 42;
                            if (i3 != 42) {
                                switch (i3) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i4;
    }

    private static int f(int i3) {
        if (i3 == 10) {
            return 1;
        }
        if (i3 == 11) {
            return 2;
        }
        if (i3 == 20) {
            return 4;
        }
        if (i3 == 21) {
            return 8;
        }
        if (i3 == 30) {
            return 16;
        }
        if (i3 == 31) {
            return 32;
        }
        if (i3 == 40) {
            return 64;
        }
        if (i3 == 41) {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (i3 == 50) {
            return Function.MAX_NARGS;
        }
        if (i3 == 51) {
            return 512;
        }
        switch (i3) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            default:
                return -1;
        }
    }

    private static boolean g(MediaCodecInfo mediaCodecInfo) {
        if (xp.f65027a >= 29) {
            return h(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        return (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) ? false : true;
    }

    private static Pair c(String str, String[] strArr) {
        if (strArr.length < 3) {
            oc.d("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f61407a.matcher(strArr[1]);
        if (!matcher.matches()) {
            oc.d("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numB = b(strGroup);
        if (numB == null) {
            oc.d("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numA = a(str2);
        if (numA == null) {
            oc.d("MediaCodecUtil", "Unknown Dolby Vision level string: " + str2);
            return null;
        }
        return new Pair(numB, numA);
    }

    private static Pair d(String str, String[] strArr) {
        if (strArr.length < 4) {
            oc.d("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i3 = 1;
        Matcher matcher = f61407a.matcher(strArr[1]);
        if (!matcher.matches()) {
            oc.d("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                oc.d("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i3 = 2;
        }
        String str2 = strArr[3];
        Integer numC = c(str2);
        if (numC == null) {
            oc.d("MediaCodecUtil", "Unknown HEVC level string: " + str2);
            return null;
        }
        return new Pair(Integer.valueOf(i3), numC);
    }

    private static Pair e(String str, String[] strArr) {
        int length = strArr.length;
        String str2 = jlWo.JMHofuw;
        if (length < 3) {
            oc.d(str2, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i3 = Integer.parseInt(strArr[1]);
            int i4 = Integer.parseInt(strArr[2]);
            int iG = g(i3);
            if (iG == -1) {
                oc.d(str2, "Unknown VP9 profile: " + i3);
                return null;
            }
            int iF = f(i4);
            if (iF == -1) {
                oc.d(str2, "Unknown VP9 level: " + i4);
                return null;
            }
            return new Pair(Integer.valueOf(iG), Integer.valueOf(iF));
        } catch (NumberFormatException unused) {
            oc.d(str2, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static boolean f(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static Pair b(String str, String[] strArr) {
        int i3;
        int i4;
        if (strArr.length < 2) {
            oc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i4 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i3 = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int i5 = Integer.parseInt(strArr[1]);
                i3 = Integer.parseInt(strArr[2]);
                i4 = i5;
            } else {
                oc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int iD = d(i4);
            if (iD == -1) {
                oc.d("MediaCodecUtil", "Unknown AVC profile: " + i4);
                return null;
            }
            int iB = b(i3);
            if (iB == -1) {
                oc.d("MediaCodecUtil", "Unknown AVC level: " + i3);
                return null;
            }
            return new Pair(Integer.valueOf(iD), Integer.valueOf(iB));
        } catch (NumberFormatException unused) {
            oc.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static boolean e(MediaCodecInfo mediaCodecInfo) {
        if (xp.f65027a >= 29) {
            return f(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
            return true;
        }
        return (lowerCase.startsWith("omx.") || lowerCase.startsWith("c2.")) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Integer c(String str) {
        if (str == null) {
            return null;
        }
        byte b3 = -1;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    b3 = 0;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    b3 = 1;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    b3 = 2;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    b3 = 3;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    b3 = 4;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    b3 = 5;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    b3 = 6;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    b3 = 7;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    b3 = 8;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    b3 = 9;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    b3 = 10;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    b3 = Ascii.VT;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    b3 = Ascii.CR;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    b3 = Ascii.SO;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    b3 = Ascii.SI;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    b3 = 16;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    b3 = 17;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    b3 = 19;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    b3 = Ascii.SYN;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    b3 = Ascii.ETB;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    b3 = Ascii.CAN;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    b3 = Ascii.EM;
                }
                break;
        }
        switch (b3) {
        }
        return null;
    }

    private static Pair a(String str, String[] strArr) {
        int iE;
        if (strArr.length != 3) {
            oc.d("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(hf.a(Integer.parseInt(strArr[1], 16))) && (iE = e(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iE), 0);
            }
        } catch (NumberFormatException unused) {
            oc.d("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static boolean d(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static Pair a(String str, String[] strArr, r3 r3Var) {
        int i3;
        if (strArr.length < 4) {
            oc.d("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i4 = 1;
        try {
            int i5 = Integer.parseInt(strArr[1]);
            int i6 = Integer.parseInt(strArr[2].substring(0, 2));
            int i7 = Integer.parseInt(strArr[3]);
            if (i5 != 0) {
                oc.d("MediaCodecUtil", "Unknown AV1 profile: " + i5);
                return null;
            }
            if (i7 != 8 && i7 != 10) {
                oc.d("MediaCodecUtil", "Unknown AV1 bit depth: " + i7);
                return null;
            }
            if (i7 != 8) {
                i4 = (r3Var == null || !(r3Var.f62725d != null || (i3 = r3Var.f62724c) == 7 || i3 == 6)) ? 2 : 4096;
            }
            int iA = a(i6);
            if (iA == -1) {
                oc.d("MediaCodecUtil", "Unknown AV1 level: " + i6);
                return null;
            }
            return new Pair(Integer.valueOf(i4), Integer.valueOf(iA));
        } catch (NumberFormatException unused) {
            oc.d("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(jd jdVar) {
        return jdVar.f60691a.startsWith("OMX.google") ? 1 : 0;
    }

    public static synchronized List b(String str, boolean z2, boolean z3) {
        d eVar;
        try {
            b bVar = new b(str, z2, z3);
            HashMap map = f61408b;
            List list = (List) map.get(bVar);
            if (list != null) {
                return list;
            }
            int i3 = xp.f65027a;
            if (i3 >= 21) {
                eVar = new f(z2, z3);
            } else {
                eVar = new e();
            }
            ArrayList arrayListA = a(bVar, eVar);
            if (z2 && arrayListA.isEmpty() && 21 <= i3 && i3 <= 23) {
                arrayListA = a(bVar, new e());
                if (!arrayListA.isEmpty()) {
                    oc.d("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((jd) arrayListA.get(0)).f60691a);
                }
            }
            a(str, arrayListA);
            List listUnmodifiableList = Collections.unmodifiableList(arrayListA);
            map.put(bVar, listUnmodifiableList);
            return listUnmodifiableList;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    private static boolean c(MediaCodecInfo mediaCodecInfo) {
        if (xp.f65027a >= 29) {
            return d(mediaCodecInfo);
        }
        return !e(mediaCodecInfo);
    }

    public static int b() {
        if (f61409c == -1) {
            int iMax = 0;
            jd jdVarA = a("video/avc", false, false);
            if (jdVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = jdVarA.a();
                int length = codecProfileLevelArrA.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(c(codecProfileLevelArrA[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, xp.f65027a >= 21 ? 345600 : 172800);
            }
            f61409c = iMax;
        }
        return f61409c;
    }

    public static Pair a(e9 e9Var) {
        String str = e9Var.f59391j;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(e9Var.f59394m)) {
            return c(e9Var.f59391j, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.getClass();
        switch (str2) {
            case "av01":
                return a(e9Var.f59391j, strArrSplit, e9Var.f59406y);
            case "avc1":
            case "avc2":
                return b(e9Var.f59391j, strArrSplit);
            case "hev1":
            case "hvc1":
                return d(e9Var.f59391j, strArrSplit);
            case "mp4a":
                return a(e9Var.f59391j, strArrSplit);
            case "vp09":
                return e(e9Var.f59391j, strArrSplit);
            default:
                return null;
        }
    }

    public static jd a(String str, boolean z2, boolean z3) {
        List listB = b(str, z2, z3);
        if (listB.isEmpty()) {
            return null;
        }
        return (jd) listB.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[PHI: r16
      0x008d: PHI (r16v9 boolean) = (r16v5 boolean), (r16v11 boolean) binds: [B:43:0x009d, B:35:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc A[Catch: Exception -> 0x0146, TRY_ENTER, TryCatch #4 {Exception -> 0x0146, blocks: (B:3:0x0008, B:5:0x001b, B:70:0x011b, B:8:0x002b, B:11:0x0036, B:64:0x00f4, B:67:0x00fc, B:69:0x0102, B:71:0x0123, B:72:0x0144), top: B:85:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList a(com.applovin.impl.md.b r19, com.applovin.impl.md.d r20) throws com.applovin.impl.md.c {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.md.a(com.applovin.impl.md$b, com.applovin.impl.md$d):java.util.ArrayList");
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i3 = xp.f65027a;
        if (i3 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i3 < 18 && CbYNFSEGaQj.TshVsg.equals(str)) {
            String str3 = xp.f65028b;
            if ("a70".equals(str3) || ("Xiaomi".equals(xp.f65029c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = xp.f65028b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i3 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = xp.f65028b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i3 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(xp.f65029c))) {
            String str6 = xp.f65028b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i3 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(xp.f65029c)) {
            String str7 = xp.f65028b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i3 <= 19 && xp.f65028b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(jd jdVar) {
        String str = jdVar.f60691a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (xp.f65027a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(e9 e9Var, jd jdVar) {
        try {
            return jdVar.b(e9Var) ? 1 : 0;
        } catch (c unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(g gVar, Object obj, Object obj2) {
        return gVar.a(obj2) - gVar.a(obj);
    }

    private static void a(List list, final g gVar) {
        Collections.sort(list, new Comparator() { // from class: com.applovin.impl.pz
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return md.a(gVar, obj, obj2);
            }
        });
    }

    public static jd a() {
        return a("audio/raw", false, false);
    }

    public static List a(List list, final e9 e9Var) {
        ArrayList arrayList = new ArrayList(list);
        a(arrayList, new g() { // from class: com.applovin.impl.sz
            @Override // com.applovin.impl.md.g
            public final int a(Object obj) {
                return md.a(e9Var, (jd) obj);
            }
        });
        return arrayList;
    }

    private static void a(String str, List list) {
        if ("audio/raw".equals(str)) {
            if (xp.f65027a < 26 && xp.f65028b.equals("R9") && list.size() == 1 && ((jd) list.get(0)).f60691a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(jd.a("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            a(list, new g() { // from class: com.applovin.impl.qz
                @Override // com.applovin.impl.md.g
                public final int a(Object obj) {
                    return md.a((jd) obj);
                }
            });
        }
        int i3 = xp.f65027a;
        if (i3 < 21 && list.size() > 1) {
            String str2 = ((jd) list.get(0)).f60691a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                a(list, new g() { // from class: com.applovin.impl.rz
                    @Override // com.applovin.impl.md.g
                    public final int a(Object obj) {
                        return md.b((jd) obj);
                    }
                });
            }
        }
        if (i3 >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((jd) list.get(0)).f60691a)) {
            return;
        }
        list.add((jd) list.remove(0));
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo) {
        return xp.f65027a >= 29 && b(mediaCodecInfo);
    }
}
