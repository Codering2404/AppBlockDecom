package com.google.android.libraries.places.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f77674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f77675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f77676c = -1;

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008d, code lost:
    
        if ((r12 - r10) == 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        r3[r7] = (byte) r14;
        r11 = r17;
        r7 = r7 + 1;
        r10 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d7, code lost:
    
        if (r8 == 16) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d9, code lost:
    
        if (r9 != (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00db, code lost:
    
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        r0 = r8 - r9;
        java.lang.System.arraycopy(r3, r9, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r9, (16 - r8) + r9, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ec, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f2, code lost:
    
        throw new java.lang.AssertionError();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress f(java.lang.String r16, int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzcdm.f(java.lang.String, int, int):java.net.InetAddress");
    }

    public final zzcdm a(String str) {
        this.f77674a = "https";
        return this;
    }

    public final zzcdm b(String str) {
        int i3;
        String strSubstring;
        if (str == null) {
            throw new IllegalArgumentException("host == null");
        }
        int i4 = 0;
        int iCharCount = 0;
        while (true) {
            int length = str.length();
            i3 = -1;
            if (iCharCount >= length) {
                strSubstring = str.substring(0, length);
                break;
            }
            if (str.charAt(iCharCount) != '%') {
                iCharCount++;
            } else {
                zzcff zzcffVar = new zzcff();
                zzcffVar.O(str, 0, iCharCount);
                while (iCharCount < length) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt != 37) {
                        zzcffVar.V(iCodePointAt);
                    } else {
                        int i5 = iCharCount + 2;
                        if (i5 < length) {
                            int iD = zzcdn.d(str.charAt(iCharCount + 1));
                            int iD2 = zzcdn.d(str.charAt(i5));
                            if (iD != -1 && iD2 != -1) {
                                zzcffVar.a((iD << 4) + iD2);
                                iCharCount = i5;
                                iCodePointAt = 37;
                            }
                        }
                        iCodePointAt = 37;
                        zzcffVar.V(iCodePointAt);
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                }
                strSubstring = zzcffVar.F();
            }
        }
        String strF = null;
        if (strSubstring.startsWith("[") && strSubstring.endsWith("]")) {
            InetAddress inetAddressF = f(strSubstring, 1, strSubstring.length() - 1);
            if (inetAddressF != null) {
                byte[] address = inetAddressF.getAddress();
                if (address.length != 16) {
                    throw new AssertionError();
                }
                int i6 = 0;
                int i7 = 0;
                while (i6 < address.length) {
                    int i8 = i6;
                    while (i8 < 16 && address[i8] == 0 && address[i8 + 1] == 0) {
                        i8 += 2;
                    }
                    int i9 = i8 - i6;
                    int i10 = i9 > i7 ? i9 : i7;
                    if (i9 > i7) {
                        i3 = i6;
                    }
                    i6 = i8 + 2;
                    i7 = i10;
                }
                zzcff zzcffVar2 = new zzcff();
                while (i4 < address.length) {
                    if (i4 == i3) {
                        zzcffVar2.a(58);
                        i4 += i7;
                        if (i4 == 16) {
                            zzcffVar2.a(58);
                        }
                    } else {
                        if (i4 > 0) {
                            zzcffVar2.a(58);
                        }
                        zzcffVar2.i(((address[i4] & 255) << 8) | (address[i4 + 1] & 255));
                        i4 += 2;
                    }
                }
                strF = zzcffVar2.F();
            }
        } else {
            try {
                String lowerCase = IDN.toASCII(strSubstring).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    while (true) {
                        if (i4 >= lowerCase.length()) {
                            strF = lowerCase;
                            break;
                        }
                        char cCharAt = lowerCase.charAt(i4);
                        if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                            break;
                        }
                        i4++;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (strF == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        this.f77675b = strF;
        return this;
    }

    public final zzcdm c(int i3) {
        if (i3 > 0 && i3 <= 65535) {
            this.f77676c = i3;
            return this;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 17);
        sb.append("unexpected port: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }

    final int d() {
        int i3 = this.f77676c;
        return i3 != -1 ? i3 : zzcdn.c(this.f77674a);
    }

    public final zzcdn e() {
        if (this.f77674a == null) {
            throw new IllegalStateException("scheme == null");
        }
        if (this.f77675b != null) {
            return new zzcdn(this, null);
        }
        throw new IllegalStateException("host == null");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f77674a);
        sb.append("://");
        if (this.f77675b.indexOf(58) != -1) {
            sb.append('[');
            sb.append(this.f77675b);
            sb.append(']');
        } else {
            sb.append(this.f77675b);
        }
        int iD = d();
        if (iD != zzcdn.c(this.f77674a)) {
            sb.append(':');
            sb.append(iD);
        }
        return sb.toString();
    }
}
