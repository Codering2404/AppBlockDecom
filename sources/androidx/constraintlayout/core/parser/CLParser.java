package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CLParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f31913d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31915b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f31916c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.f31914a = str;
    }

    private CLElement a(CLElement cLElement, int i3, TYPE type, boolean z2, char[] cArr) {
        CLElement cLElementA0;
        if (f31913d) {
            System.out.println("CREATE " + type + " at " + cArr[i3]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElementA0 = CLObject.a0(cArr);
                i3++;
                break;
            case 2:
                cLElementA0 = CLArray.a0(cArr);
                i3++;
                break;
            case 3:
                cLElementA0 = CLNumber.z(cArr);
                break;
            case 4:
                cLElementA0 = CLString.z(cArr);
                break;
            case 5:
                cLElementA0 = CLKey.b0(cArr);
                break;
            case 6:
                cLElementA0 = CLToken.z(cArr);
                break;
            default:
                cLElementA0 = null;
                break;
        }
        if (cLElementA0 == null) {
            return null;
        }
        cLElementA0.w(this.f31916c);
        if (z2) {
            cLElementA0.x(i3);
        }
        if (cLElement instanceof CLContainer) {
            cLElementA0.u((CLContainer) cLElement);
        }
        return cLElementA0;
    }

    private CLElement b(int i3, char c3, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c3 != '\t' && c3 != '\n' && c3 != '\r' && c3 != ' ') {
            if (c3 == '\"' || c3 == '\'') {
                return cLElement instanceof CLObject ? a(cLElement, i3, TYPE.KEY, true, cArr) : a(cLElement, i3, TYPE.STRING, true, cArr);
            }
            if (c3 == '[') {
                return a(cLElement, i3, TYPE.ARRAY, true, cArr);
            }
            if (c3 != ']') {
                if (c3 == '{') {
                    return a(cLElement, i3, TYPE.OBJECT, true, cArr);
                }
                if (c3 != '}') {
                    switch (c3) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return a(cLElement, i3, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i4 = i3 + 1;
                            if (i4 >= cArr.length || cArr[i4] != '/') {
                                return cLElement;
                            }
                            this.f31915b = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return a(cLElement, i3, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementA = a(cLElement, i3, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementA;
                            if (cLToken.A(c3, i3)) {
                                return cLElementA;
                            }
                            throw new CLParsingException("incorrect token <" + c3 + "> at line " + this.f31916c, cLToken);
                    }
                }
            }
            cLElement.v(i3 - 1);
            CLElement cLElementE = cLElement.e();
            cLElementE.v(i3);
            return cLElementE;
        }
        return cLElement;
    }

    public static CLObject d(String str) {
        return new CLParser(str).c();
    }

    public CLObject c() throws CLParsingException {
        int i3;
        char[] charArray = this.f31914a.toCharArray();
        int length = charArray.length;
        int i4 = 1;
        this.f31916c = 1;
        boolean z2 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            char c3 = charArray[i5];
            if (c3 == '{') {
                break;
            }
            if (c3 == '\n') {
                this.f31916c++;
            }
            i5++;
        }
        if (i5 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectA0 = CLObject.a0(charArray);
        cLObjectA0.w(this.f31916c);
        cLObjectA0.x(i5);
        int i6 = i5 + 1;
        CLElement cLElementE = cLObjectA0;
        while (i6 < length) {
            char c4 = charArray[i6];
            if (c4 == '\n') {
                this.f31916c += i4;
            }
            if (this.f31915b) {
                if (c4 == '\n') {
                    this.f31915b = z2;
                } else {
                    i3 = i4;
                    i6++;
                    i4 = i3;
                    z2 = false;
                }
            }
            if (cLElementE == null) {
                break;
            }
            if (cLElementE.t()) {
                cLElementE = b(i6, c4, cLElementE, charArray);
            } else if (cLElementE instanceof CLObject) {
                if (c4 == '}') {
                    cLElementE.v(i6 - 1);
                } else {
                    cLElementE = b(i6, c4, cLElementE, charArray);
                }
            } else if (!(cLElementE instanceof CLArray)) {
                boolean z3 = cLElementE instanceof CLString;
                if (z3) {
                    long j3 = cLElementE.f31905b;
                    if (charArray[(int) j3] == c4) {
                        cLElementE.x(j3 + 1);
                        cLElementE.v(i6 - 1);
                    }
                } else {
                    if (cLElementE instanceof CLToken) {
                        CLToken cLToken = (CLToken) cLElementE;
                        i3 = i4;
                        if (!cLToken.A(c4, i6)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.b() + " at line " + this.f31916c, cLToken);
                        }
                    } else {
                        i3 = i4;
                    }
                    if ((cLElementE instanceof CLKey) || z3) {
                        long j4 = cLElementE.f31905b;
                        char c5 = charArray[(int) j4];
                        if ((c5 == '\'' || c5 == '\"') && c5 == c4) {
                            cLElementE.x(j4 + 1);
                            cLElementE.v(i6 - 1);
                        }
                    }
                    if (!cLElementE.t() && (c4 == '}' || c4 == ']' || c4 == ',' || c4 == ' ' || c4 == '\t' || c4 == '\r' || c4 == '\n' || c4 == ':')) {
                        long j5 = i6 - 1;
                        cLElementE.v(j5);
                        if (c4 == '}' || c4 == ']') {
                            cLElementE = cLElementE.e();
                            cLElementE.v(j5);
                            if (cLElementE instanceof CLKey) {
                                cLElementE = cLElementE.e();
                                cLElementE.v(j5);
                            }
                        }
                    }
                    if (!cLElementE.t() && (!(cLElementE instanceof CLKey) || ((CLKey) cLElementE).f31903g.size() > 0)) {
                        cLElementE = cLElementE.e();
                    }
                    i6++;
                    i4 = i3;
                    z2 = false;
                }
            } else if (c4 == ']') {
                cLElementE.v(i6 - 1);
            } else {
                cLElementE = b(i6, c4, cLElementE, charArray);
            }
            i3 = i4;
            if (!cLElementE.t()) {
            }
            i6++;
            i4 = i3;
            z2 = false;
        }
        while (cLElementE != null && !cLElementE.t()) {
            if (cLElementE instanceof CLString) {
                cLElementE.x(((int) cLElementE.f31905b) + 1);
            }
            cLElementE.v(length - 1);
            cLElementE = cLElementE.e();
        }
        if (f31913d) {
            System.out.println("Root: " + cLObjectA0.y());
        }
        return cLObjectA0;
    }
}
