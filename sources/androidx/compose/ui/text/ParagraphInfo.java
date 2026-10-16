package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.text.TextRange;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ParagraphInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paragraph f28733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f28738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f28739g;

    public ParagraphInfo(Paragraph paragraph, int i3, int i4, int i5, int i6, float f3, float f4) {
        this.f28733a = paragraph;
        this.f28734b = i3;
        this.f28735c = i4;
        this.f28736d = i5;
        this.f28737e = i6;
        this.f28738f = f3;
        this.f28739g = f4;
    }

    public static /* synthetic */ long l(ParagraphInfo paragraphInfo, long j3, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return paragraphInfo.k(j3, z2);
    }

    public final float a() {
        return this.f28739g;
    }

    public final int b() {
        return this.f28735c;
    }

    public final int c() {
        return this.f28737e;
    }

    public final int d() {
        return this.f28735c - this.f28734b;
    }

    public final Paragraph e() {
        return this.f28733a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        return Intrinsics.areEqual(this.f28733a, paragraphInfo.f28733a) && this.f28734b == paragraphInfo.f28734b && this.f28735c == paragraphInfo.f28735c && this.f28736d == paragraphInfo.f28736d && this.f28737e == paragraphInfo.f28737e && Float.compare(this.f28738f, paragraphInfo.f28738f) == 0 && Float.compare(this.f28739g, paragraphInfo.f28739g) == 0;
    }

    public final int f() {
        return this.f28734b;
    }

    public final int g() {
        return this.f28736d;
    }

    public final float h() {
        return this.f28738f;
    }

    public int hashCode() {
        return (((((((((((this.f28733a.hashCode() * 31) + Integer.hashCode(this.f28734b)) * 31) + Integer.hashCode(this.f28735c)) * 31) + Integer.hashCode(this.f28736d)) * 31) + Integer.hashCode(this.f28737e)) * 31) + Float.hashCode(this.f28738f)) * 31) + Float.hashCode(this.f28739g);
    }

    public final Rect i(Rect rect) {
        float f3 = this.f28738f;
        return rect.B(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)));
    }

    public final Path j(Path path) {
        float f3 = this.f28738f;
        path.p(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)));
        return path;
    }

    public final long k(long j3, boolean z2) {
        if (z2) {
            TextRange.Companion companion = TextRange.f28921b;
            if (TextRange.g(j3, companion.a())) {
                return companion.a();
            }
        }
        return TextRangeKt.b(m(TextRange.n(j3)), m(TextRange.i(j3)));
    }

    public final int m(int i3) {
        return i3 + this.f28734b;
    }

    public final int n(int i3) {
        return i3 + this.f28736d;
    }

    public final float o(float f3) {
        return f3 + this.f28738f;
    }

    public final Rect p(Rect rect) {
        float f3 = -this.f28738f;
        return rect.B(Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)));
    }

    public final long q(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) - this.f28738f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final int r(int i3) {
        return RangesKt.p(i3, this.f28734b, this.f28735c) - this.f28734b;
    }

    public final int s(int i3) {
        return i3 - this.f28736d;
    }

    public final float t(float f3) {
        return f3 - this.f28738f;
    }

    public String toString() {
        return "ParagraphInfo(paragraph=" + this.f28733a + ", startIndex=" + this.f28734b + ", endIndex=" + this.f28735c + ", startLineIndex=" + this.f28736d + ", endLineIndex=" + this.f28737e + ", top=" + this.f28738f + ", bottom=" + this.f28739g + ')';
    }
}
