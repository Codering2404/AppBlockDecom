package com.google.android.gms.internal.ads;

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
import kotlin.comparisons.xn.YvFRmou;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzicf implements Closeable, Flushable {
    private static final Pattern zza = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] zzb = new String[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];
    private static final String[] zzc;
    private final Writer zzd;
    private int[] zze = new int[32];
    private int zzf = 0;
    private final zzibe zzg;
    private final String zzh;
    private String zzi;
    private final boolean zzj;
    private zzibl zzk;
    private String zzl;

    public zzicf(Writer writer) {
        boolean z2 = false;
        zzm(6);
        this.zzk = zzibl.LEGACY_STRICT;
        Objects.requireNonNull(writer, "out == null");
        this.zzd = writer;
        zzibe zzibeVar = zzibe.zza;
        Objects.requireNonNull(zzibeVar);
        this.zzg = zzibeVar;
        this.zzi = ",";
        if (zzibeVar.zzc()) {
            this.zzh = ": ";
            if (zzibeVar.zza().isEmpty()) {
                this.zzi = ", ";
            }
        } else {
            this.zzh = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        }
        if (zzibeVar.zza().isEmpty() && zzibeVar.zzb().isEmpty()) {
            z2 = true;
        }
        this.zzj = z2;
    }

    private final zzicf zzk(int i3, char c3) throws IOException {
        zzs();
        zzm(i3);
        this.zzd.write(c3);
        return this;
    }

    private final zzicf zzl(int i3, int i4, char c3) throws IOException {
        int iZzn = zzn();
        if (iZzn != i4 && iZzn != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.zzl;
        if (str != null) {
            throw new IllegalStateException("Dangling name: ".concat(str));
        }
        this.zzf--;
        if (iZzn == i4) {
            zzr();
        }
        this.zzd.write(c3);
        return this;
    }

    private final void zzm(int i3) {
        int i4 = this.zzf;
        int[] iArr = this.zze;
        if (i4 == iArr.length) {
            this.zze = Arrays.copyOf(iArr, i4 + i4);
        }
        int[] iArr2 = this.zze;
        int i5 = this.zzf;
        this.zzf = i5 + 1;
        iArr2[i5] = i3;
    }

    private final int zzn() {
        int i3 = this.zzf;
        if (i3 != 0) {
            return this.zze[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void zzo(int i3) {
        this.zze[this.zzf - 1] = i3;
    }

    private final void zzp() throws IOException {
        if (this.zzl != null) {
            int iZzn = zzn();
            if (iZzn == 5) {
                this.zzd.write(this.zzi);
            } else if (iZzn != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzr();
            zzo(4);
            zzq(this.zzl);
            this.zzl = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzq(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            java.io.Writer r0 = r9.zzd
            java.lang.String[] r1 = com.google.android.gms.internal.ads.zzicf.zzb
            r2 = 34
            r0.write(r2)
            int r3 = r10.length()
            r4 = 0
            r5 = r4
        Lf:
            if (r4 >= r3) goto L39
            int r6 = r4 + 1
            char r7 = r10.charAt(r4)
            r8 = 128(0x80, float:1.8E-43)
            if (r7 >= r8) goto L20
            r7 = r1[r7]
            if (r7 == 0) goto L37
            goto L2d
        L20:
            r8 = 8232(0x2028, float:1.1535E-41)
            if (r7 != r8) goto L27
            java.lang.String r7 = "\\u2028"
            goto L2d
        L27:
            r8 = 8233(0x2029, float:1.1537E-41)
            if (r7 != r8) goto L37
            java.lang.String r7 = "\\u2029"
        L2d:
            if (r5 >= r4) goto L33
            int r4 = r4 - r5
            r0.write(r10, r5, r4)
        L33:
            r0.write(r7)
            r5 = r6
        L37:
            r4 = r6
            goto Lf
        L39:
            if (r5 >= r3) goto L3f
            int r3 = r3 - r5
            r0.write(r10, r5, r3)
        L3f:
            r0.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicf.zzq(java.lang.String):void");
    }

    private final void zzr() throws IOException {
        if (this.zzj) {
            return;
        }
        Writer writer = this.zzd;
        zzibe zzibeVar = this.zzg;
        writer.write(zzibeVar.zza());
        int i3 = this.zzf;
        for (int i4 = 1; i4 < i3; i4++) {
            writer.write(zzibeVar.zzb());
        }
    }

    private final void zzs() throws IOException {
        int iZzn = zzn();
        if (iZzn == 1) {
            zzo(2);
            zzr();
            return;
        }
        if (iZzn == 2) {
            this.zzd.append((CharSequence) this.zzi);
            zzr();
        } else {
            if (iZzn == 4) {
                this.zzd.append((CharSequence) this.zzh);
                zzo(5);
                return;
            }
            if (iZzn != 6) {
                if (iZzn != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.zzk != zzibl.LENIENT) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            zzo(7);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzd.close();
        int i3 = this.zzf;
        if (i3 > 1 || (i3 == 1 && this.zze[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zzf = 0;
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzf == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.zzd.flush();
    }

    public final void zza(zzibl zziblVar) {
        Objects.requireNonNull(zziblVar);
        this.zzk = zziblVar;
    }

    public final zzicf zzb() throws IOException {
        zzp();
        zzk(1, '[');
        return this;
    }

    public final zzicf zzc() throws IOException {
        zzl(1, 2, ']');
        return this;
    }

    public final zzicf zzd() throws IOException {
        zzp();
        zzk(3, '{');
        return this;
    }

    public final zzicf zze() throws IOException {
        zzl(3, 5, '}');
        return this;
    }

    public final zzicf zzf(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.zzl != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iZzn = zzn();
        if (iZzn != 3 && iZzn != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.zzl = str;
        return this;
    }

    public final zzicf zzg(String str) throws IOException {
        if (str == null) {
            zzj();
            return this;
        }
        zzp();
        zzs();
        zzq(str);
        return this;
    }

    public final zzicf zzh(boolean z2) throws IOException {
        zzp();
        zzs();
        this.zzd.write(true != z2 ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        return this;
    }

    public final zzicf zzi(Number number) throws IOException {
        if (number == null) {
            zzj();
            return this;
        }
        zzp();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.zzk != zzibl.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
                }
            } else if (cls != Float.class && cls != Double.class && !zza.matcher(string).matches()) {
                String strValueOf = String.valueOf(cls);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47 + string.length());
                sb.append("String created by ");
                sb.append(strValueOf);
                sb.append(" is not a valid JSON number: ");
                sb.append(string);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        zzs();
        this.zzd.append((CharSequence) string);
        return this;
    }

    public final zzicf zzj() throws IOException {
        if (this.zzl != null) {
            zzp();
        }
        zzs();
        this.zzd.write("null");
        return this;
    }

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            zzb[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = zzb;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzc = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = YvFRmou.GfPu;
    }
}
