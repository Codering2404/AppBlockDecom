package org.commonmark.internal.inline;

import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import org.commonmark.parser.SourceLines;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AutolinkInlineParser implements InlineContentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f145471a = Pattern.compile("^[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f145472b = Pattern.compile("^([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)$");

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline a(InlineParserState inlineParserState) {
        String str;
        Scanner scannerB = inlineParserState.b();
        scannerB.h();
        Position positionO = scannerB.o();
        if (scannerB.b('>') > 0) {
            SourceLines sourceLinesD = scannerB.d(positionO, scannerB.o());
            String strC = sourceLinesD.c();
            scannerB.h();
            if (f145471a.matcher(strC).matches()) {
                str = strC;
            } else if (f145472b.matcher(strC).matches()) {
                str = "mailto:" + strC;
            } else {
                str = null;
            }
            if (str != null) {
                Link link = new Link(str, null);
                Text text = new Text(strC);
                text.l(sourceLinesD.e());
                link.c(text);
                return ParsedInline.b(link, scannerB.o());
            }
        }
        return ParsedInline.a();
    }
}
