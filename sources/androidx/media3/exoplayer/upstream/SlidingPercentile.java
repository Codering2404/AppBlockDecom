package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.SlidingPercentile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SlidingPercentile {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator f45560h = new Comparator() { // from class: androidx.media3.exoplayer.upstream.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return SlidingPercentile.b((SlidingPercentile.Sample) obj, (SlidingPercentile.Sample) obj2);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator f45561i = new Comparator() { // from class: androidx.media3.exoplayer.upstream.e
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((SlidingPercentile.Sample) obj).f45571c, ((SlidingPercentile.Sample) obj2).f45571c);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f45562a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f45566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45568g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sample[] f45564c = new Sample[5];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f45563b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f45565d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Sample {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f45570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f45571c;

        private Sample() {
        }
    }

    public SlidingPercentile(int i3) {
        this.f45562a = i3;
    }

    public static /* synthetic */ int b(Sample sample, Sample sample2) {
        return sample.f45569a - sample2.f45569a;
    }

    private void d() {
        if (this.f45565d != 1) {
            Collections.sort(this.f45563b, f45560h);
            this.f45565d = 1;
        }
    }

    private void e() {
        if (this.f45565d != 0) {
            Collections.sort(this.f45563b, f45561i);
            this.f45565d = 0;
        }
    }

    public void c(int i3, float f3) {
        Sample sample;
        d();
        int i4 = this.f45568g;
        if (i4 > 0) {
            Sample[] sampleArr = this.f45564c;
            int i5 = i4 - 1;
            this.f45568g = i5;
            sample = sampleArr[i5];
        } else {
            sample = new Sample();
        }
        int i6 = this.f45566e;
        this.f45566e = i6 + 1;
        sample.f45569a = i6;
        sample.f45570b = i3;
        sample.f45571c = f3;
        this.f45563b.add(sample);
        this.f45567f += i3;
        while (true) {
            int i7 = this.f45567f;
            int i8 = this.f45562a;
            if (i7 <= i8) {
                return;
            }
            int i9 = i7 - i8;
            Sample sample2 = (Sample) this.f45563b.get(0);
            int i10 = sample2.f45570b;
            if (i10 <= i9) {
                this.f45567f -= i10;
                this.f45563b.remove(0);
                int i11 = this.f45568g;
                if (i11 < 5) {
                    Sample[] sampleArr2 = this.f45564c;
                    this.f45568g = i11 + 1;
                    sampleArr2[i11] = sample2;
                }
            } else {
                sample2.f45570b = i10 - i9;
                this.f45567f -= i9;
            }
        }
    }

    public float f(float f3) {
        e();
        float f4 = f3 * this.f45567f;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f45563b.size(); i4++) {
            Sample sample = (Sample) this.f45563b.get(i4);
            i3 += sample.f45570b;
            if (i3 >= f4) {
                return sample.f45571c;
            }
        }
        if (this.f45563b.isEmpty()) {
            return Float.NaN;
        }
        return ((Sample) this.f45563b.get(r5.size() - 1)).f45571c;
    }

    public void g() {
        this.f45563b.clear();
        this.f45565d = -1;
        this.f45566e = 0;
        this.f45567f = 0;
    }
}
