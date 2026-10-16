package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.o;
import com.applovin.impl.t3;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GradientDrawable f61665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Button f61666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f61667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f61668d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxAdFormat f61669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f61670g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    private int a(b bVar) {
        return b.LOAD == bVar ? t3.a(R.color.applovin_sdk_brand_color, getContext()) : b.LOADING == bVar ? t3.a(R.color.applovin_sdk_brand_color, getContext()) : t3.a(R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    private String b(b bVar) {
        return b.LOAD == bVar ? "Load" : b.LOADING == bVar ? "" : "Show";
    }

    private void c(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.f61667c.a();
        } else {
            setEnabled(true);
            this.f61667c.b();
        }
        this.f61666b.setText(b(bVar));
        this.f61665a.setColor(a(bVar));
    }

    public b getControlState() {
        return this.f61668d;
    }

    public MaxAdFormat getFormat() {
        return this.f61669f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f61670g;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.f61668d != bVar) {
            c(bVar);
        }
        this.f61668d = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f61669f = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.f61670g = aVar;
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f61665a = gradientDrawable;
        Button button = new Button(getContext());
        this.f61666b = button;
        o oVar = new o(getContext(), 20, android.R.attr.progressBarStyleSmall);
        this.f61667c = oVar;
        b bVar = b.LOAD;
        this.f61668d = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        gradientDrawable.setCornerRadius(20.0f);
        button.setBackground(gradientDrawable);
        a();
        oVar.setColor(-1);
        addView(oVar, new FrameLayout.LayoutParams(-1, -1, 17));
        c(bVar);
    }

    private void a() {
        this.f61666b.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{t3.a(R.color.applovin_sdk_highlightTextColor, getContext()), -1}));
    }
}
