package cz.mobilesoft.coreblock.scene.strictmode3;

import android.os.CountDownTimer;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$startCooldownTimer$1;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$startCooldownTimer$1", f = "StrictMode3ViewModel.kt", l = {817}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$startCooldownTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f121417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f121420d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$startCooldownTimer$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$startCooldownTimer$1$1", f = "StrictMode3ViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f121421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f121423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f121424d;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$startCooldownTimer$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AnonymousClass2 extends CountDownTimer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StrictMode3ViewModel f121425a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f121426b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(long j3, StrictMode3ViewModel strictMode3ViewModel, boolean z2) {
                super(j3, 1000L);
                this.f121425a = strictMode3ViewModel;
                this.f121426b = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictMode3ViewState c(StrictMode3ViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2088959, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictMode3ViewState d(long j3, StrictMode3ViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                String strE = DateHelper.e(j3 / ((long) 1000));
                Intrinsics.checkNotNullExpressionValue(strE, "getFormattedTime(...)");
                return StrictMode3ViewState.b(updateState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, strE, null, null, null, 0L, 2031615, null);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f121425a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.e4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$startCooldownTimer$1.AnonymousClass1.AnonymousClass2.c((StrictMode3ViewState) obj);
                    }
                });
                this.f121425a.Q1(false, false, this.f121426b);
            }

            @Override // android.os.CountDownTimer
            public void onTick(final long j3) {
                this.f121425a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.f4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$startCooldownTimer$1.AnonymousClass1.AnonymousClass2.d(j3, (StrictMode3ViewState) obj);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel, long j3, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.f121422b = strictMode3ViewModel;
            this.f121423c = j3;
            this.f121424d = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState q(long j3, StrictMode3ViewState strictMode3ViewState) {
            String strE = DateHelper.e(j3 / ((long) 1000));
            Intrinsics.checkNotNullExpressionValue(strE, "getFormattedTime(...)");
            return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, true, false, false, strE, null, null, null, 0L, 2023423, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f121422b, this.f121423c, this.f121424d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f121421a == 0) {
                ResultKt.b(obj);
                StrictMode3ViewModel strictMode3ViewModel = this.f121422b;
                final long j3 = this.f121423c;
                strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.d4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return StrictMode3ViewModel$startCooldownTimer$1.AnonymousClass1.q(j3, (StrictMode3ViewState) obj2);
                    }
                });
                CountDownTimer countDownTimer = this.f121422b.H;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.f121422b.H = new AnonymousClass2(this.f121423c, this.f121422b, this.f121424d).start();
                return Unit.f139807a;
            }
            throw new IllegalStateException(tDEtWsFLJfe.Thp);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$startCooldownTimer$1(StrictMode3ViewModel strictMode3ViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f121419c = strictMode3ViewModel;
        this.f121420d = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$startCooldownTimer$1(this.f121419c, this.f121420d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f121418b;
        if (i3 == 0) {
            ResultKt.b(obj);
            AccessMethodConfiguration accessMethodConfigurationD = StrictMode3ViewModel.h1(this.f121419c).d();
            AccessMethodConfiguration.Cooldown cooldown = accessMethodConfigurationD instanceof AccessMethodConfiguration.Cooldown ? (AccessMethodConfiguration.Cooldown) accessMethodConfigurationD : null;
            if (cooldown == null) {
                return Unit.f139807a;
            }
            long jB = cooldown.b();
            MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f121419c, jB, this.f121420d, null);
            this.f121417a = jB;
            this.f121418b = 1;
            if (BuildersKt.g(mainCoroutineDispatcherC, anonymousClass1, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$startCooldownTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
