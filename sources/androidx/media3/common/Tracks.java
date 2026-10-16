package androidx.media3.common;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Tracks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Tracks f41239b = new Tracks(ImmutableList.y());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f41240c = Util.y0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f41241a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Group {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f41242f = Util.y0(0);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final String f41243g = Util.y0(1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final String f41244h = Util.y0(3);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final String f41245i = Util.y0(4);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f41246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrackGroup f41247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f41248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f41249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean[] f41250e;

        public Group(TrackGroup trackGroup, boolean z2, int[] iArr, boolean[] zArr) {
            int i3 = trackGroup.f41153a;
            this.f41246a = i3;
            boolean z3 = false;
            Assertions.a(i3 == iArr.length && i3 == zArr.length);
            this.f41247b = trackGroup;
            if (z2 && i3 > 1) {
                z3 = true;
            }
            this.f41248c = z3;
            this.f41249d = (int[]) iArr.clone();
            this.f41250e = (boolean[]) zArr.clone();
        }

        public Format a(int i3) {
            return this.f41247b.a(i3);
        }

        public int b(int i3) {
            return this.f41249d[i3];
        }

        public int c() {
            return this.f41247b.f41155c;
        }

        public boolean d() {
            return Booleans.c(this.f41250e, true);
        }

        public boolean e(int i3) {
            return this.f41250e[i3];
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Group.class == obj.getClass()) {
                Group group = (Group) obj;
                if (this.f41248c == group.f41248c && this.f41247b.equals(group.f41247b) && Arrays.equals(this.f41249d, group.f41249d) && Arrays.equals(this.f41250e, group.f41250e)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f41247b.hashCode() * 31) + (this.f41248c ? 1 : 0)) * 31) + Arrays.hashCode(this.f41249d)) * 31) + Arrays.hashCode(this.f41250e);
        }
    }

    public Tracks(List list) {
        this.f41241a = ImmutableList.t(list);
    }

    public ImmutableList a() {
        return this.f41241a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(int i3) {
        for (int i4 = 0; i4 < this.f41241a.size(); i4++) {
            Group group = (Group) this.f41241a.get(i4);
            if (group.d() && group.c() == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.f41241a.equals(((Tracks) obj).f41241a);
    }

    public int hashCode() {
        return this.f41241a.hashCode();
    }
}
