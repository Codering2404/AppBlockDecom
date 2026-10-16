package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final TrackGroup f45341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f45342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f45343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f45344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Format[] f45345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f45346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f45348h;

    public BaseTrackSelection(TrackGroup trackGroup, int... iArr) {
        this(trackGroup, iArr, 0);
    }

    public static /* synthetic */ int n(Format format, Format format2) {
        return format2.f40627j - format.f40627j;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final Format b(int i3) {
        return this.f45345e[i3];
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int d(int i3) {
        return this.f45343c[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
            if (this.f45341a.equals(baseTrackSelection.f45341a) && Arrays.equals(this.f45343c, baseTrackSelection.f45343c)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int g(int i3) {
        for (int i4 = 0; i4 < this.f45342b; i4++) {
            if (this.f45343c[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final TrackGroup h() {
        return this.f45341a;
    }

    public int hashCode() {
        if (this.f45347g == 0) {
            this.f45347g = (System.identityHashCode(this.f45341a) * 31) + Arrays.hashCode(this.f45343c);
        }
        return this.f45347g;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void i(boolean z2) {
        this.f45348h = z2;
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final int k() {
        return this.f45343c[a()];
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public final Format l() {
        return this.f45345e[a()];
    }

    @Override // androidx.media3.exoplayer.trackselection.TrackSelection
    public final int length() {
        return this.f45343c.length;
    }

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i3) {
        Assertions.g(iArr.length > 0);
        this.f45344d = i3;
        this.f45341a = (TrackGroup) Assertions.e(trackGroup);
        int length = iArr.length;
        this.f45342b = length;
        this.f45345e = new Format[length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.f45345e[i4] = trackGroup.a(iArr[i4]);
        }
        Arrays.sort(this.f45345e, new Comparator() { // from class: androidx.media3.exoplayer.trackselection.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return BaseTrackSelection.n((Format) obj, (Format) obj2);
            }
        });
        this.f45343c = new int[this.f45342b];
        int i5 = 0;
        while (true) {
            int i6 = this.f45342b;
            if (i5 >= i6) {
                this.f45346f = new long[i6];
                this.f45348h = false;
                return;
            } else {
                this.f45343c[i5] = trackGroup.b(this.f45345e[i5]);
                i5++;
            }
        }
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void c() {
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void j() {
    }

    @Override // androidx.media3.exoplayer.trackselection.ExoTrackSelection
    public void e(float f3) {
    }
}
