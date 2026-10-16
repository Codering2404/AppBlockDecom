package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class LockFreeTaskQueueCore<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f142460e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142461f = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f142462g = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Symbol f142463h = new Symbol("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f142464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f142465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f142466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f142467d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(long j3) {
            return (j3 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j3, int i3) {
            return d(j3, 1073741823L) | ((long) i3);
        }

        public final long c(long j3, int i3) {
            return d(j3, 1152921503533105152L) | (((long) i3) << 30);
        }

        public final long d(long j3, long j4) {
            return j3 & (~j4);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Placeholder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f142468a;

        public Placeholder(int i3) {
            this.f142468a = i3;
        }
    }

    public LockFreeTaskQueueCore(int i3, boolean z2) {
        this.f142464a = i3;
        this.f142465b = z2;
        int i4 = i3 - 1;
        this.f142466c = i4;
        this.f142467d = new AtomicReferenceArray(i3);
        if (i4 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i3 & i4) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore b(long j3) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(this.f142464a * 2, this.f142465b);
        int i3 = (int) (1073741823 & j3);
        int i4 = (int) ((1152921503533105152L & j3) >> 30);
        while (true) {
            int i5 = this.f142466c;
            if ((i3 & i5) == (i5 & i4)) {
                f142462g.set(lockFreeTaskQueueCore, f142460e.d(j3, 1152921504606846976L));
                return lockFreeTaskQueueCore;
            }
            Object placeholder = f().get(this.f142466c & i3);
            if (placeholder == null) {
                placeholder = new Placeholder(i3);
            }
            lockFreeTaskQueueCore.f().set(lockFreeTaskQueueCore.f142466c & i3, placeholder);
            i3++;
        }
    }

    private final LockFreeTaskQueueCore c(long j3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142461f;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            androidx.concurrent.futures.a.a(f142461f, this, null, b(j3));
        }
    }

    private final LockFreeTaskQueueCore e(int i3, Object obj) {
        Object obj2 = f().get(this.f142466c & i3);
        if (!(obj2 instanceof Placeholder) || ((Placeholder) obj2).f142468a != i3) {
            return null;
        }
        f().set(i3 & this.f142466c, obj);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f142467d;
    }

    private final long k() {
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142462g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if ((j3 & 1152921504606846976L) != 0) {
                return j3;
            }
            j4 = 1152921504606846976L | j3;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j4));
        return j4;
    }

    private final LockFreeTaskQueueCore n(int i3, int i4) {
        long j3;
        int i5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142462g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            i5 = (int) (1073741823 & j3);
            if ((1152921504606846976L & j3) != 0) {
                return l();
            }
        } while (!f142462g.compareAndSet(this, j3, f142460e.b(j3, i4)));
        f().set(this.f142466c & i5, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r13 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f142460e
            int r13 = r13.a(r3)
            return r13
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f142466c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.f142465b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.f142464a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r5 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f142460e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L4
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f()
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L8b
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.l()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.e(r9, r13)
            if (r0 != 0) goto L72
        L8b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142462g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if ((j3 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j3) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, 2305843009213693952L | j3));
        return true;
    }

    public final int g() {
        long j3 = f142462g.get(this);
        return (((int) ((j3 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j3))) & 1073741823;
    }

    public final boolean j() {
        long j3 = f142462g.get(this);
        return ((int) (1073741823 & j3)) == ((int) ((j3 & 1152921503533105152L) >> 30));
    }

    public final LockFreeTaskQueueCore l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f142462g;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j3) != 0) {
                return f142463h;
            }
            int i3 = (int) (1073741823 & j3);
            int i4 = this.f142466c;
            if ((((int) ((1152921503533105152L & j3) >> 30)) & i4) == (i4 & i3)) {
                return null;
            }
            Object obj = f().get(this.f142466c & i3);
            if (obj == null) {
                if (this.f142465b) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                int i5 = (i3 + 1) & 1073741823;
                if (f142462g.compareAndSet(this, j3, f142460e.b(j3, i5))) {
                    f().set(this.f142466c & i3, null);
                    return obj;
                }
                if (this.f142465b) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreN = this;
                    do {
                        lockFreeTaskQueueCoreN = lockFreeTaskQueueCoreN.n(i3, i5);
                    } while (lockFreeTaskQueueCoreN != null);
                    return obj;
                }
            }
        }
    }
}
