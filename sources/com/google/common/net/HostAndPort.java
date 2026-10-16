package com.google.common.net;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f85335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f85337c;

    private HostAndPort(String str, int i3, boolean z2) {
        this.f85335a = str;
        this.f85336b = i3;
        this.f85337c = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.common.net.HostAndPort a(java.lang.String r7) {
        /*
            com.google.common.base.Preconditions.t(r7)
            java.lang.String r0 = "["
            boolean r0 = r7.startsWith(r0)
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L19
            java.lang.String[] r0 = c(r7)
            r4 = r0[r3]
            r0 = r0[r2]
        L16:
            r5 = r4
            r4 = r3
            goto L3c
        L19:
            r0 = 58
            int r4 = r7.indexOf(r0)
            if (r4 < 0) goto L32
            int r5 = r4 + 1
            int r0 = r7.indexOf(r0, r5)
            if (r0 != r1) goto L32
            java.lang.String r4 = r7.substring(r3, r4)
            java.lang.String r0 = r7.substring(r5)
            goto L16
        L32:
            if (r4 < 0) goto L36
            r0 = r2
            goto L37
        L36:
            r0 = r3
        L37:
            r4 = 0
            r5 = r4
            r4 = r0
            r0 = r5
            r5 = r7
        L3c:
            boolean r6 = com.google.common.base.Strings.b(r0)
            if (r6 != 0) goto L80
            java.lang.String r1 = "+"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L55
            com.google.common.base.CharMatcher r1 = com.google.common.base.CharMatcher.f()
            boolean r1 = r1.p(r0)
            if (r1 == 0) goto L55
            goto L56
        L55:
            r2 = r3
        L56:
            java.lang.String r1 = "Unparseable port number: %s"
            com.google.common.base.Preconditions.m(r2, r1, r7)
            int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L69
            boolean r0 = e(r1)
            java.lang.String r2 = "Port number out of range: %s"
            com.google.common.base.Preconditions.m(r0, r2, r7)
            goto L80
        L69:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unparseable port number: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L80:
            com.google.common.net.HostAndPort r7 = new com.google.common.net.HostAndPort
            r7.<init>(r5, r1, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.HostAndPort.a(java.lang.String):com.google.common.net.HostAndPort");
    }

    private static String[] c(String str) {
        Preconditions.m(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(93);
        Preconditions.m(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", str);
        String strSubstring = str.substring(1, iLastIndexOf);
        int i3 = iLastIndexOf + 1;
        if (i3 == str.length()) {
            return new String[]{strSubstring, ""};
        }
        Preconditions.m(str.charAt(i3) == ':', "Only a colon may follow a close bracket: %s", str);
        int i4 = iLastIndexOf + 2;
        for (int i5 = i4; i5 < str.length(); i5++) {
            Preconditions.m(Character.isDigit(str.charAt(i5)), "Port must be numeric: %s", str);
        }
        return new String[]{strSubstring, str.substring(i4)};
    }

    private static boolean e(int i3) {
        return i3 >= 0 && i3 <= 65535;
    }

    public String b() {
        return this.f85335a;
    }

    public boolean d() {
        return this.f85336b >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostAndPort) {
            HostAndPort hostAndPort = (HostAndPort) obj;
            if (Objects.a(this.f85335a, hostAndPort.f85335a) && this.f85336b == hostAndPort.f85336b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.f85335a, Integer.valueOf(this.f85336b));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f85335a.length() + 8);
        if (this.f85335a.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.f85335a);
            sb.append(']');
        } else {
            sb.append(this.f85335a);
        }
        if (d()) {
            sb.append(':');
            sb.append(this.f85336b);
        }
        return sb.toString();
    }
}
