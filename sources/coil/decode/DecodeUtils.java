package coil.decode;

import coil.size.Scale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

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
public final class DecodeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DecodeUtils f55706a = new DecodeUtils();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55707a;

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
            f55707a = iArr;
        }
    }

    private DecodeUtils() {
    }

    public static final int a(int i3, int i4, int i5, int i6, Scale scale) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(i3 / i5);
        int iHighestOneBit2 = Integer.highestOneBit(i4 / i6);
        int i7 = WhenMappings.f55707a[scale.ordinal()];
        if (i7 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i7 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        return RangesKt.f(iMin, 1);
    }

    public static final double b(double d3, double d4, double d5, double d6, Scale scale) {
        double d7 = d5 / d3;
        double d8 = d6 / d4;
        int i3 = WhenMappings.f55707a[scale.ordinal()];
        if (i3 == 1) {
            return Math.max(d7, d8);
        }
        if (i3 == 2) {
            return Math.min(d7, d8);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double c(int i3, int i4, int i5, int i6, Scale scale) {
        double d3 = ((double) i5) / ((double) i3);
        double d4 = ((double) i6) / ((double) i4);
        int i7 = WhenMappings.f55707a[scale.ordinal()];
        if (i7 == 1) {
            return Math.max(d3, d4);
        }
        if (i7 == 2) {
            return Math.min(d3, d4);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float d(float f3, float f4, float f5, float f6, Scale scale) {
        float f7 = f5 / f3;
        float f8 = f6 / f4;
        int i3 = WhenMappings.f55707a[scale.ordinal()];
        if (i3 == 1) {
            return Math.max(f7, f8);
        }
        if (i3 == 2) {
            return Math.min(f7, f8);
        }
        throw new NoWhenBranchMatchedException();
    }
}
