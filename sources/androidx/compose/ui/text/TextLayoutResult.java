package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
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
public final class TextLayoutResult {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f28902g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextLayoutInput f28903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MultiParagraph f28904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f28906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f28907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f28908f;

    public /* synthetic */ TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutInput, multiParagraph, j3);
    }

    public static /* synthetic */ TextLayoutResult b(TextLayoutResult textLayoutResult, TextLayoutInput textLayoutInput, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            textLayoutInput = textLayoutResult.f28903a;
        }
        if ((i3 & 2) != 0) {
            j3 = textLayoutResult.f28905c;
        }
        return textLayoutResult.a(textLayoutInput, j3);
    }

    public static /* synthetic */ int p(TextLayoutResult textLayoutResult, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        return textLayoutResult.o(i3, z2);
    }

    public final List A() {
        return this.f28908f;
    }

    public final long B() {
        return this.f28905c;
    }

    public final long C(int i3) {
        return this.f28904b.E(i3);
    }

    public final boolean D(int i3) {
        return this.f28904b.F(i3);
    }

    public final TextLayoutResult a(TextLayoutInput textLayoutInput, long j3) {
        return new TextLayoutResult(textLayoutInput, this.f28904b, j3, null);
    }

    public final ResolvedTextDirection c(int i3) {
        return this.f28904b.c(i3);
    }

    public final Rect d(int i3) {
        return this.f28904b.d(i3);
    }

    public final Rect e(int i3) {
        return this.f28904b.e(i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutResult)) {
            return false;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
        return Intrinsics.areEqual(this.f28903a, textLayoutResult.f28903a) && Intrinsics.areEqual(this.f28904b, textLayoutResult.f28904b) && IntSize.e(this.f28905c, textLayoutResult.f28905c) && this.f28906d == textLayoutResult.f28906d && this.f28907e == textLayoutResult.f28907e && Intrinsics.areEqual(this.f28908f, textLayoutResult.f28908f);
    }

    public final boolean f() {
        return this.f28904b.f() || ((float) ((int) (this.f28905c & 4294967295L))) < this.f28904b.h();
    }

    public final boolean g() {
        return ((float) ((int) (this.f28905c >> 32))) < this.f28904b.D();
    }

    public final float h() {
        return this.f28906d;
    }

    public int hashCode() {
        return (((((((((this.f28903a.hashCode() * 31) + this.f28904b.hashCode()) * 31) + IntSize.h(this.f28905c)) * 31) + Float.hashCode(this.f28906d)) * 31) + Float.hashCode(this.f28907e)) * 31) + this.f28908f.hashCode();
    }

    public final boolean i() {
        return g() || f();
    }

    public final float j(int i3, boolean z2) {
        return this.f28904b.i(i3, z2);
    }

    public final float k() {
        return this.f28907e;
    }

    public final TextLayoutInput l() {
        return this.f28903a;
    }

    public final float m(int i3) {
        return this.f28904b.l(i3);
    }

    public final int n() {
        return this.f28904b.m();
    }

    public final int o(int i3, boolean z2) {
        return this.f28904b.n(i3, z2);
    }

    public final int q(int i3) {
        return this.f28904b.p(i3);
    }

    public final int r(float f3) {
        return this.f28904b.q(f3);
    }

    public final float s(int i3) {
        return this.f28904b.s(i3);
    }

    public final float t(int i3) {
        return this.f28904b.t(i3);
    }

    public String toString() {
        return "TextLayoutResult(layoutInput=" + this.f28903a + ", multiParagraph=" + this.f28904b + ", size=" + ((Object) IntSize.i(this.f28905c)) + ", firstBaseline=" + this.f28906d + ", lastBaseline=" + this.f28907e + ", placeholderRects=" + this.f28908f + ')';
    }

    public final int u(int i3) {
        return this.f28904b.u(i3);
    }

    public final float v(int i3) {
        return this.f28904b.v(i3);
    }

    public final MultiParagraph w() {
        return this.f28904b;
    }

    public final int x(long j3) {
        return this.f28904b.x(j3);
    }

    public final ResolvedTextDirection y(int i3) {
        return this.f28904b.y(i3);
    }

    public final Path z(int i3, int i4) {
        return this.f28904b.A(i3, i4);
    }

    private TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j3) {
        this.f28903a = textLayoutInput;
        this.f28904b = multiParagraph;
        this.f28905c = j3;
        this.f28906d = multiParagraph.g();
        this.f28907e = multiParagraph.k();
        this.f28908f = multiParagraph.B();
    }
}
