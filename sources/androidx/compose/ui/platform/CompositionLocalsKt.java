package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillManager;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CompositionLocalsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27965a = CompositionLocalKt.g(new Function0<AccessibilityManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAccessibilityManager$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AccessibilityManager invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27966b = CompositionLocalKt.g(new Function0<Autofill>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofill$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Autofill invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27967c = CompositionLocalKt.g(new Function0<AutofillTree>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillTree$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AutofillTree invoke() {
            CompositionLocalsKt.v("LocalAutofillTree");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27968d = CompositionLocalKt.g(new Function0<AutofillManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillManager$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AutofillManager invoke() {
            CompositionLocalsKt.v("LocalAutofillManager");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27969e = CompositionLocalKt.g(new Function0<ClipboardManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboardManager$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ClipboardManager invoke() {
            CompositionLocalsKt.v("LocalClipboardManager");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27970f = CompositionLocalKt.g(new Function0<Clipboard>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboard$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Clipboard invoke() {
            CompositionLocalsKt.v("LocalClipboard");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27971g = CompositionLocalKt.g(new Function0<GraphicsContext>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalGraphicsContext$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final GraphicsContext invoke() {
            CompositionLocalsKt.v("LocalGraphicsContext");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27972h = CompositionLocalKt.g(new Function0<Density>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalDensity$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Density invoke() {
            CompositionLocalsKt.v("LocalDensity");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27973i = CompositionLocalKt.g(new Function0<FocusManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFocusManager$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FocusManager invoke() {
            CompositionLocalsKt.v("LocalFocusManager");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27974j = CompositionLocalKt.g(new Function0<Font.ResourceLoader>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontLoader$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Font.ResourceLoader invoke() {
            CompositionLocalsKt.v("LocalFontLoader");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27975k = CompositionLocalKt.g(new Function0<FontFamily.Resolver>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontFamilyResolver$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FontFamily.Resolver invoke() {
            CompositionLocalsKt.v("LocalFontFamilyResolver");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27976l = CompositionLocalKt.g(new Function0<HapticFeedback>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalHapticFeedback$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final HapticFeedback invoke() {
            CompositionLocalsKt.v("LocalHapticFeedback");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27977m = CompositionLocalKt.g(new Function0<InputModeManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalInputModeManager$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final InputModeManager invoke() {
            CompositionLocalsKt.v("LocalInputManager");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27978n = CompositionLocalKt.g(new Function0<LayoutDirection>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalLayoutDirection$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LayoutDirection invoke() {
            CompositionLocalsKt.v("LocalLayoutDirection");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27979o = CompositionLocalKt.g(new Function0<TextInputService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextInputService$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextInputService invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27980p = CompositionLocalKt.g(new Function0<SoftwareKeyboardController>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalSoftwareKeyboardController$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SoftwareKeyboardController invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27981q = CompositionLocalKt.g(new Function0<TextToolbar>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextToolbar$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextToolbar invoke() {
            CompositionLocalsKt.v("LocalTextToolbar");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27982r = CompositionLocalKt.g(new Function0<UriHandler>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalUriHandler$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final UriHandler invoke() {
            CompositionLocalsKt.v("LocalUriHandler");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27983s = CompositionLocalKt.g(new Function0<ViewConfiguration>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalViewConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ViewConfiguration invoke() {
            CompositionLocalsKt.v("LocalViewConfiguration");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27984t = CompositionLocalKt.g(new Function0<WindowInfo>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalWindowInfo$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final WindowInfo invoke() {
            CompositionLocalsKt.v("LocalWindowInfo");
            throw new KotlinNothingValueException();
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27985u = CompositionLocalKt.g(new Function0<PointerIconService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalPointerIconService$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final PointerIconService invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27986v = CompositionLocalKt.e(null, new Function0<Boolean>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalProvidableScrollCaptureInProgress$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }, 1, null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final ProvidableCompositionLocal f27987w = CompositionLocalKt.g(new Function0<Boolean>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalCursorBlinkEnabled$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    public static final void a(final Owner owner, final UriHandler uriHandler, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(874662829);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(owner) : composerK.I(owner) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(uriHandler) : composerK.I(uriHandler) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(874662829, i4, -1, "androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:214)");
            }
            CompositionLocalKt.c(new ProvidedValue[]{f27965a.d(owner.getAccessibilityManager()), f27966b.d(owner.getAutofill()), f27968d.d(owner.getAutofillManager()), f27967c.d(owner.getAutofillTree()), f27969e.d(owner.getClipboardManager()), f27970f.d(owner.getClipboard()), f27972h.d(owner.getDensity()), f27973i.d(owner.getFocusOwner()), f27974j.e(owner.getFontLoader()), f27975k.e(owner.getFontFamilyResolver()), f27976l.d(owner.getHapticFeedBack()), f27977m.d(owner.getInputModeManager()), f27978n.d(owner.getLayoutDirection()), f27979o.d(owner.getTextInputService()), f27980p.d(owner.getSoftwareKeyboardController()), f27981q.d(owner.getTextToolbar()), f27982r.d(uriHandler), f27983s.d(owner.getViewConfiguration()), f27984t.d(owner.getWindowInfo()), f27985u.d(owner.getPointerIconService()), f27971g.d(owner.getGraphicsContext())}, function2, composerK, ((i4 >> 3) & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CompositionLocalsKt.a(owner, uriHandler, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal c() {
        return f27965a;
    }

    public static final ProvidableCompositionLocal d() {
        return f27970f;
    }

    public static final ProvidableCompositionLocal e() {
        return f27987w;
    }

    public static final ProvidableCompositionLocal f() {
        return f27972h;
    }

    public static final ProvidableCompositionLocal g() {
        return f27973i;
    }

    public static final ProvidableCompositionLocal h() {
        return f27975k;
    }

    public static final ProvidableCompositionLocal i() {
        return f27974j;
    }

    public static final ProvidableCompositionLocal j() {
        return f27971g;
    }

    public static final ProvidableCompositionLocal k() {
        return f27976l;
    }

    public static final ProvidableCompositionLocal l() {
        return f27977m;
    }

    public static final ProvidableCompositionLocal m() {
        return f27978n;
    }

    public static final ProvidableCompositionLocal n() {
        return f27985u;
    }

    public static final ProvidableCompositionLocal o() {
        return f27986v;
    }

    public static final CompositionLocal p() {
        return f27986v;
    }

    public static final ProvidableCompositionLocal q() {
        return f27980p;
    }

    public static final ProvidableCompositionLocal r() {
        return f27981q;
    }

    public static final ProvidableCompositionLocal s() {
        return f27982r;
    }

    public static final ProvidableCompositionLocal t() {
        return f27983s;
    }

    public static final ProvidableCompositionLocal u() {
        return f27984t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void v(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
