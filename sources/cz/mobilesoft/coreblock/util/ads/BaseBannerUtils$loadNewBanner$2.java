package cz.mobilesoft.coreblock.util.ads;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$loadNewBanner$2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$loadNewBanner$2", f = "BaseBannerUtils.kt", l = {75}, m = "invokeSuspend", v = 1)
final class BaseBannerUtils$loadNewBanner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumState f128143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseBannerUtils f128144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f128145d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$loadNewBanner$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseBannerUtils$loadNewBanner$2$1", f = "BaseBannerUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseBannerUtils f128147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f128148c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseBannerUtils baseBannerUtils, Context context, Continuation continuation) {
            super(2, continuation);
            this.f128147b = baseBannerUtils;
            this.f128148c = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(BaseBannerUtils baseBannerUtils, Context context, Boolean bool) {
            baseBannerUtils.f128130b = baseBannerUtils.h(context, bool);
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128147b, this.f128148c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128146a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final BaseBannerUtils baseBannerUtils = this.f128147b;
            final Context context = this.f128148c;
            baseBannerUtils.d(context, new Function1() { // from class: cz.mobilesoft.coreblock.util.ads.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BaseBannerUtils$loadNewBanner$2.AnonymousClass1.q(baseBannerUtils, context, (Boolean) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBannerUtils$loadNewBanner$2(PremiumState premiumState, BaseBannerUtils baseBannerUtils, Context context, Continuation continuation) {
        super(2, continuation);
        this.f128143b = premiumState;
        this.f128144c = baseBannerUtils;
        this.f128145d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseBannerUtils$loadNewBanner$2(this.f128143b, this.f128144c, this.f128145d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128142a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!this.f128143b.f(Product.ADS)) {
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f128144c, this.f128145d, null);
                this.f128142a = 1;
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
        return ((BaseBannerUtils$loadNewBanner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
