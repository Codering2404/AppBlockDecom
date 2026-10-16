package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ListBlockParser extends AbstractBlockParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListBlock f145455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f145456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f145457c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart a(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser blockParserA = matchedBlockParser.a();
            if (parserState.d() >= Parsing.f145510a) {
                return BlockStart.c();
            }
            ListData listDataO = ListBlockParser.o(parserState.c().a(), parserState.e(), parserState.b() + parserState.d(), !matchedBlockParser.b().f());
            if (listDataO == null) {
                return BlockStart.c();
            }
            int i3 = listDataO.f145459b;
            ListItemParser listItemParser = new ListItemParser(i3 - parserState.b());
            if ((blockParserA instanceof ListBlockParser) && ListBlockParser.n((ListBlock) blockParserA.e(), listDataO.f145458a)) {
                return BlockStart.d(listItemParser).a(i3);
            }
            ListBlockParser listBlockParser = new ListBlockParser(listDataO.f145458a);
            listDataO.f145458a.q(true);
            return BlockStart.d(listBlockParser, listItemParser).a(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ListData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ListBlock f145458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f145459b;

        ListData(ListBlock listBlock, int i3) {
            this.f145458a = listBlock;
            this.f145459b = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ListMarkerData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ListBlock f145460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f145461b;

        ListMarkerData(ListBlock listBlock, int i3) {
            this.f145460a = listBlock;
            this.f145461b = i3;
        }
    }

    public ListBlockParser(ListBlock listBlock) {
        this.f145455a = listBlock;
    }

    private static boolean l(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean m(CharSequence charSequence, int i3) {
        char cCharAt;
        return i3 >= charSequence.length() || (cCharAt = charSequence.charAt(i3)) == '\t' || cCharAt == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return l(Character.valueOf(((BulletList) listBlock).r()), Character.valueOf(((BulletList) listBlock2).r()));
        }
        if ((listBlock instanceof OrderedList) && (listBlock2 instanceof OrderedList)) {
            return l(Character.valueOf(((OrderedList) listBlock).r()), Character.valueOf(((OrderedList) listBlock2).r()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ListData o(CharSequence charSequence, int i3, int i4, boolean z2) {
        boolean z3;
        ListMarkerData listMarkerDataP = p(charSequence, i3);
        if (listMarkerDataP == null) {
            return null;
        }
        ListBlock listBlock = listMarkerDataP.f145460a;
        int i5 = listMarkerDataP.f145461b;
        int i6 = i4 + (i5 - i3);
        int length = charSequence.length();
        int iA = i6;
        while (true) {
            if (i5 >= length) {
                z3 = false;
                break;
            }
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt != '\t') {
                if (cCharAt != ' ') {
                    z3 = true;
                    break;
                }
                iA++;
            } else {
                iA += Parsing.a(iA);
            }
            i5++;
        }
        if (z2 && (((listBlock instanceof OrderedList) && ((OrderedList) listBlock).s() != 1) || !z3)) {
            return null;
        }
        if (!z3 || iA - i6 > Parsing.f145510a) {
            iA = i6 + 1;
        }
        return new ListData(listBlock, iA);
    }

    private static ListMarkerData p(CharSequence charSequence, int i3) {
        char cCharAt = charSequence.charAt(i3);
        if (cCharAt != '*' && cCharAt != '+' && cCharAt != '-') {
            return q(charSequence, i3);
        }
        int i4 = i3 + 1;
        if (!m(charSequence, i4)) {
            return null;
        }
        BulletList bulletList = new BulletList();
        bulletList.s(cCharAt);
        return new ListMarkerData(bulletList, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0009  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.commonmark.internal.ListBlockParser.ListMarkerData q(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = 0
            r2 = r7
        L6:
            r3 = 0
            if (r2 >= r0) goto L4b
            char r4 = r6.charAt(r2)
            r5 = 41
            if (r4 == r5) goto L23
            r5 = 46
            if (r4 == r5) goto L23
            switch(r4) {
                case 48: goto L19;
                case 49: goto L19;
                case 50: goto L19;
                case 51: goto L19;
                case 52: goto L19;
                case 53: goto L19;
                case 54: goto L19;
                case 55: goto L19;
                case 56: goto L19;
                case 57: goto L19;
                default: goto L18;
            }
        L18:
            return r3
        L19:
            int r1 = r1 + 1
            r4 = 9
            if (r1 <= r4) goto L20
            return r3
        L20:
            int r2 = r2 + 1
            goto L6
        L23:
            r0 = 1
            if (r1 < r0) goto L4b
            int r0 = r2 + 1
            boolean r1 = m(r6, r0)
            if (r1 == 0) goto L4b
            java.lang.CharSequence r6 = r6.subSequence(r7, r2)
            java.lang.String r6 = r6.toString()
            org.commonmark.node.OrderedList r7 = new org.commonmark.node.OrderedList
            r7.<init>()
            int r6 = java.lang.Integer.parseInt(r6)
            r7.u(r6)
            r7.t(r4)
            org.commonmark.internal.ListBlockParser$ListMarkerData r6 = new org.commonmark.internal.ListBlockParser$ListMarkerData
            r6.<init>(r7, r0)
            return r6
        L4b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.ListBlockParser.q(java.lang.CharSequence, int):org.commonmark.internal.ListBlockParser$ListMarkerData");
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean b() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue c(ParserState parserState) {
        if (parserState.a()) {
            this.f145456b = true;
            this.f145457c = 0;
        } else if (this.f145456b) {
            this.f145457c++;
        }
        return BlockContinue.b(parserState.getIndex());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block e() {
        return this.f145455a;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean h(Block block) {
        if (!(block instanceof ListItem)) {
            return false;
        }
        if (this.f145456b && this.f145457c == 1) {
            this.f145455a.q(false);
            this.f145456b = false;
        }
        return true;
    }
}
