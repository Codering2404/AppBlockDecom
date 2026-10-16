package cz.mobilesoft.coreblock.scene.intro.strictmode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onEvent$1", f = "StrictModeIntroViewModel.kt", l = {71, 73}, m = "invokeSuspend", v = 1)
final class StrictModeIntroViewModel$onEvent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictModeIntroViewModel f105061b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeIntroViewModel$onEvent$1(StrictModeIntroViewModel strictModeIntroViewModel, Continuation continuation) {
        super(1, continuation);
        this.f105061b = strictModeIntroViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StrictModeIntroViewModel$onEvent$1(this.f105061b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
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
            int r1 = r4.f105060a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L43
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L31
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r5 = r4.f105061b
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r5 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel.T0(r5)
            r4.f105060a = r3
            r1 = 0
            java.lang.Object r5 = r5.a1(r1, r4)
            if (r5 != r0) goto L31
            goto L42
        L31:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r5 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r5.G7()
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel r5 = r4.f105061b
            cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewCommand$Close r1 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewCommand.Close.f105027a
            r4.f105060a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel.V0(r5, r1, r4)
            if (r5 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StrictModeIntroViewModel$onEvent$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
