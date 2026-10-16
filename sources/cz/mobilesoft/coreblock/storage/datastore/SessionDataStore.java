package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import cz.mobilesoft.coreblock.enums.EmailConsentState;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
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
public final class SessionDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124526d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Flow f124538q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionDataStore(Context context) {
        super(context, "SESSION_PREFERENCES", CollectionsKt.listOf(SharedPreferencesMigrationKt.b(context, "prop_session", null, 4, null)), false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124525c = m(DataStoreKeysKt.a5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.p9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.t0();
            }
        });
        this.f124526d = m(DataStoreKeysKt.c5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.w9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.v0();
            }
        });
        this.f124527f = m(DataStoreKeysKt.J2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.x9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.a0();
            }
        });
        this.f124528g = m(DataStoreKeysKt.F2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.y9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.Y();
            }
        });
        this.f124529h = m(DataStoreKeysKt.o1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.z9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(SessionDataStore.V());
            }
        });
        this.f124530i = m(DataStoreKeysKt.p1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.aa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(SessionDataStore.W());
            }
        });
        this.f124531j = m(DataStoreKeysKt.Z2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ba
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(SessionDataStore.p0());
            }
        });
        this.f124532k = m(DataStoreKeysKt.V3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.q9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.s0();
            }
        });
        this.f124533l = m(DataStoreKeysKt.U3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.r9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.q0();
            }
        });
        this.f124534m = m(DataStoreKeysKt.M(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.s9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.G();
            }
        });
        this.f124535n = m(DataStoreKeysKt.N1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.t9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.X();
            }
        });
        this.f124536o = m(DataStoreKeysKt.G2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.u9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.Z();
            }
        });
        this.f124537p = m(DataStoreKeysKt.b5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.v9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SessionDataStore.u0();
            }
        });
        final Flow data = l().getData();
        this.f124538q = new Flow<EmailConsentState>() { // from class: cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124540a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2", f = "SessionDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124541a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124542b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124543c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124545f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124546g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124547h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124548i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124541a = obj;
                        this.f124542b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f124540a = flowCollector;
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
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124542b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124542b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124541a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124542b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124547h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124545f
                        cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L75
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124540a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        cz.mobilesoft.coreblock.enums.EmailConsentState$Companion r4 = cz.mobilesoft.coreblock.enums.EmailConsentState.f96979a
                        androidx.datastore.preferences.core.Preferences$Key r5 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.y0()
                        java.lang.Object r2 = r2.c(r5)
                        java.lang.String r2 = (java.lang.String) r2
                        cz.mobilesoft.coreblock.enums.EmailConsentState r2 = r4.a(r2)
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124543c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124545f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124546g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124547h = r7
                        r7 = 0
                        r0.f124548i = r7
                        r0.f124542b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L75
                        return r1
                    L75:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.SessionDataStore$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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
    public static final String G() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long W() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String X() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Z() {
        return " ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s0() {
        return "local";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String u0() {
        return " ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v0() {
        return "";
    }

    public final Flow H() {
        return (Flow) this.f124534m.getValue();
    }

    public final Flow I() {
        return this.f124538q;
    }

    public final Flow J() {
        return (Flow) this.f124529h.getValue();
    }

    public final Flow K() {
        return (Flow) this.f124530i.getValue();
    }

    public final Flow L() {
        return (Flow) this.f124535n.getValue();
    }

    public final Flow M() {
        return (Flow) this.f124528g.getValue();
    }

    public final Flow N() {
        return (Flow) this.f124536o.getValue();
    }

    public final Flow O() {
        return (Flow) this.f124527f.getValue();
    }

    public final Flow P() {
        return (Flow) this.f124531j.getValue();
    }

    public final Flow Q() {
        return (Flow) this.f124533l.getValue();
    }

    public final Flow R() {
        return (Flow) this.f124532k.getValue();
    }

    public final Flow S() {
        return (Flow) this.f124525c.getValue();
    }

    public final Flow T() {
        return (Flow) this.f124537p.getValue();
    }

    public final Flow U() {
        return (Flow) this.f124526d.getValue();
    }

    public final Object b0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.M(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object c0(EmailConsentState emailConsentState, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.y0(), emailConsentState.a(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object d0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.o1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object e0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.p1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object f0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.N1(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object g0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.F2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object h0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.G2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object i0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.J2(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object j0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Z2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object k0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U3(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object l0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V3(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object m0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a5(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object n0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b5(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object o0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c5(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }
}
