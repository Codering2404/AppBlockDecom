package com.facebook.stetho.inspector.elements.android;

import android.app.Application;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AndroidDocumentRoot extends AbstractChainedDescriptor<AndroidDocumentRoot> {
    private final Application mApplication;

    public AndroidDocumentRoot(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(AndroidDocumentRoot androidDocumentRoot, Accumulator accumulator) {
        onGetChildren2(androidDocumentRoot, (Accumulator<Object>) accumulator);
    }

    /* JADX INFO: renamed from: onGetChildren, reason: avoid collision after fix types in other method */
    protected void onGetChildren2(AndroidDocumentRoot androidDocumentRoot, Accumulator<Object> accumulator) {
        accumulator.store(this.mApplication);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public String onGetNodeName(AndroidDocumentRoot androidDocumentRoot) {
        return "root";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    public NodeType onGetNodeType(AndroidDocumentRoot androidDocumentRoot) {
        return NodeType.DOCUMENT_NODE;
    }
}
