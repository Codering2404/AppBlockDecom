package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MultiInstanceInvalidationClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f52199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InvalidationTracker f52200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f52201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f52202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f52203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f52204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IMultiInstanceInvalidationService f52205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableSharedFlow f52206h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MultiInstanceInvalidationClient$observer$1 f52207i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final IMultiInstanceInvalidationCallback f52208j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ServiceConnection f52209k;

    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.room.MultiInstanceInvalidationClient$observer$1] */
    public MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(invalidationTracker, "invalidationTracker");
        this.f52199a = name;
        this.f52200b = invalidationTracker;
        this.f52201c = context.getApplicationContext();
        this.f52202d = invalidationTracker.r().getCoroutineScope();
        this.f52203e = new AtomicBoolean(true);
        this.f52206h = SharedFlowKt.a(0, 0, BufferOverflow.f141062a);
        final String[] strArrS = invalidationTracker.s();
        this.f52207i = new InvalidationTracker.Observer(strArrS) { // from class: androidx.room.MultiInstanceInvalidationClient$observer$1
            @Override // androidx.room.InvalidationTracker.Observer
            public boolean b() {
                return true;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void c(Set tables) {
                Intrinsics.checkNotNullParameter(tables, "tables");
                if (this.f52222b.f52203e.get()) {
                    return;
                }
                try {
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.f52222b.f52205g;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.Y1(this.f52222b.f52204f, (String[]) tables.toArray(new String[0]));
                    }
                } catch (RemoteException e3) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e3);
                }
            }
        };
        this.f52208j = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void g0(String[] tables) {
                Intrinsics.checkNotNullParameter(tables, "tables");
                BuildersKt__Builders_commonKt.d(this.f52217a.f52202d, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(tables, this.f52217a, null), 3, null);
            }
        };
        this.f52209k = new ServiceConnection() { // from class: androidx.room.MultiInstanceInvalidationClient$serviceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name2, IBinder service) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                this.f52223a.f52205g = IMultiInstanceInvalidationService.Stub.x3(service);
                this.f52223a.j();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name2) {
                Intrinsics.checkNotNullParameter(name2, "name");
                this.f52223a.f52205g = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.f52205g;
            if (iMultiInstanceInvalidationService != null) {
                this.f52204f = iMultiInstanceInvalidationService.W2(this.f52208j, this.f52199a);
            }
        } catch (RemoteException e3) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e3);
        }
    }

    public final Flow h(final String[] resolvedTableNames) {
        Intrinsics.checkNotNullParameter(resolvedTableNames, "resolvedTableNames");
        final MutableSharedFlow mutableSharedFlow = this.f52206h;
        return new Flow<Set<? extends String>>() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f52212a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ String[] f52213b;

                /* JADX INFO: renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", l = {235}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f52214a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f52215b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f52214a = obj;
                        this.f52215b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, String[] strArr) {
                    this.f52212a = flowCollector;
                    this.f52213b = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f52215b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f52215b = r1
                        goto L18
                    L13:
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.f52214a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f52215b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r12)
                        goto L7c
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        kotlin.ResultKt.b(r12)
                        kotlinx.coroutines.flow.FlowCollector r12 = r10.f52212a
                        java.util.Set r11 = (java.util.Set) r11
                        java.util.Set r2 = kotlin.collections.SetsKt.createSetBuilder()
                        java.lang.String[] r4 = r10.f52213b
                        int r5 = r4.length
                        r6 = 0
                    L40:
                        if (r6 >= r5) goto L64
                        r7 = r4[r6]
                        r8 = r11
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.Iterator r8 = r8.iterator()
                    L4b:
                        boolean r9 = r8.hasNext()
                        if (r9 == 0) goto L61
                        java.lang.Object r9 = r8.next()
                        java.lang.String r9 = (java.lang.String) r9
                        boolean r9 = kotlin.text.StringsKt.F(r7, r9, r3)
                        if (r9 == 0) goto L4b
                        r2.add(r7)
                        goto L4b
                    L61:
                        int r6 = r6 + 1
                        goto L40
                    L64:
                        java.util.Set r11 = kotlin.collections.SetsKt.build(r2)
                        java.util.Collection r11 = (java.util.Collection) r11
                        boolean r2 = r11.isEmpty()
                        if (r2 == 0) goto L71
                        r11 = 0
                    L71:
                        if (r11 == 0) goto L7c
                        r0.f52215b = r3
                        java.lang.Object r11 = r12.emit(r11, r0)
                        if (r11 != r1) goto L7c
                        return r1
                    L7c:
                        kotlin.Unit r11 = kotlin.Unit.f139807a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = mutableSharedFlow.collect(new AnonymousClass2(flowCollector, resolvedTableNames), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    public final InvalidationTracker i() {
        return this.f52200b;
    }

    public final void k(Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        if (this.f52203e.compareAndSet(true, false)) {
            this.f52201c.bindService(serviceIntent, this.f52209k, 1);
            this.f52200b.l(this.f52207i);
        }
    }

    public final void l() {
        if (this.f52203e.compareAndSet(false, true)) {
            this.f52200b.E(this.f52207i);
            try {
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.f52205g;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.d5(this.f52208j, this.f52204f);
                }
            } catch (RemoteException e3) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e3);
            }
            this.f52201c.unbindService(this.f52209k);
        }
    }
}
