package androidx.media3.exoplayer.text;

import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface CuesResolver {
    ImmutableList a(long j3);

    boolean b(CuesWithTiming cuesWithTiming, long j3);

    long c(long j3);

    void clear();

    long d(long j3);

    void e(long j3);
}
