package cz.mobilesoft.coreblock.scene.troubleshooting;

import cz.mobilesoft.coreblock.enums.HelpItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onResumed$1", f = "TroubleshootingStackViewModel.kt", l = {147, 153, 154}, m = "invokeSuspend", v = 1)
final class TroubleshootingStackViewModel$onResumed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TroubleshootingStackViewModel f123008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ HelpItem f123009d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TroubleshootingStackViewModel$onResumed$1(TroubleshootingStackViewModel troubleshootingStackViewModel, HelpItem helpItem, Continuation continuation) {
        super(2, continuation);
        this.f123008c = troubleshootingStackViewModel;
        this.f123009d = helpItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TroubleshootingStackViewState y(HelpItem helpItem, TroubleshootingStackViewState troubleshootingStackViewState) {
        ImmutableList<TroubleshootingStackItem> immutableListC = troubleshootingStackViewState.c();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableListC, 10));
        for (TroubleshootingStackItem troubleshootingStackItemB : immutableListC) {
            if (troubleshootingStackItemB.c() == helpItem) {
                troubleshootingStackItemB = TroubleshootingStackItem.b(troubleshootingStackItemB, null, true, 1, null);
            }
            arrayList.add(troubleshootingStackItemB);
        }
        return TroubleshootingStackViewState.b(troubleshootingStackViewState, null, null, null, ExtensionsKt.h(arrayList), 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TroubleshootingStackViewState z(List list, TroubleshootingStackViewState troubleshootingStackViewState) {
        return TroubleshootingStackViewState.b(troubleshootingStackViewState, null, null, null, ExtensionsKt.h(list), 7, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TroubleshootingStackViewModel$onResumed$1(this.f123008c, this.f123009d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
    
        if (r8.P0(r3, r7) != r0) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f123007b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r7.f123006a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r8)
            goto Lb0
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            java.lang.Object r1 = r7.f123006a
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r8)
            goto L93
        L2a:
            kotlin.ResultKt.b(r8)
            goto L48
        L2e:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r8 = r7.f123008c
            cz.mobilesoft.coreblock.enums.HelpItem r1 = r7.f123009d
            cz.mobilesoft.coreblock.scene.troubleshooting.z r5 = new cz.mobilesoft.coreblock.scene.troubleshooting.z
            r5.<init>()
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.V0(r8, r5)
            r7.f123007b = r4
            r5 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r0) goto L48
            goto La5
        L48:
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r8 = r7.f123008c
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewState r8 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.R0(r8)
            kotlinx.collections.immutable.ImmutableList r8 = r8.c()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        L5b:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L72
            java.lang.Object r5 = r8.next()
            r6 = r5
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItem r6 = (cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItem) r6
            boolean r6 = r6.d()
            if (r6 != 0) goto L5b
            r1.add(r5)
            goto L5b
        L72:
            boolean r8 = r1.isEmpty()
            if (r8 == 0) goto La6
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r8 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r8.k8(r4)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r8 = r7.f123008c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.S0(r8)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f123006a = r4
            r7.f123007b = r3
            r3 = 0
            java.lang.Object r8 = r8.F5(r3, r7)
            if (r8 != r0) goto L93
            goto La5
        L93:
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r8 = r7.f123008c
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand$Finish r3 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand.Finish.f122983a
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f123006a = r1
            r7.f123007b = r2
            java.lang.Object r8 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.T0(r8, r3, r7)
            if (r8 != r0) goto Lb0
        La5:
            return r0
        La6:
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r8 = r7.f123008c
            cz.mobilesoft.coreblock.scene.troubleshooting.a0 r0 = new cz.mobilesoft.coreblock.scene.troubleshooting.a0
            r0.<init>()
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.V0(r8, r0)
        Lb0:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onResumed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TroubleshootingStackViewModel$onResumed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
