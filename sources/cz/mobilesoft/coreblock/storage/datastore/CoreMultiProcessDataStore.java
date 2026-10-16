package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import com.facebook.appevents.AppEventsConstants;
import cz.mobilesoft.coreblock.enums.TripleState;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import cz.mobilesoft.coreblock.storage.datastore.migration.CoreMultiProcessPreferencesMigrationKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.BaseRemoteConfig;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
public final class CoreMultiProcessDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124136d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124142k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124143l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124144m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124145n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124146o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124147p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124148q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124149r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124150s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f124155x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f124156y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f124157z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreMultiProcessDataStore(final Context context) {
        super(context, "CORE_MULTI_PROCESS_PREFERENCES", CollectionsKt.listOf((Object[]) new DataMigration[]{CoreMultiProcessPreferencesMigrationKt.a(context), CoreMultiProcessPreferencesMigrationKt.b()}), true);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124135c = m(DataStoreKeysKt.F1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.i3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.z0());
            }
        });
        this.f124136d = m(DataStoreKeysKt.B2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.k3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.B0());
            }
        });
        this.f124137f = m(DataStoreKeysKt.w1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.o3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreMultiProcessDataStore.x0());
            }
        });
        this.f124138g = m(DataStoreKeysKt.I4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.f1();
            }
        });
        this.f124139h = m(DataStoreKeysKt.j(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.R();
            }
        });
        this.f124140i = m(DataStoreKeysKt.R(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreMultiProcessDataStore.W());
            }
        });
        this.f124141j = m(DataStoreKeysKt.P2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.C0();
            }
        });
        this.f124142k = m(DataStoreKeysKt.C0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.Y();
            }
        });
        this.f124143l = m(DataStoreKeysKt.o3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.e1());
            }
        });
        this.f124144m = m(DataStoreKeysKt.X2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.c1());
            }
        });
        this.f124145n = m(DataStoreKeysKt.R2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.E0();
            }
        });
        this.f124146o = n(DataStoreKeysKt.i(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.x3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CoreMultiProcessDataStore.S((String) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.T();
            }
        });
        this.f124147p = m(DataStoreKeysKt.Q(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.V());
            }
        });
        this.f124148q = m(DataStoreKeysKt.y1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreMultiProcessDataStore.y0());
            }
        });
        this.f124149r = m(DataStoreKeysKt.J1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.A0());
            }
        });
        this.f124150s = m(DataStoreKeysKt.Q2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.D0(context);
            }
        });
        this.f124151t = m(DataStoreKeysKt.L(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreMultiProcessDataStore.U());
            }
        });
        this.f124152u = m(DataStoreKeysKt.S2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.F0();
            }
        });
        this.f124153v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.j3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreMultiProcessDataStore.h1(this.f124776a);
            }
        });
        this.f124154w = m(DataStoreKeysKt.J4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.l3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CoreMultiProcessDataStore.g1());
            }
        });
        this.f124155x = q(DataStoreKeysKt.N4());
        this.f124156y = m(DataStoreKeysKt.L4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.m3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(CoreMultiProcessDataStore.i1());
            }
        });
        this.f124157z = m(DataStoreKeysKt.M4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.n3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CoreMultiProcessDataStore.j1());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set C0() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set D0(Context context) {
        List listA = SystemSettingsType.Companion.a(context);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(((SystemSettingsType) ((Pair) it.next()).e()).name());
        }
        return CollectionsKt.toSet(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String E0() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String F0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set R() {
        Set DEFAULT_EXCLUDED_ALLOWLIST_APPLICATIONS = BaseRemoteConfig.f127781b;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_EXCLUDED_ALLOWLIST_APPLICATIONS, "DEFAULT_EXCLUDED_ALLOWLIST_APPLICATIONS");
        return DEFAULT_EXCLUDED_ALLOWLIST_APPLICATIONS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TripleState S(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return TripleState.Companion.a(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T() {
        return "Unset";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int U() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean V() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set Y() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set f1() {
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow h1(CoreMultiProcessDataStore coreMultiProcessDataStore) {
        final Flow data = coreMultiProcessDataStore.l().getData();
        return new Flow<Boolean>() { // from class: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124175a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2", f = "CoreMultiProcessDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124176a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124177b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124178c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124180f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124181g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124182h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124183i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124176a = obj;
                        this.f124177b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f124175a = flowCollector;
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
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124177b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124177b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124176a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124177b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124182h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124180f
                        cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L89
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124175a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.K4()
                        java.lang.Object r4 = r2.c(r4)
                        java.lang.Boolean r4 = (java.lang.Boolean) r4
                        androidx.datastore.preferences.core.Preferences$Key r5 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.J4()
                        java.lang.Object r2 = r2.c(r5)
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        r5 = 0
                        if (r2 == 0) goto L5d
                        boolean r2 = r2.booleanValue()
                        goto L5e
                    L5d:
                        r2 = r5
                    L5e:
                        boolean r2 = cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStoreKt.a(r4, r2)
                        java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124178c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124180f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124181g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124182h = r7
                        r0.f124183i = r5
                        r0.f124177b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L89
                        return r1
                    L89:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$timeNudgeEnabled_delegate$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i1() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j1() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long x0() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0() {
        return false;
    }

    public final Object G0(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.j(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object H0(TripleState tripleState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i(), tripleState.name(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object I0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object J0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.R(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object K0(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.C0(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object L0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.w1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object M0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.y1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object N0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object O0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object P0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.B2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
    
        if (r2.s(r6, r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$addExcludedUnsupportedBrowser$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$addExcludedUnsupportedBrowser$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$addExcludedUnsupportedBrowser$1) r0
            int r1 = r0.f124163g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124163g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$addExcludedUnsupportedBrowser$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$addExcludedUnsupportedBrowser$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f124161d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124163g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f124158a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r7)
            goto L80
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f124160c
            androidx.datastore.preferences.core.Preferences$Key r6 = (androidx.datastore.preferences.core.Preferences.Key) r6
            java.lang.Object r2 = r0.f124159b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r2 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore) r2
            java.lang.Object r4 = r0.f124158a
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.b(r7)
            goto L66
        L48:
            kotlin.ResultKt.b(r7)
            androidx.datastore.preferences.core.Preferences$Key r7 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.C0()
            kotlinx.coroutines.flow.Flow r2 = r5.e0()
            r0.f124158a = r6
            r0.f124159b = r5
            r0.f124160c = r7
            r0.f124163g = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L62
            goto L7f
        L62:
            r4 = r6
            r6 = r7
            r7 = r2
            r2 = r5
        L66:
            java.util.Set r7 = (java.util.Set) r7
            java.util.Set r7 = kotlin.collections.SetsKt.plus(r7, r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f124158a = r4
            r4 = 0
            r0.f124159b = r4
            r0.f124160c = r4
            r0.f124163g = r3
            java.lang.Object r6 = r2.s(r6, r7, r0)
            if (r6 != r1) goto L80
        L7f:
            return r1
        L80:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore.Q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object Q0(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P2(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object R0(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q2(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object S0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.R2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object T0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.S2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object U0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.X2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object V0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.o3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object W0(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.I4(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object X(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.L(), Boxing.d(10), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object X0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Y0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.K4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow Z() {
        return (Flow) this.f124139h.getValue();
    }

    public final Object Z0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.L4(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow a0() {
        return (Flow) this.f124146o.getValue();
    }

    public final Object a1(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.M4(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow b0() {
        return (Flow) this.f124151t.getValue();
    }

    public final Object b1(Set set, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N4(), set, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow c0() {
        return (Flow) this.f124147p.getValue();
    }

    public final Flow d0() {
        return (Flow) this.f124140i.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$shouldShowCustomBlockScreenPopup$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$shouldShowCustomBlockScreenPopup$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$shouldShowCustomBlockScreenPopup$1) r0
            int r1 = r0.f124173d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124173d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$shouldShowCustomBlockScreenPopup$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$shouldShowCustomBlockScreenPopup$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124171b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124173d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            int r0 = r0.f124170a
            kotlin.ResultKt.b(r7)
            goto L65
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            kotlin.ResultKt.b(r7)
            goto L4a
        L3a:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.flow.Flow r7 = r6.b0()
            r0.f124173d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L4a
            goto L63
        L4a:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            int r7 = r7 + r4
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.L()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r7)
            r0.f124170a = r7
            r0.f124173d = r3
            java.lang.Object r0 = r6.s(r2, r5, r0)
            if (r0 != r1) goto L64
        L63:
            return r1
        L64:
            r0 = r7
        L65:
            int r7 = r0 % 3
            if (r7 != 0) goto L6e
            r7 = 9
            if (r0 > r7) goto L6e
            goto L6f
        L6e:
            r4 = 0
        L6f:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore.d1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow e0() {
        return (Flow) this.f124142k.getValue();
    }

    public final Flow f0() {
        return (Flow) this.f124148q.getValue();
    }

    public final long g0(UsageLimit.PeriodType periodType, int i3) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        Calendar calendarA = TimeHelperExt.A();
        long timeInMillis = calendarA.getTimeInMillis();
        UsageLimit.PeriodType periodType2 = UsageLimit.PeriodType.DAILY;
        if (periodType == periodType2) {
            calendarA.set(11, i3);
        }
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        if (timeInMillis < calendarA.getTimeInMillis()) {
            if (periodType == periodType2) {
                calendarA.add(5, -1);
            } else if (periodType == UsageLimit.PeriodType.HOURLY) {
                calendarA.add(11, -1);
            }
        }
        return calendarA.getTimeInMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h0(cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$getLatestApplicationUsageLimitResetTime$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$getLatestApplicationUsageLimitResetTime$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$getLatestApplicationUsageLimitResetTime$1) r0
            int r1 = r0.f124169g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124169g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$getLatestApplicationUsageLimitResetTime$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore$getLatestApplicationUsageLimitResetTime$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124167d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124169g
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.f124166c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType) r5
            java.lang.Object r1 = r0.f124165b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r1 = (cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore) r1
            java.lang.Object r0 = r0.f124164a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType) r0
            kotlin.ResultKt.b(r6)
            goto L58
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.Flow r6 = r4.d0()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124164a = r2
            r0.f124165b = r4
            r0.f124166c = r5
            r0.f124169g = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L57
            return r1
        L57:
            r1 = r4
        L58:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            long r5 = r1.g0(r5, r6)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore.h0(cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow i0() {
        return (Flow) this.f124135c.getValue();
    }

    public final Flow j0() {
        return (Flow) this.f124149r.getValue();
    }

    public final Flow k0() {
        return (Flow) this.f124136d.getValue();
    }

    public final Flow l0() {
        return (Flow) this.f124141j.getValue();
    }

    public final Flow m0() {
        return (Flow) this.f124150s.getValue();
    }

    public final Flow n0() {
        return (Flow) this.f124145n.getValue();
    }

    public final Flow o0() {
        return (Flow) this.f124152u.getValue();
    }

    public final Flow p0() {
        return (Flow) this.f124144m.getValue();
    }

    public final Flow q0() {
        return (Flow) this.f124143l.getValue();
    }

    public final Flow s0() {
        return (Flow) this.f124138g.getValue();
    }

    public final Flow t0() {
        return (Flow) this.f124153v.getValue();
    }

    public final Flow u0() {
        return (Flow) this.f124156y.getValue();
    }

    public final Flow v0() {
        return (Flow) this.f124157z.getValue();
    }

    public final Flow w0() {
        return (Flow) this.f124155x.getValue();
    }
}
