package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

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
public final class MultiParagraphLayoutCacheKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f11032a = TextUnitKt.i(14);

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(long j3, long j4) {
        if (!TextUnit.j(j4)) {
            throw new IllegalArgumentException("The multiplier must be in em, but was " + ((Object) TextUnit.l(j4)) + '.');
        }
        if (TextUnit.j(j3)) {
            throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + ((Object) TextUnit.l(j4)) + "). Please declare the style.fontSize with Sp units instead.");
        }
        if (TextUnit.f(j3) != 0) {
            float fH = TextUnit.h(j4);
            TextUnitKt.b(j3);
            return TextUnitKt.l(TextUnit.f(j3), TextUnit.h(j3) * fH);
        }
        long j5 = f11032a;
        float fH2 = TextUnit.h(j4);
        TextUnitKt.b(j5);
        return TextUnitKt.l(TextUnit.f(j5), TextUnit.h(j5) * fH2);
    }
}
