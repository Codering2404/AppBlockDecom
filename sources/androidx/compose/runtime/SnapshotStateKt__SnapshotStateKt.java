package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
final /* synthetic */ class SnapshotStateKt__SnapshotStateKt {
    public static final SnapshotStateList a() {
        return new SnapshotStateList();
    }

    public static final SnapshotStateList b(Object... objArr) {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        snapshotStateList.addAll(ArraysKt.toList(objArr));
        return snapshotStateList;
    }

    public static final SnapshotStateMap c() {
        return new SnapshotStateMap();
    }

    public static final MutableState d(Object obj, SnapshotMutationPolicy snapshotMutationPolicy) {
        return SnapshotState_androidKt.a(obj, snapshotMutationPolicy);
    }

    public static /* synthetic */ MutableState e(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.r();
        }
        return SnapshotStateKt.i(obj, snapshotMutationPolicy);
    }

    public static final State f(Object obj, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1058319986, i3, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:329)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = e(obj, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        mutableState.setValue(obj);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }
}
