package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class ConstraintTracker<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TaskExecutor f54897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f54898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f54899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet f54900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f54901e;

    protected ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f54897a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f54898b = applicationContext;
        this.f54899c = new Object();
        this.f54900d = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List listenersList, ConstraintTracker this$0) {
        Intrinsics.checkNotNullParameter(listenersList, "$listenersList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = listenersList.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).a(this$0.f54901e);
        }
    }

    public final void c(ConstraintListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f54899c) {
            try {
                if (this.f54900d.add(listener)) {
                    if (this.f54900d.size() == 1) {
                        this.f54901e = e();
                        Logger.e().a(ConstraintTrackerKt.f54902a, getClass().getSimpleName() + ": initial state = " + this.f54901e);
                        h();
                    }
                    listener.a(this.f54901e);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final Context d() {
        return this.f54898b;
    }

    public abstract Object e();

    public final void f(ConstraintListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f54899c) {
            try {
                if (this.f54900d.remove(listener) && this.f54900d.isEmpty()) {
                    i();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(Object obj) {
        synchronized (this.f54899c) {
            Object obj2 = this.f54901e;
            if (obj2 == null || !Intrinsics.areEqual(obj2, obj)) {
                this.f54901e = obj;
                final List list = CollectionsKt.toList(this.f54900d);
                this.f54897a.a().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConstraintTracker.b(list, this);
                    }
                });
                Unit unit = Unit.f139807a;
            }
        }
    }

    public abstract void h();

    public abstract void i();
}
