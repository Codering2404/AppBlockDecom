package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public class InvalidationTracker {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f52172o = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f52173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f52174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f52175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f52176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TriggerBasedInvalidationTracker f52177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f52178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ReentrantLock f52179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AutoCloser f52180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0 f52181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function0 f52182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final InvalidationLiveDataContainer f52183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Intent f52184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MultiInstanceInvalidationClient f52185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f52186n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MultiInstanceClientInitState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f52187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f52188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Intent f52189c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) obj;
            return Intrinsics.areEqual(this.f52187a, multiInstanceClientInitState.f52187a) && Intrinsics.areEqual(this.f52188b, multiInstanceClientInitState.f52188b) && Intrinsics.areEqual(this.f52189c, multiInstanceClientInitState.f52189c);
        }

        public int hashCode() {
            return (((this.f52187a.hashCode() * 31) + this.f52188b.hashCode()) * 31) + this.f52189c.hashCode();
        }

        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.f52187a + ", name=" + this.f52188b + ", serviceIntent=" + this.f52189c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f52190a;

        public Observer(String[] tables) {
            Intrinsics.checkNotNullParameter(tables, "tables");
            this.f52190a = tables;
        }

        public final String[] a() {
            return this.f52190a;
        }

        public boolean b() {
            return false;
        }

        public abstract void c(Set set);
    }

    public InvalidationTracker(RoomDatabase database, Map shadowTablesMap, Map viewTables, String... tableNames) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(shadowTablesMap, "shadowTablesMap");
        Intrinsics.checkNotNullParameter(viewTables, "viewTables");
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        this.f52173a = database;
        this.f52174b = shadowTablesMap;
        this.f52175c = viewTables;
        this.f52176d = tableNames;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(database, shadowTablesMap, viewTables, tableNames, database.getUseTempTrackingTable$room_runtime(), new InvalidationTracker$implementation$1(this));
        this.f52177e = triggerBasedInvalidationTracker;
        this.f52178f = new LinkedHashMap();
        this.f52179g = new ReentrantLock();
        this.f52181i = new Function0() { // from class: androidx.room.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InvalidationTracker.z(this.f52486a);
            }
        };
        this.f52182j = new Function0() { // from class: androidx.room.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InvalidationTracker.y(this.f52487a);
            }
        };
        this.f52183k = new InvalidationLiveDataContainer(database);
        this.f52186n = new Object();
        triggerBasedInvalidationTracker.v(new Function0() { // from class: androidx.room.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(InvalidationTracker.d(this.f52651a));
            }
        });
    }

    private final boolean F(Observer observer) {
        ReentrantLock reentrantLock = this.f52179g;
        reentrantLock.lock();
        try {
            ObserverWrapper observerWrapper = (ObserverWrapper) this.f52178f.remove(observer);
            return observerWrapper != null && this.f52177e.q(observerWrapper.b());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.f52173a.inCompatibilityMode() || invalidationTracker.f52173a.isOpenInternal$room_runtime();
    }

    private final boolean k(Observer observer) {
        Pair pairZ = this.f52177e.z(observer.a());
        String[] strArr = (String[]) pairZ.a();
        int[] iArr = (int[]) pairZ.b();
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr);
        ReentrantLock reentrantLock = this.f52179g;
        reentrantLock.lock();
        try {
            ObserverWrapper observerWrapper2 = this.f52178f.containsKey(observer) ? (ObserverWrapper) MapsKt.getValue(this.f52178f, observer) : (ObserverWrapper) this.f52178f.put(observer, observerWrapper);
            reentrantLock.unlock();
            return observerWrapper2 == null && this.f52177e.p(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final List q() {
        ReentrantLock reentrantLock = this.f52179g;
        reentrantLock.lock();
        try {
            return CollectionsKt.toList(this.f52178f.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Set set) {
        ReentrantLock reentrantLock = this.f52179g;
        reentrantLock.lock();
        try {
            List list = CollectionsKt.toList(this.f52178f.values());
            reentrantLock.unlock();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ObserverWrapper) it.next()).c(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        synchronized (this.f52186n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f52185m;
                if (multiInstanceInvalidationClient != null) {
                    List listQ = q();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listQ) {
                        if (!((Observer) obj).b()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.l();
                    }
                }
                this.f52177e.t();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.f52180h;
        if (autoCloser != null) {
            autoCloser.g();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.f52180h;
        if (autoCloser != null) {
            autoCloser.j();
        }
        return Unit.f139807a;
    }

    public final Object A(String[] strArr, Continuation continuation) {
        return this.f52177e.r(strArr, this.f52181i, this.f52182j, continuation);
    }

    public final void B() {
        this.f52177e.s(this.f52181i, this.f52182j);
    }

    public void C() {
        this.f52177e.s(this.f52181i, this.f52182j);
    }

    public void D() {
        RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$refreshVersionsSync$1(this, null));
    }

    public void E(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (F(observer)) {
            RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$removeObserver$1(this, null));
        }
    }

    public final void G(AutoCloser autoCloser) {
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.f52180h = autoCloser;
        autoCloser.n(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void H() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f52185m;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.l();
        }
    }

    public final Object I(Continuation continuation) throws Throwable {
        Object objY = this.f52177e.y(continuation);
        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
    }

    public final void J() {
        RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$syncBlocking$1(this, null));
    }

    public void j(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (k(observer)) {
            RunBlockingUninterruptible_androidKt.a(new InvalidationTracker$addObserver$1(this, null));
        }
    }

    public final void l(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!observer.b()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        k(observer);
    }

    public void m(Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        j(new WeakObserver(this, observer));
    }

    public final Flow n(String[] tables, boolean z2) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        Pair pairZ = this.f52177e.z(tables);
        String[] strArr = (String[]) pairZ.a();
        Flow flowM = this.f52177e.m(strArr, (int[]) pairZ.b(), z2);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f52185m;
        Flow flowH = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.h(strArr) : null;
        return flowH != null ? FlowKt.T(flowM, flowH) : flowM;
    }

    public LiveData o(String[] tableNames, boolean z2, Callable computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        this.f52177e.z(tableNames);
        return this.f52183k.a(tableNames, z2, computeFunction);
    }

    public final LiveData p(String[] tableNames, boolean z2, Function1 computeFunction) {
        Intrinsics.checkNotNullParameter(tableNames, "tableNames");
        Intrinsics.checkNotNullParameter(computeFunction, "computeFunction");
        this.f52177e.z(tableNames);
        return this.f52183k.b(tableNames, z2, computeFunction);
    }

    public final RoomDatabase r() {
        return this.f52173a;
    }

    public final String[] s() {
        return this.f52176d;
    }

    public final void t(Context context, String name, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceIntent, "serviceIntent");
        this.f52184l = serviceIntent;
        this.f52185m = new MultiInstanceInvalidationClient(context, name, this);
    }

    public final void u(SQLiteConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f52177e.l(connection);
        synchronized (this.f52186n) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.f52185m;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.f52184l;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.k(intent);
                    Unit unit = Unit.f139807a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(Set tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        ReentrantLock reentrantLock = this.f52179g;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> list = CollectionsKt.toList(this.f52178f.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : list) {
                if (!observerWrapper.a().b()) {
                    observerWrapper.d(tables);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
