package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.google.android.gms.location.Geofence;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;
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
public final class GeofenceTransitionReceiver extends BroadcastReceiver implements KoinComponent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f123562h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f123563i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f123564j = GeofenceTransitionReceiver.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f123565a = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f123566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f123567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123568d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f123570g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(int i3) {
            switch (i3) {
                case 1000:
                    return "GeoFence not available";
                case AdError.NO_FILL_ERROR_CODE /* 1001 */:
                    return "Too many GeoFences";
                case 1002:
                    return "Too many pending intents";
                default:
                    return "Unknown error.";
            }
        }

        private final StreakActivityTracker c() {
            return (StreakActivityTracker) KoinJavaComponent.c(StreakActivityTracker.class, null, null, 6, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x01c1, code lost:
        
            if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.n(r1, 0, r3, 1, null) != r15) goto L60;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00d9 A[LOOP:1: B:30:0x00d3->B:32:0x00d9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0198 A[PHI: r0 r2 r4 r5
          0x0198: PHI (r0v8 boolean) = (r0v7 boolean), (r0v15 boolean) binds: [B:53:0x0195, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
          0x0198: PHI (r2v16 java.util.List) = (r2v15 java.util.List), (r2v25 java.util.List) binds: [B:53:0x0195, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
          0x0198: PHI (r4v12 cz.mobilesoft.coreblock.storage.datastore.EventDataStore) = 
          (r4v11 cz.mobilesoft.coreblock.storage.datastore.EventDataStore)
          (r4v21 cz.mobilesoft.coreblock.storage.datastore.EventDataStore)
         binds: [B:53:0x0195, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]
          0x0198: PHI (r5v12 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) = 
          (r5v11 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao)
          (r5v17 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao)
         binds: [B:53:0x0195, B:19:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object d(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r23, boolean r24, cz.mobilesoft.coreblock.storage.datastore.EventDataStore r25, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 455
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver.Companion.d(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao, boolean, cz.mobilesoft.coreblock.storage.datastore.EventDataStore, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeofenceTransitionReceiver() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123566b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123567c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123568d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f123569f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f123570g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr8, objArr9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore h() {
        return (CoreMultiProcessDataStore) this.f123566b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore i() {
        return (EventDataStore) this.f123570g.getValue();
    }

    private final GeoAddressDao j() {
        return (GeoAddressDao) this.f123567c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(int i3, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Geofence) it.next()).getRequestId());
        }
        return (i3 != 1 ? i3 != 2 ? i3 != 4 ? null : "Dwelling in " : "Exiting " : "Entering ") + TextUtils.join(", ", arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao l() {
        return (ProfileDao) this.f123568d.getValue();
    }

    private final StreakActivityTracker m() {
        return (StreakActivityTracker) this.f123569f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GeofenceTransitionReceiver geofenceTransitionReceiver, Intent intent) {
        BuildersKt__Builders_commonKt.d(geofenceTransitionReceiver.f123565a, null, null, new GeofenceTransitionReceiver$onReceive$1$1(geofenceTransitionReceiver, intent, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01c1, code lost:
    
        if (r0 == r3) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02ab, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.n(r10, 0, r13, 1, null) != r3) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065 A[PHI: r4 r5 r6 r7 r8 r9
      0x0065: PHI (r4v12 boolean) = (r4v10 boolean), (r4v13 boolean) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r5v20 java.util.List) = (r5v17 java.util.List), (r5v22 java.util.List) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r6v32 java.util.List) = (r6v29 java.util.List), (r6v34 java.util.List) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r7v19 java.util.List) = (r7v16 java.util.List), (r7v21 java.util.List) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r8v24 java.util.List) = (r8v21 java.util.List), (r8v26 java.util.List) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0065: PHI (r9v14 java.util.List) = (r9v11 java.util.List), (r9v16 java.util.List) binds: [B:58:0x0274, B:13:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012f A[LOOP:0: B:28:0x0129->B:30:0x012f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01c1 -> B:43:0x01c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(java.util.List r19, boolean r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver.o(java.util.List, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.coreblock.service.receiver.a
            @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
            public final void onInitialized() {
                GeofenceTransitionReceiver.n(this.f123779a, intent);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
