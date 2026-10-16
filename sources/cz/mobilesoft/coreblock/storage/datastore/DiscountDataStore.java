package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.preferences.core.Preferences;
import com.google.gson.Gson;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO;
import cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellSettings;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.entity.DiscountNotificationSettings;
import cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.discount.PlacementShownTimeList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
public final class DiscountDataStore extends BaseDataStore implements KoinComponent {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124298p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124299q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124300r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124301s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124302t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124303u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124304v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124305w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f124306x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f124307y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f124308z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f124310b;

        static {
            int[] iArr = new int[RevenueCatOffering.values().length];
            try {
                iArr[RevenueCatOffering.FirstDiscount.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RevenueCatOffering.SecondDiscount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RevenueCatOffering.ExSub.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RevenueCatOffering.Campaign.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RevenueCatOffering.Referral.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RevenueCatOffering.ExitPaywall.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RevenueCatOffering.PromoTrialUpgrade.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f124309a = iArr;
            int[] iArr2 = new int[RevenueCatPlacement.values().length];
            try {
                iArr2[RevenueCatPlacement.Discount20.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[RevenueCatPlacement.Discount50.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            f124310b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DiscountDataStore(Context context) {
        super(context, "DISCOUNT", DiscountPreferencesMigrationKt.b(context), false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f124286c = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$special$$inlined$inject$default$1
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
        this.f124287d = m(DataStoreKeysKt.Y(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DiscountDataStore.n0());
            }
        });
        this.f124288f = m(DataStoreKeysKt.x0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.q0());
            }
        });
        this.f124289g = m(DataStoreKeysKt.l3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DiscountDataStore.b2());
            }
        });
        this.f124290h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.c2(this.f124695a);
            }
        });
        this.f124291i = m(DataStoreKeysKt.b0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.Z1());
            }
        });
        this.f124292j = m(DataStoreKeysKt.n0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.d2();
            }
        });
        this.f124293k = m(DataStoreKeysKt.j1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.h1());
            }
        });
        this.f124294l = m(DataStoreKeysKt.H2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.h5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.p1());
            }
        });
        this.f124295m = m(DataStoreKeysKt.d0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.j0());
            }
        });
        this.f124296n = m(DataStoreKeysKt.c0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.i0());
            }
        });
        this.f124297o = n(DataStoreKeysKt.f0(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.o5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DiscountDataStore.k0(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DiscountDataStore.l0());
            }
        });
        this.f124298p = m(DataStoreKeysKt.U4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.e2());
            }
        });
        this.f124299q = m(DataStoreKeysKt.D(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.h0());
            }
        });
        this.f124300r = n(DataStoreKeysKt.h0(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.h4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DiscountDataStore.o0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.p0();
            }
        });
        this.f124301s = m(DataStoreKeysKt.g0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.s0());
            }
        });
        this.f124302t = m(DataStoreKeysKt.i0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.r1());
            }
        });
        this.f124303u = m(DataStoreKeysKt.k1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.i1());
            }
        });
        this.f124304v = m(DataStoreKeysKt.E2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.W0());
            }
        });
        this.f124305w = m(DataStoreKeysKt.D2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.V0();
            }
        });
        this.f124306x = m(DataStoreKeysKt.j0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.k1());
            }
        });
        this.f124307y = m(DataStoreKeysKt.k3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.a2());
            }
        });
        this.f124308z = m(DataStoreKeysKt.n1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.m1());
            }
        });
        this.A = m(DataStoreKeysKt.C1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.n1());
            }
        });
        this.B = m(DataStoreKeysKt.t(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.g0());
            }
        });
        this.C = n(DataStoreKeysKt.V4(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.v4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DiscountDataStore.f2((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.g2();
            }
        });
        this.D = m(DataStoreKeysKt.J(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DiscountDataStore.m0());
            }
        });
        this.E = m(DataStoreKeysKt.E1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.o1());
            }
        });
        this.F = m(DataStoreKeysKt.c1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DiscountDataStore.f1());
            }
        });
        this.G = m(DataStoreKeysKt.t1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.K0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B0() {
        return 0;
    }

    public static /* synthetic */ Object D1(DiscountDataStore discountDataStore, String str, long j3, CurrentCampaignDTO currentCampaignDTO, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            currentCampaignDTO = null;
        }
        return discountDataStore.C1(str, j3, currentCampaignDTO, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E1() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String K0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long P0() {
        return -1L;
    }

    private final Preferences.Key Q0(RevenueCatOffering revenueCatOffering) {
        switch (WhenMappings.f124309a[revenueCatOffering.ordinal()]) {
            case 1:
                return DataStoreKeysKt.s0();
            case 2:
                return DataStoreKeysKt.t0();
            case 3:
                return DataStoreKeysKt.u0();
            case 4:
                return DataStoreKeysKt.e0();
            case 5:
                return DataStoreKeysKt.r0();
            case 6:
                return DataStoreKeysKt.p0();
            case 7:
                return DataStoreKeysKt.q0();
            default:
                return DataStoreKeysKt.o0();
        }
    }

    private final Object S0(Continuation continuation) {
        return k(DataStoreKeysKt.f2(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.q4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DiscountDataStore.T0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DiscountDataStore.U0();
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlacementShownTimeList T0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PlacementShownTimeList placementShownTimeList = (PlacementShownTimeList) new Gson().j(it, PlacementShownTimeList.class);
        return placementShownTimeList == null ? new PlacementShownTimeList(CollectionsKt.emptyList()) : placementShownTimeList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String U0() {
        return "{\"placements\":[]}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long W0() {
        return 0L;
    }

    private final Flow Z0() {
        return (Flow) this.f124291i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Z1() {
        return 24L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a2() {
        return true;
    }

    private final Flow b1() {
        return (Flow) this.f124289g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b2() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow c2(final DiscountDataStore discountDataStore) {
        final Flow flowB1 = discountDataStore.b1();
        return new Flow<Long>() { // from class: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$showDiscountForMillis_delegate$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$showDiscountForMillis_delegate$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124350a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ DiscountDataStore f124351b;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$showDiscountForMillis_delegate$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$showDiscountForMillis_delegate$lambda$0$$inlined$map$1$2", f = "DiscountDataStore.kt", l = {52, 50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124352a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124353b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124354c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124356f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124357g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124358h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    Object f124359i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    Object f124360j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    int f124361k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    int f124362l;

                    /* JADX INFO: renamed from: m, reason: collision with root package name */
                    int f124363m;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124352a = obj;
                        this.f124353b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, DiscountDataStore discountDataStore) {
                    this.f124350a = flowCollector;
                    this.f124351b = discountDataStore;
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x00fa, code lost:
                
                    if (r5.emit(r15, r0) != r1) goto L30;
                 */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 256
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$showDiscountForMillis_delegate$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowB1.collect(new AnonymousClass2(flowCollector, discountDataStore), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e2() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrialUpsellSettings f2(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            TrialUpsellSettings trialUpsellSettings = (TrialUpsellSettings) new Gson().j(jsonString, TrialUpsellSettings.class);
            return trialUpsellSettings == null ? new TrialUpsellSettings(false, 0, 0, 7, null) : trialUpsellSettings;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            System.out.println((Object) ("Error parsing TrialUpsellSettings: " + th.getMessage()));
            return new TrialUpsellSettings(false, 0, 0, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g2() {
        String strS = new Gson().s(new TrialUpsellSettings(false, 0, 0, 7, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j0() {
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CampaignSource k0(int i3) {
        return CampaignSource.Companion.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l0() {
        return CampaignSource.None.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n0() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscountNotificationSettings o0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            DiscountNotificationSettings discountNotificationSettings = (DiscountNotificationSettings) new Gson().j(it, DiscountNotificationSettings.class);
            return discountNotificationSettings == null ? new DiscountNotificationSettings(0L, 0L, 0L, null, null, null, null, null, null, 511, null) : discountNotificationSettings;
        } catch (Throwable th) {
            if (BuildConfig.f95357b.booleanValue()) {
                throw th;
            }
            CrashHelper.j(th);
            return new DiscountNotificationSettings(0L, 0L, 0L, null, null, null, null, null, null, 511, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p0() {
        String strS = new Gson().s(new DiscountNotificationSettings(0L, 0L, 0L, null, null, null, null, null, null, 511, null));
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long q0() {
        return 24L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long r1() {
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long s0() {
        return -1L;
    }

    private final Object u1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    private final Object v1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore z0() {
        return (DevDataStore) this.f124286c.getValue();
    }

    public final Object A0(Continuation continuation) {
        return j(DataStoreKeysKt.X(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DiscountDataStore.B0());
            }
        }, continuation);
    }

    public final Object A1(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h0(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object B1(RevenueCatOffering revenueCatOffering, long j3, Continuation continuation) {
        Object objS = s(Q0(revenueCatOffering), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow C0() {
        return (Flow) this.f124287d.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x01f3, code lost:
    
        if (s(r8, r9, r4) != r5) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0076 A[PHI: r1 r6 r7 r9 r10 r11
      0x0076: PHI (r1v12 long) = (r1v10 long), (r1v15 long) binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0076: PHI (r6v18 int) = (r6v16 int), (r6v20 int) binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0076: PHI (r7v9 long) = (r7v7 long), (r7v11 long) binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0076: PHI (r9v12 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO) = 
      (r9v9 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
      (r9v15 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
     binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0076: PHI (r10v8 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO) = 
      (r10v5 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
      (r10v12 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
     binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0076: PHI (r11v9 java.lang.String) = (r11v6 java.lang.String), (r11v11 java.lang.String) binds: [B:40:0x017d, B:15:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01cc A[PHI: r1 r3 r6 r7
      0x01cc: PHI (r1v18 long) = (r1v16 long), (r1v21 long) binds: [B:48:0x01c9, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01cc: PHI (r3v20 java.lang.Object) = (r3v19 java.lang.Object), (r3v1 java.lang.Object) binds: [B:48:0x01c9, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01cc: PHI (r6v26 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO) = 
      (r6v21 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
      (r6v29 cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO)
     binds: [B:48:0x01c9, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01cc: PHI (r7v15 java.lang.String) = (r7v12 java.lang.String), (r7v18 java.lang.String) binds: [B:48:0x01c9, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C1(java.lang.String r18, long r19, cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.C1(java.lang.String, long, cz.mobilesoft.coreblock.scene.premium.dto.CurrentCampaignDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow D0() {
        return (Flow) this.f124300r.getValue();
    }

    public final Object E0(RevenueCatPlacement revenueCatPlacement, Continuation continuation) {
        Preferences.Key keyW;
        final long j3;
        int i3 = WhenMappings.f124310b[revenueCatPlacement.ordinal()];
        if (i3 == 1) {
            keyW = DataStoreKeysKt.W();
            j3 = 10;
        } else {
            if (i3 != 2) {
                return Boxing.e(-1L);
            }
            keyW = DataStoreKeysKt.Z();
            j3 = 30;
        }
        return j(keyW, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.F0(j3));
            }
        }, continuation);
    }

    public final Object F1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.x0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow G0() {
        return (Flow) this.f124288f.getValue();
    }

    public final Object G1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow H0() {
        return (Flow) this.f124301s.getValue();
    }

    public final Object H1(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.t1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow I0() {
        return (Flow) this.G.getValue();
    }

    public final Object I1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.C1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow J0() {
        return (Flow) this.f124305w.getValue();
    }

    public final Object J1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object K1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow L0() {
        return (Flow) this.A.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00df, code lost:
    
        if (s(r4, r6, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L1(cz.mobilesoft.coreblock.enums.RevenueCatPlacement r9, long r10, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.L1(cz.mobilesoft.coreblock.enums.RevenueCatPlacement, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow M0() {
        return (Flow) this.E.getValue();
    }

    public final Object M1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object N0(RevenueCatOffering revenueCatOffering, Continuation continuation) {
        return j(Q0(revenueCatOffering), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DiscountDataStore.P0());
            }
        }, continuation);
    }

    public final Object N1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.k1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O0(java.lang.String r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getOfferingShownTime$3
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getOfferingShownTime$3 r0 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getOfferingShownTime$3) r0
            int r1 = r0.f124316g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124316g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getOfferingShownTime$3 r0 = new cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getOfferingShownTime$3
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124314d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124316g
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f124312b
            cz.mobilesoft.coreblock.enums.RevenueCatOffering r5 = (cz.mobilesoft.coreblock.enums.RevenueCatOffering) r5
            java.lang.Object r5 = r0.f124311a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r6)
            goto L5c
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.enums.RevenueCatOffering$Companion r6 = cz.mobilesoft.coreblock.enums.RevenueCatOffering.Companion
            cz.mobilesoft.coreblock.enums.RevenueCatOffering r6 = r6.a(r5)
            if (r6 == 0) goto L67
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124311a = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f124312b = r5
            r5 = 0
            r0.f124313c = r5
            r0.f124316g = r3
            java.lang.Object r6 = r4.N0(r6, r0)
            if (r6 != r1) goto L5c
            return r1
        L5c:
            java.lang.Number r6 = (java.lang.Number) r6
            long r5 = r6.longValue()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            return r5
        L67:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.O0(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object O1(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.D2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object P1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.E2(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Q1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.H2(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object R0(cz.mobilesoft.coreblock.enums.RevenueCatPlacement r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getPlacementShownTime$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getPlacementShownTime$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getPlacementShownTime$1) r0
            int r1 = r0.f124320d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124320d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getPlacementShownTime$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$getPlacementShownTime$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124318b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124320d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f124317a
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r5 = (cz.mobilesoft.coreblock.enums.RevenueCatPlacement) r5
            kotlin.ResultKt.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            r0.f124317a = r5
            r0.f124320d = r3
            java.lang.Object r6 = r4.S0(r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            cz.mobilesoft.coreblock.util.discount.PlacementShownTimeList r6 = (cz.mobilesoft.coreblock.util.discount.PlacementShownTimeList) r6
            java.util.List r6 = r6.getPlacements()
            r0 = 0
            if (r6 == 0) goto L7c
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L52:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6e
            java.lang.Object r1 = r6.next()
            r2 = r1
            cz.mobilesoft.coreblock.util.discount.PlacementShownTime r2 = (cz.mobilesoft.coreblock.util.discount.PlacementShownTime) r2
            java.lang.String r2 = r2.getPlacement()
            java.lang.String r3 = r5.getId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L52
            goto L6f
        L6e:
            r1 = r0
        L6f:
            cz.mobilesoft.coreblock.util.discount.PlacementShownTime r1 = (cz.mobilesoft.coreblock.util.discount.PlacementShownTime) r1
            if (r1 == 0) goto L7c
            long r5 = r1.getShownTime()
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            return r5
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.R0(cz.mobilesoft.coreblock.enums.RevenueCatPlacement, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object R1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i0(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object S1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b0(), Boxing.e(TimeUnit.HOURS.toMillis(j3)), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object T1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.k3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object U1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object V1(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.l3(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object W1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.n1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow X0() {
        return (Flow) this.f124294l.getValue();
    }

    public final Object X1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Y0() {
        return (Flow) this.f124302t.getValue();
    }

    public final Object Y1(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V4(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow a1() {
        return (Flow) this.f124307y.getValue();
    }

    public final Flow c1() {
        return (Flow) this.f124290h.getValue();
    }

    public final Flow d1() {
        return (Flow) this.C.getValue();
    }

    public final Flow e1() {
        return (Flow) this.F.getValue();
    }

    public final Flow g1() {
        return (Flow) this.f124293k.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h2(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny20PercentDiscountShown$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny20PercentDiscountShown$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny20PercentDiscountShown$1) r0
            int r1 = r0.f124369c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124369c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny20PercentDiscountShown$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny20PercentDiscountShown$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124367a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124369c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.enums.RevenueCatOffering r7 = cz.mobilesoft.coreblock.enums.RevenueCatOffering.FirstDiscount
            r0.f124369c = r3
            java.lang.Object r7 = r6.N0(r7, r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = -1
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 == 0) goto L4c
            goto L4d
        L4c:
            r3 = 0
        L4d:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.h2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i2(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny50PercentDiscountShown$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny50PercentDiscountShown$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny50PercentDiscountShown$1) r0
            int r1 = r0.f124373d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124373d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny50PercentDiscountShown$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$wasAny50PercentDiscountShown$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f124371b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124373d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f124370a
            java.util.Set r0 = (java.util.Set) r0
            kotlin.ResultKt.b(r8)
            goto L5e
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.b(r8)
            androidx.datastore.preferences.core.Preferences$Key r8 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.t0()
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.e0()
            androidx.datastore.preferences.core.Preferences$Key[] r8 = new androidx.datastore.preferences.core.Preferences.Key[]{r8, r2}
            java.util.Set r8 = kotlin.collections.SetsKt.setOf(r8)
            androidx.datastore.core.DataStore r2 = r7.l()
            kotlinx.coroutines.flow.Flow r2 = r2.getData()
            r0.f124370a = r8
            r0.f124373d = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L5b
            return r1
        L5b:
            r6 = r0
            r0 = r8
            r8 = r6
        L5e:
            androidx.datastore.preferences.core.Preferences r8 = (androidx.datastore.preferences.core.Preferences) r8
            java.util.Map r8 = r8.a()
            boolean r1 = r8.isEmpty()
            r2 = 0
            if (r1 == 0) goto L6d
        L6b:
            r3 = r2
            goto L9e
        L6d:
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L75:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L6b
            java.lang.Object r1 = r8.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Object r5 = r1.getKey()
            boolean r4 = kotlin.collections.CollectionsKt.contains(r4, r5)
            if (r4 == 0) goto L75
            java.lang.Object r1 = r1.getValue()
            r4 = -1
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.e(r4)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 != 0) goto L75
        L9e:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.i2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow j1() {
        return (Flow) this.f124306x.getValue();
    }

    public final Flow l1() {
        return (Flow) this.f124308z.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x020d, code lost:
    
        if (r0.R1(r3, r2) != r8) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0188 A[PHI: r0 r2 r3
      0x0188: PHI (r0v14 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v13 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:46:0x0184, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r2v12 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v11 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:46:0x0184, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r3v9 long) = (r3v7 long), (r3v10 long) binds: [B:46:0x0184, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0195 A[PHI: r0 r2 r3
      0x0195: PHI (r0v15 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v14 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:49:0x0191, B:19:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0195: PHI (r2v13 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v12 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:49:0x0191, B:19:0x0063] A[DONT_GENERATE, DONT_INLINE]
      0x0195: PHI (r3v11 long) = (r3v9 long), (r3v12 long) binds: [B:49:0x0191, B:19:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a2 A[PHI: r0 r2 r3
      0x01a2: PHI (r0v16 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v15 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:52:0x019e, B:18:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x01a2: PHI (r2v14 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v13 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:52:0x019e, B:18:0x005c] A[DONT_GENERATE, DONT_INLINE]
      0x01a2: PHI (r3v13 long) = (r3v11 long), (r3v14 long) binds: [B:52:0x019e, B:18:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b7 A[PHI: r0 r2 r3
      0x01b7: PHI (r0v17 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v16 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:55:0x01b4, B:17:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r2v15 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v14 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:55:0x01b4, B:17:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r3v15 long) = (r3v13 long), (r3v16 long) binds: [B:55:0x01b4, B:17:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01cc A[PHI: r0 r2 r3
      0x01cc: PHI (r0v18 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v17 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:58:0x01c9, B:16:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x01cc: PHI (r2v16 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v15 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:58:0x01c9, B:16:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x01cc: PHI (r3v17 long) = (r3v15 long), (r3v18 long) binds: [B:58:0x01c9, B:16:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e1 A[PHI: r0 r2 r3
      0x01e1: PHI (r0v19 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v18 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:61:0x01de, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r2v17 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v16 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:61:0x01de, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x01e1: PHI (r3v19 long) = (r3v17 long), (r3v20 long) binds: [B:61:0x01de, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f6 A[PHI: r0 r2 r3
      0x01f6: PHI (r0v20 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v19 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:64:0x01f3, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x01f6: PHI (r2v18 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v17 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:64:0x01f3, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x01f6: PHI (r3v21 long) = (r3v19 long), (r3v22 long) binds: [B:64:0x01f3, B:14:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0203 A[PHI: r0 r2 r3
      0x0203: PHI (r0v21 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore) = 
      (r0v20 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
      (r0v0 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore)
     binds: [B:67:0x0200, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0203: PHI (r2v19 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1) = 
      (r2v18 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
      (r2v2 cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore$resetAllDiscountOffersForTesting$1)
     binds: [B:67:0x0200, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0203: PHI (r3v23 long) = (r3v21 long), (r3v24 long) binds: [B:67:0x0200, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0101 -> B:31:0x0107). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q1(kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.q1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final Object s1(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.t(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow t0() {
        return (Flow) this.B.getValue();
    }

    public final Object t1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.D(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow u0() {
        return (Flow) this.f124299q.getValue();
    }

    public final Flow v0() {
        return (Flow) this.f124296n.getValue();
    }

    public final Flow w0() {
        return (Flow) this.f124295m.getValue();
    }

    public final Object w1(CampaignSource campaignSource, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f0(), Boxing.d(campaignSource.getId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow x0() {
        return (Flow) this.f124297o.getValue();
    }

    public final Object x1(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow y0() {
        return (Flow) this.D.getValue();
    }

    public final Object y1(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.W(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object z1(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Y(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long F0(long j3) {
        return j3;
    }
}
