package coil.util;

import android.graphics.Bitmap;
import coil.size.Dimension;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: renamed from: coil.util.-SvgUtils, reason: invalid class name */
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
public final class SvgUtils {

    /* JADX INFO: renamed from: coil.util.-SvgUtils$WhenMappings */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56214a;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56214a = iArr;
        }
    }

    public static final long a(BufferedSource bufferedSource, ByteString byteString, long j3, long j4) {
        if (byteString.C() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        byte bG = byteString.g(0);
        long jC = j4 - ((long) byteString.C());
        long j5 = j3;
        while (j5 < jC) {
            BufferedSource bufferedSource2 = bufferedSource;
            long jM0 = bufferedSource2.m0(bG, j5, jC);
            if (jM0 == -1 || bufferedSource2.E0(jM0, byteString)) {
                return jM0;
            }
            j5 = jM0 + 1;
            bufferedSource = bufferedSource2;
        }
        return -1L;
    }

    public static final boolean b(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }

    public static final float c(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).f56163a;
        }
        int i3 = WhenMappings.f56214a[scale.ordinal()];
        if (i3 == 1) {
            return Float.MIN_VALUE;
        }
        if (i3 == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Bitmap.Config d(Bitmap.Config config) {
        return (config == null || b(config)) ? Bitmap.Config.ARGB_8888 : config;
    }
}
