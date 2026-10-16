package androidx.compose.foundation.text;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
final class TextAnnotatorScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f9884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnnotatedString f9885b;

    public TextAnnotatorScope(AnnotatedString annotatedString) {
        this.f9884a = annotatedString;
        this.f9885b = annotatedString;
    }

    public final AnnotatedString a() {
        return this.f9885b;
    }

    public final void b(final AnnotatedString.Range range, final SpanStyle spanStyle) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        this.f9885b = this.f9884a.q(new Function1<AnnotatedString.Range<? extends AnnotatedString.Annotation>, AnnotatedString.Range<? extends AnnotatedString.Annotation>>() { // from class: androidx.compose.foundation.text.TextAnnotatorScope$replaceStyle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AnnotatedString.Range invoke(AnnotatedString.Range range2) {
                AnnotatedString.Range range3;
                if (booleanRef.f140137a && (range2.g() instanceof SpanStyle) && range2.h() == range.h() && range2.f() == range.f()) {
                    SpanStyle spanStyle2 = spanStyle;
                    if (spanStyle2 == null) {
                        spanStyle2 = new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65535, (DefaultConstructorMarker) null);
                    }
                    range3 = new AnnotatedString.Range(spanStyle2, range2.h(), range2.f());
                } else {
                    range3 = range2;
                }
                booleanRef.f140137a = Intrinsics.areEqual(range, range2);
                return range3;
            }
        });
    }
}
