package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKt;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakDataStore extends BaseDataStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f124579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f124580d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f124581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f124582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f124583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f124584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f124585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f124586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f124587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f124588m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ActivityTransition {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Closed implements ActivityTransition {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final long f124589a;

            public Closed(long j3) {
                this.f124589a = j3;
            }

            public final long a() {
                return this.f124589a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Closed) && this.f124589a == ((Closed) obj).f124589a;
            }

            public int hashCode() {
                return Long.hashCode(this.f124589a);
            }

            public String toString() {
                return "Closed(startMillis=" + this.f124589a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Opened implements ActivityTransition {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Opened f124590a = new Opened();

            private Opened() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Opened);
            }

            public int hashCode() {
                return -1283832791;
            }

            public String toString() {
                return "Opened";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Unchanged implements ActivityTransition {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Unchanged f124591a = new Unchanged();

            private Unchanged() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Unchanged);
            }

            public int hashCode() {
                return 920539707;
            }

            public String toString() {
                return "Unchanged";
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreakDataStore(Context context) {
        super(context, "STREAKS", null, true, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124579c = m(DataStoreKeysKt.h4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ya
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StreakDataStore.e0());
            }
        });
        this.f124580d = m(DataStoreKeysKt.e4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.za
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StreakDataStore.b0());
            }
        });
        this.f124581f = m(DataStoreKeysKt.Z3(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.ab
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(StreakDataStore.E());
            }
        });
        this.f124582g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.bb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakDataStore.l0(this.f124688a);
            }
        });
        this.f124583h = m(DataStoreKeysKt.b4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.cb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StreakDataStore.U());
            }
        });
        this.f124584i = m(DataStoreKeysKt.c4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.db
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakDataStore.X();
            }
        });
        this.f124585j = m(DataStoreKeysKt.d4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.eb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StreakDataStore.Y();
            }
        });
        this.f124586k = m(DataStoreKeysKt.a4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.fb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StreakDataStore.R());
            }
        });
        this.f124587l = m(DataStoreKeysKt.g4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.gb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(StreakDataStore.d0());
            }
        });
        this.f124588m = m(DataStoreKeysKt.f4(), new Function0() { // from class: cz.mobilesoft.coreblock.storage.datastore.hb
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(StreakDataStore.W());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long E() {
        return 0L;
    }

    public static /* synthetic */ Object G(StreakDataStore streakDataStore, long j3, Boolean bool, Boolean bool2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        if ((i3 & 4) != 0) {
            bool2 = null;
        }
        return streakDataStore.F(j3, bool, bool2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W() {
        return false;
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
    public final ActivityTransition a0(MutablePreferences mutablePreferences, boolean z2, boolean z3, long j3) {
        if (z2 == z3) {
            return ActivityTransition.Unchanged.f124591a;
        }
        if (z3) {
            mutablePreferences.k(DataStoreKeysKt.Z3(), Long.valueOf(j3));
            return ActivityTransition.Opened.f124590a;
        }
        Long l3 = (Long) mutablePreferences.c(DataStoreKeysKt.Z3());
        long jLongValue = l3 != null ? l3.longValue() : 0L;
        mutablePreferences.k(DataStoreKeysKt.Z3(), 0L);
        return new ActivityTransition.Closed(jLongValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow l0(StreakDataStore streakDataStore) {
        final Flow data = streakDataStore.l().getData();
        return new Flow<Set<? extends Integer>>() { // from class: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f124627a;

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2", f = "StreakDataStore.kt", l = {50}, m = "emit", v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f124628a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f124629b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    Object f124630c;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    Object f124632f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    Object f124633g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    Object f124634h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    int f124635i;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f124628a = obj;
                        this.f124629b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f124627a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f124629b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f124629b = r1
                        goto L18
                    L13:
                        cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.f124628a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f124629b
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r7 = r0.f124634h
                        kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                        java.lang.Object r7 = r0.f124632f
                        cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                        kotlin.ResultKt.b(r8)
                        goto L9d
                    L31:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L39:
                        kotlin.ResultKt.b(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.f124627a
                        r2 = r7
                        androidx.datastore.preferences.core.Preferences r2 = (androidx.datastore.preferences.core.Preferences) r2
                        androidx.datastore.preferences.core.Preferences$Key r4 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.i4()
                        java.lang.Object r2 = r2.c(r4)
                        java.util.Set r2 = (java.util.Set) r2
                        if (r2 == 0) goto L75
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r4.<init>()
                        java.util.Iterator r2 = r2.iterator()
                    L58:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L6e
                        java.lang.Object r5 = r2.next()
                        java.lang.String r5 = (java.lang.String) r5
                        java.lang.Integer r5 = kotlin.text.StringsKt.u(r5)
                        if (r5 == 0) goto L58
                        r4.add(r5)
                        goto L58
                    L6e:
                        java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r4)
                        if (r2 == 0) goto L75
                        goto L79
                    L75:
                        java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
                    L79:
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124630c = r4
                        java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                        r0.f124632f = r4
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                        r0.f124633g = r7
                        java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                        r0.f124634h = r7
                        r7 = 0
                        r0.f124635i = r7
                        r0.f124629b = r3
                        java.lang.Object r7 = r8.emit(r2, r0)
                        if (r7 != r1) goto L9d
                        return r1
                    L9d:
                        kotlin.Unit r7 = kotlin.Unit.f139807a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$shownMilestones_delegate$lambda$0$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = data.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(long r13, java.lang.Boolean r15, java.lang.Boolean r16, kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = r17
            boolean r1 = r0 instanceof cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$1
            if (r1 == 0) goto L15
            r1 = r0
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$1 r1 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$1) r1
            int r2 = r1.f124598h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f124598h = r2
            goto L1a
        L15:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$1 r1 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$1
            r1.<init>(r12, r0)
        L1a:
            java.lang.Object r0 = r1.f124596f
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r1.f124598h
            r11 = 1
            if (r2 == 0) goto L3f
            if (r2 != r11) goto L37
            java.lang.Object r2 = r1.f124595d
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r1.f124594c
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            java.lang.Object r1 = r1.f124593b
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            kotlin.ResultKt.b(r0)
            goto L74
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3f:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$ActivityTransition$Unchanged r0 = cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.ActivityTransition.Unchanged.f124591a
            r5.f140144a = r0
            androidx.datastore.core.DataStore r0 = r12.l()
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$2 r2 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$applyBlockingActivity$2
            r9 = 0
            r6 = r12
            r7 = r13
            r3 = r15
            r4 = r16
            r2.<init>(r3, r4, r5, r6, r7, r9)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r15)
            r1.f124593b = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r16)
            r1.f124594c = r3
            r1.f124595d = r5
            r1.f124592a = r13
            r1.f124598h = r11
            java.lang.Object r0 = androidx.datastore.preferences.core.PreferencesKt.a(r0, r2, r1)
            if (r0 != r10) goto L73
            return r10
        L73:
            r2 = r5
        L74:
            java.lang.Object r0 = r2.f140144a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.F(long, java.lang.Boolean, java.lang.Boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object H(Continuation continuation) {
        Object objA = PreferencesKt.a(l(), new StreakDataStore$clearBlockingActivity$2(null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final Object I(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.i4(), SetsKt.emptySet(), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Flow J() {
        return (Flow) this.f124581f.getValue();
    }

    public final Flow K() {
        return (Flow) this.f124586k.getValue();
    }

    public final Flow L() {
        return (Flow) this.f124584i.getValue();
    }

    public final Flow M() {
        return (Flow) this.f124585j.getValue();
    }

    public final Flow N() {
        return (Flow) this.f124580d.getValue();
    }

    public final Flow O() {
        return (Flow) this.f124587l.getValue();
    }

    public final Flow P() {
        return (Flow) this.f124579c.getValue();
    }

    public final Flow Q() {
        return (Flow) this.f124582g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object S(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$isBlockingActive$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$isBlockingActive$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$isBlockingActive$1) r0
            int r1 = r0.f124610c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124610c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$isBlockingActive$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$isBlockingActive$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f124608a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124610c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.b(r6)
            goto L48
        L38:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.Flow r6 = r5.P()
            r0.f124610c = r4
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L48
            goto L5c
        L48:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L5e
            kotlinx.coroutines.flow.Flow r6 = r5.N()
            r0.f124610c = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L5d
        L5c:
            return r1
        L5d:
            return r6
        L5e:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.S(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow T() {
        return (Flow) this.f124583h.getValue();
    }

    public final Flow V() {
        return (Flow) this.f124588m.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
    
        if (s(r2, r4, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z(int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$markMilestoneShown$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$markMilestoneShown$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$markMilestoneShown$1) r0
            int r1 = r0.f124615f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124615f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$markMilestoneShown$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$markMilestoneShown$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f124613c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124615f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r8 = r0.f124612b
            java.util.Set r8 = (java.util.Set) r8
            kotlin.ResultKt.b(r9)
            goto L9d
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            int r8 = r0.f124611a
            kotlin.ResultKt.b(r9)
            goto L50
        L3e:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.flow.Flow r9 = r7.Q()
            r0.f124611a = r8
            r0.f124615f = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L50
            goto L9c
        L50:
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.d(r8)
            java.util.Set r9 = kotlin.collections.SetsKt.plus(r9, r2)
            androidx.datastore.preferences.core.Preferences$Key r2 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.i4()
            r4 = r9
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
            r5.<init>(r6)
            java.util.Iterator r4 = r4.iterator()
        L70:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L88
            java.lang.Object r6 = r4.next()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r5.add(r6)
            goto L70
        L88:
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r5)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f124612b = r9
            r0.f124611a = r8
            r0.f124615f = r3
            java.lang.Object r8 = r7.s(r2, r4, r0)
            if (r8 != r1) goto L9d
        L9c:
            return r1
        L9d:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.Z(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c0(long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$1) r0
            int r1 = r0.f124620f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124620f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f124618c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124620f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r11 = r0.f124617b
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            kotlin.ResultKt.b(r13)
            goto L5b
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            kotlin.ResultKt.b(r13)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$ActivityTransition$Unchanged r13 = cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.ActivityTransition.Unchanged.f124591a
            r5.f140144a = r13
            androidx.datastore.core.DataStore r13 = r10.l()
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$2 r4 = new cz.mobilesoft.coreblock.storage.datastore.StreakDataStore$reconcileOpenSession$2
            r9 = 0
            r6 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.f124617b = r5
            r0.f124616a = r7
            r0.f124620f = r3
            java.lang.Object r11 = androidx.datastore.preferences.core.PreferencesKt.a(r13, r4, r0)
            if (r11 != r1) goto L5a
            return r1
        L5a:
            r11 = r5
        L5b:
            java.lang.Object r11 = r11.f140144a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.StreakDataStore.c0(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object f0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.a4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object g0(Continuation continuation) {
        Object objS = s(DataStoreKeysKt.b4(), Boxing.a(true), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object h0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.c4(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object i0(String str, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.d4(), str, continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object j0(boolean z2, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.f4(), Boxing.a(z2), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }

    public final Object k0(int i3, Continuation continuation) {
        Object objS = s(DataStoreKeysKt.g4(), Boxing.d(i3), continuation);
        return objS == IntrinsicsKt.f() ? objS : Unit.f139807a;
    }
}
