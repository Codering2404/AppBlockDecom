package coil.request;

import android.view.View;
import coil.util.Utils;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

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
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f56156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTargetDisposable f56157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Job f56158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewTargetRequestDelegate f56159d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f56160f;

    public ViewTargetRequestManager(View view) {
        this.f56156a = view;
    }

    public final synchronized void a() {
        try {
            Job job = this.f56158c;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f56158c = BuildersKt__Builders_commonKt.d(GlobalScope.f140958a, Dispatchers.c().w0(), null, new ViewTargetRequestManager$dispose$1(this, null), 2, null);
            this.f56157b = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ViewTargetDisposable b(Deferred deferred) {
        ViewTargetDisposable viewTargetDisposable = this.f56157b;
        if (viewTargetDisposable != null && Utils.s() && this.f56160f) {
            this.f56160f = false;
            viewTargetDisposable.a(deferred);
            return viewTargetDisposable;
        }
        Job job = this.f56158c;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f56158c = null;
        ViewTargetDisposable viewTargetDisposable2 = new ViewTargetDisposable(this.f56156a, deferred);
        this.f56157b = viewTargetDisposable2;
        return viewTargetDisposable2;
    }

    public final void c(ViewTargetRequestDelegate viewTargetRequestDelegate) {
        ViewTargetRequestDelegate viewTargetRequestDelegate2 = this.f56159d;
        if (viewTargetRequestDelegate2 != null) {
            viewTargetRequestDelegate2.a();
        }
        this.f56159d = viewTargetRequestDelegate;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.f56159d;
        if (viewTargetRequestDelegate == null) {
            return;
        }
        this.f56160f = true;
        viewTargetRequestDelegate.c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTargetRequestDelegate viewTargetRequestDelegate = this.f56159d;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.a();
        }
    }
}
