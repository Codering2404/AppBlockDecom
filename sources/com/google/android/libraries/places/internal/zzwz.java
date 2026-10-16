package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzwz extends zzwx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f78788a;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (SecurityException unused) {
        }
        if (!property.matches("\\n|\\r(?:\\n)?")) {
            property = "\n";
        }
        f78788a = property;
    }

    static int d(String str, int i3) {
        while (i3 < str.length()) {
            int i4 = i3 + 1;
            if (str.charAt(i3) != '%') {
                i3 = i4;
            } else {
                if (i4 >= str.length()) {
                    throw zzwy.c("trailing unquoted '%' character", str, i3);
                }
                char cCharAt = str.charAt(i4);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i3;
                }
                i3 += 2;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
    
        r1 = r15;
        r4 = d(r3, c(r1, r2, r3, r4, r5, r6));
        r15 = r1;
        r1 = r2;
        r0 = r9;
     */
    @Override // com.google.android.libraries.places.internal.zzwx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a(com.google.android.libraries.places.internal.zzww r15) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzwz.a(com.google.android.libraries.places.internal.zzww):void");
    }

    @Override // com.google.android.libraries.places.internal.zzwx
    public final void b(StringBuilder sb, String str, int i3, int i4) {
        int i5 = i3;
        while (i3 < i4) {
            int i6 = i3 + 1;
            if (str.charAt(i3) == '%') {
                if (i6 == i4) {
                    break;
                }
                char cCharAt = str.charAt(i6);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i5, i6);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i5, i3);
                    sb.append(f78788a);
                }
                i5 = i3 + 2;
                i3 = i5;
            }
            i3 = i6;
        }
        if (i5 < i4) {
            sb.append((CharSequence) str, i5, i4);
        }
    }

    abstract int c(zzww zzwwVar, int i3, String str, int i4, int i5, int i6);
}
