package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzicd implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private zzibl zzc = zzibl.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzibn.zza = new zzicc();
    }

    public zzicd(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.zzb = reader;
    }

    private final boolean zzn(char c3) throws IOException {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzt();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x013c, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x013e, code lost:
    
        if (r0 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0140, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x014c, code lost:
    
        r0.append(r4, r2, r3);
        r11.zze = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ed, code lost:
    
        throw zzv("Malformed Unicode escape \\u".concat(new java.lang.String(r4, r11.zze, 4)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzo(char r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicd.zzo(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        zzt();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzp() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r5.zze
            int r3 = r3 + r2
            int r4 = r5.zzf
            if (r3 >= r4) goto L4c
            char[] r4 = r5.zzd
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L59
            r4 = 10
            if (r3 == r4) goto L59
            r4 = 12
            if (r3 == r4) goto L59
            r4 = 13
            if (r3 == r4) goto L59
            r4 = 32
            if (r3 == r4) goto L59
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L59
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L59
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L59
            r4 = 58
            if (r3 == r4) goto L59
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L59;
                case 92: goto L48;
                case 93: goto L59;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.zzt()
            goto L59
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5b
            int r3 = r2 + 1
            boolean r3 = r5.zzr(r3)
            if (r3 == 0) goto L59
            goto L3
        L59:
            r0 = r2
            goto L7b
        L5b:
            if (r1 != 0) goto L68
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L68:
            char[] r3 = r5.zzd
            int r4 = r5.zze
            r1.append(r3, r4, r2)
            int r3 = r5.zze
            int r3 = r3 + r2
            r5.zze = r3
            r2 = 1
            boolean r2 = r5.zzr(r2)
            if (r2 != 0) goto L2
        L7b:
            if (r1 != 0) goto L87
            char[] r1 = r5.zzd
            java.lang.String r2 = new java.lang.String
            int r3 = r5.zze
            r2.<init>(r1, r3, r0)
            goto L92
        L87:
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r1.append(r2, r3, r0)
            java.lang.String r2 = r1.toString()
        L92:
            int r1 = r5.zze
            int r1 = r1 + r0
            r5.zze = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicd.zzp():java.lang.String");
    }

    private final void zzq(int i3) throws zzicg {
        int i4 = this.zzl;
        if (i4 - 1 >= 1280) {
            String strZzl = zzl();
            StringBuilder sb = new StringBuilder(strZzl.length() + 26);
            sb.append("Nesting limit 1280 reached");
            sb.append(strZzl);
            throw new zzicg(sb.toString());
        }
        int[] iArr = this.zzk;
        if (i4 == iArr.length) {
            int i5 = i4 + i4;
            this.zzk = Arrays.copyOf(iArr, i5);
            this.zzn = Arrays.copyOf(this.zzn, i5);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i5);
        }
        int[] iArr2 = this.zzk;
        int i6 = this.zzl;
        this.zzl = i6 + 1;
        iArr2[i6] = i3;
    }

    private final boolean zzr(int i3) throws IOException {
        int i4;
        int i5 = this.zzh;
        int i6 = this.zze;
        this.zzh = i5 - i6;
        char[] cArr = this.zzd;
        int i7 = this.zzf;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.zzf = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i9 = this.zzf;
            int i10 = reader.read(cArr, i9, 1024 - i9);
            if (i10 == -1) {
                return false;
            }
            i4 = this.zzf + i10;
            this.zzf = i4;
            if (this.zzg == 0 && this.zzh == 0 && i4 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private final int zzs(boolean z2) throws IOException {
        int i3;
        int i4 = this.zze;
        int i5 = this.zzf;
        while (true) {
            if (i4 == i5) {
                this.zze = i4;
                if (!zzr(1)) {
                    if (z2) {
                        throw new EOFException("End of input".concat(zzl()));
                    }
                    return -1;
                }
                i4 = this.zze;
                i5 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i6 = i4 + 1;
            char c3 = cArr[i4];
            if (c3 == '\n') {
                this.zzg++;
                this.zzh = i6;
            } else if (c3 != ' ' && c3 != '\r' && c3 != '\t') {
                if (c3 == '/') {
                    this.zze = i6;
                    if (i6 == i5) {
                        this.zze = i4;
                        boolean zZzr = zzr(2);
                        this.zze++;
                        if (!zZzr) {
                            return 47;
                        }
                    }
                    zzt();
                    int i7 = this.zze;
                    char c4 = cArr[i7];
                    if (c4 == '*') {
                        this.zze = i7 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzr(2)) {
                                throw zzv("Unterminated comment");
                            }
                            int i8 = this.zze;
                            if (cArr[i8] != '\n') {
                                while (i3 < 2) {
                                    i3 = cArr[this.zze + i3] == "*/".charAt(i3) ? i3 + 1 : 0;
                                }
                                i4 = this.zze + 2;
                                i5 = this.zzf;
                                break;
                            }
                            this.zzg++;
                            this.zzh = i8 + 1;
                            this.zze++;
                        }
                    } else {
                        if (c4 != '/') {
                            return 47;
                        }
                        this.zze = i7 + 1;
                        zzu();
                        i4 = this.zze;
                        i5 = this.zzf;
                    }
                } else {
                    if (c3 != '#') {
                        this.zze = i6;
                        return c3;
                    }
                    this.zze = i6;
                    zzt();
                    zzu();
                    i4 = this.zze;
                    i5 = this.zzf;
                }
            }
            i4 = i6;
        }
    }

    private final void zzt() throws zzicg {
        if (this.zzc != zzibl.LENIENT) {
            throw zzv("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzu() throws IOException {
        char c3;
        do {
            if (this.zze >= this.zzf && !zzr(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i3 = this.zze;
            int i4 = i3 + 1;
            this.zze = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.zzg++;
                this.zzh = i4;
                return;
            }
        } while (c3 != '\r');
    }

    private final zzicg zzv(String str) throws zzicg {
        String strZzl = zzl();
        StringBuilder sb = new StringBuilder(str.length() + strZzl.length() + 79);
        sb.append(str);
        sb.append(strZzl);
        sb.append("\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json");
        throw new zzicg(sb.toString());
    }

    private final IllegalStateException zzw(String str) throws IOException {
        int iZzm = zzm();
        String strZza = zzice.zza(zzm());
        String strZzl = zzl();
        int length = str.length() + 18 + strZza.length() + strZzl.length();
        String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzm == 9 ? "adapter-not-null-safe" : "unexpected-json-structure");
        StringBuilder sb = new StringBuilder(length + 5 + strConcat.length());
        sb.append("Expected ");
        sb.append(str);
        sb.append(" but was ");
        sb.append(strZza);
        sb.append(strZzl);
        sb.append("\nSee ");
        sb.append(strConcat);
        return new IllegalStateException(sb.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        return zzicd.class.getSimpleName().concat(zzl());
    }

    public final void zza(zzibl zziblVar) {
        Objects.requireNonNull(zziblVar);
        this.zzc = zziblVar;
    }

    public final void zzb() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 3) {
            throw zzw("BEGIN_ARRAY");
        }
        zzq(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzc() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 4) {
            throw zzw("END_ARRAY");
        }
        int i3 = this.zzl;
        this.zzl = i3 - 1;
        int[] iArr = this.zzn;
        int i4 = i3 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.zza = 0;
    }

    public final void zzd() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 1) {
            throw zzw("BEGIN_OBJECT");
        }
        zzq(3);
        this.zza = 0;
    }

    public final void zze() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 2) {
            throw zzw("END_OBJECT");
        }
        int i3 = this.zzl;
        int i4 = i3 - 1;
        this.zzl = i4;
        this.zzm[i4] = null;
        int[] iArr = this.zzn;
        int i5 = i3 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.zza = 0;
    }

    public final boolean zzf() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        return (iZzg == 2 || iZzg == 4 || iZzg == 17) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01a2, code lost:
    
        r23 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01de, code lost:
    
        r23 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x022c, code lost:
    
        if (zzn(r1) == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0247, code lost:
    
        if (r3 == 0) goto L179;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0296 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzg() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzicd.zzg():int");
    }

    public final String zzh() throws IOException {
        String strZzo;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 14) {
            strZzo = zzp();
        } else if (iZzg == 12) {
            strZzo = zzo('\'');
        } else {
            if (iZzg != 13) {
                throw zzw("a name");
            }
            strZzo = zzo('\"');
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = strZzo;
        return strZzo;
    }

    public final String zzi() throws IOException {
        String string;
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 10) {
            string = zzp();
        } else if (iZzg == 8) {
            string = zzo('\'');
        } else if (iZzg == 9) {
            string = zzo('\"');
        } else if (iZzg == 11) {
            string = null;
        } else if (iZzg == 15) {
            string = Long.toString(this.zzi);
        } else {
            if (iZzg != 16) {
                throw zzw("a string");
            }
            String str = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i3 = this.zzl - 1;
        iArr[i3] = iArr[i3] + 1;
        return string;
    }

    public final boolean zzj() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i3 = this.zzl - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (iZzg != 6) {
            throw zzw("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i4 = this.zzl - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return false;
    }

    public final void zzk() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        if (iZzg != 7) {
            throw zzw("null");
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i3 = this.zzl - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    final String zzl() {
        int i3 = this.zzg + 1;
        int i4 = this.zze - this.zzh;
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i5 = 0; i5 < this.zzl; i5++) {
            int i6 = this.zzk[i5];
            switch (i6) {
                case 1:
                case 2:
                    int i7 = this.zzn[i5];
                    sb.append('[');
                    sb.append(i7);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.zzm[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i6).length() + 21);
                    sb2.append("Unknown scope value: ");
                    sb2.append(i6);
                    throw new AssertionError(sb2.toString());
            }
        }
        int i8 = i4 + 1;
        String string = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(i3).length() + 17 + String.valueOf(i8).length() + 6 + string.length());
        sb3.append(" at line ");
        sb3.append(i3);
        sb3.append(" column ");
        sb3.append(i8);
        sb3.append(" path ");
        sb3.append(string);
        return sb3.toString();
    }

    public final int zzm() throws IOException {
        int iZzg = this.zza;
        if (iZzg == 0) {
            iZzg = zzg();
        }
        switch (iZzg) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
