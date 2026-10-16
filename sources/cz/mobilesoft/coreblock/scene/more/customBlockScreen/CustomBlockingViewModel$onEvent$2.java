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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$onEvent$2", f = "CustomBlockingViewModel.kt", l = {75, 78, 79}, m = "invokeSuspend", v = 1)
final class CustomBlockingViewModel$onEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewModel f107095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomBlockingViewEvent f107096c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomBlockingViewModel$onEvent$2(CustomBlockingViewModel customBlockingViewModel, CustomBlockingViewEvent customBlockingViewEvent, Continuation continuation) {
        super(2, continuation);
        this.f107095b = customBlockingViewModel;
        this.f107096c = customBlockingViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomBlockingViewModel$onEvent$2(this.f107095b, this.f107096c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt.a(r6, r1, r5) == r0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f107094a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L79
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            goto L52
        L21:
            kotlin.ResultKt.b(r6)
            goto L3f
        L25:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r6 = r5.f107095b
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r6 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.T0(r6)
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent r1 = r5.f107096c
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent$OnConfigDeleted r1 = (cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent.OnConfigDeleted) r1
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r1 = r1.a()
            r5.f107094a = r4
            java.lang.Object r6 = r6.q(r1, r5)
            if (r6 != r0) goto L3f
            goto L78
        L3f:
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r6 = r5.f107095b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.S0(r6)
            kotlinx.coroutines.flow.Flow r6 = r6.n0()
            r5.f107094a = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r5)
            if (r6 != r0) goto L52
            goto L78
        L52:
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent r1 = r5.f107096c
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent$OnConfigDeleted r1 = (cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent.OnConfigDeleted) r1
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r1 = r1.a()
            java.lang.String r1 = r1.i()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r6 == 0) goto L79
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r6 = r5.f107095b
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r6 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.T0(r6)
            cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel r1 = r5.f107095b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r1 = cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel.S0(r1)
            r5.f107094a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt.a(r6, r1, r5)
            if (r6 != r0) goto L79
        L78:
            return r0
        L79:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomBlockingViewModel$onEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
