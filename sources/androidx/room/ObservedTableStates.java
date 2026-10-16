package androidx.room;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ObservedTableStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReentrantLock f52230a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f52231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f52232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f52233d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ObserveOp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ObserveOp f52234a = new ObserveOp("NO_OP", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ObserveOp f52235b = new ObserveOp("ADD", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ObserveOp f52236c = new ObserveOp("REMOVE", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ ObserveOp[] f52237d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f52238f;

        static {
            ObserveOp[] observeOpArrA = a();
            f52237d = observeOpArrA;
            f52238f = EnumEntriesKt.a(observeOpArrA);
        }

        private ObserveOp(String str, int i3) {
        }

        private static final /* synthetic */ ObserveOp[] a() {
            return new ObserveOp[]{f52234a, f52235b, f52236c};
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) f52237d.clone();
        }
    }

    public ObservedTableStates(int i3) {
        this.f52231b = new long[i3];
        this.f52232c = new boolean[i3];
    }

    public final void f() {
        ReentrantLock reentrantLock = this.f52230a;
        reentrantLock.lock();
        try {
            this.f52233d = true;
            Unit unit = Unit.f139807a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(int[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r12.f52230a
            r0.lock()
            int r1 = r13.length     // Catch: java.lang.Throwable -> L26
            r2 = 0
            r3 = r2
            r4 = r3
        Le:
            r5 = 1
            if (r3 >= r1) goto L2b
            r6 = r13[r3]     // Catch: java.lang.Throwable -> L26
            long[] r7 = r12.f52231b     // Catch: java.lang.Throwable -> L26
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L26
            r10 = 1
            long r10 = r10 + r8
            r7[r6] = r10     // Catch: java.lang.Throwable -> L26
            r6 = 0
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L28
            r12.f52233d = r5     // Catch: java.lang.Throwable -> L26
            r4 = r5
            goto L28
        L26:
            r13 = move-exception
            goto L36
        L28:
            int r3 = r3 + 1
            goto Le
        L2b:
            if (r4 != 0) goto L31
            boolean r13 = r12.f52233d     // Catch: java.lang.Throwable -> L26
            if (r13 == 0) goto L32
        L31:
            r2 = r5
        L32:
            r0.unlock()
            return r2
        L36:
            r0.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.g(int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean h(int[] r15) {
        /*
            r14 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r14.f52230a
            r0.lock()
            int r1 = r15.length     // Catch: java.lang.Throwable -> L25
            r2 = 0
            r3 = r2
            r4 = r3
        Le:
            r5 = 1
            if (r3 >= r1) goto L2a
            r6 = r15[r3]     // Catch: java.lang.Throwable -> L25
            long[] r7 = r14.f52231b     // Catch: java.lang.Throwable -> L25
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L25
            r10 = 1
            long r12 = r8 - r10
            r7[r6] = r12     // Catch: java.lang.Throwable -> L25
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L27
            r14.f52233d = r5     // Catch: java.lang.Throwable -> L25
            r4 = r5
            goto L27
        L25:
            r15 = move-exception
            goto L35
        L27:
            int r3 = r3 + 1
            goto Le
        L2a:
            if (r4 != 0) goto L30
            boolean r15 = r14.f52233d     // Catch: java.lang.Throwable -> L25
            if (r15 == 0) goto L31
        L30:
            r2 = r5
        L31:
            r0.unlock()
            return r2
        L35:
            r0.unlock()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.h(int[]):boolean");
    }

    public final void i() {
        ReentrantLock reentrantLock = this.f52230a;
        reentrantLock.lock();
        try {
            ArraysKt.fill$default(this.f52232c, false, 0, 0, 6, (Object) null);
            this.f52233d = true;
            Unit unit = Unit.f139807a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
