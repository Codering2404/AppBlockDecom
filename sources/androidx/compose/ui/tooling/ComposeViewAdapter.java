package androidx.compose.ui.tooling;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.NodeGroup;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ComposeViewAdapter extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComposeView f29680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29682d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f29683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f29684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositionDataRecord f29685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f29686i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f29687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ThreadSafeException f29688k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function2 f29689l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableState f29690m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f29691n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f29692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f29693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0 f29694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f29695r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f29696s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PreviewAnimationClock f29697t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 f29698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 f29699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 f29700w;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(522143116);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(522143116, i4, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.android.kt:402)");
            }
            CompositionLocalKt.c(new ProvidedValue[]{CompositionLocalsKt.i().d(new LayoutlibFontResourceLoader(getContext())), CompositionLocalsKt.h().d(FontFamilyResolver_androidKt.a(getContext())), LocalOnBackPressedDispatcherOwner.f458a.b(this.f29699v), LocalActivityResultRegistryOwner.f452a.b(this.f29700w)}, ComposableLambdaKt.e(-1475548980, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$1
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
                    if (!composer2.r((i5 & 3) != 2, i5 & 1)) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1475548980, i5, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.android.kt:413)");
                    }
                    InspectableKt.b(this.f29707a.f29685h, function2, composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$WrapPreview$2
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
                    this.f29709a.a(function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private final void g() {
        Set setA = this.f29685h.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.b((CompositionData) it.next()));
        }
        boolean z2 = this.f29697t != null;
        AnimationSearch animationSearch = new AnimationSearch(new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$1
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ComposeViewAdapter) this.receiver).getClock$ui_tooling_release();
            }
        }, new ComposeViewAdapter$findAndTrackAnimations$2(this));
        boolean zF = animationSearch.f(arrayList);
        this.f29687j = zF;
        if (z2 && zF) {
            animationSearch.d(arrayList);
        }
    }

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    private final void h() {
        Set setA = this.f29685h.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.b((CompositionData) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            List<Group> listB = PreviewUtils_androidKt.b((Group) obj, new Function1<Group, Boolean>() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Group group) {
                    boolean z2;
                    if (!Intrinsics.areEqual(group.f(), "remember") && this.f29712a.m(group)) {
                        z2 = true;
                        break;
                    }
                    Collection<Group> collectionB = group.b();
                    ComposeViewAdapter composeViewAdapter = this.f29712a;
                    if (!(collectionB instanceof Collection) || !collectionB.isEmpty()) {
                        for (Group group2 : collectionB) {
                            if (Intrinsics.areEqual(group2.f(), "remember") && composeViewAdapter.m(group2)) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    return Boolean.valueOf(z2);
                }
            });
            ArrayList arrayList3 = new ArrayList();
            for (Group group : listB) {
                String strJ = j(group, group.a());
                if (strJ == null) {
                    Iterator it2 = group.b().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            strJ = null;
                            break;
                        }
                        String strJ2 = j((Group) it2.next(), group.a());
                        if (strJ2 != null) {
                            strJ = strJ2;
                            break;
                        }
                    }
                }
                if (strJ != null) {
                    arrayList3.add(strJ);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        this.f29684g = arrayList2;
    }

    private final Method i(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            return cls.getDeclaredMethod("getDesignInfo", cls2, cls2, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String j(Group group, IntRect intRect) {
        String strP;
        Iterator it = group.c().iterator();
        do {
            strP = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                strP = p(next, intRect.g(), intRect.h());
            }
        } while (strP == null);
        return strP;
    }

    private final String k(Group group) {
        String strD;
        SourceLocation sourceLocationD = group.d();
        return (sourceLocationD == null || (strD = sourceLocationD.d()) == null) ? "" : strD;
    }

    private final int l(Group group) {
        SourceLocation sourceLocationD = group.d();
        if (sourceLocationD != null) {
            return sourceLocationD.b();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(Group group) {
        Collection collectionC = group.c();
        if ((collectionC instanceof Collection) && collectionC.isEmpty()) {
            return false;
        }
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ((next != null ? i(next) : null) != null) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(Group group) {
        return k(group).length() == 0 && l(group) == -1;
    }

    private final void o() {
        this.f29690m.setValue(ComposableSingletons$ComposeViewAdapter_androidKt.f29669a.b());
        this.f29690m.setValue(this.f29689l);
        invalidate();
    }

    private final String p(Object obj, int i3, int i4) {
        Method methodI = i(obj);
        if (methodI == null) {
            return null;
        }
        try {
            Object objInvoke = methodI.invoke(obj, Integer.valueOf(i3), Integer.valueOf(i4), this.f29693p);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str = (String) objInvoke;
            if (str.length() == 0) {
                return null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean q(Group group) {
        if (!n(group) || !group.b().isEmpty()) {
            return false;
        }
        NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
        Object objG = nodeGroup != null ? nodeGroup.g() : null;
        return (objG instanceof LayoutInfo ? (LayoutInfo) objG : null) == null;
    }

    private final void r() {
        Set setA = this.f29685h.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(s(SlotTreeKt.b((CompositionData) it.next())));
        }
        List list = CollectionsKt.toList(arrayList);
        if (this.f29695r) {
            list = ShadowViewInfo_androidKt.a(list);
        }
        this.f29683f = list;
        if (this.f29681c) {
            Log.d(this.f29679a, ViewInfoUtil_androidKt.c(list, 0, null, 3, null));
        }
    }

    private final ViewInfo s(Group group) {
        String strD;
        NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
        Object objG = nodeGroup != null ? nodeGroup.g() : null;
        LayoutInfo layoutInfo = objG instanceof LayoutInfo ? (LayoutInfo) objG : null;
        if (group.b().size() == 1 && n(group) && layoutInfo == null) {
            return s((Group) CollectionsKt.single(group.b()));
        }
        Collection collectionB = group.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            if (!q((Group) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(s((Group) obj2));
        }
        SourceLocation sourceLocationD = group.d();
        if (sourceLocationD == null || (strD = sourceLocationD.d()) == null) {
            strD = "";
        }
        String str = strD;
        SourceLocation sourceLocationD2 = group.d();
        return new ViewInfo(str, sourceLocationD2 != null ? sourceLocationD2.b() : -1, group.a(), group.d(), arrayList2, layoutInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f29691n) {
            o();
        }
        this.f29694q.invoke();
        if (this.f29682d) {
            List<ViewInfo> list = this.f29683f;
            ArrayList arrayList = new ArrayList();
            for (ViewInfo viewInfo : list) {
                CollectionsKt.addAll(arrayList, CollectionsKt.plus((Collection) CollectionsKt.listOf(viewInfo), (Iterable) viewInfo.a()));
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ViewInfo viewInfo2 = (ViewInfo) obj;
                if (viewInfo2.h()) {
                    canvas.drawRect(new Rect(viewInfo2.b().g(), viewInfo2.b().j(), viewInfo2.b().h(), viewInfo2.b().d()), this.f29696s);
                }
            }
        }
    }

    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.f29697t;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.f29684g;
    }

    public final boolean getStitchTrees$ui_tooling_release() {
        return this.f29695r;
    }

    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.f29683f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewTreeLifecycleOwner.b(this.f29680b.getRootView(), this.f29698u);
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        this.f29688k.b();
        r();
        if (this.f29686i.length() > 0) {
            g();
            if (this.f29692o) {
                h();
            }
        }
    }

    public final void setClock$ui_tooling_release(PreviewAnimationClock previewAnimationClock) {
        this.f29697t = previewAnimationClock;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        this.f29684g = list;
    }

    public final void setStitchTrees$ui_tooling_release(boolean z2) {
        this.f29695r = z2;
    }

    public final void setViewInfos$ui_tooling_release(List<ViewInfo> list) {
        this.f29683f = list;
    }
}
