package com.google.android.libraries.places.internal;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.places.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpj extends Dialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Uri f78398d = Uri.parse("https://support.google.com/contributionpolicy/answer/7422880");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Uri f78399f = Uri.parse("https://support.google.com/maps/answer/3092445");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Uri f78400g = Uri.parse("https://support.google.com/maps/contact/14718793");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Uri f78401h = Uri.parse("https://policies.google.com/privacy");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Uri f78402i = Uri.parse("https://www.google.com/help/terms_maps/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f78404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f78405c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpj(Context context, int i3, List sections) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sections, "sections");
        this.f78403a = context;
        this.f78404b = i3;
        this.f78405c = sections;
    }

    private final void f() {
        TextView textView = (TextView) findViewById(R.id.s2);
        int lineHeight = textView != null ? textView.getLineHeight() : (int) this.f78403a.getResources().getDimension(R.dimen.f74675a);
        for (ImageView imageView : CollectionsKt.listOfNotNull((Object[]) new ImageView[]{(ImageView) findViewById(R.id.Y1), (ImageView) findViewById(R.id.f74711e), (ImageView) findViewById(R.id.r2), (ImageView) findViewById(R.id.f74758p2), (ImageView) findViewById(R.id.Q1)})) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.height = lineHeight;
            marginLayoutParams.width = lineHeight;
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Uri uri) {
        try {
            this.f78403a.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            new zzpl(this.f78403a, this.f78404b).show();
        }
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f74799j);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setFlags(2, 2);
            window.setDimAmount(0.6f);
        }
        setTitle(R.string.Y0);
        f();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.X1);
        if (linearLayout != null) {
            zzop.b(linearLayout);
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzph
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f78392a.g(zzpj.f78398d);
                }
            });
        }
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f74707d);
        if (linearLayout2 != null) {
            zzop.b(linearLayout2);
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpc
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f78387a.g(zzpj.f78399f);
                }
            });
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.f74762q2);
        if (linearLayout3 != null) {
            zzop.b(linearLayout3);
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpd
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f78388a.g(zzpj.f78402i);
                }
            });
        }
        LinearLayout linearLayout4 = (LinearLayout) findViewById(R.id.f74754o2);
        if (linearLayout4 != null) {
            zzop.b(linearLayout4);
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpe
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f78389a.g(zzpj.f78401h);
                }
            });
        }
        LinearLayout linearLayout5 = (LinearLayout) findViewById(R.id.P1);
        if (linearLayout5 != null) {
            zzop.b(linearLayout5);
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpf
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f78390a.g(zzpj.f78400g);
                }
            });
        }
        ((Button) findViewById(R.id.f74700b0)).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.internal.zzpg
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.f78391a.dismiss();
            }
        });
        for (zzpi zzpiVar : this.f78405c) {
            zzpi zzpiVar2 = zzpi.f78393a;
            int iOrdinal = zzpiVar.ordinal();
            if (iOrdinal == 0) {
                LinearLayout linearLayout6 = (LinearLayout) findViewById(R.id.W1);
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
            } else if (iOrdinal == 1) {
                LinearLayout linearLayout7 = (LinearLayout) findViewById(R.id.f74703c);
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
            } else if (iOrdinal == 2) {
                LinearLayout linearLayout8 = (LinearLayout) findViewById(R.id.U1);
                if (linearLayout8 != null) {
                    linearLayout8.setVisibility(0);
                }
            } else {
                if (iOrdinal != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                LinearLayout linearLayout9 = (LinearLayout) findViewById(R.id.O1);
                if (linearLayout9 != null) {
                    linearLayout9.setVisibility(0);
                }
            }
        }
    }
}
