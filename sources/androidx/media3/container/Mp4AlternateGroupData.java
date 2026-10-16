package androidx.media3.container;

import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4AlternateGroupData implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41662a;

    public Mp4AlternateGroupData(int i3) {
        this.f41662a = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mp4AlternateGroupData) && this.f41662a == ((Mp4AlternateGroupData) obj).f41662a;
    }

    public int hashCode() {
        return this.f41662a;
    }

    public String toString() {
        return "Mp4AlternateGroup: " + this.f41662a;
    }
}
