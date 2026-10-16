package androidx.constraintlayout.core.parser;

import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class CLString extends CLElement {
    public CLString(char[] cArr) {
        super(cArr);
    }

    public static CLString A(String str) {
        CLString cLString = new CLString(str.toCharArray());
        cLString.x(0L);
        cLString.v(str.length() - 1);
        return cLString;
    }

    public static CLElement z(char[] cArr) {
        return new CLString(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CLString) && b().equals(((CLString) obj).b())) {
            return true;
        }
        return super.equals(obj);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String y() {
        StringBuilder sb = new StringBuilder();
        String str = KrzujOtzIk.PHPG;
        sb.append(str);
        sb.append(b());
        sb.append(str);
        return sb.toString();
    }
}
