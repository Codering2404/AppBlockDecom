package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.XmpData;
import com.google.common.primitives.Longs;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MuxerUtil {
    static MdtaMetadataEntry a(long j3) {
        return new MdtaMetadataEntry("auxiliary.tracks.length", Longs.j(j3), 78);
    }

    private static MdtaMetadataEntry b(List list) {
        int i3;
        int size = list.size();
        byte[] bArr = new byte[size + 2];
        bArr[0] = 1;
        bArr[1] = (byte) size;
        for (int i4 = 0; i4 < size; i4++) {
            Track track = (Track) list.get(i4);
            int i5 = track.f47890b.f40624g;
            if (i5 != 1) {
                i3 = 2;
                if (i5 == 2) {
                    i3 = 1;
                } else if (i5 == 3) {
                    continue;
                } else {
                    if (i5 != 4) {
                        throw new IllegalArgumentException("Unsupported auxiliary track type " + track.f47890b.f40624g);
                    }
                    i3 = 3;
                }
            } else {
                i3 = 0;
            }
            bArr[i4 + 2] = (byte) i3;
        }
        return new MdtaMetadataEntry("auxiliary.tracks.map", bArr, 0);
    }

    static MdtaMetadataEntry c(long j3) {
        return new MdtaMetadataEntry("auxiliary.tracks.offset", Longs.j(j3), 78);
    }

    private static MdtaMetadataEntry d(boolean z2) {
        return new MdtaMetadataEntry("auxiliary.tracks.interleaved", new byte[]{z2 ? (byte) 1 : (byte) 0}, 75);
    }

    static boolean e(Format format) {
        if ((format.f40623f & 32768) <= 0) {
            return false;
        }
        int i3 = format.f40624g;
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4;
    }

    private static boolean f(MdtaMetadataEntry mdtaMetadataEntry) {
        int i3 = mdtaMetadataEntry.f41661d;
        return i3 == 1 || i3 == 23;
    }

    public static boolean g(Metadata.Entry entry) {
        if ((entry instanceof Mp4OrientationData) || (entry instanceof Mp4LocationData)) {
            return true;
        }
        if ((entry instanceof Mp4TimestampData) && h((Mp4TimestampData) entry)) {
            return true;
        }
        return ((entry instanceof MdtaMetadataEntry) && f((MdtaMetadataEntry) entry)) || (entry instanceof XmpData);
    }

    private static boolean h(Mp4TimestampData mp4TimestampData) {
        return mp4TimestampData.f41671a <= 4294967295L && mp4TimestampData.f41672b <= 4294967295L;
    }

    static void i(MetadataCollector metadataCollector, Mp4TimestampData mp4TimestampData, boolean z2, List list) {
        metadataCollector.a(mp4TimestampData);
        metadataCollector.a(d(z2));
        metadataCollector.a(b(list));
    }
}
