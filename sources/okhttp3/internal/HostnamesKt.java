package okhttp3.internal;

import com.revenuecat.purchases.common.Constants;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class HostnamesKt {
    private static final boolean a(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0 || StringsKt.m0(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
            i3 = i4;
        }
        return false;
    }

    private static final boolean b(String str, int i3, int i4, byte[] bArr, int i5) {
        int i6 = i5;
        while (i3 < i4) {
            if (i6 == bArr.length) {
                return false;
            }
            if (i6 != i5) {
                if (str.charAt(i3) != '.') {
                    return false;
                }
                i3++;
            }
            int i7 = i3;
            int i8 = 0;
            while (i7 < i4) {
                char cCharAt = str.charAt(i7);
                if (Intrinsics.compare((int) cCharAt, 48) < 0 || Intrinsics.compare((int) cCharAt, 57) > 0) {
                    break;
                }
                if ((i8 == 0 && i3 != i7) || (i8 = ((i8 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i7++;
            }
            if (i7 - i3 == 0) {
                return false;
            }
            bArr[i6] = (byte) i8;
            i6++;
            i3 = i7;
        }
        return i6 == i5 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        if (r11 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0094, code lost:
    
        if (r12 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0096, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
    
        r0 = r11 - r12;
        java.lang.System.arraycopy(r8, r12, r8, 16 - r0, r0);
        java.util.Arrays.fill(r8, r12, (16 - r11) + r12, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
    
        return java.net.InetAddress.getByAddress(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.net.InetAddress c(java.lang.String r16, int r17, int r18) {
        /*
            r6 = r18
            r7 = 16
            byte[] r8 = new byte[r7]
            r9 = 0
            r10 = -1
            r2 = r17
            r11 = r9
            r12 = r10
            r13 = r12
        Ld:
            r14 = 0
            if (r2 >= r6) goto L92
            if (r11 != r7) goto L13
            return r14
        L13:
            int r15 = r2 + 2
            if (r15 > r6) goto L33
            r4 = 4
            r5 = 0
            java.lang.String r1 = "::"
            r3 = 0
            r0 = r16
            boolean r1 = kotlin.text.StringsKt.T(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L33
            if (r12 == r10) goto L27
            return r14
        L27:
            int r11 = r11 + 2
            if (r15 != r6) goto L2e
            r12 = r11
            goto L92
        L2e:
            r0 = r16
            r12 = r11
            r13 = r15
            goto L62
        L33:
            if (r11 == 0) goto L44
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r3 = 0
            r0 = r16
            boolean r1 = kotlin.text.StringsKt.T(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L48
            int r2 = r2 + 1
        L44:
            r0 = r16
            r13 = r2
            goto L62
        L48:
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r3 = 0
            r0 = r16
            boolean r1 = kotlin.text.StringsKt.T(r0, r1, r2, r3, r4, r5)
            if (r1 == 0) goto L61
            int r1 = r11 + (-2)
            boolean r0 = b(r0, r13, r6, r8, r1)
            if (r0 != 0) goto L5e
            return r14
        L5e:
            int r11 = r11 + 2
            goto L92
        L61:
            return r14
        L62:
            r1 = r9
            r2 = r13
        L64:
            if (r2 >= r6) goto L77
            char r3 = r0.charAt(r2)
            int r3 = okhttp3.internal.Util.I(r3)
            if (r3 != r10) goto L71
            goto L77
        L71:
            int r1 = r1 << 4
            int r1 = r1 + r3
            int r2 = r2 + 1
            goto L64
        L77:
            int r3 = r2 - r13
            if (r3 == 0) goto L91
            r4 = 4
            if (r3 <= r4) goto L7f
            goto L91
        L7f:
            int r3 = r11 + 1
            int r4 = r1 >>> 8
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r8[r11] = r4
            int r11 = r11 + 2
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r8[r3] = r1
            goto Ld
        L91:
            return r14
        L92:
            if (r11 == r7) goto La3
            if (r12 != r10) goto L97
            return r14
        L97:
            int r0 = r11 - r12
            int r1 = 16 - r0
            java.lang.System.arraycopy(r8, r12, r8, r1, r0)
            int r7 = r7 - r11
            int r7 = r7 + r12
            java.util.Arrays.fill(r8, r12, r7, r9)
        La3:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.c(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String d(byte[] bArr) {
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < bArr.length) {
            int i7 = i5;
            while (i7 < 16 && bArr[i7] == 0 && bArr[i7 + 1] == 0) {
                i7 += 2;
            }
            int i8 = i7 - i5;
            if (i8 > i6 && i8 >= 4) {
                i3 = i5;
                i6 = i8;
            }
            i5 = i7 + 2;
        }
        Buffer buffer = new Buffer();
        while (i4 < bArr.length) {
            if (i4 == i3) {
                buffer.writeByte(58);
                i4 += i6;
                if (i4 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i4 > 0) {
                    buffer.writeByte(58);
                }
                buffer.e2((Util.d(bArr[i4], 255) << 8) | Util.d(bArr[i4 + 1], 255));
                i4 += 2;
            }
        }
        return buffer.e0();
    }

    public static final String e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!StringsKt.a0(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = ascii.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                if (a(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressC = (StringsKt.U(str, "[", false, 2, null) && StringsKt.E(str, "]", false, 2, null)) ? c(str, 1, str.length() - 1) : c(str, 0, str.length());
        if (inetAddressC == null) {
            return null;
        }
        byte[] address = inetAddressC.getAddress();
        if (address.length == 16) {
            Intrinsics.checkNotNullExpressionValue(address, "address");
            return d(address);
        }
        if (address.length == 4) {
            return inetAddressC.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
