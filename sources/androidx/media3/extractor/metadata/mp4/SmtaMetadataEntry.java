package androidx.media3.extractor.metadata.mp4;

import androidx.media3.common.Metadata;
import com.google.common.primitives.Floats;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f46502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46503b;

    public SmtaMetadataEntry(float f3, int i3) {
        this.f46502a = f3;
        this.f46503b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SmtaMetadataEntry.class == obj.getClass()) {
            SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
            if (this.f46502a == smtaMetadataEntry.f46502a && this.f46503b == smtaMetadataEntry.f46503b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Floats.c(this.f46502a)) * 31) + this.f46503b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f46502a + ", svcTemporalLayerCount=" + this.f46503b;
    }
}
