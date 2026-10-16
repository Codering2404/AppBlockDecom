package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class WindowInsetsHolder {
    private static boolean A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f7180x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f7181y = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final WeakHashMap f7182z = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidWindowInsets f7183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidWindowInsets f7184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AndroidWindowInsets f7185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AndroidWindowInsets f7186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AndroidWindowInsets f7187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AndroidWindowInsets f7188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AndroidWindowInsets f7189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AndroidWindowInsets f7190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AndroidWindowInsets f7191i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ValueInsets f7192j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final WindowInsets f7193k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final WindowInsets f7194l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final WindowInsets f7195m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ValueInsets f7196n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ValueInsets f7197o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ValueInsets f7198p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ValueInsets f7199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ValueInsets f7200r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ValueInsets f7201s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ValueInsets f7202t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f7203u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f7204v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final InsetsListener f7205w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WindowInsetsHolder d(View view) {
            WindowInsetsHolder windowInsetsHolder;
            synchronized (WindowInsetsHolder.f7182z) {
                try {
                    WeakHashMap weakHashMap = WindowInsetsHolder.f7182z;
                    Object obj = weakHashMap.get(view);
                    Object obj2 = obj;
                    if (obj == null) {
                        WindowInsetsHolder windowInsetsHolder2 = new WindowInsetsHolder(null, view, false ? 1 : 0);
                        weakHashMap.put(view, windowInsetsHolder2);
                        obj2 = windowInsetsHolder2;
                    }
                    windowInsetsHolder = (WindowInsetsHolder) obj2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return windowInsetsHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AndroidWindowInsets e(WindowInsetsCompat windowInsetsCompat, int i3, String str) {
            AndroidWindowInsets androidWindowInsets = new AndroidWindowInsets(i3, str);
            if (windowInsetsCompat != null) {
                androidWindowInsets.j(windowInsetsCompat, i3);
            }
            return androidWindowInsets;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ValueInsets f(WindowInsetsCompat windowInsetsCompat, int i3, String str) {
            Insets insetsG;
            if (windowInsetsCompat == null || (insetsG = windowInsetsCompat.g(i3)) == null) {
                insetsG = Insets.f33963e;
            }
            return WindowInsets_androidKt.a(insetsG, str);
        }

        public final WindowInsetsHolder c(Composer composer, int i3) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1366542614, i3, -1, "androidx.compose.foundation.layout.WindowInsetsHolder.Companion.current (WindowInsets.android.kt:578)");
            }
            final View view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
            final WindowInsetsHolder windowInsetsHolderD = d(view);
            boolean zI = composer.I(windowInsetsHolderD) | composer.I(view);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        windowInsetsHolderD.p(view);
                        final WindowInsetsHolder windowInsetsHolder = windowInsetsHolderD;
                        final View view2 = view;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.layout.WindowInsetsHolder$Companion$current$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                windowInsetsHolder.b(view2);
                            }
                        };
                    }
                };
                composer.w(objG);
            }
            EffectsKt.c(windowInsetsHolderD, (Function1) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return windowInsetsHolderD;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsetsCompat, view);
    }

    public static /* synthetic */ void r(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        windowInsetsHolder.q(windowInsetsCompat, i3);
    }

    public final void b(View view) {
        int i3 = this.f7204v - 1;
        this.f7204v = i3;
        if (i3 == 0) {
            ViewCompat.C0(view, null);
            ViewCompat.K0(view, null);
            view.removeOnAttachStateChangeListener(this.f7205w);
        }
    }

    public final AndroidWindowInsets c() {
        return this.f7183a;
    }

    public final boolean d() {
        return this.f7203u;
    }

    public final AndroidWindowInsets e() {
        return this.f7184b;
    }

    public final AndroidWindowInsets f() {
        return this.f7185c;
    }

    public final AndroidWindowInsets g() {
        return this.f7186d;
    }

    public final AndroidWindowInsets h() {
        return this.f7187e;
    }

    public final WindowInsets i() {
        return this.f7195m;
    }

    public final WindowInsets j() {
        return this.f7193k;
    }

    public final WindowInsets k() {
        return this.f7194l;
    }

    public final AndroidWindowInsets l() {
        return this.f7188f;
    }

    public final AndroidWindowInsets m() {
        return this.f7189g;
    }

    public final AndroidWindowInsets n() {
        return this.f7190h;
    }

    public final ValueInsets o() {
        return this.f7192j;
    }

    public final void p(View view) {
        if (this.f7204v == 0) {
            ViewCompat.C0(view, this.f7205w);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(this.f7205w);
            ViewCompat.K0(view, this.f7205w);
        }
        this.f7204v++;
    }

    public final void q(WindowInsetsCompat windowInsetsCompat, int i3) {
        if (A) {
            android.view.WindowInsets windowInsetsY = windowInsetsCompat.y();
            Intrinsics.checkNotNull(windowInsetsY);
            windowInsetsCompat = WindowInsetsCompat.z(windowInsetsY);
        }
        this.f7183a.j(windowInsetsCompat, i3);
        this.f7185c.j(windowInsetsCompat, i3);
        this.f7184b.j(windowInsetsCompat, i3);
        this.f7187e.j(windowInsetsCompat, i3);
        this.f7188f.j(windowInsetsCompat, i3);
        this.f7189g.j(windowInsetsCompat, i3);
        this.f7190h.j(windowInsetsCompat, i3);
        this.f7191i.j(windowInsetsCompat, i3);
        this.f7186d.j(windowInsetsCompat, i3);
        if (i3 == 0) {
            this.f7196n.f(WindowInsets_androidKt.f(windowInsetsCompat.g(WindowInsetsCompat.Type.b())));
            this.f7197o.f(WindowInsets_androidKt.f(windowInsetsCompat.g(WindowInsetsCompat.Type.g())));
            this.f7198p.f(WindowInsets_androidKt.f(windowInsetsCompat.g(WindowInsetsCompat.Type.h())));
            this.f7199q.f(WindowInsets_androidKt.f(windowInsetsCompat.g(WindowInsetsCompat.Type.i())));
            this.f7200r.f(WindowInsets_androidKt.f(windowInsetsCompat.g(WindowInsetsCompat.Type.k())));
            DisplayCutoutCompat displayCutoutCompatE = windowInsetsCompat.e();
            if (displayCutoutCompatE != null) {
                this.f7192j.f(WindowInsets_androidKt.f(displayCutoutCompatE.e()));
            }
        }
        Snapshot.f24914e.n();
    }

    public final void s(WindowInsetsCompat windowInsetsCompat) {
        this.f7202t.f(WindowInsets_androidKt.f(windowInsetsCompat.f(WindowInsetsCompat.Type.d())));
    }

    public final void t(WindowInsetsCompat windowInsetsCompat) {
        this.f7201s.f(WindowInsets_androidKt.f(windowInsetsCompat.f(WindowInsetsCompat.Type.d())));
    }

    private WindowInsetsHolder(WindowInsetsCompat windowInsetsCompat, View view) {
        DisplayCutoutCompat displayCutoutCompatE;
        Insets insetsE;
        Companion companion = f7180x;
        this.f7183a = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.b(), "captionBar");
        AndroidWindowInsets androidWindowInsetsE = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.c(), "displayCutout");
        this.f7184b = androidWindowInsetsE;
        AndroidWindowInsets androidWindowInsetsE2 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.d(), "ime");
        this.f7185c = androidWindowInsetsE2;
        AndroidWindowInsets androidWindowInsetsE3 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.f(), "mandatorySystemGestures");
        this.f7186d = androidWindowInsetsE3;
        this.f7187e = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.g(), "navigationBars");
        this.f7188f = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.h(), "statusBars");
        AndroidWindowInsets androidWindowInsetsE4 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.i(), "systemBars");
        this.f7189g = androidWindowInsetsE4;
        AndroidWindowInsets androidWindowInsetsE5 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.j(), "systemGestures");
        this.f7190h = androidWindowInsetsE5;
        AndroidWindowInsets androidWindowInsetsE6 = companion.e(windowInsetsCompat, WindowInsetsCompat.Type.k(), "tappableElement");
        this.f7191i = androidWindowInsetsE6;
        ValueInsets valueInsetsA = WindowInsets_androidKt.a((windowInsetsCompat == null || (displayCutoutCompatE = windowInsetsCompat.e()) == null || (insetsE = displayCutoutCompatE.e()) == null) ? Insets.f33963e : insetsE, "waterfall");
        this.f7192j = valueInsetsA;
        WindowInsets windowInsetsJ = WindowInsetsKt.j(WindowInsetsKt.j(androidWindowInsetsE4, androidWindowInsetsE2), androidWindowInsetsE);
        this.f7193k = windowInsetsJ;
        WindowInsets windowInsetsJ2 = WindowInsetsKt.j(WindowInsetsKt.j(WindowInsetsKt.j(androidWindowInsetsE6, androidWindowInsetsE3), androidWindowInsetsE5), valueInsetsA);
        this.f7194l = windowInsetsJ2;
        this.f7195m = WindowInsetsKt.j(windowInsetsJ, windowInsetsJ2);
        this.f7196n = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.b(), "captionBarIgnoringVisibility");
        this.f7197o = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.g(), "navigationBarsIgnoringVisibility");
        this.f7198p = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.h(), "statusBarsIgnoringVisibility");
        this.f7199q = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.i(), "systemBarsIgnoringVisibility");
        this.f7200r = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.k(), "tappableElementIgnoringVisibility");
        this.f7201s = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.d(), "imeAnimationTarget");
        this.f7202t = companion.f(windowInsetsCompat, WindowInsetsCompat.Type.d(), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(androidx.compose.ui.R.id.I) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.f7203u = bool != null ? bool.booleanValue() : true;
        this.f7205w = new InsetsListener(this);
    }
}
