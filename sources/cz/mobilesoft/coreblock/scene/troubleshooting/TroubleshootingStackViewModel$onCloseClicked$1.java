package cz.mobilesoft.coreblock.scene.troubleshooting;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onCloseClicked$1", f = "TroubleshootingStackViewModel.kt", l = {170}, m = "invokeSuspend", v = 1)
final class TroubleshootingStackViewModel$onCloseClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TroubleshootingStackViewModel f123001b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TroubleshootingStackViewModel$onCloseClicked$1(TroubleshootingStackViewModel troubleshootingStackViewModel, Continuation continuation) {
        super(2, continuation);
        this.f123001b = troubleshootingStackViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TroubleshootingStackViewModel$onCloseClicked$1(this.f123001b, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f123000a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r5)
            goto L62
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r5 = r4.f123001b
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewState r5 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.R0(r5)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            kotlinx.collections.immutable.ImmutableList r3 = r5.c()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L51
            kotlinx.collections.immutable.ImmutableList r5 = r5.c()
            if (r5 == 0) goto L39
            boolean r3 = r5.isEmpty()
            if (r3 == 0) goto L39
            goto L51
        L39:
            java.util.Iterator r5 = r5.iterator()
        L3d:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L51
            java.lang.Object r3 = r5.next()
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItem r3 = (cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackItem) r3
            boolean r3 = r3.d()
            if (r3 != 0) goto L3d
            r5 = 0
            goto L52
        L51:
            r5 = r2
        L52:
            r1.k8(r5)
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel r5 = r4.f123001b
            cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand$Finish r1 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewCommand.Finish.f122983a
            r4.f123000a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel.T0(r5, r1, r4)
            if (r5 != r0) goto L62
            return r0
        L62:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.troubleshooting.TroubleshootingStackViewModel$onCloseClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TroubleshootingStackViewModel$onCloseClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
