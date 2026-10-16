package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class SavedStateHandleSaverKt$mutableStateSaver$1$2 implements Function1<MutableState<Object>, MutableState<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Saver f40243a;

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final MutableState invoke(MutableState mutableState) {
        Object objB;
        if (!(mutableState instanceof SnapshotMutableState)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        SnapshotMutableState snapshotMutableState = (SnapshotMutableState) mutableState;
        if (snapshotMutableState.getValue() != null) {
            Saver saver = this.f40243a;
            Object value = snapshotMutableState.getValue();
            Intrinsics.checkNotNull(value);
            objB = saver.b(value);
        } else {
            objB = null;
        }
        SnapshotMutationPolicy snapshotMutationPolicyF = snapshotMutableState.f();
        Intrinsics.checkNotNull(snapshotMutationPolicyF, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver?>");
        MutableState mutableStateI = SnapshotStateKt.i(objB, snapshotMutationPolicyF);
        Intrinsics.checkNotNull(mutableStateI, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.mutableStateSaver>");
        return mutableStateI;
    }
}
