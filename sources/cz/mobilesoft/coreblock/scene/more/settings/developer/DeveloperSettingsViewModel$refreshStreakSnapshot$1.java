package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$refreshStreakSnapshot$1", f = "DeveloperSettingsViewModel.kt", l = {1411}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$refreshStreakSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108908b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$refreshStreakSnapshot$1(DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108908b = developerSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(StreakDebugHelper.Snapshot snapshot, DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, snapshot, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -2, 524287, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$refreshStreakSnapshot$1(this.f108908b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DeveloperSettingsViewModel$refreshStreakSnapshot$1 developerSettingsViewModel$refreshStreakSnapshot$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108907a;
        if (i3 == 0) {
            ResultKt.b(obj);
            StreakDebugHelper streakDebugHelperV2 = this.f108908b.v2();
            this.f108907a = 1;
            developerSettingsViewModel$refreshStreakSnapshot$1 = this;
            obj = StreakDebugHelper.g(streakDebugHelperV2, 0L, null, developerSettingsViewModel$refreshStreakSnapshot$1, 3, null);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            developerSettingsViewModel$refreshStreakSnapshot$1 = this;
        }
        final StreakDebugHelper.Snapshot snapshot = (StreakDebugHelper.Snapshot) obj;
        developerSettingsViewModel$refreshStreakSnapshot$1.f108908b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeveloperSettingsViewModel$refreshStreakSnapshot$1.q(snapshot, (DeveloperSettingsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$refreshStreakSnapshot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
