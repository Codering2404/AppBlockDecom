package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedCharEscaper extends CharEscaper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[][] f84871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f84872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char f84873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final char f84874e;

    protected ArrayBasedCharEscaper(Map map, char c3, char c4) {
        this(ArrayBasedEscaperMap.a(map), c3, c4);
    }

    @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
    public final String a(String str) {
        Preconditions.t(str);
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < this.f84872c && this.f84871b[cCharAt] != null) || cCharAt > this.f84874e || cCharAt < this.f84873d) {
                return c(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.CharEscaper
    protected final char[] b(char c3) {
        char[] cArr;
        if (c3 < this.f84872c && (cArr = this.f84871b[c3]) != null) {
            return cArr;
        }
        if (c3 < this.f84873d || c3 > this.f84874e) {
            return e(c3);
        }
        return null;
    }

    protected abstract char[] e(char c3);

    protected ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c3, char c4) {
        Preconditions.t(arrayBasedEscaperMap);
        char[][] cArrC = arrayBasedEscaperMap.c();
        this.f84871b = cArrC;
        this.f84872c = cArrC.length;
        if (c4 < c3) {
            c4 = 0;
            c3 = 65535;
        }
        this.f84873d = c3;
        this.f84874e = c4;
    }
}
