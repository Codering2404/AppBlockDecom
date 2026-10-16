package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
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
public final class RequestService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageLoader f56136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SystemCallbacks f56137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HardwareBitmapService f56138c;

    public RequestService(ImageLoader imageLoader, SystemCallbacks systemCallbacks, Logger logger) {
        this.f56136a = imageLoader;
        this.f56137b = systemCallbacks;
        this.f56138c = HardwareBitmaps.a(logger);
    }

    private final boolean d(ImageRequest imageRequest, Size size) {
        if (Bitmaps.d(imageRequest.j())) {
            return c(imageRequest, imageRequest.j()) && this.f56138c.a(size);
        }
        return true;
    }

    private final boolean e(ImageRequest imageRequest) {
        return imageRequest.O().isEmpty() || ArraysKt.contains(Utils.p(), imageRequest.j());
    }

    public final boolean a(Options options) {
        return !Bitmaps.d(options.f()) || this.f56138c.b();
    }

    public final ErrorResult b(ImageRequest imageRequest, Throwable th) {
        Drawable drawableT;
        if (!(th instanceof NullRequestDataException) || (drawableT = imageRequest.u()) == null) {
            drawableT = imageRequest.t();
        }
        return new ErrorResult(drawableT, imageRequest, th);
    }

    public final boolean c(ImageRequest imageRequest, Bitmap.Config config) {
        if (!Bitmaps.d(config)) {
            return true;
        }
        if (!imageRequest.h()) {
            return false;
        }
        Target targetM = imageRequest.M();
        if (targetM instanceof ViewTarget) {
            View viewA = ((ViewTarget) targetM).a();
            if (viewA.isAttachedToWindow() && !viewA.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public final Options f(ImageRequest imageRequest, Size size) {
        Bitmap.Config configJ = (e(imageRequest) && d(imageRequest, size)) ? imageRequest.j() : Bitmap.Config.ARGB_8888;
        CachePolicy cachePolicyD = this.f56137b.b() ? imageRequest.D() : CachePolicy.DISABLED;
        Dimension dimensionD = size.d();
        Dimension.Undefined undefined = Dimension.Undefined.f56164a;
        return new Options(imageRequest.l(), configJ, imageRequest.k(), size, (Intrinsics.areEqual(dimensionD, undefined) || Intrinsics.areEqual(size.c(), undefined)) ? Scale.FIT : imageRequest.J(), Requests.a(imageRequest), imageRequest.i() && imageRequest.O().isEmpty() && configJ != Bitmap.Config.ALPHA_8, imageRequest.I(), imageRequest.r(), imageRequest.x(), imageRequest.L(), imageRequest.E(), imageRequest.C(), imageRequest.s(), cachePolicyD);
    }

    public final RequestDelegate g(ImageRequest imageRequest, Job job) {
        Lifecycle lifecycleZ = imageRequest.z();
        Target targetM = imageRequest.M();
        return targetM instanceof ViewTarget ? new ViewTargetRequestDelegate(this.f56136a, imageRequest, (ViewTarget) targetM, lifecycleZ, job) : new BaseRequestDelegate(lifecycleZ, job);
    }
}
