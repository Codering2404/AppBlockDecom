package androidx.media3.muxer;

import androidx.media3.common.Metadata;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.XmpData;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MetadataCollector {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Mp4LocationData f47837b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Mp4TimestampData f47839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public XmpData f47840e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mp4OrientationData f47836a = new Mp4OrientationData(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f47838c = new HashSet();

    public MetadataCollector() {
        long jD = Mp4TimestampData.d(System.currentTimeMillis());
        this.f47839d = new Mp4TimestampData(jD, jD);
    }

    public void a(Metadata.Entry entry) {
        if (entry instanceof Mp4OrientationData) {
            this.f47836a = (Mp4OrientationData) entry;
            return;
        }
        if (entry instanceof Mp4LocationData) {
            this.f47837b = (Mp4LocationData) entry;
            return;
        }
        if (entry instanceof Mp4TimestampData) {
            this.f47839d = (Mp4TimestampData) entry;
        } else if (entry instanceof MdtaMetadataEntry) {
            this.f47838c.add((MdtaMetadataEntry) entry);
        } else {
            if (!(entry instanceof XmpData)) {
                throw new IllegalArgumentException("Unsupported metadata");
            }
            this.f47840e = (XmpData) entry;
        }
    }

    public void b(MdtaMetadataEntry mdtaMetadataEntry) {
        this.f47838c.remove(mdtaMetadataEntry);
    }
}
