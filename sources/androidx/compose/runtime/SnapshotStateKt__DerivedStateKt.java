package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SnapshotThreadLocal f24242a = new SnapshotThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SnapshotThreadLocal f24243b = new SnapshotThreadLocal();

    public static final MutableVector b() {
        SnapshotThreadLocal snapshotThreadLocal = f24243b;
        MutableVector mutableVector = (MutableVector) snapshotThreadLocal.a();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector mutableVector2 = new MutableVector(new DerivedStateObserver[0], 0);
        snapshotThreadLocal.b(mutableVector2);
        return mutableVector2;
    }

    public static final State c(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0) {
        return new DerivedSnapshotState(function0, snapshotMutationPolicy);
    }

    public static final State d(Function0 function0) {
        return new DerivedSnapshotState(function0, null);
    }
}
