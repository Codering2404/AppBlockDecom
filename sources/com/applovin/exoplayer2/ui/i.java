package com.applovin.exoplayer2.ui;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface i {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(i iVar, long j3);

        void a(i iVar, long j3, boolean z2);

        void b(i iVar, long j3);
    }

    void a(a aVar);

    void a(long[] jArr, boolean[] zArr, int i3);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j3);

    void setDuration(long j3);

    void setEnabled(boolean z2);

    void setPosition(long j3);
}
