package com.google.common.base;

import com.google.common.base.CharMatcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f83352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f83353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f83354d;

    private boolean x(int i3) {
        return 1 == ((this.f83354d >> i3) & 1);
    }

    static int y(int i3) {
        return Integer.rotateLeft(i3 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean o(char c3) {
        if (c3 == 0) {
            return this.f83353c;
        }
        if (!x(c3)) {
            return false;
        }
        int length = this.f83352b.length - 1;
        int iY = y(c3) & length;
        int i3 = iY;
        do {
            char c4 = this.f83352b[i3];
            if (c4 == 0) {
                return false;
            }
            if (c4 == c3) {
                return true;
            }
            i3 = (i3 + 1) & length;
        } while (i3 != iY);
        return false;
    }
}
