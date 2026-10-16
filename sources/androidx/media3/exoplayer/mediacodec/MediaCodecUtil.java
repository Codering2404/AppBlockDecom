package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaCodecUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap f44324a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f44325b = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CodecKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f44326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f44327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f44328c;

        public CodecKey(String str, boolean z2, boolean z3) {
            this.f44326a = str;
            this.f44327b = z2;
            this.f44328c = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == CodecKey.class) {
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.f44326a, codecKey.f44326a) && this.f44327b == codecKey.f44327b && this.f44328c == codecKey.f44328c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f44326a.hashCode() + 31) * 31) + (this.f44327b ? 1231 : 1237)) * 31) + (this.f44328c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface MediaCodecListCompat {
        android.media.MediaCodecInfo a(int i3);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo a(int i3) {
            return MediaCodecList.getCodecInfoAt(i3);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean e() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f44329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private android.media.MediaCodecInfo[] f44330b;

        public MediaCodecListCompatV21(boolean z2, boolean z3, boolean z4) {
            this.f44329a = (z2 || z3 || z4) ? 1 : 0;
        }

        private void f() {
            if (this.f44330b == null) {
                this.f44330b = new MediaCodecList(this.f44329a).getCodecInfos();
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo a(int i3) {
            f();
            return this.f44330b[i3];
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int d() {
            f();
            return this.f44330b.length;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean e() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ScoreProvider<T> {
        int a(Object obj);
    }

    private static boolean A(android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util.f41609a >= 29) {
            return B(mediaCodecInfo);
        }
        String strE = Ascii.e(mediaCodecInfo.getName());
        return (strE.startsWith("omx.google.") || strE.startsWith("c2.android.") || strE.startsWith("c2.google.")) ? false : true;
    }

    private static boolean B(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    private static void C(List list, final ScoreProvider scoreProvider) {
        Collections.sort(list, new Comparator() { // from class: androidx.media3.exoplayer.mediacodec.z
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.a(scoreProvider, obj, obj2);
            }
        });
    }

    public static /* synthetic */ int a(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.a(obj2) - scoreProvider.a(obj);
    }

    public static /* synthetic */ int b(MediaCodecInfo mediaCodecInfo) {
        return (mediaCodecInfo.f44272i ? 2 : 0) + (!mediaCodecInfo.f44273j ? 1 : 0);
    }

    public static /* synthetic */ int c(Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.n(format) ? 1 : 0;
    }

    public static /* synthetic */ int d(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f44264a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util.f41609a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int e(Format format, MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.o(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    private static void f(String str, List list) {
        if ("audio/raw".equals(str)) {
            if (Util.f41609a < 26 && Build.DEVICE.equals("R9") && list.size() == 1 && ((MediaCodecInfo) list.get(0)).f44264a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.D("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            C(list, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.x
                @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
                public final int a(Object obj) {
                    return MediaCodecUtil.d((MediaCodecInfo) obj);
                }
            });
        }
        if (Util.f41609a >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((MediaCodecInfo) list.get(0)).f44264a)) {
            return;
        }
        list.add((MediaCodecInfo) list.remove(0));
    }

    public static String g(Format format) {
        Pair pairJ;
        if ("audio/eac3-joc".equals(format.f40632o)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(format.f40632o) && (pairJ = j(format)) != null) {
            int iIntValue = ((Integer) pairJ.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(format.f40632o)) {
            return "video/hevc";
        }
        return null;
    }

    public static List h(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) {
        String strG = g(format);
        return strG == null ? ImmutableList.y() : mediaCodecSelector.b(strG, z2, z3);
    }

    private static String i(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
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
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static Pair j(Format format) {
        return CodecSpecificDataUtil.o(format);
    }

    public static MediaCodecInfo k(String str, boolean z2, boolean z3) {
        List listL = l(str, z2, z3);
        if (listL.isEmpty()) {
            return null;
        }
        return (MediaCodecInfo) listL.get(0);
    }

    public static synchronized List l(String str, boolean z2, boolean z3) {
        try {
            CodecKey codecKey = new CodecKey(str, z2, z3);
            HashMap map = f44324a;
            List list = (List) map.get(codecKey);
            if (list != null) {
                return list;
            }
            ArrayList arrayListM = m(codecKey, new MediaCodecListCompatV21(z2, z3, str.equals("video/mv-hevc")));
            if (z2 && arrayListM.isEmpty() && Util.f41609a <= 23) {
                arrayListM = m(codecKey, new MediaCodecListCompatV16());
                if (!arrayListM.isEmpty()) {
                    Log.i("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((MediaCodecInfo) arrayListM.get(0)).f44264a);
                }
            }
            f(str, arrayListM);
            ImmutableList immutableListT = ImmutableList.t(arrayListM);
            map.put(codecKey, immutableListT);
            return immutableListT;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b A[PHI: r16
      0x008b: PHI (r16v9 boolean) = (r16v5 boolean), (r16v11 boolean) binds: [B:41:0x009b, B:33:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fa A[Catch: Exception -> 0x0144, TRY_ENTER, TryCatch #4 {Exception -> 0x0144, blocks: (B:3:0x0008, B:5:0x001b, B:68:0x0119, B:8:0x002b, B:11:0x0036, B:62:0x00f2, B:65:0x00fa, B:67:0x0100, B:69:0x0121, B:70:0x0142), top: B:83:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList m(androidx.media3.exoplayer.mediacodec.MediaCodecUtil.CodecKey r19, androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat r20) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.m(androidx.media3.exoplayer.mediacodec.MediaCodecUtil$CodecKey, androidx.media3.exoplayer.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    public static List n(MediaCodecSelector mediaCodecSelector, Format format, boolean z2, boolean z3) {
        List listB = mediaCodecSelector.b(format.f40632o, z2, z3);
        return ImmutableList.o().k(listB).k(h(mediaCodecSelector, format, z2, z3)).m();
    }

    public static List o(List list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        C(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.y
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int a(Object obj) {
                return MediaCodecUtil.c(format, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    public static List p(List list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        C(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.w
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int a(Object obj) {
                return MediaCodecUtil.e(format, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    public static List q(List list) {
        ArrayList arrayList = new ArrayList(list);
        C(arrayList, new ScoreProvider() { // from class: androidx.media3.exoplayer.mediacodec.a0
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.ScoreProvider
            public final int a(Object obj) {
                return MediaCodecUtil.b((MediaCodecInfo) obj);
            }
        });
        return ImmutableList.t(arrayList);
    }

    public static MediaCodecInfo r() {
        return k("audio/raw", false, false);
    }

    public static Pair s(Format format) {
        String strH = NalUnitUtil.h(format.f40635r);
        if (strH == null) {
            return null;
        }
        return CodecSpecificDataUtil.r(strH, Util.h1(strH.trim(), "\\."), format.C);
    }

    private static boolean t(android.media.MediaCodecInfo mediaCodecInfo) {
        return Util.f41609a >= 29 && u(mediaCodecInfo);
    }

    private static boolean u(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean v(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i3 = Util.f41609a;
        if (i3 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Build.MANUFACTURER))) {
            String str3 = Build.DEVICE;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        return (i3 <= 23 && "audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean w(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        return Util.f41609a >= 29 ? x(mediaCodecInfo) : !y(mediaCodecInfo, str);
    }

    private static boolean x(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean y(android.media.MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f41609a >= 29) {
            return z(mediaCodecInfo);
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

    private static boolean z(android.media.MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }
}
