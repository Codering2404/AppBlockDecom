package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$4", f = "DeveloperSettingsViewModel.kt", l = {421}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108770b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$4(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108770b = developerSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$4(this.f108770b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DeveloperSettingsViewModel$onEvent$4 developerSettingsViewModel$onEvent$4;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108769a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StreakDebugHelper streakDebugHelperV2 = this.f108770b.v2();
            this.f108769a = 1;
            developerSettingsViewModel$onEvent$4 = this;
            if (StreakDebugHelper.b(streakDebugHelperV2, 30L, 0L, developerSettingsViewModel$onEvent$4, 2, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            developerSettingsViewModel$onEvent$4 = this;
        }
        developerSettingsViewModel$onEvent$4.f108770b.j3();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
