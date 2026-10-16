package cz.mobilesoft.coreblock.storage.room.management;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback", f = "CoreDatabaseCallback.kt", l = {147}, m = "setDefaultsForCustomBlockingScreens", v = 1)
final class CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f126670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f126671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoreDatabaseCallback f126672d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f126673f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1(CoreDatabaseCallback coreDatabaseCallback, Continuation continuation) {
        super(continuation);
        this.f126672d = coreDatabaseCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f126671c = obj;
        this.f126673f |= Integer.MIN_VALUE;
        return this.f126672d.h(this);
    }
}
