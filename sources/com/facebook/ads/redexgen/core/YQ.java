package com.facebook.ads.redexgen.core;

import android.content.DialogInterface;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class YQ implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0971Pp A00;

    public YQ(C0971Pp c0971Pp) {
        this.A00 = c0971Pp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        dialogInterface.cancel();
    }
}
