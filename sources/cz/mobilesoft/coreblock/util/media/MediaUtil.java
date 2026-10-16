package cz.mobilesoft.coreblock.util.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.exifinterface.media.ExifInterface;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MediaUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaUtil f128857a = new MediaUtil();

    private MediaUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int d(BitmapFactory.Options options, int i3, int i4) {
        Pair pairA = TuplesKt.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) pairA.a()).intValue();
        int iIntValue2 = ((Number) pairA.b()).intValue();
        int i5 = 1;
        if (iIntValue <= i4 && iIntValue2 <= i3) {
            return 1;
        }
        while (iIntValue / i5 >= i4 && iIntValue2 / i5 >= i3) {
            i5 *= 2;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float e(Context context, Uri uri) {
        try {
            ExifInterface exifInterfaceF = f(context, uri);
            if (exifInterfaceF == null) {
                return -1.0f;
            }
            int iC = exifInterfaceF.c("Orientation", 0);
            if (iC == 1) {
                return 0.0f;
            }
            if (iC == 3) {
                return 180.0f;
            }
            if (iC != 6) {
                return iC != 8 ? -1.0f : 270.0f;
            }
            return 90.0f;
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    private final ExifInterface f(Context context, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            return new ExifInterface(inputStreamOpenInputStream);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap i(Bitmap bitmap, float f3) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f3);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public final Object g(Context context, int i3, int i4, Uri uri, boolean z2, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new MediaUtil$getInSampledBitmap$2(context, uri, i3, i4, z2, null), continuation);
    }

    public final boolean h() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            return true;
        }
        return i3 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
    }
}
