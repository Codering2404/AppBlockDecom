package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import java.util.concurrent.TimeUnit;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$onEvent$74", f = "DeveloperSettingsViewModel.kt", l = {883}, m = "invokeSuspend", v = 1)
final class DeveloperSettingsViewModel$onEvent$74 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f108844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f108845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewEvent f108846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DeveloperSettingsViewModel f108847d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeveloperSettingsViewModel$onEvent$74(DeveloperSettingsViewEvent developerSettingsViewEvent, DeveloperSettingsViewModel developerSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f108846c = developerSettingsViewEvent;
        this.f108847d = developerSettingsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState q(DeveloperSettingsViewState developerSettingsViewState) {
        return DeveloperSettingsViewState.b(developerSettingsViewState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeveloperSettingsViewModel$onEvent$74(this.f108846c, this.f108847d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f108845b;
        if (i3 == 0) {
            ResultKt.b(obj);
            long millis = TimeUnit.MINUTES.toMillis(((DeveloperSettingsViewEvent.OnTimeChangeLimitSaved) this.f108846c).a());
            DevDataStore devDataStoreM2 = this.f108847d.m2();
            this.f108844a = millis;
            this.f108845b = 1;
            if (devDataStoreM2.u2(millis, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f108847d.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DeveloperSettingsViewModel$onEvent$74.q((DeveloperSettingsViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeveloperSettingsViewModel$onEvent$74) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
