package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f31337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList f31338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList f31339c;

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f31337a + ":{\n");
        int i3 = 0;
        if (!this.f31338b.isEmpty()) {
            ArrayList arrayList = this.f31338b;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                sb.append(((Constraint) obj).toString());
            }
        }
        if (!this.f31339c.isEmpty()) {
            ArrayList arrayList2 = this.f31339c;
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                sb.append(((Helper) obj2).toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }
}
