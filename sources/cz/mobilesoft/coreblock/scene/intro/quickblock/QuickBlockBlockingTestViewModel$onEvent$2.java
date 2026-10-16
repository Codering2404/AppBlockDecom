package cz.mobilesoft.coreblock.scene.intro.quickblock;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$onEvent$2", f = "QuickBlockBlockingTestViewModel.kt", l = {31, 32}, m = "invokeSuspend", v = 1)
final class QuickBlockBlockingTestViewModel$onEvent$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ QuickBlockBlockingTestViewModel f104760b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockBlockingTestViewModel$onEvent$2(QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel, Continuation continuation) {
        super(1, continuation);
        this.f104760b = quickBlockBlockingTestViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new QuickBlockBlockingTestViewModel$onEvent$2(this.f104760b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f104759a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L3f
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L32
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel r6 = r5.f104760b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel.R0(r6)
            r5.f104759a = r3
            r3 = 0
            java.lang.Object r6 = r6.H4(r3, r5)
            if (r6 != r0) goto L32
            goto L3e
        L32:
            cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel r6 = r5.f104760b
            cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewCommand$GoToSchedule r1 = cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewCommand.GoToSchedule.f104750a
            r5.f104759a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel.T0(r6, r1, r5)
            if (r6 != r0) goto L3f
        L3e:
            return r0
        L3f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$onEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((QuickBlockBlockingTestViewModel$onEvent$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
