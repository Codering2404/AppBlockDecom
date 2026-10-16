package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class SwipeableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(float f3, float f4, Set set, Function2 function2, float f5, float f6) {
        List listD = d(f3, set);
        int size = listD.size();
        if (size == 0) {
            return f4;
        }
        if (size == 1) {
            return ((Number) listD.get(0)).floatValue();
        }
        float fFloatValue = ((Number) listD.get(0)).floatValue();
        float fFloatValue2 = ((Number) listD.get(1)).floatValue();
        return (f4 > f3 ? f5 > (-f6) && f3 > ((Number) function2.invoke(Float.valueOf(fFloatValue2), Float.valueOf(fFloatValue))).floatValue() : f5 >= f6 || f3 >= ((Number) function2.invoke(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue()) ? fFloatValue2 : fFloatValue;
    }

    private static final List d(float f3, Set set) {
        Object obj;
        Set set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= ((double) f3) + 0.001d) {
                arrayList.add(obj2);
            }
        }
        Object obj3 = null;
        int i3 = 1;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            float fFloatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i4 = 1;
                while (true) {
                    Object obj4 = arrayList.get(i4);
                    float fFloatValue2 = ((Number) obj4).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                        obj = obj4;
                        fFloatValue = fFloatValue2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        Float f4 = (Float) obj;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj5 : set2) {
            if (((Number) obj5).floatValue() >= ((double) f3) - 0.001d) {
                arrayList2.add(obj5);
            }
        }
        if (!arrayList2.isEmpty()) {
            Object obj6 = arrayList2.get(0);
            float fFloatValue3 = ((Number) obj6).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj7 = arrayList2.get(i3);
                    float fFloatValue4 = ((Number) obj7).floatValue();
                    if (Float.compare(fFloatValue3, fFloatValue4) > 0) {
                        obj6 = obj7;
                        fFloatValue3 = fFloatValue4;
                    }
                    if (i3 == lastIndex2) {
                        break;
                    }
                    i3++;
                }
            }
            obj3 = obj6;
        }
        Float f5 = (Float) obj3;
        return f4 == null ? CollectionsKt.listOfNotNull(f5) : f5 == null ? CollectionsKt.listOf(f4) : Intrinsics.areEqual(f4, f5) ? CollectionsKt.listOf(f4) : CollectionsKt.listOf((Object[]) new Float[]{f4, f5});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float e(Map map, Object obj) {
        Object next;
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Map.Entry) next).getValue(), obj)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final Modifier f(Modifier modifier, final SwipeableState swipeableState, final Map map, final Orientation orientation, final boolean z2, final boolean z3, final MutableInteractionSource mutableInteractionSource, final Function2 function2, final ResistanceConfig resistanceConfig, final float f3) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("swipeable");
                inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, swipeableState);
                inspectorInfo.b().c("anchors", map);
                inspectorInfo.b().c("orientation", orientation);
                inspectorInfo.b().c("enabled", Boolean.valueOf(z2));
                inspectorInfo.b().c("reverseDirection", Boolean.valueOf(z3));
                inspectorInfo.b().c("interactionSource", mutableInteractionSource);
                inspectorInfo.b().c("thresholds", function2);
                inspectorInfo.b().c("resistance", resistanceConfig);
                inspectorInfo.b().c("velocityThreshold", Dp.d(f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SwipeableKt$swipeable$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(43594985);
                if (ComposerKt.M()) {
                    ComposerKt.U(43594985, i3, -1, "androidx.compose.material.swipeable.<anonymous> (Swipeable.kt:596)");
                }
                if (map.isEmpty()) {
                    throw new IllegalArgumentException("You must have at least one anchor.");
                }
                if (CollectionsKt.distinct(map.values()).size() != map.size()) {
                    throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.");
                }
                Density density = (Density) composer.q(CompositionLocalsKt.f());
                swipeableState.l(map);
                Map map2 = map;
                Object obj = swipeableState;
                boolean Z = composer.Z(obj) | composer.I(map) | composer.Z(resistanceConfig) | composer.Z(function2) | composer.Z(density) | composer.c(f3);
                SwipeableState swipeableState2 = swipeableState;
                Map map3 = map;
                ResistanceConfig resistanceConfig2 = resistanceConfig;
                Function2 function22 = function2;
                float f4 = f3;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    Object swipeableKt$swipeable$3$3$1 = new SwipeableKt$swipeable$3$3$1(swipeableState2, map3, resistanceConfig2, density, function22, f4, null);
                    composer.w(swipeableKt$swipeable$3$3$1);
                    objG = swipeableKt$swipeable$3$3$1;
                }
                EffectsKt.f(map2, obj, (Function2) objG, composer, 0);
                Modifier.Companion companion = Modifier.b8;
                boolean zX = swipeableState.x();
                DraggableState draggableStateQ = swipeableState.q();
                Orientation orientation2 = orientation;
                boolean z4 = z2;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                boolean Z2 = composer.Z(swipeableState);
                SwipeableState swipeableState3 = swipeableState;
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new SwipeableKt$swipeable$3$4$1(swipeableState3, null);
                    composer.w(objG2);
                }
                Modifier modifierH = DraggableKt.h(companion, draggableStateQ, orientation2, z4, mutableInteractionSource2, zX, null, (Function3) objG2, z3, 32, null);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierH;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }
}
