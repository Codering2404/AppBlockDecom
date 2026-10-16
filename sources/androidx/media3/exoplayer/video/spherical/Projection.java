package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mesh f45927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Mesh f45928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f45930d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Mesh {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SubMesh[] f45931a;

        public Mesh(SubMesh... subMeshArr) {
            this.f45931a = subMeshArr;
        }

        public SubMesh a(int i3) {
            return this.f45931a[i3];
        }

        public int b() {
            return this.f45931a.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SubMesh {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f45933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f45934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f45935d;

        public SubMesh(int i3, float[] fArr, float[] fArr2, int i4) {
            this.f45932a = i3;
            Assertions.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f45934c = fArr;
            this.f45935d = fArr2;
            this.f45933b = i4;
        }

        public int a() {
            return this.f45934c.length / 3;
        }
    }

    public Projection(Mesh mesh, int i3) {
        this(mesh, mesh, i3);
    }

    public static Projection a(float f3, int i3, int i4, float f4, float f5, int i5) {
        int i6;
        int i7 = i3;
        Assertions.a(f3 > 0.0f);
        Assertions.a(i7 >= 1);
        Assertions.a(i4 >= 1);
        Assertions.a(f4 > 0.0f && f4 <= 180.0f);
        Assertions.a(f5 > 0.0f && f5 <= 360.0f);
        float radians = (float) Math.toRadians(f4);
        float radians2 = (float) Math.toRadians(f5);
        float f6 = radians / i7;
        float f7 = radians2 / i4;
        int i8 = i4 + 1;
        int i9 = ((i8 * 2) + 2) * i7;
        float[] fArr = new float[i9 * 3];
        float[] fArr2 = new float[i9 * 2];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i7) {
            float f8 = radians / 2.0f;
            float f9 = (i10 * f6) - f8;
            int i13 = i10 + 1;
            float f10 = (i13 * f6) - f8;
            int i14 = 0;
            while (i14 < i8) {
                float f11 = radians;
                float f12 = radians2;
                int i15 = 0;
                int i16 = 2;
                while (i15 < i16) {
                    float f13 = f6;
                    float f14 = i14 * f7;
                    float f15 = f7;
                    float f16 = f9;
                    double d3 = f3;
                    double d4 = (f14 + 3.1415927f) - (f12 / 2.0f);
                    double d5 = i15 == 0 ? f9 : f10;
                    fArr[i11] = -((float) (Math.cos(d5) * Math.sin(d4) * d3));
                    fArr[i11 + 1] = (float) (d3 * Math.sin(d5));
                    int i17 = i11 + 3;
                    fArr[i11 + 2] = (float) (d3 * Math.cos(d4) * Math.cos(d5));
                    fArr2[i12] = f14 / f12;
                    int i18 = i12 + 2;
                    fArr2[i12 + 1] = ((i10 + i15) * f13) / f11;
                    if ((i14 == 0 && i15 == 0) || (i14 == i4 && i15 == 1)) {
                        System.arraycopy(fArr, i11, fArr, i17, 3);
                        i11 += 6;
                        i6 = 2;
                        System.arraycopy(fArr2, i12, fArr2, i18, 2);
                        i12 += 4;
                    } else {
                        i6 = 2;
                        i11 = i17;
                        i12 = i18;
                    }
                    i15++;
                    i16 = i6;
                    f6 = f13;
                    f7 = f15;
                    f9 = f16;
                }
                i14++;
                radians2 = f12;
                radians = f11;
                f6 = f6;
            }
            i7 = i3;
            i10 = i13;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr, fArr2, 1)), i5);
    }

    public static Projection b(int i3) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i3);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i3) {
        this.f45927a = mesh;
        this.f45928b = mesh2;
        this.f45929c = i3;
        this.f45930d = mesh == mesh2;
    }
}
