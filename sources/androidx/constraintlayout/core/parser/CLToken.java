package androidx.constraintlayout.core.parser;

import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLToken extends CLElement {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f31928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Type f31929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    char[] f31930i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    char[] f31931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    char[] f31932k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.f31928g = 0;
        this.f31929h = Type.UNKNOWN;
        this.f31930i = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.toCharArray();
        this.f31931j = "false".toCharArray();
        this.f31932k = "null".toCharArray();
    }

    public static CLElement z(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean A(char c3, long j3) {
        int iOrdinal = this.f31929h.ordinal();
        if (iOrdinal == 0) {
            char[] cArr = this.f31930i;
            int i3 = this.f31928g;
            if (cArr[i3] == c3) {
                this.f31929h = Type.TRUE;
            } else if (this.f31931j[i3] == c3) {
                this.f31929h = Type.FALSE;
            } else if (this.f31932k[i3] == c3) {
                this.f31929h = Type.NULL;
            }
            z = true;
        } else if (iOrdinal == 1) {
            char[] cArr2 = this.f31930i;
            int i4 = this.f31928g;
            z = cArr2[i4] == c3;
            if (z && i4 + 1 == cArr2.length) {
                v(j3);
            }
        } else if (iOrdinal == 2) {
            char[] cArr3 = this.f31931j;
            int i5 = this.f31928g;
            z = cArr3[i5] == c3;
            if (z && i5 + 1 == cArr3.length) {
                v(j3);
            }
        } else if (iOrdinal == 3) {
            char[] cArr4 = this.f31932k;
            int i6 = this.f31928g;
            z = cArr4[i6] == c3;
            if (z && i6 + 1 == cArr4.length) {
                v(j3);
            }
        }
        this.f31928g++;
        return z;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String y() {
        if (!CLParser.f31913d) {
            return b();
        }
        return "<" + b() + ">";
    }
}
