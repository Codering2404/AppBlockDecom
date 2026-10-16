package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
