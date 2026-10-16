package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class CampaignCheckWorker extends CoroutineWorker implements KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f123877g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f123878h = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123880f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object c(android.content.Context r12, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r13, long r14, kotlin.coroutines.Continuation r16) throws java.lang.Throwable {
            /*
                r11 = this;
                r0 = r16
                boolean r1 = r0 instanceof cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$cancelCurrentCampaign$1
                if (r1 == 0) goto L16
                r1 = r0
                cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$cancelCurrentCampaign$1 r1 = (cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$cancelCurrentCampaign$1) r1
                int r2 = r1.f123887h
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L16
                int r2 = r2 - r3
                r1.f123887h = r2
            L14:
                r7 = r1
                goto L1c
            L16:
                cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$cancelCurrentCampaign$1 r1 = new cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$Companion$cancelCurrentCampaign$1
                r1.<init>(r11, r0)
                goto L14
            L1c:
                java.lang.Object r0 = r7.f123885f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r7.f123887h
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L5d
                if (r2 == r4) goto L47
                if (r2 != r3) goto L3f
                long r12 = r7.f123884d
                java.lang.Object r1 = r7.f123883c
                cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO r1 = (cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO) r1
                java.lang.Object r1 = r7.f123882b
                cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r1 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) r1
                java.lang.Object r1 = r7.f123881a
                android.content.Context r1 = (android.content.Context) r1
                kotlin.ResultKt.b(r0)
                goto La7
            L3f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L47:
                long r12 = r7.f123884d
                java.lang.Object r2 = r7.f123883c
                cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO r2 = (cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO) r2
                java.lang.Object r4 = r7.f123882b
                cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r4 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) r4
                java.lang.Object r5 = r7.f123881a
                android.content.Context r5 = (android.content.Context) r5
                kotlin.ResultKt.b(r0)
                r8 = r12
                r6 = r2
                r2 = r4
                r12 = r5
                goto L83
            L5d:
                kotlin.ResultKt.b(r0)
                cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO r2 = new cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO
                cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource r0 = cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource.None
                r5 = 0
                java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
                r9 = -1
                r2.<init>(r9, r0, r8)
                r7.f123881a = r12
                r7.f123882b = r13
                r7.f123883c = r2
                r7.f123884d = r14
                r7.f123887h = r4
                java.lang.Object r0 = r13.Q1(r5, r7)
                if (r0 != r1) goto L80
                goto La4
            L80:
                r8 = r14
                r6 = r2
                r2 = r13
            L83:
                cz.mobilesoft.coreblock.enums.RevenueCatOffering r13 = cz.mobilesoft.coreblock.enums.RevenueCatOffering.Campaign
                java.lang.String r13 = r13.getOfferingId()
                r7.f123881a = r12
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
                r7.f123882b = r0
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                r7.f123883c = r0
                r7.f123884d = r8
                r7.f123887h = r3
                r4 = -1
                r3 = r13
                java.lang.Object r13 = r2.C1(r3, r4, r6, r7)
                if (r13 != r1) goto La5
            La4:
                return r1
            La5:
                r1 = r12
                r12 = r8
            La7:
                java.lang.String r0 = "Canceling campaign"
                r11.e(r0)
                cz.mobilesoft.coreblock.util.runnability.JobHelper.c()
                cz.mobilesoft.coreblock.util.notifications.NotificationHelper r0 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
                r0.c(r1)
                cz.mobilesoft.coreblock.util.analytics.AnswersHelper r0 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
                r0.X0(r12)
                kotlin.Unit r12 = kotlin.Unit.f139807a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker.Companion.c(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final void e(String str) {
            Log.d(CampaignCheckWorker.class.getSimpleName(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object g(android.content.Context r12, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r13, cz.mobilesoft.coreblock.rest.response.CurrentCampaignResponse r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 230
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker.Companion.g(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore, cz.mobilesoft.coreblock.rest.response.CurrentCampaignResponse, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:68:0x02ba, code lost:
        
            if (r0.g(r4, r7, r12, r5) == r6) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x0344, code lost:
        
            if (r0.c(r4, r9, r10, r5) == r6) goto L81;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x016a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x019b  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01fe  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x020e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0266  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0273  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x027b  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x02be  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0306  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object d(android.content.Context r22, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r23, cz.mobilesoft.coreblock.enums.PremiumState r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 900
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker.Companion.d(android.content.Context, cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore, cz.mobilesoft.coreblock.enums.PremiumState, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object f(android.content.Context r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 210
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker.Companion.f(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CampaignCheckWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123879d = LazyKt.a(lazyThreadSafetyModeB, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123880f = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.worker.CampaignCheckWorker$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore k() {
        return (DiscountDataStore) this.f123879d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 l() {
        return (PremiumRepositoryV2) this.f123880f.getValue();
    }

    @Override // androidx.work.CoroutineWorker
    public Object c(Continuation continuation) {
        return BuildersKt.g(CoroutinesHelperExtKt.b(), new CampaignCheckWorker$doWork$2(this, null), continuation);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
