package com.google.android.libraries.places.internal;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.ConsumerAlert;
import com.google.android.libraries.places.api.model.ConsumerAlertDetails;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpb extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f78385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConsumerAlert f78386b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpb(Context context, int i3, ConsumerAlert consumerAlert) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consumerAlert, "consumerAlert");
        this.f78385a = i3;
        this.f78386b = consumerAlert;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TextView textView, zzpb zzpbVar, View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        ConsumerAlertDetails consumerAlertDetailsD = zzpbVar.f78386b.d();
        intent.setData(consumerAlertDetailsD != null ? consumerAlertDetailsD.e() : null);
        try {
            textView.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new zzpl(context, zzpbVar.f78385a).show();
        }
    }

    private static final void c(View view, CharSequence charSequence) {
        if (charSequence == null || StringsKt.p0(charSequence)) {
            view.setVisibility(8);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        view.setVisibility(0);
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f74795f);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setFlags(2, 2);
            window.setDimAmount(0.6f);
        }
        View viewFindViewById = findViewById(R.id.E);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConsumerAlert consumerAlert = this.f78386b;
        ConsumerAlertDetails consumerAlertDetailsD = consumerAlert.d();
        c(viewFindViewById, consumerAlertDetailsD != null ? consumerAlertDetailsD.g() : null);
        View viewFindViewById2 = findViewById(R.id.C);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ConsumerAlertDetails consumerAlertDetailsD2 = consumerAlert.d();
        c(viewFindViewById2, consumerAlertDetailsD2 != null ? consumerAlertDetailsD2.f() : null);
        final TextView textView = (TextView) findViewById(R.id.D);
        Intrinsics.checkNotNull(textView);
        ConsumerAlertDetails consumerAlertDetailsD3 = consumerAlert.d();
        c(textView, consumerAlertDetailsD3 != null ? consumerAlertDetailsD3.d() : null);
        Drawable drawable = textView.getCompoundDrawablesRelative()[2];
        if (drawable != null) {
            drawable.setBounds(0, 0, textView.getLineHeight(), textView.getLineHeight());
            textView.setCompoundDrawablesRelative(null, null, drawable, null);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpa
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                zzpb.b(textView, this, view);
            }
        });
        Button button = (Button) findViewById(R.id.B);
        Intrinsics.checkNotNull(button);
        Object parent = button.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        Context context = button.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        zzop.a(button, (View) parent, context, 48, 48);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzoz
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.f78381a.dismiss();
            }
        });
    }
}
