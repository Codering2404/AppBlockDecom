package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement a0(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String y() {
        StringBuilder sb = new StringBuilder(g() + "[");
        boolean z2 = true;
        for (int i3 = 0; i3 < this.f31903g.size(); i3++) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(((CLElement) this.f31903g.get(i3)).y());
        }
        return ((Object) sb) + "]";
    }
}
