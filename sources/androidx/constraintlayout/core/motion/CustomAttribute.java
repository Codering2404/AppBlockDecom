package androidx.constraintlayout.core.motion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CustomAttribute {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AttributeType f31512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f31514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f31515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31516e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public void a(float[] fArr) {
        switch (this.f31512a) {
            case INT_TYPE:
                fArr[0] = this.f31513b;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.f31514c;
                return;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i3 = (this.f31516e >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i3 / 255.0f;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case BOOLEAN_TYPE:
                fArr[0] = this.f31515d ? 1.0f : 0.0f;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.f31514c;
                return;
            default:
                return;
        }
    }

    public int b() {
        int iOrdinal = this.f31512a.ordinal();
        return (iOrdinal == 2 || iOrdinal == 3) ? 4 : 1;
    }
}
