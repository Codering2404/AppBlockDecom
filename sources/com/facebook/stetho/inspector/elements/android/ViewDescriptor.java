package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewDebug;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.ReflectionUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor<View> {
    private static final String ACCESSIBILITY_STYLE_RULE_NAME = "Accessibility Properties";
    private static final String ID_NAME = "id";
    private static final String NONE_MAPPING = "<no mapping>";
    private static final String NONE_VALUE = "(none)";
    private static final String VIEW_STYLE_RULE_NAME = "<this_view>";
    private static final boolean sHasSupportNodeInfo;
    private final MethodInvoker mMethodInvoker;

    @Nullable
    private volatile List<ViewCSSProperty> mViewProperties;

    @Nullable
    private Pattern mWordBoundaryPattern;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class FieldBackedCSSProperty extends ViewCSSProperty {
        private final Field mField;

        public FieldBackedCSSProperty(Field field, String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mField = field;
            field.setAccessible(true);
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewDescriptor.ViewCSSProperty
        public Object getValue(View view) throws IllegalAccessException, InvocationTargetException {
            return this.mField.get(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MethodBackedCSSProperty extends ViewCSSProperty {
        private final Method mMethod;

        public MethodBackedCSSProperty(Method method, String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mMethod = method;
            method.setAccessible(true);
        }

        @Override // com.facebook.stetho.inspector.elements.android.ViewDescriptor.ViewCSSProperty
        public Object getValue(View view) throws IllegalAccessException, InvocationTargetException {
            return this.mMethod.invoke(view, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class ViewCSSProperty {
        private final ViewDebug.ExportedProperty mAnnotation;
        private final String mCSSName;

        public ViewCSSProperty(String str, @Nullable ViewDebug.ExportedProperty exportedProperty) {
            this.mCSSName = str;
            this.mAnnotation = exportedProperty;
        }

        @Nullable
        public final ViewDebug.ExportedProperty getAnnotation() {
            return this.mAnnotation;
        }

        public final String getCSSName() {
            return this.mCSSName;
        }

        public abstract Object getValue(View view) throws IllegalAccessException, InvocationTargetException;
    }

    static {
        sHasSupportNodeInfo = ReflectionUtil.tryGetClassForName("androidx.core.view.accessibility.AccessibilityNodeInfoCompat") != null;
    }

    public ViewDescriptor() {
        this(new MethodInvoker());
    }

    private static boolean canFlagsBeMappedToString(@Nullable ViewDebug.ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.flagMapping() == null || exportedProperty.flagMapping().length <= 0) ? false : true;
    }

    private static boolean canIntBeMappedToString(@Nullable ViewDebug.ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.mapping() == null || exportedProperty.mapping().length <= 0) ? false : true;
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0 || Character.isTitleCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toTitleCase(sb.charAt(0)));
        return sb.toString();
    }

    private String convertViewPropertyNameToCSSName(String str) {
        String[] strArrSplit = getWordBoundaryPattern().split(str);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            if (!strArrSplit[i3].equals("get") && !strArrSplit[i3].equals("m")) {
                sb.append(strArrSplit[i3].toLowerCase());
                if (i3 < strArrSplit.length - 1) {
                    sb.append('-');
                }
            }
        }
        return sb.toString();
    }

    @Nullable
    private static String getIdAttribute(View view) {
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id);
    }

    private void getIdStyle(View view, StyleAccumulator styleAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute == null) {
            styleAccumulator.store("id", NONE_VALUE, false);
        } else {
            styleAccumulator.store("id", idAttribute, false);
        }
    }

    private void getStyleFromInteger(String str, Integer num, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String str2 = IntegerFormatter.getInstance().format(num, exportedProperty);
        if (canIntBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, str2 + " (" + mapIntToStringUsingAnnotation(num.intValue(), exportedProperty) + ")", false);
            return;
        }
        if (canFlagsBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, str2 + " (" + mapFlagsToStringUsingAnnotation(num.intValue(), exportedProperty) + ")", false);
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (num.intValue() != 0 || canFlagsBeMappedToString(exportedProperty) || canIntBeMappedToString(exportedProperty)) {
            bool = Boolean.FALSE;
        }
        styleAccumulator.store(str, str2, bool.booleanValue());
    }

    private void getStyleFromValue(View view, String str, Object obj, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        if (str.equals("id")) {
            getIdStyle(view, styleAccumulator);
            return;
        }
        if (obj instanceof Integer) {
            getStyleFromInteger(str, (Integer) obj, exportedProperty, styleAccumulator);
            return;
        }
        if (obj instanceof Float) {
            styleAccumulator.store(str, String.valueOf(obj), ((Float) obj).floatValue() == 0.0f);
            return;
        }
        if (obj instanceof Boolean) {
            styleAccumulator.store(str, String.valueOf(obj), false);
            return;
        }
        if (obj instanceof Short) {
            styleAccumulator.store(str, String.valueOf(obj), ((Short) obj).shortValue() == 0);
            return;
        }
        if (obj instanceof Long) {
            styleAccumulator.store(str, String.valueOf(obj), ((Long) obj).longValue() == 0);
            return;
        }
        if (obj instanceof Double) {
            styleAccumulator.store(str, String.valueOf(obj), ((Double) obj).doubleValue() == 0.0d);
            return;
        }
        if (obj instanceof Byte) {
            styleAccumulator.store(str, String.valueOf(obj), ((Byte) obj).byteValue() == 0);
            return;
        }
        if (obj instanceof Character) {
            styleAccumulator.store(str, String.valueOf(obj), ((Character) obj).charValue() == 0);
        } else if (obj instanceof CharSequence) {
            styleAccumulator.store(str, String.valueOf(obj), ((CharSequence) obj).length() == 0);
        } else {
            getStylesFromObject(view, str, obj, exportedProperty, styleAccumulator);
        }
    }

    private void getStylesFromObject(View view, String str, Object obj, @Nullable ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String name;
        String strConvertViewPropertyNameToCSSName;
        if (exportedProperty == null || !exportedProperty.deepExport() || obj == null) {
            return;
        }
        for (Field field : obj.getClass().getFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    name = field.getName();
                    name.getClass();
                    switch (name) {
                        case "rightMargin":
                            strConvertViewPropertyNameToCSSName = "margin-right";
                            break;
                        case "topMargin":
                            strConvertViewPropertyNameToCSSName = "margin-top";
                            break;
                        case "leftMargin":
                            strConvertViewPropertyNameToCSSName = "margin-left";
                            break;
                        case "bottomMargin":
                            strConvertViewPropertyNameToCSSName = "margin-bottom";
                            break;
                        default:
                            String strPrefix = exportedProperty.prefix();
                            if (strPrefix != null) {
                                name = strPrefix + name;
                            }
                            strConvertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                            break;
                    }
                    getStyleFromValue(view, strConvertViewPropertyNameToCSSName, obj2, (ViewDebug.ExportedProperty) field.getAnnotation(ViewDebug.ExportedProperty.class), styleAccumulator);
                } catch (IllegalAccessException e3) {
                    LogUtil.e(e3, "failed to get property of name: \"" + str + "\" of object: " + String.valueOf(obj));
                    return;
                }
            }
        }
    }

    private List<ViewCSSProperty> getViewProperties() {
        if (this.mViewProperties == null) {
            synchronized (this) {
                try {
                    if (this.mViewProperties == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Method method : View.class.getDeclaredMethods()) {
                            ViewDebug.ExportedProperty exportedProperty = (ViewDebug.ExportedProperty) method.getAnnotation(ViewDebug.ExportedProperty.class);
                            if (exportedProperty != null) {
                                arrayList.add(new MethodBackedCSSProperty(method, convertViewPropertyNameToCSSName(method.getName()), exportedProperty));
                            }
                        }
                        for (Field field : View.class.getDeclaredFields()) {
                            ViewDebug.ExportedProperty exportedProperty2 = (ViewDebug.ExportedProperty) field.getAnnotation(ViewDebug.ExportedProperty.class);
                            if (exportedProperty2 != null) {
                                arrayList.add(new FieldBackedCSSProperty(field, convertViewPropertyNameToCSSName(field.getName()), exportedProperty2));
                            }
                        }
                        Collections.sort(arrayList, new Comparator<ViewCSSProperty>() { // from class: com.facebook.stetho.inspector.elements.android.ViewDescriptor.1
                            @Override // java.util.Comparator
                            public int compare(ViewCSSProperty viewCSSProperty, ViewCSSProperty viewCSSProperty2) {
                                return viewCSSProperty.getCSSName().compareTo(viewCSSProperty2.getCSSName());
                            }
                        });
                        this.mViewProperties = Collections.unmodifiableList(arrayList);
                    }
                } finally {
                }
            }
        }
        return this.mViewProperties;
    }

    private Pattern getWordBoundaryPattern() {
        if (this.mWordBoundaryPattern == null) {
            this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
        }
        return this.mWordBoundaryPattern;
    }

    private static String mapFlagsToStringUsingAnnotation(int i3, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        if (!canFlagsBeMappedToString(exportedProperty)) {
            throw new IllegalStateException("Cannot map using this annotation");
        }
        StringBuilder sb = null;
        boolean z2 = false;
        for (ViewDebug.FlagToString flagToString : exportedProperty.flagMapping()) {
            if (flagToString.outputIf() == ((flagToString.mask() & i3) == flagToString.equals())) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                if (z2) {
                    sb.append(" | ");
                }
                sb.append(flagToString.name());
                z2 = true;
            }
        }
        return z2 ? sb.toString() : NONE_MAPPING;
    }

    private static String mapIntToStringUsingAnnotation(int i3, @Nullable ViewDebug.ExportedProperty exportedProperty) {
        if (!canIntBeMappedToString(exportedProperty)) {
            throw new IllegalStateException("Cannot map using this annotation");
        }
        for (ViewDebug.IntToString intToString : exportedProperty.mapping()) {
            if (intToString.from() == i3) {
                return intToString.to();
            }
        }
        return NONE_MAPPING;
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewAndBoundsForHighlighting(View view, Rect rect) {
        return view;
    }

    public ViewDescriptor(MethodInvoker methodInvoker) {
        this.mMethodInvoker = methodInvoker;
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public Object getElementToHighlightAtPosition(View view, int i3, int i4, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onGetAttributes(View view, AttributeAccumulator attributeAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute != null) {
            attributeAccumulator.store("id", idAttribute);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onGetComputedStyles(View view, ComputedStyleAccumulator computedStyleAccumulator) {
        computedStyleAccumulator.store(ViewHierarchyConstants.DIMENSION_LEFT_KEY, Integer.toString(view.getLeft()));
        computedStyleAccumulator.store(ViewHierarchyConstants.DIMENSION_TOP_KEY, Integer.toString(view.getTop()));
        computedStyleAccumulator.store("right", Integer.toString(view.getRight()));
        computedStyleAccumulator.store("bottom", Integer.toString(view.getBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public String onGetNodeName(View view) {
        String name = view.getClass().getName();
        return StringUtil.removePrefix(name, "android.view.", StringUtil.removePrefix(name, "android.widget."));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onGetStyleRuleNames(View view, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        styleRuleNameAccumulator.store(VIEW_STYLE_RULE_NAME, false);
        if (sHasSupportNodeInfo) {
            styleRuleNameAccumulator.store(ACCESSIBILITY_STYLE_RULE_NAME, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onGetStyles(View view, String str, StyleAccumulator styleAccumulator) {
        if (!VIEW_STYLE_RULE_NAME.equals(str)) {
            if (ACCESSIBILITY_STYLE_RULE_NAME.equals(str) && sHasSupportNodeInfo) {
                boolean ignored = AccessibilityNodeInfoWrapper.getIgnored(view);
                getStyleFromValue(view, "ignored", Boolean.valueOf(ignored), null, styleAccumulator);
                if (ignored) {
                    getStyleFromValue(view, "ignored-reasons", AccessibilityNodeInfoWrapper.getIgnoredReasons(view), null, styleAccumulator);
                }
                getStyleFromValue(view, "focusable", Boolean.valueOf(!ignored), null, styleAccumulator);
                if (ignored) {
                    return;
                }
                getStyleFromValue(view, "focusable-reasons", AccessibilityNodeInfoWrapper.getFocusableReasons(view), null, styleAccumulator);
                getStyleFromValue(view, "focused", Boolean.valueOf(AccessibilityNodeInfoWrapper.getIsAccessibilityFocused(view)), null, styleAccumulator);
                getStyleFromValue(view, "description", AccessibilityNodeInfoWrapper.getDescription(view), null, styleAccumulator);
                getStyleFromValue(view, "actions", AccessibilityNodeInfoWrapper.getActions(view), null, styleAccumulator);
                return;
            }
            return;
        }
        List<ViewCSSProperty> viewProperties = getViewProperties();
        int size = viewProperties.size();
        for (int i3 = 0; i3 < size; i3++) {
            ViewCSSProperty viewCSSProperty = viewProperties.get(i3);
            try {
                getStyleFromValue(view, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(view), viewCSSProperty.getAnnotation(), styleAccumulator);
            } catch (Exception e3) {
                if (!(e3 instanceof IllegalAccessException) && !(e3 instanceof InvocationTargetException)) {
                    throw ExceptionUtil.propagate(e3);
                }
                LogUtil.e(e3, "failed to get style property " + viewCSSProperty.getCSSName() + " of element= " + view.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public void onSetAttributesAsText(View view, String str) {
        for (Map.Entry<String, String> entry : Descriptor.parseSetAttributesAsTextArg(str).entrySet()) {
            this.mMethodInvoker.invoke(view, "set" + capitalize(entry.getKey()), entry.getValue());
        }
    }
}
