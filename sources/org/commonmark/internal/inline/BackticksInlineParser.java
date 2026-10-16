package org.commonmark.internal.inline;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.Text;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BackticksInlineParser implements InlineContentParser {
    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline a(InlineParserState inlineParserState) {
        Scanner scannerB = inlineParserState.b();
        Position positionO = scannerB.o();
        int iG = scannerB.g('`');
        Position positionO2 = scannerB.o();
        while (scannerB.b('`') > 0) {
            Position positionO3 = scannerB.o();
            if (scannerB.g('`') == iG) {
                Code code = new Code();
                String strReplace = scannerB.d(positionO2, positionO3).c().replace('\n', ' ');
                if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && Parsing.e(strReplace)) {
                    strReplace = strReplace.substring(1, strReplace.length() - 1);
                }
                code.p(strReplace);
                return ParsedInline.b(code, scannerB.o());
            }
        }
        return ParsedInline.b(new Text(scannerB.d(positionO, positionO2).c()), positionO2);
    }
}
