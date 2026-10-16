package com.google.android.libraries.places.internal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpl extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpl(Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f74800k);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setFlags(2, 2);
            window.setDimAmount(0.6f);
        }
        ((Button) findViewById(R.id.f74740l0)).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpk
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.f78406a.dismiss();
            }
        });
    }
}
