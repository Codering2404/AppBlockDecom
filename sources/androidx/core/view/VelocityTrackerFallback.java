package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class VelocityTrackerFallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f34439a = new float[20];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f34440b = new long[20];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f34441c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34442d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34443e = 0;

    VelocityTrackerFallback() {
    }

    private void b() {
        this.f34442d = 0;
        this.f34441c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j3;
        int i3 = this.f34442d;
        if (i3 < 2) {
            return 0.0f;
        }
        int i4 = this.f34443e;
        int i5 = ((i4 + 20) - (i3 - 1)) % 20;
        long j4 = this.f34440b[i4];
        while (true) {
            jArr = this.f34440b;
            j3 = jArr[i5];
            if (j4 - j3 <= 100) {
                break;
            }
            this.f34442d--;
            i5 = (i5 + 1) % 20;
        }
        int i6 = this.f34442d;
        if (i6 < 2) {
            return 0.0f;
        }
        if (i6 == 2) {
            int i7 = (i5 + 1) % 20;
            if (j3 == jArr[i7]) {
                return 0.0f;
            }
            return this.f34439a[i7] / (r2 - j3);
        }
        float fAbs = 0.0f;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f34442d - 1; i9++) {
            int i10 = i9 + i5;
            long[] jArr2 = this.f34440b;
            long j5 = jArr2[i10 % 20];
            int i11 = (i10 + 1) % 20;
            if (jArr2[i11] != j5) {
                i8++;
                float f3 = f(fAbs);
                float f4 = this.f34439a[i11] / (this.f34440b[i11] - j5);
                fAbs += (f4 - f3) * Math.abs(f4);
                if (i8 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }

    private static float f(float f3) {
        return (f3 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f3) * 2.0f));
    }

    void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f34442d != 0 && eventTime - this.f34440b[this.f34443e] > 40) {
            b();
        }
        int i3 = (this.f34443e + 1) % 20;
        this.f34443e = i3;
        int i4 = this.f34442d;
        if (i4 != 20) {
            this.f34442d = i4 + 1;
        }
        this.f34439a[i3] = motionEvent.getAxisValue(26);
        this.f34440b[this.f34443e] = eventTime;
    }

    void c(int i3, float f3) {
        float fE = e() * i3;
        this.f34441c = fE;
        if (fE < (-Math.abs(f3))) {
            this.f34441c = -Math.abs(f3);
        } else if (this.f34441c > Math.abs(f3)) {
            this.f34441c = Math.abs(f3);
        }
    }

    float d(int i3) {
        if (i3 != 26) {
            return 0.0f;
        }
        return this.f34441c;
    }
}
