package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface NodeDescriptor<E> extends ThreadBound {
    void getAttributes(E e3, AttributeAccumulator attributeAccumulator);

    void getChildren(E e3, Accumulator<Object> accumulator);

    void getComputedStyles(E e3, ComputedStyleAccumulator computedStyleAccumulator);

    String getLocalName(E e3);

    String getNodeName(E e3);

    NodeType getNodeType(E e3);

    @Nullable
    String getNodeValue(E e3);

    void getStyleRuleNames(E e3, StyleRuleNameAccumulator styleRuleNameAccumulator);

    void getStyles(E e3, String str, StyleAccumulator styleAccumulator);

    void hook(E e3);

    void setAttributesAsText(E e3, String str);

    void setStyle(E e3, String str, String str2, String str3);

    void unhook(E e3);
}
