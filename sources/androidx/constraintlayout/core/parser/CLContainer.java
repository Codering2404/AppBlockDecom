package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLContainer extends CLElement {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f31903g;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.f31903g = new ArrayList();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public CLContainer clone() {
        CLContainer cLContainer = (CLContainer) super.clone();
        ArrayList arrayList = new ArrayList(this.f31903g.size());
        ArrayList arrayList2 = this.f31903g;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            CLElement cLElementClone = ((CLElement) obj).clone();
            cLElementClone.u(cLContainer);
            arrayList.add(cLElementClone);
        }
        cLContainer.f31903g = arrayList;
        return cLContainer;
    }

    public CLElement B(int i3) throws CLParsingException {
        if (i3 >= 0 && i3 < this.f31903g.size()) {
            return (CLElement) this.f31903g.get(i3);
        }
        throw new CLParsingException("no element at index " + i3, this);
    }

    public CLElement D(String str) throws CLParsingException {
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLKey cLKey = (CLKey) ((CLElement) obj);
            if (cLKey.b().equals(str)) {
                return cLKey.d0();
            }
        }
        throw new CLParsingException("no element for key <" + str + ">", this);
    }

    public CLArray E(String str) throws CLParsingException {
        CLElement cLElementD = D(str);
        if (cLElementD instanceof CLArray) {
            return (CLArray) cLElementD;
        }
        throw new CLParsingException("no array found for key <" + str + ">, found [" + cLElementD.q() + "] : " + cLElementD, this);
    }

    public CLArray G(String str) {
        CLElement cLElementO = O(str);
        if (cLElementO instanceof CLArray) {
            return (CLArray) cLElementO;
        }
        return null;
    }

    public float H(int i3) throws CLParsingException {
        CLElement cLElementB = B(i3);
        if (cLElementB != null) {
            return cLElementB.h();
        }
        throw new CLParsingException("no float at index " + i3, this);
    }

    public float I(String str) throws CLParsingException {
        CLElement cLElementD = D(str);
        if (cLElementD != null) {
            return cLElementD.h();
        }
        throw new CLParsingException("no float found for key <" + str + ">, found [" + cLElementD.q() + "] : " + cLElementD, this);
    }

    public float J(String str) {
        CLElement cLElementO = O(str);
        if (cLElementO instanceof CLNumber) {
            return cLElementO.h();
        }
        return Float.NaN;
    }

    public int K(String str) throws CLParsingException {
        CLElement cLElementD = D(str);
        if (cLElementD != null) {
            return cLElementD.o();
        }
        throw new CLParsingException("no int found for key <" + str + ">, found [" + cLElementD.q() + "] : " + cLElementD, this);
    }

    public CLObject L(String str) throws CLParsingException {
        CLElement cLElementD = D(str);
        if (cLElementD instanceof CLObject) {
            return (CLObject) cLElementD;
        }
        throw new CLParsingException("no object found for key <" + str + ">, found [" + cLElementD.q() + "] : " + cLElementD, this);
    }

    public CLObject M(String str) {
        CLElement cLElementO = O(str);
        if (cLElementO instanceof CLObject) {
            return (CLObject) cLElementO;
        }
        return null;
    }

    public CLElement N(int i3) {
        if (i3 < 0 || i3 >= this.f31903g.size()) {
            return null;
        }
        return (CLElement) this.f31903g.get(i3);
    }

    public CLElement O(String str) {
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLKey cLKey = (CLKey) ((CLElement) obj);
            if (cLKey.b().equals(str)) {
                return cLKey.d0();
            }
        }
        return null;
    }

    public String P(int i3) throws CLParsingException {
        CLElement cLElementB = B(i3);
        if (cLElementB instanceof CLString) {
            return cLElementB.b();
        }
        throw new CLParsingException("no string at index " + i3, this);
    }

    public String Q(String str) throws CLParsingException {
        CLElement cLElementD = D(str);
        if (cLElementD instanceof CLString) {
            return cLElementD.b();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cLElementD != null ? cLElementD.q() : null) + "] : " + cLElementD, this);
    }

    public String R(int i3) {
        CLElement cLElementN = N(i3);
        if (cLElementN instanceof CLString) {
            return cLElementN.b();
        }
        return null;
    }

    public String S(String str) {
        CLElement cLElementO = O(str);
        if (cLElementO instanceof CLString) {
            return cLElementO.b();
        }
        return null;
    }

    public boolean U(String str) {
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLElement cLElement = (CLElement) obj;
            if ((cLElement instanceof CLKey) && ((CLKey) cLElement).b().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList V() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f31903g;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            CLElement cLElement = (CLElement) obj;
            if (cLElement instanceof CLKey) {
                arrayList.add(((CLKey) cLElement).b());
            }
        }
        return arrayList;
    }

    public void W(String str, CLElement cLElement) {
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLKey cLKey = (CLKey) ((CLElement) obj);
            if (cLKey.b().equals(str)) {
                cLKey.f0(cLElement);
                return;
            }
        }
        this.f31903g.add((CLKey) CLKey.a0(str, cLElement));
    }

    public void X(String str, float f3) {
        W(str, new CLNumber(f3));
    }

    public void Y(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.x(0L);
        cLString.v(str2.length() - 1);
        W(str, cLString);
    }

    public void Z(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f31903g;
        int size = arrayList2.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList2.get(i4);
            i4++;
            CLElement cLElement = (CLElement) obj;
            if (((CLKey) cLElement).b().equals(str)) {
                arrayList.add(cLElement);
            }
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            this.f31903g.remove((CLElement) obj2);
        }
    }

    public void clear() {
        this.f31903g.clear();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLContainer) {
            return this.f31903g.equals(((CLContainer) obj).f31903g);
        }
        return false;
    }

    public int getInt(int i3) throws CLParsingException {
        CLElement cLElementB = B(i3);
        if (cLElementB != null) {
            return cLElementB.o();
        }
        throw new CLParsingException("no int at index " + i3, this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.f31903g, Integer.valueOf(super.hashCode()));
    }

    public int size() {
        return this.f31903g.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f31903g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            CLElement cLElement = (CLElement) obj;
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    public void z(CLElement cLElement) {
        this.f31903g.add(cLElement);
        if (CLParser.f31913d) {
            System.out.println("added element " + cLElement + " to " + this);
        }
    }
}
