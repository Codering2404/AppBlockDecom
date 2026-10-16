package androidx.compose.runtime.snapshots;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

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
public final class SnapshotIdSet implements Iterable<Long>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f24931f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SnapshotIdSet f24932g = new SnapshotIdSet(0, 0, 0, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f24933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f24935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long[] f24936d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet a() {
            return SnapshotIdSet.f24932g;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {252, Function.MAX_NARGS, 263}, m = "invokeSuspend")
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Long>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f24937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24940d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f24941f;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(continuation);
            anonymousClass1.f24941f = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
        
            if (r15.a(r4, r20) == r1) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b5, code lost:
        
            if (r13.a(r4, r20) == r1) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:19:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009b -> B:30:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b5 -> B:30:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d3 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f2 -> B:42:0x00f3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 249
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private SnapshotIdSet(long j3, long j4, long j5, long[] jArr) {
        this.f24933a = j3;
        this.f24934b = j4;
        this.f24935c = j5;
        this.f24936d = jArr;
    }

    public final SnapshotIdSet g(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSetH;
        SnapshotIdSet snapshotIdSet2 = f24932g;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        long j3 = snapshotIdSet.f24935c;
        long j4 = this.f24935c;
        if (j3 == j4) {
            long[] jArr = snapshotIdSet.f24936d;
            long[] jArr2 = this.f24936d;
            if (jArr == jArr2) {
                return new SnapshotIdSet((~snapshotIdSet.f24933a) & this.f24933a, (~snapshotIdSet.f24934b) & this.f24934b, j4, jArr2);
            }
        }
        long[] jArr3 = snapshotIdSet.f24936d;
        if (jArr3 != null) {
            snapshotIdSetH = this;
            for (long j5 : jArr3) {
                snapshotIdSetH = snapshotIdSetH.h(j5);
            }
        } else {
            snapshotIdSetH = this;
        }
        if (snapshotIdSet.f24934b != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((snapshotIdSet.f24934b & (1 << i3)) != 0) {
                    snapshotIdSetH = snapshotIdSetH.h(snapshotIdSet.f24935c + ((long) i3));
                }
            }
        }
        if (snapshotIdSet.f24933a != 0) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((snapshotIdSet.f24933a & (1 << i4)) != 0) {
                    snapshotIdSetH = snapshotIdSetH.h(snapshotIdSet.f24935c + ((long) i4) + ((long) 64));
                }
            }
        }
        return snapshotIdSetH;
    }

    public final SnapshotIdSet h(long j3) {
        long[] jArr;
        int iA;
        long j4 = this.f24935c;
        long j5 = j3 - j4;
        if (j5 >= 0 && j5 < 64) {
            long j6 = 1 << ((int) j5);
            long j7 = this.f24934b;
            if ((j7 & j6) != 0) {
                return new SnapshotIdSet(this.f24933a, j7 & (~j6), j4, this.f24936d);
            }
        } else if (j5 >= 64 && j5 < 128) {
            long j8 = 1 << (((int) j5) - 64);
            long j9 = this.f24933a;
            if ((j9 & j8) != 0) {
                return new SnapshotIdSet(j9 & (~j8), this.f24934b, j4, this.f24936d);
            }
        } else if (j5 < 0 && (jArr = this.f24936d) != null && (iA = SnapshotId_jvmKt.a(jArr, j3)) >= 0) {
            return new SnapshotIdSet(this.f24933a, this.f24934b, this.f24935c, SnapshotId_jvmKt.e(jArr, iA));
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return SequencesKt.b(new AnonymousClass1(null)).iterator();
    }

    public final boolean l(long j3) {
        long[] jArr;
        long j4 = j3 - this.f24935c;
        return (j4 < 0 || j4 >= 64) ? (j4 < 64 || j4 >= 128) ? j4 <= 0 && (jArr = this.f24936d) != null && SnapshotId_jvmKt.a(jArr, j3) >= 0 : ((1 << (((int) j4) + (-64))) & this.f24933a) != 0 : ((1 << ((int) j4)) & this.f24934b) != 0;
    }

    public final long n(long j3) {
        long[] jArr = this.f24936d;
        if (jArr != null) {
            return jArr[0];
        }
        long j4 = this.f24934b;
        if (j4 != 0) {
            return this.f24935c + ((long) Long.numberOfTrailingZeros(j4));
        }
        long j5 = this.f24933a;
        return j5 != 0 ? this.f24935c + ((long) 64) + ((long) Long.numberOfTrailingZeros(j5)) : j3;
    }

    public final SnapshotIdSet o(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSetP;
        SnapshotIdSet snapshotIdSet2 = f24932g;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet;
        }
        long j3 = snapshotIdSet.f24935c;
        long j4 = this.f24935c;
        if (j3 == j4) {
            long[] jArr = snapshotIdSet.f24936d;
            long[] jArr2 = this.f24936d;
            if (jArr == jArr2) {
                return new SnapshotIdSet(snapshotIdSet.f24933a | this.f24933a, snapshotIdSet.f24934b | this.f24934b, j4, jArr2);
            }
        }
        int i3 = 0;
        if (this.f24936d == null) {
            long[] jArr3 = this.f24936d;
            if (jArr3 != null) {
                for (long j5 : jArr3) {
                    snapshotIdSet = snapshotIdSet.p(j5);
                }
            }
            if (this.f24934b != 0) {
                for (int i4 = 0; i4 < 64; i4++) {
                    if ((this.f24934b & (1 << i4)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(this.f24935c + ((long) i4));
                    }
                }
            }
            if (this.f24933a != 0) {
                while (i3 < 64) {
                    if ((this.f24933a & (1 << i3)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(this.f24935c + ((long) i3) + ((long) 64));
                    }
                    i3++;
                }
            }
            return snapshotIdSet;
        }
        long[] jArr4 = snapshotIdSet.f24936d;
        if (jArr4 != null) {
            snapshotIdSetP = this;
            for (long j6 : jArr4) {
                snapshotIdSetP = snapshotIdSetP.p(j6);
            }
        } else {
            snapshotIdSetP = this;
        }
        if (snapshotIdSet.f24934b != 0) {
            for (int i5 = 0; i5 < 64; i5++) {
                if ((snapshotIdSet.f24934b & (1 << i5)) != 0) {
                    snapshotIdSetP = snapshotIdSetP.p(snapshotIdSet.f24935c + ((long) i5));
                }
            }
        }
        if (snapshotIdSet.f24933a != 0) {
            while (i3 < 64) {
                if ((snapshotIdSet.f24933a & (1 << i3)) != 0) {
                    snapshotIdSetP = snapshotIdSetP.p(snapshotIdSet.f24935c + ((long) i3) + ((long) 64));
                }
                i3++;
            }
        }
        return snapshotIdSetP;
    }

    public final SnapshotIdSet p(long j3) {
        long j4;
        long j5;
        long[] jArrB;
        long j6 = this.f24935c;
        long j7 = j3 - j6;
        long j8 = 0;
        if (j7 >= 0 && j7 < 64) {
            long j9 = 1 << ((int) j7);
            long j10 = this.f24934b;
            if ((j10 & j9) == 0) {
                return new SnapshotIdSet(this.f24933a, j10 | j9, j6, this.f24936d);
            }
        } else if (j7 >= 64 && j7 < 128) {
            long j11 = 1 << (((int) j7) - 64);
            long j12 = this.f24933a;
            if ((j12 & j11) == 0) {
                return new SnapshotIdSet(j12 | j11, this.f24934b, j6, this.f24936d);
            }
        } else if (j7 < 128) {
            long[] jArr = this.f24936d;
            if (jArr == null) {
                return new SnapshotIdSet(this.f24933a, this.f24934b, j6, new long[]{j3});
            }
            int iA = SnapshotId_jvmKt.a(jArr, j3);
            if (iA < 0) {
                return new SnapshotIdSet(this.f24933a, this.f24934b, this.f24935c, SnapshotId_jvmKt.d(jArr, -(iA + 1), j3));
            }
        } else if (!l(j3)) {
            long j13 = this.f24933a;
            long j14 = this.f24934b;
            long j15 = this.f24935c;
            long j16 = 64;
            long j17 = ((j3 + 1) / j16) * j16;
            if (j17 < 0) {
                j17 = 9223372036854775680L;
            }
            SnapshotIdArrayBuilder snapshotIdArrayBuilder = null;
            long j18 = j13;
            while (true) {
                if (j15 >= j17) {
                    j4 = j14;
                    j5 = j15;
                    break;
                }
                if (j14 != j8) {
                    if (snapshotIdArrayBuilder == null) {
                        snapshotIdArrayBuilder = new SnapshotIdArrayBuilder(this.f24936d);
                    }
                    int i3 = 0;
                    while (i3 < 64) {
                        long j19 = j8;
                        if ((j14 & (1 << i3)) != j8) {
                            snapshotIdArrayBuilder.a(j15 + ((long) i3));
                        }
                        i3++;
                        j8 = j19;
                    }
                }
                j4 = j8;
                if (j18 == j4) {
                    j5 = j17;
                    break;
                }
                j15 += j16;
                j14 = j18;
                j8 = j4;
                j18 = j8;
            }
            if (snapshotIdArrayBuilder == null || (jArrB = snapshotIdArrayBuilder.b()) == null) {
                jArrB = this.f24936d;
            }
            return new SnapshotIdSet(j18, j4, j5, jArrB).p(j3);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator<Long> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().longValue()));
        }
        sb.append(ListUtilsKt.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }
}
