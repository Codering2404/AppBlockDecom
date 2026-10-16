package androidx.room.support;

import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
public final class AutoCloser {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f52733l = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Watch f52734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SupportSQLiteOpenHelper f52735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CoroutineScope f52736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f52737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f52738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f52739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f52740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicLong f52741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private SupportSQLiteDatabase f52742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f52743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Job f52744k;

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
    public interface Watch {
        long a();
    }

    public AutoCloser(long j3, TimeUnit timeUnit, Watch watch) {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics.checkNotNullParameter(watch, "watch");
        this.f52734a = watch;
        this.f52738e = new Object();
        this.f52739f = timeUnit.toMillis(j3);
        this.f52740g = new AtomicInteger(0);
        this.f52741h = new AtomicLong(watch.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b() {
        return SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        synchronized (this.f52738e) {
            try {
                if (this.f52734a.a() - this.f52741h.get() < this.f52739f) {
                    return;
                }
                if (this.f52740g.get() != 0) {
                    return;
                }
                Function0 function0 = this.f52737d;
                if (function0 == null) {
                    throw new IllegalStateException("onAutoCloseCallback is null but it should  have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                function0.invoke();
                SupportSQLiteDatabase supportSQLiteDatabase = this.f52742i;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    supportSQLiteDatabase.close();
                }
                this.f52742i = null;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this.f52738e) {
            try {
                this.f52743j = true;
                Job job = this.f52744k;
                if (job != null) {
                    Job.DefaultImpls.b(job, null, 1, null);
                }
                this.f52744k = null;
                SupportSQLiteDatabase supportSQLiteDatabase = this.f52742i;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                this.f52742i = null;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        CoroutineScope coroutineScope;
        int iDecrementAndGet = this.f52740g.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Unbalanced reference count.");
        }
        this.f52741h.set(this.f52734a.a());
        if (iDecrementAndGet == 0) {
            CoroutineScope coroutineScope2 = this.f52736c;
            if (coroutineScope2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coroutineScope");
                coroutineScope = null;
            } else {
                coroutineScope = coroutineScope2;
            }
            this.f52744k = BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AutoCloser$decrementCountAndScheduleClose$2(this, null), 3, null);
        }
    }

    public final Object h(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(j());
        } finally {
            g();
        }
    }

    public final SupportSQLiteDatabase i() {
        return this.f52742i;
    }

    public final SupportSQLiteDatabase j() {
        Job job = this.f52744k;
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = null;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f52744k = null;
        this.f52740g.incrementAndGet();
        if (this.f52743j) {
            throw new IllegalStateException("Attempting to open already closed database.");
        }
        synchronized (this.f52738e) {
            SupportSQLiteDatabase supportSQLiteDatabase = this.f52742i;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return supportSQLiteDatabase;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.f52735b;
            if (supportSQLiteOpenHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
            } else {
                supportSQLiteOpenHelper = supportSQLiteOpenHelper2;
            }
            SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
            this.f52742i = writableDatabase;
            return writableDatabase;
        }
    }

    public final void k(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f52736c = coroutineScope;
    }

    public final void l(SupportSQLiteOpenHelper delegateOpenHelper) {
        Intrinsics.checkNotNullParameter(delegateOpenHelper, "delegateOpenHelper");
        if (delegateOpenHelper instanceof AutoClosingRoomOpenHelper) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.f52735b = delegateOpenHelper;
    }

    public final boolean m() {
        return !this.f52743j;
    }

    public final void n(Function0 onAutoClose) {
        Intrinsics.checkNotNullParameter(onAutoClose, "onAutoClose");
        this.f52737d = onAutoClose;
    }

    public /* synthetic */ AutoCloser(long j3, TimeUnit timeUnit, Watch watch, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, timeUnit, (i3 & 4) != 0 ? new Watch() { // from class: androidx.room.support.a
            @Override // androidx.room.support.AutoCloser.Watch
            public final long a() {
                return AutoCloser.b();
            }
        } : watch);
    }
}
