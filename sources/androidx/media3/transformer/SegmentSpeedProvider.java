package androidx.media3.transformer;

import androidx.media3.common.Metadata;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class SegmentSpeedProvider implements SpeedProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableSortedMap f48388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f48389b;

    public SegmentSpeedProvider(Metadata metadata) {
        float fE = e(metadata);
        float f3 = fE == -3.4028235E38f ? 1.0f : fE / 30.0f;
        this.f48389b = f3;
        this.f48388a = c(metadata, f3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ImmutableSortedMap c(Metadata metadata, float f3) {
        ImmutableList immutableListD = d(metadata);
        if (immutableListD.isEmpty()) {
            return ImmutableSortedMap.K();
        }
        TreeMap treeMap = new TreeMap();
        for (int i3 = 0; i3 < immutableListD.size(); i3++) {
            treeMap.put(Long.valueOf(Util.P0(((SlowMotionData.Segment) immutableListD.get(i3)).f46499a)), Float.valueOf(f3 / r3.f46501c));
        }
        for (int i4 = 0; i4 < immutableListD.size(); i4++) {
            SlowMotionData.Segment segment = (SlowMotionData.Segment) immutableListD.get(i4);
            if (!treeMap.containsKey(Long.valueOf(Util.P0(segment.f46500b)))) {
                treeMap.put(Long.valueOf(Util.P0(segment.f46500b)), Float.valueOf(f3));
            }
        }
        return ImmutableSortedMap.x(treeMap);
    }

    private static ImmutableList d(Metadata metadata) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof SlowMotionData) {
                arrayList.addAll(((SlowMotionData) entryD).f46497a);
            }
        }
        return ImmutableList.K(SlowMotionData.Segment.f46498d, arrayList);
    }

    private static float e(Metadata metadata) {
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof SmtaMetadataEntry) {
                return ((SmtaMetadataEntry) entryD).f46502a;
            }
        }
        return -3.4028235E38f;
    }

    @Override // androidx.media3.common.audio.SpeedProvider
    public float a(long j3) {
        Assertions.a(j3 >= 0);
        Map.Entry entryFloorEntry = this.f48388a.floorEntry(Long.valueOf(j3));
        return entryFloorEntry != null ? ((Float) entryFloorEntry.getValue()).floatValue() : this.f48389b;
    }

    @Override // androidx.media3.common.audio.SpeedProvider
    public long b(long j3) {
        Assertions.a(j3 >= 0);
        Long l3 = (Long) this.f48388a.higherKey(Long.valueOf(j3));
        if (l3 != null) {
            return l3.longValue();
        }
        return -9223372036854775807L;
    }
}
