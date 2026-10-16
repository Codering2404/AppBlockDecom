package com.facebook.stetho.common.android;

import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface FragmentManagerAccessor<FRAGMENT_MANAGER, FRAGMENT> {
    @Nullable
    List<FRAGMENT> getAddedFragments(FRAGMENT_MANAGER fragment_manager);
}
