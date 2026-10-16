package androidx.constraintlayout.core.motion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CustomVariable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f31530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f31531f;

    public CustomVariable(CustomVariable customVariable) {
        this.f31528c = Integer.MIN_VALUE;
        this.f31529d = Float.NaN;
        this.f31530e = null;
        this.f31526a = customVariable.f31526a;
        this.f31527b = customVariable.f31527b;
        this.f31528c = customVariable.f31528c;
        this.f31529d = customVariable.f31529d;
        this.f31530e = customVariable.f31530e;
        this.f31531f = customVariable.f31531f;
    }

    private static int a(int i3) {
        int i4 = (i3 & (~(i3 >> 31))) - 255;
        return (i4 & (i4 >> 31)) + 255;
    }

    public static String b(int i3) {
        return "#" + ("00000000" + Integer.toHexString(i3)).substring(r2.length() - 8);
    }

    public CustomVariable c() {
        return new CustomVariable(this);
    }

    public boolean d() {
        return this.f31531f;
    }

    public float e() {
        return this.f31529d;
    }

    public int f() {
        return this.f31528c;
    }

    public String g() {
        return this.f31526a;
    }

    public String h() {
        return this.f31530e;
    }

    public int i() {
        return this.f31527b;
    }

    public float j() {
        switch (this.f31527b) {
            case 900:
                return this.f31528c;
            case 901:
                return this.f31529d;
            case 902:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                return this.f31531f ? 1.0f : 0.0f;
            case 905:
                return this.f31529d;
            default:
                return Float.NaN;
        }
    }

    public void k(float[] fArr) {
        switch (this.f31527b) {
            case 900:
                fArr[0] = this.f31528c;
                return;
            case 901:
                fArr[0] = this.f31529d;
                return;
            case 902:
                int i3 = (this.f31528c >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i3 / 255.0f;
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                fArr[0] = this.f31531f ? 1.0f : 0.0f;
                return;
            case 905:
                fArr[0] = this.f31529d;
                return;
            default:
                return;
        }
    }

    public boolean l() {
        int i3 = this.f31527b;
        return (i3 == 903 || i3 == 904 || i3 == 906) ? false : true;
    }

    public int m() {
        return this.f31527b != 902 ? 1 : 4;
    }

    public void n(boolean z2) {
        this.f31531f = z2;
    }

    public void o(float f3) {
        this.f31529d = f3;
    }

    public void p(int i3) {
        this.f31528c = i3;
    }

    public void q(MotionWidget motionWidget, float[] fArr) {
        int i3 = this.f31527b;
        switch (i3) {
            case 900:
                motionWidget.H(this.f31526a, i3, (int) fArr[0]);
                return;
            case 901:
            case 905:
                motionWidget.G(this.f31526a, i3, fArr[0]);
                return;
            case 902:
                motionWidget.H(this.f31526a, this.f31527b, (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case 903:
            case 906:
                throw new RuntimeException("unable to interpolate " + this.f31526a);
            case 904:
                motionWidget.I(this.f31526a, i3, fArr[0] > 0.5f);
                return;
            default:
                return;
        }
    }

    public void r(Object obj) {
        switch (this.f31527b) {
            case 900:
            case 906:
                this.f31528c = ((Integer) obj).intValue();
                break;
            case 901:
                this.f31529d = ((Float) obj).floatValue();
                break;
            case 902:
                this.f31528c = ((Integer) obj).intValue();
                break;
            case 903:
                this.f31530e = (String) obj;
                break;
            case 904:
                this.f31531f = ((Boolean) obj).booleanValue();
                break;
            case 905:
                this.f31529d = ((Float) obj).floatValue();
                break;
        }
    }

    public void s(float[] fArr) {
        switch (this.f31527b) {
            case 900:
            case 906:
                this.f31528c = (int) fArr[0];
                return;
            case 901:
            case 905:
                this.f31529d = fArr[0];
                return;
            case 902:
                this.f31528c = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case 903:
                throw new RuntimeException("Cannot interpolate String");
            case 904:
                this.f31531f = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f31526a + ':';
        switch (this.f31527b) {
            case 900:
                return str + this.f31528c;
            case 901:
                return str + this.f31529d;
            case 902:
                return str + b(this.f31528c);
            case 903:
                return str + this.f31530e;
            case 904:
                return str + Boolean.valueOf(this.f31531f);
            case 905:
                return str + this.f31529d;
            default:
                return str + "????";
        }
    }

    public CustomVariable(String str, int i3, int i4) {
        this.f31528c = Integer.MIN_VALUE;
        this.f31529d = Float.NaN;
        this.f31530e = null;
        this.f31526a = str;
        this.f31527b = i3;
        if (i3 == 901) {
            this.f31529d = i4;
        } else {
            this.f31528c = i4;
        }
    }

    public CustomVariable(String str, int i3, float f3) {
        this.f31528c = Integer.MIN_VALUE;
        this.f31530e = null;
        this.f31526a = str;
        this.f31527b = i3;
        this.f31529d = f3;
    }

    public CustomVariable(String str, int i3, boolean z2) {
        this.f31528c = Integer.MIN_VALUE;
        this.f31529d = Float.NaN;
        this.f31530e = null;
        this.f31526a = str;
        this.f31527b = i3;
        this.f31531f = z2;
    }
}
