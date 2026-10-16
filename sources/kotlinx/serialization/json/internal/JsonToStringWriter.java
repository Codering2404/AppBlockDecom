package kotlinx.serialization.json.internal;

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
public final class JsonToStringWriter implements InternalJsonWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private char[] f143109a = CharArrayPool.f143060c.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143110b;

    private final void d(int i3, int i4, String str) {
        byte b3;
        int length = str.length();
        while (i3 < length) {
            int iF = f(i4, 2);
            char cCharAt = str.charAt(i3);
            if (cCharAt >= StringOpsKt.a().length || (b3 = StringOpsKt.a()[cCharAt]) == 0) {
                int i5 = iF + 1;
                this.f143109a[iF] = cCharAt;
                i4 = i5;
                i3++;
            } else {
                if (b3 == 1) {
                    String str2 = StringOpsKt.b()[cCharAt];
                    Intrinsics.checkNotNull(str2);
                    int iF2 = f(iF, str2.length());
                    str2.getChars(0, str2.length(), this.f143109a, iF2);
                    i4 = iF2 + str2.length();
                    this.f143110b = i4;
                } else {
                    char[] cArr = this.f143109a;
                    cArr[iF] = '\\';
                    cArr[iF + 1] = (char) b3;
                    i4 = iF + 2;
                    this.f143110b = i4;
                }
                i3++;
            }
        }
        int iF3 = f(i4, 1);
        this.f143109a[iF3] = '\"';
        this.f143110b = iF3 + 1;
    }

    private final void e(int i3) {
        f(this.f143110b, i3);
    }

    private final int f(int i3, int i4) {
        int i5 = i4 + i3;
        char[] cArr = this.f143109a;
        if (cArr.length <= i5) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, RangesKt.f(i5, i3 * 2));
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.f143109a = cArrCopyOf;
        }
        return i3;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void a(char c3) {
        e(1);
        char[] cArr = this.f143109a;
        int i3 = this.f143110b;
        this.f143110b = i3 + 1;
        cArr[i3] = c3;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void b(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        e(text.length() + 2);
        char[] cArr = this.f143109a;
        int i3 = this.f143110b;
        int i4 = i3 + 1;
        cArr[i3] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i4);
        int i5 = length + i4;
        for (int i6 = i4; i6 < i5; i6++) {
            char c3 = cArr[i6];
            if (c3 < StringOpsKt.a().length && StringOpsKt.a()[c3] != 0) {
                d(i6 - i4, i6, text);
                return;
            }
        }
        cArr[i5] = '\"';
        this.f143110b = i5 + 1;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void c(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        e(length);
        text.getChars(0, text.length(), this.f143109a, this.f143110b);
        this.f143110b += length;
    }

    public void g() {
        CharArrayPool.f143060c.c(this.f143109a);
    }

    public String toString() {
        return new String(this.f143109a, 0, this.f143110b);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long j3) {
        c(String.valueOf(j3));
    }
}
