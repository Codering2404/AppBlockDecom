package com.google.common.escape;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CharEscaperBuilder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CharArrayDecorator extends CharEscaper {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[][] f84883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f84884c;

        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String a(String str) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                char[][] cArr = this.f84883b;
                if (cCharAt < cArr.length && cArr[cCharAt] != null) {
                    return c(str, i3);
                }
            }
            return str;
        }

        @Override // com.google.common.escape.CharEscaper
        protected char[] b(char c3) {
            if (c3 < this.f84884c) {
                return this.f84883b[c3];
            }
            return null;
        }
    }
}
