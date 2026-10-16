package ru.noties.markwon.html.jsoup.parser;

import ru.noties.markwon.html.jsoup.helper.Normalizer;
import ru.noties.markwon.html.jsoup.helper.Validate;
import ru.noties.markwon.html.jsoup.nodes.Attributes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenType f147237a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class CData extends Character {
        CData(String str) {
            c(str);
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + d() + "]]>";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Character extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f147238b;

        Character() {
            super(TokenType.Character);
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            this.f147238b = null;
            return this;
        }

        Character c(String str) {
            this.f147238b = str;
            return this;
        }

        public String d() {
            return this.f147238b;
        }

        public String toString() {
            return d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Comment extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final StringBuilder f147239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f147240c;

        Comment() {
            super(TokenType.Comment);
            this.f147239b = new StringBuilder();
            this.f147240c = false;
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            Token.b(this.f147239b);
            this.f147240c = false;
            return this;
        }

        String c() {
            return this.f147239b.toString();
        }

        public String toString() {
            return "<!--" + c() + "-->";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Doctype extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final StringBuilder f147241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f147242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final StringBuilder f147243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final StringBuilder f147244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f147245f;

        Doctype() {
            super(TokenType.Doctype);
            this.f147241b = new StringBuilder();
            this.f147242c = null;
            this.f147243d = new StringBuilder();
            this.f147244e = new StringBuilder();
            this.f147245f = false;
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            Token.b(this.f147241b);
            this.f147242c = null;
            Token.b(this.f147243d);
            Token.b(this.f147244e);
            this.f147245f = false;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EndTag extends Tag {
        EndTag() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + l() + ">";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class StartTag extends Tag {
        public StartTag() {
            super(TokenType.StartTag);
            this.f147254j = new Attributes();
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token.Tag, ru.noties.markwon.html.jsoup.parser.Token
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Tag a() {
            super.a();
            this.f147254j = new Attributes();
            return this;
        }

        public String toString() {
            Attributes attributes = this.f147254j;
            if (attributes == null || attributes.size() <= 0) {
                return "<" + l() + ">";
            }
            return "<" + l() + " " + this.f147254j.toString() + ">";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Tag extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f147246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f147247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f147248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private StringBuilder f147249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f147250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f147251g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f147252h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f147253i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Attributes f147254j;

        protected Tag(TokenType tokenType) {
            super(tokenType);
            this.f147249e = new StringBuilder();
            this.f147251g = false;
            this.f147252h = false;
            this.f147253i = false;
        }

        private void j() {
            this.f147252h = true;
            String str = this.f147250f;
            if (str != null) {
                this.f147249e.append(str);
                this.f147250f = null;
            }
        }

        final void c(char c3) {
            d(String.valueOf(c3));
        }

        final void d(String str) {
            String str2 = this.f147248d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f147248d = str;
        }

        final void e(char c3) {
            j();
            this.f147249e.append(c3);
        }

        final void f(String str) {
            j();
            if (this.f147249e.length() == 0) {
                this.f147250f = str;
            } else {
                this.f147249e.append(str);
            }
        }

        final void g(int[] iArr) {
            j();
            for (int i3 : iArr) {
                this.f147249e.appendCodePoint(i3);
            }
        }

        final void h(char c3) {
            i(String.valueOf(c3));
        }

        final void i(String str) {
            String str2 = this.f147246b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f147246b = str;
            this.f147247c = Normalizer.a(str);
        }

        final void k() {
            if (this.f147248d != null) {
                n();
            }
        }

        final String l() {
            String str = this.f147246b;
            Validate.b(str == null || str.length() == 0);
            return this.f147246b;
        }

        final Tag m(String str) {
            this.f147246b = str;
            this.f147247c = Normalizer.a(str);
            return this;
        }

        final void n() {
            if (this.f147254j == null) {
                this.f147254j = new Attributes();
            }
            String str = this.f147248d;
            if (str != null) {
                String strTrim = str.trim();
                this.f147248d = strTrim;
                if (strTrim.length() > 0) {
                    this.f147254j.t(this.f147248d, this.f147252h ? this.f147249e.length() > 0 ? this.f147249e.toString() : this.f147250f : this.f147251g ? "" : null);
                }
            }
            this.f147248d = null;
            this.f147251g = false;
            this.f147252h = false;
            Token.b(this.f147249e);
            this.f147250f = null;
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token
        /* JADX INFO: renamed from: o */
        public Tag a() {
            this.f147246b = null;
            this.f147247c = null;
            this.f147248d = null;
            Token.b(this.f147249e);
            this.f147250f = null;
            this.f147251g = false;
            this.f147252h = false;
            this.f147253i = false;
            this.f147254j = null;
            return this;
        }

        final void p() {
            this.f147251g = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    protected Token(TokenType tokenType) {
        this.f147237a = tokenType;
    }

    static void b(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public abstract Token a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class EOF extends Token {
        EOF() {
            super(TokenType.EOF);
        }

        @Override // ru.noties.markwon.html.jsoup.parser.Token
        public Token a() {
            return this;
        }
    }
}
