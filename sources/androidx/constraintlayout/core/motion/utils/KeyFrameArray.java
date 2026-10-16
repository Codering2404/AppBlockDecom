package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyFrameArray {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f31786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CustomAttribute[] f31787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31788c;

        public int a(int i3) {
            return this.f31786a[i3];
        }

        public int b() {
            return this.f31788c;
        }

        public CustomAttribute c(int i3) {
            return this.f31787b[this.f31786a[i3]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomVar {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f31789a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CustomVariable[] f31790b = new CustomVariable[101];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31791c;

        public CustomVar() {
            b();
        }

        public void a(int i3, CustomVariable customVariable) {
            if (this.f31790b[i3] != null) {
                d(i3);
            }
            this.f31790b[i3] = customVariable;
            int[] iArr = this.f31789a;
            int i4 = this.f31791c;
            this.f31791c = i4 + 1;
            iArr[i4] = i3;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f31789a, 999);
            Arrays.fill(this.f31790b, (Object) null);
            this.f31791c = 0;
        }

        public int c(int i3) {
            return this.f31789a[i3];
        }

        public void d(int i3) {
            this.f31790b[i3] = null;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = this.f31791c;
                if (i4 >= i6) {
                    this.f31791c = i6 - 1;
                    return;
                }
                int[] iArr = this.f31789a;
                if (i3 == iArr[i4]) {
                    iArr[i4] = 999;
                    i5++;
                }
                if (i4 != i5) {
                    iArr[i4] = iArr[i5];
                }
                i5++;
                i4++;
            }
        }

        public int e() {
            return this.f31791c;
        }

        public CustomVariable f(int i3) {
            return this.f31790b[this.f31789a[i3]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FloatArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f31792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float[][] f31793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31794c;

        public void a(int i3, float[] fArr) {
            if (this.f31793b[i3] != null) {
                b(i3);
            }
            this.f31793b[i3] = fArr;
            int[] iArr = this.f31792a;
            int i4 = this.f31794c;
            this.f31794c = i4 + 1;
            iArr[i4] = i3;
            Arrays.sort(iArr);
        }

        public void b(int i3) {
            this.f31793b[i3] = null;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = this.f31794c;
                if (i4 >= i6) {
                    this.f31794c = i6 - 1;
                    return;
                }
                int[] iArr = this.f31792a;
                if (i3 == iArr[i4]) {
                    iArr[i4] = 999;
                    i5++;
                }
                if (i4 != i5) {
                    iArr[i4] = iArr[i5];
                }
                i5++;
                i4++;
            }
        }

        public float[] c(int i3) {
            return this.f31793b[this.f31792a[i3]];
        }
    }
}
