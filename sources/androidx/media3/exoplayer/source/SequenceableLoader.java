package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.LoadingInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface SequenceableLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback<T extends SequenceableLoader> {
        void h(SequenceableLoader sequenceableLoader);
    }

    boolean a();

    boolean b(LoadingInfo loadingInfo);

    long c();

    long e();

    void f(long j3);
}
