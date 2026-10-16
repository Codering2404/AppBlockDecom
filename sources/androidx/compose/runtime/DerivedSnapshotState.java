package androidx.compose.runtime;

import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.Utils_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class DerivedSnapshotState<T> extends StateObjectImpl implements DerivedState<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f23860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SnapshotMutationPolicy f23861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ResultRecord f23862d = new ResultRecord(SnapshotKt.I().i());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Companion f23863h = new Companion(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f23864i = 8;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f23865j = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f23867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ObjectIntMap f23868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Object f23869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f23870g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a() {
                return ResultRecord.f23865j;
            }

            private Companion() {
            }
        }

        public ResultRecord(long j3) {
            super(j3);
            this.f23868e = ObjectIntMapKt.a();
            this.f23869f = f23865j;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public Object a() {
            return this.f23869f;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap b() {
            return this.f23868e;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            n(resultRecord.b());
            this.f23869f = resultRecord.f23869f;
            this.f23870g = resultRecord.f23870g;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(SnapshotKt.I().i());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new ResultRecord(j3);
        }

        public final Object k() {
            return this.f23869f;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean l(androidx.compose.runtime.DerivedState r6, androidx.compose.runtime.snapshots.Snapshot r7) {
            /*
                r5 = this;
                java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.J()
                monitor-enter(r0)
                long r1 = r5.f23866c     // Catch: java.lang.Throwable -> L1c
                long r3 = r7.i()     // Catch: java.lang.Throwable -> L1c
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L1e
                int r1 = r5.f23867d     // Catch: java.lang.Throwable -> L1c
                int r4 = r7.j()     // Catch: java.lang.Throwable -> L1c
                if (r1 == r4) goto L1a
                goto L1e
            L1a:
                r1 = r3
                goto L1f
            L1c:
                r6 = move-exception
                goto L4f
            L1e:
                r1 = r2
            L1f:
                monitor-exit(r0)
                java.lang.Object r0 = r5.f23869f
                java.lang.Object r4 = androidx.compose.runtime.DerivedSnapshotState.ResultRecord.f23865j
                if (r0 == r4) goto L31
                if (r1 == 0) goto L32
                int r0 = r5.f23870g
                int r6 = r5.m(r6, r7)
                if (r0 != r6) goto L31
                goto L32
            L31:
                r2 = r3
            L32:
                if (r2 == 0) goto L4e
                if (r1 == 0) goto L4e
                java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotKt.J()
                monitor-enter(r6)
                long r0 = r7.i()     // Catch: java.lang.Throwable -> L4b
                r5.f23866c = r0     // Catch: java.lang.Throwable -> L4b
                int r7 = r7.j()     // Catch: java.lang.Throwable -> L4b
                r5.f23867d = r7     // Catch: java.lang.Throwable -> L4b
                kotlin.Unit r7 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r6)
                return r2
            L4b:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            L4e:
                return r2
            L4f:
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.ResultRecord.l(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):boolean");
        }

        public final int m(DerivedState derivedState, Snapshot snapshot) {
            ObjectIntMap objectIntMapB;
            int iA;
            int i3;
            int i4;
            int i5;
            synchronized (SnapshotKt.J()) {
                objectIntMapB = b();
            }
            int i6 = 7;
            if (!objectIntMapB.h()) {
                return 7;
            }
            MutableVector mutableVectorC = SnapshotStateKt.c();
            Object[] objArr = mutableVectorC.f24389a;
            int iO = mutableVectorC.o();
            for (int i7 = 0; i7 < iO; i7++) {
                ((DerivedStateObserver) objArr[i7]).b(derivedState);
            }
            try {
                Object[] objArr2 = objectIntMapB.f3076b;
                int[] iArr = objectIntMapB.f3077c;
                long[] jArr = objectIntMapB.f3075a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    iA = 7;
                    int i8 = 0;
                    while (true) {
                        long j3 = jArr[i8];
                        if ((((~j3) << i6) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i9 = 8;
                            int i10 = 8 - ((~(i8 - length)) >>> 31);
                            int i11 = 0;
                            while (i11 < i10) {
                                if ((j3 & 255) < 128) {
                                    int i12 = (i8 << 3) + i11;
                                    i4 = i6;
                                    StateObject stateObject = (StateObject) objArr2[i12];
                                    i5 = i9;
                                    if (iArr[i12] == 1) {
                                        StateRecord stateRecordV = stateObject instanceof DerivedSnapshotState ? ((DerivedSnapshotState) stateObject).v(snapshot) : SnapshotKt.H(stateObject.p(), snapshot);
                                        iA = (((iA * 31) + Utils_jvmKt.a(stateRecordV)) * 31) + Long.hashCode(stateRecordV.g());
                                    }
                                } else {
                                    i4 = i6;
                                    i5 = i9;
                                }
                                j3 >>= i5;
                                i11++;
                                i9 = i5;
                                i6 = i4;
                            }
                            i3 = i6;
                            if (i10 != i9) {
                                break;
                            }
                        } else {
                            i3 = i6;
                        }
                        if (i8 == length) {
                            i6 = iA;
                            break;
                        }
                        i8++;
                        i6 = i3;
                    }
                }
                iA = i6;
                Unit unit = Unit.f139807a;
                Object[] objArr3 = mutableVectorC.f24389a;
                int iO2 = mutableVectorC.o();
                for (int i13 = 0; i13 < iO2; i13++) {
                    ((DerivedStateObserver) objArr3[i13]).a(derivedState);
                }
                return iA;
            } catch (Throwable th) {
                Object[] objArr4 = mutableVectorC.f24389a;
                int iO3 = mutableVectorC.o();
                for (int i14 = 0; i14 < iO3; i14++) {
                    ((DerivedStateObserver) objArr4[i14]).a(derivedState);
                }
                throw th;
            }
        }

        public void n(ObjectIntMap objectIntMap) {
            this.f23868e = objectIntMap;
        }

        public final void o(Object obj) {
            this.f23869f = obj;
        }

        public final void p(int i3) {
            this.f23870g = i3;
        }

        public final void q(long j3) {
            this.f23866c = j3;
        }

        public final void r(int i3) {
            this.f23867d = i3;
        }
    }

    public DerivedSnapshotState(Function0 function0, SnapshotMutationPolicy snapshotMutationPolicy) {
        this.f23860b = function0;
        this.f23861c = snapshotMutationPolicy;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.runtime.DerivedSnapshotState.ResultRecord w(androidx.compose.runtime.DerivedSnapshotState.ResultRecord r22, androidx.compose.runtime.snapshots.Snapshot r23, boolean r24, kotlin.jvm.functions.Function0 r25) {
        /*
            Method dump skipped, instruction units count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedSnapshotState.w(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    private final String x() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.G(this.f23862d);
        return resultRecord.l(this, Snapshot.f24914e.c()) ? String.valueOf(resultRecord.k()) : "<Not calculated>";
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy f() {
        return this.f23861c;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        Snapshot.Companion companion = Snapshot.f24914e;
        Function1 function1G = companion.c().g();
        if (function1G != null) {
            function1G.invoke(this);
        }
        Snapshot snapshotC = companion.c();
        return w((ResultRecord) SnapshotKt.H(this.f23862d, snapshotC), snapshotC, true, this.f23860b).k();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.f23862d = (ResultRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f23862d;
    }

    public String toString() {
        return "DerivedState(value=" + x() + ")@" + hashCode();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record u() {
        Snapshot snapshotC = Snapshot.f24914e.c();
        return w((ResultRecord) SnapshotKt.H(this.f23862d, snapshotC), snapshotC, false, this.f23860b);
    }

    public final StateRecord v(Snapshot snapshot) {
        return w((ResultRecord) SnapshotKt.H(this.f23862d, snapshot), snapshot, false, this.f23860b);
    }
}
