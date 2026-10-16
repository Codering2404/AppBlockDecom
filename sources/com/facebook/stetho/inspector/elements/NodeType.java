package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.json.annotation.JsonValue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum NodeType {
    ELEMENT_NODE(1),
    TEXT_NODE(3),
    PROCESSING_INSTRUCTION_NODE(7),
    COMMENT_NODE(8),
    DOCUMENT_NODE(9),
    DOCUMENT_TYPE_NODE(10),
    DOCUMENT_FRAGMENT_NODE(11);

    private final int mValue;

    NodeType(int i3) {
        this.mValue = i3;
    }

    @JsonValue
    public int getProtocolValue() {
        return this.mValue;
    }
}
