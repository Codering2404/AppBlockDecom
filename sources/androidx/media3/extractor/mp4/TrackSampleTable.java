package androidx.media3.extractor.mp4;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSampleTable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Track f46854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f46856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f46857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f46859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f46860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f46861h;

    public TrackSampleTable(Track track, long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3) {
        Assertions.a(iArr.length == jArr2.length);
        Assertions.a(jArr.length == jArr2.length);
        Assertions.a(iArr2.length == jArr2.length);
        this.f46854a = track;
        this.f46856c = jArr;
        this.f46857d = iArr;
        this.f46858e = i3;
        this.f46859f = jArr2;
        this.f46860g = iArr2;
        this.f46861h = j3;
        this.f46855b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j3) {
        for (int iJ = Util.j(this.f46859f, j3, true, false); iJ >= 0; iJ--) {
            if ((this.f46860g[iJ] & 1) != 0) {
                return iJ;
            }
        }
        return -1;
    }

    public int b(long j3) {
        for (int iF = Util.f(this.f46859f, j3, true, false); iF < this.f46859f.length; iF++) {
            if ((this.f46860g[iF] & 1) != 0) {
                return iF;
            }
        }
        return -1;
    }
}
