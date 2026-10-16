package coil.decode;

import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;

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
public final class ExifUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f55720a = SetsKt.setOf((Object[]) new String[]{"image/jpeg", "image/webp", "image/heic", "image/heif"});

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55721a;

        static {
            int[] iArr = new int[ExifOrientationPolicy.values().length];
            try {
                iArr[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExifOrientationPolicy.IGNORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f55721a = iArr;
        }
    }

    public static final boolean a(ExifData exifData) {
        return exifData.a() > 0;
    }

    public static final boolean b(ExifData exifData) {
        return exifData.a() == 90 || exifData.a() == 270;
    }

    public static final boolean c(ExifOrientationPolicy exifOrientationPolicy, String str) {
        int i3 = WhenMappings.f55721a[exifOrientationPolicy.ordinal()];
        if (i3 == 1) {
            return str != null && f55720a.contains(str);
        }
        if (i3 == 2) {
            return false;
        }
        if (i3 == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
