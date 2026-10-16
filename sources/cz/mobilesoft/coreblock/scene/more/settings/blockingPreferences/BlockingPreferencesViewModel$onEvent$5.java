package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesViewModel$onEvent$5", f = "BlockingPreferencesViewModel.kt", l = {224}, m = "invokeSuspend", v = 1)
final class BlockingPreferencesViewModel$onEvent$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f108147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewEvent f108149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BlockingPreferencesViewModel f108150d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingPreferencesViewModel$onEvent$5(BlockingPreferencesViewEvent blockingPreferencesViewEvent, BlockingPreferencesViewModel blockingPreferencesViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108149c = blockingPreferencesViewEvent;
        this.f108150d = blockingPreferencesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingPreferencesViewModel$onEvent$5(this.f108149c, this.f108150d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108148b;
        if (i3 == 0) {
            ResultKt.b(obj);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(((BlockingPreferencesViewEvent.OnStrictDeactivationTimeConfirm) this.f108149c).a());
            StrictModeDataStore strictModeDataStoreL1 = this.f108150d.l1();
            this.f108147a = minutes;
            this.f108148b = 1;
            if (strictModeDataStoreL1.d1(minutes, this) == objF) {
                return objF;
            }
            j3 = minutes;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.f108147a;
            ResultKt.b(obj);
        }
        AnswersHelper.f128199a.v5(j3);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingPreferencesViewModel$onEvent$5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
