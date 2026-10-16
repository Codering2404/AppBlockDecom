package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExtractorOutput {
    public static final ExtractorOutput m8 = new ExtractorOutput() { // from class: androidx.media3.extractor.ExtractorOutput.1
        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput d(int i3, int i4) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void n(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void q() {
            throw new UnsupportedOperationException();
        }
    };

    TrackOutput d(int i3, int i4);

    void n(SeekMap seekMap);

    void q();
}
