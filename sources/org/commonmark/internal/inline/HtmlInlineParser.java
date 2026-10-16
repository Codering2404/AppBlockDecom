package org.commonmark.internal.inline;

import org.commonmark.internal.util.AsciiMatcher;
import org.commonmark.node.HtmlInline;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlInlineParser implements InlineContentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AsciiMatcher f145479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AsciiMatcher f145480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AsciiMatcher f145481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AsciiMatcher f145482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AsciiMatcher f145483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AsciiMatcher f145484f;

    static {
        AsciiMatcher asciiMatcherB = AsciiMatcher.b().d('A', 'Z').d('a', 'z').b();
        f145479a = asciiMatcherB;
        f145480b = asciiMatcherB;
        f145481c = asciiMatcherB.c().d('0', '9').c('-').b();
        AsciiMatcher asciiMatcherB2 = asciiMatcherB.c().c('_').c(':').b();
        f145482d = asciiMatcherB2;
        f145483e = asciiMatcherB2.c().d('0', '9').c('.').c('-').b();
        f145484f = AsciiMatcher.b().c(' ').c('\t').c('\n').c((char) 11).c('\f').c('\r').c('\"').c('\'').c('=').c('<').c('>').c('`').b();
    }

    private static ParsedInline b(Position position, Scanner scanner) {
        String strC = scanner.d(position, scanner.o()).c();
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.p(strC);
        return ParsedInline.b(htmlInline, scanner.o());
    }

    private static boolean c(Scanner scanner) {
        scanner.h();
        if (!scanner.j("CDATA[")) {
            return false;
        }
        while (scanner.b(']') >= 0) {
            if (scanner.j("]]>")) {
                return true;
            }
            scanner.h();
        }
        return false;
    }

    private static boolean d(Scanner scanner) {
        scanner.h();
        if (scanner.f(f145480b) < 1) {
            return false;
        }
        scanner.f(f145481c);
        scanner.r();
        return scanner.i('>');
    }

    private static boolean e(Scanner scanner) {
        scanner.h();
        if (scanner.i('-') && !scanner.i('>') && !scanner.j("->")) {
            while (scanner.b('-') >= 0) {
                if (scanner.j("--")) {
                    return scanner.i('>');
                }
                scanner.h();
            }
        }
        return false;
    }

    private static boolean f(Scanner scanner) {
        scanner.f(f145479a);
        if (scanner.r() <= 0 || scanner.b('>') < 0) {
            return false;
        }
        scanner.h();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r4.r() < 1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r4.i('=') == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        r4.r();
        r0 = r4.l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r0 != '\'') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        r4.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r4.b('\'') >= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r4.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (r0 != '\"') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r4.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r4.b('\"') >= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        r4.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r4.c(org.commonmark.internal.inline.HtmlInlineParser.f145484f) > 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r4.r() < 1) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r4.i('/');
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        return r4.i('>');
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0013, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
    
        if (r4.r() >= 1) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r4.f(org.commonmark.internal.inline.HtmlInlineParser.f145482d) < 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r4.f(org.commonmark.internal.inline.HtmlInlineParser.f145483e);
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:4:0x0010). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean g(org.commonmark.internal.inline.Scanner r4) {
        /*
            r4.h()
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.f145481c
            r4.f(r0)
            int r0 = r4.r()
            r1 = 0
            r2 = 1
            if (r0 < r2) goto L12
        L10:
            r0 = r2
            goto L13
        L12:
            r0 = r1
        L13:
            if (r0 == 0) goto L6e
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.f145482d
            int r0 = r4.f(r0)
            if (r0 < r2) goto L6e
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.f145483e
            r4.f(r0)
            int r0 = r4.r()
            if (r0 < r2) goto L2a
            r0 = r2
            goto L2b
        L2a:
            r0 = r1
        L2b:
            r3 = 61
            boolean r3 = r4.i(r3)
            if (r3 == 0) goto L13
            r4.r()
            char r0 = r4.l()
            r3 = 39
            if (r0 != r3) goto L4c
            r4.h()
            int r0 = r4.b(r3)
            if (r0 >= 0) goto L48
            return r1
        L48:
            r4.h()
            goto L67
        L4c:
            r3 = 34
            if (r0 != r3) goto L5e
            r4.h()
            int r0 = r4.b(r3)
            if (r0 >= 0) goto L5a
            return r1
        L5a:
            r4.h()
            goto L67
        L5e:
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.f145484f
            int r0 = r4.c(r0)
            if (r0 > 0) goto L67
            return r1
        L67:
            int r0 = r4.r()
            if (r0 < r2) goto L12
            goto L10
        L6e:
            r0 = 47
            r4.i(r0)
            r0 = 62
            boolean r4 = r4.i(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.inline.HtmlInlineParser.g(org.commonmark.internal.inline.Scanner):boolean");
    }

    private static boolean h(Scanner scanner) {
        scanner.h();
        while (scanner.b('?') > 0) {
            scanner.h();
            if (scanner.i('>')) {
                return true;
            }
        }
        return false;
    }

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline a(InlineParserState inlineParserState) {
        Scanner scannerB = inlineParserState.b();
        Position positionO = scannerB.o();
        scannerB.h();
        char cL = scannerB.l();
        if (f145480b.a(cL)) {
            if (g(scannerB)) {
                return b(positionO, scannerB);
            }
        } else if (cL == '/') {
            if (d(scannerB)) {
                return b(positionO, scannerB);
            }
        } else if (cL == '?') {
            if (h(scannerB)) {
                return b(positionO, scannerB);
            }
        } else if (cL == '!') {
            scannerB.h();
            char cL2 = scannerB.l();
            if (cL2 == '-') {
                if (e(scannerB)) {
                    return b(positionO, scannerB);
                }
            } else if (cL2 == '[') {
                if (c(scannerB)) {
                    return b(positionO, scannerB);
                }
            } else if (f145479a.a(cL2) && f(scannerB)) {
                return b(positionO, scannerB);
            }
        }
        return ParsedInline.a();
    }
}
