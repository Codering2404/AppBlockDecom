package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CompositeSequenceableLoader implements SequenceableLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f44598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f44599b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SequenceableLoaderWithTrackTypes implements SequenceableLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SequenceableLoader f44600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImmutableList f44601b;

        public SequenceableLoaderWithTrackTypes(SequenceableLoader sequenceableLoader, List list) {
            this.f44600a = sequenceableLoader;
            this.f44601b = ImmutableList.t(list);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public boolean a() {
            return this.f44600a.a();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public boolean b(LoadingInfo loadingInfo) {
            return this.f44600a.b(loadingInfo);
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public long c() {
            return this.f44600a.c();
        }

        public ImmutableList d() {
            return this.f44601b;
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public long e() {
            return this.f44600a.e();
        }

        @Override // androidx.media3.exoplayer.source.SequenceableLoader
        public void f(long j3) {
            this.f44600a.f(j3);
        }
    }

    public CompositeSequenceableLoader(List list, List list2) {
        ImmutableList.Builder builderO = ImmutableList.o();
        Assertions.a(list.size() == list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            builderO.a(new SequenceableLoaderWithTrackTypes((SequenceableLoader) list.get(i3), (List) list2.get(i3)));
        }
        this.f44598a = builderO.m();
        this.f44599b = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        for (int i3 = 0; i3 < this.f44598a.size(); i3++) {
            if (((SequenceableLoaderWithTrackTypes) this.f44598a.get(i3)).a()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        boolean zB;
        boolean z2 = false;
        do {
            long jC = c();
            if (jC == Long.MIN_VALUE) {
                return z2;
            }
            zB = false;
            for (int i3 = 0; i3 < this.f44598a.size(); i3++) {
                long jC2 = ((SequenceableLoaderWithTrackTypes) this.f44598a.get(i3)).c();
                boolean z3 = jC2 != Long.MIN_VALUE && jC2 <= loadingInfo.f43121a;
                if (jC2 == jC || z3) {
                    zB |= ((SequenceableLoaderWithTrackTypes) this.f44598a.get(i3)).b(loadingInfo);
                }
            }
            z2 |= zB;
        } while (zB);
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        long jMin = Long.MAX_VALUE;
        for (int i3 = 0; i3 < this.f44598a.size(); i3++) {
            long jC = ((SequenceableLoaderWithTrackTypes) this.f44598a.get(i3)).c();
            if (jC != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jC);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < this.f44598a.size(); i3++) {
            SequenceableLoaderWithTrackTypes sequenceableLoaderWithTrackTypes = (SequenceableLoaderWithTrackTypes) this.f44598a.get(i3);
            long jE = sequenceableLoaderWithTrackTypes.e();
            if ((sequenceableLoaderWithTrackTypes.d().contains(1) || sequenceableLoaderWithTrackTypes.d().contains(2) || sequenceableLoaderWithTrackTypes.d().contains(4)) && jE != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jE);
            }
            if (jE != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jE);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            this.f44599b = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j3 = this.f44599b;
        return j3 != -9223372036854775807L ? j3 : jMin2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
        for (int i3 = 0; i3 < this.f44598a.size(); i3++) {
            ((SequenceableLoaderWithTrackTypes) this.f44598a.get(i3)).f(j3);
        }
    }
}
