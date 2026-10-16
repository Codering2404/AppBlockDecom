package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractChainedDescriptor<E> extends Descriptor<E> implements ChainedDescriptor<E> {
    private Descriptor<? super E> mSuper;

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getAttributes(E e3, AttributeAccumulator attributeAccumulator) {
        this.mSuper.getAttributes(e3, attributeAccumulator);
        onGetAttributes(e3, attributeAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getChildren(E e3, Accumulator<Object> accumulator) {
        this.mSuper.getChildren(e3, accumulator);
        onGetChildren(e3, accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public void getComputedStyles(E e3, ComputedStyleAccumulator computedStyleAccumulator) {
        this.mSuper.getComputedStyles(e3, computedStyleAccumulator);
        onGetComputedStyles(e3, computedStyleAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getLocalName(E e3) {
        return onGetLocalName(e3);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeName(E e3) {
        return onGetNodeName(e3);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final NodeType getNodeType(E e3) {
        return onGetNodeType(e3);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final String getNodeValue(E e3) {
        return onGetNodeValue(e3);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyleRuleNames(E e3, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        this.mSuper.getStyleRuleNames(e3, styleRuleNameAccumulator);
        onGetStyleRuleNames(e3, styleRuleNameAccumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void getStyles(E e3, String str, StyleAccumulator styleAccumulator) {
        this.mSuper.getStyles(e3, str, styleAccumulator);
        onGetStyles(e3, str, styleAccumulator);
    }

    final Descriptor<? super E> getSuper() {
        return this.mSuper;
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void hook(E e3) {
        verifyThreadAccess();
        this.mSuper.hook(e3);
        onHook(e3);
    }

    protected String onGetLocalName(E e3) {
        return this.mSuper.getLocalName(e3);
    }

    protected String onGetNodeName(E e3) {
        return this.mSuper.getNodeName(e3);
    }

    protected NodeType onGetNodeType(E e3) {
        return this.mSuper.getNodeType(e3);
    }

    @Nullable
    public String onGetNodeValue(E e3) {
        return this.mSuper.getNodeValue(e3);
    }

    protected void onSetAttributesAsText(E e3, String str) {
        this.mSuper.setAttributesAsText(e3, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setAttributesAsText(E e3, String str) {
        onSetAttributesAsText(e3, str);
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void setStyle(E e3, String str, String str2, String str3) {
        this.mSuper.setStyle(e3, str, str2, str3);
        onSetStyle(e3, str, str2, str3);
    }

    @Override // com.facebook.stetho.inspector.elements.ChainedDescriptor
    public void setSuper(Descriptor<? super E> descriptor) {
        Util.throwIfNull(descriptor);
        Descriptor<? super E> descriptor2 = this.mSuper;
        if (descriptor != descriptor2) {
            if (descriptor2 != null) {
                throw new IllegalStateException();
            }
            this.mSuper = descriptor;
        }
    }

    @Override // com.facebook.stetho.inspector.elements.NodeDescriptor
    public final void unhook(E e3) {
        verifyThreadAccess();
        onUnhook(e3);
        this.mSuper.unhook(e3);
    }

    protected void onHook(E e3) {
    }

    protected void onUnhook(E e3) {
    }

    protected void onGetAttributes(E e3, AttributeAccumulator attributeAccumulator) {
    }

    protected void onGetChildren(E e3, Accumulator<Object> accumulator) {
    }

    protected void onGetComputedStyles(E e3, ComputedStyleAccumulator computedStyleAccumulator) {
    }

    protected void onGetStyleRuleNames(E e3, StyleRuleNameAccumulator styleRuleNameAccumulator) {
    }

    protected void onGetStyles(E e3, String str, StyleAccumulator styleAccumulator) {
    }

    protected void onSetStyle(E e3, String str, String str2, String str3) {
    }
}
