package cz.mobilesoft.coreblock.util.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
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
public final class LocationCheckHelper implements KoinComponent {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static LocationCheckHelper f128778q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f128780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FusedLocationProviderClient f128781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f128782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Job f128783d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f128784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f128785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f128786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f128787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f128788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f128789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f128790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f128791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f128775n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f128776o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f128777p = LocationCheckHelper.class.getSimpleName();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Mutex f128779r = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.location.LocationCheckHelper$1", f = "LocationCheckHelper.kt", l = {89, 90, 96, 99, 100}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f128792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f128793b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LocationCheckHelper.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        
            if (cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.b(r10, false, r9, 1, null) == r0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
        
            if (cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.b(r10, false, r9, 1, null) == r0) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Object b(Companion companion, boolean z2, Continuation continuation, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = true;
            }
            return companion.a(z2, continuation);
        }

        public static /* synthetic */ Object f(Companion companion, Context context, boolean z2, Continuation continuation, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z2 = false;
            }
            return companion.e(context, z2, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(boolean r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$finish$1
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$finish$1 r0 = (cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$finish$1) r0
                int r1 = r0.f128800g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f128800g = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$finish$1 r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$finish$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f128798d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f128800g
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L39
                if (r2 != r4) goto L31
                boolean r7 = r0.f128795a
                java.lang.Object r0 = r0.f128796b
                kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
                kotlin.ResultKt.b(r8)
                goto L50
            L31:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L39:
                kotlin.ResultKt.b(r8)
                kotlinx.coroutines.sync.Mutex r8 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.g()
                r0.f128796b = r8
                r0.f128795a = r7
                r0.f128797c = r3
                r0.f128800g = r4
                java.lang.Object r0 = r8.f(r5, r0)
                if (r0 != r1) goto L4f
                return r1
            L4f:
                r0 = r8
            L50:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper r8 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.d()     // Catch: java.lang.Throwable -> L67
                if (r8 == 0) goto L69
                java.lang.String r1 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.j()     // Catch: java.lang.Throwable -> L67
                java.lang.String r2 = "Stopping"
                android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L67
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper.n(r8, r7)     // Catch: java.lang.Throwable -> L67
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper.l(r5)     // Catch: java.lang.Throwable -> L67
                r3 = r4
                goto L69
            L67:
                r7 = move-exception
                goto L71
            L69:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)     // Catch: java.lang.Throwable -> L67
                r0.i(r5)
                return r7
            L71:
                r0.i(r5)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.a(boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final void c() {
            BuildersKt__Builders_commonKt.d(CoroutinesHelperExtKt.a(Dispatchers.b()), null, null, new LocationCheckHelper$Companion$finishAsync$1(null), 3, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object d(android.content.Context r7, boolean r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$restartLocationCheck$1
                if (r0 == 0) goto L13
                r0 = r9
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$restartLocationCheck$1 r0 = (cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$restartLocationCheck$1) r0
                int r1 = r0.f128808h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f128808h = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$restartLocationCheck$1 r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$restartLocationCheck$1
                r0.<init>(r6, r9)
            L18:
                java.lang.Object r9 = r0.f128806f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f128808h
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L3f
                if (r2 != r4) goto L37
                boolean r8 = r0.f128804c
                java.lang.Object r7 = r0.f128803b
                kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
                java.lang.Object r0 = r0.f128802a
                android.content.Context r0 = (android.content.Context) r0
                kotlin.ResultKt.b(r9)
                r9 = r7
                r7 = r0
                goto L57
            L37:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3f:
                kotlin.ResultKt.b(r9)
                kotlinx.coroutines.sync.Mutex r9 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.g()
                r0.f128802a = r7
                r0.f128803b = r9
                r0.f128804c = r8
                r0.f128805d = r3
                r0.f128808h = r4
                java.lang.Object r0 = r9.f(r5, r0)
                if (r0 != r1) goto L57
                return r1
            L57:
                boolean r0 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.j(r7)     // Catch: java.lang.Throwable -> L68
                if (r0 != 0) goto L5e
                goto L73
            L5e:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper r0 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.d()     // Catch: java.lang.Throwable -> L68
                if (r0 == 0) goto L6a
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper.A(r0, r3, r4, r5)     // Catch: java.lang.Throwable -> L68
                goto L6a
            L68:
                r7 = move-exception
                goto L7b
            L6a:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper     // Catch: java.lang.Throwable -> L68
                r0.<init>(r7, r8, r5)     // Catch: java.lang.Throwable -> L68
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper.l(r0)     // Catch: java.lang.Throwable -> L68
                r3 = r4
            L73:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)     // Catch: java.lang.Throwable -> L68
                r9.i(r5)
                return r7
            L7b:
                r9.i(r5)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.d(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object e(android.content.Context r7, boolean r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$startLocationCheck$1
                if (r0 == 0) goto L13
                r0 = r9
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$startLocationCheck$1 r0 = (cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$startLocationCheck$1) r0
                int r1 = r0.f128815h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f128815h = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$startLocationCheck$1 r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper$Companion$startLocationCheck$1
                r0.<init>(r6, r9)
            L18:
                java.lang.Object r9 = r0.f128813f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f128815h
                r3 = 0
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L3f
                if (r2 != r4) goto L37
                boolean r8 = r0.f128811c
                java.lang.Object r7 = r0.f128810b
                kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
                java.lang.Object r0 = r0.f128809a
                android.content.Context r0 = (android.content.Context) r0
                kotlin.ResultKt.b(r9)
                r9 = r7
                r7 = r0
                goto L57
            L37:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3f:
                kotlin.ResultKt.b(r9)
                kotlinx.coroutines.sync.Mutex r9 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.g()
                r0.f128809a = r7
                r0.f128810b = r9
                r0.f128811c = r8
                r0.f128812d = r3
                r0.f128815h = r4
                java.lang.Object r0 = r9.f(r5, r0)
                if (r0 != r1) goto L57
                return r1
            L57:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper r0 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.d()     // Catch: java.lang.Throwable -> L6e
                if (r0 != 0) goto L70
                boolean r0 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.j(r7)     // Catch: java.lang.Throwable -> L6e
                if (r0 != 0) goto L64
                goto L70
            L64:
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper     // Catch: java.lang.Throwable -> L6e
                r0.<init>(r7, r8, r5)     // Catch: java.lang.Throwable -> L6e
                cz.mobilesoft.coreblock.util.location.LocationCheckHelper.l(r0)     // Catch: java.lang.Throwable -> L6e
                r3 = r4
                goto L79
            L6e:
                r7 = move-exception
                goto L81
            L70:
                java.lang.String r7 = cz.mobilesoft.coreblock.util.location.LocationCheckHelper.j()     // Catch: java.lang.Throwable -> L6e
                java.lang.String r8 = "Start skipped, already running or missing permissions"
                android.util.Log.d(r7, r8)     // Catch: java.lang.Throwable -> L6e
            L79:
                java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)     // Catch: java.lang.Throwable -> L6e
                r9.i(r5)
                return r7
            L81:
                r9.i(r5)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.Companion.e(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    public /* synthetic */ LocationCheckHelper(Context context, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z2);
    }

    static /* synthetic */ void A(LocationCheckHelper locationCheckHelper, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        locationCheckHelper.z(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x04c8, code lost:
    
        if (cz.mobilesoft.coreblock.scene.streaks.StreakActivityTracker.n(r6, 0, r6, 1, null) == r1) goto L125;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x042a A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0487 A[Catch: Exception -> 0x0086, TRY_LEAVE, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0165 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0173 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c9 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d7 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020a A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0273 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0296 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c8 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:19:0x007f, B:121:0x047e, B:123:0x0487, B:24:0x00af, B:116:0x042a, B:117:0x042d, B:27:0x00da, B:110:0x03d3, B:30:0x0113, B:69:0x0256, B:71:0x0273, B:73:0x027e, B:59:0x0204, B:61:0x020a, B:66:0x0228, B:80:0x02bc, B:82:0x02c8, B:83:0x02d5, B:85:0x02db, B:87:0x02ee, B:89:0x02f8, B:90:0x0304, B:91:0x030a, B:93:0x0310, B:95:0x0325, B:97:0x032b, B:103:0x0340, B:105:0x035f, B:106:0x0362, B:74:0x028a, B:75:0x0296, B:77:0x02a1, B:78:0x02ad, B:33:0x012b, B:54:0x01c1, B:56:0x01c9, B:58:0x01d7, B:36:0x0136, B:42:0x015c, B:44:0x0165, B:46:0x0173, B:47:0x0181, B:49:0x0187, B:50:0x01a1, B:39:0x0144), top: B:130:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0252 -> B:69:0x0256). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(android.location.Location r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.o(android.location.Location, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final EventDataStore p() {
        return (EventDataStore) this.f128789k.getValue();
    }

    private final GeoAddressDao q() {
        return (GeoAddressDao) this.f128786h.getValue();
    }

    private final LocationCallback r() {
        return (LocationCallback) this.f128791m.getValue();
    }

    private final LocationRequest s() {
        return (LocationRequest) this.f128790l.getValue();
    }

    private final ProfileDao t() {
        return (ProfileDao) this.f128787i.getValue();
    }

    private final StreakActivityTracker u() {
        return (StreakActivityTracker) this.f128788j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
    
        if (r10 == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.util.location.LocationCheckHelper$hasLocationGeofences$1
            if (r0 == 0) goto L14
            r0 = r10
            cz.mobilesoft.coreblock.util.location.LocationCheckHelper$hasLocationGeofences$1 r0 = (cz.mobilesoft.coreblock.util.location.LocationCheckHelper$hasLocationGeofences$1) r0
            int r1 = r0.f128835d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f128835d = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.util.location.LocationCheckHelper$hasLocationGeofences$1 r0 = new cz.mobilesoft.coreblock.util.location.LocationCheckHelper$hasLocationGeofences$1
            r0.<init>(r9, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.f128833b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f128835d
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L3e
            if (r1 == r8) goto L3a
            if (r1 != r7) goto L32
            java.lang.Object r0 = r4.f128832a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r10)
            goto L9e
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3a:
            kotlin.ResultKt.b(r10)
            goto L53
        L3e:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r1 = r9.t()
            cz.mobilesoft.coreblock.enums.ProfileType r2 = cz.mobilesoft.coreblock.enums.ProfileType.LOCATION
            r4.f128835d = r8
            r3 = 0
            r5 = 2
            r6 = 0
            java.lang.Object r10 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.u0(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L53
            goto L9d
        L53:
            java.util.List r10 = (java.util.List) r10
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L61
            r10 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r10)
            return r10
        L61:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao r1 = r9.q()
            r2 = r10
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r3.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L77:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L8f
            java.lang.Object r5 = r2.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r5
            long r5 = r5.r()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            r3.add(r5)
            goto L77
        L8f:
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r4.f128832a = r10
            r4.f128835d = r7
            java.lang.Object r10 = r1.M(r3, r4)
            if (r10 != r0) goto L9e
        L9d:
            return r0
        L9e:
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r8
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.LocationCheckHelper.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [cz.mobilesoft.coreblock.util.location.LocationCheckHelper$locationCallback$2$1] */
    public static final LocationCheckHelper$locationCallback$2$1 w(final LocationCheckHelper locationCheckHelper) {
        return new LocationCallback() { // from class: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$locationCallback$2$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                super.onLocationResult(locationResult);
                Location locationM = locationResult.M();
                if (locationM != null) {
                    LocationCheckHelper locationCheckHelper2 = this.f128836a;
                    BuildersKt__Builders_commonKt.d(locationCheckHelper2.f128782c, null, null, new LocationCheckHelper$locationCallback$2$1$onLocationResult$1$1(locationCheckHelper2, locationM, null), 3, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationRequest x() {
        LocationRequest locationRequestP2 = LocationRequest.M().R2(100).Q2(180000L).P2(30000L);
        Intrinsics.checkNotNullExpressionValue(locationRequestP2, "setFastestInterval(...)");
        return locationRequestP2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        if (this.f128785g) {
            Log.d(f128777p, "Start location updates skipped, helper already stopped");
            return;
        }
        Log.d(f128777p, "Starting location updates");
        Job job = this.f128783d;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f128783d = BuildersKt__Builders_commonKt.d(this.f128782c, null, null, new LocationCheckHelper$startLocationUpdates$1(null), 3, null);
        this.f128784f = true;
        this.f128781b.requestLocationUpdates(s(), r(), Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean z2) {
        Job job;
        this.f128785g = true;
        if (z2 && (job = this.f128783d) != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f128783d = null;
        if (this.f128784f) {
            this.f128781b.removeLocationUpdates(r());
            this.f128784f = false;
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LocationCheckHelper(Context context, boolean z2) {
        this.f128780a = z2;
        FusedLocationProviderClient fusedLocationProviderClientA = LocationServices.a(context);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClientA, "getFusedLocationProviderClient(...)");
        this.f128781b = fusedLocationProviderClientA;
        CoroutineScope coroutineScopeA = CoroutinesHelperExtKt.a(Dispatchers.b());
        this.f128782c = coroutineScopeA;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f128786h = LazyKt.a(lazyThreadSafetyModeB, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f128787i = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f128788j = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StreakActivityTracker>() { // from class: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakActivityTracker.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f128789k = LazyKt.a(lazyThreadSafetyModeB4, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.location.LocationCheckHelper$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr6, objArr7);
            }
        });
        this.f128790l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.location.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LocationCheckHelper.x();
            }
        });
        this.f128791m = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.location.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LocationCheckHelper.w(this.f128856a);
            }
        });
        Log.d(f128777p, "Starting...");
        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(null), 3, null);
    }
}
