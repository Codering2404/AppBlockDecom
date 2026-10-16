package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class TextFieldCharSequence implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f10138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f10139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextRange f10141d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Pair f10142f;

    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j3, TextRange textRange, Pair pair, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j3, textRange, pair, list);
    }

    public final boolean a(CharSequence charSequence) {
        return StringsKt.A(this.f10139b, charSequence);
    }

    public char b(int i3) {
        return this.f10139b.charAt(i3);
    }

    public final List c() {
        return this.f10138a;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return b(i3);
    }

    public final TextRange d() {
        return this.f10141d;
    }

    public final Pair e() {
        return this.f10142f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextFieldCharSequence.class != obj.getClass()) {
            return false;
        }
        TextFieldCharSequence textFieldCharSequence = (TextFieldCharSequence) obj;
        return TextRange.g(this.f10140c, textFieldCharSequence.f10140c) && Intrinsics.areEqual(this.f10141d, textFieldCharSequence.f10141d) && Intrinsics.areEqual(this.f10142f, textFieldCharSequence.f10142f) && Intrinsics.areEqual(this.f10138a, textFieldCharSequence.f10138a) && a(textFieldCharSequence.f10139b);
    }

    public int f() {
        return this.f10139b.length();
    }

    public final long g() {
        return this.f10140c;
    }

    public final CharSequence h() {
        return this.f10139b;
    }

    public int hashCode() {
        int iHashCode = ((this.f10139b.hashCode() * 31) + TextRange.o(this.f10140c)) * 31;
        TextRange textRange = this.f10141d;
        int iO = (iHashCode + (textRange != null ? TextRange.o(textRange.r()) : 0)) * 31;
        Pair pair = this.f10142f;
        int iHashCode2 = (iO + (pair != null ? pair.hashCode() : 0)) * 31;
        List list = this.f10138a;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean i() {
        return this.f10142f == null;
    }

    public final void j(char[] cArr, int i3, int i4, int i5) {
        ToCharArray_androidKt.a(this.f10139b, cArr, i3, i4, i5);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return f();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f10139b.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f10139b.toString();
    }

    private TextFieldCharSequence(CharSequence charSequence, long j3, TextRange textRange, Pair pair, List list) {
        this.f10138a = list;
        this.f10139b = charSequence instanceof TextFieldCharSequence ? ((TextFieldCharSequence) charSequence).f10139b : charSequence;
        this.f10140c = TextRangeKt.c(j3, 0, charSequence.length());
        this.f10141d = textRange != null ? TextRange.b(TextRangeKt.c(textRange.r(), 0, charSequence.length())) : null;
        this.f10142f = pair != null ? Pair.d(pair, null, TextRange.b(TextRangeKt.c(((TextRange) pair.f()).r(), 0, charSequence.length())), 1, null) : null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j3, TextRange textRange, Pair pair, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        CharSequence charSequence2 = (i3 & 1) != 0 ? "" : charSequence;
        long jA = (i3 & 2) != 0 ? TextRange.f28921b.a() : j3;
        TextRange textRange2 = (i3 & 4) != 0 ? null : textRange;
        this(charSequence2, jA, textRange2, (i3 & 8) != 0 ? null : pair, (i3 & 16) == 0 ? list : null, null);
    }
}
