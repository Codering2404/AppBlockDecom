package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class FontFamily {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29155b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SystemFontFamily f29156c = new DefaultFontFamily();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final GenericFontFamily f29157d = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final GenericFontFamily f29158f = new GenericFontFamily("serif", "FontFamily.Serif");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final GenericFontFamily f29159g = new GenericFontFamily("monospace", tDEtWsFLJfe.acOzgIx);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final GenericFontFamily f29160h = new GenericFontFamily("cursive", "FontFamily.Cursive");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f29161a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GenericFontFamily a() {
            return FontFamily.f29160h;
        }

        public final SystemFontFamily b() {
            return FontFamily.f29156c;
        }

        public final GenericFontFamily c() {
            return FontFamily.f29159g;
        }

        public final GenericFontFamily d() {
            return FontFamily.f29157d;
        }

        public final GenericFontFamily e() {
            return FontFamily.f29158f;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public interface Resolver {
        static /* synthetic */ State b(Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i3, int i4, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
            if ((i5 & 1) != 0) {
                fontFamily = null;
            }
            if ((i5 & 2) != 0) {
                fontWeight = FontWeight.f29233b.g();
            }
            if ((i5 & 4) != 0) {
                i3 = FontStyle.f29211b.b();
            }
            if ((i5 & 8) != 0) {
                i4 = FontSynthesis.f29215b.a();
            }
            return resolver.a(fontFamily, fontWeight, i3, i4);
        }

        State a(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4);
    }

    public /* synthetic */ FontFamily(boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2);
    }

    private FontFamily(boolean z2) {
        this.f29161a = z2;
    }
}
