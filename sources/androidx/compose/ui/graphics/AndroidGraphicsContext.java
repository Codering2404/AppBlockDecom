package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerV23;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.GraphicsViewLayer;
import androidx.compose.ui.graphics.layer.LayerManager;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import kotlin.Metadata;
import kotlin.Unit;
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
final class AndroidGraphicsContext implements GraphicsContext {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f25626h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f25627i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f25628a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DrawChildContainer f25631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f25632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f25633f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f25629b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayerManager f25630c = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ComponentCallbacks2 f25634g = null;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.AndroidGraphicsContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass2 implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AndroidGraphicsContext f25637a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f25637a.k(view.getContext());
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f25637a.l(view.getContext());
            this.f25637a.f25630c.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class UniqueDrawingIdApi29 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UniqueDrawingIdApi29 f25638a = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        public static final long a(View view) {
            return view.getUniqueDrawingId();
        }
    }

    public AndroidGraphicsContext(ViewGroup viewGroup) {
        this.f25628a = viewGroup;
    }

    private final long i(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.a(view);
        }
        return -1L;
    }

    private final DrawChildContainer j(ViewGroup viewGroup) {
        DrawChildContainer drawChildContainer = this.f25631d;
        if (drawChildContainer != null) {
            return drawChildContainer;
        }
        ViewLayerContainer viewLayerContainer = new ViewLayerContainer(viewGroup.getContext());
        viewGroup.addView(viewLayerContainer);
        this.f25631d = viewLayerContainer;
        return viewLayerContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Context context) {
        if (this.f25632e) {
            return;
        }
        context.getApplicationContext().registerComponentCallbacks(this.f25634g);
        this.f25632e = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Context context) {
        if (this.f25632e) {
            context.getApplicationContext().unregisterComponentCallbacks(this.f25634g);
            this.f25632e = false;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer a() {
        GraphicsLayerImpl graphicsViewLayer;
        GraphicsLayer graphicsLayer;
        synchronized (this.f25629b) {
            try {
                long jI = i(this.f25628a);
                if (Build.VERSION.SDK_INT >= 29) {
                    graphicsViewLayer = new GraphicsLayerV29(jI, null, null, 6, null);
                } else if (f25627i) {
                    try {
                        graphicsViewLayer = new GraphicsLayerV23(this.f25628a, jI, null, null, 12, null);
                    } catch (Throwable unused) {
                        f25627i = false;
                        graphicsViewLayer = new GraphicsViewLayer(j(this.f25628a), jI, null, null, 12, null);
                    }
                } else {
                    graphicsViewLayer = new GraphicsViewLayer(j(this.f25628a), jI, null, null, 12, null);
                }
                graphicsLayer = new GraphicsLayer(graphicsViewLayer, this.f25630c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void b(GraphicsLayer graphicsLayer) {
        synchronized (this.f25629b) {
            graphicsLayer.J();
            Unit unit = Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.AndroidGraphicsContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements ComponentCallbacks2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AndroidGraphicsContext f25635a;

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            if (i3 < 40 || this.f25635a.f25633f) {
                return;
            }
            this.f25635a.f25630c.c();
            ViewTreeObserver viewTreeObserver = this.f25635a.f25628a.getViewTreeObserver();
            final AndroidGraphicsContext androidGraphicsContext = this.f25635a;
            viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.compose.ui.graphics.AndroidGraphicsContext$1$onTrimMemory$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    androidGraphicsContext.f25630c.g();
                    androidGraphicsContext.f25628a.getViewTreeObserver().removeOnPreDrawListener(this);
                    androidGraphicsContext.f25633f = false;
                    return true;
                }
            });
            this.f25635a.f25633f = true;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }
}
