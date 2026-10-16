package coil.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.target.ViewTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: coil.util.-Requests, reason: invalid class name */
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Requests {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DefaultRequestOptions f56212a = new DefaultRequestOptions(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* JADX INFO: renamed from: coil.util.-Requests$WhenMappings */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56213a;

        static {
            int[] iArr = new int[Precision.values().length];
            try {
                iArr[Precision.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Precision.INEXACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Precision.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f56213a = iArr;
        }
    }

    public static final boolean a(ImageRequest imageRequest) {
        int i3 = WhenMappings.f56213a[imageRequest.H().ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (imageRequest.q().m() == null && (imageRequest.K() instanceof DisplaySizeResolver)) {
            return true;
        }
        return (imageRequest.M() instanceof ViewTarget) && (imageRequest.K() instanceof ViewSizeResolver) && (((ViewTarget) imageRequest.M()).a() instanceof ImageView) && ((ViewTarget) imageRequest.M()).a() == ((ViewSizeResolver) imageRequest.K()).a();
    }

    public static final DefaultRequestOptions b() {
        return f56212a;
    }

    public static final Drawable c(ImageRequest imageRequest, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return Contexts.a(imageRequest.l(), num.intValue());
    }
}
