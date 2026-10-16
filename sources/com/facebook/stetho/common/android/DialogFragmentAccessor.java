package com.facebook.stetho.common.android;

import android.app.Dialog;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface DialogFragmentAccessor<DIALOG_FRAGMENT, FRAGMENT, FRAGMENT_MANAGER> extends FragmentAccessor<FRAGMENT, FRAGMENT_MANAGER> {
    Dialog getDialog(DIALOG_FRAGMENT dialog_fragment);
}
