package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$onEvent$1", f = "LocationConditionScreenViewModel.kt", l = {129, 132}, m = "invokeSuspend", v = 1)
final class LocationConditionScreenViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f115434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocationConditionScreenViewModel f115435c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionScreenViewModel$onEvent$1(LocationConditionScreenViewModel locationConditionScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f115435c = locationConditionScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationConditionScreenViewModel$onEvent$1(this.f115435c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r1.P0(r2, r6) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
    
        if (r1.P0(r3, r6) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f115434b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            java.lang.Object r0 = r6.f115433a
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState r0 = (cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState) r0
            kotlin.ResultKt.b(r7)
            goto L96
        L20:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r7 = r6.f115435c
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState r7 = cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel.U0(r7)
            cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r1 = r7.c()
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LocationDTO r1 = r1.b()
            r4 = 0
            if (r1 == 0) goto L39
            cz.mobilesoft.coreblock.dto.GeoAddressDTO r1 = r1.e()
            goto L3a
        L39:
            r1 = r4
        L3a:
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r5 = r6.f115435c
            cz.mobilesoft.coreblock.base.ViewState r5 = r5.L0()
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState r5 = (cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState) r5
            cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r5 = r5.c()
            cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LocationDTO r5 = r5.b()
            if (r5 == 0) goto L50
            cz.mobilesoft.coreblock.dto.GeoAddressDTO r4 = r5.e()
        L50:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L76
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.enums.ProfileType r2 = cz.mobilesoft.coreblock.enums.ProfileType.LOCATION
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r4 = r6.f115435c
            boolean r4 = r4.X()
            r1.N4(r2, r4)
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r1 = r6.f115435c
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand$CloseScreen r2 = cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand.CloseScreen.f115417a
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f115433a = r7
            r6.f115434b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel.V0(r1, r2, r6)
            if (r7 != r0) goto L96
            goto L95
        L76:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.enums.ProfileType r3 = cz.mobilesoft.coreblock.enums.ProfileType.LOCATION
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r4 = r6.f115435c
            boolean r4 = r4.X()
            r1.Q4(r3, r4)
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel r1 = r6.f115435c
            cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand$ShowUnsavedChangesDialog r3 = cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewCommand.ShowUnsavedChangesDialog.f115420a
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f115433a = r7
            r6.f115434b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel.V0(r1, r3, r6)
            if (r7 != r0) goto L96
        L95:
            return r0
        L96:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationConditionScreenViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
