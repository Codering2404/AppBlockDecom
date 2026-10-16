package cz.mobilesoft.appblock.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1", f = "LockScreenProvider.kt", l = {1088, 1098, 1093, 1098, 1098, 1098}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$tryToClose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f95309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f95310d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f95311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95312g;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f95313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LockScreenProvider f95314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f95315c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LockScreenProvider lockScreenProvider, Ref.BooleanRef booleanRef, Continuation continuation) {
            super(2, continuation);
            this.f95314b = lockScreenProvider;
            this.f95315c = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95314b, this.f95315c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95313a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f95314b.N0(this.f95315c.f140137a);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$tryToClose$1(LockScreenProvider lockScreenProvider, Continuation continuation) {
        super(2, continuation);
        this.f95312g = lockScreenProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProvider$tryToClose$1(this.f95312g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0140, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r14, r0, r13) == r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r14, r0, r13) != r1) goto L71;
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x014e: INVOKE 
      (r0v2 ?? I:cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1$1)
      (r2v1 ?? I:cz.mobilesoft.appblock.view.LockScreenProvider)
      (r5 I:kotlin.jvm.internal.Ref$BooleanRef)
      (r4 I:kotlin.coroutines.Continuation)
     DIRECT call: cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1.1.<init>(cz.mobilesoft.appblock.view.LockScreenProvider, kotlin.jvm.internal.Ref$BooleanRef, kotlin.coroutines.Continuation):void A[MD:(cz.mobilesoft.appblock.view.LockScreenProvider, kotlin.jvm.internal.Ref$BooleanRef, kotlin.coroutines.Continuation):void (m)] (LINE:335), block:B:68:0x0146 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x016c: INVOKE 
      (r2v3 ?? I:cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1$1)
      (r3v1 ?? I:cz.mobilesoft.appblock.view.LockScreenProvider)
      (r5 I:kotlin.jvm.internal.Ref$BooleanRef)
      (r4 I:kotlin.coroutines.Continuation)
     DIRECT call: cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1.1.<init>(cz.mobilesoft.appblock.view.LockScreenProvider, kotlin.jvm.internal.Ref$BooleanRef, kotlin.coroutines.Continuation):void A[MD:(cz.mobilesoft.appblock.view.LockScreenProvider, kotlin.jvm.internal.Ref$BooleanRef, kotlin.coroutines.Continuation):void (m)] (LINE:365), block:B:73:0x0164 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084 A[Catch: all -> 0x003b, SQLiteDatabaseLockedException -> 0x003f, TRY_LEAVE, TryCatch #1 {SQLiteDatabaseLockedException -> 0x003f, blocks: (B:9:0x0036, B:57:0x0116, B:63:0x0126, B:18:0x0054, B:24:0x0080, B:26:0x0084, B:31:0x00a1, B:33:0x00a8, B:53:0x00fc, B:36:0x00b3, B:37:0x00b7, B:39:0x00bd, B:41:0x00c9, B:43:0x00d3, B:46:0x00dd, B:47:0x00e1, B:49:0x00e7, B:21:0x0060), top: B:77:0x0009, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1 A[Catch: all -> 0x003b, SQLiteDatabaseLockedException -> 0x003f, TRY_ENTER, TryCatch #1 {SQLiteDatabaseLockedException -> 0x003f, blocks: (B:9:0x0036, B:57:0x0116, B:63:0x0126, B:18:0x0054, B:24:0x0080, B:26:0x0084, B:31:0x00a1, B:33:0x00a8, B:53:0x00fc, B:36:0x00b3, B:37:0x00b7, B:39:0x00bd, B:41:0x00c9, B:43:0x00d3, B:46:0x00dd, B:47:0x00e1, B:49:0x00e7, B:21:0x0060), top: B:77:0x0009, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc A[Catch: all -> 0x003b, SQLiteDatabaseLockedException -> 0x003f, TryCatch #1 {SQLiteDatabaseLockedException -> 0x003f, blocks: (B:9:0x0036, B:57:0x0116, B:63:0x0126, B:18:0x0054, B:24:0x0080, B:26:0x0084, B:31:0x00a1, B:33:0x00a8, B:53:0x00fc, B:36:0x00b3, B:37:0x00b7, B:39:0x00bd, B:41:0x00c9, B:43:0x00d3, B:46:0x00dd, B:47:0x00e1, B:49:0x00e7, B:21:0x0060), top: B:77:0x0009, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0123  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, kotlin.jvm.internal.Ref$BooleanRef] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$tryToClose$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProvider$tryToClose$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
