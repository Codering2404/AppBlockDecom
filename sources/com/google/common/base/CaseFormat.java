package com.google.common.base;

import java.io.Serializable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class CaseFormat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CaseFormat f83222d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CaseFormat f83223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CaseFormat f83224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CaseFormat f83225h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharMatcher f83227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CaseFormat f83221c = new CaseFormat("LOWER_HYPHEN", 0, CharMatcher.k('-'), "-") { // from class: com.google.common.base.CaseFormat.1
        @Override // com.google.common.base.CaseFormat
        String c(CaseFormat caseFormat, String str) {
            return caseFormat == CaseFormat.f83222d ? str.replace('-', '_') : caseFormat == CaseFormat.f83225h ? Ascii.g(str.replace('-', '_')) : super.c(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        String f(String str) {
            return Ascii.e(str);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ CaseFormat[] f83226i = a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StringConverter extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CaseFormat f83229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CaseFormat f83230c;

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                StringConverter stringConverter = (StringConverter) obj;
                if (this.f83229b.equals(stringConverter.f83229b) && this.f83230c.equals(stringConverter.f83230c)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(String str) {
            return this.f83230c.g(this.f83229b, str);
        }

        public int hashCode() {
            return this.f83229b.hashCode() ^ this.f83230c.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public String e(String str) {
            return this.f83229b.g(this.f83230c, str);
        }

        public String toString() {
            return this.f83229b + ".converterTo(" + this.f83230c + ")";
        }
    }

    static {
        String str = "_";
        f83222d = new CaseFormat("LOWER_UNDERSCORE", 1, CharMatcher.k('_'), str) { // from class: com.google.common.base.CaseFormat.2
            @Override // com.google.common.base.CaseFormat
            String c(CaseFormat caseFormat, String str2) {
                return caseFormat == CaseFormat.f83221c ? str2.replace('_', '-') : caseFormat == CaseFormat.f83225h ? Ascii.g(str2) : super.c(caseFormat, str2);
            }

            @Override // com.google.common.base.CaseFormat
            String f(String str2) {
                return Ascii.e(str2);
            }
        };
        String str2 = "";
        f83223f = new CaseFormat("LOWER_CAMEL", 2, CharMatcher.h('A', 'Z'), str2) { // from class: com.google.common.base.CaseFormat.3
            @Override // com.google.common.base.CaseFormat
            String e(String str3) {
                return Ascii.e(str3);
            }

            @Override // com.google.common.base.CaseFormat
            String f(String str3) {
                return CaseFormat.d(str3);
            }
        };
        f83224g = new CaseFormat("UPPER_CAMEL", 3, CharMatcher.h('A', 'Z'), str2) { // from class: com.google.common.base.CaseFormat.4
            @Override // com.google.common.base.CaseFormat
            String f(String str3) {
                return CaseFormat.d(str3);
            }
        };
        f83225h = new CaseFormat("UPPER_UNDERSCORE", 4, CharMatcher.k('_'), str) { // from class: com.google.common.base.CaseFormat.5
            @Override // com.google.common.base.CaseFormat
            String c(CaseFormat caseFormat, String str3) {
                return caseFormat == CaseFormat.f83221c ? Ascii.e(str3.replace('_', '-')) : caseFormat == CaseFormat.f83222d ? Ascii.e(str3) : super.c(caseFormat, str3);
            }

            @Override // com.google.common.base.CaseFormat
            String f(String str3) {
                return Ascii.g(str3);
            }
        };
    }

    private static /* synthetic */ CaseFormat[] a() {
        return new CaseFormat[]{f83221c, f83222d, f83223f, f83224g, f83225h};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.f(str.charAt(0)) + Ascii.e(str.substring(1));
    }

    public static CaseFormat valueOf(String str) {
        return (CaseFormat) Enum.valueOf(CaseFormat.class, str);
    }

    public static CaseFormat[] values() {
        return (CaseFormat[]) f83226i.clone();
    }

    String c(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int length = 0;
        int iJ = -1;
        while (true) {
            iJ = this.f83227a.j(str, iJ + 1);
            if (iJ == -1) {
                break;
            }
            if (length == 0) {
                sb = new StringBuilder(str.length() + (caseFormat.f83228b.length() * 4));
                sb.append(caseFormat.e(str.substring(length, iJ)));
            } else {
                java.util.Objects.requireNonNull(sb);
                sb.append(caseFormat.f(str.substring(length, iJ)));
            }
            sb.append(caseFormat.f83228b);
            length = this.f83228b.length() + iJ;
        }
        if (length == 0) {
            return caseFormat.e(str);
        }
        java.util.Objects.requireNonNull(sb);
        sb.append(caseFormat.f(str.substring(length)));
        return sb.toString();
    }

    String e(String str) {
        return f(str);
    }

    abstract String f(String str);

    public final String g(CaseFormat caseFormat, String str) {
        Preconditions.t(caseFormat);
        Preconditions.t(str);
        return caseFormat == this ? str : c(caseFormat, str);
    }

    private CaseFormat(String str, int i3, CharMatcher charMatcher, String str2) {
        this.f83227a = charMatcher;
        this.f83228b = str2;
    }
}
