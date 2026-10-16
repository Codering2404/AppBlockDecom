package androidx.media3.extractor.metadata.dvbsi;

import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoTable implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46414b;

    public AppInfoTable(int i3, String str) {
        this.f46413a = i3;
        this.f46414b = str;
    }

    public String toString() {
        return "Ait(controlCode=" + this.f46413a + ",url=" + this.f46414b + ")";
    }
}
