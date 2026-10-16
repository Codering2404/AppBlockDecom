package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.Util;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ElementInfo {
    public final List<Object> children;
    public final Object element;

    @Nullable
    public final Object parentElement;

    ElementInfo(Object obj, @Nullable Object obj2, List<Object> list) {
        this.element = Util.throwIfNull(obj);
        this.parentElement = obj2;
        this.children = ListUtil.copyToImmutableList(list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ElementInfo) {
            ElementInfo elementInfo = (ElementInfo) obj;
            if (this.element == elementInfo.element && this.parentElement == elementInfo.parentElement && ListUtil.identityEquals(this.children, elementInfo.children)) {
                return true;
            }
        }
        return false;
    }
}
