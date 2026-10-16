package com.applovin.impl;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f60693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f60694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f60695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f60696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f60697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f60698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f60699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f60700j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f60701k;

    jd(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f60691a = (String) b1.a((Object) str);
        this.f60692b = str2;
        this.f60693c = str3;
        this.f60694d = codecCapabilities;
        this.f60698h = z2;
        this.f60699i = z3;
        this.f60700j = z4;
        this.f60695e = z5;
        this.f60696f = z6;
        this.f60697g = z7;
        this.f60701k = hf.i(str2);
    }

    private static int a(String str, String str2, int i3) {
        if (i3 > 1 || ((xp.f65027a >= 26 && i3 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i3;
        }
        int i4 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        oc.d("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i3 + " to " + i4 + "]");
        return i4;
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f65027a >= 21 && e(codecCapabilities);
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f65027a >= 21 && g(codecCapabilities);
    }

    private static boolean g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public boolean b(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f60694d;
        if (codecCapabilities == null) {
            b("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            b("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i3)) {
            return true;
        }
        b("sampleRate.support, " + i3);
        return false;
    }

    public String toString() {
        return this.f60691a;
    }

    private static boolean d(String str) {
        return xp.f65030d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean e(String str) {
        if (xp.f65027a > 22) {
            return false;
        }
        String str2 = xp.f65030d;
        if ("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static final boolean f(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(xp.f65028b)) ? false : true;
    }

    public boolean c(e9 e9Var) {
        if (this.f60701k) {
            return this.f60695e;
        }
        Pair pairA = md.a(e9Var);
        return pairA != null && ((Integer) pairA.first).intValue() == 42;
    }

    private static boolean c(String str) {
        return "audio/opus".equals(str);
    }

    public boolean b(e9 e9Var) {
        int i3;
        int i4;
        int i5;
        if (!a(e9Var)) {
            return false;
        }
        if (!this.f60701k) {
            return xp.f65027a < 21 || (((i3 = e9Var.A) == -1 || b(i3)) && ((i4 = e9Var.f59407z) == -1 || a(i4)));
        }
        int i6 = e9Var.f59399r;
        if (i6 <= 0 || (i5 = e9Var.f59400s) <= 0) {
            return true;
        }
        if (xp.f65027a >= 21) {
            return a(i6, i5, e9Var.f59401t);
        }
        boolean z2 = i6 * i5 <= md.b();
        if (!z2) {
            b("legacyFrameSize, " + e9Var.f59399r + "x" + e9Var.f59400s);
        }
        return z2;
    }

    public Point a(int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f60694d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return a(videoCapabilities, i3, i4);
    }

    public boolean b() {
        if (xp.f65027a >= 29 && "video/x-vnd.on2.vp9".equals(this.f60692b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(xp.a(i3, widthAlignment) * widthAlignment, xp.a(i4, heightAlignment) * heightAlignment);
    }

    private void b(String str) {
        oc.a("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f60691a + ", " + this.f60692b + "] [" + xp.f65031e + "]");
    }

    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return xp.f65027a >= 19 && c(codecCapabilities);
    }

    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4, double d3) {
        Point pointA = a(videoCapabilities, i3, i4);
        int i5 = pointA.x;
        int i6 = pointA.y;
        if (d3 != -1.0d && d3 >= 1.0d) {
            return videoCapabilities.areSizeAndRateSupported(i5, i6, Math.floor(d3));
        }
        return videoCapabilities.isSizeSupported(i5, i6);
    }

    public p5 a(e9 e9Var, e9 e9Var2) {
        e9 e9Var3;
        e9 e9Var4;
        int i3 = !xp.a((Object) e9Var.f59394m, (Object) e9Var2.f59394m) ? 8 : 0;
        if (this.f60701k) {
            if (e9Var.f59402u != e9Var2.f59402u) {
                i3 |= 1024;
            }
            if (!this.f60695e && (e9Var.f59399r != e9Var2.f59399r || e9Var.f59400s != e9Var2.f59400s)) {
                i3 |= 512;
            }
            if (!xp.a(e9Var.f59406y, e9Var2.f59406y)) {
                i3 |= 2048;
            }
            if (d(this.f60691a) && !e9Var.a(e9Var2)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new p5(this.f60691a, e9Var, e9Var2, e9Var.a(e9Var2) ? 3 : 2, 0);
            }
            e9Var3 = e9Var;
            e9Var4 = e9Var2;
        } else {
            e9Var3 = e9Var;
            e9Var4 = e9Var2;
            if (e9Var3.f59407z != e9Var4.f59407z) {
                i3 |= 4096;
            }
            if (e9Var3.A != e9Var4.A) {
                i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            if (e9Var3.B != e9Var4.B) {
                i3 |= 16384;
            }
            if (i3 == 0 && "audio/mp4a-latm".equals(this.f60692b)) {
                Pair pairA = md.a(e9Var3);
                Pair pairA2 = md.a(e9Var4);
                if (pairA != null && pairA2 != null) {
                    int iIntValue = ((Integer) pairA.first).intValue();
                    int iIntValue2 = ((Integer) pairA2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new p5(this.f60691a, e9Var3, e9Var4, 3, 0);
                    }
                }
            }
            if (!e9Var3.a(e9Var4)) {
                i3 |= 32;
            }
            if (c(this.f60692b)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new p5(this.f60691a, e9Var3, e9Var4, 1, 0);
            }
        }
        return new p5(this.f60691a, e9Var3, e9Var4, 0, i3);
    }

    private static MediaCodecInfo.CodecProfileLevel[] a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i3 = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? Function.MAX_NARGS : iIntValue >= 30000000 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i3;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f60694d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean a(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f60694d;
        if (codecCapabilities == null) {
            b("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            b("channelCount.aCaps");
            return false;
        }
        if (a(this.f60691a, this.f60692b, audioCapabilities.getMaxInputChannelCount()) >= i3) {
            return true;
        }
        b("channelCount.support, " + i3);
        return false;
    }

    public boolean a(e9 e9Var) {
        String strB;
        String str = e9Var.f59391j;
        if (str == null || this.f60692b == null || (strB = hf.b(str)) == null) {
            return true;
        }
        if (!this.f60692b.equals(strB)) {
            b("codec.mime " + e9Var.f59391j + ", " + strB);
            return false;
        }
        Pair pairA = md.a(e9Var);
        if (pairA == null) {
            return true;
        }
        int iIntValue = ((Integer) pairA.first).intValue();
        int iIntValue2 = ((Integer) pairA.second).intValue();
        if (!this.f60701k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = a();
        if (xp.f65027a <= 23 && "video/x-vnd.on2.vp9".equals(this.f60692b) && codecProfileLevelArrA.length == 0) {
            codecProfileLevelArrA = a(this.f60694d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrA) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        b("codec.profileLevel, " + e9Var.f59391j + ", " + strB);
        return false;
    }

    public boolean a(int i3, int i4, double d3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f60694d;
        if (codecCapabilities == null) {
            b("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            b("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i3, i4, d3)) {
            return true;
        }
        if (i3 < i4 && f(this.f60691a) && a(videoCapabilities, i4, i3, d3)) {
            a("sizeAndRate.rotated, " + i3 + "x" + i4 + "x" + d3);
            return true;
        }
        b("sizeAndRate.support, " + i3 + "x" + i4 + "x" + d3);
        return false;
    }

    public static jd a(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        String str4;
        String str5;
        MediaCodecInfo.CodecCapabilities codecCapabilities2;
        boolean z8;
        boolean z9;
        boolean z10;
        String str6;
        boolean z11 = (z5 || codecCapabilities == null || !b(codecCapabilities) || e(str)) ? false : true;
        boolean z12 = codecCapabilities != null && f(codecCapabilities);
        if (z6 || (codecCapabilities != null && d(codecCapabilities))) {
            z7 = true;
            str4 = str;
            str5 = str3;
            codecCapabilities2 = codecCapabilities;
            z8 = z2;
            z9 = z3;
            z10 = z4;
            str6 = str2;
        } else {
            z7 = false;
            str6 = str2;
            str5 = str3;
            codecCapabilities2 = codecCapabilities;
            z8 = z2;
            z9 = z3;
            z10 = z4;
            str4 = str;
        }
        return new jd(str4, str6, str5, codecCapabilities2, z8, z9, z10, z11, z12, z7);
    }

    private void a(String str) {
        oc.a("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f60691a + ", " + this.f60692b + "] [" + xp.f65031e + "]");
    }
}
