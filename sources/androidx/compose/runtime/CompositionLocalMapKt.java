package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
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
public final class CompositionLocalMapKt {
    public static final boolean a(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return persistentCompositionLocalMap.containsKey(compositionLocal);
    }

    public static final Object b(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal compositionLocal) {
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        ValueHolder<Object> valueHolderA = persistentCompositionLocalMap.get(compositionLocal);
        if (valueHolderA == null) {
            valueHolderA = compositionLocal.a();
        }
        return valueHolderA.b(persistentCompositionLocalMap);
    }

    public static final PersistentCompositionLocalMap c(ProvidedValue[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalHashMap.Builder builderL = PersistentCompositionLocalMapKt.a().builder();
        for (ProvidedValue providedValue : providedValueArr) {
            CompositionLocal compositionLocalB = providedValue.b();
            Intrinsics.checkNotNull(compositionLocalB, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            ProvidableCompositionLocal providableCompositionLocal = (ProvidableCompositionLocal) compositionLocalB;
            if (providedValue.a() || !a(persistentCompositionLocalMap, providableCompositionLocal)) {
                ValueHolder valueHolder = (ValueHolder) persistentCompositionLocalMap2.get(providableCompositionLocal);
                Intrinsics.checkNotNull(providedValue, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
                builderL.put(providableCompositionLocal, providableCompositionLocal.b(providedValue, valueHolder));
            }
        }
        return builderL.build();
    }

    public static /* synthetic */ PersistentCompositionLocalMap d(ProvidedValue[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            persistentCompositionLocalMap2 = PersistentCompositionLocalMapKt.a();
        }
        return c(providedValueArr, persistentCompositionLocalMap, persistentCompositionLocalMap2);
    }
}
