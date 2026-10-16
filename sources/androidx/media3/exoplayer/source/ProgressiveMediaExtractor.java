package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.DataReader;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ProgressiveMediaExtractor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        ProgressiveMediaExtractor a(PlayerId playerId);
    }

    void a(long j3, long j4);

    void b();

    void c(DataReader dataReader, Uri uri, Map map, long j3, long j4, ExtractorOutput extractorOutput);

    long d();

    int e(PositionHolder positionHolder);

    void release();
}
