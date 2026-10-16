package dev.doubledot.doki.api.extensions;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StringKt {
    public static final boolean hasContent(String receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return receiver$0.length() > 0 && !StringsKt.p0(receiver$0);
    }

    public static final String round(Number receiver$0, int i3) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append("#.");
        Iterator<Integer> it = new IntRange(1, i3).iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            sb.append("#");
        }
        DecimalFormat decimalFormat = new DecimalFormat(sb.toString());
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String str = decimalFormat.format(receiver$0);
        Intrinsics.checkExpressionValueIsNotNull(str, "formatter.format(this)");
        return str;
    }
}
