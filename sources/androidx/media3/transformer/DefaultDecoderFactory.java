package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Pair;
import android.view.Surface;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.DefaultDecoderFactory;
import androidx.media3.transformer.ExportException;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDecoderFactory implements Codec.DecoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f48063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f48064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener f48065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f48066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f48067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MediaCodecSelector f48068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f48069g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface Listener {
        void a(String str, List list);
    }

    private static void c(MediaFormat mediaFormat) {
        if (Util.f41609a < 25) {
            return;
        }
        if (m()) {
            mediaFormat.setInteger("priority", 1);
        }
        mediaFormat.setInteger("operating-rate", ColorExtractionConstants.MAX_PIXEL_SAMPLES);
    }

    private DefaultCodec d(MediaFormat mediaFormat, Format format, Surface surface, boolean z2) throws ExportException {
        ImmutableList.y();
        Assertions.e(format.f40632o);
        try {
            List listP = MediaCodecUtil.p(MediaCodecUtil.n(this.f48068f, format, false, false), format);
            if (listP.isEmpty()) {
                throw f(format, "No decoders for format");
            }
            if (z2) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < listP.size(); i3++) {
                    MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) listP.get(i3);
                    if (!mediaCodecInfo.f44271h) {
                        arrayList.add(mediaCodecInfo);
                    }
                }
                if (!arrayList.isEmpty()) {
                    listP = arrayList;
                }
            }
            if (Util.f41609a >= 31 && ((MediaCodecInfo) listP.get(0)).f44266c.equals("video/dolby-vision")) {
                mediaFormat.setInteger("color-transfer-request", 7);
            }
            ArrayList arrayList2 = new ArrayList();
            Context context = this.f48063a;
            if (!this.f48064b) {
                listP = listP.subList(0, 1);
            }
            DefaultCodec defaultCodecE = e(context, listP, format, mediaFormat, surface, arrayList2);
            this.f48065c.a(defaultCodecE.getName(), arrayList2);
            return defaultCodecE;
        } catch (MediaCodecUtil.DecoderQueryException e3) {
            Log.e("DefaultDecoderFactory", "Error querying decoders", e3);
            throw f(format, "Querying codecs failed");
        }
    }

    private static DefaultCodec e(Context context, List list, Format format, MediaFormat mediaFormat, Surface surface, List list2) throws ExportException {
        Context context2;
        Format format2;
        MediaFormat mediaFormat2;
        Surface surface2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) it.next();
            mediaFormat.setString("mime", mediaCodecInfo.f44266c);
            try {
                context2 = context;
                format2 = format;
                mediaFormat2 = mediaFormat;
                surface2 = surface;
            } catch (ExportException e3) {
                e = e3;
                context2 = context;
                format2 = format;
                mediaFormat2 = mediaFormat;
                surface2 = surface;
            }
            try {
                return new DefaultCodec(context2, format2, mediaFormat2, mediaCodecInfo.f44264a, true, surface2);
            } catch (ExportException e4) {
                e = e4;
                list2.add(e);
                context = context2;
                format = format2;
                mediaFormat = mediaFormat2;
                surface = surface2;
            }
        }
        throw ((ExportException) list2.get(0));
    }

    private static ExportException f(Format format, String str) {
        return ExportException.c(new IllegalArgumentException(str), 3003, new ExportException.CodecInfo(format.toString(), MimeTypes.q((String) Assertions.e(format.f40632o)), true, null));
    }

    private static boolean i(Context context) {
        return Util.f41609a >= 29 && context.getApplicationInfo().targetSdkVersion >= 29;
    }

    private static boolean j(Format format) {
        String str;
        if (Util.f41609a >= 31 || format.f40639v < 7680 || format.f40640w < 4320 || (str = format.f40632o) == null || !str.equals("video/hevc")) {
            return false;
        }
        String str2 = Build.MODEL;
        return str2.equals("SM-F711U1") || str2.equals("SM-F926U1");
    }

    private static boolean l() {
        return Util.f41609a < 30 && Build.DEVICE.equals("joyeuse");
    }

    private static boolean m() {
        if (Util.f41609a >= 31) {
            return Build.SOC_MODEL.equals("s5e8835") || Build.SOC_MODEL.equals("SA8155P");
        }
        return false;
    }

    private static boolean n(Format format) {
        if (format.f40639v * format.f40640w < 2073600) {
            return false;
        }
        String str = Build.MODEL;
        return Ascii.a(str, "vivo 1906") || Ascii.a(str, "redmi 7a") || Ascii.a(str, "redmi 8");
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public DefaultCodec a(Format format) {
        return d(MediaFormatUtil.b(format), format, null, false);
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public DefaultCodec b(Format format, Surface surface, boolean z2) throws ExportException {
        if (ColorInfo.l(format.C)) {
            if (z2 && (Util.f41609a < 31 || k(((ColorInfo) Assertions.e(format.C)).f40556c))) {
                throw f(format, "Tone-mapping HDR is not supported on this device.");
            }
            if (Util.f41609a < 29) {
                throw f(format, "Decoding HDR is not supported on this device.");
            }
        }
        if (j(format)) {
            throw f(format, "Decoding 8k is not supported on this device.");
        }
        if (l()) {
            format = format.b().b0(-1.0f).N();
        }
        MediaFormat mediaFormatB = MediaFormatUtil.b(format);
        if (i(this.f48063a)) {
            mediaFormatB.setInteger("allow-frame-drop", 0);
        }
        int i3 = Util.f41609a;
        if (i3 >= 31 && z2) {
            mediaFormatB.setInteger("color-transfer-request", 3);
        }
        Pair pairJ = MediaCodecUtil.j(format);
        if (pairJ != null) {
            MediaFormatUtil.p(mediaFormatB, "profile", ((Integer) pairJ.first).intValue());
            MediaFormatUtil.p(mediaFormatB, AppLovinEventTypes.USER_COMPLETED_LEVEL, ((Integer) pairJ.second).intValue());
        }
        if (i3 >= 35) {
            mediaFormatB.setInteger("importance", Math.max(0, -this.f48066d));
        }
        if (this.f48067e) {
            c(mediaFormatB);
        }
        return d(mediaFormatB, format, surface, n(format));
    }

    public boolean o() {
        return this.f48069g;
    }

    private DefaultDecoderFactory(Builder builder) {
        this.f48063a = builder.f48070a;
        this.f48064b = builder.f48072c;
        this.f48065c = builder.f48071b;
        this.f48066d = builder.f48073d;
        this.f48067e = builder.f48074e;
        this.f48068f = builder.f48075f;
        this.f48069g = builder.f48076g;
    }

    private static boolean k(int i3) {
        if (Build.MANUFACTURER.equals("Google") && Build.ID.startsWith("TP1A")) {
            return true;
        }
        if (i3 == 7) {
            String str = Build.MODEL;
            if (str.startsWith("SM-F936") || str.startsWith("SM-F916") || str.startsWith("SM-F721") || str.equals(QgXempTBEfV.VhNlTAvqlvkzD)) {
                return true;
            }
        }
        return Util.f41609a < 34 && i3 == 6 && Build.MODEL.startsWith("SM-F936");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f48070a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f48072c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f48076g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Listener f48071b = new Listener() { // from class: androidx.media3.transformer.d0
            @Override // androidx.media3.transformer.DefaultDecoderFactory.Listener
            public final void a(String str, List list) {
                DefaultDecoderFactory.Builder.a(str, list);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f48073d = -2000;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f48074e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MediaCodecSelector f48075f = MediaCodecSelector.f44322a;

        public Builder(Context context) {
            this.f48070a = context.getApplicationContext();
        }

        public DefaultDecoderFactory i() {
            return new DefaultDecoderFactory(this);
        }

        public static /* synthetic */ void a(String str, List list) {
        }
    }
}
