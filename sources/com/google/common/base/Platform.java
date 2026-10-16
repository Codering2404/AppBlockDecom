package com.google.common.base;

import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Platform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PatternCompiler f83335a = d();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }
    }

    static CommonPattern a(String str) {
        Preconditions.t(str);
        return f83335a.a(str);
    }

    static String b(String str) {
        if (f(str)) {
            return null;
        }
        return str;
    }

    static String c(double d3) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d3));
    }

    private static PatternCompiler d() {
        return new JdkPatternCompiler();
    }

    static String e(String str) {
        return str == null ? "" : str;
    }

    static boolean f(String str) {
        return str == null || str.isEmpty();
    }
}
