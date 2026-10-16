package androidx.compose.ui.text.input;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class GapBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char[] f29345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29347d;

    public GapBuffer(char[] cArr, int i3, int i4) {
        this.f29344a = cArr.length;
        this.f29345b = cArr;
        this.f29346c = i3;
        this.f29347d = i4;
    }

    private final void b(int i3, int i4) {
        int i5 = this.f29346c;
        if (i3 < i5 && i4 <= i5) {
            int i6 = i5 - i4;
            char[] cArr = this.f29345b;
            ArraysKt.copyInto(cArr, cArr, this.f29347d - i6, i4, i5);
            this.f29346c = i3;
            this.f29347d -= i6;
            return;
        }
        if (i3 < i5 && i4 >= i5) {
            this.f29347d = i4 + c();
            this.f29346c = i3;
            return;
        }
        int iC = i3 + c();
        int iC2 = i4 + c();
        int i7 = this.f29347d;
        char[] cArr2 = this.f29345b;
        ArraysKt.copyInto(cArr2, cArr2, this.f29346c, i7, iC);
        this.f29346c += iC - i7;
        this.f29347d = iC2;
    }

    private final int c() {
        return this.f29347d - this.f29346c;
    }

    private final void f(int i3) {
        if (i3 <= c()) {
            return;
        }
        int iC = i3 - c();
        int i4 = this.f29344a;
        do {
            i4 *= 2;
        } while (i4 - this.f29344a < iC);
        char[] cArr = new char[i4];
        ArraysKt.copyInto(this.f29345b, cArr, 0, 0, this.f29346c);
        int i5 = this.f29344a;
        int i6 = this.f29347d;
        int i7 = i5 - i6;
        int i8 = i4 - i7;
        ArraysKt.copyInto(this.f29345b, cArr, i8, i6, i7 + i6);
        this.f29345b = cArr;
        this.f29344a = i4;
        this.f29347d = i8;
    }

    public final void a(StringBuilder sb) {
        sb.append(this.f29345b, 0, this.f29346c);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        char[] cArr = this.f29345b;
        int i3 = this.f29347d;
        sb.append(cArr, i3, this.f29344a - i3);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
    }

    public final char d(int i3) {
        int i4 = this.f29346c;
        return i3 < i4 ? this.f29345b[i3] : this.f29345b[(i3 - i4) + this.f29347d];
    }

    public final int e() {
        return this.f29344a - c();
    }

    public final void g(int i3, int i4, String str) {
        f(str.length() - (i4 - i3));
        b(i3, i4);
        GapBufferKt.b(str, this.f29345b, this.f29346c);
        this.f29346c += str.length();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) sb);
        return sb.toString();
    }
}
