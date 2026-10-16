package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
final /* synthetic */ class SnapshotStateKt__ProduceStateKt {
    public static final State a(Object obj, Object obj2, Object obj3, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1703169085, i3, -1, "androidx.compose.runtime.produceState (ProduceState.kt:135)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        boolean zI = composer.I(function2);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new SnapshotStateKt__ProduceStateKt$produceState$3$1(function2, mutableState, null);
            composer.w(objG2);
        }
        EffectsKt.f(obj2, obj3, (Function2) objG2, composer, (i3 >> 3) & 126);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }

    public static final State b(Object obj, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(10454275, i3, -1, "androidx.compose.runtime.produceState (ProduceState.kt:74)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        Unit unit = Unit.f139807a;
        boolean zI = composer.I(function2);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, null);
            composer.w(objG2);
        }
        EffectsKt.g(unit, (Function2) objG2, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }

    public static final State c(Object obj, Object[] objArr, Function2 function2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(490154582, i3, -1, "androidx.compose.runtime.produceState (ProduceState.kt:197)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        boolean zI = composer.I(function2);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new SnapshotStateKt__ProduceStateKt$produceState$5$1(function2, mutableState, null);
            composer.w(objG2);
        }
        EffectsKt.i(objArrCopyOf, (Function2) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }
}
