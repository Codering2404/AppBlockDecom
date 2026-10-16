package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PartialGapBuffer implements CharSequence {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f10412f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10413g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f10414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GapBuffer f10415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10416c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10417d = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PartialGapBuffer(CharSequence charSequence) {
        this.f10414a = charSequence;
    }

    public static /* synthetic */ void d(PartialGapBuffer partialGapBuffer, int i3, int i4, CharSequence charSequence, int i5, int i6, int i7, Object obj) {
        if ((i7 & 8) != 0) {
            i5 = 0;
        }
        int i8 = i5;
        if ((i7 & 16) != 0) {
            i6 = charSequence.length();
        }
        partialGapBuffer.c(i3, i4, charSequence, i8, i6);
    }

    public char a(int i3) {
        GapBuffer gapBuffer = this.f10415b;
        if (gapBuffer == null) {
            return this.f10414a.charAt(i3);
        }
        if (i3 < this.f10416c) {
            return this.f10414a.charAt(i3);
        }
        int iE = gapBuffer.e();
        int i4 = this.f10416c;
        return i3 < iE + i4 ? gapBuffer.d(i3 - i4) : this.f10414a.charAt(i3 - ((iE - this.f10417d) + i4));
    }

    public int b() {
        GapBuffer gapBuffer = this.f10415b;
        return gapBuffer == null ? this.f10414a.length() : (this.f10414a.length() - (this.f10417d - this.f10416c)) + gapBuffer.e();
    }

    public final void c(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        if (!(i3 <= i4)) {
            InlineClassHelperKt.a("start=" + i3 + " > end=" + i4);
        }
        if (!(i5 <= i6)) {
            InlineClassHelperKt.a("textStart=" + i5 + " > textEnd=" + i6);
        }
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("start must be non-negative, but was " + i3);
        }
        if (!(i5 >= 0)) {
            InlineClassHelperKt.a("textStart must be non-negative, but was " + i5);
        }
        GapBuffer gapBuffer = this.f10415b;
        int i7 = i6 - i5;
        if (gapBuffer != null) {
            int i8 = this.f10416c;
            int i9 = i3 - i8;
            int i10 = i4 - i8;
            if (i9 >= 0 && i10 <= gapBuffer.e()) {
                gapBuffer.g(i9, i10, charSequence, i5, i6);
                return;
            }
            this.f10414a = toString();
            this.f10415b = null;
            this.f10416c = -1;
            this.f10417d = -1;
            c(i3, i4, charSequence, i5, i6);
            return;
        }
        int iMax = Math.max(255, i7 + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        char[] cArr = new char[iMax];
        int iMin = Math.min(i3, 64);
        int iMin2 = Math.min(this.f10414a.length() - i4, 64);
        int i11 = i3 - iMin;
        ToCharArray_androidKt.a(this.f10414a, cArr, 0, i11, i3);
        int i12 = iMax - iMin2;
        int i13 = iMin2 + i4;
        ToCharArray_androidKt.a(this.f10414a, cArr, i12, i4, i13);
        ToCharArray_androidKt.a(charSequence, cArr, iMin, i5, i6);
        this.f10415b = new GapBuffer(cArr, iMin + i7, i12);
        this.f10416c = i11;
        this.f10417d = i13;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return a(i3);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return b();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return toString().subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        GapBuffer gapBuffer = this.f10415b;
        if (gapBuffer == null) {
            return this.f10414a.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10414a, 0, this.f10416c);
        gapBuffer.a(sb);
        CharSequence charSequence = this.f10414a;
        sb.append(charSequence, this.f10417d, charSequence.length());
        return sb.toString();
    }
}
