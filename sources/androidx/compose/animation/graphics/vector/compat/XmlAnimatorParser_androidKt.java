package androidx.compose.animation.graphics.vector.compat;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.PathInterpolator;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.graphics.res.AnimatorResources_androidKt;
import androidx.compose.animation.graphics.vector.AnimatorSet;
import androidx.compose.animation.graphics.vector.Keyframe;
import androidx.compose.animation.graphics.vector.ObjectAnimator;
import androidx.compose.animation.graphics.vector.Ordering;
import androidx.compose.animation.graphics.vector.PropertyValuesHolder;
import androidx.compose.animation.graphics.vector.PropertyValuesHolder1D;
import androidx.compose.animation.graphics.vector.PropertyValuesHolder2D;
import androidx.compose.animation.graphics.vector.PropertyValuesHolderColor;
import androidx.compose.animation.graphics.vector.PropertyValuesHolderFloat;
import androidx.compose.animation.graphics.vector.PropertyValuesHolderInt;
import androidx.compose.animation.graphics.vector.PropertyValuesHolderPath;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.core.graphics.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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
public final class XmlAnimatorParser_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ValueType f4490a = ValueType.f4484a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4491a;

        static {
            int[] iArr = new int[ValueType.values().length];
            try {
                iArr[ValueType.f4484a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValueType.f4485b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValueType.f4486c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValueType.f4487d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f4491a = iArr;
        }
    }

    private static final RepeatMode c(int i3) {
        return i3 == 2 ? RepeatMode.f4053b : RepeatMode.f4052a;
    }

    private static final Easing d(TypedArray typedArray, Resources resources, Resources.Theme theme, int i3, Easing easing) {
        int resourceId = typedArray.getResourceId(i3, 0);
        return resourceId == 0 ? easing : AnimatorResources_androidKt.C(theme, resources, resourceId);
    }

    private static final Keyframe e(TypedArray typedArray, float f3, Easing easing, ValueType valueType, int i3) {
        int i4 = WhenMappings.f4491a[valueType.ordinal()];
        if (i4 == 1) {
            return new Keyframe(f3, Float.valueOf(typedArray.getFloat(i3, 0.0f)), easing);
        }
        if (i4 == 2) {
            return new Keyframe(f3, Integer.valueOf(typedArray.getInt(i3, 0)), easing);
        }
        if (i4 == 3) {
            return new Keyframe(f3, Color.n(ColorKt.b(typedArray.getColor(i3, 0))), easing);
        }
        if (i4 == 4) {
            return new Keyframe(f3, VectorKt.a(typedArray.getString(i3)), easing);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final PropertyValuesHolder1D f(TypedArray typedArray, String str, int i3, int i4, int i5, Easing easing, Function2 function2) {
        int i6 = typedArray.getInt(i3, 4);
        TypedValue typedValuePeekValue = typedArray.peekValue(i4);
        boolean z2 = typedValuePeekValue != null;
        int i7 = typedValuePeekValue != null ? typedValuePeekValue.type : 4;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i5);
        boolean z3 = typedValuePeekValue2 != null;
        ValueType valueTypeH = h(i6, i7, typedValuePeekValue2 != null ? typedValuePeekValue2.type : 4);
        ArrayList arrayList = new ArrayList();
        if (valueTypeH == null && (z2 || z3)) {
            valueTypeH = ValueType.f4484a;
        }
        if (z2) {
            Intrinsics.checkNotNull(valueTypeH);
            arrayList.add(e(typedArray, 0.0f, easing, valueTypeH, i4));
        }
        if (z3) {
            Intrinsics.checkNotNull(valueTypeH);
            arrayList.add(e(typedArray, 1.0f, easing, valueTypeH, i5));
        }
        ValueType valueType = (ValueType) function2.invoke(valueTypeH, arrayList);
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: androidx.compose.animation.graphics.vector.compat.XmlAnimatorParser_androidKt$getPropertyValuesHolder1D$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d(Float.valueOf(((Keyframe) obj).a()), Float.valueOf(((Keyframe) obj2).a()));
                }
            });
        }
        int i8 = WhenMappings.f4491a[valueType.ordinal()];
        if (i8 == 1) {
            return new PropertyValuesHolderFloat(str, arrayList);
        }
        if (i8 == 2) {
            return new PropertyValuesHolderInt(str, arrayList);
        }
        if (i8 == 3) {
            return new PropertyValuesHolderColor(str, arrayList);
        }
        if (i8 == 4) {
            return new PropertyValuesHolderPath(str, arrayList);
        }
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ PropertyValuesHolder1D g(TypedArray typedArray, String str, int i3, int i4, int i5, Easing easing, Function2 function2, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            function2 = new Function2<ValueType, List<Keyframe<Object>>, ValueType>() { // from class: androidx.compose.animation.graphics.vector.compat.XmlAnimatorParser_androidKt$getPropertyValuesHolder1D$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ValueType invoke(ValueType valueType, List list) {
                    return valueType == null ? XmlAnimatorParser_androidKt.f4490a : valueType;
                }
            };
        }
        return f(typedArray, str, i3, i4, i5, easing, function2);
    }

    private static final ValueType h(int i3, int... iArr) {
        if (i3 == 0) {
            return ValueType.f4484a;
        }
        if (i3 == 1) {
            return ValueType.f4485b;
        }
        if (i3 == 2) {
            return ValueType.f4487d;
        }
        if (i3 == 3) {
            return ValueType.f4486c;
        }
        for (int i4 : iArr) {
            if (28 > i4 || i4 >= 32) {
                return null;
            }
        }
        return ValueType.f4486c;
    }

    public static final AnimatorSet i(XmlPullParser xmlPullParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        int[] iArrE = AndroidVectorResources.f4469a.e();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrE, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrE);
        }
        try {
            int i3 = typedArrayObtainAttributes.getInt(0, 0);
            ArrayList arrayList = new ArrayList();
            xmlPullParser.next();
            while (!XmlPullParserUtils_androidKt.a(xmlPullParser) && (xmlPullParser.getEventType() != 3 || !Intrinsics.areEqual(xmlPullParser.getName(), "set"))) {
                if (xmlPullParser.getEventType() == 2) {
                    String name = xmlPullParser.getName();
                    if (Intrinsics.areEqual(name, "set")) {
                        arrayList.add(i(xmlPullParser, resources, theme, attributeSet));
                    } else if (Intrinsics.areEqual(name, "objectAnimator")) {
                        arrayList.add(l(xmlPullParser, resources, theme, attributeSet));
                    }
                }
                xmlPullParser.next();
            }
            AnimatorSet animatorSet = new AnimatorSet(arrayList, i3 != 0 ? Ordering.f4421b : Ordering.f4420a);
            typedArrayObtainAttributes.recycle();
            return animatorSet;
        } catch (Throwable th) {
            typedArrayObtainAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Easing j(XmlPullParser xmlPullParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        String name = xmlPullParser.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2140409460:
                    if (name.equals("pathInterpolator")) {
                        int[] iArrK = AndroidVectorResources.f4469a.k();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrK, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(attributeSet, iArrK);
                        }
                        try {
                            String string = typedArrayObtainAttributes.getString(4);
                            return string != null ? AnimatorResources_androidKt.D(new PathInterpolator(PathParser.e(string))) : (typedArrayObtainAttributes.hasValue(2) && typedArrayObtainAttributes.hasValue(3)) ? new CubicBezierEasing(typedArrayObtainAttributes.getFloat(0, 0.0f), typedArrayObtainAttributes.getFloat(1, 0.0f), typedArrayObtainAttributes.getFloat(2, 1.0f), typedArrayObtainAttributes.getFloat(3, 1.0f)) : AnimatorResources_androidKt.D(new PathInterpolator(typedArrayObtainAttributes.getFloat(0, 0.0f), typedArrayObtainAttributes.getFloat(1, 0.0f)));
                        } finally {
                        }
                    }
                    break;
                case -2120889007:
                    if (name.equals("anticipateInterpolator")) {
                        int[] iArrF = AndroidVectorResources.f4469a.f();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrF, 0, 0)) == null) {
                            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrF);
                        }
                        try {
                            return AnimatorResources_androidKt.n(typedArrayObtainAttributes.getFloat(0, 2.0f));
                        } finally {
                        }
                    }
                    break;
                case -1248486260:
                    if (name.equals("linearInterpolator")) {
                        return EasingKt.e();
                    }
                    break;
                case -935873468:
                    if (name.equals("accelerateInterpolator")) {
                        int[] iArrA = AndroidVectorResources.f4469a.a();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrA, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(attributeSet, iArrA);
                        }
                        try {
                            float f3 = typedArrayObtainAttributes.getFloat(0, 1.0f);
                            return f3 == 1.0f ? AnimatorResources_androidKt.y() : AnimatorResources_androidKt.k(f3);
                        } finally {
                        }
                    }
                    break;
                case -425326737:
                    if (name.equals("bounceInterpolator")) {
                        return AnimatorResources_androidKt.z();
                    }
                    break;
                case 1192587314:
                    if (name.equals("overshootInterpolator")) {
                        int[] iArrJ = AndroidVectorResources.f4469a.j();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrJ, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes4 = resources.obtainAttributes(attributeSet, iArrJ);
                        }
                        try {
                            return AnimatorResources_androidKt.v(typedArrayObtainAttributes.getFloat(0, 2.0f));
                        } finally {
                        }
                    }
                    break;
                case 1472030440:
                    if (name.equals("anticipateOvershootInterpolator")) {
                        int[] iArrF2 = AndroidVectorResources.f4469a.f();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrF2, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes5 = resources.obtainAttributes(attributeSet, iArrF2);
                        }
                        try {
                            return AnimatorResources_androidKt.p(typedArrayObtainAttributes.getFloat(0, 2.0f), typedArrayObtainAttributes.getFloat(1, 1.5f));
                        } finally {
                        }
                    }
                    break;
                case 1962594083:
                    if (name.equals("decelerateInterpolator")) {
                        int[] iArrH = AndroidVectorResources.f4469a.h();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrH, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes6 = resources.obtainAttributes(attributeSet, iArrH);
                        }
                        try {
                            float f4 = typedArrayObtainAttributes.getFloat(0, 1.0f);
                            return f4 == 1.0f ? AnimatorResources_androidKt.A() : AnimatorResources_androidKt.s(f4);
                        } finally {
                        }
                    }
                    break;
                case 2019672672:
                    if (name.equals("accelerateDecelerateInterpolator")) {
                        return AnimatorResources_androidKt.x();
                    }
                    break;
                case 2038238413:
                    if (name.equals("cycleInterpolator")) {
                        int[] iArrG = AndroidVectorResources.f4469a.g();
                        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrG, 0, 0)) == null) {
                            TypedArray typedArrayObtainAttributes7 = resources.obtainAttributes(attributeSet, iArrG);
                        }
                        try {
                            return AnimatorResources_androidKt.q(typedArrayObtainAttributes.getFloat(0, 1.0f));
                        } finally {
                        }
                    }
                    break;
            }
        }
        throw new RuntimeException("Unknown interpolator: " + xmlPullParser.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueType valueType, Easing easing) {
        TypedArray typedArrayObtainAttributes;
        int[] iArrI = AndroidVectorResources.f4469a.i();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrI, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrI);
        }
        if (valueType == null) {
            try {
                valueType = h(typedArrayObtainAttributes.getInt(2, 4), typedArrayObtainAttributes.peekValue(0).type);
                if (valueType == null) {
                    valueType = f4490a;
                }
            } catch (Throwable th) {
                typedArrayObtainAttributes.recycle();
                throw th;
            }
        }
        Pair pairA = TuplesKt.a(e(typedArrayObtainAttributes, typedArrayObtainAttributes.getFloat(3, 0.0f), d(typedArrayObtainAttributes, resources, theme, 1, easing), valueType, 0), valueType);
        typedArrayObtainAttributes.recycle();
        return pairA;
    }

    public static final ObjectAnimator l(XmlPullParser xmlPullParser, Resources resources, Resources.Theme theme, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        TypedArray typedArrayObtainAttributes2;
        int i3;
        int i4;
        XmlPullParser xmlPullParser2;
        AndroidVectorResources androidVectorResources = AndroidVectorResources.f4469a;
        int[] iArrD = androidVectorResources.d();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrD, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrD);
        }
        TypedArray typedArray = typedArrayObtainAttributes;
        try {
            int[] iArrL = androidVectorResources.l();
            if (theme == null || (typedArrayObtainAttributes2 = theme.obtainStyledAttributes(attributeSet, iArrL, 0, 0)) == null) {
                typedArrayObtainAttributes2 = resources.obtainAttributes(attributeSet, iArrL);
            }
            try {
                Easing easingD = d(typedArray, resources, theme, 0, AnimatorResources_androidKt.x());
                ArrayList arrayList = new ArrayList();
                String string = typedArrayObtainAttributes2.getString(1);
                if (string != null) {
                    String string2 = typedArrayObtainAttributes2.getString(2);
                    Intrinsics.checkNotNull(string2);
                    String string3 = typedArrayObtainAttributes2.getString(3);
                    Intrinsics.checkNotNull(string3);
                    arrayList.add(new PropertyValuesHolder2D(string2, string3, VectorKt.a(string), easingD));
                    i3 = 3;
                    i4 = 2;
                } else {
                    String string4 = typedArrayObtainAttributes2.getString(0);
                    if (string4 != null) {
                        i3 = 3;
                        i4 = 2;
                        arrayList.add(g(typedArray, string4, 7, 5, 6, easingD, null, 32, null));
                    } else {
                        i3 = 3;
                        i4 = 2;
                    }
                    xmlPullParser.next();
                    while (!XmlPullParserUtils_androidKt.a(xmlPullParser) && (xmlPullParser.getEventType() != i3 || !Intrinsics.areEqual(xmlPullParser.getName(), "objectAnimator"))) {
                        if (xmlPullParser.getEventType() == i4 && Intrinsics.areEqual(xmlPullParser.getName(), "propertyValuesHolder")) {
                            xmlPullParser2 = xmlPullParser;
                            arrayList.add(m(xmlPullParser2, resources, theme, attributeSet, easingD));
                        } else {
                            xmlPullParser2 = xmlPullParser;
                        }
                        xmlPullParser2.next();
                    }
                }
                ObjectAnimator objectAnimator = new ObjectAnimator(typedArray.getInt(1, 300), typedArray.getInt(i4, 0), typedArray.getInt(i3, 0), c(typedArray.getInt(4, 0)), arrayList);
                typedArrayObtainAttributes2.recycle();
                typedArray.recycle();
                return objectAnimator;
            } catch (Throwable th) {
                typedArrayObtainAttributes2.recycle();
                throw th;
            }
        } catch (Throwable th2) {
            typedArray.recycle();
            throw th2;
        }
    }

    private static final PropertyValuesHolder m(final XmlPullParser xmlPullParser, final Resources resources, final Resources.Theme theme, final AttributeSet attributeSet, final Easing easing) {
        TypedArray typedArrayObtainAttributes;
        int[] iArrM = AndroidVectorResources.f4469a.m();
        if (theme == null || (typedArrayObtainAttributes = theme.obtainStyledAttributes(attributeSet, iArrM, 0, 0)) == null) {
            typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, iArrM);
        }
        TypedArray typedArray = typedArrayObtainAttributes;
        try {
            String string = typedArray.getString(3);
            Intrinsics.checkNotNull(string);
            return f(typedArray, string, 2, 0, 1, easing, new Function2<ValueType, List<Keyframe<Object>>, ValueType>() { // from class: androidx.compose.animation.graphics.vector.compat.XmlAnimatorParser_androidKt$parsePropertyValuesHolder$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ValueType invoke(ValueType valueType, List list) throws XmlPullParserException, IOException {
                    XmlPullParser xmlPullParser2 = xmlPullParser;
                    Resources resources2 = resources;
                    Resources.Theme theme2 = theme;
                    AttributeSet attributeSet2 = attributeSet;
                    Easing easing2 = easing;
                    xmlPullParser2.next();
                    ValueType valueType2 = null;
                    while (!XmlPullParserUtils_androidKt.a(xmlPullParser2) && (xmlPullParser2.getEventType() != 3 || !Intrinsics.areEqual(xmlPullParser2.getName(), "propertyValuesHolder"))) {
                        if (xmlPullParser2.getEventType() == 2 && Intrinsics.areEqual(xmlPullParser2.getName(), "keyframe")) {
                            Pair pairK = XmlAnimatorParser_androidKt.k(resources2, theme2, attributeSet2, valueType, easing2);
                            Keyframe keyframe = (Keyframe) pairK.a();
                            ValueType valueType3 = (ValueType) pairK.b();
                            if (valueType2 == null) {
                                valueType2 = valueType3;
                            }
                            list.add(keyframe);
                        }
                        xmlPullParser2.next();
                    }
                    return valueType2 == null ? valueType == null ? XmlAnimatorParser_androidKt.f4490a : valueType : valueType2;
                }
            });
        } finally {
            typedArray.recycle();
        }
    }
}
