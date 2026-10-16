package cz.mobilesoft.coreblock.util.ads;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.AdsUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BaseBannerUtils<T> implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompletableJob f128129a = JobKt__JobKt.b(null, 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f128130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f128131c;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        if (this.f128131c == 0) {
            return true;
        }
        AdsUtils adsUtils = AdsUtils.f127678i;
        return adsUtils.d() == 0 || System.currentTimeMillis() - this.f128131c < adsUtils.d();
    }

    public abstract void d(Context context, Function1 function1);

    public abstract void e(Object obj);

    public final void f(Context applicationContext, PremiumState premiumState, Function1 bannerCallback) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(bannerCallback, "bannerCallback");
        BuildersKt__Builders_commonKt.d(this, null, null, new BaseBannerUtils$getBanner$1(premiumState, this, bannerCallback, applicationContext, null), 3, null);
    }

    public final void g(Context context, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        k(context, premiumState);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f128129a.plus(Dispatchers.a());
    }

    public abstract Object h(Context context, Boolean bool);

    public final void k(Context applicationContext, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Object obj = this.f128130b;
        if (obj != null) {
            e(obj);
        }
        BuildersKt__Builders_commonKt.d(this, null, null, new BaseBannerUtils$loadNewBanner$2(premiumState, this, applicationContext, null), 3, null);
    }

    public final void l(long j3) {
        this.f128131c = j3;
    }
}
