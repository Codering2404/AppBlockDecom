package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class InAppMessageParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f57249a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f57250a = new HashSet();

        public Builder a(int i3) {
            this.f57250a.add(Integer.valueOf(i3));
            return this;
        }

        public InAppMessageParams b() {
            return new InAppMessageParams(this.f57250a, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageCategoryId {
    }

    /* synthetic */ InAppMessageParams(Set set, zzdq zzdqVar) {
        this.f57249a = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    public static Builder a() {
        return new Builder();
    }

    final ArrayList b() {
        return this.f57249a;
    }
}
