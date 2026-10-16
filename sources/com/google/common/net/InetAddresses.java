package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class InetAddresses {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharMatcher f85339a = CharMatcher.k('.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharMatcher f85340b = CharMatcher.k(':');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Inet4Address f85341c = (Inet4Address) c("127.0.0.1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Inet4Address f85342d = (Inet4Address) c("0.0.0.0");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Scope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f85343a;

        private Scope() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class TeredoInfo {
    }

    private static InetAddress a(byte[] bArr, String str) {
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            if (str == null) {
                return byAddress;
            }
            Preconditions.e(byAddress instanceof Inet6Address, "Unexpected state, scope should only appear for ipv6");
            Inet6Address inet6Address = (Inet6Address) byAddress;
            int iK = k(str, 0, str.length());
            if (iK != -1) {
                return Inet6Address.getByAddress(inet6Address.getHostAddress(), inet6Address.getAddress(), iK);
            }
            try {
                NetworkInterface byName = NetworkInterface.getByName(str);
                if (byName != null) {
                    return Inet6Address.getByAddress(inet6Address.getHostAddress(), inet6Address.getAddress(), byName);
                }
                throw d("No such interface: '%s'", str);
            } catch (SocketException e3) {
                e = e3;
                throw new IllegalArgumentException("No such interface: " + str, e);
            } catch (UnknownHostException e4) {
                e = e4;
                throw new IllegalArgumentException("No such interface: " + str, e);
            }
        } catch (UnknownHostException e5) {
            throw new AssertionError(e5);
        }
    }

    private static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(58) + 1;
        String strSubstring = str.substring(0, iLastIndexOf);
        byte[] bArrI = i(str.substring(iLastIndexOf));
        if (bArrI == null) {
            return null;
        }
        return strSubstring + Integer.toHexString(((bArrI[0] & 255) << 8) | (bArrI[1] & 255)) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Integer.toHexString((bArrI[3] & 255) | ((bArrI[2] & 255) << 8));
    }

    public static InetAddress c(String str) {
        Scope scope = new Scope();
        byte[] bArrE = e(str, scope);
        if (bArrE != null) {
            return a(bArrE, scope.f85343a);
        }
        throw d("'%s' is not an IP string literal.", str);
    }

    private static IllegalArgumentException d(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r3 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        if (r2 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        r9 = b(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r1 == (-1)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r10 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r10.f85343a = r9.substring(r1 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        r9 = r9.substring(0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        return j(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
    
        if (r2 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
    
        if (r1 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        return i(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] e(java.lang.String r9, com.google.common.net.InetAddresses.Scope r10) {
        /*
            r0 = 0
            r1 = r0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r9.length()
            r5 = 0
            r6 = -1
            if (r1 >= r4) goto L31
            char r4 = r9.charAt(r1)
            r7 = 46
            r8 = 1
            if (r4 != r7) goto L17
            r2 = r8
            goto L2e
        L17:
            r7 = 58
            if (r4 != r7) goto L20
            if (r2 == 0) goto L1e
            return r5
        L1e:
            r3 = r8
            goto L2e
        L20:
            r7 = 37
            if (r4 != r7) goto L25
            goto L32
        L25:
            r7 = 16
            int r4 = java.lang.Character.digit(r4, r7)
            if (r4 != r6) goto L2e
            return r5
        L2e:
            int r1 = r1 + 1
            goto L4
        L31:
            r1 = r6
        L32:
            if (r3 == 0) goto L53
            if (r2 == 0) goto L3d
            java.lang.String r9 = b(r9)
            if (r9 != 0) goto L3d
            return r5
        L3d:
            if (r1 == r6) goto L4e
            if (r10 == 0) goto L4a
            int r2 = r1 + 1
            java.lang.String r2 = r9.substring(r2)
            com.google.common.net.InetAddresses.Scope.b(r10, r2)
        L4a:
            java.lang.String r9 = r9.substring(r0, r1)
        L4e:
            byte[] r9 = j(r9)
            return r9
        L53:
            if (r2 == 0) goto L5d
            if (r1 == r6) goto L58
            return r5
        L58:
            byte[] r9 = i(r9)
            return r9
        L5d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.e(java.lang.String, com.google.common.net.InetAddresses$Scope):byte[]");
    }

    public static boolean f(String str) {
        return e(str, null) != null;
    }

    private static short g(String str, int i3, int i4) {
        int i5 = i4 - i3;
        if (i5 <= 0 || i5 > 4) {
            throw new NumberFormatException();
        }
        int iDigit = 0;
        while (i3 < i4) {
            iDigit = (iDigit << 4) | Character.digit(str.charAt(i3), 16);
            i3++;
        }
        return (short) iDigit;
    }

    private static byte h(String str, int i3, int i4) {
        int i5 = i4 - i3;
        if (i5 <= 0 || i5 > 3) {
            throw new NumberFormatException();
        }
        if (i5 > 1 && str.charAt(i3) == '0') {
            throw new NumberFormatException();
        }
        int i6 = 0;
        while (i3 < i4) {
            int i7 = i6 * 10;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                throw new NumberFormatException();
            }
            i6 = i7 + iDigit;
            i3++;
        }
        if (i6 <= 255) {
            return (byte) i6;
        }
        throw new NumberFormatException();
    }

    private static byte[] i(String str) {
        if (f85339a.g(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int iIndexOf = str.indexOf(46, i3);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            try {
                bArr[i4] = h(str, i3, iIndexOf);
                i3 = iIndexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    private static byte[] j(String str) {
        int iG = f85340b.g(str);
        if (iG >= 2 && iG <= 8) {
            int i3 = 1;
            int i4 = iG + 1;
            int i5 = 8 - i4;
            boolean z2 = false;
            for (int i6 = 0; i6 < str.length() - 1; i6++) {
                if (str.charAt(i6) == ':' && str.charAt(i6 + 1) == ':') {
                    if (z2) {
                        return null;
                    }
                    int i7 = i5 + 1;
                    if (i6 == 0) {
                        i7 = i5 + 2;
                    }
                    if (i6 == str.length() - 2) {
                        i7++;
                    }
                    i5 = i7;
                    z2 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z2 && i5 <= 0) {
                return null;
            }
            if (!z2 && i4 != 8) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i3 = 0;
                }
                while (i3 < str.length()) {
                    int iIndexOf = str.indexOf(58, i3);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    if (str.charAt(i3) == ':') {
                        for (int i8 = 0; i8 < i5; i8++) {
                            byteBufferAllocate.putShort((short) 0);
                        }
                    } else {
                        byteBufferAllocate.putShort(g(str, i3, iIndexOf));
                    }
                    i3 = iIndexOf + 1;
                }
                return byteBufferAllocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private static int k(String str, int i3, int i4) {
        int i5 = 0;
        while (i3 < i4) {
            if (i5 > 214748364) {
                return -1;
            }
            int i6 = i5 * 10;
            int iDigit = Character.digit(str.charAt(i3), 10);
            if (iDigit < 0) {
                return -1;
            }
            i5 = i6 + iDigit;
            i3++;
        }
        return i5;
    }
}
