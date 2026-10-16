package ru.noties.markwon.html.jsoup.parser;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import ru.noties.markwon.html.jsoup.UncheckedIOException;
import ru.noties.markwon.html.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CharacterReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f147226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reader f147227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f147228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f147229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f147230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f147231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f147232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String[] f147233h;

    public CharacterReader(Reader reader, int i3) {
        this.f147233h = new String[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
        Validate.f(reader);
        Validate.d(reader.markSupported());
        this.f147227b = reader;
        this.f147226a = new char[4096];
        b();
    }

    static boolean G(char[] cArr, int i3, int i4, String str) {
        if (i4 != str.length()) {
            return false;
        }
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 == 0) {
                return true;
            }
            int i7 = i3 + 1;
            int i8 = i5 + 1;
            if (cArr[i3] != str.charAt(i5)) {
                return false;
            }
            i3 = i7;
            i4 = i6;
            i5 = i8;
        }
    }

    private void b() {
        int i3 = this.f147230e;
        if (i3 < this.f147229d) {
            return;
        }
        try {
            this.f147227b.skip(i3);
            this.f147227b.mark(4096);
            int i4 = this.f147227b.read(this.f147226a);
            this.f147227b.reset();
            if (i4 != -1) {
                this.f147228c = i4;
                this.f147231f += this.f147230e;
                this.f147230e = 0;
                this.f147232g = 0;
                if (i4 > 3072) {
                    i4 = 3072;
                }
                this.f147229d = i4;
            }
        } catch (IOException e3) {
            throw new UncheckedIOException(e3);
        }
    }

    private static String c(char[] cArr, String[] strArr, int i3, int i4) {
        if (i4 > 12) {
            return new String(cArr, i3, i4);
        }
        if (i4 < 1) {
            return "";
        }
        int i5 = 0;
        int i6 = i3;
        int i7 = 0;
        while (i5 < i4) {
            i7 = (i7 * 31) + cArr[i6];
            i5++;
            i6++;
        }
        int length = i7 & (strArr.length - 1);
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i3, i4);
            strArr[length] = str2;
            return str2;
        }
        if (G(cArr, i3, i4, str)) {
            return str;
        }
        String str3 = new String(cArr, i3, i4);
        strArr[length] = str3;
        return str3;
    }

    private boolean s() {
        return this.f147230e >= this.f147228c;
    }

    boolean A() {
        char c3;
        return !r() && (c3 = this.f147226a[this.f147230e]) >= '0' && c3 <= '9';
    }

    boolean B(String str) {
        b();
        int length = str.length();
        if (length > this.f147228c - this.f147230e) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (Character.toUpperCase(str.charAt(i3)) != Character.toUpperCase(this.f147226a[this.f147230e + i3])) {
                return false;
            }
        }
        return true;
    }

    boolean C() {
        if (r()) {
            return false;
        }
        char c3 = this.f147226a[this.f147230e];
        if (c3 < 'A' || c3 > 'Z') {
            return (c3 >= 'a' && c3 <= 'z') || Character.isLetter(c3);
        }
        return true;
    }

    int D(char c3) {
        b();
        for (int i3 = this.f147230e; i3 < this.f147228c; i3++) {
            if (c3 == this.f147226a[i3]) {
                return i3 - this.f147230e;
            }
        }
        return -1;
    }

    int E(CharSequence charSequence) {
        b();
        char cCharAt = charSequence.charAt(0);
        int i3 = this.f147230e;
        while (i3 < this.f147228c) {
            if (cCharAt != this.f147226a[i3]) {
                do {
                    i3++;
                    if (i3 >= this.f147228c) {
                        break;
                    }
                } while (cCharAt != this.f147226a[i3]);
            }
            int i4 = i3 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.f147228c;
            if (i3 < i5 && length <= i5) {
                int i6 = i4;
                for (int i7 = 1; i6 < length && charSequence.charAt(i7) == this.f147226a[i6]; i7++) {
                    i6++;
                }
                if (i6 == length) {
                    return i3 - this.f147230e;
                }
            }
            i3 = i4;
        }
        return -1;
    }

    public int F() {
        return this.f147231f + this.f147230e;
    }

    void H() {
        this.f147230e = this.f147232g;
    }

    void I() {
        this.f147230e--;
    }

    public void a() {
        this.f147230e++;
    }

    char d() {
        b();
        char c3 = s() ? (char) 65535 : this.f147226a[this.f147230e];
        this.f147230e++;
        return c3;
    }

    String e() {
        int i3;
        char c3;
        b();
        int i4 = this.f147230e;
        int i5 = this.f147228c;
        char[] cArr = this.f147226a;
        while (true) {
            i3 = this.f147230e;
            if (i3 >= i5 || (c3 = cArr[i3]) == '&' || c3 == '<' || c3 == 0) {
                break;
            }
            this.f147230e = i3 + 1;
        }
        return i3 > i4 ? c(this.f147226a, this.f147233h, i4, i3 - i4) : "";
    }

    String f() {
        int i3;
        char c3;
        b();
        int i4 = this.f147230e;
        while (true) {
            i3 = this.f147230e;
            if (i3 >= this.f147228c || (c3 = this.f147226a[i3]) < '0' || c3 > '9') {
                break;
            }
            this.f147230e = i3 + 1;
        }
        return c(this.f147226a, this.f147233h, i4, i3 - i4);
    }

    String g() {
        int i3;
        char c3;
        b();
        int i4 = this.f147230e;
        while (true) {
            i3 = this.f147230e;
            if (i3 >= this.f147228c || (((c3 = this.f147226a[i3]) < '0' || c3 > '9') && ((c3 < 'A' || c3 > 'F') && (c3 < 'a' || c3 > 'f')))) {
                break;
            }
            this.f147230e = i3 + 1;
        }
        return c(this.f147226a, this.f147233h, i4, i3 - i4);
    }

    String h() {
        char c3;
        b();
        int i3 = this.f147230e;
        while (true) {
            int i4 = this.f147230e;
            if (i4 >= this.f147228c || (((c3 = this.f147226a[i4]) < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !Character.isLetter(c3)))) {
                break;
            }
            this.f147230e++;
        }
        return c(this.f147226a, this.f147233h, i3, this.f147230e - i3);
    }

    String i() {
        char c3;
        b();
        int i3 = this.f147230e;
        while (true) {
            int i4 = this.f147230e;
            if (i4 >= this.f147228c || (((c3 = this.f147226a[i4]) < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !Character.isLetter(c3)))) {
                break;
            }
            this.f147230e++;
        }
        while (!s()) {
            char[] cArr = this.f147226a;
            int i5 = this.f147230e;
            char c4 = cArr[i5];
            if (c4 < '0' || c4 > '9') {
                break;
            }
            this.f147230e = i5 + 1;
        }
        return c(this.f147226a, this.f147233h, i3, this.f147230e - i3);
    }

    String j() {
        int i3;
        char c3;
        b();
        int i4 = this.f147230e;
        int i5 = this.f147228c;
        char[] cArr = this.f147226a;
        while (true) {
            i3 = this.f147230e;
            if (i3 >= i5 || (c3 = cArr[i3]) == '\t' || c3 == '\n' || c3 == '\r' || c3 == '\f' || c3 == ' ' || c3 == '/' || c3 == '>' || c3 == 0) {
                break;
            }
            this.f147230e = i3 + 1;
        }
        return i3 > i4 ? c(this.f147226a, this.f147233h, i4, i3 - i4) : "";
    }

    public String k(char c3) {
        int iD = D(c3);
        if (iD == -1) {
            return o();
        }
        String strC = c(this.f147226a, this.f147233h, this.f147230e, iD);
        this.f147230e += iD;
        return strC;
    }

    String l(String str) {
        int iE = E(str);
        if (iE == -1) {
            return o();
        }
        String strC = c(this.f147226a, this.f147233h, this.f147230e, iE);
        this.f147230e += iE;
        return strC;
    }

    public String m(char... cArr) {
        b();
        int i3 = this.f147230e;
        int i4 = this.f147228c;
        char[] cArr2 = this.f147226a;
        loop0: while (this.f147230e < i4) {
            for (char c3 : cArr) {
                if (cArr2[this.f147230e] == c3) {
                    break loop0;
                }
            }
            this.f147230e++;
        }
        int i5 = this.f147230e;
        return i5 > i3 ? c(this.f147226a, this.f147233h, i3, i5 - i3) : "";
    }

    String n(char... cArr) {
        b();
        int i3 = this.f147230e;
        int i4 = this.f147228c;
        char[] cArr2 = this.f147226a;
        while (true) {
            int i5 = this.f147230e;
            if (i5 >= i4 || Arrays.binarySearch(cArr, cArr2[i5]) >= 0) {
                break;
            }
            this.f147230e++;
        }
        int i6 = this.f147230e;
        return i6 > i3 ? c(this.f147226a, this.f147233h, i3, i6 - i3) : "";
    }

    String o() {
        b();
        char[] cArr = this.f147226a;
        String[] strArr = this.f147233h;
        int i3 = this.f147230e;
        String strC = c(cArr, strArr, i3, this.f147228c - i3);
        this.f147230e = this.f147228c;
        return strC;
    }

    boolean p(String str) {
        Locale locale = Locale.ENGLISH;
        return E(str.toLowerCase(locale)) > -1 || E(str.toUpperCase(locale)) > -1;
    }

    public char q() {
        b();
        if (s()) {
            return (char) 65535;
        }
        return this.f147226a[this.f147230e];
    }

    public boolean r() {
        b();
        return this.f147230e >= this.f147228c;
    }

    void t() {
        this.f147232g = this.f147230e;
    }

    public String toString() {
        char[] cArr = this.f147226a;
        int i3 = this.f147230e;
        return new String(cArr, i3, this.f147228c - i3);
    }

    boolean u(String str) {
        b();
        if (!x(str)) {
            return false;
        }
        this.f147230e += str.length();
        return true;
    }

    boolean v(String str) {
        if (!B(str)) {
            return false;
        }
        this.f147230e += str.length();
        return true;
    }

    boolean w(char c3) {
        return !r() && this.f147226a[this.f147230e] == c3;
    }

    boolean x(String str) {
        b();
        int length = str.length();
        if (length > this.f147228c - this.f147230e) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) != this.f147226a[this.f147230e + i3]) {
                return false;
            }
        }
        return true;
    }

    boolean y(char... cArr) {
        if (r()) {
            return false;
        }
        b();
        char c3 = this.f147226a[this.f147230e];
        for (char c4 : cArr) {
            if (c4 == c3) {
                return true;
            }
        }
        return false;
    }

    boolean z(char[] cArr) {
        b();
        return !r() && Arrays.binarySearch(cArr, this.f147226a[this.f147230e]) >= 0;
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }
}
