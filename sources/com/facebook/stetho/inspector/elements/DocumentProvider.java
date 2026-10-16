package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface DocumentProvider extends ThreadBound {
    void dispose();

    @Nullable
    NodeDescriptor getNodeDescriptor(@Nullable Object obj);

    @Nullable
    Object getRootElement();

    void hideHighlight();

    void highlightElement(Object obj, int i3);

    void setAttributesAsText(Object obj, String str);

    void setInspectModeEnabled(boolean z2);

    void setListener(DocumentProviderListener documentProviderListener);
}
