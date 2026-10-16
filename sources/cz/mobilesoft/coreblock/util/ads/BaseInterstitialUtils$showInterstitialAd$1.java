package cz.mobilesoft.coreblock.util.ads;

import android.app.Activity;
import android.util.Log;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1", f = "BaseInterstitialUtils.kt", l = {98, 103, 119}, m = "invokeSuspend", v = 1)
final class BaseInterstitialUtils$showInterstitialAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumState f128175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseInterstitialUtils f128176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f128177d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdUnitId f128178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Activity f128179g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$1", f = "BaseInterstitialUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128181b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f128181b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128181b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128180a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Function1 function1 = this.f128181b;
            if (function1 != null) {
                function1.invoke(Boxing.a(false));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$2", f = "BaseInterstitialUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseInterstitialUtils f128183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdUnitId f128184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f128185d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f128186f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BaseInterstitialUtils baseInterstitialUtils, AdUnitId adUnitId, Function1 function1, Activity activity, Continuation continuation) {
            super(2, continuation);
            this.f128183b = baseInterstitialUtils;
            this.f128184c = adUnitId;
            this.f128185d = function1;
            this.f128186f = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f128183b, this.f128184c, this.f128185d, this.f128186f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128182a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BaseInterstitialUtils.BaseInterstitialAdProvider baseInterstitialAdProvider = (BaseInterstitialUtils.BaseInterstitialAdProvider) this.f128183b.f128152b.get(this.f128184c);
            if (baseInterstitialAdProvider != null) {
                BaseInterstitialUtils baseInterstitialUtils = this.f128183b;
                Function1 function1 = this.f128185d;
                Activity activity = this.f128186f;
                AdUnitId adUnitId = this.f128184c;
                Object objD = baseInterstitialAdProvider.d();
                if (objD != null) {
                    baseInterstitialAdProvider.k(false);
                    baseInterstitialUtils.s(System.currentTimeMillis());
                    PrefManager.f126839a.k2(baseInterstitialUtils.j());
                    baseInterstitialAdProvider.h(function1);
                    baseInterstitialUtils.u(activity, objD);
                } else {
                    String simpleName = BaseInterstitialUtils.class.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                    Log.e(simpleName, "Cannot show ad with id " + adUnitId + " - no ad is loaded. Did you forget to call loadInterstitialAd(Activity, AdUnitId)?");
                    if (function1 != null) {
                        function1.invoke(Boxing.a(false));
                    }
                }
            } else {
                Function1 function12 = this.f128185d;
                if (function12 != null) {
                    function12.invoke(Boxing.a(false));
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$3", f = "BaseInterstitialUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f128188b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f128188b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f128188b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128187a == 0) {
                ResultKt.b(obj);
                Function1 function1 = this.f128188b;
                if (function1 != null) {
                    function1.invoke(Boxing.a(false));
                }
                return Unit.f139807a;
            }
            throw new IllegalStateException(FptyjHFU.hCEJRqnuhKrtif);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInterstitialUtils$showInterstitialAd$1(PremiumState premiumState, BaseInterstitialUtils baseInterstitialUtils, Function1 function1, AdUnitId adUnitId, Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f128175b = premiumState;
        this.f128176c = baseInterstitialUtils;
        this.f128177d = function1;
        this.f128178f = adUnitId;
        this.f128179g = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseInterstitialUtils$showInterstitialAd$1(this.f128175b, this.f128176c, this.f128177d, this.f128178f, this.f128179g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r11, r2, r10) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r11, r4, r10) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r11, r3, r10) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f128174a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1e
            if (r1 == r4) goto L1a
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L1a
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1a:
            kotlin.ResultKt.b(r11)
            goto L77
        L1e:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.enums.PremiumState r11 = r10.f128175b
            cz.mobilesoft.coreblock.enums.Product r1 = cz.mobilesoft.coreblock.enums.Product.ADS
            boolean r11 = r11.f(r1)
            r1 = 0
            if (r11 == 0) goto L40
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$1 r2 = new cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$1
            kotlin.jvm.functions.Function1 r3 = r10.f128177d
            r2.<init>(r3, r1)
            r10.f128174a = r4
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r2, r10)
            if (r11 != r0) goto L77
            goto L76
        L40:
            cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils r11 = r10.f128176c
            boolean r11 = r11.k()
            if (r11 == 0) goto L63
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$2 r4 = new cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$2
            cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils r5 = r10.f128176c
            cz.mobilesoft.coreblock.util.constants.AdUnitId r6 = r10.f128178f
            kotlin.jvm.functions.Function1 r7 = r10.f128177d
            android.app.Activity r8 = r10.f128179g
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            r10.f128174a = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r4, r10)
            if (r11 != r0) goto L77
            goto L76
        L63:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$3 r3 = new cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1$3
            kotlin.jvm.functions.Function1 r4 = r10.f128177d
            r3.<init>(r4, r1)
            r10.f128174a = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r3, r10)
            if (r11 != r0) goto L77
        L76:
            return r0
        L77:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$showInterstitialAd$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseInterstitialUtils$showInterstitialAd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
