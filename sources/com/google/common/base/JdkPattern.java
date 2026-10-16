package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pattern f83312a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JdkMatcher extends CommonMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matcher f83313a;

        JdkMatcher(Matcher matcher) {
            this.f83313a = (Matcher) Preconditions.t(matcher);
        }

        @Override // com.google.common.base.CommonMatcher
        public int a() {
            return this.f83313a.end();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean b() {
            return this.f83313a.find();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean c(int i3) {
            return this.f83313a.find(i3);
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean d() {
            return this.f83313a.matches();
        }

        @Override // com.google.common.base.CommonMatcher
        public int e() {
            return this.f83313a.start();
        }
    }

    JdkPattern(Pattern pattern) {
        this.f83312a = (Pattern) Preconditions.t(pattern);
    }

    @Override // com.google.common.base.CommonPattern
    public int a() {
        return this.f83312a.flags();
    }

    @Override // com.google.common.base.CommonPattern
    public CommonMatcher b(CharSequence charSequence) {
        return new JdkMatcher(this.f83312a.matcher(charSequence));
    }

    @Override // com.google.common.base.CommonPattern
    public String c() {
        return this.f83312a.pattern();
    }

    public String toString() {
        return this.f83312a.toString();
    }
}
