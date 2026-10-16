package cz.mobilesoft.coreblock.scene.more.help;

import android.content.Context;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.LockieApplication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1", f = "IgnoreBatteryOptimizationGuideActivity.kt", l = {76}, m = "invokeSuspend", v = 1)
final class IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IgnoreBatteryOptimizationGuideActivity f107782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f107783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f107784d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f107785f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1$1", f = "IgnoreBatteryOptimizationGuideActivity.kt", l = {79}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f107786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f107787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IgnoreBatteryOptimizationGuideActivity f107788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f107789d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f107790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f107791g;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1$1$1", f = "IgnoreBatteryOptimizationGuideActivity.kt", l = {81}, m = "invokeSuspend", v = 1)
        static final class C02831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f107792a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f107793b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ScaffoldState f107794c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f107795d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f107796f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ IgnoreBatteryOptimizationGuideActivity f107797g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02831(boolean z2, ScaffoldState scaffoldState, String str, Context context, IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, Continuation continuation) {
                super(2, continuation);
                this.f107793b = z2;
                this.f107794c = scaffoldState;
                this.f107795d = str;
                this.f107796f = context;
                this.f107797g = ignoreBatteryOptimizationGuideActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02831(this.f107793b, this.f107794c, this.f107795d, this.f107796f, this.f107797g, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f107792a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                if (!this.f107793b) {
                    LockieApplication.r(this.f107796f);
                    this.f107797g.finish();
                    return Unit.f139807a;
                }
                SnackbarHostState snackbarHostStateB = this.f107794c.b();
                String str = this.f107795d;
                this.f107792a = 1;
                Object objE = SnackbarHostState.e(snackbarHostStateB, str, null, null, this, 6, null);
                return objE == objF ? objF : objE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02831) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, ScaffoldState scaffoldState, String str, Context context, Continuation continuation) {
            super(2, continuation);
            this.f107788c = ignoreBatteryOptimizationGuideActivity;
            this.f107789d = scaffoldState;
            this.f107790f = str;
            this.f107791g = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f107788c, this.f107789d, this.f107790f, this.f107791g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107787b;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            boolean zN = this.f107788c.z0().n();
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            C02831 c02831 = new C02831(zN, this.f107789d, this.f107790f, this.f107791g, this.f107788c, null);
            this.f107786a = zN;
            this.f107787b = 1;
            Object objG = BuildersKt.g(mainCoroutineDispatcherC, c02831, this);
            return objG == objF ? objF : objG;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1(IgnoreBatteryOptimizationGuideActivity ignoreBatteryOptimizationGuideActivity, ScaffoldState scaffoldState, String str, Context context, Continuation continuation) {
        super(1, continuation);
        this.f107782b = ignoreBatteryOptimizationGuideActivity;
        this.f107783c = scaffoldState;
        this.f107784d = str;
        this.f107785f = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1(this.f107782b, this.f107783c, this.f107784d, this.f107785f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f107781a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        CoroutineDispatcher coroutineDispatcherB = Dispatchers.b();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f107782b, this.f107783c, this.f107784d, this.f107785f, null);
        this.f107781a = 1;
        Object objG = BuildersKt.g(coroutineDispatcherB, anonymousClass1, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((IgnoreBatteryOptimizationGuideActivity$RootCompose$1$1$1$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
