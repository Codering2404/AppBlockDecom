package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.preferences.core.PreferencesKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.dto.diagnostic.RecentNetworkErrorsDTO;
import cz.mobilesoft.coreblock.enums.AppIcon;
import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import cz.mobilesoft.coreblock.enums.PendingEmailConsentState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.SubAppUpdateDto;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.intro.OnboardingAnswersDTO;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOfferSelectionType;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.storage.datastore.entity.IntroPremiumScreenType;
import cz.mobilesoft.coreblock.storage.datastore.entity.IntroTrialToggleScreenType;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;

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
public final class CoreDataStore extends BaseDataStore {
    private final Lazy A;
    private final Lazy A0;
    private final Lazy B;
    private final Lazy B0;
    private final Lazy C;
    private final Lazy C0;
    private final Lazy D;
    private final Lazy D0;
    private final Lazy E;
    private final Lazy E0;
    private final Lazy F;
    private final Lazy F0;
    private final Lazy G;
    private final Lazy G0;
    private final Lazy H;
    private final Lazy H0;
    private final Lazy I;
    private final Lazy I0;
    private final Lazy J;
    private final Lazy J0;
    private final Lazy K;
    private final Lazy K0;
    private final Lazy L;
    private final Lazy L0;
    private final Lazy M;
    private final Lazy M0;
    private final Lazy N;
    private final Lazy N0;
    private final Lazy O;
    private final Lazy P;
    private final Lazy Q;
    private final Lazy R;
    private final Lazy S;
    private final Lazy T;
    private final Lazy U;
    private final Lazy V;
    private final Lazy W;
    private final Lazy X;
    private final Lazy Y;
    private final Lazy Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Lazy f124082a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Lazy f124083b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124084c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Lazy f124085c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124086d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Lazy f124087d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Lazy f124088e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124089f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Lazy f124090f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124091g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Lazy f124092g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124093h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Lazy f124094h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124095i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Lazy f124096i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124097j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Lazy f124098j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124099k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Lazy f124100k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124101l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final Lazy f124102l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124103m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final Lazy f124104m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124105n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Lazy f124106n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124107o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final Lazy f124108o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124109p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final Lazy f124110p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124111q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final Lazy f124112q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124113r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final Lazy f124114r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124115s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final Lazy f124116s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124117t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final Lazy f124118t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124119u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final Lazy f124120u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124121v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private final Lazy f124122v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124123w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final Lazy f124124w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f124125x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private final Lazy f124126x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f124127y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private final Lazy f124128y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f124129z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private final Lazy f124130z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreDataStore(Context context, List migrations) {
        super(context, "CORE_PREFERENCES", migrations, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        this.f124084c = m(DataStoreKeysKt.e5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.P6());
            }
        });
        this.f124086d = m(DataStoreKeysKt.f3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.i6());
            }
        });
        this.f124089f = m(DataStoreKeysKt.v(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.I1();
            }
        });
        this.f124091g = m(DataStoreKeysKt.u1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.T3();
            }
        });
        this.f124093h = m(DataStoreKeysKt.O3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.B6());
            }
        });
        this.f124095i = m(DataStoreKeysKt.k2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.O3());
            }
        });
        this.f124097j = m(DataStoreKeysKt.I(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.O1());
            }
        });
        this.f124099k = m(DataStoreKeysKt.d5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.O6());
            }
        });
        this.f124101l = m(DataStoreKeysKt.z(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.J1());
            }
        });
        this.f124103m = n(DataStoreKeysKt.S1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.Z3((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.a4();
            }
        });
        this.f124105n = m(DataStoreKeysKt.f5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.Q6());
            }
        });
        this.f124107o = n(DataStoreKeysKt.S0(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.h3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.G3((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.H3();
            }
        });
        this.f124109p = n(DataStoreKeysKt.i2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.k4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.l4();
            }
        });
        this.f124111q = m(DataStoreKeysKt.A3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.x6());
            }
        });
        this.f124113r = m(DataStoreKeysKt.f1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.P3());
            }
        });
        this.f124115s = m(DataStoreKeysKt.S3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.m4());
            }
        });
        this.f124117t = m(DataStoreKeysKt.B(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.K1();
            }
        });
        this.f124119u = m(DataStoreKeysKt.L0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.F3());
            }
        });
        this.f124121v = m(DataStoreKeysKt.e1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.N3());
            }
        });
        this.f124123w = m(DataStoreKeysKt.J3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.A6());
            }
        });
        this.f124125x = m(DataStoreKeysKt.R3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.C6());
            }
        });
        this.f124127y = m(DataStoreKeysKt.H0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.Y1();
            }
        });
        this.f124129z = m(DataStoreKeysKt.g3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.j6());
            }
        });
        this.A = m(DataStoreKeysKt.m1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.R3());
            }
        });
        this.B = m(DataStoreKeysKt.I3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.z6());
            }
        });
        this.C = m(DataStoreKeysKt.j3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.l6());
            }
        });
        this.D = m(DataStoreKeysKt.F(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.L1();
            }
        });
        this.E = n(DataStoreKeysKt.j2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.n4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.o4();
            }
        });
        this.F = m(DataStoreKeysKt.q1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.S3());
            }
        });
        this.G = m(DataStoreKeysKt.K2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.w4();
            }
        });
        this.H = m(DataStoreKeysKt.v3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.t6());
            }
        });
        this.I = m(DataStoreKeysKt.G1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreDataStore.X3());
            }
        });
        this.J = m(DataStoreKeysKt.Y2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.g6());
            }
        });
        this.K = m(DataStoreKeysKt.V(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.S1());
            }
        });
        this.L = m(DataStoreKeysKt.H3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.y6());
            }
        });
        this.M = m(DataStoreKeysKt.z1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.U3());
            }
        });
        this.N = m(DataStoreKeysKt.l2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.p4();
            }
        });
        this.O = m(DataStoreKeysKt.p3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.n6());
            }
        });
        this.P = m(DataStoreKeysKt.N2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.x4();
            }
        });
        this.Q = m(DataStoreKeysKt.w0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.T1();
            }
        });
        this.R = m(DataStoreKeysKt.a3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.h6());
            }
        });
        this.S = n(DataStoreKeysKt.z2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.q4(this.f124806a, (String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.r4();
            }
        });
        this.T = n(DataStoreKeysKt.k(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.b1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.B1(this.f124687a, (String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.C1();
            }
        });
        this.U = n(DataStoreKeysKt.I2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.u4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.v4();
            }
        });
        this.V = m(DataStoreKeysKt.J0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.Z1());
            }
        });
        this.W = n(DataStoreKeysKt.A2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.s4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.t4();
            }
        });
        this.X = m(DataStoreKeysKt.Q(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.R1());
            }
        });
        this.Y = m(DataStoreKeysKt.D0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.V1());
            }
        });
        this.Z = m(DataStoreKeysKt.E0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.W1());
            }
        });
        this.f124082a0 = m(DataStoreKeysKt.Q4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.L6());
            }
        });
        this.f124083b0 = m(DataStoreKeysKt.F0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.X1());
            }
        });
        this.f124085c0 = m(DataStoreKeysKt.G4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.I6());
            }
        });
        this.f124087d0 = m(DataStoreKeysKt.H4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.J6());
            }
        });
        this.f124088e0 = m(DataStoreKeysKt.n3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.m6());
            }
        });
        this.f124090f0 = m(DataStoreKeysKt.Z4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.N6());
            }
        });
        this.f124092g0 = n(DataStoreKeysKt.y3(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.v1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.v6((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.w6();
            }
        });
        this.f124094h0 = m(DataStoreKeysKt.z3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.u6());
            }
        });
        this.f124096i0 = n(DataStoreKeysKt.u(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.y1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.G1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.H1();
            }
        });
        this.f124098j0 = m(DataStoreKeysKt.q(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.D1());
            }
        });
        this.f124100k0 = m(DataStoreKeysKt.r(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.E1());
            }
        });
        this.f124102l0 = m(DataStoreKeysKt.s(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.F1());
            }
        });
        this.f124104m0 = n(DataStoreKeysKt.h2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.i4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.j4();
            }
        });
        this.f124106n0 = m(DataStoreKeysKt.Y4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.M6());
            }
        });
        this.f124108o0 = n(DataStoreKeysKt.K(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.i2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.P1(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreDataStore.Q1());
            }
        });
        this.f124110p0 = n(DataStoreKeysKt.F4(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.k2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.G6((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.H6();
            }
        });
        this.f124112q0 = n(DataStoreKeysKt.V1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.n2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.d4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.e4();
            }
        });
        this.f124114r0 = q(DataStoreKeysKt.y());
        this.f124116s0 = m(DataStoreKeysKt.q3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.o6());
            }
        });
        this.f124118t0 = m(DataStoreKeysKt.i3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.k6());
            }
        });
        this.f124120u0 = m(DataStoreKeysKt.A0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.U1());
            }
        });
        this.f124122v0 = m(DataStoreKeysKt.h(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.A1());
            }
        });
        this.f124124w0 = n(DataStoreKeysKt.e2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.u2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.g4(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreDataStore.h4());
            }
        });
        this.f124126x0 = m(DataStoreKeysKt.d2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.f4();
            }
        });
        this.f124128y0 = n(DataStoreKeysKt.T0(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.y2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.I3((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.J3();
            }
        });
        this.f124130z0 = m(DataStoreKeysKt.d1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.L3());
            }
        });
        this.A0 = m(DataStoreKeysKt.K1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.Y3();
            }
        });
        this.B0 = m(DataStoreKeysKt.A1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.V3();
            }
        });
        this.C0 = m(DataStoreKeysKt.t3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.r6());
            }
        });
        this.D0 = m(DataStoreKeysKt.r3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.p6());
            }
        });
        this.E0 = m(DataStoreKeysKt.u3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.s6());
            }
        });
        this.F0 = m(DataStoreKeysKt.s3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.q6());
            }
        });
        this.G0 = m(DataStoreKeysKt.T3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.D6());
            }
        });
        this.H0 = m(DataStoreKeysKt.H(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreDataStore.N1());
            }
        });
        this.I0 = m(DataStoreKeysKt.D1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.W3());
            }
        });
        this.J0 = n(DataStoreKeysKt.T1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreDataStore.b4((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.c4();
            }
        });
        this.K0 = m(DataStoreKeysKt.g(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreDataStore.z1());
            }
        });
        this.L0 = m(DataStoreKeysKt.f(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.y1());
            }
        });
        this.M0 = m(DataStoreKeysKt.j4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.E6());
            }
        });
        this.N0 = m(DataStoreKeysKt.k4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreDataStore.F6());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B1(CoreDataStore coreDataStore, String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return coreDataStore.K6(jsonString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String C1() {
        return "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C6() {
        return RunnabilityHelper.f129617a.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AutoTrialVariant G1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AutoTrialVariant.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroPremiumScreenType G3(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return IntroPremiumScreenType.Companion.a(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G6(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            if (StringsKt.p0(jsonString)) {
                return CollectionsKt.emptyList();
            }
            List list = (List) new Gson().k(jsonString, new TypeToken<List<? extends SubAppUpdateDto>>() { // from class: cz.mobilesoft.coreblock.storage.datastore.CoreDataStore$subAppViewIds$2$type$1
            }.d());
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H1() {
        return AutoTrialVariant.Off.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H3() {
        return IntroPremiumScreenType.TrialWithCloseButton.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H6() {
        return "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set I1() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroTrialToggleScreenType I3(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return IntroTrialToggleScreenType.Companion.a(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long J1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String J3() {
        return IntroTrialToggleScreenType.TrialNoToggle.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set K1() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List K6(String str) {
        try {
            List list = (List) new Gson().k(str, new TypeToken<List<? extends String>>() { // from class: cz.mobilesoft.coreblock.storage.datastore.CoreDataStore$toStringList$1
            }.d());
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set L1() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N1() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long O1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIcon P1(int i3) {
        return AppIcon.Companion.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Q1() {
        return AppIcon.Icon1.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R3() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long S3() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T3() {
        return DashboardActivity.NavBarItem.Blocking.f99175i.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long U3() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V3() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long W3() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X3() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set Y3() {
        Set DEFAULT_SINGULAR_META_ATTRIBUTION_NETWORKS = Constants.f128452j;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SINGULAR_META_ATTRIBUTION_NETWORKS, "DEFAULT_SINGULAR_META_ATTRIBUTION_NETWORKS");
        return DEFAULT_SINGULAR_META_ATTRIBUTION_NETWORKS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingAnswersDTO Z3(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            OnboardingAnswersDTO onboardingAnswersDTO = (OnboardingAnswersDTO) new Gson().j(it, OnboardingAnswersDTO.class);
            return onboardingAnswersDTO == null ? new OnboardingAnswersDTO(null, 0, 0, 0L, 0L, 31, null) : onboardingAnswersDTO;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new OnboardingAnswersDTO(null, 0, 0, 0L, 0L, 31, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a4() {
        String strS = new Gson().s(new OnboardingAnswersDTO(null, 0, 0, 0L, 0L, 31, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingFlowVariant b4(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return OnboardingFlowVariant.Companion.a(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c4() {
        return OnboardingFlowVariant.Default.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewStateV2.OnboardingVariant d4(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return OnboardingViewStateV2.OnboardingVariant.Companion.a(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e4() {
        return OnboardingViewStateV2.OnboardingVariant.NoSkip.getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f4() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingEmailConsentState g4(int i3) {
        return PendingEmailConsentState.Companion.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h4() {
        return PendingEmailConsentState.NONE.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumExpiringViewState.ScreenType i4(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumExpiringViewState.ScreenType.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j4() {
        return PremiumExpiringViewState.ScreenType.Flow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumOfferSelectionType k4(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return PremiumOfferSelectionType.Companion.a(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l4() {
        return PremiumOfferSelectionType.Selection.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m4() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumState n4(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumState.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String o4() {
        return PremiumState.None.INSTANCE.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p4() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List q4(CoreDataStore coreDataStore, String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        return coreDataStore.K6(jsonString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r4() {
        return "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List s4(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            List list = (List) new Gson().k(jsonString, new TypeToken<List<? extends RecentNetworkErrorsDTO>>() { // from class: cz.mobilesoft.coreblock.storage.datastore.CoreDataStore$recentNetworkErrors$2$type$1
            }.d());
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t4() {
        return "[]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoginAfterPurchase u4(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return LoginAfterPurchase.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v4() {
        return LoginAfterPurchase.None.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumRepositoryV2.PremiumExpiringFlowState v6(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PremiumRepositoryV2.PremiumExpiringFlowState.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String w4() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String w6() {
        return "Unset";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String x4() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x6() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z6() {
        return RunnabilityHelper.f129617a.K();
    }

    public final Flow A2() {
        return (Flow) this.f124119u.getValue();
    }

    public final Flow A3() {
        return (Flow) this.f124082a0.getValue();
    }

    public final Object A4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object A5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Y2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow B2() {
        return (Flow) this.f124107o.getValue();
    }

    public final Flow B3() {
        return (Flow) this.f124106n0.getValue();
    }

    public final Object B4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.q(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object B5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow C2() {
        return (Flow) this.f124128y0.getValue();
    }

    public final Flow C3() {
        return (Flow) this.f124090f0.getValue();
    }

    public final Object C4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.r(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object C5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow D2() {
        return (Flow) this.F.getValue();
    }

    public final Flow D3() {
        return (Flow) this.f124099k.getValue();
    }

    public final Object D4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.s(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object D5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow E2() {
        return (Flow) this.f124091g.getValue();
    }

    public final Flow E3() {
        return (Flow) this.f124105n.getValue();
    }

    public final Object E4(AutoTrialVariant autoTrialVariant, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.u(), autoTrialVariant.getId(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object E5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow F2() {
        return (Flow) this.M.getValue();
    }

    public final Object F4(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.v(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object F5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow G2() {
        return (Flow) this.B0.getValue();
    }

    public final Object G4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.y(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object G5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.n3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow H2() {
        return (Flow) this.I0.getValue();
    }

    public final Object H4(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.z(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object H5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.p3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow I2() {
        return (Flow) this.I.getValue();
    }

    public final Object I4(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.B(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object I5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.q3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow J2() {
        return (Flow) this.A0.getValue();
    }

    public final Object J4(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object J5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.r3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow K2() {
        return (Flow) this.J0.getValue();
    }

    public final Flow K3() {
        return (Flow) this.f124130z0.getValue();
    }

    public final Object K4(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object K5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.s3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow L2() {
        return (Flow) this.f124112q0.getValue();
    }

    public final Object L4(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object L5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.t3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object M1(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.k(), "[]", continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow M2() {
        return (Flow) this.f124126x0.getValue();
    }

    public final Flow M3() {
        return (Flow) this.f124121v.getValue();
    }

    public final Object M4(AppIcon appIcon, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.K(), Boxing.d(appIcon.getId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object M5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.u3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow N2() {
        return (Flow) this.f124124w0.getValue();
    }

    public final Object N4(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object N5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.v3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow O2() {
        return (Flow) this.f124104m0.getValue();
    }

    public final Object O4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object O5(PremiumRepositoryV2.PremiumExpiringFlowState premiumExpiringFlowState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.y3(), premiumExpiringFlowState.name(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow P2() {
        return (Flow) this.f124109p.getValue();
    }

    public final Object P4(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.w0(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object P5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.z3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Q2() {
        return (Flow) this.f124115s.getValue();
    }

    public final Flow Q3() {
        return (Flow) this.A.getValue();
    }

    public final Object Q4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.A0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Q5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.A3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow R2() {
        return (Flow) this.E.getValue();
    }

    public final Object R4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.D0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object R5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow S2() {
        return (Flow) this.N.getValue();
    }

    public final Object S4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object S5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow T2() {
        return (Flow) this.S.getValue();
    }

    public final Object T4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object T5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow U2() {
        return (Flow) this.W.getValue();
    }

    public final Object U4(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H0(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object U5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.O3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow V2() {
        return (Flow) this.U.getValue();
    }

    public final Object V4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object V5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.R3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow W2() {
        return (Flow) this.G.getValue();
    }

    public final Object W4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.L0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object W5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow X2() {
        return (Flow) this.P.getValue();
    }

    public final Object X4(IntroPremiumScreenType introPremiumScreenType, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S0(), introPremiumScreenType.getId(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object X5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Y2() {
        return (Flow) this.J.getValue();
    }

    public final Object Y4(IntroTrialToggleScreenType introTrialToggleScreenType, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T0(), introTrialToggleScreenType.getId(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Y5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.k4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Z2() {
        return (Flow) this.R.getValue();
    }

    public final Object Z4(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.q1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Z5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F4(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow a2() {
        return (Flow) this.L0.getValue();
    }

    public final Flow a3() {
        return (Flow) this.f124086d.getValue();
    }

    public final Object a5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.u1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object a6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f5(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow b2() {
        return (Flow) this.K0.getValue();
    }

    public final Flow b3() {
        return (Flow) this.f124129z.getValue();
    }

    public final Object b5(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.z1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object b6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow c2() {
        return (Flow) this.f124122v0.getValue();
    }

    public final Flow c3() {
        return (Flow) this.f124118t0.getValue();
    }

    public final Object c5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.A1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object c6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow d2() {
        return (Flow) this.T.getValue();
    }

    public final Flow d3() {
        return (Flow) this.C.getValue();
    }

    public final Object d5(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.D1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object d6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow e2() {
        return (Flow) this.f124098j0.getValue();
    }

    public final Flow e3() {
        return (Flow) this.f124088e0.getValue();
    }

    public final Object e5(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G1(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object e6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Y4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow f2() {
        return (Flow) this.f124100k0.getValue();
    }

    public final Flow f3() {
        return (Flow) this.O.getValue();
    }

    public final Object f5(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.K1(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object f6(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Z4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow g2() {
        return (Flow) this.f124102l0.getValue();
    }

    public final Flow g3() {
        return (Flow) this.f124116s0.getValue();
    }

    public final Object g5(OnboardingAnswersDTO onboardingAnswersDTO, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S1(), new Gson().s(onboardingAnswersDTO), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow h2() {
        return (Flow) this.f124096i0.getValue();
    }

    public final Flow h3() {
        return (Flow) this.D0.getValue();
    }

    public final Object h5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.T1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow i2() {
        return (Flow) this.f124089f.getValue();
    }

    public final Flow i3() {
        return (Flow) this.F0.getValue();
    }

    public final Object i5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow j2() {
        return (Flow) this.f124114r0.getValue();
    }

    public final Flow j3() {
        return (Flow) this.C0.getValue();
    }

    public final Object j5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.e1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow k2() {
        return (Flow) this.f124101l.getValue();
    }

    public final Flow k3() {
        return (Flow) this.E0.getValue();
    }

    public final Object k5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow l2() {
        return (Flow) this.f124117t.getValue();
    }

    public final Flow l3() {
        return (Flow) this.H.getValue();
    }

    public final Object l5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow m2() {
        return (Flow) this.D.getValue();
    }

    public final Flow m3() {
        return (Flow) this.f124092g0.getValue();
    }

    public final Object m5(PendingEmailConsentState pendingEmailConsentState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.e2(), Boxing.d(pendingEmailConsentState.ordinal()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow n2() {
        return (Flow) this.H0.getValue();
    }

    public final Flow n3() {
        return (Flow) this.f124094h0.getValue();
    }

    public final Object n5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d5(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow o2() {
        return (Flow) this.f124097j.getValue();
    }

    public final Flow o3() {
        return (Flow) this.f124111q.getValue();
    }

    public final Object o5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow p2() {
        return (Flow) this.f124108o0.getValue();
    }

    public final Flow p3() {
        return (Flow) this.L.getValue();
    }

    public final Object p5(PremiumOfferSelectionType premiumOfferSelectionType, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i2(), premiumOfferSelectionType.getId(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object q2(Continuation continuation) {
        return j(DataStoreKeysKt.U(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataStore.r2();
            }
        }, continuation);
    }

    public final Flow q3() {
        return (Flow) this.B.getValue();
    }

    public final Object q5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow r3() {
        return (Flow) this.f124123w.getValue();
    }

    public final Object r5(PremiumState premiumState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j2(), premiumState.h(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow s2() {
        return (Flow) this.K.getValue();
    }

    public final Flow s3() {
        return (Flow) this.f124093h.getValue();
    }

    public final Object s5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.k2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow t2() {
        return (Flow) this.Q.getValue();
    }

    public final Flow t3() {
        return (Flow) this.f124125x.getValue();
    }

    public final Object t5(PremiumState premiumState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.l2(), premiumState.h(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow u2() {
        return (Flow) this.f124120u0.getValue();
    }

    public final Flow u3() {
        return (Flow) this.G0.getValue();
    }

    public final Object u5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow v2() {
        return (Flow) this.Y.getValue();
    }

    public final Flow v3() {
        return (Flow) this.M0.getValue();
    }

    public final Object v5(List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.z2(), new Gson().s(list), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow w2() {
        return (Flow) this.Z.getValue();
    }

    public final Flow w3() {
        return (Flow) this.N0.getValue();
    }

    public final Object w5(List list, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.A2(), new Gson().s(list), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object x1(List list, Continuation continuation) {
        if (list.isEmpty()) {
            return Unit.f139807a;
        }
        Object objA = PreferencesKt.a(l(), new CoreDataStore$addApiErrorLogs$2(this, list, null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Flow x2() {
        return (Flow) this.f124083b0.getValue();
    }

    public final Flow x3() {
        return (Flow) this.f124110p0.getValue();
    }

    public final Object x5(LoginAfterPurchase loginAfterPurchase, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I2(), loginAfterPurchase.getValue(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow y2() {
        return (Flow) this.f124127y.getValue();
    }

    public final Flow y3() {
        return (Flow) this.f124085c0.getValue();
    }

    public final Object y4(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object y5(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.m1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow z2() {
        return (Flow) this.V.getValue();
    }

    public final Flow z3() {
        return (Flow) this.f124087d0.getValue();
    }

    public final Object z4(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object z5(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public /* synthetic */ CoreDataStore(Context context, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}
