package androidx.compose.ui.platform;

import android.graphics.Region;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
public final class SemanticsUtils_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f28208a = new Rect(0.0f, 0.0f, 10.0f, 10.0f);

    public static final ScrollObservationScope a(List list, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((ScrollObservationScope) list.get(i4)).d() == i3) {
                return (ScrollObservationScope) list.get(i4);
            }
        }
        return null;
    }

    public static final IntObjectMap b(SemanticsOwner semanticsOwner) {
        SemanticsNode semanticsNodeD = semanticsOwner.d();
        if (!semanticsNodeD.q().u() || !semanticsNodeD.q().m()) {
            return IntObjectMapKt.a();
        }
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(48);
        Rect rectI = semanticsNodeD.i();
        c(new Region(Math.round(rectI.o()), Math.round(rectI.r()), Math.round(rectI.p()), Math.round(rectI.i())), semanticsNodeD, mutableIntObjectMap, semanticsNodeD, new Region());
        return mutableIntObjectMap;
    }

    private static final void c(Region region, SemanticsNode semanticsNode, MutableIntObjectMap mutableIntObjectMap, SemanticsNode semanticsNode2, Region region2) {
        LayoutInfo layoutInfoP;
        boolean z2 = (semanticsNode2.q().u() && semanticsNode2.q().m()) ? false : true;
        if (!region.isEmpty() || semanticsNode2.o() == semanticsNode.o()) {
            if (!z2 || semanticsNode2.x()) {
                Rect rectV = semanticsNode2.v();
                int iRound = Math.round(rectV.o());
                int iRound2 = Math.round(rectV.r());
                int iRound3 = Math.round(rectV.p());
                int iRound4 = Math.round(rectV.i());
                region2.set(iRound, iRound2, iRound3, iRound4);
                int iO = semanticsNode2.o() == semanticsNode.o() ? -1 : semanticsNode2.o();
                if (!region2.op(region, Region.Op.INTERSECT)) {
                    if (semanticsNode2.x()) {
                        SemanticsNode semanticsNodeR = semanticsNode2.r();
                        Rect rectI = (semanticsNodeR == null || (layoutInfoP = semanticsNodeR.p()) == null || !layoutInfoP.u()) ? f28208a : semanticsNodeR.i();
                        mutableIntObjectMap.r(iO, new SemanticsNodeWithAdjustedBounds(semanticsNode2, new android.graphics.Rect(Math.round(rectI.o()), Math.round(rectI.r()), Math.round(rectI.p()), Math.round(rectI.i()))));
                        return;
                    } else {
                        if (iO == -1) {
                            mutableIntObjectMap.r(iO, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                            return;
                        }
                        return;
                    }
                }
                mutableIntObjectMap.r(iO, new SemanticsNodeWithAdjustedBounds(semanticsNode2, region2.getBounds()));
                List listT = semanticsNode2.t();
                for (int size = listT.size() - 1; -1 < size; size--) {
                    if (!((SemanticsNode) listT.get(size)).n().d(SemanticsProperties.f28517a.w())) {
                        c(region, semanticsNode, mutableIntObjectMap, (SemanticsNode) listT.get(size), region2);
                    }
                }
                if (g(semanticsNode2)) {
                    region.op(iRound, iRound2, iRound3, iRound4, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Float d(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfiguration, SemanticsActions.f28471a.h());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (Float) arrayList.get(0);
    }

    public static final TextLayoutResult e(SemanticsConfiguration semanticsConfiguration) {
        Function1 function1;
        ArrayList arrayList = new ArrayList();
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfiguration, SemanticsActions.f28471a.i());
        if (accessibilityAction == null || (function1 = (Function1) accessibilityAction.a()) == null || !((Boolean) function1.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (TextLayoutResult) arrayList.get(0);
    }

    public static final boolean f(SemanticsNode semanticsNode) {
        if (semanticsNode.z()) {
            return true;
        }
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return semanticsConfigurationW.d(semanticsProperties.k()) || semanticsNode.w().d(semanticsProperties.p());
    }

    public static final boolean g(SemanticsNode semanticsNode) {
        if (f(semanticsNode)) {
            return false;
        }
        return semanticsNode.w().p() || semanticsNode.w().e();
    }

    public static final View h(AndroidViewsHandler androidViewsHandler, int i3) {
        Object next;
        Iterator<T> it = androidViewsHandler.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((LayoutNode) ((Map.Entry) next).getKey()).v() == i3) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (AndroidViewHolder) entry.getValue();
        }
        return null;
    }

    public static final String i(int i3) {
        Role.Companion companion = Role.f28457b;
        if (Role.m(i3, companion.a())) {
            return "android.widget.Button";
        }
        if (Role.m(i3, companion.c())) {
            return "android.widget.CheckBox";
        }
        if (Role.m(i3, companion.f())) {
            return "android.widget.RadioButton";
        }
        if (Role.m(i3, companion.e())) {
            return "android.widget.ImageView";
        }
        if (Role.m(i3, companion.d())) {
            return "android.widget.Spinner";
        }
        if (Role.m(i3, companion.i())) {
            return sKeKFMqmvNzY.xQLsdEsfpPrUYIB;
        }
        return null;
    }
}
