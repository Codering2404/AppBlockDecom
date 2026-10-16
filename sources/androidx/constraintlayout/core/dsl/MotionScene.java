package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionScene {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f31449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList f31450b;

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        int i3 = 0;
        if (!this.f31449a.isEmpty()) {
            sb.append("Transitions:{\n");
            ArrayList arrayList = this.f31449a;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                sb.append(((Transition) obj).toString());
            }
            sb.append("},\n");
        }
        if (!this.f31450b.isEmpty()) {
            sb.append("ConstraintSets:{\n");
            ArrayList arrayList2 = this.f31450b;
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                sb.append(((ConstraintSet) obj2).toString());
            }
            sb.append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
