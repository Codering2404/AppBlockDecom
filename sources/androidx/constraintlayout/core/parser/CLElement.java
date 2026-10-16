package androidx.constraintlayout.core.parser;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLElement implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f31904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f31905b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f31906c = Long.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected CLContainer f31907d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31908f;

    public CLElement(char[] cArr) {
        this.f31904a = cArr;
    }

    @Override // 
    /* JADX INFO: renamed from: a */
    public CLElement clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public String b() {
        String str = new String(this.f31904a);
        if (str.length() < 1) {
            return "";
        }
        long j3 = this.f31906c;
        if (j3 != Long.MAX_VALUE) {
            long j4 = this.f31905b;
            if (j3 >= j4) {
                return str.substring((int) j4, ((int) j3) + 1);
            }
        }
        long j5 = this.f31905b;
        return str.substring((int) j5, ((int) j5) + 1);
    }

    public CLElement e() {
        return this.f31907d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        if (this.f31905b == cLElement.f31905b && this.f31906c == cLElement.f31906c && this.f31908f == cLElement.f31908f && Arrays.equals(this.f31904a, cLElement.f31904a)) {
            return Objects.equals(this.f31907d, cLElement.f31907d);
        }
        return false;
    }

    protected String g() {
        if (!CLParser.f31913d) {
            return "";
        }
        return q() + " -> ";
    }

    public float h() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).h();
        }
        return Float.NaN;
    }

    public int hashCode() {
        int iHashCode = Arrays.hashCode(this.f31904a) * 31;
        long j3 = this.f31905b;
        int i3 = (iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f31906c;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        CLContainer cLContainer = this.f31907d;
        return ((i4 + (cLContainer != null ? cLContainer.hashCode() : 0)) * 31) + this.f31908f;
    }

    public int o() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).o();
        }
        return 0;
    }

    public int p() {
        return this.f31908f;
    }

    protected String q() {
        String string = getClass().toString();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean s() {
        char[] cArr = this.f31904a;
        return cArr != null && cArr.length >= 1;
    }

    public boolean t() {
        return this.f31906c != Long.MAX_VALUE;
    }

    public String toString() {
        long j3 = this.f31905b;
        long j4 = this.f31906c;
        if (j3 > j4 || j4 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.f31905b + "-" + this.f31906c + ")";
        }
        return q() + " (" + this.f31905b + " : " + this.f31906c + ") <<" + new String(this.f31904a).substring((int) this.f31905b, ((int) this.f31906c) + 1) + ">>";
    }

    public void u(CLContainer cLContainer) {
        this.f31907d = cLContainer;
    }

    public void v(long j3) {
        if (this.f31906c != Long.MAX_VALUE) {
            return;
        }
        this.f31906c = j3;
        if (CLParser.f31913d) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.f31907d;
        if (cLContainer != null) {
            cLContainer.z(this);
        }
    }

    public void w(int i3) {
        this.f31908f = i3;
    }

    public void x(long j3) {
        this.f31905b = j3;
    }

    protected String y() {
        return "";
    }
}
