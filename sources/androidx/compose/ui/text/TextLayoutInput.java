package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TextLayoutInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f28891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f28892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f28893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f28895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f28896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Density f28897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LayoutDirection f28898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FontFamily.Resolver f28899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f28900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Font.ResourceLoader f28901k;

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i3, boolean z2, int i4, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, list, i3, z2, i4, density, layoutDirection, resolver, j3);
    }

    public final long a() {
        return this.f28900j;
    }

    public final Density b() {
        return this.f28897g;
    }

    public final FontFamily.Resolver c() {
        return this.f28899i;
    }

    public final LayoutDirection d() {
        return this.f28898h;
    }

    public final int e() {
        return this.f28894d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return Intrinsics.areEqual(this.f28891a, textLayoutInput.f28891a) && Intrinsics.areEqual(this.f28892b, textLayoutInput.f28892b) && Intrinsics.areEqual(this.f28893c, textLayoutInput.f28893c) && this.f28894d == textLayoutInput.f28894d && this.f28895e == textLayoutInput.f28895e && TextOverflow.h(this.f28896f, textLayoutInput.f28896f) && Intrinsics.areEqual(this.f28897g, textLayoutInput.f28897g) && this.f28898h == textLayoutInput.f28898h && Intrinsics.areEqual(this.f28899i, textLayoutInput.f28899i) && Constraints.f(this.f28900j, textLayoutInput.f28900j);
    }

    public final int f() {
        return this.f28896f;
    }

    public final List g() {
        return this.f28893c;
    }

    public final boolean h() {
        return this.f28895e;
    }

    public int hashCode() {
        return (((((((((((((((((this.f28891a.hashCode() * 31) + this.f28892b.hashCode()) * 31) + this.f28893c.hashCode()) * 31) + this.f28894d) * 31) + Boolean.hashCode(this.f28895e)) * 31) + TextOverflow.i(this.f28896f)) * 31) + this.f28897g.hashCode()) * 31) + this.f28898h.hashCode()) * 31) + this.f28899i.hashCode()) * 31) + Constraints.o(this.f28900j);
    }

    public final TextStyle i() {
        return this.f28892b;
    }

    public final AnnotatedString j() {
        return this.f28891a;
    }

    public String toString() {
        return "TextLayoutInput(text=" + ((Object) this.f28891a) + ", style=" + this.f28892b + ", placeholders=" + this.f28893c + ", maxLines=" + this.f28894d + ", softWrap=" + this.f28895e + ", overflow=" + ((Object) TextOverflow.j(this.f28896f)) + ", density=" + this.f28897g + ", layoutDirection=" + this.f28898h + ", fontFamilyResolver=" + this.f28899i + ", constraints=" + ((Object) Constraints.q(this.f28900j)) + ')';
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i3, boolean z2, int i4, Density density, LayoutDirection layoutDirection, Font.ResourceLoader resourceLoader, FontFamily.Resolver resolver, long j3) {
        this.f28891a = annotatedString;
        this.f28892b = textStyle;
        this.f28893c = list;
        this.f28894d = i3;
        this.f28895e = z2;
        this.f28896f = i4;
        this.f28897g = density;
        this.f28898h = layoutDirection;
        this.f28899i = resolver;
        this.f28900j = j3;
        this.f28901k = resourceLoader;
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i3, boolean z2, int i4, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3) {
        this(annotatedString, textStyle, list, i3, z2, i4, density, layoutDirection, (Font.ResourceLoader) null, resolver, j3);
    }
}
