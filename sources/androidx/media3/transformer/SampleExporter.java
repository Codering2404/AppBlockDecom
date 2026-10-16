package androidx.media3.transformer;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.MuxerWrapper;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class SampleExporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MuxerWrapper f48364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f48365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Metadata f48366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f48367d;

    public SampleExporter(Format format, MuxerWrapper muxerWrapper) {
        this.f48364a = muxerWrapper;
        this.f48366c = format.f40629l;
        this.f48365b = TransformerUtil.g(format.f40632o);
    }

    private boolean j() throws ExportException {
        if (!this.f48367d) {
            Format formatN = n();
            if (formatN == null) {
                return false;
            }
            if (this.f48366c != null) {
                formatN = formatN.b().n0(this.f48366c).N();
            }
            if (!this.f48364a.n(formatN.f40632o)) {
                String strG = MediaCodecUtil.g(formatN);
                if (this.f48364a.n(strG)) {
                    formatN = formatN.b().u0(strG).N();
                }
            }
            try {
                this.f48364a.a(formatN);
                this.f48367d = true;
            } catch (MuxerException e3) {
                throw ExportException.d(e3, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            } catch (MuxerWrapper.AppendTrackFormatException e4) {
                throw ExportException.d(e4, AdError.CLEAR_TEXT_SUPPORT_NOT_ALLOWED);
            }
        }
        if (o()) {
            this.f48364a.d(this.f48365b);
            return false;
        }
        DecoderInputBuffer decoderInputBufferM = m();
        if (decoderInputBufferM == null) {
            return false;
        }
        try {
            if (!this.f48364a.o(this.f48365b, (ByteBuffer) Assertions.i(decoderInputBufferM.f42138d), decoderInputBufferM.k(), decoderInputBufferM.f42140g)) {
                return false;
            }
            s();
            return true;
        } catch (MuxerException e5) {
            throw ExportException.d(e5, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static String k(Format format, List list) {
        boolean zQ = MimeTypes.q((String) Assertions.e(format.f40632o));
        ImmutableSet.Builder builderE = new ImmutableSet.Builder().e(format.f40632o);
        if (zQ) {
            builderE.e("video/hevc").e("video/avc");
        }
        builderE.k(list);
        ImmutableList immutableListA = builderE.n().a();
        for (int i3 = 0; i3 < immutableListA.size(); i3++) {
            String str = (String) immutableListA.get(i3);
            if (list.contains(str)) {
                if (zQ && ColorInfo.l(format.C)) {
                    if (!EncoderUtil.i(str, format.C).isEmpty()) {
                        return str;
                    }
                } else if (!EncoderUtil.h(str).isEmpty()) {
                    return str;
                }
            }
        }
        return null;
    }

    public abstract GraphInput l(EditedMediaItem editedMediaItem, Format format, int i3);

    protected abstract DecoderInputBuffer m();

    protected abstract Format n();

    protected abstract boolean o();

    public final boolean p() {
        if (j()) {
            return true;
        }
        return !o() && q();
    }

    protected boolean q() {
        return false;
    }

    public abstract void r();

    protected abstract void s();
}
