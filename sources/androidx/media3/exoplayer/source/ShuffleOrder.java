package androidx.media3.exoplayer.source;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ShuffleOrder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DefaultShuffleOrder implements ShuffleOrder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Random f44909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f44910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f44911c;

        public DefaultShuffleOrder(int i3) {
            this(i3, new Random());
        }

        private static int[] h(int i3, Random random) {
            int[] iArr = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i4 + 1;
                int iNextInt = random.nextInt(i5);
                iArr[i4] = iArr[iNextInt];
                iArr[iNextInt] = i4;
                i4 = i5;
            }
            return iArr;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder a(int i3, int i4) {
            int i5 = i4 - i3;
            int[] iArr = new int[this.f44910b.length - i5];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr2 = this.f44910b;
                if (i6 >= iArr2.length) {
                    return new DefaultShuffleOrder(iArr, new Random(this.f44909a.nextLong()));
                }
                int i8 = iArr2[i6];
                if (i8 < i3 || i8 >= i4) {
                    int i9 = i6 - i7;
                    if (i8 >= i3) {
                        i8 -= i5;
                    }
                    iArr[i9] = i8;
                } else {
                    i7++;
                }
                i6++;
            }
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int b(int i3) {
            int i4 = this.f44911c[i3] - 1;
            if (i4 >= 0) {
                return this.f44910b[i4];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int c(int i3) {
            int i4 = this.f44911c[i3] + 1;
            int[] iArr = this.f44910b;
            if (i4 < iArr.length) {
                return iArr[i4];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int d() {
            int[] iArr = this.f44910b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder e() {
            return new DefaultShuffleOrder(0, new Random(this.f44909a.nextLong()));
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int f() {
            int[] iArr = this.f44910b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder g(int i3, int i4) {
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int i5 = 0;
            int i6 = 0;
            while (i6 < i4) {
                iArr[i6] = this.f44909a.nextInt(this.f44910b.length + 1);
                int i7 = i6 + 1;
                int iNextInt = this.f44909a.nextInt(i7);
                iArr2[i6] = iArr2[iNextInt];
                iArr2[iNextInt] = i6 + i3;
                i6 = i7;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f44910b.length + i4];
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int[] iArr4 = this.f44910b;
                if (i5 >= iArr4.length + i4) {
                    return new DefaultShuffleOrder(iArr3, new Random(this.f44909a.nextLong()));
                }
                if (i8 >= i4 || i9 != iArr[i8]) {
                    int i10 = i9 + 1;
                    int i11 = iArr4[i9];
                    iArr3[i5] = i11;
                    if (i11 >= i3) {
                        iArr3[i5] = i11 + i4;
                    }
                    i9 = i10;
                } else {
                    iArr3[i5] = iArr2[i8];
                    i8++;
                }
                i5++;
            }
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int getLength() {
            return this.f44910b.length;
        }

        private DefaultShuffleOrder(int i3, Random random) {
            this(h(i3, random), random);
        }

        private DefaultShuffleOrder(int[] iArr, Random random) {
            this.f44910b = iArr;
            this.f44909a = random;
            this.f44911c = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.f44911c[iArr[i3]] = i3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnshuffledShuffleOrder implements ShuffleOrder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f44912a;

        public UnshuffledShuffleOrder(int i3) {
            this.f44912a = i3;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder a(int i3, int i4) {
            return new UnshuffledShuffleOrder((this.f44912a - i4) + i3);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int b(int i3) {
            int i4 = i3 - 1;
            if (i4 >= 0) {
                return i4;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int c(int i3) {
            int i4 = i3 + 1;
            if (i4 < this.f44912a) {
                return i4;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int d() {
            int i3 = this.f44912a;
            if (i3 > 0) {
                return i3 - 1;
            }
            return -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder e() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int f() {
            return this.f44912a > 0 ? 0 : -1;
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public ShuffleOrder g(int i3, int i4) {
            return new UnshuffledShuffleOrder(this.f44912a + i4);
        }

        @Override // androidx.media3.exoplayer.source.ShuffleOrder
        public int getLength() {
            return this.f44912a;
        }
    }

    ShuffleOrder a(int i3, int i4);

    int b(int i3);

    int c(int i3);

    int d();

    ShuffleOrder e();

    int f();

    ShuffleOrder g(int i3, int i4);

    int getLength();
}
