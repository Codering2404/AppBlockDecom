package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.migration.StatisticsPreferencesMigrationKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
public final class StatisticsDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124550d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124558m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f124559n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f124560o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f124561p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f124562q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f124563r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f124564s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f124565t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f124566u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f124567v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f124568w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatisticsDataStore(Context context) {
        super(context, "STATISTICS_PREFERENCES", CollectionsKt.listOf(StatisticsPreferencesMigrationKt.a(context)), true);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124549c = m(DataStoreKeysKt.s1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.qa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.w0());
            }
        });
        this.f124550d = m(DataStoreKeysKt.U2(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ga
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.A0());
            }
        });
        this.f124551f = m(DataStoreKeysKt.X3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ha
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.S());
            }
        });
        this.f124552g = m(DataStoreKeysKt.n(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ia
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.Q());
            }
        });
        this.f124553h = m(DataStoreKeysKt.g5(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ja
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.T());
            }
        });
        this.f124554i = m(DataStoreKeysKt.P0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ka
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.R());
            }
        });
        this.f124555j = m(DataStoreKeysKt.W3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.la
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.k0());
            }
        });
        this.f124556k = m(DataStoreKeysKt.B1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ma
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.x0());
            }
        });
        this.f124557l = m(DataStoreKeysKt.P3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.oa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.S0());
            }
        });
        this.f124558m = m(DataStoreKeysKt.Y3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.pa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.T0());
            }
        });
        this.f124559n = m(DataStoreKeysKt.X0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ra
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.t0());
            }
        });
        this.f124560o = m(DataStoreKeysKt.m(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.sa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.P());
            }
        });
        this.f124561p = m(DataStoreKeysKt.W0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ta
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.q0());
            }
        });
        this.f124562q = m(DataStoreKeysKt.U0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ua
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.m0());
            }
        });
        this.f124563r = m(DataStoreKeysKt.V0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.va
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.o0());
            }
        });
        this.f124564s = m(DataStoreKeysKt.b1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.wa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.v0());
            }
        });
        this.f124565t = m(DataStoreKeysKt.M1(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.xa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StatisticsDataStore.z0());
            }
        });
        this.f124566u = m(DataStoreKeysKt.B0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.da
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StatisticsDataStore.y0());
            }
        });
        this.f124567v = m(DataStoreKeysKt.P(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ea
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsDataStore.U();
            }
        });
        this.f124568w = m(DataStoreKeysKt.Q0(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.fa
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StatisticsDataStore.j0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long P() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long S0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long T0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String U() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long V0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long X0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j0() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long x0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z0() {
        return 0L;
    }

    public final Object B0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.m(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object C0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.n(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object D0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object E0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object F0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.Q0(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object G0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object H0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.V0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object I0(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.W0(), Boxing.a(true), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object J0(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.X0(), Boxing.a(true), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object K0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object L0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.s1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object M0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.B1(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object N0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.B0(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object O0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.U2(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object P0(long j3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.P3(), Boxing.e(j3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object Q0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.X3(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object R0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g5(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r4.s(r2, r10, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object U0(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateMoodCheckInClosedCount$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateMoodCheckInClosedCount$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateMoodCheckInClosedCount$1) r0
            int r1 = r0.f124573f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124573f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateMoodCheckInClosedCount$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateMoodCheckInClosedCount$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f124571c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124573f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            goto L79
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            java.lang.Object r2 = r0.f124570b
            androidx.datastore.preferences.core.Preferences$Key r2 = (androidx.datastore.preferences.core.Preferences.Key) r2
            java.lang.Object r4 = r0.f124569a
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r4 = (cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore) r4
            kotlin.ResultKt.b(r10)
            goto L5e
        L40:
            kotlin.ResultKt.b(r10)
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.M1()
            androidx.datastore.preferences.core.Preferences$Key r10 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.M1()
            cz.mobilesoft.coreblock.storage.datastore.na r5 = new cz.mobilesoft.coreblock.storage.datastore.na
            r5.<init>()
            r0.f124569a = r9
            r0.f124570b = r2
            r0.f124573f = r4
            java.lang.Object r10 = r9.j(r10, r5, r0)
            if (r10 != r1) goto L5d
            goto L78
        L5d:
            r4 = r9
        L5e:
            java.lang.Number r10 = (java.lang.Number) r10
            long r5 = r10.longValue()
            r7 = 1
            long r5 = r5 + r7
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            r5 = 0
            r0.f124569a = r5
            r0.f124570b = r5
            r0.f124573f = r3
            java.lang.Object r10 = r4.s(r2, r10, r0)
            if (r10 != r1) goto L79
        L78:
            return r1
        L79:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore.U0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow V() {
        return (Flow) this.f124560o.getValue();
    }

    public final Flow W() {
        return (Flow) this.f124552g.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r4.s(r2, r10, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object W0(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateStatisticsLaunchCount$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateStatisticsLaunchCount$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateStatisticsLaunchCount$1) r0
            int r1 = r0.f124578f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124578f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateStatisticsLaunchCount$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore$updateStatisticsLaunchCount$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f124576c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124578f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            goto L79
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L34:
            java.lang.Object r2 = r0.f124575b
            androidx.datastore.preferences.core.Preferences$Key r2 = (androidx.datastore.preferences.core.Preferences.Key) r2
            java.lang.Object r4 = r0.f124574a
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r4 = (cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore) r4
            kotlin.ResultKt.b(r10)
            goto L5e
        L40:
            kotlin.ResultKt.b(r10)
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Y3()
            androidx.datastore.preferences.core.Preferences$Key r10 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Y3()
            cz.mobilesoft.coreblock.storage.datastore.ca r5 = new cz.mobilesoft.coreblock.storage.datastore.ca
            r5.<init>()
            r0.f124574a = r9
            r0.f124575b = r2
            r0.f124578f = r4
            java.lang.Object r10 = r9.j(r10, r5, r0)
            if (r10 != r1) goto L5d
            goto L78
        L5d:
            r4 = r9
        L5e:
            java.lang.Number r10 = (java.lang.Number) r10
            long r5 = r10.longValue()
            r7 = 1
            long r5 = r5 + r7
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            r5 = 0
            r0.f124574a = r5
            r0.f124575b = r5
            r0.f124578f = r3
            java.lang.Object r10 = r4.s(r2, r10, r0)
            if (r10 != r1) goto L79
        L78:
            return r1
        L79:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore.W0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow X() {
        return (Flow) this.f124554i.getValue();
    }

    public final Flow Y() {
        return (Flow) this.f124551f.getValue();
    }

    public final Flow Z() {
        return (Flow) this.f124553h.getValue();
    }

    public final Flow a0() {
        return (Flow) this.f124567v.getValue();
    }

    public final Flow b0() {
        return (Flow) this.f124568w.getValue();
    }

    public final Flow c0() {
        return (Flow) this.f124549c.getValue();
    }

    public final Flow d0() {
        return (Flow) this.f124556k.getValue();
    }

    public final Flow e0() {
        return (Flow) this.f124566u.getValue();
    }

    public final Flow f0() {
        return (Flow) this.f124565t.getValue();
    }

    public final Flow g0() {
        return (Flow) this.f124550d.getValue();
    }

    public final Flow h0() {
        return (Flow) this.f124557l.getValue();
    }

    public final Flow i0() {
        return (Flow) this.f124558m.getValue();
    }

    public final Flow l0() {
        return (Flow) this.f124562q.getValue();
    }

    public final Flow n0() {
        return (Flow) this.f124563r.getValue();
    }

    public final Flow p0() {
        return (Flow) this.f124561p.getValue();
    }

    public final Flow s0() {
        return (Flow) this.f124559n.getValue();
    }

    public final Flow u0() {
        return (Flow) this.f124564s.getValue();
    }
}
