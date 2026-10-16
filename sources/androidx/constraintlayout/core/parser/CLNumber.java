package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLNumber extends CLElement {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f31910g;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.f31910g = Float.NaN;
    }

    public static CLElement z(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float fH = h();
            float fH2 = ((CLNumber) obj).h();
            if ((Float.isNaN(fH) && Float.isNaN(fH2)) || fH == fH2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float h() {
        if (Float.isNaN(this.f31910g) && s()) {
            this.f31910g = Float.parseFloat(b());
        }
        return this.f31910g;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        float f3 = this.f31910g;
        return iHashCode + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int o() {
        if (Float.isNaN(this.f31910g) && s()) {
            this.f31910g = Integer.parseInt(b());
        }
        return (int) this.f31910g;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String y() {
        float fH = h();
        int i3 = (int) fH;
        if (i3 == fH) {
            return "" + i3;
        }
        return "" + fH;
    }

    public CLNumber(float f3) {
        super(null);
        this.f31910g = f3;
    }
}
