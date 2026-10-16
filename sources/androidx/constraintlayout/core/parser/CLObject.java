package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CLObjectIterator implements Iterator<CLKey> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CLObject f31911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31912b = 0;

        CLObjectIterator(CLObject cLObject) {
            this.f31911a = cLObject;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CLKey next() {
            CLKey cLKey = (CLKey) this.f31911a.f31903g.get(this.f31912b);
            this.f31912b++;
            return cLKey;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31912b < this.f31911a.size();
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject a0(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public CLObject clone() {
        return (CLObject) super.clone();
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String y() {
        StringBuilder sb = new StringBuilder(g() + "{ ");
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        boolean z2 = true;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLElement cLElement = (CLElement) obj;
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(cLElement.y());
        }
        sb.append(" }");
        return sb.toString();
    }
}
