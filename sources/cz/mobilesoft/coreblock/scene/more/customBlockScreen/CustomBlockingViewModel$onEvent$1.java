package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$onEvent$1", f = "CustomBlockingViewModel.kt", l = {69, 70}, m = "invokeSuspend", v = 1)
final class CustomBlockingViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewModel f107092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewEvent f107093c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomBlockingViewModel$onEvent$1(CustomBlockingViewModel customBlockingViewModel, CustomBlockingViewEvent customBlockingViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f107092b = customBlockingViewModel;
        this.f107093c = customBlockingViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomBlockingViewModel$onEvent$1(this.f107092b, this.f107093c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f107091a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L45
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L38
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r5 = r4.f107092b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r5 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.S0(r5)
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent r1 = r4.f107093c
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent$OnConfigSelected r1 = (cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent.OnConfigSelected) r1
            java.lang.String r1 = r1.a()
            r4.f107091a = r3
            java.lang.Object r5 = r5.S0(r1, r4)
            if (r5 != r0) goto L38
            goto L44
        L38:
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r5 = r4.f107092b
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewCommand$CloseScreen r1 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewCommand.CloseScreen.f107069a
            r4.f107091a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.W0(r5, r1, r4)
            if (r5 != r0) goto L45
        L44:
            return r0
        L45:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomBlockingViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
