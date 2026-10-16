package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextStyleKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28929a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f28929a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformTextStyle b(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.a(platformSpanStyle, platformParagraphStyle);
    }

    public static final TextStyle c(TextStyle textStyle, TextStyle textStyle2, float f3) {
        return new TextStyle(SpanStyleKt.c(textStyle.P(), textStyle2.P(), f3), ParagraphStyleKt.b(textStyle.O(), textStyle2.O(), f3));
    }

    public static final TextStyle d(TextStyle textStyle, LayoutDirection layoutDirection) {
        return new TextStyle(SpanStyleKt.h(textStyle.A()), ParagraphStyleKt.e(textStyle.x(), layoutDirection), textStyle.y());
    }

    public static final int e(LayoutDirection layoutDirection, int i3) {
        TextDirection.Companion companion = TextDirection.f29630b;
        if (TextDirection.j(i3, companion.a())) {
            int i4 = WhenMappings.f28929a[layoutDirection.ordinal()];
            if (i4 == 1) {
                return companion.b();
            }
            if (i4 == 2) {
                return companion.c();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!TextDirection.j(i3, companion.f())) {
            return i3;
        }
        int i5 = WhenMappings.f28929a[layoutDirection.ordinal()];
        if (i5 == 1) {
            return companion.d();
        }
        if (i5 == 2) {
            return companion.e();
        }
        throw new NoWhenBranchMatchedException();
    }
}
