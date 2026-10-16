package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class VectorProperty<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Fill extends VectorProperty<Brush> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Fill f26565a = new Fill();

        private Fill() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FillAlpha extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FillAlpha f26566a = new FillAlpha();

        private FillAlpha() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PathData extends VectorProperty<List<? extends PathNode>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PathData f26567a = new PathData();

        private PathData() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PivotX extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PivotX f26568a = new PivotX();

        private PivotX() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PivotY extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PivotY f26569a = new PivotY();

        private PivotY() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Rotation extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Rotation f26570a = new Rotation();

        private Rotation() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScaleX extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScaleX f26571a = new ScaleX();

        private ScaleX() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScaleY extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScaleY f26572a = new ScaleY();

        private ScaleY() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Stroke extends VectorProperty<Brush> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Stroke f26573a = new Stroke();

        private Stroke() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrokeAlpha extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrokeAlpha f26574a = new StrokeAlpha();

        private StrokeAlpha() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StrokeLineWidth extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrokeLineWidth f26575a = new StrokeLineWidth();

        private StrokeLineWidth() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TranslateX extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TranslateX f26576a = new TranslateX();

        private TranslateX() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TranslateY extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TranslateY f26577a = new TranslateY();

        private TranslateY() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrimPathEnd extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TrimPathEnd f26578a = new TrimPathEnd();

        private TrimPathEnd() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrimPathOffset extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TrimPathOffset f26579a = new TrimPathOffset();

        private TrimPathOffset() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrimPathStart extends VectorProperty<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TrimPathStart f26580a = new TrimPathStart();

        private TrimPathStart() {
            super(null);
        }
    }

    public /* synthetic */ VectorProperty(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private VectorProperty() {
    }
}
