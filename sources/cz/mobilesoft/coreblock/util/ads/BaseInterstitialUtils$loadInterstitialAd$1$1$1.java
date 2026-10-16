package cz.mobilesoft.coreblock.util.ads;

import android.content.Context;
import android.util.Log;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
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
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils$loadInterstitialAd$1$1$1", f = "BaseInterstitialUtils.kt", l = {}, m = "invokeSuspend", v = 1)
final class BaseInterstitialUtils$loadInterstitialAd$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseInterstitialUtils f128169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f128170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdUnitId f128171d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseInterstitialUtils.BaseInterstitialAdProvider f128172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ PremiumState f128173g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInterstitialUtils$loadInterstitialAd$1$1$1(BaseInterstitialUtils baseInterstitialUtils, Context context, AdUnitId adUnitId, BaseInterstitialUtils.BaseInterstitialAdProvider baseInterstitialAdProvider, PremiumState premiumState, Continuation continuation) {
        super(2, continuation);
        this.f128169b = baseInterstitialUtils;
        this.f128170c = context;
        this.f128171d = adUnitId;
        this.f128172f = baseInterstitialAdProvider;
        this.f128173g = premiumState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(BaseInterstitialUtils baseInterstitialUtils, AdUnitId adUnitId, BaseInterstitialUtils.BaseInterstitialAdProvider baseInterstitialAdProvider, Context context, PremiumState premiumState, Boolean bool) {
        String str = "Loading interstitial with id " + adUnitId;
        String simpleName = BaseInterstitialUtils.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.i(simpleName, str);
        baseInterstitialAdProvider.g(context, bool, premiumState);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseInterstitialUtils$loadInterstitialAd$1$1$1(this.f128169b, this.f128170c, this.f128171d, this.f128172f, this.f128173g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f128168a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final BaseInterstitialUtils baseInterstitialUtils = this.f128169b;
        final Context context = this.f128170c;
        final AdUnitId adUnitId = this.f128171d;
        final BaseInterstitialUtils.BaseInterstitialAdProvider baseInterstitialAdProvider = this.f128172f;
        final PremiumState premiumState = this.f128173g;
        baseInterstitialUtils.f(context, new Function1() { // from class: cz.mobilesoft.coreblock.util.ads.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return BaseInterstitialUtils$loadInterstitialAd$1$1$1.q(baseInterstitialUtils, adUnitId, baseInterstitialAdProvider, context, premiumState, (Boolean) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseInterstitialUtils$loadInterstitialAd$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
