package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RoomDatabase f52365l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final InvalidationLiveDataContainer f52366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f52367n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final InvalidationTracker.Observer f52368o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f52369p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f52370q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f52371r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final CoroutineContext f52372s;

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z2, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(roomDatabase, invalidationLiveDataContainer, z2, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        boolean zH = h();
        if (this.f52369p.compareAndSet(false, true) && zH) {
            BuildersKt__Builders_commonKt.d(this.f52365l.getCoroutineScope(), this.f52372s, null, new RoomTrackingLiveData$invalidated$1(this, null), 2, null);
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void l() {
        super.l();
        this.f52366m.c(this);
        BuildersKt__Builders_commonKt.d(this.f52365l.getCoroutineScope(), this.f52372s, null, new RoomTrackingLiveData$onActive$1(this, null), 2, null);
    }

    @Override // androidx.lifecycle.LiveData
    protected void m() {
        super.m();
        this.f52366m.d(this);
    }

    public abstract Object s(Continuation continuation);

    protected final RoomDatabase t() {
        return this.f52365l;
    }

    protected final boolean u() {
        return this.f52367n;
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z2, String[] strArr) {
        this.f52365l = roomDatabase;
        this.f52366m = invalidationLiveDataContainer;
        this.f52367n = z2;
        this.f52368o = new RoomTrackingLiveData$observer$1(strArr, this);
        this.f52369p = new AtomicBoolean(true);
        this.f52370q = new AtomicBoolean(false);
        this.f52371r = new AtomicBoolean(false);
        this.f52372s = roomDatabase.inCompatibilityMode() ? z2 ? roomDatabase.getTransactionContext$room_runtime() : roomDatabase.getQueryContext() : EmptyCoroutineContext.f139889a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[Catch: all -> 0x002c, Exception -> 0x002e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:12:0x0028, B:28:0x0060), top: B:45:0x0028, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #1 {all -> 0x002c, blocks: (B:12:0x0028, B:26:0x0058, B:28:0x0060, B:35:0x0078, B:32:0x006d, B:33:0x0075), top: B:45:0x0028, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0056 -> B:26:0x0058). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0087 -> B:40:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.room.RoomTrackingLiveData$refresh$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = (androidx.room.RoomTrackingLiveData$refresh$1) r0
            int r1 = r0.f52381d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f52381d = r1
            goto L18
        L13:
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = new androidx.room.RoomTrackingLiveData$refresh$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f52379b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f52381d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r2 = r0.f52378a
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            goto L58
        L2c:
            r7 = move-exception
            goto L81
        L2e:
            r7 = move-exception
            goto L6d
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            kotlin.ResultKt.b(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.f52371r
            boolean r7 = r7.compareAndSet(r3, r4)
            if (r7 == 0) goto L4e
            androidx.room.RoomDatabase r7 = r6.f52365l
            androidx.room.InvalidationTracker r7 = r7.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r2 = r6.f52368o
            r7.m(r2)
        L4e:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.f52370q
            boolean r7 = r7.compareAndSet(r3, r4)
            if (r7 == 0) goto L87
            r7 = 0
            r2 = r3
        L58:
            java.util.concurrent.atomic.AtomicBoolean r5 = r6.f52369p     // Catch: java.lang.Throwable -> L2c
            boolean r5 = r5.compareAndSet(r4, r3)     // Catch: java.lang.Throwable -> L2c
            if (r5 == 0) goto L76
            r0.f52378a = r4     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r0.f52381d = r4     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.lang.Object r7 = r6.s(r0)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r7 != r1) goto L6b
            return r1
        L6b:
            r2 = r4
            goto L58
        L6d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2c
            r1 = 0
            java.lang.String r1 = com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY.ssmNlIR     // Catch: java.lang.Throwable -> L2c
            r0.<init>(r1, r7)     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.lang.Throwable -> L2c
        L76:
            if (r2 == 0) goto L7b
            r6.n(r7)     // Catch: java.lang.Throwable -> L2c
        L7b:
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.f52370q
            r7.set(r3)
            goto L88
        L81:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f52370q
            r0.set(r3)
            throw r7
        L87:
            r2 = r3
        L88:
            if (r2 == 0) goto L92
            java.util.concurrent.atomic.AtomicBoolean r7 = r6.f52369p
            boolean r7 = r7.get()
            if (r7 != 0) goto L4e
        L92:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.w(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
