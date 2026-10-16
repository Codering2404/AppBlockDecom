package androidx.media3.exoplayer.source;

import android.media.MediaParser;
import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.ProgressiveMediaExtractor;
import androidx.media3.exoplayer.source.mediaparser.InputReaderAdapterV30;
import androidx.media3.exoplayer.source.mediaparser.MediaParserUtil;
import androidx.media3.exoplayer.source.mediaparser.OutputConsumerAdapterV30;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaParserExtractorAdapter implements ProgressiveMediaExtractor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ProgressiveMediaExtractor.Factory f44747e = new ProgressiveMediaExtractor.Factory() { // from class: androidx.media3.exoplayer.source.s
        @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor.Factory
        public final ProgressiveMediaExtractor a(PlayerId playerId) {
            return MediaParserExtractorAdapter.f(playerId);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputConsumerAdapterV30 f44748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputReaderAdapterV30 f44749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaParser f44750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44751d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements ProgressiveMediaExtractor.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map f44752a = new HashMap();

        @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaParserExtractorAdapter a(PlayerId playerId) {
            return new MediaParserExtractorAdapter(playerId, f44752a);
        }
    }

    public static /* synthetic */ ProgressiveMediaExtractor f(PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId, ImmutableMap.n());
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void a(long j3, long j4) {
        this.f44749b.b(j3);
        Pair pairI = this.f44748a.i(j4);
        this.f44750c.seek(m.a(m.a(pairI.second).position == j3 ? pairI.second : pairI.first));
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void b() {
        if ("android.media.mediaparser.Mp3Parser".equals(this.f44751d)) {
            this.f44748a.a();
        }
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void c(DataReader dataReader, Uri uri, Map map, long j3, long j4, ExtractorOutput extractorOutput) throws IOException {
        this.f44748a.m(extractorOutput);
        this.f44749b.c(dataReader, j4);
        this.f44749b.b(j3);
        String parserName = this.f44750c.getParserName();
        if ("android.media.mediaparser.UNKNOWN".equals(parserName)) {
            this.f44750c.advance(this.f44749b);
            String parserName2 = this.f44750c.getParserName();
            this.f44751d = parserName2;
            this.f44748a.o(parserName2);
            return;
        }
        if (parserName.equals(this.f44751d)) {
            return;
        }
        String parserName3 = this.f44750c.getParserName();
        this.f44751d = parserName3;
        this.f44748a.o(parserName3);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public long d() {
        return this.f44749b.getPosition();
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public int e(PositionHolder positionHolder) throws IOException {
        boolean zAdvance = this.f44750c.advance(this.f44749b);
        long jA = this.f44749b.a();
        positionHolder.f46210a = jA;
        if (zAdvance) {
            return jA != -1 ? 1 : 0;
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void release() {
        this.f44750c.release();
    }

    private MediaParserExtractorAdapter(PlayerId playerId, Map map) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        this.f44748a = outputConsumerAdapterV30;
        this.f44749b = new InputReaderAdapterV30();
        MediaParser mediaParserCreate = MediaParser.create(outputConsumerAdapterV30, new String[0]);
        this.f44750c = mediaParserCreate;
        Boolean bool = Boolean.TRUE;
        mediaParserCreate.setParameter("android.media.mediaparser.eagerlyExposeTrackType", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.inBandCryptoInfo", bool);
        mediaParserCreate.setParameter("android.media.mediaparser.includeSupplementalData", bool);
        for (Map.Entry entry : map.entrySet()) {
            this.f44750c.setParameter((String) entry.getKey(), entry.getValue());
        }
        this.f44751d = "android.media.mediaparser.UNKNOWN";
        if (Util.f41609a >= 31) {
            MediaParserUtil.a(this.f44750c, playerId);
        }
    }
}
