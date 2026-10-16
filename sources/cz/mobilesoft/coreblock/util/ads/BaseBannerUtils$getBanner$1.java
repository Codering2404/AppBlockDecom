package cz.mobilesoft.coreblock.util.ads;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$getBanner$1", f = "BaseBannerUtils.kt", l = {47}, m = "invokeSuspend", v = 1)
final class BaseBannerUtils$getBanner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumState f128133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseBannerUtils f128134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f128135d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f128136f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$getBanner$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$getBanner$1$1", f = "BaseBannerUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f128138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseBannerUtils f128139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f128140d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f128141f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseBannerUtils baseBannerUtils, Function1 function1, Context context, Continuation continuation) {
            super(2, continuation);
            this.f128139c = baseBannerUtils;
            this.f128140d = function1;
            this.f128141f = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(BaseBannerUtils baseBannerUtils, Context context, Boolean bool) {
            baseBannerUtils.f128130b = baseBannerUtils.h(context, bool);
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128139c, this.f128140d, this.f128141f, continuation);
            anonymousClass1.f128138b = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = r5.f128138b
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r5.f128137a
                if (r0 != 0) goto L55
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.util.ads.BaseBannerUtils r6 = r5.f128139c
                java.lang.Object r6 = cz.mobilesoft.coreblock.util.ads.BaseBannerUtils.a(r6)
                if (r6 == 0) goto L44
                cz.mobilesoft.coreblock.util.ads.BaseBannerUtils r0 = r5.f128139c
                boolean r0 = cz.mobilesoft.coreblock.util.ads.BaseBannerUtils.b(r0)
                r1 = 0
                if (r0 == 0) goto L20
                goto L21
            L20:
                r6 = r1
            L21:
                if (r6 == 0) goto L44
                kotlin.jvm.functions.Function1 r0 = r5.f128140d
                boolean r2 = r6 instanceof android.view.View
                if (r2 == 0) goto L2d
                r2 = r6
                android.view.View r2 = (android.view.View) r2
                goto L2e
            L2d:
                r2 = r1
            L2e:
                if (r2 == 0) goto L40
                android.view.ViewParent r3 = r2.getParent()
                boolean r4 = r3 instanceof android.view.ViewGroup
                if (r4 == 0) goto L3b
                r1 = r3
                android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            L3b:
                if (r1 == 0) goto L40
                r1.removeView(r2)
            L40:
                r0.invoke(r6)
                goto L52
            L44:
                android.content.Context r6 = r5.f128141f
                cz.mobilesoft.coreblock.util.ads.BaseBannerUtils r0 = r5.f128139c
                cz.mobilesoft.coreblock.util.InterstitialUtils r1 = cz.mobilesoft.coreblock.util.InterstitialUtils.f127880h
                cz.mobilesoft.coreblock.util.ads.c r2 = new cz.mobilesoft.coreblock.util.ads.c
                r2.<init>()
                r1.f(r6, r2)
            L52:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            L55:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$getBanner$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBannerUtils$getBanner$1(PremiumState premiumState, BaseBannerUtils baseBannerUtils, Function1 function1, Context context, Continuation continuation) {
        super(2, continuation);
        this.f128133b = premiumState;
        this.f128134c = baseBannerUtils;
        this.f128135d = function1;
        this.f128136f = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseBannerUtils$getBanner$1(this.f128133b, this.f128134c, this.f128135d, this.f128136f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128132a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!this.f128133b.f(Product.ADS)) {
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128134c, this.f128135d, this.f128136f, null);
                this.f128132a = 1;
                if (BuildersKt.g(mainCoroutineDispatcherC, anonymousClass1, this) == objF) {
                    return objF;
                }
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
        return ((BaseBannerUtils$getBanner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
