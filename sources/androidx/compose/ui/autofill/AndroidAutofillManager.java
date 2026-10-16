package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsListener;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidAutofillManager extends AutofillManager implements SemanticsListener, FocusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PlatformAutofillManager f25195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SemanticsOwner f25196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f25197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectManager f25198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f25199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f25200f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AutofillId f25201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableIntSet f25202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f25203i;

    public AndroidAutofillManager(PlatformAutofillManager platformAutofillManager, SemanticsOwner semanticsOwner, View view, RectManager rectManager, String str) {
        this.f25195a = platformAutofillManager;
        this.f25196b = semanticsOwner;
        this.f25197c = view;
        this.f25198d = rectManager;
        this.f25199e = str;
        view.setImportantForAutofill(1);
        AutofillIdCompat autofillIdCompatA = ViewCompatShims.a(view);
        AutofillId autofillIdA = autofillIdCompatA != null ? autofillIdCompatA.a() : null;
        if (autofillIdA == null) {
            InlineClassHelperKt.d("Required value was null.");
            throw new KotlinNothingValueException();
        }
        this.f25201g = autofillIdA;
        this.f25202h = new MutableIntSet(0, 1, null);
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public void a(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2) {
        SemanticsInfo semanticsInfoQ;
        SemanticsConfiguration semanticsConfigurationQ;
        SemanticsInfo semanticsInfoQ2;
        SemanticsConfiguration semanticsConfigurationQ2;
        if (focusTargetModifierNode != null && (semanticsInfoQ2 = DelegatableNodeKt.q(focusTargetModifierNode)) != null && (semanticsConfigurationQ2 = semanticsInfoQ2.Q()) != null && AndroidAutofillManager_androidKt.d(semanticsConfigurationQ2)) {
            this.f25195a.b(this.f25197c, semanticsInfoQ2.v());
        }
        if (focusTargetModifierNode2 == null || (semanticsInfoQ = DelegatableNodeKt.q(focusTargetModifierNode2)) == null || (semanticsConfigurationQ = semanticsInfoQ.Q()) == null || !AndroidAutofillManager_androidKt.d(semanticsConfigurationQ)) {
            return;
        }
        final int iV = semanticsInfoQ.v();
        this.f25198d.e().l(iV, new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$onFocusChanged$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public final void c(int i3, int i4, int i5, int i6) {
                this.f25204a.e().e(this.f25204a.f25197c, iV, new Rect(i3, i4, i5, i6));
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.compose.ui.semantics.SemanticsListener
    public void b(SemanticsInfo semanticsInfo, SemanticsConfiguration semanticsConfiguration) {
        AnnotatedString annotatedString;
        AnnotatedString annotatedString2;
        SemanticsConfiguration semanticsConfigurationQ = semanticsInfo.Q();
        final int iV = semanticsInfo.v();
        String strK = (semanticsConfiguration == null || (annotatedString2 = (AnnotatedString) SemanticsConfigurationKt.a(semanticsConfiguration, SemanticsProperties.f28517a.o())) == null) ? null : annotatedString2.k();
        String strK2 = (semanticsConfigurationQ == null || (annotatedString = (AnnotatedString) SemanticsConfigurationKt.a(semanticsConfigurationQ, SemanticsProperties.f28517a.o())) == null) ? null : annotatedString.k();
        boolean z2 = false;
        if (strK != strK2) {
            if (strK == null) {
                this.f25195a.d(this.f25197c, iV, true);
            } else if (strK2 == null) {
                this.f25195a.d(this.f25197c, iV, false);
            } else if (Intrinsics.areEqual((ContentDataType) SemanticsConfigurationKt.a(semanticsConfigurationQ, SemanticsProperties.f28517a.c()), ContentDataType.f25250a.a())) {
                this.f25195a.a(this.f25197c, iV, AutofillApi26Helper.f25213a.b(strK2.toString()));
            }
        }
        if (!ComposeUiFlags.f25107g) {
            Boolean bool = semanticsConfiguration != null ? (Boolean) SemanticsConfigurationKt.a(semanticsConfiguration, SemanticsProperties.f28517a.i()) : null;
            Boolean bool2 = semanticsConfigurationQ != null ? (Boolean) SemanticsConfigurationKt.a(semanticsConfigurationQ, SemanticsProperties.f28517a.i()) : null;
            Boolean bool3 = Boolean.TRUE;
            if (!Intrinsics.areEqual(bool, bool3) && Intrinsics.areEqual(bool2, bool3) && AndroidAutofillManager_androidKt.d(semanticsConfigurationQ)) {
                this.f25198d.e().l(iV, new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$onSemanticsChanged$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    public final void c(int i3, int i4, int i5, int i6) {
                        this.f25206a.e().e(this.f25206a.f25197c, iV, new Rect(i3, i4, i5, i6));
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
                        return Unit.f139807a;
                    }
                });
            }
            if (Intrinsics.areEqual(bool, bool3) && !Intrinsics.areEqual(bool2, bool3) && AndroidAutofillManager_androidKt.d(semanticsConfiguration)) {
                this.f25195a.b(this.f25197c, iV);
            }
        }
        boolean z3 = semanticsConfiguration != null && AndroidAutofillManager_androidKt.e(semanticsConfiguration);
        if (semanticsConfigurationQ != null && AndroidAutofillManager_androidKt.e(semanticsConfigurationQ)) {
            z2 = true;
        }
        if (z3 != z2) {
            if (z2) {
                this.f25202h.g(iV);
            } else {
                this.f25202h.r(iV);
            }
        }
    }

    public final PlatformAutofillManager e() {
        return this.f25195a;
    }

    public final void f(SemanticsInfo semanticsInfo) {
        if (this.f25202h.r(semanticsInfo.v())) {
            this.f25195a.d(this.f25197c, semanticsInfo.v(), false);
        }
    }

    public final void g() {
        if (this.f25202h.c() && this.f25203i) {
            this.f25195a.commit();
            this.f25203i = false;
        }
        if (this.f25202h.d()) {
            this.f25203i = true;
        }
    }

    public final void h(SemanticsInfo semanticsInfo) {
        if (this.f25202h.r(semanticsInfo.v())) {
            this.f25195a.d(this.f25197c, semanticsInfo.v(), false);
        }
    }

    public final void i(SemanticsInfo semanticsInfo) {
        SemanticsConfiguration semanticsConfigurationQ = semanticsInfo.Q();
        if (semanticsConfigurationQ == null || !AndroidAutofillManager_androidKt.e(semanticsConfigurationQ)) {
            return;
        }
        this.f25202h.g(semanticsInfo.v());
        this.f25195a.d(this.f25197c, semanticsInfo.v(), true);
    }

    public final void j(SemanticsInfo semanticsInfo, int i3) {
        if (this.f25202h.r(i3)) {
            this.f25195a.d(this.f25197c, i3, false);
        }
        SemanticsConfiguration semanticsConfigurationQ = semanticsInfo.Q();
        if (semanticsConfigurationQ == null || !AndroidAutofillManager_androidKt.e(semanticsConfigurationQ)) {
            return;
        }
        this.f25202h.g(semanticsInfo.v());
        this.f25195a.d(this.f25197c, semanticsInfo.v(), true);
    }

    public final void k(SparseArray sparseArray) {
        SemanticsConfiguration semanticsConfigurationQ;
        AccessibilityAction accessibilityAction;
        Function1 function1;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iKeyAt = sparseArray.keyAt(i3);
            AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.f25213a;
            if (autofillApi26Helper.e(autofillValue)) {
                SemanticsInfo semanticsInfoA = this.f25196b.a(iKeyAt);
                if (semanticsInfoA != null && (semanticsConfigurationQ = semanticsInfoA.Q()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationQ, SemanticsActions.f28471a.k())) != null && (function1 = (Function1) accessibilityAction.a()) != null) {
                }
            } else if (autofillApi26Helper.c(autofillValue)) {
                Log.w("ComposeAutofillManager", "Auto filling Date fields is not yet supported.");
            } else if (autofillApi26Helper.d(autofillValue)) {
                Log.w("ComposeAutofillManager", "Auto filling dropdown lists is not yet supported.");
            } else if (autofillApi26Helper.f(autofillValue)) {
                Log.w("ComposeAutofillManager", "Auto filling toggle fields are not yet supported.");
            }
        }
    }

    public final void l(ViewStructure viewStructure) {
        AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.f25213a;
        SemanticsInfo semanticsInfoC = this.f25196b.c();
        PopulateViewStructure_androidKt.a(viewStructure, semanticsInfoC, this.f25201g, this.f25199e, this.f25198d);
        MutableObjectList mutableObjectListH = ObjectListKt.h(semanticsInfoC, viewStructure);
        while (mutableObjectListH.h()) {
            Object objA = mutableObjectListH.A(mutableObjectListH.f3082b - 1);
            Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type android.view.ViewStructure");
            ViewStructure viewStructure2 = (ViewStructure) objA;
            Object objA2 = mutableObjectListH.A(mutableObjectListH.f3082b - 1);
            Intrinsics.checkNotNull(objA2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsInfo");
            List listR = ((SemanticsInfo) objA2).R();
            int size = listR.size();
            for (int i3 = 0; i3 < size; i3++) {
                SemanticsInfo semanticsInfo = (SemanticsInfo) listR.get(i3);
                if (!semanticsInfo.y() && semanticsInfo.m() && semanticsInfo.u()) {
                    SemanticsConfiguration semanticsConfigurationQ = semanticsInfo.Q();
                    if (semanticsConfigurationQ == null || !AndroidAutofillManager_androidKt.f(semanticsConfigurationQ)) {
                        mutableObjectListH.n(semanticsInfo);
                        mutableObjectListH.n(viewStructure2);
                    } else {
                        ViewStructure viewStructureG = autofillApi26Helper.g(viewStructure2, autofillApi26Helper.a(viewStructure2, 1));
                        PopulateViewStructure_androidKt.a(viewStructureG, semanticsInfo, this.f25201g, this.f25199e, this.f25198d);
                        mutableObjectListH.n(semanticsInfo);
                        mutableObjectListH.n(viewStructureG);
                    }
                }
            }
        }
    }

    public final void m(final SemanticsInfo semanticsInfo) {
        this.f25198d.e().l(semanticsInfo.v(), new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$requestAutofill$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public final void c(int i3, int i4, int i5, int i6) {
                this.f25208a.f25200f.set(i3, i4, i5, i6);
                this.f25208a.e().c(this.f25208a.f25197c, semanticsInfo.v(), this.f25208a.f25200f);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
                return Unit.f139807a;
            }
        });
    }
}
