package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import com.google.gson.Gson;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.dto.events.AdsConsentEventDTO;
import cz.mobilesoft.coreblock.dto.events.EventWithIdsDTO;
import cz.mobilesoft.coreblock.dto.events.EventWithPackageDTO;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class EventDataStore extends BaseDataStore {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private final Lazy J;
    private final Lazy K;
    private final Lazy L;
    private final Lazy M;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124375d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124388r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124389s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124390t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124391u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f124394x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f124395y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f124396z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDataStore(Context context) {
        super(context, "EVENTS", null, true, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124374c = m(DataStoreKeysKt.V2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(EventDataStore.u2());
            }
        });
        this.f124375d = n(DataStoreKeysKt.X4(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.t5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.x2(this.f124805a, (String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.y2();
            }
        });
        this.f124376f = m(DataStoreKeysKt.W2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.v2();
            }
        });
        this.f124377g = n(DataStoreKeysKt.M2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.v6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.H1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.I1();
            }
        });
        this.f124378h = n(DataStoreKeysKt.L2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.x6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.F1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.G1();
            }
        });
        this.f124379i = m(DataStoreKeysKt.C2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.C1();
            }
        });
        this.f124380j = m(DataStoreKeysKt.g2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(EventDataStore.z1());
            }
        });
        this.f124381k = n(DataStoreKeysKt.W1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.c6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.v1(this.f124690a, (String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.w1();
            }
        });
        this.f124382l = m(DataStoreKeysKt.I1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.u1());
            }
        });
        this.f124383m = n(DataStoreKeysKt.R0(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.c7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.o1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.p1();
            }
        });
        this.f124384n = m(DataStoreKeysKt.G0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.D0());
            }
        });
        this.f124385o = n(DataStoreKeysKt.G(), new EventDataStore$collapseFloatingWindowRequestedEvent$2(this), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.z0();
            }
        });
        this.f124386p = n(DataStoreKeysKt.v0(), new EventDataStore$dismissPipRequestedEvent$2(this), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.C0();
            }
        });
        this.f124387q = n(DataStoreKeysKt.b2(), new EventDataStore$pauseMediaPlaybackRequestedEvent$2(this), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.y1();
            }
        });
        this.f124388r = m(DataStoreKeysKt.K0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.n1());
            }
        });
        this.f124389s = m(DataStoreKeysKt.S(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.A0());
            }
        });
        this.f124390t = m(DataStoreKeysKt.C(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.x0());
            }
        });
        this.f124391u = m(DataStoreKeysKt.o(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.u0());
            }
        });
        this.f124392v = m(DataStoreKeysKt.l(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.t0());
            }
        });
        this.f124393w = m(DataStoreKeysKt.T(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.B0());
            }
        });
        this.f124394x = m(DataStoreKeysKt.E(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.y0());
            }
        });
        this.f124395y = m(DataStoreKeysKt.b(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.m0());
            }
        });
        this.f124396z = m(DataStoreKeysKt.a(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.l0());
            }
        });
        this.A = m(DataStoreKeysKt.c(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.n0());
            }
        });
        this.B = n(DataStoreKeysKt.e(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.e6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.q0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.s0();
            }
        });
        this.C = m(DataStoreKeysKt.h5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.z2());
            }
        });
        this.D = m(DataStoreKeysKt.A(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.w0());
            }
        });
        this.E = m(DataStoreKeysKt.E4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.w2());
            }
        });
        this.F = m(DataStoreKeysKt.n2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.A1());
            }
        });
        this.G = m(DataStoreKeysKt.p(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.v0());
            }
        });
        this.H = m(DataStoreKeysKt.T2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(EventDataStore.J1());
            }
        });
        this.I = n(DataStoreKeysKt.d(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.o6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventDataStore.o0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventDataStore.p0();
            }
        });
        this.J = m(DataStoreKeysKt.y2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(EventDataStore.B1());
            }
        });
        this.K = m(DataStoreKeysKt.l1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(EventDataStore.r1());
            }
        });
        this.L = m(DataStoreKeysKt.H1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.t1());
            }
        });
        this.M = m(DataStoreKeysKt.x1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EventDataStore.s1());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long B0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C0() {
        String strS = new Gson().s(new EventWithPackageDTO(0L, null, 3, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long D0() {
        return 0L;
    }

    private final void D1() {
        CoroutinesHelperExtKt.d(new EventDataStore$resetOverlayServiceStarted$1(this, null));
    }

    private final void E1() {
        CoroutinesHelperExtKt.d(new EventDataStore$resetUsageLimitHost$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventWithIdsDTO F1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            EventWithIdsDTO eventWithIdsDTO = (EventWithIdsDTO) new Gson().j(it, EventWithIdsDTO.class);
            return eventWithIdsDTO == null ? new EventWithIdsDTO(0L, CollectionsKt.emptyList()) : eventWithIdsDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new EventWithIdsDTO(0L, CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String G1() {
        String strS = new Gson().s(new EventWithIdsDTO(0L, CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventWithIdsDTO H1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            EventWithIdsDTO eventWithIdsDTO = (EventWithIdsDTO) new Gson().j(it, EventWithIdsDTO.class);
            return eventWithIdsDTO == null ? new EventWithIdsDTO(0L, CollectionsKt.emptyList()) : eventWithIdsDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new EventWithIdsDTO(0L, CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String I1() {
        String strS = new Gson().s(new EventWithIdsDTO(0L, CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventWithIdsDTO o0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            return (EventWithIdsDTO) new Gson().j(it, EventWithIdsDTO.class);
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventWithIdsDTO o1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            EventWithIdsDTO eventWithIdsDTO = (EventWithIdsDTO) new Gson().j(it, EventWithIdsDTO.class);
            return eventWithIdsDTO == null ? new EventWithIdsDTO(0L, CollectionsKt.emptyList()) : eventWithIdsDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new EventWithIdsDTO(0L, CollectionsKt.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p1() {
        String strS = new Gson().s(new EventWithIdsDTO(0L, CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdsConsentEventDTO q0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            AdsConsentEventDTO adsConsentEventDTO = (AdsConsentEventDTO) new Gson().j(it, AdsConsentEventDTO.class);
            return adsConsentEventDTO == null ? new AdsConsentEventDTO(null, null, null, 7, null) : adsConsentEventDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new AdsConsentEventDTO(null, null, null, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s0() {
        String strS = new Gson().s(new AdsConsentEventDTO(null, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long s1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long t0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long t1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long u0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long u1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageAdditionalBlockingDTO v1(EventDataStore eventDataStore, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = (PackageAdditionalBlockingDTO) new Gson().j(it, PackageAdditionalBlockingDTO.class);
            return packageAdditionalBlockingDTO == null ? new PackageAdditionalBlockingDTO(null, null, null, 7, null) : packageAdditionalBlockingDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            eventDataStore.D1();
            return new PackageAdditionalBlockingDTO(null, null, null, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String w1() {
        String strS = new Gson().s(new PackageAdditionalBlockingDTO(null, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w2() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long x0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventWithPackageDTO x1(String str) {
        try {
            EventWithPackageDTO eventWithPackageDTO = (EventWithPackageDTO) new Gson().j(str, EventWithPackageDTO.class);
            return eventWithPackageDTO == null ? new EventWithPackageDTO(0L, null, 3, null) : eventWithPackageDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new EventWithPackageDTO(0L, null, 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageAdditionalBlockingDTO x2(EventDataStore eventDataStore, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = (PackageAdditionalBlockingDTO) new Gson().j(it, PackageAdditionalBlockingDTO.class);
            return packageAdditionalBlockingDTO == null ? new PackageAdditionalBlockingDTO(null, null, null, 7, null) : packageAdditionalBlockingDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            eventDataStore.E1();
            return new PackageAdditionalBlockingDTO(null, null, null, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y1() {
        String strS = new Gson().s(new EventWithPackageDTO(0L, null, 3, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y2() {
        String strS = new Gson().s(new PackageAdditionalBlockingDTO(null, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z2() {
        return 0L;
    }

    public final Flow E0() {
        return (Flow) this.f124396z.getValue();
    }

    public final Flow F0() {
        return (Flow) this.f124395y.getValue();
    }

    public final Flow G0() {
        return (Flow) this.A.getValue();
    }

    public final Flow H0() {
        return (Flow) this.I.getValue();
    }

    public final Flow I0() {
        return (Flow) this.B.getValue();
    }

    public final Flow J0() {
        return (Flow) this.f124392v.getValue();
    }

    public final Flow K0() {
        return (Flow) this.f124391u.getValue();
    }

    public final Object K1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow L0() {
        return (Flow) this.G.getValue();
    }

    public final Object L1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow M0() {
        return (Flow) this.D.getValue();
    }

    public final Object M1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow N0() {
        return (Flow) this.f124390t.getValue();
    }

    public final Object N1(long j3, List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d(), new Gson().s(new EventWithIdsDTO(j3, list)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow O0() {
        return (Flow) this.f124394x.getValue();
    }

    public final Object O1(AdsConsentEventDTO adsConsentEventDTO, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.e(), new Gson().s(adsConsentEventDTO), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow P0() {
        return (Flow) this.f124385o.getValue();
    }

    public final Object P1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.l(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Q0() {
        return (Flow) this.f124389s.getValue();
    }

    public final Object Q1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.o(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow R0() {
        return (Flow) this.f124393w.getValue();
    }

    public final Object R1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.p(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow S0() {
        return (Flow) this.f124386p.getValue();
    }

    public final Object S1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.A(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow T0() {
        return (Flow) this.f124384n.getValue();
    }

    public final Object T1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.C(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow U0() {
        return (Flow) this.f124388r.getValue();
    }

    public final Object U1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow V0() {
        return (Flow) this.f124383m.getValue();
    }

    public final Object V1(long j3, String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G(), new Gson().s(new EventWithPackageDTO(j3, str)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow W0() {
        return (Flow) this.M.getValue();
    }

    public final Object W1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow X0() {
        return (Flow) this.L.getValue();
    }

    public final Object X1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Y0() {
        return (Flow) this.f124382l.getValue();
    }

    public final Object Y1(long j3, String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.v0(), new Gson().s(new EventWithPackageDTO(j3, str)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Z0() {
        return (Flow) this.f124381k.getValue();
    }

    public final Object Z1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow a1() {
        return (Flow) this.f124387q.getValue();
    }

    public final Object a2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.K0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow b1() {
        return (Flow) this.f124380j.getValue();
    }

    public final Object b2(long j3, List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.R0(), new Gson().s(new EventWithIdsDTO(j3, list)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow c1() {
        return (Flow) this.F.getValue();
    }

    public final Object c2(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.l1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow d1() {
        return (Flow) this.J.getValue();
    }

    public final Object d2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.x1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow e1() {
        return (Flow) this.f124379i.getValue();
    }

    public final Object e2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow f1() {
        return (Flow) this.f124378h.getValue();
    }

    public final Object f2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow g1() {
        return (Flow) this.f124377g.getValue();
    }

    public final Object g2(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.W1(), new Gson().s(packageAdditionalBlockingDTO), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow h1() {
        return (Flow) this.H.getValue();
    }

    public final Object h2(long j3, String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b2(), new Gson().s(new EventWithPackageDTO(j3, str)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow i1() {
        return (Flow) this.f124374c.getValue();
    }

    public final Object i2(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow j1() {
        return (Flow) this.f124376f.getValue();
    }

    public final Object j2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.n2(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow k1() {
        return (Flow) this.E.getValue();
    }

    public final Object k2(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.y2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow l1() {
        return (Flow) this.f124375d.getValue();
    }

    public final Object l2(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.C2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow m1() {
        return (Flow) this.C.getValue();
    }

    public final Object m2(long j3, List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.L2(), new Gson().s(new EventWithIdsDTO(j3, list)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object n2(long j3, List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.M2(), new Gson().s(new EventWithIdsDTO(j3, list)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object o2(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object p2(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow q1() {
        return (Flow) this.K.getValue();
    }

    public final Object q2(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.W2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object r2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E4(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object s2(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.X4(), new Gson().s(packageAdditionalBlockingDTO), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object t2(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h5(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z0() {
        String strS = new Gson().s(new EventWithPackageDTO(0L, null, 3, null));
        Intrinsics.checkNotNullExpressionValue(strS, vgWWUoTKYyuC.LJzddfDXPYSNBhn);
        return strS;
    }
}
