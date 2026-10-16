package cz.mobilesoft.coreblock.scene.premium.trial_upsell;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

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
public final class TrialUpsellManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DiscountDataStore f113963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DevDataStore f113964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoreDataStore f113965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f113966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PremiumRepositoryV2 f113967e;

    public TrialUpsellManager(DiscountDataStore discountDataStore, DevDataStore devDataStore, CoreDataStore coreDataStore, Context applicationContext, PremiumRepositoryV2 premiumRepository) {
        Intrinsics.checkNotNullParameter(discountDataStore, "discountDataStore");
        Intrinsics.checkNotNullParameter(devDataStore, "devDataStore");
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        this.f113963a = discountDataStore;
        this.f113964b = devDataStore;
        this.f113965c = coreDataStore;
        this.f113966d = applicationContext;
        this.f113967e = premiumRepository;
    }

    private final long e(int i3) {
        return ((long) i3) * 3600000;
    }

    private final Object f(Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new TrialUpsellManager$isTrialEligible$2(this, null), continuation);
    }

    private final void g(String str) {
        Context context = this.f113966d;
        Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.IntroTrial(false, 1, null), str, "trial_upsell", false, true, false, null, 144, null);
        intentC.addFlags(268435456);
        context.startActivity(intentC);
    }

    private final boolean i(long j3, int i3) {
        return j3 + e(i3) > System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x014f, code lost:
    
        if (r5.J1(r6, r0) != r1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x016f, code lost:
    
        if (r12.x1(r6, r0) == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(java.lang.String r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager.h(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
