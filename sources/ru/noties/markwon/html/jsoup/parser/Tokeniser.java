package ru.noties.markwon.html.jsoup.parser;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import ru.noties.markwon.html.jsoup.helper.Validate;
import ru.noties.markwon.html.jsoup.nodes.CommonMarkEntities;
import ru.noties.markwon.html.jsoup.parser.Token;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Tokeniser {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final char[] f147262r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final int[] f147263s = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharacterReader f147264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParseErrorList f147265b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Token f147267d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Token.Tag f147272i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f147278o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TokeniserState f147266c = TokeniserState.Data;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f147268e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f147269f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StringBuilder f147270g = new StringBuilder(1024);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    StringBuilder f147271h = new StringBuilder(1024);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Token.StartTag f147273j = new Token.StartTag();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Token.EndTag f147274k = new Token.EndTag();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Token.Character f147275l = new Token.Character();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Token.Doctype f147276m = new Token.Doctype();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Token.Comment f147277n = new Token.Comment();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int[] f147279p = new int[1];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int[] f147280q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        f147262r = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.f147264a = characterReader;
        this.f147265b = parseErrorList;
    }

    private void c(String str) {
        if (this.f147265b.a()) {
            this.f147265b.add(new ParseError(this.f147264a.F(), "Invalid character reference: %s", str));
        }
    }

    void a(TokeniserState tokeniserState) {
        this.f147264a.a();
        this.f147266c = tokeniserState;
    }

    String b() {
        return this.f147278o;
    }

    int[] d(Character ch, boolean z2) {
        int iIntValue;
        if (this.f147264a.r()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.f147264a.q()) || this.f147264a.z(f147262r)) {
            return null;
        }
        int[] iArr = this.f147279p;
        this.f147264a.t();
        if (this.f147264a.u("#")) {
            boolean zV = this.f147264a.v("X");
            CharacterReader characterReader = this.f147264a;
            String strG = zV ? characterReader.g() : characterReader.f();
            if (strG.length() == 0) {
                c("numeric reference with no numerals");
                this.f147264a.H();
                return null;
            }
            if (!this.f147264a.u(";")) {
                c("missing semicolon");
            }
            try {
                iIntValue = Integer.valueOf(strG, zV ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = -1;
            }
            if (iIntValue == -1 || ((iIntValue >= 55296 && iIntValue <= 57343) || iIntValue > 1114111)) {
                c("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (iIntValue >= 128) {
                int[] iArr2 = f147263s;
                if (iIntValue < iArr2.length + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) {
                    c("character is not a valid unicode code point");
                    iIntValue = iArr2[iIntValue - 128];
                }
            }
            iArr[0] = iIntValue;
            return iArr;
        }
        String strI = this.f147264a.i();
        boolean zW = this.f147264a.w(';');
        if (!CommonMarkEntities.b(strI) || !zW) {
            this.f147264a.H();
            if (zW) {
                c(String.format("invalid named referenece '%s'", strI));
            }
            return null;
        }
        if (z2 && (this.f147264a.C() || this.f147264a.A() || this.f147264a.y('=', '-', '_'))) {
            this.f147264a.H();
            return null;
        }
        if (!this.f147264a.u(";")) {
            c("missing semicolon");
        }
        int iA = CommonMarkEntities.a(strI, this.f147280q);
        if (iA == 1) {
            iArr[0] = this.f147280q[0];
            return iArr;
        }
        if (iA == 2) {
            return this.f147280q;
        }
        Validate.a("Unexpected characters returned for " + strI);
        return this.f147280q;
    }

    void e() {
        this.f147277n.a();
    }

    void f() {
        this.f147276m.a();
    }

    Token.Tag g(boolean z2) {
        Token.Tag tagA = z2 ? this.f147273j.a() : this.f147274k.a();
        this.f147272i = tagA;
        return tagA;
    }

    void h() {
        Token.b(this.f147271h);
    }

    void i(char c3) {
        j(String.valueOf(c3));
    }

    void j(String str) {
        if (this.f147269f == null) {
            this.f147269f = str;
            return;
        }
        if (this.f147270g.length() == 0) {
            this.f147270g.append(this.f147269f);
        }
        this.f147270g.append(str);
    }

    void k(Token token) {
        Validate.c(this.f147268e, "There is an unread token pending!");
        this.f147267d = token;
        this.f147268e = true;
        Token.TokenType tokenType = token.f147237a;
        if (tokenType == Token.TokenType.StartTag) {
            this.f147278o = ((Token.StartTag) token).f147246b;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).f147254j == null) {
                return;
            }
            q("Attributes incorrectly present on end tag");
        }
    }

    void l(int[] iArr) {
        j(new String(iArr, 0, iArr.length));
    }

    void m() {
        k(this.f147277n);
    }

    void n() {
        k(this.f147276m);
    }

    void o() {
        this.f147272i.k();
        k(this.f147272i);
    }

    void p(TokeniserState tokeniserState) {
        if (this.f147265b.a()) {
            this.f147265b.add(new ParseError(this.f147264a.F(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    void q(String str) {
        if (this.f147265b.a()) {
            this.f147265b.add(new ParseError(this.f147264a.F(), str));
        }
    }

    void r(TokeniserState tokeniserState) {
        if (this.f147265b.a()) {
            this.f147265b.add(new ParseError(this.f147264a.F(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f147264a.q()), tokeniserState));
        }
    }

    boolean s() {
        return this.f147278o != null && this.f147272i.l().equalsIgnoreCase(this.f147278o);
    }

    public Token t() {
        while (!this.f147268e) {
            this.f147266c.i(this, this.f147264a);
        }
        if (this.f147270g.length() > 0) {
            String string = this.f147270g.toString();
            StringBuilder sb = this.f147270g;
            sb.delete(0, sb.length());
            this.f147269f = null;
            return this.f147275l.c(string);
        }
        String str = this.f147269f;
        if (str == null) {
            this.f147268e = false;
            return this.f147267d;
        }
        Token.Character characterC = this.f147275l.c(str);
        this.f147269f = null;
        return characterC;
    }

    void u(TokeniserState tokeniserState) {
        this.f147266c = tokeniserState;
    }
}
