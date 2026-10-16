package cz.mobilesoft.coreblock.util.ads;

import android.content.Context;
import android.util.Log;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$loadInterstitialAd$1", f = "BaseInterstitialUtils.kt", l = {69}, m = "invokeSuspend", v = 1)
final class BaseInterstitialUtils$loadInterstitialAd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f128162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f128163d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PremiumState f128164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BaseInterstitialUtils f128165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AdUnitId f128166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f128167i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInterstitialUtils$loadInterstitialAd$1(PremiumState premiumState, BaseInterstitialUtils baseInterstitialUtils, AdUnitId adUnitId, Context context, Continuation continuation) {
        super(2, continuation);
        this.f128164f = premiumState;
        this.f128165g = baseInterstitialUtils;
        this.f128166h = adUnitId;
        this.f128167i = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseInterstitialUtils$loadInterstitialAd$1(this.f128164f, this.f128165g, this.f128166h, this.f128167i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BaseInterstitialUtils.BaseInterstitialAdProvider baseInterstitialAdProvider;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128163d;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!this.f128164f.f(Product.ADS) && (baseInterstitialAdProvider = (BaseInterstitialUtils.BaseInterstitialAdProvider) this.f128165g.f128152b.get(this.f128166h)) != null) {
                BaseInterstitialUtils baseInterstitialUtils = this.f128165g;
                AdUnitId adUnitId = this.f128166h;
                Context context = this.f128167i;
                PremiumState premiumState = this.f128164f;
                if (baseInterstitialAdProvider.d() == null) {
                    MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                    BaseInterstitialUtils$loadInterstitialAd$1$1$1 baseInterstitialUtils$loadInterstitialAd$1$1$1 = new BaseInterstitialUtils$loadInterstitialAd$1$1$1(baseInterstitialUtils, context, adUnitId, baseInterstitialAdProvider, premiumState, null);
                    this.f128160a = baseInterstitialAdProvider;
                    this.f128161b = SpillingKt.a(baseInterstitialAdProvider);
                    this.f128162c = 0;
                    this.f128163d = 1;
                    if (BuildersKt.g(mainCoroutineDispatcherC, baseInterstitialUtils$loadInterstitialAd$1$1$1, this) == objF) {
                        return objF;
                    }
                } else {
                    String simpleName = BaseInterstitialUtils.class.getSimpleName();
                    Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                    Boxing.d(Log.i(simpleName, "Tried to load interstitial with id " + adUnitId + " but it's already loaded"));
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
        return ((BaseInterstitialUtils$loadInterstitialAd$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
