package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextPreparedSelectionKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10959a;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.f10350a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.f10353d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.f10352c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.f10351b.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f10959a = iArr;
        }
    }

    public static final long a(int i3, int i4, TransformedTextFieldState transformedTextFieldState) {
        if (i3 == -1) {
            return CursorAndWedgeAffinity.c(i4);
        }
        boolean z2 = i3 > i4;
        long jQ = transformedTextFieldState.q(i3);
        long jS = transformedTextFieldState.s(jQ);
        int i5 = WhenMappings.f10959a[((TextRange.h(jQ) && TextRange.h(jS)) ? IndexTransformationType.f10350a : (TextRange.h(jQ) || TextRange.h(jS)) ? (!TextRange.h(jQ) || TextRange.h(jS)) ? IndexTransformationType.f10353d : IndexTransformationType.f10351b : IndexTransformationType.f10352c).ordinal()];
        if (i5 == 1) {
            return CursorAndWedgeAffinity.d(i3, z2 ? WedgeAffinity.f10685a : WedgeAffinity.f10686b);
        }
        if (i5 == 2) {
            return CursorAndWedgeAffinity.c(i3);
        }
        if (i5 == 3) {
            return z2 ? CursorAndWedgeAffinity.d(TextRange.i(jS), WedgeAffinity.f10685a) : CursorAndWedgeAffinity.d(TextRange.n(jS), WedgeAffinity.f10686b);
        }
        if (i5 == 4) {
            return z2 ? i3 == TextRange.n(jS) ? CursorAndWedgeAffinity.d(i3, WedgeAffinity.f10685a) : CursorAndWedgeAffinity.d(TextRange.i(jS), WedgeAffinity.f10686b) : i3 == TextRange.i(jS) ? CursorAndWedgeAffinity.d(i3, WedgeAffinity.f10686b) : CursorAndWedgeAffinity.d(TextRange.n(jS), WedgeAffinity.f10685a);
        }
        throw new NoWhenBranchMatchedException();
    }
}
