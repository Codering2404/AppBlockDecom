package androidx.media3.common.util;

import android.media.MediaFormat;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaFormatUtil {
    public static Format a(MediaFormat mediaFormat) {
        int i3 = 0;
        Format.Builder builderO0 = new Format.Builder().u0(mediaFormat.getString("mime")).j0(mediaFormat.getString("language")).p0(g(mediaFormat, "max-bitrate", -1)).Q(g(mediaFormat, "bitrate", -1)).S(d(mediaFormat)).b0(f(mediaFormat, -1.0f)).B0(g(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1)).d0(g(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1)).q0(h(mediaFormat, 1.0f)).k0(g(mediaFormat, "max-input-size", -1)).t0(g(mediaFormat, "rotation-degrees", 0)).T(e(mediaFormat)).v0(g(mediaFormat, "sample-rate", -1)).R(g(mediaFormat, "channel-count", -1)).o0(g(mediaFormat, "pcm-encoding", -1));
        ImmutableList.Builder builder = new ImmutableList.Builder();
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-" + i3);
            if (byteBuffer == null) {
                break;
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.rewind();
            builder.a(bArr);
            i3++;
        }
        builderO0.g0(builder.m());
        if (mediaFormat.containsKey("track-id")) {
            builderO0.e0(mediaFormat.getInteger("track-id"));
        }
        return builderO0.N();
    }

    public static MediaFormat b(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        p(mediaFormat, "bitrate", format.f40627j);
        p(mediaFormat, "max-bitrate", format.f40626i);
        p(mediaFormat, "channel-count", format.E);
        n(mediaFormat, format.C);
        s(mediaFormat, "mime", format.f40632o);
        s(mediaFormat, "codecs-string", format.f40628k);
        o(mediaFormat, "frame-rate", format.f40641x);
        p(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, format.f40639v);
        p(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, format.f40640w);
        u(mediaFormat, format.f40635r);
        q(mediaFormat, format.G);
        s(mediaFormat, "language", format.f40621d);
        p(mediaFormat, "max-input-size", format.f40633p);
        p(mediaFormat, "sample-rate", format.F);
        p(mediaFormat, "caption-service-number", format.J);
        mediaFormat.setInteger("rotation-degrees", format.f40642y);
        int i3 = format.f40622e;
        t(mediaFormat, "is-autoselect", i3 & 4);
        t(mediaFormat, "is-default", i3 & 1);
        t(mediaFormat, "is-forced-subtitle", i3 & 2);
        mediaFormat.setInteger("encoder-delay", format.H);
        mediaFormat.setInteger("encoder-padding", format.I);
        r(mediaFormat, format.f40643z);
        String str = format.f40618a;
        if (str != null) {
            mediaFormat.setInteger("track-id", Integer.parseInt(str));
        }
        return mediaFormat;
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static String d(MediaFormat mediaFormat) {
        return (Objects.equals(mediaFormat.getString("mime"), "video/3gpp") && mediaFormat.containsKey("profile") && mediaFormat.containsKey(AppLovinEventTypes.USER_COMPLETED_LEVEL)) ? CodecSpecificDataUtil.f(mediaFormat.getInteger("profile"), mediaFormat.getInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL)) : i(mediaFormat, "codecs-string", null);
    }

    public static ColorInfo e(MediaFormat mediaFormat) {
        if (Util.f41609a < 24) {
            return null;
        }
        int iG = g(mediaFormat, "color-standard", -1);
        int iG2 = g(mediaFormat, "color-range", -1);
        int iG3 = g(mediaFormat, "color-transfer", -1);
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] bArrC = byteBuffer != null ? c(byteBuffer) : null;
        if (!k(iG)) {
            iG = -1;
        }
        if (!j(iG2)) {
            iG2 = -1;
        }
        if (!l(iG3)) {
            iG3 = -1;
        }
        if (iG == -1 && iG2 == -1 && iG3 == -1 && bArrC == null) {
            return null;
        }
        return new ColorInfo.Builder().d(iG).c(iG2).e(iG3).f(bArrC).a();
    }

    private static float f(MediaFormat mediaFormat, float f3) {
        if (!mediaFormat.containsKey("frame-rate")) {
            return f3;
        }
        try {
            return mediaFormat.getFloat("frame-rate");
        } catch (ClassCastException unused) {
            return mediaFormat.getInteger("frame-rate");
        }
    }

    public static int g(MediaFormat mediaFormat, String str, int i3) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i3;
    }

    private static float h(MediaFormat mediaFormat, float f3) {
        return (mediaFormat.containsKey("sar-width") && mediaFormat.containsKey("sar-height")) ? mediaFormat.getInteger("sar-width") / mediaFormat.getInteger("sar-height") : f3;
    }

    public static String i(MediaFormat mediaFormat, String str, String str2) {
        return mediaFormat.containsKey(str) ? mediaFormat.getString(str) : str2;
    }

    private static boolean j(int i3) {
        return i3 == 2 || i3 == 1 || i3 == -1;
    }

    private static boolean k(int i3) {
        return i3 == 2 || i3 == 1 || i3 == 6 || i3 == -1;
    }

    private static boolean l(int i3) {
        return i3 == 1 || i3 == 3 || i3 == 6 || i3 == 7 || i3 == -1;
    }

    public static void m(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void n(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            p(mediaFormat, "color-transfer", colorInfo.f40556c);
            p(mediaFormat, "color-standard", colorInfo.f40554a);
            p(mediaFormat, "color-range", colorInfo.f40555b);
            m(mediaFormat, "hdr-static-info", colorInfo.f40557d);
        }
    }

    public static void o(MediaFormat mediaFormat, String str, float f3) {
        if (f3 != -1.0f) {
            mediaFormat.setFloat(str, f3);
        }
    }

    public static void p(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }

    private static void q(MediaFormat mediaFormat, int i3) {
        int i4;
        if (i3 == -1) {
            return;
        }
        p(mediaFormat, "exo-pcm-encoding-int", i3);
        if (i3 != 0) {
            i4 = 2;
            if (i3 != 2) {
                i4 = 3;
                if (i3 != 3) {
                    i4 = 4;
                    if (i3 != 4) {
                        i4 = 21;
                        if (i3 != 21) {
                            i4 = 22;
                            if (i3 != 22) {
                                return;
                            }
                        }
                    }
                }
            }
        } else {
            i4 = 0;
        }
        mediaFormat.setInteger("pcm-encoding", i4);
    }

    private static void r(MediaFormat mediaFormat, float f3) {
        int i3;
        mediaFormat.setFloat("exo-pixel-width-height-ratio-float", f3);
        int i4 = 1073741824;
        if (f3 < 1.0f) {
            i4 = (int) (f3 * 1073741824);
            i3 = 1073741824;
        } else if (f3 > 1.0f) {
            i3 = (int) (1073741824 / f3);
        } else {
            i4 = 1;
            i3 = 1;
        }
        mediaFormat.setInteger("sar-width", i4);
        mediaFormat.setInteger("sar-height", i3);
    }

    public static void s(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    private static void t(MediaFormat mediaFormat, String str, int i3) {
        mediaFormat.setInteger(str, i3 != 0 ? 1 : 0);
    }

    public static void u(MediaFormat mediaFormat, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap((byte[]) list.get(i3)));
        }
    }
}
