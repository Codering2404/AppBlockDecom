package androidx.media3.container;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class XmpData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f41775a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f41775a, ((XmpData) obj).f41775a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f41775a);
    }

    public String toString() {
        return "XMP: " + Util.o1(this.f41775a);
    }
}
