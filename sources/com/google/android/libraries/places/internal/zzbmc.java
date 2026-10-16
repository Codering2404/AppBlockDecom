package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbmc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BitSet f76392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f76393e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f76394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f76396c;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c3 = '0'; c3 <= '9'; c3 = (char) (c3 + 1)) {
            bitSet.set(c3);
        }
        for (char c4 = 'a'; c4 <= 'z'; c4 = (char) (c4 + 1)) {
            bitSet.set(c4);
        }
        f76392d = bitSet;
    }

    /* synthetic */ zzbmc(String str, boolean z2, Object obj, byte[] bArr) {
        String str2 = (String) Preconditions.u(str, "name");
        this.f76394a = str2;
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        Preconditions.u(lowerCase, "name");
        Preconditions.e(!lowerCase.isEmpty(), "token must have at least 1 tchar");
        if (lowerCase.equals("connection")) {
            zzbmb zzbmbVar = zzbmg.f76399d;
            zzbmg.f76398c.logp(Level.WARNING, "io.grpc.Metadata$Key", "validateName", "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        int i3 = 0;
        while (i3 < lowerCase.length()) {
            char cCharAt = lowerCase.charAt(i3);
            if (!z2 || cCharAt != ':') {
                Preconditions.g(f76392d.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, lowerCase);
            } else if (i3 == 0) {
                i3 = 0;
            } else {
                cCharAt = ':';
                Preconditions.g(f76392d.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, lowerCase);
            }
            i3++;
        }
        this.f76395b = lowerCase;
        this.f76396c = lowerCase.getBytes(StandardCharsets.US_ASCII);
    }

    public static zzbmc c(String str, zzbmb zzbmbVar) {
        return new zzbma(str, false, zzbmbVar, null);
    }

    abstract byte[] a(Object obj);

    abstract Object b(byte[] bArr);

    public final String d() {
        return this.f76395b;
    }

    final byte[] e() {
        return this.f76396c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f76395b.equals(((zzbmc) obj).f76395b);
    }

    public final int hashCode() {
        return this.f76395b.hashCode();
    }

    public final String toString() {
        String str = this.f76395b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append("Key{name='");
        sb.append(str);
        sb.append("'}");
        return sb.toString();
    }
}
