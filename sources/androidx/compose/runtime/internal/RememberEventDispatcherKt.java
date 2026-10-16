package androidx.compose.runtime.internal;

import androidx.collection.MutableIntList;
import java.util.List;
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
public final class RememberEventDispatcherKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableIntList mutableIntList, int i3, int i4) {
        int iE = mutableIntList.e(i3);
        mutableIntList.q(i3, mutableIntList.e(i4));
        mutableIntList.q(i4, iE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(List list, int i3, int i4) {
        Object obj = list.get(i3);
        list.set(i3, list.get(i4));
        list.set(i4, obj);
    }
}
