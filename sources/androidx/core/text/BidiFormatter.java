package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BidiFormatter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final TextDirectionHeuristicCompat f34249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f34250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f34251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final BidiFormatter f34252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final BidiFormatter f34253h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f34255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextDirectionHeuristicCompat f34256c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f34257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextDirectionHeuristicCompat f34259c;

        public Builder() {
            c(BidiFormatter.e(Locale.getDefault()));
        }

        private static BidiFormatter b(boolean z2) {
            return z2 ? BidiFormatter.f34253h : BidiFormatter.f34252g;
        }

        private void c(boolean z2) {
            this.f34257a = z2;
            this.f34259c = BidiFormatter.f34249d;
            this.f34258b = 2;
        }

        public BidiFormatter a() {
            return (this.f34258b == 2 && this.f34259c == BidiFormatter.f34249d) ? b(this.f34257a) : new BidiFormatter(this.f34257a, this.f34258b, this.f34259c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DirectionalityEstimator {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f34260f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f34261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f34262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private char f34265e;

        static {
            for (int i3 = 0; i3 < 1792; i3++) {
                f34260f[i3] = Character.getDirectionality(i3);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z2) {
            this.f34261a = charSequence;
            this.f34262b = z2;
            this.f34263c = charSequence.length();
        }

        private static byte c(char c3) {
            return c3 < 1792 ? f34260f[c3] : Character.getDirectionality(c3);
        }

        private byte f() {
            char cCharAt;
            int i3 = this.f34264d;
            do {
                int i4 = this.f34264d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f34261a;
                int i5 = i4 - 1;
                this.f34264d = i5;
                cCharAt = charSequence.charAt(i5);
                this.f34265e = cCharAt;
                if (cCharAt == '&') {
                    return Ascii.FF;
                }
            } while (cCharAt != ';');
            this.f34264d = i3;
            this.f34265e = ';';
            return Ascii.CR;
        }

        private byte g() {
            char cCharAt;
            do {
                int i3 = this.f34264d;
                if (i3 >= this.f34263c) {
                    return Ascii.FF;
                }
                CharSequence charSequence = this.f34261a;
                this.f34264d = i3 + 1;
                cCharAt = charSequence.charAt(i3);
                this.f34265e = cCharAt;
            } while (cCharAt != ';');
            return Ascii.FF;
        }

        private byte h() {
            char cCharAt;
            int i3 = this.f34264d;
            while (true) {
                int i4 = this.f34264d;
                if (i4 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f34261a;
                int i5 = i4 - 1;
                this.f34264d = i5;
                char cCharAt2 = charSequence.charAt(i5);
                this.f34265e = cCharAt2;
                if (cCharAt2 == '<') {
                    return Ascii.FF;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i6 = this.f34264d;
                        if (i6 > 0) {
                            CharSequence charSequence2 = this.f34261a;
                            int i7 = i6 - 1;
                            this.f34264d = i7;
                            cCharAt = charSequence2.charAt(i7);
                            this.f34265e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f34264d = i3;
            this.f34265e = '>';
            return Ascii.CR;
        }

        private byte i() {
            char cCharAt;
            int i3 = this.f34264d;
            while (true) {
                int i4 = this.f34264d;
                if (i4 >= this.f34263c) {
                    this.f34264d = i3;
                    this.f34265e = '<';
                    return Ascii.CR;
                }
                CharSequence charSequence = this.f34261a;
                this.f34264d = i4 + 1;
                char cCharAt2 = charSequence.charAt(i4);
                this.f34265e = cCharAt2;
                if (cCharAt2 == '>') {
                    return Ascii.FF;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i5 = this.f34264d;
                        if (i5 < this.f34263c) {
                            CharSequence charSequence2 = this.f34261a;
                            this.f34264d = i5 + 1;
                            cCharAt = charSequence2.charAt(i5);
                            this.f34265e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f34261a.charAt(this.f34264d - 1);
            this.f34265e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f34261a, this.f34264d);
                this.f34264d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f34264d--;
            byte bC = c(this.f34265e);
            if (!this.f34262b) {
                return bC;
            }
            char c3 = this.f34265e;
            return c3 == '>' ? h() : c3 == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.f34261a.charAt(this.f34264d);
            this.f34265e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f34261a, this.f34264d);
                this.f34264d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f34264d++;
            byte bC = c(this.f34265e);
            if (!this.f34262b) {
                return bC;
            }
            char c3 = this.f34265e;
            return c3 == '<' ? i() : c3 == '&' ? g() : bC;
        }

        int d() {
            this.f34264d = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (this.f34264d < this.f34263c && i3 == 0) {
                byte b3 = b();
                if (b3 != 0) {
                    if (b3 == 1 || b3 == 2) {
                        if (i5 == 0) {
                            return 1;
                        }
                    } else if (b3 != 9) {
                        switch (b3) {
                            case 14:
                            case 15:
                                i5++;
                                i4 = -1;
                                continue;
                            case 16:
                            case 17:
                                i5++;
                                i4 = 1;
                                continue;
                            case 18:
                                i5--;
                                i4 = 0;
                                continue;
                        }
                    }
                } else if (i5 == 0) {
                    return -1;
                }
                i3 = i5;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i4 != 0) {
                return i4;
            }
            while (this.f34264d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i3 == i5) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i3 == i5) {
                            return 1;
                        }
                        break;
                    case 18:
                        i5++;
                        continue;
                }
                i5--;
            }
            return 0;
        }

        int e() {
            this.f34264d = this.f34263c;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                while (this.f34264d > 0) {
                    byte bA = a();
                    if (bA == 0) {
                        if (i3 == 0) {
                            return -1;
                        }
                        if (i4 == 0) {
                            break;
                        }
                    } else if (bA == 1 || bA == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                        if (i4 == 0) {
                            break;
                        }
                    } else if (bA != 9) {
                        switch (bA) {
                            case 14:
                            case 15:
                                if (i4 == i3) {
                                    return -1;
                                }
                                i3--;
                                break;
                            case 16:
                            case 17:
                                if (i4 == i3) {
                                    return 1;
                                }
                                i3--;
                                break;
                            case 18:
                                i3++;
                                break;
                            default:
                                if (i4 != 0) {
                                }
                                break;
                        }
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f34280c;
        f34249d = textDirectionHeuristicCompat;
        f34250e = Character.toString((char) 8206);
        f34251f = Character.toString((char) 8207);
        f34252g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f34253h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z2, int i3, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f34254a = z2;
        this.f34255b = i3;
        this.f34256c = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    static boolean e(Locale locale) {
        return TextUtilsCompat.a(locale) == 1;
    }

    private String f(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.f34254a || !(zIsRtl || b(charSequence) == 1)) ? this.f34254a ? (!zIsRtl || b(charSequence) == -1) ? f34251f : "" : "" : f34250e;
    }

    private String g(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.f34254a || !(zIsRtl || a(charSequence) == 1)) ? this.f34254a ? (!zIsRtl || a(charSequence) == -1) ? f34251f : "" : "" : f34250e;
    }

    public boolean d() {
        return (this.f34255b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f34256c, true);
    }

    public CharSequence i(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z2) {
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z2) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zIsRtl ? TextDirectionHeuristicsCompat.f34279b : TextDirectionHeuristicsCompat.f34278a));
        }
        if (zIsRtl != this.f34254a) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z2) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zIsRtl ? TextDirectionHeuristicsCompat.f34279b : TextDirectionHeuristicsCompat.f34278a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f34256c, true);
    }

    public String k(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z2) {
        if (str == null) {
            return null;
        }
        return i(str, textDirectionHeuristicCompat, z2).toString();
    }
}
