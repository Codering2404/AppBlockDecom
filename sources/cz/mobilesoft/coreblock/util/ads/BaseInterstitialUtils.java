package cz.mobilesoft.coreblock.util.ads;

import android.app.Activity;
import android.content.Context;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.LazyMutable;
import cz.mobilesoft.coreblock.util.ads.BaseInterstitialUtils.BaseInterstitialAdProvider;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

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
public abstract class BaseInterstitialUtils<U, T extends BaseInterstitialAdProvider<U>> implements CoroutineScope {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f128149f = {Reflection.e(new MutablePropertyReference1Impl(BaseInterstitialUtils.class, "lastAdShowTime", "getLastAdShowTime()J", 0)), Reflection.e(new MutablePropertyReference1Impl(BaseInterstitialUtils.class, "interstitialAdTimeoutMS", "getInterstitialAdTimeoutMS()J", 0))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f128150g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompletableJob f128151a = JobKt__JobKt.b(null, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f128152b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyMutable f128153c = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.util.ads.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(BaseInterstitialUtils.o());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyMutable f128154d = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.util.ads.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Long.valueOf(BaseInterstitialUtils.m());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class BaseInterstitialAdProvider<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdUnitId f128155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f128156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Function1 f128157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f128158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f128159e;

        public BaseInterstitialAdProvider(AdUnitId adUnitId) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            this.f128155a = adUnitId;
        }

        public final Function1 a() {
            return this.f128157c;
        }

        public final AdUnitId b() {
            return this.f128155a;
        }

        public final Object c() {
            return this.f128156b;
        }

        public abstract Object d();

        public final boolean e() {
            if (this.f128159e == 0) {
                return true;
            }
            AdsUtils adsUtils = AdsUtils.f127678i;
            return adsUtils.d() == 0 || System.currentTimeMillis() - this.f128159e < adsUtils.d();
        }

        public final boolean f() {
            return this.f128158d;
        }

        public abstract void g(Context context, Boolean bool, PremiumState premiumState);

        public final void h(Function1 function1) {
            this.f128157c = function1;
        }

        public final void i(long j3) {
            this.f128159e = j3;
        }

        public final void j(Object obj) {
            this.f128156b = obj;
        }

        public final void k(boolean z2) {
            this.f128158d = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long j() {
        return ((Number) this.f128153c.a(this, f128149f[0])).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m() {
        return PrefManager.f126839a.F0() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o() {
        return PrefManager.f126839a.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(long j3) {
        this.f128153c.b(this, f128149f[0], Long.valueOf(j3));
    }

    public abstract void f(Context context, Function1 function1);

    public abstract BaseInterstitialAdProvider g(AdUnitId adUnitId);

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f128151a.plus(Dispatchers.a()).plus(CoroutinesHelperExtKt.b());
    }

    public final long h() {
        return ((Number) this.f128154d.a(this, f128149f[1])).longValue();
    }

    public final boolean k() {
        return (j() == 0 || System.currentTimeMillis() - j() >= h()) && PrefManager.f126839a.Y0();
    }

    public final void l(AdUnitId adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        if (((BaseInterstitialAdProvider) this.f128152b.get(adUnitId)) == null) {
            this.f128152b.put(adUnitId, g(adUnitId));
            Unit unit = Unit.f139807a;
        }
    }

    public final void p(Context context, AdUnitId adUnitId, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        BuildersKt__Builders_commonKt.d(this, null, null, new BaseInterstitialUtils$loadInterstitialAd$1(premiumState, this, adUnitId, context, null), 3, null);
    }

    public final void q(long j3) {
        this.f128154d.b(this, f128149f[1], Long.valueOf(j3));
    }

    public final void t(Activity activity, AdUnitId adUnitId, PremiumState premiumState, Function1 function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        BuildersKt__Builders_commonKt.d(this, null, null, new BaseInterstitialUtils$showInterstitialAd$1(premiumState, this, function1, adUnitId, activity, null), 3, null);
    }

    public abstract void u(Activity activity, Object obj);
}
