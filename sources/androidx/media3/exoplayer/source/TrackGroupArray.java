package androidx.media3.exoplayer.source;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroupArray {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TrackGroupArray f44985d = new TrackGroupArray(new TrackGroup[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f44986e = Util.y0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f44988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44989c;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f44988b = ImmutableList.v(trackGroupArr);
        this.f44987a = trackGroupArr.length;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e() {
        int i3 = 0;
        while (i3 < this.f44988b.size()) {
            int i4 = i3 + 1;
            for (int i5 = i4; i5 < this.f44988b.size(); i5++) {
                if (((TrackGroup) this.f44988b.get(i3)).equals(this.f44988b.get(i5))) {
                    Log.e("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i3 = i4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrackGroup b(int i3) {
        return (TrackGroup) this.f44988b.get(i3);
    }

    public ImmutableList c() {
        return ImmutableList.t(Lists.p(this.f44988b, new Function() { // from class: androidx.media3.exoplayer.source.h0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Integer.valueOf(((TrackGroup) obj).f41155c);
            }
        }));
    }

    public int d(TrackGroup trackGroup) {
        int iIndexOf = this.f44988b.indexOf(trackGroup);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroupArray.class == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            if (this.f44987a == trackGroupArray.f44987a && this.f44988b.equals(trackGroupArray.f44988b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f44989c == 0) {
            this.f44989c = this.f44988b.hashCode();
        }
        return this.f44989c;
    }

    public String toString() {
        return this.f44988b.toString();
    }
}
