package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
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
public final class InvalidationLiveDataContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f52170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f52171b;

    public InvalidationLiveDataContainer(RoomDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.f52170a = database;
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(...)");
        this.f52171b = setNewSetFromMap;
    }

    public final LiveData a(String[] tableNames, boolean z2, Callable callableFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(callableFunction, "callableFunction");
        return new RoomCallableTrackingLiveData(this.f52170a, this, z2, tableNames, callableFunction);
    }

    public final LiveData b(String[] tableNames, boolean z2, Function1 lambdaFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(lambdaFunction, "lambdaFunction");
        return new RoomLambdaTrackingLiveData(this.f52170a, this, z2, tableNames, lambdaFunction);
    }

    public final void c(LiveData liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        this.f52171b.add(liveData);
    }

    public final void d(LiveData liveData) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        this.f52171b.remove(liveData);
    }
}
