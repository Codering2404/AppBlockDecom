package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AppVersionRepository$handleChangelogOnAppUpdated$willBeShowingUpdatedNotification$2", f = "AppVersionRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class AppVersionRepository$handleChangelogOnAppUpdated$willBeShowingUpdatedNotification$2 extends SuspendLambda implements Function1<Continuation<? super AppVersionEntity>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppVersionEntity f97392b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppVersionRepository$handleChangelogOnAppUpdated$willBeShowingUpdatedNotification$2(AppVersionEntity appVersionEntity, Continuation continuation) {
        super(1, continuation);
        this.f97392b = appVersionEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AppVersionRepository$handleChangelogOnAppUpdated$willBeShowingUpdatedNotification$2(this.f97392b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f97391a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return this.f97392b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AppVersionRepository$handleChangelogOnAppUpdated$willBeShowingUpdatedNotification$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
