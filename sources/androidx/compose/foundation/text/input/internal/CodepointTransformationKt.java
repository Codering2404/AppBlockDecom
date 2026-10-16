package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;
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
public final class CodepointTransformationKt {
    public static final CharSequence a(TextFieldCharSequence textFieldCharSequence, CodepointTransformation codepointTransformation, OffsetMappingCalculator offsetMappingCalculator) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (i3 < textFieldCharSequence.length()) {
            int iB = CodepointHelpers_jvmKt.b(textFieldCharSequence, i3);
            int iA = codepointTransformation.a(i4, iB);
            int iA2 = CodepointHelpers_jvmKt.a(iB);
            if (iA != iB) {
                offsetMappingCalculator.e(sb.length(), sb.length() + iA2, CodepointHelpers_jvmKt.a(iA));
                z2 = true;
            }
            StringHelpers_jvmKt.a(sb, iA);
            i3 += iA2;
            i4++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return z2 ? string : textFieldCharSequence;
    }
}
