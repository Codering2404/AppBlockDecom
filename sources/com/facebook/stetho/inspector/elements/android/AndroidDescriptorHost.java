package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
interface AndroidDescriptorHost extends Descriptor.Host {
    @Nullable
    HighlightableDescriptor getHighlightableDescriptor(@Nullable Object obj);
}
