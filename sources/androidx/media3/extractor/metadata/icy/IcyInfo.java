package androidx.media3.extractor.metadata.icy;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class IcyInfo implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f46444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46446c;

    public IcyInfo(byte[] bArr, String str, String str2) {
        this.f46444a = bArr;
        this.f46445b = str;
        this.f46446c = str2;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        String str = this.f46445b;
        if (str != null) {
            builder.q0(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f46444a, ((IcyInfo) obj).f46444a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f46444a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f46445b, this.f46446c, Integer.valueOf(this.f46444a.length));
    }
}
