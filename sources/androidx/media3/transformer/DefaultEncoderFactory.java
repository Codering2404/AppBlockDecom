package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.ExportException;
import androidx.media3.transformer.VideoEncoderSettings;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultEncoderFactory implements Codec.EncoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EncoderSelector f48078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VideoEncoderSettings f48079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioEncoderSettings f48080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f48081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f48082f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f48083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private EncoderSelector f48084b = EncoderSelector.f48139a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private VideoEncoderSettings f48085c = VideoEncoderSettings.f48597j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private AudioEncoderSettings f48086d = AudioEncoderSettings.f47902c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f48087e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f48088f = -2000;

        public Builder(Context context) {
            this.f48083a = context.getApplicationContext();
        }

        public DefaultEncoderFactory g() {
            return new DefaultEncoderFactory(this);
        }

        public Builder h(AudioEncoderSettings audioEncoderSettings) {
            this.f48086d = audioEncoderSettings;
            return this;
        }

        public Builder i(VideoEncoderSettings videoEncoderSettings) {
            this.f48085c = videoEncoderSettings;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface EncoderFallbackCost {
        int a(MediaCodecInfo mediaCodecInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EncoderQueryResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodecInfo f48089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Format f48090b;

        public EncoderQueryResult(MediaCodecInfo mediaCodecInfo, Format format) {
            this.f48089a = mediaCodecInfo;
            this.f48090b = format;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class VideoEncoderQueryResult extends EncoderQueryResult {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final VideoEncoderSettings f48091c;

        public VideoEncoderQueryResult(MediaCodecInfo mediaCodecInfo, Format format, VideoEncoderSettings videoEncoderSettings) {
            super(mediaCodecInfo, format);
            this.f48091c = videoEncoderSettings;
        }
    }

    private static int A(int i3, int i4, float f3) {
        return (int) (((double) (i3 * i4 * f3)) * 0.07d * 2.0d);
    }

    public static /* synthetic */ int e(String str, int i3, MediaCodecInfo mediaCodecInfo) {
        if (EncoderUtil.k(mediaCodecInfo, str, i3)) {
            return 0;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static /* synthetic */ int f(String str, ColorInfo colorInfo, MediaCodecInfo mediaCodecInfo) {
        if (EncoderUtil.n(mediaCodecInfo, str, (ColorInfo) Assertions.e(colorInfo))) {
            return 0;
        }
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static /* synthetic */ int g(String str, int i3, int i4, MediaCodecInfo mediaCodecInfo) {
        Size sizeJ = EncoderUtil.j(mediaCodecInfo, str, i3, i4);
        return sizeJ == null ? Api.BaseClientBuilder.API_PRIORITY_OTHER : Math.abs((i3 * i4) - (sizeJ.getWidth() * sizeJ.getHeight()));
    }

    private static void j(MediaFormat mediaFormat) {
        int i3 = Util.f41609a;
        if (i3 < 25) {
            return;
        }
        mediaFormat.setInteger("priority", 1);
        if (i3 == 26) {
            mediaFormat.setInteger("operating-rate", 30);
        } else if (q()) {
            mediaFormat.setInteger("operating-rate", 1000);
        } else {
            mediaFormat.setInteger("operating-rate", Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void k(ColorInfo colorInfo, MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) {
        int i3 = Util.f41609a;
        int iIntValue = 8;
        if (i3 >= 29) {
            if (colorInfo != null) {
                ImmutableList immutableListE = EncoderUtil.e("video/avc", colorInfo.f40556c);
                if (!immutableListE.isEmpty()) {
                    iIntValue = ((Integer) immutableListE.get(0)).intValue();
                }
            }
            int iB = EncoderUtil.b(mediaCodecInfo, "video/avc", iIntValue);
            if (iB != -1) {
                mediaFormat.setInteger("profile", iIntValue);
                if (mediaFormat.containsKey(AppLovinEventTypes.USER_COMPLETED_LEVEL)) {
                    return;
                }
                mediaFormat.setInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL, iB);
                return;
            }
            return;
        }
        if (i3 >= 26 && !r()) {
            int iB2 = EncoderUtil.b(mediaCodecInfo, "video/avc", 8);
            if (iB2 != -1) {
                mediaFormat.setInteger("profile", 8);
                if (!mediaFormat.containsKey(AppLovinEventTypes.USER_COMPLETED_LEVEL)) {
                    mediaFormat.setInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL, iB2);
                }
                mediaFormat.setInteger("latency", 1);
                return;
            }
            return;
        }
        if (i3 >= 24) {
            int iB3 = EncoderUtil.b(mediaCodecInfo, "video/avc", 1);
            Assertions.g(iB3 != -1);
            mediaFormat.setInteger("profile", 1);
            if (mediaFormat.containsKey(AppLovinEventTypes.USER_COMPLETED_LEVEL)) {
                return;
            }
            mediaFormat.setInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL, iB3);
        }
    }

    private static ExportException l(Format format, String str) {
        return ExportException.c(new IllegalArgumentException(str), 4003, new ExportException.CodecInfo(format.toString(), MimeTypes.q(format.f40632o), false, null));
    }

    private static ExportException o(Format format, boolean z2) {
        String str = "No MIME type is supported by both encoder and muxer.";
        if (z2 && ColorInfo.l(format.C)) {
            str = "No MIME type is supported by both encoder and muxer. Requested HDR colorInfo: " + format.C;
        }
        return ExportException.c(new IllegalArgumentException(str), 4003, new ExportException.CodecInfo(format.toString(), z2, false, null));
    }

    private static boolean p() {
        return Util.f41609a < 30 && Build.DEVICE.equals("joyeuse");
    }

    private static boolean q() {
        int i3 = Util.f41609a;
        if (i3 < 31 || i3 > 34) {
            return false;
        }
        return Build.SOC_MODEL.equals("SM8550") || Build.SOC_MODEL.equals("SM7450") || Build.SOC_MODEL.equals("SM6450") || Build.SOC_MODEL.equals("SC9863A") || Build.SOC_MODEL.equals("T612") || Build.SOC_MODEL.equals("T606") || Build.SOC_MODEL.equals("T603");
    }

    private static boolean r() {
        if (Util.f41609a != 27) {
            return false;
        }
        String str = Build.DEVICE;
        return str.equals("ASUS_X00T_3") || str.equals("TC77");
    }

    private static ImmutableList s(List list, EncoderFallbackCost encoderFallbackCost) {
        ArrayList arrayList = new ArrayList(list.size());
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < list.size(); i4++) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) list.get(i4);
            int iA = encoderFallbackCost.a(mediaCodecInfo);
            if (iA != Integer.MAX_VALUE) {
                if (iA < i3) {
                    arrayList.clear();
                    arrayList.add(mediaCodecInfo);
                    i3 = iA;
                } else if (iA == i3) {
                    arrayList.add(mediaCodecInfo);
                }
            }
        }
        return ImmutableList.t(arrayList);
    }

    private static ImmutableList t(List list, final String str, final int i3) {
        return s(list, new EncoderFallbackCost() { // from class: androidx.media3.transformer.f0
            @Override // androidx.media3.transformer.DefaultEncoderFactory.EncoderFallbackCost
            public final int a(MediaCodecInfo mediaCodecInfo) {
                String str2 = str;
                int i4 = i3;
                return Math.abs(((Integer) EncoderUtil.f(mediaCodecInfo, str2).clamp(Integer.valueOf(i4))).intValue() - i4);
            }
        });
    }

    private static ImmutableList u(List list, final String str, final int i3) {
        return s(list, new EncoderFallbackCost() { // from class: androidx.media3.transformer.g0
            @Override // androidx.media3.transformer.DefaultEncoderFactory.EncoderFallbackCost
            public final int a(MediaCodecInfo mediaCodecInfo) {
                return DefaultEncoderFactory.e(str, i3, mediaCodecInfo);
            }
        });
    }

    private static ImmutableList v(List list, final String str, final ColorInfo colorInfo) {
        return (Util.f41609a < 33 || !ColorInfo.l(colorInfo)) ? ImmutableList.t(list) : s(list, new EncoderFallbackCost() { // from class: androidx.media3.transformer.h0
            @Override // androidx.media3.transformer.DefaultEncoderFactory.EncoderFallbackCost
            public final int a(MediaCodecInfo mediaCodecInfo) {
                return DefaultEncoderFactory.f(str, colorInfo, mediaCodecInfo);
            }
        });
    }

    private static ImmutableList w(List list, final String str, final int i3, final int i4) {
        return s(list, new EncoderFallbackCost() { // from class: androidx.media3.transformer.i0
            @Override // androidx.media3.transformer.DefaultEncoderFactory.EncoderFallbackCost
            public final int a(MediaCodecInfo mediaCodecInfo) {
                return DefaultEncoderFactory.g(str, i3, i4, mediaCodecInfo);
            }
        });
    }

    private static ImmutableList x(List list, final String str, final int i3) {
        return s(list, new EncoderFallbackCost() { // from class: androidx.media3.transformer.e0
            @Override // androidx.media3.transformer.DefaultEncoderFactory.EncoderFallbackCost
            public final int a(MediaCodecInfo mediaCodecInfo) {
                String str2 = str;
                int i4 = i3;
                return Math.abs(EncoderUtil.d(mediaCodecInfo, str2, i4) - i4);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static EncoderQueryResult y(Format format, ImmutableList immutableList) {
        String str = (String) Assertions.e(format.f40632o);
        if (immutableList.isEmpty()) {
            return null;
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) x(immutableList, str, format.F).get(0);
        return new EncoderQueryResult(mediaCodecInfo, format.b().v0(EncoderUtil.d(mediaCodecInfo, str, format.F)).N());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static VideoEncoderQueryResult z(Format format, VideoEncoderSettings videoEncoderSettings, EncoderSelector encoderSelector, boolean z2) {
        int iA;
        int i3;
        String str = (String) Assertions.e(format.f40632o);
        ImmutableList immutableListB = encoderSelector.b(str);
        if (immutableListB.isEmpty()) {
            return null;
        }
        if (!z2) {
            return new VideoEncoderQueryResult((MediaCodecInfo) immutableListB.get(0), format, videoEncoderSettings);
        }
        ImmutableList immutableListV = v(immutableListB, str, format.C);
        if (immutableListV.isEmpty()) {
            return null;
        }
        ImmutableList immutableListW = w(immutableListV, str, format.f40639v, format.f40640w);
        if (immutableListW.isEmpty()) {
            return null;
        }
        Size size = (Size) Assertions.e(EncoderUtil.j((MediaCodecInfo) immutableListW.get(0), str, format.f40639v, format.f40640w));
        if (videoEncoderSettings.f48606i) {
            iA = -1;
        } else {
            iA = videoEncoderSettings.f48598a;
            if (iA == -1 && (iA = format.f40625h) == -1) {
                iA = A(size.getWidth(), size.getHeight(), format.f40641x);
            }
            immutableListW = t(immutableListW, str, iA);
            if (immutableListW.isEmpty()) {
                return null;
            }
        }
        ImmutableList immutableListU = u(immutableListW, str, videoEncoderSettings.f48599b);
        if (immutableListU.isEmpty()) {
            return null;
        }
        VideoEncoderSettings.Builder builderA = videoEncoderSettings.a();
        Format.Builder builderD0 = format.b().u0(str).B0(size.getWidth()).d0(size.getHeight());
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) immutableListU.get(0);
        if (videoEncoderSettings.f48606i) {
            iA = new DeviceMappedEncoderBitrateProvider().a(mediaCodecInfo.getName(), size.getWidth(), size.getHeight(), format.f40641x);
            builderA.b(false);
        }
        int iIntValue = ((Integer) EncoderUtil.f(mediaCodecInfo, str).clamp(Integer.valueOf(iA))).intValue();
        builderA.c(iIntValue);
        builderD0.Q(iIntValue);
        int i4 = videoEncoderSettings.f48600c;
        if (i4 == -1 || (i3 = videoEncoderSettings.f48601d) == -1 || i3 > EncoderUtil.b(mediaCodecInfo, str, i4)) {
            builderA.d(-1, -1);
        }
        return new VideoEncoderQueryResult(mediaCodecInfo, builderD0.N(), builderA.a());
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean a() {
        return !this.f48079c.equals(VideoEncoderSettings.f48597j);
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean d() {
        return !this.f48080d.equals(AudioEncoderSettings.f47902c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.transformer.Codec.EncoderFactory
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public DefaultCodec b(Format format) throws ExportException {
        EncoderQueryResult encoderQueryResultY;
        if (format.f40627j == -1) {
            format = format.b().Q(131072).N();
        }
        boolean z2 = false;
        if (format.f40632o == null) {
            throw o(format, false);
        }
        MediaFormat mediaFormatB = MediaFormatUtil.b(format);
        ImmutableList immutableListH = EncoderUtil.h(format.f40632o);
        if (immutableListH.isEmpty()) {
            throw l(format, "No audio media codec found");
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) immutableListH.get(0);
        if (this.f48080d.f47903a != -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= immutableListH.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) immutableListH.get(i3);
                if (EncoderUtil.c(mediaCodecInfo2, format.f40632o).contains(Integer.valueOf(this.f48080d.f47903a))) {
                    if (format.f40632o.equals("audio/mp4a-latm")) {
                        mediaFormatB.setInteger("aac-profile", this.f48080d.f47903a);
                    }
                    mediaFormatB.setInteger("profile", this.f48080d.f47903a);
                    z2 = true;
                    mediaCodecInfo = mediaCodecInfo2;
                } else {
                    i3++;
                }
            }
        }
        if (!z2 && this.f48081e && (encoderQueryResultY = y(format, immutableListH)) != null) {
            mediaCodecInfo = encoderQueryResultY.f48089a;
            format = encoderQueryResultY.f48090b;
            mediaFormatB = MediaFormatUtil.b(format);
        }
        Format format2 = format;
        MediaFormat mediaFormat = mediaFormatB;
        int i4 = this.f48080d.f47904b;
        if (i4 != -1) {
            mediaFormat.setInteger("bitrate", i4);
        }
        return new DefaultCodec(this.f48077a, format2, mediaFormat, mediaCodecInfo.getName(), false, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.transformer.Codec.EncoderFactory
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public DefaultCodec c(Format format) throws ExportException {
        int iA;
        if (format.f40641x == -1.0f || p()) {
            format = format.b().b0(30.0f).N();
        }
        if (format.f40632o == null) {
            throw o(format, true);
        }
        Assertions.a(format.f40639v != -1);
        Assertions.a(format.f40640w != -1);
        Assertions.a(format.f40642y == 0);
        Assertions.i(this.f48078b);
        VideoEncoderQueryResult videoEncoderQueryResultZ = z(format, this.f48079c, this.f48078b, this.f48081e);
        if (videoEncoderQueryResultZ == null) {
            throw l(format, "The requested video encoding format is not supported.");
        }
        MediaCodecInfo mediaCodecInfo = videoEncoderQueryResultZ.f48089a;
        Format format2 = videoEncoderQueryResultZ.f48090b;
        VideoEncoderSettings videoEncoderSettings = videoEncoderQueryResultZ.f48091c;
        String str = (String) Assertions.e(format2.f40632o);
        if (this.f48081e) {
            iA = videoEncoderSettings.f48598a;
        } else {
            iA = videoEncoderSettings.f48598a;
            if (iA == -1) {
                if (videoEncoderSettings.f48606i) {
                    iA = new DeviceMappedEncoderBitrateProvider().a(mediaCodecInfo.getName(), format2.f40639v, format2.f40640w, format2.f40641x);
                } else {
                    iA = format2.f40625h;
                    if (iA == -1) {
                        iA = A(format2.f40639v, format2.f40640w, format2.f40641x);
                    }
                }
            }
        }
        Format formatN = format2.b().Q(iA).N();
        MediaFormat mediaFormatB = MediaFormatUtil.b(formatN);
        mediaFormatB.setInteger("bitrate-mode", videoEncoderSettings.f48599b);
        mediaFormatB.setInteger("frame-rate", Math.round(formatN.f40641x));
        int i3 = videoEncoderSettings.f48600c;
        if (i3 != -1 && videoEncoderSettings.f48601d != -1 && Util.f41609a >= 24) {
            mediaFormatB.setInteger("profile", i3);
            mediaFormatB.setInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL, videoEncoderSettings.f48601d);
        } else if (Util.f41609a >= 24 && ColorInfo.l(format.C)) {
            mediaFormatB.setInteger("profile", ((Integer) EncoderUtil.e(str, ((ColorInfo) Assertions.e(format.C)).f40556c).get(0)).intValue());
        }
        if (str.equals("video/avc")) {
            k(format.C, mediaCodecInfo, mediaFormatB);
        }
        int i4 = Util.f41609a;
        if (i4 < 31 || !ColorInfo.l(format.C)) {
            mediaFormatB.setInteger("color-format", 2130708361);
        } else {
            if (!EncoderUtil.g(mediaCodecInfo, str).contains(2130750114)) {
                throw l(format, "Encoding HDR is not supported on this device.");
            }
            mediaFormatB.setInteger("color-format", 2130750114);
        }
        if (i4 >= 25) {
            mediaFormatB.setFloat("i-frame-interval", videoEncoderSettings.f48602e);
        } else {
            float f3 = videoEncoderSettings.f48602e;
            mediaFormatB.setInteger("i-frame-interval", (f3 <= 0.0f || f3 > 1.0f) ? (int) Math.floor(f3) : 1);
        }
        int i5 = videoEncoderSettings.f48603f;
        int i6 = videoEncoderSettings.f48604g;
        if (i4 >= 23) {
            if (i5 == -1 && i6 == -1) {
                j(mediaFormatB);
            } else {
                if (i5 != -2) {
                    mediaFormatB.setInteger("operating-rate", i5);
                }
                if (i6 != -2) {
                    mediaFormatB.setInteger("priority", i6);
                }
            }
        }
        long j3 = videoEncoderSettings.f48605h;
        if (j3 != -1) {
            mediaFormatB.setLong("repeat-previous-frame-after", j3);
        }
        if (i4 >= 35) {
            mediaFormatB.setInteger("importance", Math.max(0, -this.f48082f));
        }
        return new DefaultCodec(this.f48077a, formatN, mediaFormatB, mediaCodecInfo.getName(), false, null);
    }

    private DefaultEncoderFactory(Builder builder) {
        this.f48077a = builder.f48083a;
        this.f48078b = builder.f48084b;
        this.f48079c = builder.f48085c;
        this.f48080d = builder.f48086d;
        this.f48081e = builder.f48087e;
        this.f48082f = builder.f48088f;
    }
}
