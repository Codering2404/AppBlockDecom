package cz.mobilesoft.coreblock.scene.strictmode3.options;

import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$onSaveClicked$1", f = "StrictModeOptionsViewModel.kt", l = {57, 58, 60, 64, 67, 72}, m = "invokeSuspend", v = 1)
final class StrictModeOptionsViewModel$onSaveClicked$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f122317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f122318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f122319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictModeOptionsViewModel f122320d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$onSaveClicked$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$onSaveClicked$1$2", f = "StrictModeOptionsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f122321a;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f122321a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            JobHelper.p();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeOptionsViewModel$onSaveClicked$1(StrictModeOptionsViewModel strictModeOptionsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f122320d = strictModeOptionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StrictModeOptionsViewModel$onSaveClicked$1(this.f122320d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StrictModeOptionsViewModel$onSaveClicked$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0145, code lost:
    
        if (r7.P0(r3, r6) == r0) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004d A[PHI: r1 r7
      0x004d: PHI (r1v5 kotlinx.collections.immutable.ImmutableList) = (r1v2 kotlinx.collections.immutable.ImmutableList), (r1v9 kotlinx.collections.immutable.ImmutableList) binds: [B:17:0x008b, B:10:0x0046] A[DONT_GENERATE, DONT_INLINE]
      0x004d: PHI (r7v10 java.lang.Object) = (r7v9 java.lang.Object), (r7v0 java.lang.Object) binds: [B:17:0x008b, B:10:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e A[PHI: r1 r2
      0x012e: PHI (r1v16 java.util.List) = (r1v10 java.util.List), (r1v13 java.util.List), (r1v13 java.util.List), (r1v13 java.util.List), (r1v20 java.util.List) binds: [B:25:0x00cc, B:48:0x012e, B:41:0x012b, B:33:0x00f5, B:7:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x012e: PHI (r2v9 kotlinx.collections.immutable.ImmutableList) = 
      (r2v3 kotlinx.collections.immutable.ImmutableList)
      (r2v6 kotlinx.collections.immutable.ImmutableList)
      (r2v6 kotlinx.collections.immutable.ImmutableList)
      (r2v6 kotlinx.collections.immutable.ImmutableList)
      (r2v12 kotlinx.collections.immutable.ImmutableList)
     binds: [B:25:0x00cc, B:48:0x012e, B:41:0x012b, B:33:0x00f5, B:7:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewModel$onSaveClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
