package com.facebook.ads.redexgen.core;

import android.content.DialogInterface;
import android.widget.EditText;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class YR implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText A00;
    public final /* synthetic */ C0971Pp A01;

    public YR(C0971Pp c0971Pp, EditText editText) {
        this.A01 = c0971Pp;
        this.A00 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        this.A01.A03.execute(new Q1(this, dialogInterface));
    }
}
