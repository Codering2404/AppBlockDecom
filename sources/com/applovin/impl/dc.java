package com.applovin.impl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class dc extends BaseAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f59200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f59201b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f59202c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f59203d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(kb kbVar, cc ccVar);
    }

    protected dc(Context context) {
        this.f59200a = context.getApplicationContext();
    }

    protected cc a() {
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    protected abstract int b();

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cc getItem(int i3) {
        return (cc) this.f59201b.get(i3);
    }

    protected abstract List c(int i3);

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.su
            @Override // java.lang.Runnable
            public final void run() {
                this.f63834a.notifyDataSetChanged();
            }
        });
    }

    protected abstract int d(int i3);

    protected abstract cc e(int i3);

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f59201b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return getItem(i3).m();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        bc bcVar;
        cc item = getItem(i3);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(item.j(), viewGroup, false);
            bcVar = new bc();
            bcVar.f58631a = (TextView) view.findViewById(R.id.text1);
            bcVar.f58632b = (TextView) view.findViewById(R.id.text2);
            bcVar.f58633c = (ImageView) view.findViewById(com.applovin.sdk.R.id.imageView);
            bcVar.f58634d = (ImageView) view.findViewById(com.applovin.sdk.R.id.detailImageView);
            view.setTag(bcVar);
            view.setOnClickListener(this);
            view.setBackground(a(view));
        } else {
            bcVar = (bc) view.getTag();
        }
        bcVar.a(i3);
        bcVar.a(item);
        view.setEnabled(item.o());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cc.n();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        return getItem(i3).o();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i3;
        this.f59201b = new ArrayList();
        int iB = b();
        this.f59202c = new HashMap(iB);
        cc ccVarA = a();
        if (ccVarA != null) {
            this.f59201b.add(ccVarA);
            i3 = 1;
        } else {
            i3 = 0;
        }
        for (int i4 = 0; i4 < iB; i4++) {
            int iD = d(i4);
            if (iD != 0) {
                this.f59201b.add(e(i4));
                this.f59201b.addAll(c(i4));
                this.f59202c.put(Integer.valueOf(i4), Integer.valueOf(i3));
                i3 += iD + 1;
            }
        }
        this.f59201b.add(new fj(""));
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bc bcVar = (bc) view.getTag();
        cc ccVarB = bcVar.b();
        kb kbVarA = a(bcVar.a());
        a aVar = this.f59203d;
        if (aVar == null || kbVarA == null) {
            return;
        }
        aVar.a(kbVarA, ccVarB);
    }

    private Drawable a(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(t3.a(com.applovin.sdk.R.color.applovin_sdk_highlightListItemColor, this.f59200a));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }

    private kb a(int i3) {
        for (int i4 = 0; i4 < b(); i4++) {
            Integer num = (Integer) this.f59202c.get(Integer.valueOf(i4));
            if (num != null) {
                if (i3 <= num.intValue() + d(i4)) {
                    return new kb(i4, i3 - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.f59203d = aVar;
    }
}
