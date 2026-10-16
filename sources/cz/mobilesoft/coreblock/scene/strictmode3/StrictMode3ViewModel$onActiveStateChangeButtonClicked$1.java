package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onActiveStateChangeButtonClicked$1", f = "StrictMode3ViewModel.kt", l = {582, 602, 609, 613}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onActiveStateChangeButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f121311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictModeButtonState f121312d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121313f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onActiveStateChangeButtonClicked$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onActiveStateChangeButtonClicked$1$1", f = "StrictMode3ViewModel.kt", l = {585, 586, 587}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f121315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f121316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121317d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
            super(2, continuation);
            this.f121317d = strictMode3ViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f121317d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        
            if (r7.P0(r5, r6) != r0) goto L21;
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
                int r1 = r6.f121316c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.b(r7)
                goto L73
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                int r1 = r6.f121314a
                kotlin.ResultKt.b(r7)
                goto L59
            L23:
                kotlin.ResultKt.b(r7)
                goto L3d
            L27:
                kotlin.ResultKt.b(r7)
                cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r7 = r6.f121317d
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.v1(r7)
                kotlinx.coroutines.flow.Flow r7 = r7.w0()
                r6.f121316c = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
                if (r7 != r0) goto L3d
                goto L72
            L3d:
                java.lang.Number r7 = (java.lang.Number) r7
                long r4 = r7.longValue()
                int r1 = (int) r4
                cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r7 = r6.f121317d
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.v1(r7)
                kotlinx.coroutines.flow.Flow r7 = r7.v0()
                r6.f121314a = r1
                r6.f121316c = r3
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
                if (r7 != r0) goto L59
                goto L72
            L59:
                java.lang.Number r7 = (java.lang.Number) r7
                long r3 = r7.longValue()
                cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r7 = r6.f121317d
                cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowCommitmentDeactivationScreen r5 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewCommand$ShowCommitmentDeactivationScreen
                r5.<init>(r1, r3)
                r6.f121314a = r1
                r6.f121315b = r3
                r6.f121316c = r2
                java.lang.Object r7 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.D1(r7, r5, r6)
                if (r7 != r0) goto L73
            L72:
                return r0
            L73:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onActiveStateChangeButtonClicked$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121318a;

        static {
            int[] iArr = new int[StrictModeButtonState.values().length];
            try {
                iArr[StrictModeButtonState.Activate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeButtonState.Deactivate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeButtonState.ExtendTimer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StrictModeButtonState.Resume.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StrictModeButtonState.ApprovalRequest.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StrictModeButtonState.ApprovalRequestSent.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[StrictModeButtonState.ConnectCharger.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f121318a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onActiveStateChangeButtonClicked$1(StrictModeButtonState strictModeButtonState, StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121312d = strictModeButtonState;
        this.f121313f = strictMode3ViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState y(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, true, false, null, null, null, null, 0L, 2080767, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState z(String str, StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, str, 0L, 1572863, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictMode3ViewModel$onActiveStateChangeButtonClicked$1 strictMode3ViewModel$onActiveStateChangeButtonClicked$1 = new StrictMode3ViewModel$onActiveStateChangeButtonClicked$1(this.f121312d, this.f121313f, continuation);
        strictMode3ViewModel$onActiveStateChangeButtonClicked$1.f121311c = obj;
        return strictMode3ViewModel$onActiveStateChangeButtonClicked$1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r11.u(r10) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009c, code lost:
    
        if (r2.P0(r3, r10) != r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d3, code lost:
    
        if (r11.r2(r10) == r0) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onActiveStateChangeButtonClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$onActiveStateChangeButtonClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
