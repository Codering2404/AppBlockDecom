package com.google.common.escape;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[][] f84877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f84878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f84879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f84880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final char f84881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final char f84882g;

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String a(String str) {
        Preconditions.t(str);
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < this.f84878c && this.f84877b[cCharAt] != null) || cCharAt > this.f84882g || cCharAt < this.f84881f) {
                return d(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final char[] c(int i3) {
        char[] cArr;
        if (i3 < this.f84878c && (cArr = this.f84877b[i3]) != null) {
            return cArr;
        }
        if (i3 < this.f84879d || i3 > this.f84880e) {
            return g(i3);
        }
        return null;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected final int f(CharSequence charSequence, int i3, int i4) {
        while (i3 < i4) {
            char cCharAt = charSequence.charAt(i3);
            if ((cCharAt < this.f84878c && this.f84877b[cCharAt] != null) || cCharAt > this.f84882g || cCharAt < this.f84881f) {
                break;
            }
            i3++;
        }
        return i3;
    }

    protected abstract char[] g(int i3);
}
