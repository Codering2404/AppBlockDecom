package androidx.compose.ui.semantics;

import androidx.collection.MutableObjectList;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SemanticsInfoKt {
    public static final SemanticsConfiguration a(SemanticsInfo semanticsInfo) {
        SemanticsConfiguration semanticsConfigurationQ = semanticsInfo.Q();
        if (semanticsConfigurationQ != null && semanticsConfigurationQ.p() && !semanticsConfigurationQ.o()) {
            semanticsConfigurationQ = semanticsConfigurationQ.f();
            MutableObjectList mutableObjectList = new MutableObjectList(semanticsInfo.R().size());
            mutableObjectList.r(semanticsInfo.R());
            while (mutableObjectList.h()) {
                SemanticsInfo semanticsInfo2 = (SemanticsInfo) mutableObjectList.A(mutableObjectList.f3082b - 1);
                SemanticsConfiguration semanticsConfigurationQ2 = semanticsInfo2.Q();
                if (semanticsConfigurationQ2 != null && !semanticsConfigurationQ2.p()) {
                    semanticsConfigurationQ.q(semanticsConfigurationQ2);
                    if (!semanticsConfigurationQ2.o()) {
                        mutableObjectList.r(semanticsInfo2.R());
                    }
                }
            }
        }
        return semanticsConfigurationQ;
    }
}
