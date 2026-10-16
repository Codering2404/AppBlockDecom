package androidx.media3.transformer;

import android.content.Context;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.GlEffect;
import androidx.media3.effect.ScaleAndRotateTransformation;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.transformer.Codec;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TransformerUtil {
    private static boolean a(Format format) {
        Metadata metadata = format.f40629l;
        if (metadata == null) {
            return false;
        }
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            if (metadata.d(i3) instanceof SlowMotionData) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String b(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case 96870:
                if (str.equals("arw")) {
                    b3 = 0;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    b3 = 1;
                }
                break;
            case 98723:
                if (str.equals("cr2")) {
                    b3 = 2;
                }
                break;
            case 99453:
                if (str.equals("dib")) {
                    b3 = 3;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    b3 = 4;
                }
                break;
            case 104085:
                if (str.equals("ico")) {
                    b3 = 5;
                }
                break;
            case 104430:
                if (str.equals("k25")) {
                    b3 = 6;
                }
                break;
            case 105133:
                if (str.equals("jfi")) {
                    b3 = 7;
                }
                break;
            case 105223:
                if (str.equals("jif")) {
                    b3 = 8;
                }
                break;
            case 105439:
                if (str.equals("jpe")) {
                    b3 = 9;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    b3 = 10;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    b3 = Ascii.VT;
                }
                break;
            case 112680:
                if (str.equals("raw")) {
                    b3 = Ascii.FF;
                }
                break;
            case 114276:
                if (str.equals("svg")) {
                    b3 = Ascii.CR;
                }
                break;
            case 114833:
                if (str.equals("tif")) {
                    b3 = Ascii.SO;
                }
                break;
            case 3006482:
                if (str.equals("avif")) {
                    b3 = Ascii.SI;
                }
                break;
            case 3198679:
                if (str.equals("heic")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 3198682:
                if (str.equals("heif")) {
                    b3 = 17;
                }
                break;
            case 3259225:
                if (str.equals("jfif")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    b3 = 19;
                }
                break;
            case 3542678:
                if (str.equals("svgz")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 3559925:
                if (str.equals("tiff")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 3645340:
                if (str.equals("webp")) {
                    b3 = Ascii.SYN;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 2:
            case 6:
            case 12:
                return "image/raw";
            case 1:
            case 3:
                return "image/bmp";
            case 4:
                return "image/gif";
            case 5:
                return "image/x-icon";
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 19:
                return "image/jpeg";
            case 11:
                return "image/png";
            case 13:
            case 20:
                return "image/svg+xml";
            case 14:
            case 21:
                return "image/tiff";
            case 15:
                return "image/avif";
            case 16:
                return "image/heic";
            case 17:
                return "image/heif";
            case 22:
                return "image/webp";
            default:
                return null;
        }
    }

    public static ColorInfo c(ColorInfo colorInfo, boolean z2) {
        return (z2 && ColorInfo.l(colorInfo)) ? ColorInfo.f40546h : colorInfo;
    }

    public static String d(Context context, MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f40714b;
        if (localConfiguration == null) {
            return null;
        }
        String str = localConfiguration.f40811b;
        if (str == null) {
            if (Objects.equals(localConfiguration.f40810a.getScheme(), AppLovinEventTypes.USER_VIEWED_CONTENT)) {
                return context.getContentResolver().getType(localConfiguration.f40810a);
            }
            String path = localConfiguration.f40810a.getPath();
            if (path == null) {
                return null;
            }
            int iLastIndexOf = path.lastIndexOf(".");
            if (iLastIndexOf >= 0 && iLastIndexOf < path.length() - 1) {
                return b(com.google.common.base.Ascii.e(path.substring(iLastIndexOf + 1)));
            }
        }
        return str;
    }

    public static int e(int i3) {
        int i4 = (i3 & 1) != 1 ? 0 : 1;
        return (i3 & 4) == 4 ? i4 | 4 : i4;
    }

    public static Pair f(int i3, String str, ColorInfo colorInfo) {
        if (i3 == 0 && ColorInfo.l(colorInfo) && EncoderUtil.i(str, colorInfo).isEmpty()) {
            if (EncoderUtil.i("video/hevc", colorInfo).isEmpty()) {
                i3 = 2;
            } else {
                str = "video/hevc";
            }
        }
        return Pair.create(str, Integer.valueOf(i3));
    }

    public static int g(String str) {
        int iK = MimeTypes.k(str);
        if (iK == 4) {
            return 2;
        }
        return iK;
    }

    public static ColorInfo h(ColorInfo colorInfo) {
        return (colorInfo == null || !colorInfo.j()) ? ColorInfo.f40546h : colorInfo;
    }

    public static boolean i(Context context, MediaItem mediaItem) {
        String strD = d(context, mediaItem);
        return strD != null && MimeTypes.o(strD);
    }

    private static float j(ImmutableList immutableList, Format format) {
        int i3 = format.f40642y;
        int i4 = i3 % SensibleDefaults.X_OFFSET == 0 ? format.f40639v : format.f40640w;
        int i5 = i3 % SensibleDefaults.X_OFFSET == 0 ? format.f40640w : format.f40639v;
        float f3 = 0.0f;
        for (int i6 = 0; i6 < immutableList.size(); i6++) {
            Effect effect = (Effect) immutableList.get(i6);
            if (!(effect instanceof GlEffect)) {
                return -1.0f;
            }
            GlEffect glEffect = (GlEffect) effect;
            if (effect instanceof ScaleAndRotateTransformation) {
                ScaleAndRotateTransformation scaleAndRotateTransformation = (ScaleAndRotateTransformation) effect;
                if (scaleAndRotateTransformation.f42558a != 1.0f || scaleAndRotateTransformation.f42559b != 1.0f) {
                    return -1.0f;
                }
                float f4 = scaleAndRotateTransformation.f42560c;
                if (f4 % 90.0f != 0.0f) {
                    return -1.0f;
                }
                f3 += f4;
                float f5 = f3 % 180.0f;
                i4 = f5 == 0.0f ? format.f40639v : format.f40640w;
                i5 = f5 == 0.0f ? format.f40640w : format.f40639v;
            } else if (!glEffect.i(i4, i5)) {
                return -1.0f;
            }
        }
        float f6 = f3 % 360.0f;
        if (f6 % 90.0f == 0.0f) {
            return f6;
        }
        return -1.0f;
    }

    public static void k(MuxerWrapper muxerWrapper, ImmutableList immutableList, Format format) {
        float fJ = j(immutableList, format);
        if (fJ == 90.0f || fJ == 180.0f || fJ == 270.0f) {
            muxerWrapper.l(360 - Math.round(fJ));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean l(Format format, Composition composition, int i3, TransformationRequest transformationRequest, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper) {
        if (composition.f47968a.size() > 1 || ((EditedMediaItemSequence) composition.f47968a.get(i3)).f48110a.size() > 1) {
            Assertions.b((composition.b() && composition.f47972e) ? false : true, "Gaps can not be transmuxed.");
            return !composition.f47972e;
        }
        if (composition.b() || encoderFactory.d()) {
            return true;
        }
        String str = transformationRequest.f48471b;
        if (str != null && !str.equals(format.f40632o)) {
            return true;
        }
        if (transformationRequest.f48471b == null && !muxerWrapper.n(format.f40632o)) {
            return true;
        }
        EditedMediaItem editedMediaItem = (EditedMediaItem) ((EditedMediaItemSequence) composition.f47968a.get(i3)).f48110a.get(0);
        return ((!editedMediaItem.f48098d || !a(format)) && editedMediaItem.f48101g.f48126a.isEmpty() && composition.f47970c.f48126a.isEmpty()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean m(Format format, Composition composition, int i3, TransformationRequest transformationRequest, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper) {
        if (composition.f47968a.size() > 1 || ((EditedMediaItemSequence) composition.f47968a.get(i3)).f48110a.size() > 1) {
            return !composition.f47973f;
        }
        if (encoderFactory.a() || transformationRequest.f48473d != 0) {
            return true;
        }
        String str = transformationRequest.f48472c;
        if (str != null && !str.equals(format.f40632o) && !str.equals(MediaCodecUtil.g(format))) {
            return true;
        }
        if ((str == null && !muxerWrapper.n(format.f40632o) && !muxerWrapper.n(MediaCodecUtil.g(format))) || format.f40643z != 1.0f) {
            return true;
        }
        ImmutableList immutableListM = new ImmutableList.Builder().k(((EditedMediaItem) ((EditedMediaItemSequence) composition.f47968a.get(i3)).f48110a.get(0)).f48101g.f48127b).k(composition.f47970c.f48127b).m();
        return !immutableListM.isEmpty() && j(immutableListM, format) == -1.0f;
    }
}
