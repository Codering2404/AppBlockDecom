package cz.mobilesoft.coreblock.scene.sharing.images.components;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShareSubtitleStringsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119427a;

        static {
            int[] iArr = new int[AppDistractionType.values().length];
            try {
                iArr[AppDistractionType.Distractive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppDistractionType.Productive.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppDistractionType.Neutral.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f119427a = iArr;
        }
    }

    public static final int a(AppDistractionType appDistractionType) {
        int i3 = appDistractionType == null ? -1 : WhenMappings.f119427a[appDistractionType.ordinal()];
        if (i3 == -1) {
            return R.string.v2;
        }
        if (i3 == 1) {
            return R.string.s2;
        }
        if (i3 == 2) {
            return R.string.u2;
        }
        if (i3 == 3) {
            return R.string.t2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int b(AppDistractionType appDistractionType) {
        int i3 = appDistractionType == null ? -1 : WhenMappings.f119427a[appDistractionType.ordinal()];
        if (i3 == -1) {
            return R.string.Mw;
        }
        if (i3 == 1) {
            return R.string.Nw;
        }
        if (i3 == 2) {
            return R.string.Vw;
        }
        if (i3 == 3) {
            return R.string.Tw;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int c(AppDistractionType appDistractionType) {
        int i3 = appDistractionType == null ? -1 : WhenMappings.f119427a[appDistractionType.ordinal()];
        if (i3 == -1) {
            return R.string.Bv;
        }
        if (i3 == 1) {
            return R.string.Ow;
        }
        if (i3 == 2) {
            return R.string.Ww;
        }
        if (i3 == 3) {
            return R.string.Uw;
        }
        throw new NoWhenBranchMatchedException();
    }
}
