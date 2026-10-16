package androidx.compose.ui;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface Alignment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f25072a = Companion.f25073a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f25073a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Alignment f25074b = new BiasAlignment(-1.0f, -1.0f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Alignment f25075c = new BiasAlignment(0.0f, -1.0f);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Alignment f25076d = new BiasAlignment(1.0f, -1.0f);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Alignment f25077e = new BiasAlignment(-1.0f, 0.0f);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Alignment f25078f = new BiasAlignment(0.0f, 0.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final Alignment f25079g = new BiasAlignment(1.0f, 0.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Alignment f25080h = new BiasAlignment(-1.0f, 1.0f);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final Alignment f25081i = new BiasAlignment(0.0f, 1.0f);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Alignment f25082j = new BiasAlignment(1.0f, 1.0f);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final Vertical f25083k = new BiasAlignment.Vertical(-1.0f);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final Vertical f25084l = new BiasAlignment.Vertical(0.0f);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final Vertical f25085m = new BiasAlignment.Vertical(1.0f);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final Horizontal f25086n = new BiasAlignment.Horizontal(-1.0f);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final Horizontal f25087o = new BiasAlignment.Horizontal(0.0f);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final Horizontal f25088p = new BiasAlignment.Horizontal(1.0f);

        private Companion() {
        }

        public final Vertical a() {
            return f25085m;
        }

        public final Alignment b() {
            return f25081i;
        }

        public final Alignment c() {
            return f25082j;
        }

        public final Alignment d() {
            return f25080h;
        }

        public final Alignment e() {
            return f25078f;
        }

        public final Alignment f() {
            return f25079g;
        }

        public final Horizontal g() {
            return f25087o;
        }

        public final Alignment h() {
            return f25077e;
        }

        public final Vertical i() {
            return f25084l;
        }

        public final Horizontal j() {
            return f25088p;
        }

        public final Horizontal k() {
            return f25086n;
        }

        public final Vertical l() {
            return f25083k;
        }

        public final Alignment m() {
            return f25075c;
        }

        public final Alignment n() {
            return f25076d;
        }

        public final Alignment o() {
            return f25074b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Horizontal {
        int a(int i3, int i4, LayoutDirection layoutDirection);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Vertical {
        int a(int i3, int i4);
    }

    long a(long j3, long j4, LayoutDirection layoutDirection);
}
