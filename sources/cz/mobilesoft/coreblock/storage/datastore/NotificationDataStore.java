package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.storage.datastore.migration.NotificationPreferencesMigrationKt;
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
public final class NotificationDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124409d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124413i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124414j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124415k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124423s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationDataStore(Context context) {
        super(context, "NOTIFICATION", CollectionsKt.listOf(NotificationPreferencesMigrationKt.a(context)), true);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124408c = m(DataStoreKeysKt.K3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.G0());
            }
        });
        this.f124409d = m(DataStoreKeysKt.M3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.f8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.H0());
            }
        });
        this.f124410f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.g8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NotificationDataStore.c0(this.f124775a);
            }
        });
        this.f124411g = m(DataStoreKeysKt.P1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(NotificationDataStore.d0());
            }
        });
        this.f124412h = m(DataStoreKeysKt.Q1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(NotificationDataStore.g0());
            }
        });
        this.f124413i = n(DataStoreKeysKt.R1(), new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.t7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotificationDataStore.e0(((Integer) obj).intValue());
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(NotificationDataStore.f0());
            }
        });
        this.f124414j = m(DataStoreKeysKt.e3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.C0());
            }
        });
        this.f124415k = m(DataStoreKeysKt.d3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.B0());
            }
        });
        this.f124416l = m(DataStoreKeysKt.c3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.A0());
            }
        });
        this.f124417m = m(DataStoreKeysKt.b3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.z0());
            }
        });
        this.f124418n = m(DataStoreKeysKt.N3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.F0());
            }
        });
        this.f124419o = m(DataStoreKeysKt.Q3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.a8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.I0());
            }
        });
        this.f124420p = m(DataStoreKeysKt.x3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.b8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.E0());
            }
        });
        this.f124421q = m(DataStoreKeysKt.h3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.c8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NotificationDataStore.D0());
            }
        });
        this.f124422r = m(DataStoreKeysKt.O(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.d8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(NotificationDataStore.L());
            }
        });
        this.f124423s = m(DataStoreKeysKt.N(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.e8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(NotificationDataStore.K());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long K() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int L() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow c0(NotificationDataStore notificationDataStore) {
        final Flow data = notificationDataStore.l().getData();
        return new Flow<Integer>() { // from class: cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124425a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2", f = "NotificationDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124426a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124427b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124428c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124430f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124431g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124432h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124433i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124426a = obj;
                        this.f124427b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f124425a = flowCollector;
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
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124427b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124427b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124426a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124427b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124432h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124430f
                        cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L8f
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124425a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.O1()
                        java.lang.Object r4 = r2.c(r4)
                        java.lang.Integer r4 = (java.lang.Integer) r4
                        r5 = 0
                        if (r4 == 0) goto L53
                        int r2 = r4.intValue()
                        goto L68
                    L53:
                        androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.a1()
                        java.lang.Object r2 = r2.c(r4)
                        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
                        boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
                        if (r2 == 0) goto L67
                        r2 = r5
                        goto L68
                    L67:
                        r2 = 5
                    L68:
                        java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.d(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124428c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124430f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124431g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124432h = r7
                        r0.f124433i = r5
                        r0.f124427b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L8f
                        return r1
                    L8f:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore$notificationBeforeIntervalStart_delegate$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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
    public static final int d0() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventShowAsType e0(int i3) {
        return EventShowAsType.Converter.f96983a.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f0() {
        return EventShowAsType.NOTIFICATION.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0() {
        return true;
    }

    public final Flow M() {
        return (Flow) this.f124423s.getValue();
    }

    public final Flow N() {
        return (Flow) this.f124422r.getValue();
    }

    public final Flow O() {
        return (Flow) this.f124410f.getValue();
    }

    public final Flow P() {
        return (Flow) this.f124411g.getValue();
    }

    public final Flow Q() {
        return (Flow) this.f124412h.getValue();
    }

    public final Flow R() {
        return (Flow) this.f124413i.getValue();
    }

    public final Flow S() {
        return (Flow) this.f124416l.getValue();
    }

    public final Flow T() {
        return (Flow) this.f124417m.getValue();
    }

    public final Flow U() {
        return (Flow) this.f124414j.getValue();
    }

    public final Flow V() {
        return (Flow) this.f124415k.getValue();
    }

    public final Flow W() {
        return (Flow) this.f124421q.getValue();
    }

    public final Flow X() {
        return (Flow) this.f124420p.getValue();
    }

    public final Flow Y() {
        return (Flow) this.f124418n.getValue();
    }

    public final Flow Z() {
        return (Flow) this.f124408c.getValue();
    }

    public final Flow a0() {
        return (Flow) this.f124409d.getValue();
    }

    public final Flow b0() {
        return (Flow) this.f124419o.getValue();
    }

    public final Object h0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object i0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.e3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object j0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object k0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.O(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object l0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a1(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object m0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.O1(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object n0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P1(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object o0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q1(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object p0(EventShowAsType eventShowAsType, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.R1(), Boxing.d(eventShowAsType.getId()), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object q0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object s0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object t0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.h3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object u0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.x3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object v0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.K3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object w0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.M3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object x0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object y0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }
}
