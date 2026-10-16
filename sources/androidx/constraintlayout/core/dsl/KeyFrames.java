package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyFrames {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f31424a;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f31424a.isEmpty()) {
            sb.append("keyFrames:{\n");
            ArrayList arrayList = this.f31424a;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                sb.append(((Keys) obj).toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
