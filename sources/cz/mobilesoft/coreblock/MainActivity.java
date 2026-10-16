package cz.mobilesoft.coreblock;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import c1.ub.AsHNMpHTEsKfE;
import com.applovin.impl.mediation.nativeAds.es.CBwUegoGfYl;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.crashlytics.internal.metadata.rSN.xSRx;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseActivitySurface;
import cz.mobilesoft.coreblock.databinding.ActivityFragmentBinding;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import cz.mobilesoft.coreblock.scene.password.PassCodeActivity;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.DeepLinksUtils;
import cz.mobilesoft.coreblock.util.DeeplinkRouter;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.SingularCallbackHandler;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelperExtKt;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.lang.reflect.InvocationTargetException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
public class MainActivity extends BaseActivitySurface<ActivityFragmentBinding> implements InitHelper.OnInitializedListener {
    public static final Companion H = new Companion(null);
    public static final int I = 8;
    public static MainActivityProvider J;
    public Pair A;
    public boolean B;
    public String C;
    public boolean D;
    public String E;
    public final ActivityResultLauncher F;
    public final ActivityResultLauncher G;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CoroutineScope f95368s = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f95369t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f95370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f95371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f95372w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f95373x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f95374y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f95375z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            MainActivityProvider mainActivityProvider = MainActivity.J;
            if (mainActivityProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("provider");
                mainActivityProvider = null;
            }
            return mainActivityProvider.a(context);
        }

        public final void b(MainActivityProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            MainActivity.J = provider;
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface MainActivityProvider {
        Intent a(Context context);
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$1", f = "MainActivity.kt", l = {151}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f95383a;

        public AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return MainActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f95383a;
            if (i3 == 0) {
                ResultKt.b(obj);
                DynamicShortcutsManager dynamicShortcutsManager = DynamicShortcutsManager.f101460a;
                MainActivity mainActivity = MainActivity.this;
                CoreDataStore coreDataStoreR0 = mainActivity.R0();
                this.f95383a = 1;
                if (dynamicShortcutsManager.i(mainActivity, coreDataStoreR0, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3", f = "MainActivity.kt", l = {177, SensibleDefaults.X_OFFSET, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 196, 196, 199, 212, Function.MAX_NARGS}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f95385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f95386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f95387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f95388d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f95389f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f95390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ MainActivity f95391h;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95392a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95393b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MainActivity mainActivity, Continuation continuation) {
                super(2, continuation);
                this.f95393b = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.f95393b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f95392a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Intent intent = new Intent(this.f95393b, (Class<?>) OnboardingActivityV2.class);
                intent.setFlags(872415232);
                this.f95393b.startActivity(intent);
                this.f95393b.finish();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$2", f = "MainActivity.kt", l = {188}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95394a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95395b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(MainActivity mainActivity, Continuation continuation) {
                super(1, continuation);
                this.f95395b = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass2(this.f95395b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f95394a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    CoreDataStore coreDataStoreR0 = this.f95395b.R0();
                    this.f95394a = 1;
                    if (coreDataStoreR0.H4(0L, this) == objF) {
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

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$3, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$3", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02643 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95396a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95397b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02643(MainActivity mainActivity, Continuation continuation) {
                super(2, continuation);
                this.f95397b = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02643(this.f95397b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f95396a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f95397b.startActivity(IntroScheduleActivity.Companion.b(IntroScheduleActivity.f104813g, this.f95397b, false, 2, null));
                this.f95397b.finish();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02643) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$4", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95398a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95399b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(MainActivity mainActivity, Continuation continuation) {
                super(2, continuation);
                this.f95399b = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass4(this.f95399b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f95398a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f95399b.F.b(PassCodeActivity.f111670f.a(this.f95399b, PassCodeType.Check));
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$5", f = "MainActivity.kt", l = {234}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95401b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(MainActivity mainActivity, Continuation continuation) {
                super(1, continuation);
                this.f95401b = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass5(this.f95401b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f95400a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    CoreDataStore coreDataStoreR0 = this.f95401b.R0();
                    this.f95400a = 1;
                    if (coreDataStoreR0.U5(false, this) == objF) {
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

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onInitialized$3$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onInitialized$3$8", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f95402a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f95403b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Intent f95404c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass8(MainActivity mainActivity, Intent intent, Continuation continuation) {
                super(2, continuation);
                this.f95403b = mainActivity;
                this.f95404c = intent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass8(this.f95403b, this.f95404c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f95402a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f95403b.startActivity(this.f95404c);
                this.f95403b.finish();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(boolean z2, MainActivity mainActivity, Continuation continuation) {
            super(1, continuation);
            this.f95390g = z2;
            this.f95391h = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass3(this.f95390g, this.f95391h, continuation);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        
            if (r2 == r1) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r3, r4, r18) == r1) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r3, r4, r18) == r1) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r3, r4, r18) == r1) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x021b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r4, r8, r18) != r1) goto L71;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0148 A[PHI: r2 r6
          0x0148: PHI (r2v25 int) = (r2v21 int), (r2v28 int) binds: [B:47:0x0144, B:7:0x001f] A[DONT_GENERATE, DONT_INLINE]
          0x0148: PHI (r6v27 java.lang.Object) = (r6v22 java.lang.Object), (r6v30 java.lang.Object) binds: [B:47:0x0144, B:7:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x01c1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 568
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.MainActivity.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$onResume$1", f = "MainActivity.kt", l = {301}, m = "invokeSuspend", v = 1)
    static final class C29561 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f95405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f95406b;

        public C29561(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return MainActivity.this.new C29561(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f95406b;
            if (i3 == 0) {
                ResultKt.b(obj);
                int intExtra = MainActivity.this.getIntent().getIntExtra("NOTIFICATION_ID", -1);
                if (intExtra == 100017) {
                    NotificationDataStore notificationDataStoreT0 = MainActivity.this.T0();
                    this.f95405a = intExtra;
                    this.f95406b = 1;
                    if (AnswersHelperExtKt.a(notificationDataStoreT0, this) == objF) {
                        return objF;
                    }
                }
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            MainActivity.this.getIntent().removeExtra("NOTIFICATION_ID");
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C29561) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MainActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f95369t = LazyKt.a(lazyThreadSafetyMode, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.MainActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f95370u = LazyKt.a(lazyThreadSafetyMode, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.MainActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(NotificationDataStore.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f95371v = LazyKt.a(lazyThreadSafetyMode, new Function0<PassCodeDataStore>() { // from class: cz.mobilesoft.coreblock.MainActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PassCodeDataStore.class), objArr4, objArr5);
            }
        });
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f95372w = LazyKt.a(lazyThreadSafetyMode, new Function0<DeeplinkRouter>() { // from class: cz.mobilesoft.coreblock.MainActivity$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(DeeplinkRouter.class), objArr6, objArr7);
            }
        });
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        this.F = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.X0(this.f96449a, (ActivityResult) obj);
            }
        });
        this.G = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.Z0(this.f96450a, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore R0() {
        return (CoreDataStore) this.f95369t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeeplinkRouter S0() {
        return (DeeplinkRouter) this.f95372w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationDataStore T0() {
        return (NotificationDataStore) this.f95370u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PassCodeDataStore U0() {
        return (PassCodeDataStore) this.f95371v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        CoroutinesHelperExtKt.d(new MainActivity$handleDeeplink$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0() {
        DeepLinksUtils deepLinksUtils = DeepLinksUtils.f127818a;
        SingularCallbackHandler singularCallbackHandler = SingularCallbackHandler.f127992a;
        deepLinksUtils.j(this, new MainActivity$handleSingularDeeplink$1(singularCallbackHandler), new MainActivity$handleSingularDeeplink$2(singularCallbackHandler));
    }

    public static final void X0(MainActivity mainActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.d(mainActivity.f95368s, null, null, new MainActivity$passCodeLauncher$1$1(mainActivity, result, null), 3, null);
    }

    public static final void Z0(MainActivity mainActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            BuildersKt__Builders_commonKt.d(mainActivity.f95368s, null, null, new MainActivity$signInLauncher$1$1(result, mainActivity, null), 3, null);
        } else {
            mainActivity.finish();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public ActivityFragmentBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityFragmentBinding activityFragmentBindingC = ActivityFragmentBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityFragmentBindingC, "inflate(...)");
        return activityFragmentBindingC;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        xSRx.AsIdkxKun.invoke(null, this, bundle);
    }

    @Override // cz.mobilesoft.coreblock.activity.AdsBaseActivity, cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() throws IllegalAccessException, InvocationTargetException {
        CBwUegoGfYl.IsWstPIPWwq.invoke(null, this);
    }

    public void onInitialized() {
        PrefManager prefManager = PrefManager.f126839a;
        boolean zR1 = prefManager.r1();
        if (zR1) {
            prefManager.v1();
            CoroutinesHelperExtKt.d(new AnonymousClass1(null));
        }
        InterstitialUtils.f127880h.l(AdUnitId.APP_INTERSTITIAL);
        this.f95373x = getIntent().getBooleanExtra("SHOW_OREO_NOTIFICATION_DIALOG", false);
        this.f95374y = getIntent().getBooleanExtra("OPEN_BLOCK_NOTIFICATIONS", false);
        this.f95375z = getIntent().getBooleanExtra("OPEN_CHANGELOG", false);
        this.A = (Pair) getIntent().getSerializableExtra("STATISTICS_INTERVAL");
        this.B = getIntent().getBooleanExtra("IS_TILE_SERVICE", false);
        this.C = getIntent().getStringExtra("DASHBOARD_TAB");
        this.D = getIntent().getBooleanExtra("IS_FROM_SHORTCUT", false);
        this.E = getIntent().getStringExtra("SHORTCUT_ACTION");
        if (this.f95375z) {
            AnswersHelper.f128199a.k1();
        }
        String stringExtra = getIntent().getStringExtra("NOTIFICATION_OPENED_EVENT_NAME");
        if (stringExtra != null) {
            AnswersHelper.f128199a.K2(stringExtra);
            getIntent().removeExtra("NOTIFICATION_OPENED_EVENT_NAME");
        }
        CoroutinesHelperExtKt.d(new AnonymousClass3(zR1, this, null));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        V0();
    }

    @Override // cz.mobilesoft.coreblock.activity.AdsBaseActivity, cz.mobilesoft.coreblock.base.activity.BaseLockableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() throws IllegalAccessException, InvocationTargetException {
        AsHNMpHTEsKfE.NmRqBF.invoke(null, this);
    }
}
