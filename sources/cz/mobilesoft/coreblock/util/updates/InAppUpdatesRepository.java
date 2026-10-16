package cz.mobilesoft.coreblock.util.updates;

import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateManager;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import java.util.concurrent.TimeUnit;
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
public final class InAppUpdatesRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InAppUpdatesRepository f129855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f129857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f129858d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f129859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f129860g;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final InAppUpdatesRepository inAppUpdatesRepository = new InAppUpdatesRepository();
        f129855a = inAppUpdatesRepository;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129856b = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = inAppUpdatesRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f129857c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<InAppUpdatesDataStore>() { // from class: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = inAppUpdatesRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InAppUpdatesDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f129858d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<AppUpdateManager>() { // from class: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = inAppUpdatesRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AppUpdateManager.class), objArr4, objArr5);
            }
        });
        f129859f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.updates.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(InAppUpdatesRepository.D());
            }
        });
        f129860g = 8;
    }

    private InAppUpdatesRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d A[PHI: r1 r6 r9 r10 r11
      0x006d: PHI (r1v10 long) = (r1v8 long), (r1v11 long) binds: [B:36:0x011a, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r6v13 int) = (r6v11 int), (r6v14 int) binds: [B:36:0x011a, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r9v13 int) = (r9v11 int), (r9v15 int) binds: [B:36:0x011a, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r10v4 java.lang.Integer) = (r10v1 java.lang.Integer), (r10v6 java.lang.Integer) binds: [B:36:0x011a, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x006d: PHI (r11v6 cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore) = 
      (r11v3 cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore)
      (r11v10 cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore)
     binds: [B:36:0x011a, B:15:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r20, int r21, int r22, java.lang.Integer r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.A(cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore, int, int, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C(int r5, int r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$scheduleOrCancelNotification$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$scheduleOrCancelNotification$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$scheduleOrCancelNotification$1) r0
            int r1 = r0.f129929f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129929f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$scheduleOrCancelNotification$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$scheduleOrCancelNotification$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f129927c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129929f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            int r6 = r0.f129926b
            int r5 = r0.f129925a
            kotlin.ResultKt.b(r7)
            goto L4d
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r7 = r4.m()
            kotlinx.coroutines.flow.Flow r7 = r7.L()
            r0.f129925a = r5
            r0.f129926b = r6
            r0.f129929f = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7e
            java.lang.Long r7 = r4.t(r5)
            if (r7 == 0) goto L7e
            long r0 = r7.longValue()
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L69
            cz.mobilesoft.coreblock.util.runnability.JobHelper.z(r0)
            goto L7b
        L69:
            cz.mobilesoft.coreblock.util.notifications.NotificationHelper r7 = cz.mobilesoft.coreblock.util.notifications.NotificationHelper.f128940a
            android.content.Context r0 = cz.mobilesoft.coreblock.LockieApplication.g()
            java.lang.String r1 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.d(r6)
            r7.A(r0, r5, r6)
        L7b:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L7e:
            r4.h()
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.C(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long D() {
        return BuildConfig.f95357b.booleanValue() ? TimeUnit.MINUTES.toMillis(1L) : TimeUnit.DAYS.toMillis(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AppUpdateManager l() {
        return (AppUpdateManager) f129858d.getValue();
    }

    private final int o(int i3) {
        return (i3 == 2 || i3 == 3) ? R.string.f95819m1 : (i3 == 4 || i3 == 5) ? R.string.f95811k1 : R.string.f95815l1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(int r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.p(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Long s(int r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r3 = 0
            if (r6 == 0) goto L1b
            r4 = 3
            if (r6 == r1) goto L1f
            r1 = 2
            if (r6 == r1) goto L1d
            if (r6 == r4) goto L1d
            r1 = 4
            if (r6 == r1) goto L23
            r1 = 5
            if (r6 == r1) goto L23
        L1b:
            r0 = r3
            goto L23
        L1d:
            r0 = r2
            goto L23
        L1f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
        L23:
            if (r0 == 0) goto L34
            int r6 = r0.intValue()
            long r0 = (long) r6
            long r2 = r5.x()
            long r0 = r0 * r2
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            return r6
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.s(int):java.lang.Long");
    }

    private final Long t(int i3) {
        return i3 != 3 ? (i3 == 4 || i3 == 5) ? 0L : null : Long.valueOf(x());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Long u(int r5) {
        /*
            r4 = this;
            r0 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = 0
            if (r5 == 0) goto L16
            r3 = 2
            if (r5 == r0) goto L1e
            if (r5 == r3) goto L22
            r0 = 3
            if (r5 == r0) goto L22
            r0 = 4
            if (r5 == r0) goto L22
            r0 = 5
            if (r5 == r0) goto L18
        L16:
            r1 = r2
            goto L22
        L18:
            r5 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L22
        L1e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
        L22:
            if (r1 == 0) goto L33
            int r5 = r1.intValue()
            long r0 = (long) r5
            long r2 = r4.x()
            long r0 = r0 * r2
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            return r5
        L33:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.u(int):java.lang.Long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getVersionPrioritiesMocked$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getVersionPrioritiesMocked$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getVersionPrioritiesMocked$1) r0
            int r1 = r0.f129908c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129908c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getVersionPrioritiesMocked$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getVersionPrioritiesMocked$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f129906a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129908c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            java.lang.Boolean r5 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L8c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r5 = r4.n()
            kotlinx.coroutines.flow.Flow r5 = r5.F0()
            r0.f129908c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L4d
            return r1
        L4d:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO r5 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO) r5
            boolean r0 = r5.isMockingEnabledAndSetUpCorrectly()
            if (r0 == 0) goto L8c
            java.util.Map r5 = r5.getParsedPriorities()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L6a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L8b
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesVersion r2 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesVersion
            java.lang.Object r3 = r1.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            java.lang.Object r1 = r1.getValue()
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2.<init>(r3, r1)
            r0.add(r2)
            goto L6a
        L8b:
            return r0
        L8c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(int r7, int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$handleNewlyDiscoveredPriority$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$handleNewlyDiscoveredPriority$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$handleNewlyDiscoveredPriority$1) r0
            int r1 = r0.f129913f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129913f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$handleNewlyDiscoveredPriority$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$handleNewlyDiscoveredPriority$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f129911c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129913f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            int r7 = r0.f129910b
            int r8 = r0.f129909a
            kotlin.ResultKt.b(r9)
            goto L64
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            int r8 = r0.f129910b
            int r7 = r0.f129909a
            kotlin.ResultKt.b(r9)
            goto L54
        L40:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r9 = r6.m()
            r0.f129909a = r7
            r0.f129910b = r8
            r0.f129913f = r4
            java.lang.Object r9 = r9.P(r8, r0)
            if (r9 != r1) goto L54
            goto L60
        L54:
            r0.f129909a = r7
            r0.f129910b = r8
            r0.f129913f = r3
            java.lang.Object r9 = r6.C(r8, r7, r0)
            if (r9 != r1) goto L61
        L60:
            return r1
        L61:
            r5 = r8
            r8 = r7
            r7 = r5
        L64:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r9 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r9.h2(r8, r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.z(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$isRealUpdateAvailableOnline$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$isRealUpdateAvailableOnline$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$isRealUpdateAvailableOnline$1) r0
            int r1 = r0.f129924c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129924c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$isRealUpdateAvailableOnline$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$isRealUpdateAvailableOnline$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f129922a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129924c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Exception -> L2a
            goto L4d
        L2a:
            r6 = move-exception
            goto L60
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            com.google.android.play.core.appupdate.AppUpdateManager r6 = r5.l()     // Catch: java.lang.Exception -> L2a
            com.google.android.gms.tasks.Task r6 = r6.a()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "getAppUpdateInfo(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch: java.lang.Exception -> L2a
            r0.f129924c = r4     // Catch: java.lang.Exception -> L2a
            java.lang.Object r6 = kotlinx.coroutines.tasks.TasksKt.b(r6, r0)     // Catch: java.lang.Exception -> L2a
            if (r6 != r1) goto L4d
            return r1
        L4d:
            com.google.android.play.core.appupdate.AppUpdateInfo r6 = (com.google.android.play.core.appupdate.AppUpdateInfo) r6     // Catch: java.lang.Exception -> L2a
            int r0 = r6.f()     // Catch: java.lang.Exception -> L2a
            r1 = 2
            if (r0 != r1) goto L63
            int r6 = r6.a()     // Catch: java.lang.Exception -> L2a
            int r0 = cz.mobilesoft.coreblock.LockieApplication.f95359d     // Catch: java.lang.Exception -> L2a
            if (r6 <= r0) goto L63
            r3 = r4
            goto L63
        L60:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r6)
        L63:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.B(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void h() {
        JobHelper.d();
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        notificationHelper.f(contextG);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        if (r11.T(0, r0) != r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$clearPendingInAppUpdateData$1
            if (r0 == 0) goto L13
            r0 = r11
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$clearPendingInAppUpdateData$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$clearPendingInAppUpdateData$1) r0
            int r1 = r0.f129863c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129863c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$clearPendingInAppUpdateData$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$clearPendingInAppUpdateData$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.f129861a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129863c
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L4f
            if (r2 == r7) goto L4b
            if (r2 == r6) goto L47
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            kotlin.ResultKt.b(r11)
            goto L95
        L37:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3f:
            kotlin.ResultKt.b(r11)
            goto L88
        L43:
            kotlin.ResultKt.b(r11)
            goto L7b
        L47:
            kotlin.ResultKt.b(r11)
            goto L6e
        L4b:
            kotlin.ResultKt.b(r11)
            goto L60
        L4f:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r11 = r10.m()
            r0.f129863c = r7
            r2 = 0
            java.lang.Object r11 = r11.R(r2, r0)
            if (r11 != r1) goto L60
            goto L94
        L60:
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r11 = r10.m()
            r0.f129863c = r6
            r2 = -1
            java.lang.Object r11 = r11.P(r2, r0)
            if (r11 != r1) goto L6e
            goto L94
        L6e:
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r11 = r10.m()
            r0.f129863c = r5
            java.lang.Object r11 = r11.Q(r8, r0)
            if (r11 != r1) goto L7b
            goto L94
        L7b:
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r11 = r10.m()
            r0.f129863c = r4
            java.lang.Object r11 = r11.O(r8, r0)
            if (r11 != r1) goto L88
            goto L94
        L88:
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r11 = r10.m()
            r0.f129863c = r3
            java.lang.Object r11 = r11.T(r8, r0)
            if (r11 != r1) goto L95
        L94:
            return r1
        L95:
            r10.h()
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012a A[PHI: r1 r5 r7 r8 r9 r14
      0x012a: PHI (r1v9 int) = (r1v7 int), (r1v11 int) binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r5v7 int) = (r5v4 int), (r5v9 int) binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r7v9 int) = (r7v6 int), (r7v10 int) binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r8v10 int) = (r8v6 int), (r8v11 int) binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r9v5 com.google.android.play.core.appupdate.AppUpdateInfo) = 
      (r9v3 com.google.android.play.core.appupdate.AppUpdateInfo)
      (r9v7 com.google.android.play.core.appupdate.AppUpdateInfo)
     binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r14v20 java.lang.Object) = (r14v19 java.lang.Object), (r14v1 java.lang.Object) binds: [B:42:0x0126, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.k(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final InAppUpdatesDataStore m() {
        return (InAppUpdatesDataStore) f129857c.getValue();
    }

    public final DevDataStore n() {
        return (DevDataStore) f129856b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020a A[PHI: r1 r4 r5 r8 r9 r10
      0x020a: PHI (r1v37 int) = (r1v35 int), (r1v38 int) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r4v13 int) = (r4v10 int), (r4v16 int) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r5v2 long) = (r5v1 long), (r5v3 long) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r8v3 int) = (r8v1 int), (r8v5 int) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r9v1 java.lang.Long) = (r9v0 java.lang.Long), (r9v4 java.lang.Long) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x020a: PHI (r10v1 java.lang.Long) = (r10v0 java.lang.Long), (r10v4 java.lang.Long) binds: [B:67:0x0206, B:18:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int r(int i3) {
        return o(i3);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r6 == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getPendingInAppUpdateVersionCode$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getPendingInAppUpdateVersionCode$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getPendingInAppUpdateVersionCode$1) r0
            int r1 = r0.f129898c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129898c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getPendingInAppUpdateVersionCode$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getPendingInAppUpdateVersionCode$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f129896a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129898c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            goto L67
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L4c
        L38:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r6 = r5.m()
            kotlinx.coroutines.flow.Flow r6 = r6.L()
            r0.f129898c = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L4c
            goto L66
        L4c:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L56
            r6 = 0
            return r6
        L56:
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r6 = r5.m()
            kotlinx.coroutines.flow.Flow r6 = r6.F()
            r0.f129898c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L67
        L66:
            return r1
        L67:
            java.lang.Integer r6 = (java.lang.Integer) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getShowInAppUpdateLockScreenBannerVersionCode$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getShowInAppUpdateLockScreenBannerVersionCode$1 r0 = (cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getShowInAppUpdateLockScreenBannerVersionCode$1) r0
            int r1 = r0.f129905h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129905h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getShowInAppUpdateLockScreenBannerVersionCode$1 r0 = new cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository$getShowInAppUpdateLockScreenBannerVersionCode$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f129903f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129905h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r1 = r0.f129901c
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r1 = r0.f129900b
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r0 = r0.f129899a
            java.lang.Integer r0 = (java.lang.Integer) r0
            kotlin.ResultKt.b(r6)
            goto L78
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L40:
            kotlin.ResultKt.b(r6)
            goto L50
        L44:
            kotlin.ResultKt.b(r6)
            r0.f129905h = r4
            java.lang.Object r6 = r5.v(r0)
            if (r6 != r1) goto L50
            goto L75
        L50:
            java.lang.Integer r6 = (java.lang.Integer) r6
            cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository r2 = cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.f129855a
            cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore r2 = r2.m()
            kotlinx.coroutines.flow.Flow r2 = r2.D()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f129899a = r4
            r0.f129900b = r6
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f129901c = r4
            r4 = 0
            r0.f129902d = r4
            r0.f129905h = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L76
        L75:
            return r1
        L76:
            r1 = r6
            r6 = r0
        L78:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            r0 = 3
            if (r0 > r6) goto L85
            r0 = 6
            if (r6 >= r0) goto L85
            return r1
        L85:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository.w(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long x() {
        return ((Number) f129859f.getValue()).longValue();
    }
}
