package org.commonmark.internal.inline;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class BackslashInlineParser implements InlineContentParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f145473a = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline a(InlineParserState inlineParserState) {
        Scanner scannerB = inlineParserState.b();
        scannerB.h();
        char cL = scannerB.l();
        if (cL == '\n') {
            scannerB.h();
            return ParsedInline.b(new HardLineBreak(), scannerB.o());
        }
        if (!f145473a.matcher(String.valueOf(cL)).matches()) {
            return ParsedInline.b(new Text("\\"), scannerB.o());
        }
        scannerB.h();
        return ParsedInline.b(new Text(String.valueOf(cL)), scannerB.o());
    }
}
