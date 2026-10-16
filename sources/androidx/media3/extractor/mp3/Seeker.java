package androidx.media3.extractor.mp3;

import androidx.media3.extractor.SeekMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface Seeker extends SeekMap {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(-9223372036854775807L);
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public long d() {
            return -1L;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public long f(long j3) {
            return 0L;
        }

        @Override // androidx.media3.extractor.mp3.Seeker
        public int k() {
            return -2147483647;
        }
    }

    long d();

    long f(long j3);

    int k();
}
