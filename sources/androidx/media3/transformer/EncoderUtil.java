package androidx.media3.transformer;

import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import android.util.Size;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Ascii;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EncoderUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayListMultimap f48140a = ArrayListMultimap.F();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        public static boolean a(MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.isHardwareAccelerated();
        }

        public static boolean b(MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.isSoftwareOnly();
        }
    }

    private static int a(int i3, int i4) {
        return i3 % 10 == 1 ? (int) (((double) i4) * Math.floor(i3 / i4)) : i4 * Math.round(i3 / i4);
    }

    public static int b(MediaCodecInfo mediaCodecInfo, String str, int i3) {
        int iMax = -1;
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
            if (codecProfileLevel.profile == i3) {
                iMax = Math.max(iMax, codecProfileLevel.level);
            }
        }
        return iMax;
    }

    public static ImmutableSet c(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.getCapabilitiesForType(str).profileLevels;
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            builder.e(Integer.valueOf(codecProfileLevel.profile));
        }
        return builder.n();
    }

    public static int d(MediaCodecInfo mediaCodecInfo, String str, int i3) {
        MediaCodecInfo.AudioCapabilities audioCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getAudioCapabilities();
        int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
        int i4 = 0;
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (supportedSampleRates != null) {
            int length = supportedSampleRates.length;
            while (i4 < length) {
                int i6 = supportedSampleRates[i4];
                if (Math.abs(i6 - i3) < Math.abs(i5 - i3)) {
                    i5 = i6;
                }
                i4++;
            }
            return i5;
        }
        Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
        int length2 = supportedSampleRateRanges.length;
        while (i4 < length2) {
            int iIntValue = ((Integer) supportedSampleRateRanges[i4].clamp(Integer.valueOf(i3))).intValue();
            if (Math.abs(iIntValue - i3) < Math.abs(i5 - i3)) {
                i5 = iIntValue;
            }
            i4++;
        }
        return i5;
    }

    public static ImmutableList e(String str, int i3) {
        str.getClass();
        switch (str) {
            case "video/dolby-vision":
                if (i3 == 7) {
                    return ImmutableList.z(Integer.valueOf(Function.MAX_NARGS));
                }
                break;
            case "video/av01":
                if (i3 == 7) {
                    return ImmutableList.z(2);
                }
                if (i3 == 6) {
                    return ImmutableList.z(4096);
                }
                break;
            case "video/hevc":
                if (i3 == 7) {
                    return ImmutableList.z(2);
                }
                if (i3 == 6) {
                    return ImmutableList.z(4096);
                }
                break;
            case "video/avc":
                if (i3 == 7) {
                    return ImmutableList.z(16);
                }
                break;
            case "video/x-vnd.on2.vp9":
                if (i3 == 7 || i3 == 6) {
                    return ImmutableList.A(4096, Integer.valueOf(Utility.DEFAULT_STREAM_BUFFER_SIZE));
                }
                break;
        }
        return ImmutableList.y();
    }

    public static Range f(MediaCodecInfo mediaCodecInfo, String str) {
        return mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange();
    }

    public static ImmutableList g(MediaCodecInfo mediaCodecInfo, String str) {
        return ImmutableList.t(Ints.c(mediaCodecInfo.getCapabilitiesForType(str).colorFormats));
    }

    public static synchronized ImmutableList h(String str) {
        q();
        return ImmutableList.t(f48140a.get((Object) Ascii.e(str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList i(String str, ColorInfo colorInfo) {
        if (Util.f41609a < 33 || colorInfo == null) {
            return ImmutableList.y();
        }
        ImmutableList immutableListH = h(str);
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i3 = 0; i3 < immutableListH.size(); i3++) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) immutableListH.get(i3);
            if (!mediaCodecInfo.isAlias() && n(mediaCodecInfo, str, colorInfo)) {
                builder.a(mediaCodecInfo);
            }
        }
        return builder.m();
    }

    public static Size j(MediaCodecInfo mediaCodecInfo, String str, int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int iA = a(i3, widthAlignment);
        int iA2 = a(i4, heightAlignment);
        if (o(mediaCodecInfo, str, iA, iA2)) {
            return new Size(iA, iA2);
        }
        float[] fArr = {0.95f, 0.9f, 0.85f, 0.8f, 0.75f, 0.7f, 0.6666667f, 0.6f, 0.55f, 0.5f, 0.4f, 0.33333334f, 0.25f};
        for (int i5 = 0; i5 < 13; i5++) {
            float f3 = fArr[i5];
            int iA3 = a(Math.round(i3 * f3), widthAlignment);
            int iA4 = a(Math.round(i4 * f3), heightAlignment);
            if (o(mediaCodecInfo, str, iA3, iA4)) {
                return new Size(iA3, iA4);
            }
        }
        int iIntValue = ((Integer) videoCapabilities.getSupportedHeightsFor(((Integer) videoCapabilities.getSupportedWidths().clamp(Integer.valueOf(i3))).intValue()).clamp(Integer.valueOf(i4))).intValue();
        if (iIntValue != i4) {
            i3 = a((int) Math.round((((double) i3) * ((double) iIntValue)) / ((double) i4)), widthAlignment);
            i4 = a(iIntValue, heightAlignment);
        }
        if (o(mediaCodecInfo, str, i3, i4)) {
            return new Size(i3, i4);
        }
        return null;
    }

    public static boolean k(MediaCodecInfo mediaCodecInfo, String str, int i3) {
        return mediaCodecInfo.getCapabilitiesForType(str).getEncoderCapabilities().isBitrateModeSupported(i3);
    }

    public static boolean l(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported(str2);
    }

    public static boolean m(MediaCodecInfo mediaCodecInfo, String str) {
        return Util.f41609a >= 29 ? Api29.a(mediaCodecInfo) : !p(mediaCodecInfo, str);
    }

    public static boolean n(MediaCodecInfo mediaCodecInfo, String str, ColorInfo colorInfo) {
        if (!str.equals("video/dolby-vision") && !l(mediaCodecInfo, str, "hdr-editing") && (colorInfo.f40556c != 7 || Util.f41609a < 35 || !l(mediaCodecInfo, str, "hlg-editing"))) {
            return false;
        }
        ImmutableList immutableListE = e(str, colorInfo.f40556c);
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
            if (immutableListE.contains(Integer.valueOf(codecProfileLevel.profile))) {
                return true;
            }
        }
        return false;
    }

    public static boolean o(MediaCodecInfo mediaCodecInfo, String str, int i3, int i4) {
        if (mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities().isSizeSupported(i3, i4)) {
            return true;
        }
        if (i3 == 1920 && i4 == 1080) {
            return CamcorderProfile.hasProfile(6);
        }
        if (i3 == 3840 && i4 == 2160) {
            return CamcorderProfile.hasProfile(8);
        }
        return false;
    }

    private static boolean p(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f41609a >= 29) {
            return Api29.b(mediaCodecInfo);
        }
        if (MimeTypes.n(str)) {
            return true;
        }
        String strE = Ascii.e(mediaCodecInfo.getName());
        if (strE.startsWith("arc.")) {
            return false;
        }
        return strE.startsWith("omx.google.") || strE.startsWith("omx.ffmpeg.") || (strE.startsWith("omx.sec.") && strE.contains(".sw.")) || strE.equals("omx.qcom.video.decoder.hevcswvdec") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.") || !(strE.startsWith("omx.") || strE.startsWith("c2."));
    }

    private static synchronized void q() {
        if (f48140a.isEmpty()) {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder()) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        f48140a.put(Ascii.e(str), mediaCodecInfo);
                    }
                }
            }
        }
    }
}
