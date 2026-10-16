package com.superwall.sdk;

import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt;
import com.superwall.sdk.models.config.Config;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlow;

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
public final class SdkContextImpl implements SdkContext {
    private final Function0<ConfigManager> configManager;

    /* JADX INFO: renamed from: com.superwall.sdk.SdkContextImpl$awaitConfig$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.SdkContextImpl$awaitConfig$2", f = "SdkContext.kt", l = {40}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Config>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SdkContextImpl.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            StateFlow<ConfigState> configState$superwall_release = ((ConfigManager) SdkContextImpl.this.configManager.invoke()).getConfigState$superwall_release();
            this.label = 1;
            Object objAwaitFirstValidConfig = Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(configState$superwall_release, this);
            return objAwaitFirstValidConfig == objF ? objF : objAwaitFirstValidConfig;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Config> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.SdkContextImpl$fetchAssignments$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.SdkContextImpl", f = "SdkContext.kt", l = {32, 33}, m = "fetchAssignments")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkContextImpl.this.fetchAssignments(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.SdkContextImpl$fetchAssignments$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.SdkContextImpl$fetchAssignments$2", f = "SdkContext.kt", l = {34}, m = "invokeSuspend")
    static final class C27612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27612(Continuation<? super C27612> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SdkContextImpl.this.new C27612(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                ConfigManager configManager = (ConfigManager) SdkContextImpl.this.configManager.invoke();
                this.label = 1;
                if (configManager.getAssignments(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27612) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SdkContextImpl(Function0<? extends ConfigManager> configManager) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.configManager = configManager;
    }

    @Override // com.superwall.sdk.SdkContext
    public Object awaitConfig(Continuation<? super Config> continuation) {
        Duration.Companion companion = Duration.f140631b;
        return TimeoutKt.f(DurationKt.s(30, DurationUnit.f140641f), new AnonymousClass2(null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.SdkContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchAssignments(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.SdkContextImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.SdkContextImpl$fetchAssignments$1 r0 = (com.superwall.sdk.SdkContextImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.SdkContextImpl$fetchAssignments$1 r0 = new com.superwall.sdk.SdkContextImpl$fetchAssignments$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.SdkContextImpl r2 = (com.superwall.sdk.SdkContextImpl) r2
            kotlin.ResultKt.b(r8)
            goto L57
        L3c:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.functions.Function0<com.superwall.sdk.config.ConfigManager> r8 = r7.configManager
            java.lang.Object r8 = r8.invoke()
            com.superwall.sdk.config.ConfigManager r8 = (com.superwall.sdk.config.ConfigManager) r8
            kotlinx.coroutines.flow.StateFlow r8 = r8.getConfigState$superwall_release()
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = com.superwall.sdk.misc.Config_AwaitFirstValidConfigKt.awaitFirstValidConfig(r8, r0)
            if (r8 != r1) goto L56
            goto L71
        L56:
            r2 = r7
        L57:
            kotlin.time.Duration$Companion r8 = kotlin.time.Duration.f140631b
            r8 = 30
            kotlin.time.DurationUnit r4 = kotlin.time.DurationUnit.f140641f
            long r4 = kotlin.time.DurationKt.s(r8, r4)
            com.superwall.sdk.SdkContextImpl$fetchAssignments$2 r8 = new com.superwall.sdk.SdkContextImpl$fetchAssignments$2
            r6 = 0
            r8.<init>(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.f(r4, r8, r0)
            if (r8 != r1) goto L72
        L71:
            return r1
        L72:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.SdkContextImpl.fetchAssignments(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.SdkContext
    public Object reevaluateTestMode(String str, String str2, Continuation<? super Unit> continuation) {
        Object objReevaluateTestMode$default = ConfigManager.reevaluateTestMode$default((ConfigManager) this.configManager.invoke(), null, str, str2, continuation, 1, null);
        return objReevaluateTestMode$default == IntrinsicsKt.f() ? objReevaluateTestMode$default : Unit.f139807a;
    }
}
