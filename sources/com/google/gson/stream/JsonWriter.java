package com.google.gson.stream;

import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class JsonWriter implements Closeable, Flushable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f90571k = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f90572l = new String[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f90573m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f90574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f90575b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f90576c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f90577d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f90578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f90579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f90580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f90581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f90582j;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f90572l[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f90572l;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f90573m = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        L(6);
        this.f90578f = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        this.f90582j = true;
        Objects.requireNonNull(writer, "out == null");
        this.f90574a = writer;
    }

    private void C() throws IOException {
        if (this.f90577d == null) {
            return;
        }
        this.f90574a.write(10);
        int i3 = this.f90576c;
        for (int i4 = 1; i4 < i3; i4++) {
            this.f90574a.write(this.f90577d);
        }
    }

    private JsonWriter J(int i3, char c3) throws IOException {
        b();
        L(i3);
        this.f90574a.write(c3);
        return this;
    }

    private int K() {
        int i3 = this.f90576c;
        if (i3 != 0) {
            return this.f90575b[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void L(int i3) {
        int i4 = this.f90576c;
        int[] iArr = this.f90575b;
        if (i4 == iArr.length) {
            this.f90575b = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f90575b;
        int i5 = this.f90576c;
        this.f90576c = i5 + 1;
        iArr2[i5] = i3;
    }

    private void M(int i3) {
        this.f90575b[this.f90576c - 1] = i3;
    }

    private void O0() throws IOException {
        if (this.f90581i != null) {
            a();
            e0(this.f90581i);
            this.f90581i = null;
        }
    }

    private void a() throws IOException {
        int iK = K();
        if (iK == 5) {
            this.f90574a.write(44);
        } else if (iK != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        C();
        M(4);
    }

    private void b() throws IOException {
        int iK = K();
        if (iK == 1) {
            M(2);
            C();
            return;
        }
        if (iK == 2) {
            this.f90574a.append(',');
            C();
        } else {
            if (iK == 4) {
                this.f90574a.append((CharSequence) this.f90578f);
                M(5);
                return;
            }
            if (iK != 6) {
                if (iK != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f90579g) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            M(7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f90580h
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f90573m
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.f90572l
        L9:
            java.io.Writer r1 = r8.f90574a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f90574a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f90574a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f90574a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f90574a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.e0(java.lang.String):void");
    }

    private JsonWriter i(int i3, int i4, char c3) throws IOException {
        int iK = K();
        if (iK != i4 && iK != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f90581i != null) {
            throw new IllegalStateException("Dangling name: " + this.f90581i);
        }
        this.f90576c--;
        if (iK == i4) {
            C();
        }
        this.f90574a.write(c3);
        return this;
    }

    private static boolean r(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    public JsonWriter A0(boolean z2) throws IOException {
        O0();
        b();
        this.f90574a.write(z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter F() throws IOException {
        if (this.f90581i != null) {
            if (!this.f90582j) {
                this.f90581i = null;
                return this;
            }
            O0();
        }
        b();
        this.f90574a.write("null");
        return this;
    }

    public final void N(boolean z2) {
        this.f90580h = z2;
    }

    public final void O(String str) {
        if (str.length() == 0) {
            this.f90577d = null;
            this.f90578f = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        } else {
            this.f90577d = str;
            this.f90578f = ": ";
        }
    }

    public final void T(boolean z2) {
        this.f90579g = z2;
    }

    public final void V(boolean z2) {
        this.f90582j = z2;
    }

    public JsonWriter c() throws IOException {
        O0();
        return J(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f90574a.close();
        int i3 = this.f90576c;
        if (i3 > 1 || (i3 == 1 && this.f90575b[i3 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f90576c = 0;
    }

    public JsonWriter f() throws IOException {
        O0();
        return J(3, '{');
    }

    public void flush() throws IOException {
        if (this.f90576c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f90574a.flush();
    }

    public JsonWriter g0(double d3) throws IOException {
        O0();
        if (this.f90579g || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
            b();
            this.f90574a.append((CharSequence) Double.toString(d3));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d3);
    }

    public JsonWriter j() {
        return i(1, 2, ']');
    }

    public JsonWriter j0(long j3) throws IOException {
        O0();
        b();
        this.f90574a.write(Long.toString(j3));
        return this;
    }

    public JsonWriter k() {
        return i(3, 5, '}');
    }

    public final boolean l() {
        return this.f90582j;
    }

    public final boolean m() {
        return this.f90580h;
    }

    public boolean n() {
        return this.f90579g;
    }

    public JsonWriter q0(Boolean bool) throws IOException {
        if (bool == null) {
            return F();
        }
        O0();
        b();
        this.f90574a.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter w0(Number number) throws IOException {
        if (number == null) {
            return F();
        }
        O0();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!r(cls) && !f90571k.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (!this.f90579g) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
        }
        b();
        this.f90574a.append((CharSequence) string);
        return this;
    }

    public JsonWriter z(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f90581i != null) {
            throw new IllegalStateException();
        }
        if (this.f90576c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f90581i = str;
        return this;
    }

    public JsonWriter z0(String str) throws IOException {
        if (str == null) {
            return F();
        }
        O0();
        b();
        e0(str);
        return this;
    }
}
