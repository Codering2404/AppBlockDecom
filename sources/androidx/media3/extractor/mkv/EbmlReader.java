package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
interface EbmlReader {
    boolean a(ExtractorInput extractorInput);

    void b(EbmlProcessor ebmlProcessor);

    void reset();
}
