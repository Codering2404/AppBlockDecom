package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$46", f = "DeveloperSettingsViewModel.kt", l = {685}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$46 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f108780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewEvent f108782c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$46(DeveloperSettingsViewModel developerSettingsViewModel, DeveloperSettingsViewEvent developerSettingsViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f108781b = developerSettingsViewModel;
        this.f108782c = developerSettingsViewEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$46(this.f108781b, this.f108782c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108780a;
        if (i3 == 0) {
            ResultKt.b(obj);
            DevDataStore devDataStoreM2 = this.f108781b.m2();
            DevPrefState devPrefStateA = ((DeveloperSettingsViewEvent.OnShowAniaInfoDialogStateSelected) this.f108782c).a();
            this.f108780a = 1;
            if (devDataStoreM2.j2(devPrefStateA, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f108781b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeveloperSettingsViewModel$onEvent$46.q((DeveloperSettingsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$46) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
