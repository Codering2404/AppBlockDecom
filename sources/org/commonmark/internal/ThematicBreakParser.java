package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ThematicBreakParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThematicBreak f145470a = new ThematicBreak();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.d() >= 4) {
                return BlockStart.c();
            }
            int iE = parserState.e();
            CharSequence charSequenceA = parserState.c().a();
            return ThematicBreakParser.k(charSequenceA, iE) ? BlockStart.d(new ThematicBreakParser()).b(charSequenceA.length()) : BlockStart.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt != '\t' && cCharAt != ' ') {
                if (cCharAt == '*') {
                    i6++;
                } else if (cCharAt == '-') {
                    i4++;
                } else {
                    if (cCharAt != '_') {
                        return false;
                    }
                    i5++;
                }
            }
            i3++;
        }
        if (i4 >= 3 && i5 == 0 && i6 == 0) {
            return true;
        }
        if (i5 >= 3 && i4 == 0 && i6 == 0) {
            return true;
        }
        return i6 >= 3 && i4 == 0 && i5 == 0;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        return BlockContinue.d();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145470a;
    }
}
