package org.commonmark.internal.util;

import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class AsciiMatcher implements CharMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitSet f145500a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BitSet f145501a;

        public AsciiMatcher b() {
            return new AsciiMatcher(this);
        }

        public Builder c(char c3) {
            if (c3 > 127) {
                throw new IllegalArgumentException("Can only match ASCII characters");
            }
            this.f145501a.set(c3);
            return this;
        }

        public Builder d(char c3, char c4) {
            while (c3 <= c4) {
                c(c3);
                c3 = (char) (c3 + 1);
            }
            return this;
        }

        private Builder(BitSet bitSet) {
            this.f145501a = bitSet;
        }
    }

    public static Builder b() {
        return new Builder(new BitSet());
    }

    @Override // org.commonmark.internal.util.CharMatcher
    public boolean a(char c3) {
        return this.f145500a.get(c3);
    }

    public Builder c() {
        return new Builder((BitSet) this.f145500a.clone());
    }

    private AsciiMatcher(Builder builder) {
        this.f145500a = builder.f145501a;
    }
}
