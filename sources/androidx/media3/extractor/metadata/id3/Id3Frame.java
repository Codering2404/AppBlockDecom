package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46475a;

    public Id3Frame(String str) {
        this.f46475a = str;
    }

    public String toString() {
        return this.f46475a;
    }
}
