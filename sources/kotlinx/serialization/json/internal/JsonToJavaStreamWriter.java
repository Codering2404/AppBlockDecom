package kotlinx.serialization.json.internal;

import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class JsonToJavaStreamWriter implements InternalJsonWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f143105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f143106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char[] f143107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f143108d;

    private final void d(int i3, String str) throws IOException {
        byte b3;
        int length = str.length();
        for (int i4 = i3 - 1; i4 < length; i4++) {
            int iE = e(i3, 2);
            char cCharAt = str.charAt(i4);
            if (cCharAt >= StringOpsKt.a().length || (b3 = StringOpsKt.a()[cCharAt]) == 0) {
                int i5 = iE + 1;
                this.f143107c[iE] = cCharAt;
                i3 = i5;
            } else {
                if (b3 == 1) {
                    String str2 = StringOpsKt.b()[cCharAt];
                    Intrinsics.checkNotNull(str2);
                    int iE2 = e(iE, str2.length());
                    str2.getChars(0, str2.length(), this.f143107c, iE2);
                    i3 = iE2 + str2.length();
                } else {
                    char[] cArr = this.f143107c;
                    cArr[iE] = '\\';
                    cArr[iE + 1] = (char) b3;
                    i3 = iE + 2;
                }
            }
        }
        e(i3, 1);
        char[] cArr2 = this.f143107c;
        cArr2[i3] = '\"';
        g(cArr2, i3 + 1);
        f();
    }

    private final int e(int i3, int i4) {
        int i5 = i4 + i3;
        char[] cArr = this.f143107c;
        if (cArr.length <= i5) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, RangesKt.f(i5, i3 * 2));
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.f143107c = cArrCopyOf;
        }
        return i3;
    }

    private final void f() throws IOException {
        this.f143105a.write(this.f143106b, 0, this.f143108d);
        this.f143108d = 0;
    }

    private final void g(char[] cArr, int i3) throws IOException {
        if (i3 < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        if (i3 > cArr.length) {
            throw new IllegalArgumentException(("count > string.length: " + i3 + " > " + cArr.length).toString());
        }
        int i4 = 0;
        while (i4 < i3) {
            char c3 = cArr[i4];
            if (c3 < 128) {
                if (this.f143106b.length - this.f143108d < 1) {
                    f();
                }
                byte[] bArr = this.f143106b;
                int i5 = this.f143108d;
                int i6 = i5 + 1;
                this.f143108d = i6;
                bArr[i5] = (byte) c3;
                i4++;
                int iMin = Math.min(i3, (bArr.length - i6) + i4);
                while (i4 < iMin) {
                    char c4 = cArr[i4];
                    if (c4 < 128) {
                        byte[] bArr2 = this.f143106b;
                        int i7 = this.f143108d;
                        this.f143108d = i7 + 1;
                        bArr2[i7] = (byte) c4;
                        i4++;
                    }
                }
            } else {
                if (c3 < 2048) {
                    if (this.f143106b.length - this.f143108d < 2) {
                        f();
                    }
                    byte[] bArr3 = this.f143106b;
                    int i8 = this.f143108d;
                    int i9 = i8 + 1;
                    this.f143108d = i9;
                    bArr3[i8] = (byte) ((c3 >> 6) | 192);
                    int i10 = (c3 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    this.f143108d = i8 + 2;
                    bArr3[i9] = (byte) i10;
                } else if (c3 < 55296 || c3 > 57343) {
                    if (this.f143106b.length - this.f143108d < 3) {
                        f();
                    }
                    byte[] bArr4 = this.f143106b;
                    int i11 = this.f143108d;
                    int i12 = i11 + 1;
                    this.f143108d = i12;
                    bArr4[i11] = (byte) ((c3 >> '\f') | 224);
                    int i13 = ((c3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    int i14 = i11 + 2;
                    this.f143108d = i14;
                    bArr4[i12] = (byte) i13;
                    int i15 = (c3 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    this.f143108d = i11 + 3;
                    bArr4[i14] = (byte) i15;
                } else {
                    int i16 = i4 + 1;
                    char c5 = i16 < i3 ? cArr[i16] : (char) 0;
                    if (c3 > 56319 || 56320 > c5 || c5 >= 57344) {
                        if (this.f143106b.length - this.f143108d < 1) {
                            f();
                        }
                        byte[] bArr5 = this.f143106b;
                        int i17 = this.f143108d;
                        this.f143108d = i17 + 1;
                        bArr5[i17] = (byte) 63;
                        i4 = i16;
                    } else {
                        int i18 = (((c3 & 1023) << 10) | (c5 & 1023)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        if (this.f143106b.length - this.f143108d < 4) {
                            f();
                        }
                        byte[] bArr6 = this.f143106b;
                        int i19 = this.f143108d;
                        int i20 = i19 + 1;
                        this.f143108d = i20;
                        bArr6[i19] = (byte) ((i18 >> 18) | 240);
                        int i21 = ((i18 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        int i22 = i19 + 2;
                        this.f143108d = i22;
                        bArr6[i20] = (byte) i21;
                        int i23 = ((i18 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        int i24 = i19 + 3;
                        this.f143108d = i24;
                        bArr6[i22] = (byte) i23;
                        int i25 = (i18 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        this.f143108d = i19 + 4;
                        bArr6[i24] = (byte) i25;
                        i4 += 2;
                    }
                }
                i4++;
            }
        }
    }

    private final void h(int i3) throws IOException {
        if (i3 < 128) {
            if (this.f143106b.length - this.f143108d < 1) {
                f();
            }
            byte[] bArr = this.f143106b;
            int i4 = this.f143108d;
            this.f143108d = i4 + 1;
            bArr[i4] = (byte) i3;
            return;
        }
        if (i3 < 2048) {
            if (this.f143106b.length - this.f143108d < 2) {
                f();
            }
            byte[] bArr2 = this.f143106b;
            int i5 = this.f143108d;
            int i6 = i5 + 1;
            this.f143108d = i6;
            bArr2[i5] = (byte) ((i3 >> 6) | 192);
            int i7 = (i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            this.f143108d = i5 + 2;
            bArr2[i6] = (byte) i7;
            return;
        }
        if (55296 <= i3 && i3 < 57344) {
            if (this.f143106b.length - this.f143108d < 1) {
                f();
            }
            byte[] bArr3 = this.f143106b;
            int i8 = this.f143108d;
            this.f143108d = i8 + 1;
            bArr3[i8] = (byte) 63;
            return;
        }
        if (i3 < 65536) {
            if (this.f143106b.length - this.f143108d < 3) {
                f();
            }
            byte[] bArr4 = this.f143106b;
            int i9 = this.f143108d;
            int i10 = i9 + 1;
            this.f143108d = i10;
            bArr4[i9] = (byte) ((i3 >> 12) | 224);
            int i11 = ((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            int i12 = i9 + 2;
            this.f143108d = i12;
            bArr4[i10] = (byte) i11;
            int i13 = (i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            this.f143108d = i9 + 3;
            bArr4[i12] = (byte) i13;
            return;
        }
        if (i3 > 1114111) {
            throw new JsonEncodingException("Unexpected code point: " + i3);
        }
        if (this.f143106b.length - this.f143108d < 4) {
            f();
        }
        byte[] bArr5 = this.f143106b;
        int i14 = this.f143108d;
        int i15 = i14 + 1;
        this.f143108d = i15;
        bArr5[i14] = (byte) ((i3 >> 18) | 240);
        int i16 = ((i3 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i17 = i14 + 2;
        this.f143108d = i17;
        bArr5[i15] = (byte) i16;
        int i18 = ((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i19 = i14 + 3;
        this.f143108d = i19;
        bArr5[i17] = (byte) i18;
        int i20 = (i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.f143108d = i14 + 4;
        bArr5[i19] = (byte) i20;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void a(char c3) throws IOException {
        h(c3);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void b(String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        e(0, text.length() + 2);
        char[] cArr = this.f143107c;
        cArr[0] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, 1);
        int i3 = length + 1;
        for (int i4 = 1; i4 < i3; i4++) {
            char c3 = cArr[i4];
            if (c3 < StringOpsKt.a().length && StringOpsKt.a()[c3] != 0) {
                d(i4, text);
                return;
            }
        }
        cArr[i3] = '\"';
        g(cArr, length + 2);
        f();
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void c(String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        e(0, length);
        text.getChars(0, length, this.f143107c, 0);
        g(this.f143107c, length);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long j3) throws IOException {
        c(String.valueOf(j3));
    }
}
