package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$onShowSnackbar$1", f = "LocationConditionScreenViewModel.kt", l = {81}, m = "invokeSuspend", v = 1)
final class LocationConditionScreenViewModel$onShowSnackbar$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LocationConditionScreenViewModel f115440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f115441c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionScreenViewModel$onShowSnackbar$1(LocationConditionScreenViewModel locationConditionScreenViewModel, int i3, Continuation continuation) {
        super(1, continuation);
        this.f115440b = locationConditionScreenViewModel;
        this.f115441c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LocationConditionScreenViewModel$onShowSnackbar$1(this.f115440b, this.f115441c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115439a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LocationConditionScreenViewModel locationConditionScreenViewModel = this.f115440b;
            String string = this.f115440b.A0().getString(this.f115441c);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            LocationConditionScreenViewCommand.ShowSnackbar showSnackbar = new LocationConditionScreenViewCommand.ShowSnackbar(string);
            this.f115439a = 1;
            if (locationConditionScreenViewModel.P0(showSnackbar, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LocationConditionScreenViewModel$onShowSnackbar$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
