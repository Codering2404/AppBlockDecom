package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.MediaMetadata;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ApicFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f46450e;

    public ApicFrame(String str, String str2, int i3, byte[] bArr) {
        super("APIC");
        this.f46447b = str;
        this.f46448c = str2;
        this.f46449d = i3;
        this.f46450e = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        builder.K(this.f46450e, this.f46449d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ApicFrame.class == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.f46449d == apicFrame.f46449d && Objects.equals(this.f46447b, apicFrame.f46447b) && Objects.equals(this.f46448c, apicFrame.f46448c) && Arrays.equals(this.f46450e, apicFrame.f46450e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (527 + this.f46449d) * 31;
        String str = this.f46447b;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f46448c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f46450e);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": mimeType=" + this.f46447b + ", description=" + this.f46448c;
    }
}
