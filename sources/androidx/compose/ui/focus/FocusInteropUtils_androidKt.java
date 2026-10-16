package androidx.compose.ui.focus;

import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidComposeView;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FocusInteropUtils_androidKt {
    public static final Rect a(View view, View view2) {
        FocusInteropUtils.Companion companion = FocusInteropUtils.f25457a;
        view.getLocationInWindow(companion.a());
        int i3 = companion.a()[0];
        int i4 = companion.a()[1];
        view2.getLocationInWindow(companion.a());
        float f3 = i3 - companion.a()[0];
        float f4 = i4 - companion.a()[1];
        return new Rect(f3, f4, view.getWidth() + f3, view.getHeight() + f4);
    }

    public static final boolean b(View view, Integer num, android.graphics.Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !view.hasFocus()) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return view.requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : view.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, view.hasFocus() ? view.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    public static final Integer c(int i3) {
        FocusDirection.Companion companion = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion.h())) {
            return 33;
        }
        if (FocusDirection.l(i3, companion.a())) {
            return 130;
        }
        if (FocusDirection.l(i3, companion.d())) {
            return 17;
        }
        if (FocusDirection.l(i3, companion.g())) {
            return 66;
        }
        if (FocusDirection.l(i3, companion.e())) {
            return 2;
        }
        return FocusDirection.l(i3, companion.f()) ? 1 : null;
    }

    public static final FocusDirection d(int i3) {
        if (i3 == 1) {
            return FocusDirection.i(FocusDirection.f25444b.f());
        }
        if (i3 == 2) {
            return FocusDirection.i(FocusDirection.f25444b.e());
        }
        if (i3 == 17) {
            return FocusDirection.i(FocusDirection.f25444b.d());
        }
        if (i3 == 33) {
            return FocusDirection.i(FocusDirection.f25444b.h());
        }
        if (i3 == 66) {
            return FocusDirection.i(FocusDirection.f25444b.g());
        }
        if (i3 != 130) {
            return null;
        }
        return FocusDirection.i(FocusDirection.f25444b.a());
    }

    public static final LayoutDirection e(int i3) {
        if (i3 == 0) {
            return LayoutDirection.f30001a;
        }
        if (i3 != 1) {
            return null;
        }
        return LayoutDirection.f30002b;
    }
}
