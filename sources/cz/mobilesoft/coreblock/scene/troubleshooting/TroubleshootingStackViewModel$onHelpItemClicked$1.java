package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.enums.HelpItem;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onHelpItemClicked$1", f = "TroubleshootingStackViewModel.kt", l = {122, 124, 126}, m = "invokeSuspend", v = 1)
final class TroubleshootingStackViewModel$onHelpItemClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ HelpItem f123004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TroubleshootingStackViewModel f123005d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TroubleshootingStackViewModel$onHelpItemClicked$1(HelpItem helpItem, TroubleshootingStackViewModel troubleshootingStackViewModel, Continuation continuation) {
        super(2, continuation);
        this.f123004c = helpItem;
        this.f123005d = troubleshootingStackViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TroubleshootingStackViewModel$onHelpItemClicked$1(this.f123004c, this.f123005d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
    
        if (r7.P0(r3, r6) != r0) goto L21;
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
            int r1 = r6.f123003b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r6.f123002a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto L99
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L22:
            java.lang.Object r1 = r6.f123002a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r7)
            goto L7d
        L2a:
            kotlin.ResultKt.b(r7)
            goto L52
        L2e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.enums.HelpItem r1 = r6.f123004c
            r7.l8(r1)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r7 = r6.f123005d
            cz.mobilesoft.coreblock.enums.HelpItem r1 = r6.f123004c
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.U0(r7, r1)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r7 = r6.f123005d
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.S0(r7)
            kotlinx.coroutines.flow.Flow r7 = r7.m2()
            r6.f123003b = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
            if (r7 != r0) goto L52
            goto L98
        L52:
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r7)
            cz.mobilesoft.coreblock.enums.HelpItem r7 = r6.f123004c
            java.lang.String r7 = r7.name()
            r1.add(r7)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r7 = r6.f123005d
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.S0(r7)
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r4)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r6.f123002a = r5
            r6.f123003b = r3
            java.lang.Object r7 = r7.J4(r4, r6)
            if (r7 != r0) goto L7d
            goto L98
        L7d:
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r7 = r6.f123005d
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand$ShowHelpItem r3 = new cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand$ShowHelpItem
            cz.mobilesoft.coreblock.enums.HelpItem r4 = r6.f123004c
            kotlin.jvm.functions.Function1 r4 = r4.getAction()
            r3.<init>(r4)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r6.f123002a = r1
            r6.f123003b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.T0(r7, r3, r6)
            if (r7 != r0) goto L99
        L98:
            return r0
        L99:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onHelpItemClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TroubleshootingStackViewModel$onHelpItemClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
