package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface TimestampIterator {
    default long a() {
        return -9223372036854775807L;
    }

    TimestampIterator b();

    boolean hasNext();

    long next();
}
