package androidx.room;

import androidx.room.util.DBUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Function1 f52337t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLambdaTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean z2, String[] tableNames, Function1 lambdaFunction) {
        super(database, container, z2, tableNames, null);
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(lambdaFunction, "lambdaFunction");
        this.f52337t = lambdaFunction;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object s(Continuation continuation) {
        return DBUtil.g(t(), true, u(), this.f52337t, continuation);
    }
}
