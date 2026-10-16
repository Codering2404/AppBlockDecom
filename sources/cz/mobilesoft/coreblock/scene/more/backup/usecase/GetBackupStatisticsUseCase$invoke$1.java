package cz.mobilesoft.coreblock.scene.more.backup.usecase;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase", f = "GetBackupStatisticsUseCase.kt", l = {16}, m = "invoke", v = 1)
final class GetBackupStatisticsUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f106721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GetBackupStatisticsUseCase f106722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f106723d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetBackupStatisticsUseCase$invoke$1(GetBackupStatisticsUseCase getBackupStatisticsUseCase, Continuation continuation) {
        super(continuation);
        this.f106722c = getBackupStatisticsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f106721b = obj;
        this.f106723d |= Integer.MIN_VALUE;
        return this.f106722c.d(null, this);
    }
}
