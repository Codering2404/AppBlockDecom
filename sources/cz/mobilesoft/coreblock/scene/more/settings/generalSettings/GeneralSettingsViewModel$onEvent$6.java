package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$onEvent$6", f = "GeneralSettingsViewModel.kt", l = {238}, m = "invokeSuspend", v = 1)
final class GeneralSettingsViewModel$onEvent$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f109781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeneralSettingsViewModel f109782c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeneralSettingsViewModel$onEvent$6(GeneralSettingsViewModel generalSettingsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f109782c = generalSettingsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeneralSettingsViewModel$onEvent$6(this.f109782c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f109781b;
        if (i4 == 0) {
            ResultKt.b(obj);
            boolean z2 = !GeneralSettingsViewModel.S0(this.f109782c).i();
            StatisticsDataStore statisticsDataStoreO1 = this.f109782c.o1();
            this.f109780a = z2 ? 1 : 0;
            this.f109781b = 1;
            if (statisticsDataStoreO1.N0(z2, this) == objF) {
                return objF;
            }
            i3 = z2 ? 1 : 0;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = this.f109780a;
            ResultKt.b(obj);
        }
        AnswersHelper.f128199a.L5(i3 != 0);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeneralSettingsViewModel$onEvent$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
