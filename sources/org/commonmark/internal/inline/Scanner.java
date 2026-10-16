package org.commonmark.internal.inline;

import java.util.List;
import org.commonmark.internal.util.CharMatcher;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Scanner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f145489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SourceLine f145492d = SourceLine.c("", null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f145493e = 0;

    Scanner(List list, int i3, int i4) {
        this.f145489a = list;
        this.f145490b = i3;
        this.f145491c = i4;
        if (list.isEmpty()) {
            return;
        }
        a(i3, i4);
        p((SourceLine) list.get(i3));
    }

    private void a(int i3, int i4) {
        if (i3 < 0 || i3 >= this.f145489a.size()) {
            throw new IllegalArgumentException("Line index " + i3 + " out of range, number of lines: " + this.f145489a.size());
        }
        SourceLine sourceLine = (SourceLine) this.f145489a.get(i3);
        if (i4 < 0 || i4 > sourceLine.a().length()) {
            throw new IllegalArgumentException("Index " + i4 + " out of range, line length: " + sourceLine.a().length());
        }
    }

    public static Scanner k(SourceLines sourceLines) {
        return new Scanner(sourceLines.d(), 0, 0);
    }

    private void p(SourceLine sourceLine) {
        this.f145492d = sourceLine;
        this.f145493e = sourceLine.a().length();
    }

    public int b(char c3) {
        int i3 = 0;
        while (true) {
            char cL = l();
            if (cL == 0) {
                return -1;
            }
            if (cL == c3) {
                return i3;
            }
            i3++;
            h();
        }
    }

    public int c(CharMatcher charMatcher) {
        int i3 = 0;
        while (true) {
            char cL = l();
            if (cL == 0) {
                return -1;
            }
            if (charMatcher.a(cL)) {
                return i3;
            }
            i3++;
            h();
        }
    }

    public SourceLines d(Position position, Position position2) {
        int i3 = position.f145487a;
        if (i3 == position2.f145487a) {
            SourceLine sourceLine = (SourceLine) this.f145489a.get(i3);
            CharSequence charSequenceSubSequence = sourceLine.a().subSequence(position.f145488b, position2.f145488b);
            SourceSpan sourceSpanB = sourceLine.b();
            return SourceLines.h(SourceLine.c(charSequenceSubSequence, sourceSpanB != null ? SourceSpan.d(sourceSpanB.c(), sourceSpanB.a() + position.f145488b, charSequenceSubSequence.length()) : null));
        }
        SourceLines sourceLinesB = SourceLines.b();
        SourceLine sourceLine2 = (SourceLine) this.f145489a.get(position.f145487a);
        sourceLinesB.a(sourceLine2.d(position.f145488b, sourceLine2.a().length()));
        int i4 = position.f145487a;
        while (true) {
            i4++;
            int i5 = position2.f145487a;
            if (i4 >= i5) {
                sourceLinesB.a(((SourceLine) this.f145489a.get(i5)).d(0, position2.f145488b));
                return sourceLinesB;
            }
            sourceLinesB.a((SourceLine) this.f145489a.get(i4));
        }
    }

    public boolean e() {
        return this.f145491c < this.f145493e || this.f145490b < this.f145489a.size() - 1;
    }

    public int f(CharMatcher charMatcher) {
        int i3 = 0;
        while (charMatcher.a(l())) {
            i3++;
            h();
        }
        return i3;
    }

    public int g(char c3) {
        int i3 = 0;
        while (l() == c3) {
            i3++;
            h();
        }
        return i3;
    }

    public void h() {
        int i3 = this.f145491c + 1;
        this.f145491c = i3;
        if (i3 > this.f145493e) {
            int i4 = this.f145490b + 1;
            this.f145490b = i4;
            if (i4 < this.f145489a.size()) {
                p((SourceLine) this.f145489a.get(this.f145490b));
            } else {
                p(SourceLine.c("", null));
            }
            this.f145491c = 0;
        }
    }

    public boolean i(char c3) {
        if (l() != c3) {
            return false;
        }
        h();
        return true;
    }

    public boolean j(String str) {
        int i3 = this.f145491c;
        if (i3 >= this.f145493e || i3 + str.length() > this.f145493e) {
            return false;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (this.f145492d.a().charAt(this.f145491c + i4) != str.charAt(i4)) {
                return false;
            }
        }
        this.f145491c += str.length();
        return true;
    }

    public char l() {
        return this.f145491c < this.f145493e ? this.f145492d.a().charAt(this.f145491c) : this.f145490b < this.f145489a.size() + (-1) ? '\n' : (char) 0;
    }

    public int m() {
        if (this.f145491c >= this.f145493e) {
            return this.f145490b < this.f145489a.size() + (-1) ? 10 : 0;
        }
        char cCharAt = this.f145492d.a().charAt(this.f145491c);
        if (!Character.isHighSurrogate(cCharAt) || this.f145491c + 1 >= this.f145493e) {
            return cCharAt;
        }
        char cCharAt2 = this.f145492d.a().charAt(this.f145491c + 1);
        return Character.isLowSurrogate(cCharAt2) ? Character.toCodePoint(cCharAt, cCharAt2) : cCharAt;
    }

    public int n() {
        int i3 = this.f145491c;
        if (i3 <= 0) {
            return this.f145490b > 0 ? 10 : 0;
        }
        int i4 = i3 - 1;
        char cCharAt = this.f145492d.a().charAt(i4);
        if (Character.isLowSurrogate(cCharAt) && i4 > 0) {
            char cCharAt2 = this.f145492d.a().charAt(i3 - 2);
            if (Character.isHighSurrogate(cCharAt2)) {
                return Character.toCodePoint(cCharAt2, cCharAt);
            }
        }
        return cCharAt;
    }

    public Position o() {
        return new Position(this.f145490b, this.f145491c);
    }

    public void q(Position position) {
        a(position.f145487a, position.f145488b);
        int i3 = position.f145487a;
        this.f145490b = i3;
        this.f145491c = position.f145488b;
        p((SourceLine) this.f145489a.get(i3));
    }

    public int r() {
        int i3 = 0;
        while (true) {
            char cL = l();
            if (cL != ' ') {
                switch (cL) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        return i3;
                }
            }
            i3++;
            h();
        }
    }
}
