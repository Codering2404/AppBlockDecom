package org.commonmark.parser;

import org.commonmark.node.SourceSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SourceLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f145565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SourceSpan f145566b;

    private SourceLine(CharSequence charSequence, SourceSpan sourceSpan) {
        if (charSequence == null) {
            throw new NullPointerException("content must not be null");
        }
        this.f145565a = charSequence;
        this.f145566b = sourceSpan;
    }

    public static SourceLine c(CharSequence charSequence, SourceSpan sourceSpan) {
        return new SourceLine(charSequence, sourceSpan);
    }

    public CharSequence a() {
        return this.f145565a;
    }

    public SourceSpan b() {
        return this.f145566b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.commonmark.parser.SourceLine d(int r3, int r4) {
        /*
            r2 = this;
            java.lang.CharSequence r0 = r2.f145565a
            java.lang.CharSequence r0 = r0.subSequence(r3, r4)
            org.commonmark.node.SourceSpan r1 = r2.f145566b
            if (r1 == 0) goto L1d
            int r1 = r1.a()
            int r1 = r1 + r3
            int r4 = r4 - r3
            if (r4 == 0) goto L1d
            org.commonmark.node.SourceSpan r3 = r2.f145566b
            int r3 = r3.c()
            org.commonmark.node.SourceSpan r3 = org.commonmark.node.SourceSpan.d(r3, r1, r4)
            goto L1e
        L1d:
            r3 = 0
        L1e:
            org.commonmark.parser.SourceLine r3 = c(r0, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.parser.SourceLine.d(int, int):org.commonmark.parser.SourceLine");
    }
}
