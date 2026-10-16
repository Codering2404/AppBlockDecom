package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLKey extends CLContainer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ArrayList f31909h;

    static {
        ArrayList arrayList = new ArrayList();
        f31909h = arrayList;
        arrayList.add("ConstraintSets");
        f31909h.add("Variables");
        f31909h.add("Generate");
        f31909h.add("Transitions");
        f31909h.add("KeyFrames");
        f31909h.add("KeyAttributes");
        f31909h.add("KeyPositions");
        f31909h.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement a0(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.x(0L);
        cLKey.v(str.length() - 1);
        cLKey.f0(cLElement);
        return cLKey;
    }

    public static CLElement b0(char[] cArr) {
        return new CLKey(cArr);
    }

    public String c0() {
        return b();
    }

    public CLElement d0() {
        if (this.f31903g.size() > 0) {
            return (CLElement) this.f31903g.get(0);
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLKey) || Objects.equals(c0(), ((CLKey) obj).c0())) {
            return super.equals(obj);
        }
        return false;
    }

    public void f0(CLElement cLElement) {
        if (this.f31903g.size() > 0) {
            this.f31903g.set(0, cLElement);
        } else {
            this.f31903g.add(cLElement);
        }
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String y() {
        if (this.f31903g.size() <= 0) {
            return g() + b() + ": <> ";
        }
        return g() + b() + ": " + ((CLElement) this.f31903g.get(0)).y();
    }
}
