package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class GapBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char[] f10326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10328d;

    public GapBuffer(char[] cArr, int i3, int i4) {
        this.f10325a = cArr.length;
        this.f10326b = cArr;
        this.f10327c = i3;
        this.f10328d = i4;
    }

    private final void b(int i3, int i4) {
        int i5 = this.f10327c;
        if (i3 < i5 && i4 <= i5) {
            int i6 = i5 - i4;
            char[] cArr = this.f10326b;
            ArraysKt.copyInto(cArr, cArr, this.f10328d - i6, i4, i5);
            this.f10327c = i3;
            this.f10328d -= i6;
            return;
        }
        if (i3 < i5 && i4 >= i5) {
            this.f10328d = i4 + c();
            this.f10327c = i3;
            return;
        }
        int iC = i3 + c();
        int iC2 = i4 + c();
        int i7 = this.f10328d;
        char[] cArr2 = this.f10326b;
        ArraysKt.copyInto(cArr2, cArr2, this.f10327c, i7, iC);
        this.f10327c += iC - i7;
        this.f10328d = iC2;
    }

    private final int c() {
        return this.f10328d - this.f10327c;
    }

    private final void f(int i3) {
        if (i3 <= c()) {
            return;
        }
        int iC = i3 - c();
        int i4 = this.f10325a;
        do {
            i4 *= 2;
        } while (i4 - this.f10325a < iC);
        char[] cArr = new char[i4];
        ArraysKt.copyInto(this.f10326b, cArr, 0, 0, this.f10327c);
        int i5 = this.f10325a;
        int i6 = this.f10328d;
        int i7 = i5 - i6;
        int i8 = i4 - i7;
        ArraysKt.copyInto(this.f10326b, cArr, i8, i6, i7 + i6);
        this.f10326b = cArr;
        this.f10325a = i4;
        this.f10328d = i8;
    }

    public final void a(StringBuilder sb) {
        sb.append(this.f10326b, 0, this.f10327c);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        char[] cArr = this.f10326b;
        int i3 = this.f10328d;
        sb.append(cArr, i3, this.f10325a - i3);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
    }

    public final char d(int i3) {
        int i4 = this.f10327c;
        return i3 < i4 ? this.f10326b[i3] : this.f10326b[(i3 - i4) + this.f10328d];
    }

    public final int e() {
        return this.f10325a - c();
    }

    public final void g(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        int i7 = i6 - i5;
        f(i7 - (i4 - i3));
        b(i3, i4);
        ToCharArray_androidKt.a(charSequence, this.f10326b, this.f10327c, i5, i6);
        this.f10327c += i7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) sb);
        return sb.toString();
    }
}
