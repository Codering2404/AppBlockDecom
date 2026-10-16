package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Escapers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Escaper f84886a = new CharEscaper() { // from class: com.google.common.escape.Escapers.1
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String a(String str) {
            return (String) Preconditions.t(str);
        }

        @Override // com.google.common.escape.CharEscaper
        protected char[] b(char c3) {
            return null;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f84887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private char f84888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private char f84889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f84890d;

        public Builder b(char c3, String str) {
            Preconditions.t(str);
            this.f84887a.put(Character.valueOf(c3), str);
            return this;
        }

        public Escaper c() {
            return new ArrayBasedCharEscaper(this.f84887a, this.f84888b, this.f84889c) { // from class: com.google.common.escape.Escapers.Builder.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final char[] f84891f;

                {
                    this.f84891f = Builder.this.f84890d != null ? Builder.this.f84890d.toCharArray() : null;
                }

                @Override // com.google.common.escape.ArrayBasedCharEscaper
                protected char[] e(char c3) {
                    return this.f84891f;
                }
            };
        }

        public Builder d(char c3, char c4) {
            this.f84888b = c3;
            this.f84889c = c4;
            return this;
        }

        public Builder e(String str) {
            this.f84890d = str;
            return this;
        }

        private Builder() {
            this.f84887a = new HashMap();
            this.f84888b = (char) 0;
            this.f84889c = (char) 65535;
            this.f84890d = null;
        }
    }

    public static Builder a() {
        return new Builder();
    }
}
