package com.airbnb.lottie.parser.moshi;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonReader implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f57015h = new String[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f57016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f57017b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f57018c = new String[32];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f57019d = new int[32];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f57020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f57021g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Options {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String[] f57022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final okio.Options f57023b;

        private Options(String[] strArr, okio.Options options) {
            this.f57022a = strArr;
            this.f57023b = options;
        }

        public static Options a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    JsonReader.M(buffer, strArr[i3]);
                    buffer.readByte();
                    byteStringArr[i3] = buffer.M();
                }
                return new Options((String[]) strArr.clone(), okio.Options.l(byteStringArr));
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f57015h[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f57015h;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    JsonReader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void M(okio.BufferedSink r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f57015h
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.J0(r8, r4, r3)
        L2e:
            r7.C0(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.J0(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.M(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader z(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    public abstract Token C();

    final void F(int i3) {
        int i4 = this.f57016a;
        int[] iArr = this.f57017b;
        if (i4 == iArr.length) {
            if (i4 == 256) {
                throw new JsonDataException("Nesting too deep at " + g());
            }
            this.f57017b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f57018c;
            this.f57018c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f57019d;
            this.f57019d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f57017b;
        int i5 = this.f57016a;
        this.f57016a = i5 + 1;
        iArr3[i5] = i3;
    }

    public abstract int J(Options options);

    public abstract void K();

    public abstract void L();

    final JsonEncodingException N(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + g());
    }

    public abstract void b();

    public abstract void c();

    public abstract void f();

    public final String g() {
        return JsonScope.a(this.f57016a, this.f57017b, this.f57018c, this.f57019d);
    }

    public abstract void i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract double l();

    public abstract int m();

    public abstract String n();

    public abstract String r();
}
