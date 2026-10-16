package cz.mobilesoft.coreblock.util.subscription;

import android.content.Context;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DiscountRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f129679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f129680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f129681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f129682d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f129683f;

    /* JADX WARN: Multi-variable type inference failed */
    public DiscountRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f129679a = context;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f129680b = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.util.subscription.DiscountRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f129681c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.util.subscription.DiscountRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f129682d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<LaunchTimeDao>() { // from class: cz.mobilesoft.coreblock.util.subscription.DiscountRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(LaunchTimeDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f129683f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.subscription.DiscountRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr6, objArr7);
            }
        });
    }

    private final DevDataStore b() {
        return (DevDataStore) this.f129680b.getValue();
    }

    private final DiscountDataStore c() {
        return (DiscountDataStore) this.f129681c.getValue();
    }

    private final LaunchTimeDao d() {
        return (LaunchTimeDao) this.f129682d.getValue();
    }

    private final PremiumRepositoryV2 e() {
        return (PremiumRepositoryV2) this.f129683f.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f4, code lost:
    
        r3 = r28;
        r1 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x017a -> B:71:0x01f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x01e4 -> B:69:0x01ec). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(long r28, kotlin.coroutines.Continuation r30) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.subscription.DiscountRepository.a(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(long r30, cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource r32, cz.mobilesoft.coreblock.enums.RevenueCatPlacement r33, kotlin.coroutines.Continuation r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.subscription.DiscountRepository.f(long, cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource, cz.mobilesoft.coreblock.enums.RevenueCatPlacement, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowDiscount50$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowDiscount50$1 r0 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowDiscount50$1) r0
            int r1 = r0.f129716d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129716d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowDiscount50$1 r0 = new cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowDiscount50$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f129714b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129716d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            int r0 = r0.f129713a
            kotlin.ResultKt.b(r8)
            goto L8a
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L39:
            kotlin.ResultKt.b(r8)
            goto L6f
        L3d:
            kotlin.ResultKt.b(r8)
            goto L51
        L41:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r8 = r7.c()
            r0.f129716d = r5
            java.lang.Object r8 = r8.i2(r0)
            if (r8 != r1) goto L51
            goto L86
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L5e
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r8
        L5e:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r8 = r7.c()
            kotlinx.coroutines.flow.Flow r8 = r8.C0()
            r0.f129716d = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L6f
            goto L86
        L6f:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r2 = -1
            if (r8 == r2) goto L93
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r2 = r7.c()
            r0.f129713a = r8
            r0.f129716d = r3
            java.lang.Object r0 = r2.A0(r0)
            if (r0 != r1) goto L87
        L86:
            return r1
        L87:
            r6 = r0
            r0 = r8
            r8 = r6
        L8a:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 <= r0) goto L93
            goto L94
        L93:
            r5 = 0
        L94:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.subscription.DiscountRepository.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0092, code lost:
    
        if (r1 == r3) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0159, code lost:
    
        if (r1 == r3) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6 A[PHI: r1 r4
      0x00d6: PHI (r1v20 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:40:0x00d2, B:21:0x0065] A[DONT_GENERATE, DONT_INLINE]
      0x00d6: PHI (r4v5 cz.mobilesoft.coreblock.enums.RevenueCatPlacement) = (r4v3 cz.mobilesoft.coreblock.enums.RevenueCatPlacement), (r4v18 cz.mobilesoft.coreblock.enums.RevenueCatPlacement) binds: [B:40:0x00d2, B:21:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0145 A[PHI: r4 r8 r9 r13
      0x0145: PHI (r4v10 int) = (r4v8 int), (r4v12 int) binds: [B:58:0x010f, B:69:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r8v2 cz.mobilesoft.coreblock.enums.RevenueCatPlacement) = (r8v1 cz.mobilesoft.coreblock.enums.RevenueCatPlacement), (r8v3 cz.mobilesoft.coreblock.enums.RevenueCatPlacement) binds: [B:58:0x010f, B:69:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r9v3 long) = (r9v1 long), (r9v5 long) binds: [B:58:0x010f, B:69:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0145: PHI (r13v2 long) = (r13v1 long), (r13v3 long) binds: [B:58:0x010f, B:69:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(cz.mobilesoft.coreblock.enums.RevenueCatPlacement r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.subscription.DiscountRepository.h(cz.mobilesoft.coreblock.enums.RevenueCatPlacement, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r6 == r1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        if (r6 != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowEarliestDiscount$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowEarliestDiscount$1 r0 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowEarliestDiscount$1) r0
            int r1 = r0.f129726c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129726c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowEarliestDiscount$1 r0 = new cz.mobilesoft.coreblock.util.subscription.DiscountRepository$shouldShowEarliestDiscount$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f129724a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129726c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L76
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L54
        L38:
            kotlin.ResultKt.b(r6)
            java.lang.Boolean r6 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L65
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r6 = r5.b()
            kotlinx.coroutines.flow.Flow r6 = r6.a1()
            r0.f129726c = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L54
            goto L75
        L54:
            cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState r6 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState) r6
            java.lang.Boolean r6 = r6.isActive()
            if (r6 == 0) goto L65
            boolean r6 = r6.booleanValue()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r6
        L65:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r6 = r5.c()
            kotlinx.coroutines.flow.Flow r6 = r6.G0()
            r0.f129726c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L76
        L75:
            return r1
        L76:
            java.lang.Number r6 = (java.lang.Number) r6
            long r0 = r6.longValue()
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 < 0) goto L98
            long r2 = java.lang.System.currentTimeMillis()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.HOURS
            long r0 = r6.toMillis(r0)
            long r2 = r2 - r0
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r6 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            long r0 = r6.C0()
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 <= 0) goto L98
            goto L99
        L98:
            r4 = 0
        L99:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.subscription.DiscountRepository.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
