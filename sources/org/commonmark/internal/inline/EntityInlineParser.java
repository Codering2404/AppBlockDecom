package org.commonmark.internal.inline;

import org.commonmark.internal.util.AsciiMatcher;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.node.Text;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class EntityInlineParser implements InlineContentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AsciiMatcher f145475a = AsciiMatcher.b().d('0', '9').d('A', 'F').d('a', 'f').b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AsciiMatcher f145476b = AsciiMatcher.b().d('0', '9').b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AsciiMatcher f145477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AsciiMatcher f145478d;

    static {
        AsciiMatcher asciiMatcherB = AsciiMatcher.b().d('A', 'Z').d('a', 'z').b();
        f145477c = asciiMatcherB;
        f145478d = asciiMatcherB.c().d('0', '9').b();
    }

    private ParsedInline b(Scanner scanner, Position position) {
        return ParsedInline.b(new Text(Html5Entities.a(scanner.d(position, scanner.o()).c())), scanner.o());
    }

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline a(InlineParserState inlineParserState) {
        Scanner scannerB = inlineParserState.b();
        Position positionO = scannerB.o();
        scannerB.h();
        char cL = scannerB.l();
        if (cL == '#') {
            scannerB.h();
            if (scannerB.i('x') || scannerB.i('X')) {
                int iF = scannerB.f(f145475a);
                if (1 <= iF && iF <= 6 && scannerB.i(';')) {
                    return b(scannerB, positionO);
                }
            } else {
                int iF2 = scannerB.f(f145476b);
                if (1 <= iF2 && iF2 <= 7 && scannerB.i(';')) {
                    return b(scannerB, positionO);
                }
            }
        } else if (f145477c.a(cL)) {
            scannerB.f(f145478d);
            if (scannerB.i(';')) {
                return b(scannerB, positionO);
            }
        }
        return ParsedInline.a();
    }
}
