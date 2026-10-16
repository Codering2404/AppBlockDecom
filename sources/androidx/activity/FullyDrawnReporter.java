package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FullyDrawnReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f367h;

    public FullyDrawnReporter(Executor executor, Function0 reportFullyDrawn) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(reportFullyDrawn, "reportFullyDrawn");
        this.f360a = executor;
        this.f361b = reportFullyDrawn;
        this.f362c = new Object();
        this.f366g = new ArrayList();
        this.f367h = new Runnable() { // from class: androidx.activity.p
            @Override // java.lang.Runnable
            public final void run() {
                FullyDrawnReporter.h(this.f535a);
            }
        };
    }

    private final void f() {
        if (this.f364e || this.f363d != 0) {
            return;
        }
        this.f364e = true;
        this.f360a.execute(this.f367h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FullyDrawnReporter fullyDrawnReporter) {
        synchronized (fullyDrawnReporter.f362c) {
            try {
                fullyDrawnReporter.f364e = false;
                if (fullyDrawnReporter.f363d == 0 && !fullyDrawnReporter.f365f) {
                    fullyDrawnReporter.f361b.invoke();
                    fullyDrawnReporter.d();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Function0 callback) {
        boolean z2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.f362c) {
            if (this.f365f) {
                z2 = true;
            } else {
                this.f366g.add(callback);
                z2 = false;
            }
        }
        if (z2) {
            callback.invoke();
        }
    }

    public final void c() {
        synchronized (this.f362c) {
            try {
                if (!this.f365f) {
                    this.f363d++;
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.f362c) {
            try {
                this.f365f = true;
                Iterator it = this.f366g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f366g.clear();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f362c) {
            z2 = this.f365f;
        }
        return z2;
    }

    public final void g() {
        int i3;
        synchronized (this.f362c) {
            try {
                if (!this.f365f && (i3 = this.f363d) > 0) {
                    this.f363d = i3 - 1;
                    f();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
