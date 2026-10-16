package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ChainParams implements HelperParams {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f30361j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ChainParams f30362k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f30363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f30364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f30365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f30366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f30367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f30368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f30369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f30370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f30371i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        float f3 = 0;
        f30362k = new ChainParams(Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3), Dp.g(f3), Float.NaN, null);
    }

    public /* synthetic */ ChainParams(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    private ChainParams(float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f30363a = f3;
        this.f30364b = f4;
        this.f30365c = f5;
        this.f30366d = f6;
        this.f30367e = f7;
        this.f30368f = f8;
        this.f30369g = f9;
        this.f30370h = f10;
        this.f30371i = f11;
    }
}
