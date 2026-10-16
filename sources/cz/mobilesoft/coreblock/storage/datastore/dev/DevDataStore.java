package cz.mobilesoft.coreblock.storage.datastore.dev;

import android.content.Context;
import androidx.datastore.preferences.core.Preferences;
import com.google.gson.Gson;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.storage.datastore.BaseDataStore;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class DevDataStore extends BaseDataStore {
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
    private final Lazy N;
    private final Lazy O;
    private final Lazy P;
    private final Lazy Q;
    private final Lazy R;
    private final Lazy S;
    private final Lazy T;
    private final Lazy U;
    private final Lazy V;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124697d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Flow f124703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124710r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124711s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124712t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124713u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124714v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124715w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f124716x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f124717y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f124718z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevDataStore(Context context) {
        super(context, "DEVELOPER", CollectionsKt.listOf(DevPreferencesMigrationKt.a(context)), true);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124696c = n(DevDataStoreKeysKt.v(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevDataStore.I1(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DevDataStore.J1());
            }
        });
        this.f124697d = n(DevDataStoreKeysKt.u(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevDataStore.G1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.H1();
            }
        });
        this.f124698f = m(DevDataStoreKeysKt.N(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(DevDataStore.I2());
            }
        });
        this.f124699g = m(DevDataStoreKeysKt.S(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.M2());
            }
        });
        this.f124700h = m(DevDataStoreKeysKt.E(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.D2());
            }
        });
        this.f124701i = m(DevDataStoreKeysKt.o(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.A1());
            }
        });
        this.f124702j = m(DevDataStoreKeysKt.w(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.L1();
            }
        });
        final Flow flowQ0 = Q0();
        this.f124703k = new Flow<QuestionnaireConfig>() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124734a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2", f = "DevDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124735a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124736b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124737c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124739f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124740g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124741h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124742i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124735a = obj;
                        this.f124736b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f124734a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124736b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124736b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124735a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124736b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124741h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124739f
                        cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L78
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124734a
                        r2 = r7
                        java.lang.String r2 = (java.lang.String) r2
                        com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L4f
                        r4.<init>()     // Catch: java.lang.Exception -> L4f
                        java.lang.Class<cz.mobilesoft.coreblock.dto.QuestionnaireConfig> r5 = cz.mobilesoft.coreblock.dto.QuestionnaireConfig.class
                        java.lang.Object r2 = r4.j(r2, r5)     // Catch: java.lang.Exception -> L4f
                        cz.mobilesoft.coreblock.dto.QuestionnaireConfig r2 = (cz.mobilesoft.coreblock.dto.QuestionnaireConfig) r2     // Catch: java.lang.Exception -> L4f
                        goto L54
                    L4f:
                        r2 = move-exception
                        r2.printStackTrace()
                        r2 = 0
                    L54:
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124737c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124739f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124740g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124741h = r7
                        r7 = 0
                        r0.f124742i = r7
                        r0.f124736b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L78
                        return r1
                    L78:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowQ0.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        this.f124704l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.K1(this.f124769a);
            }
        });
        this.f124705m = m0(DevDataStoreKeysKt.D());
        this.f124706n = m0(DevDataStoreKeysKt.T());
        this.f124707o = m0(DevDataStoreKeysKt.A());
        this.f124708p = m0(DevDataStoreKeysKt.C());
        this.f124709q = m0(DevDataStoreKeysKt.z());
        this.f124710r = m0(DevDataStoreKeysKt.J());
        this.f124711s = m(DevDataStoreKeysKt.m(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.p1());
            }
        });
        this.f124712t = m(DevDataStoreKeysKt.I(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.u1());
            }
        });
        this.f124713u = m(DevDataStoreKeysKt.P(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.y1());
            }
        });
        this.f124714v = m(DevDataStoreKeysKt.H(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.s1());
            }
        });
        this.f124715w = m(DevDataStoreKeysKt.K(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.w1());
            }
        });
        this.f124716x = n(DevDataStoreKeysKt.l(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevDataStore.j1((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.k1();
            }
        });
        this.f124717y = m(DevDataStoreKeysKt.p(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.B1();
            }
        });
        this.f124718z = m(DevDataStoreKeysKt.r(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.D1());
            }
        });
        this.A = m(DevDataStoreKeysKt.t(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.F1());
            }
        });
        this.B = m(DevDataStoreKeysKt.O(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.J2());
            }
        });
        this.C = m(DevDataStoreKeysKt.L(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.G2());
            }
        });
        this.D = m(DevDataStoreKeysKt.d(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.p0());
            }
        });
        this.E = m(DevDataStoreKeysKt.R(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.L2());
            }
        });
        this.F = m(DevDataStoreKeysKt.b(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.l0());
            }
        });
        this.G = m(DevDataStoreKeysKt.e(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DevDataStore.q0());
            }
        });
        this.H = m(DevDataStoreKeysKt.f(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.z1();
            }
        });
        this.I = m(DevDataStoreKeysKt.F(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.F2());
            }
        });
        this.J = m(DevDataStoreKeysKt.G(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.E2());
            }
        });
        this.K = m(DevDataStoreKeysKt.g(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.t0());
            }
        });
        this.L = m(DevDataStoreKeysKt.h(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.s0());
            }
        });
        this.M = m(DevDataStoreKeysKt.y(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.B2());
            }
        });
        this.N = m(DevDataStoreKeysKt.B(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.C2());
            }
        });
        this.O = m(DevDataStoreKeysKt.q(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.C1());
            }
        });
        this.P = m(DevDataStoreKeysKt.a(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.k0());
            }
        });
        this.Q = m(DevDataStoreKeysKt.i(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.n1());
            }
        });
        this.R = m0(DevDataStoreKeysKt.s());
        this.S = m(DevDataStoreKeysKt.Q(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.K2());
            }
        });
        this.T = m(DevDataStoreKeysKt.j(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DevDataStore.w0());
            }
        });
        this.U = n(DevDataStoreKeysKt.k(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevDataStore.u0((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.v0();
            }
        });
        this.V = m(DevDataStoreKeysKt.M(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DevDataStore.H2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String B1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RevenueCatOffering G1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return RevenueCatOffering.Converter.f97038a.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H1() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H2() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumDevState I1(int i3) {
        return PremiumDevState.Converter.f97018a.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long I2() {
        return 600000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J1() {
        return PremiumDevState.REAL_STATE.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow K1(DevDataStore devDataStore) {
        return !BuildConfig.f95357b.booleanValue() ? StateFlowKt.a(null) : FlowKt.J(devDataStore.f124703k, devDataStore.i1(), new DevDataStore$questionnaireConfigIfValid$2$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean K2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String L1() {
        return "{\n   \"id\":1,\n   \"title\":\"Get a $40 Amazon gift card\",\n   \"description\":\"All you have to do is tell us your thoughts on AppBlock\",\n   \"url\":\"https://www.userinterviews.com/projects/qhkGi8lQCg/apply\",\n   \"imageUrl\":\"images/img_research.svg\"\n}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M2() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdatesMockSettingsDTO j1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO = (InAppUpdatesMockSettingsDTO) new Gson().j(it, InAppUpdatesMockSettingsDTO.class);
        return inAppUpdatesMockSettingsDTO == null ? new InAppUpdatesMockSettingsDTO() : inAppUpdatesMockSettingsDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k1() {
        String strS = new Gson().s(new InAppUpdatesMockSettingsDTO());
        Intrinsics.checkNotNullExpressionValue(strS, "toJson(...)");
        return strS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l0() {
        return false;
    }

    private final Lazy m0(Preferences.Key key) {
        return n(key, new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.j0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DevDataStore.n0(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.dev.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(DevDataStore.o0());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DevPrefState n0(int i3) {
        return DevPrefState.Companion.a(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o0() {
        return DevPrefState.REAL.getStatusId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RatingDialogType u0(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        RatingDialogType ratingDialogType = null;
        if (StringsKt.p0(value)) {
            return null;
        }
        Iterator<RatingDialogType> it = RatingDialogType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RatingDialogType next = it.next();
            if (Intrinsics.areEqual(next.name(), value)) {
                ratingDialogType = next;
                break;
            }
        }
        return ratingDialogType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String z1() {
        return "";
    }

    public final Flow A0() {
        return (Flow) this.D.getValue();
    }

    public final Object A2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.T(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Lazy B0() {
        return this.G;
    }

    public final Flow C0() {
        return (Flow) this.K.getValue();
    }

    public final Flow D0() {
        return (Flow) this.L.getValue();
    }

    public final Flow E0() {
        return (Flow) this.U.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$paywallEngineOverride$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$paywallEngineOverride$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$paywallEngineOverride$1) r0
            int r1 = r0.f124729c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124729c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$paywallEngineOverride$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$paywallEngineOverride$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f124727a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124729c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L49
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            java.lang.Boolean r5 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L50
            kotlinx.coroutines.flow.Flow r5 = r4.L0()
            r0.f124729c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState r5 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState) r5
            java.lang.Boolean r5 = r5.isActive()
            return r5
        L50:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore.E1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow F0() {
        return (Flow) this.f124716x.getValue();
    }

    public final Lazy G0() {
        return this.H;
    }

    public final Flow H0() {
        return (Flow) this.f124701i.getValue();
    }

    public final Flow I0() {
        return (Flow) this.f124717y.getValue();
    }

    public final Flow J0() {
        return (Flow) this.O.getValue();
    }

    public final Flow K0() {
        return (Flow) this.f124718z.getValue();
    }

    public final Flow L0() {
        return (Flow) this.R.getValue();
    }

    public final Flow M0() {
        return (Flow) this.A.getValue();
    }

    public final Object M1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.a(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow N0() {
        return (Flow) this.f124697d.getValue();
    }

    public final Object N1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.b(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow O0() {
        return (Flow) this.f124696c.getValue();
    }

    public final Object O1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.d(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow P0() {
        return (Flow) this.f124704l.getValue();
    }

    public final Object P1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.g(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Q0() {
        return (Flow) this.f124702j.getValue();
    }

    public final Object Q1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.h(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow R0() {
        return (Flow) this.M.getValue();
    }

    public final Object R1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.i(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow S0() {
        return (Flow) this.f124709q.getValue();
    }

    public final Object S1(RatingDialogType ratingDialogType, Continuation continuation) {
        String strName;
        Preferences.Key keyK = DevDataStoreKeysKt.k();
        if (ratingDialogType == null || (strName = ratingDialogType.name()) == null) {
            strName = "";
        }
        Object objS = s(keyK, strName, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow T0() {
        return (Flow) this.f124707o.getValue();
    }

    public final Object T1(InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.l(), new Gson().s(inAppUpdatesMockSettingsDTO), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow U0() {
        return (Flow) this.N.getValue();
    }

    public final Object U1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.m(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow V0() {
        return (Flow) this.f124708p.getValue();
    }

    public final Object V1(String str, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.f(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow W0() {
        return (Flow) this.f124705m.getValue();
    }

    public final Object W1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.o(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow X0() {
        return (Flow) this.f124700h.getValue();
    }

    public final Object X1(String str, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.p(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Y0() {
        return (Flow) this.I.getValue();
    }

    public final Object Y1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.q(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Z0() {
        return (Flow) this.J.getValue();
    }

    public final Object Z1(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.r(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow a1() {
        return (Flow) this.f124710r.getValue();
    }

    public final Object a2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.s(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow b1() {
        return (Flow) this.C.getValue();
    }

    public final Object b2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.t(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow c1() {
        return (Flow) this.V.getValue();
    }

    public final Object c2(RevenueCatOffering revenueCatOffering, Continuation continuation) {
        String strName;
        Preferences.Key keyU = DevDataStoreKeysKt.u();
        if (revenueCatOffering == null || (strName = revenueCatOffering.name()) == null) {
            strName = "";
        }
        Object objS = s(keyU, strName, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow d1() {
        return (Flow) this.f124698f.getValue();
    }

    public final Object d2(PremiumDevState premiumDevState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.v(), Boxing.d(premiumDevState.getId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow e1() {
        return (Flow) this.B.getValue();
    }

    public final Object e2(String str, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.w(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow f1() {
        return (Flow) this.S.getValue();
    }

    public final Object f2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.y(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow g1() {
        return (Flow) this.E.getValue();
    }

    public final Object g2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.z(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow h1() {
        return (Flow) this.f124699g.getValue();
    }

    public final Object h2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.A(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow i1() {
        return (Flow) this.f124706n.getValue();
    }

    public final Object i2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.B(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object j2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.C(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object k2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.D(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
    
        if (r5.s(r2, r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$incrementEmergencyUnlockFlowCanceledCount$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$incrementEmergencyUnlockFlowCanceledCount$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$incrementEmergencyUnlockFlowCanceledCount$1) r0
            int r1 = r0.f124723f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124723f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$incrementEmergencyUnlockFlowCanceledCount$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$incrementEmergencyUnlockFlowCanceledCount$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124721c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124723f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L76
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            java.lang.Object r2 = r0.f124720b
            androidx.datastore.preferences.core.Preferences$Key r2 = (androidx.datastore.preferences.core.Preferences.Key) r2
            java.lang.Object r5 = r0.f124719a
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r5 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore) r5
            kotlin.ResultKt.b(r7)
            goto L5d
        L40:
            kotlin.ResultKt.b(r7)
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStoreKeysKt.e()
            kotlin.Lazy r7 = r6.G
            java.lang.Object r7 = r7.getValue()
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            r0.f124719a = r6
            r0.f124720b = r2
            r0.f124723f = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5c
            goto L75
        L5c:
            r5 = r6
        L5d:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r7 = r7 + r4
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r7)
            r4 = 0
            r0.f124719a = r4
            r0.f124720b = r4
            r0.f124723f = r3
            java.lang.Object r7 = r5.s(r2, r7, r0)
            if (r7 != r1) goto L76
        L75:
            return r1
        L76:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore.l1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object l2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.E(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow m1() {
        return (Flow) this.Q.getValue();
    }

    public final Object m2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.F(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object n2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.G(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow o1() {
        return (Flow) this.f124711s.getValue();
    }

    public final Object o2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.H(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object p2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.I(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$isRatingForced$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$isRatingForced$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$isRatingForced$1) r0
            int r1 = r0.f124726c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124726c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$isRatingForced$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore$isRatingForced$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f124724a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124726c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            r0.f124726c = r3
            java.lang.Object r5 = r4.x0(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            if (r5 == 0) goto L40
            goto L41
        L40:
            r3 = 0
        L41:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore.q1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object q2(DevPrefState devPrefState, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.J(), Boxing.d(devPrefState.getStatusId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow r1() {
        return (Flow) this.f124714v.getValue();
    }

    public final Object r2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.K(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object s2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.L(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow t1() {
        return (Flow) this.f124712t.getValue();
    }

    public final Object t2(String str, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.M(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object u2(long j3, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.N(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow v1() {
        return (Flow) this.f124715w.getValue();
    }

    public final Object v2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.O(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object w2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.P(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object x0(Continuation continuation) {
        if (BuildConfig.f95357b.booleanValue()) {
            return FlowKt.D(E0(), continuation);
        }
        return null;
    }

    public final Flow x1() {
        return (Flow) this.f124713u.getValue();
    }

    public final Object x2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.Q(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow y0() {
        return (Flow) this.P.getValue();
    }

    public final Object y2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.R(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow z0() {
        return (Flow) this.F.getValue();
    }

    public final Object z2(boolean z2, Continuation continuation) {
        Object objS = s(DevDataStoreKeysKt.S(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }
}
