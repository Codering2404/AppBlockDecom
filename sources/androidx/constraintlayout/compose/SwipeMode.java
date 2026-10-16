package androidx.constraintlayout.compose;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class SwipeMode {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f30953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final SwipeMode f30954j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final SwipeMode f30955k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f30957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f30958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f30959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f30960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SpringBoundary f30961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f30962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f30963h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SwipeMode b(Companion companion, float f3, float f4, float f5, float f6, SpringBoundary springBoundary, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f3 = 1.0f;
            }
            if ((i3 & 2) != 0) {
                f4 = 400.0f;
            }
            if ((i3 & 4) != 0) {
                f5 = 10.0f;
            }
            if ((i3 & 8) != 0) {
                f6 = 0.01f;
            }
            if ((i3 & 16) != 0) {
                springBoundary = SpringBoundary.f30934b.a();
            }
            SpringBoundary springBoundary2 = springBoundary;
            float f7 = f5;
            return companion.a(f3, f4, f7, f6, springBoundary2);
        }

        public static /* synthetic */ SwipeMode d(Companion companion, float f3, float f4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f3 = 4.0f;
            }
            if ((i3 & 2) != 0) {
                f4 = 1.2f;
            }
            return companion.c(f3, f4);
        }

        public final SwipeMode a(float f3, float f4, float f5, float f6, SpringBoundary springBoundary) {
            return new SwipeMode("spring", f3, f4, f5, f6, springBoundary, 0.0f, 0.0f, 192, null);
        }

        public final SwipeMode c(float f3, float f4) {
            return new SwipeMode("velocity", 0.0f, 0.0f, 0.0f, 0.0f, null, f3, f4, 62, null);
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        f30953i = companion;
        f30954j = Companion.d(companion, 0.0f, 0.0f, 3, null);
        f30955k = Companion.b(companion, 0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
    }

    public SwipeMode(String str, float f3, float f4, float f5, float f6, SpringBoundary springBoundary, float f7, float f8) {
        this.f30956a = str;
        this.f30957b = f3;
        this.f30958c = f4;
        this.f30959d = f5;
        this.f30960e = f6;
        this.f30961f = springBoundary;
        this.f30962g = f7;
        this.f30963h = f8;
    }

    public /* synthetic */ SwipeMode(String str, float f3, float f4, float f5, float f6, SpringBoundary springBoundary, float f7, float f8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 1.0f : f3, (i3 & 4) != 0 ? 400.0f : f4, (i3 & 8) != 0 ? 10.0f : f5, (i3 & 16) != 0 ? 0.01f : f6, (i3 & 32) != 0 ? SpringBoundary.f30934b.a() : springBoundary, (i3 & 64) != 0 ? 4.0f : f7, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 1.2f : f8);
    }
}
