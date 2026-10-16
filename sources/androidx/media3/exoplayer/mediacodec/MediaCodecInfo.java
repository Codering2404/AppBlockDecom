package androidx.media3.exoplayer.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class MediaCodecInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f44267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f44268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f44269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f44270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f44271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f44272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f44273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f44274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f44275l;

    MediaCodecInfo(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f44264a = (String) Assertions.e(str);
        this.f44265b = str2;
        this.f44266c = str3;
        this.f44267d = codecCapabilities;
        this.f44271h = z2;
        this.f44272i = z3;
        this.f44273j = z4;
        this.f44268e = z5;
        this.f44269f = z6;
        this.f44270g = z7;
        this.f44274k = z8;
        this.f44275l = MimeTypes.q(str2);
    }

    private static boolean A(String str) {
        if (Util.f41609a > 22) {
            return false;
        }
        String str2 = Build.MODEL;
        if ("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static boolean B(String str, int i3) {
        if (!"video/hevc".equals(str) || 2 != i3) {
            return false;
        }
        String str2 = Build.DEVICE;
        return "sailfish".equals(str2) || "marlin".equals(str2);
    }

    private static boolean C(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(Build.DEVICE)) ? false : true;
    }

    public static MediaCodecInfo D(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z2, z3, z4, (z5 || codecCapabilities == null || !h(codecCapabilities) || A(str)) ? false : true, codecCapabilities != null && t(codecCapabilities), z6 || (codecCapabilities != null && s(codecCapabilities)), m(codecCapabilities));
    }

    private static int a(String str, String str2, int i3) {
        if (i3 > 1 || ((Util.f41609a >= 26 && i3 > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i3;
        }
        int i4 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        Log.i("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i3 + " to " + i4 + "]");
        return i4;
    }

    private static Point b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.m(i3, widthAlignment) * widthAlignment, Util.m(i4, heightAlignment) * heightAlignment);
    }

    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i3, int i4, double d3) {
        Point pointB = b(videoCapabilities, i3, i4);
        int i5 = pointB.x;
        int i6 = pointB.y;
        return (d3 == -1.0d || d3 < 1.0d) ? videoCapabilities.isSizeSupported(i5, i6) : videoCapabilities.areSizeAndRateSupported(i5, i6, Math.floor(d3));
    }

    private static MediaCodecInfo.CodecProfileLevel[] f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i3 = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? Function.MAX_NARGS : iIntValue >= 30000000 ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i3;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    private static boolean h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean k(Format format, boolean z2) {
        Pair pairJ = MediaCodecUtil.j(format);
        String str = format.f40632o;
        if (str != null && str.equals("video/mv-hevc")) {
            String strR = MimeTypes.r(this.f44266c);
            if (strR.equals("video/mv-hevc")) {
                return true;
            }
            if (strR.equals("video/hevc")) {
                pairJ = MediaCodecUtil.s(format);
            }
        }
        if (pairJ == null) {
            return true;
        }
        int iIntValue = ((Integer) pairJ.first).intValue();
        int iIntValue2 = ((Integer) pairJ.second).intValue();
        if ("video/dolby-vision".equals(format.f40632o)) {
            String str2 = this.f44265b;
            str2.getClass();
            switch (str2) {
                case "video/av01":
                case "video/hevc":
                    iIntValue2 = 0;
                    iIntValue = 2;
                    break;
                case "video/avc":
                    iIntValue = 8;
                    iIntValue2 = 0;
                    break;
            }
        }
        if (!this.f44275l && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrG = g();
        if (Util.f41609a <= 23 && "video/x-vnd.on2.vp9".equals(this.f44265b) && codecProfileLevelArrG.length == 0) {
            codecProfileLevelArrG = f(this.f44267d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrG) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z2) && !B(this.f44265b, iIntValue))) {
                return true;
            }
        }
        w("codec.profileLevel, " + format.f40628k + ", " + this.f44266c);
        return false;
    }

    private boolean l(Format format) {
        return (Objects.equals(format.f40632o, "audio/flac") && format.G == 22 && Util.f41609a < 34 && this.f44264a.equals("c2.android.flac.decoder")) ? false : true;
    }

    private boolean q(Format format) {
        return this.f44265b.equals(format.f40632o) || this.f44265b.equals(MediaCodecUtil.g(format));
    }

    private static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void v(String str) {
        Log.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.f44264a + ", " + this.f44265b + "] [" + Util.f41613e + "]");
    }

    private void w(String str) {
        Log.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.f44264a + ", " + this.f44265b + "] [" + Util.f41613e + "]");
    }

    private static boolean x(String str) {
        return "audio/opus".equals(str);
    }

    private static boolean y(String str) {
        return Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean z() {
        String str = Build.MANUFACTURER;
        return str.equals("Xiaomi") || str.equals("OPPO");
    }

    public Point c(int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f44267d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return b(videoCapabilities, i3, i4);
    }

    public DecoderReuseEvaluation e(Format format, Format format2) {
        Format format3;
        Format format4;
        int i3 = !Objects.equals(format.f40632o, format2.f40632o) ? 8 : 0;
        if (this.f44275l) {
            if (format.f40642y != format2.f40642y) {
                i3 |= 1024;
            }
            if (!this.f44268e && (format.f40639v != format2.f40639v || format.f40640w != format2.f40640w)) {
                i3 |= 512;
            }
            if ((!ColorInfo.k(format.C) || !ColorInfo.k(format2.C)) && !Objects.equals(format.C, format2.C)) {
                i3 |= 2048;
            }
            if (y(this.f44264a) && !format.f(format2)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new DecoderReuseEvaluation(this.f44264a, format, format2, format.f(format2) ? 3 : 2, 0);
            }
            format3 = format;
            format4 = format2;
        } else {
            format3 = format;
            format4 = format2;
            if (format3.E != format4.E) {
                i3 |= 4096;
            }
            if (format3.F != format4.F) {
                i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            if (format3.G != format4.G) {
                i3 |= 16384;
            }
            if (i3 == 0 && "audio/mp4a-latm".equals(this.f44265b)) {
                Pair pairJ = MediaCodecUtil.j(format3);
                Pair pairJ2 = MediaCodecUtil.j(format4);
                if (pairJ != null && pairJ2 != null) {
                    int iIntValue = ((Integer) pairJ.first).intValue();
                    int iIntValue2 = ((Integer) pairJ2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f44264a, format3, format4, 3, 0);
                    }
                }
            }
            if (!format3.f(format4)) {
                i3 |= 32;
            }
            if (x(this.f44265b)) {
                i3 |= 2;
            }
            if (i3 == 0) {
                return new DecoderReuseEvaluation(this.f44264a, format3, format4, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f44264a, format3, format4, 0, i3);
    }

    public MediaCodecInfo.CodecProfileLevel[] g() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f44267d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean i(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f44267d;
        if (codecCapabilities == null) {
            w("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("channelCount.aCaps");
            return false;
        }
        if (a(this.f44264a, this.f44265b, audioCapabilities.getMaxInputChannelCount()) >= i3) {
            return true;
        }
        w("channelCount.support, " + i3);
        return false;
    }

    public boolean j(int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f44267d;
        if (codecCapabilities == null) {
            w("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            w("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i3)) {
            return true;
        }
        w("sampleRate.support, " + i3);
        return false;
    }

    public boolean n(Format format) {
        return q(format) && k(format, false) && l(format);
    }

    public boolean o(Format format) {
        int i3;
        int i4;
        if (!q(format) || !k(format, true) || !l(format)) {
            return false;
        }
        if (!this.f44275l) {
            int i5 = format.F;
            return (i5 == -1 || j(i5)) && ((i3 = format.E) == -1 || i(i3));
        }
        int i6 = format.f40639v;
        if (i6 <= 0 || (i4 = format.f40640w) <= 0) {
            return true;
        }
        return u(i6, i4, format.f40641x);
    }

    public boolean p() {
        if (Util.f41609a >= 29 && "video/x-vnd.on2.vp9".equals(this.f44265b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean r(Format format) {
        if (this.f44275l) {
            return this.f44268e;
        }
        Pair pairJ = MediaCodecUtil.j(format);
        return pairJ != null && ((Integer) pairJ.first).intValue() == 42;
    }

    public String toString() {
        return this.f44264a;
    }

    public boolean u(int i3, int i4, double d3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f44267d;
        if (codecCapabilities == null) {
            w("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            w("sizeAndRate.vCaps");
            return false;
        }
        if (Util.f41609a >= 29) {
            int iC = MediaCodecPerformancePointCoverageProvider.c(videoCapabilities, i3, i4, d3);
            if (iC == 2) {
                return true;
            }
            if (iC == 1) {
                w("sizeAndRate.cover, " + i3 + "x" + i4 + "@" + d3);
                return false;
            }
        }
        if (!d(videoCapabilities, i3, i4, d3)) {
            if (i3 >= i4 || !C(this.f44264a) || !d(videoCapabilities, i4, i3, d3)) {
                w("sizeAndRate.support, " + i3 + "x" + i4 + "@" + d3);
                return false;
            }
            v("sizeAndRate.rotated, " + i3 + "x" + i4 + "@" + d3);
        }
        return true;
    }

    private static boolean m(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f41609a >= 35 && codecCapabilities != null && codecCapabilities.isFeatureSupported(CbYNFSEGaQj.yAjxcyAbO) && !z();
    }
}
